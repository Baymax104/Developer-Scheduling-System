package indi.Jake.team.view;

import indi.Jake.team.domain.Employee;
import indi.Jake.team.domain.Programmer;
import indi.Jake.team.service.*;

/**
 * @ClassName TeamView
 * @Description
 * @Author Jake
 * @Date 2021/1/27 18:28
 * @Version
 */
public class TeamView {
    NameListService nameListService=new NameListService();
    TeamService teamService=new TeamService();
    public static void main(String[] args) {
        TeamView teamView=new TeamView();
        teamView.enterMenu();
    }

    public void enterMenu(){
        boolean flag=true;
        char key=0;
        do{
            if(key!='1')
                listAllEmployees();
            System.out.print("1-团队列表  2-添加团队成员  3-删除团队成员 4-退出   请选择(1-4):");
            key=TSUtility.readMenuSelection();
            switch(key){
                case '1':
                    listTeam();
                    break;
                case '2':
                    addMember();
                    break;
                case '3':
                    deleteMember();
                    break;
                case '4':
                    System.out.print("确认是否退出(Y/N):");
                    char yn=TSUtility.readConfirmSelection();
                    if(yn=='Y') {
                        flag=false;
                        System.out.println("Goodbye!");
                    }
                    break;
                default:
                    break;
            }

        }while(flag);
    }

    private void listAllEmployees(){
        System.out.println("\n-------------------------------开发团队调度软件--------------------------------\n");
        Employee[] employees=nameListService.getAllEmployees();
        if(employees.length==0)
            System.out.println("没有员工记录!");
        else
            System.out.println("ID  姓名  年龄  工资  职位  状态  奖金  股票  领用设备");
        for (Employee e : employees) {
            System.out.println(e.toString());
        }
        System.out.println("-------------------------------------------------------------------------------");
    }

    private void listTeam(){
        System.out.println("\n--------------------团队成员列表---------------------\n");
        Programmer[] programmer=teamService.getTeam();
        if(programmer.length==0)
            System.out.println("该团队没有任何成员!");
        else
            System.out.println("TID/ID\t姓名\t年龄\t工资\t职位\t奖金\t股票");
        for (Programmer p : programmer) {
            System.out.println(p.getDetailsForTeam());
        }
        System.out.println("-----------------------------------------------------");
    }

    private void addMember(){
        System.out.println("---------------------添加成员---------------------");
        System.out.print("请输入要添加的员工ID:");
        int id=TSUtility.readInt();
        try {
            Employee employee=nameListService.getEmployee(id);
            teamService.addMember(employee);
            System.out.println("添加成功!");
        } catch (TeamException e) {
            System.out.println("添加失败,原因为:"+e.getMessage());
        }
        TSUtility.readReturn();
    }

    private void deleteMember(){
        System.out.println("---------------------删除成员---------------------");
        System.out.print("请输入要删除的员工TID:");
        int memberId= TSUtility.readInt();
        System.out.print("确认是否删除:(Y/N):");
        char yn=TSUtility.readConfirmSelection();
        if(yn!='Y')
            return;
        else{
            try {
                teamService.deleteMember(memberId);
                System.out.println("删除成功!");
            } catch (TeamException e) {
                System.out.println("删除失败,原因为:"+e.getMessage());
            }
        }
        TSUtility.readReturn();
    }
}
