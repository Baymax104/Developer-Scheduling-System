package indi.Jake.team.service;

import indi.Jake.team.domain.*;

/**
 * @ClassName NameListService
 * @Description
 * @Author Jake
 * @Date 2021/1/27 17:12
 * @Version
 */
public class NameListService {
    private Employee[] employees;

    public NameListService(){
        employees=new Employee[Data.EMPLOYEES.length];
        for (int i = 0; i < employees.length; i++) {
            //获取原数组中每项的数据
            int type=Integer.parseInt(Data.EMPLOYEES[i][0]);
            int id=Integer.parseInt(Data.EMPLOYEES[i][1]);
            String name=Data.EMPLOYEES[i][2];
            int age=Integer.parseInt(Data.EMPLOYEES[i][3]);
            double salary=Double.parseDouble(Data.EMPLOYEES[i][4]);
            Equipment equipment;
            double bonus;
            int stock;
            //根据type赋值
            switch(type){
                case Data.EMPLOYEE:
                    employees[i]=new Employee(id,name,age,salary);
                    break;
                case Data.PROGRAMMER:
                    equipment=createEquipment(i);
                    employees[i]=new Programmer(id,name,age,salary,equipment);
                    break;
                case Data.DESIGNER:
                    equipment=createEquipment(i);
                    bonus= Double.parseDouble(Data.EMPLOYEES[i][5]);
                    employees[i]=new Designer(id,name,age,salary,equipment,bonus);
                    break;
                case Data.ARCHITECT:
                    equipment=createEquipment(i);
                    bonus=Double.parseDouble(Data.EMPLOYEES[i][5]);
                    stock= Integer.parseInt(Data.EMPLOYEES[i][6]);
                    employees[i]=new Architect(id,name,age,salary,equipment,bonus,stock);
                    break;
                default:
                    break;
            }
        }
    }

    private Equipment createEquipment(int i){
        int type=Integer.parseInt(Data.EQUIPMENTS[i][0]);
        switch(type){
            case Data.PC:
                return new PC(Data.EQUIPMENTS[i][1],Data.EQUIPMENTS[i][2]);
            case Data.NOTEBOOK:
                double price=Double.parseDouble(Data.EQUIPMENTS[i][2]);
                return new NoteBook(Data.EQUIPMENTS[i][1],price);
            case Data.PRINTER:
                return new Printer(Data.EQUIPMENTS[i][1],Data.EQUIPMENTS[i][2]);
        }
        return null;
    }

    public Employee[] getAllEmployees(){
        return employees;
    }

    public Employee getEmployee(int id)throws TeamException{
        for (Employee e :
                employees) {
            if(e.getId()==id)
                return e;
        }
        throw new TeamException("员工不存在!");
    }
}
