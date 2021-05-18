package indi.Jake.team.service;

import indi.Jake.team.domain.*;

/**
 * @ClassName TeamService
 * @Description
 * @Author Jake
 * @Date 2021/1/27 17:45
 * @Version
 */
public class TeamService {
    private static int count=1;
    private final int MAX_MEMBER=5;
    private Programmer[] team=new Programmer[MAX_MEMBER];
    private int totalCurrent=0;

    public TeamService() {
    }

    public Programmer[] getTeam(){
        Programmer[] totalTeam=new Programmer[totalCurrent];
        for (int i = 0; i < totalCurrent; i++) {
            totalTeam[i]=team[i];
        }
        return totalTeam;
    }

    public void addMember(Employee e)throws TeamException{
        if(totalCurrent>=MAX_MEMBER)
            throw new TeamException("成员已满，无法添加!");
        if(!(e instanceof Programmer))
            throw new TeamException("该员工不是开发人员，无法添加!");
        //判断员工状态
        Programmer p=(Programmer) e;
        if(isExist(p))
            throw new TeamException("该员工已加入本团队，不可重复添加!");
        if(p.getStatus().getNAME().equals("BUSY"))
            throw new TeamException("该员工已加入某团队，无法添加!");
        if(p.getStatus().getNAME().equals("VACATION"))
            throw new TeamException("该员工正在休假，无法添加!");
        //团队人员限制
        int numOfArchitect=0;
        int numOfDesigner=0;
        int numOfProgrammer=0;
        //获取当前团队人员类型
        for (int i = 0; i < totalCurrent; i++) {
            if(team[i] instanceof Programmer)
                numOfProgrammer++;
            else if(team[i] instanceof Designer)
                numOfDesigner++;
            else if(team[i] instanceof Architect)
                numOfArchitect++;
        }
        if(p instanceof Programmer&&numOfProgrammer>=3)
            throw new TeamException("团队中至多有三名程序员");
        else if(p instanceof Designer&&numOfDesigner>=2)
            throw new TeamException("团队中至多有两名设计师");
        else if(p instanceof Architect&&numOfArchitect>=3)
            throw new TeamException("团队中至多有一名架构师");
        //添加成员
        p.setStatus(Status.BUSY);
        p.setMemberId(count);
        count++;
        team[totalCurrent]=p;
        totalCurrent++;
    }

    private boolean isExist(Programmer p){
        for (int i = 0; i < totalCurrent; i++) {
            if(team[i].getId()== p.getId())
                return true;
        }
        return false;
    }

    public void deleteMember(int memberId)throws TeamException{
        int i;
        for (i = 0; i < totalCurrent; i++) {
            if(team[i].getMemberId()==memberId){
                team[i].setStatus(Status.FREE);
                break;
            }
        }
        if(i==totalCurrent)
            throw new TeamException("该员工不存在，删除失败!");
        //删除成员
        for (int j=i+1;j<totalCurrent;j++) {
            team[j-1]=team[j];
        }
        team[--totalCurrent]=null;
    }
}
