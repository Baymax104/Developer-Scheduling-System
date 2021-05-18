package indi.Jake.team.domain;

/**
 * @ClassName Designer
 * @Description
 * @Author Jake
 * @Date 2021/1/27 17:00
 * @Version
 */
public class Designer extends Programmer{
    private double bonus;

    public Designer(int id, String name, int age, double salary, Equipment equipment, double bonus) {
        super(id, name, age, salary, equipment);
        this.bonus = bonus;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    public String getDetailsForTeam(){
        return getMemberDetails()+"\t设计师\t"+getBonus();
    }
     public String toString(){
        return getDetails()+"\t设计师\t"+getStatus()+"\t"+getBonus()+"\t\t"+getEquipment().getDescription();
     }
}
