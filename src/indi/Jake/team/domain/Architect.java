package indi.Jake.team.domain;

/**
 * @ClassName Architect
 * @Description
 * @Author Jake
 * @Date 2021/1/27 17:06
 * @Version
 */
public class Architect extends Designer{
    private int stock;

    public Architect(int id, String name, int age, double salary, Equipment equipment, double bonus, int stock) {
        super(id, name, age, salary, equipment, bonus);
        this.stock = stock;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
    public String getDetailsForTeam(){
        return getMemberDetails()+"\t架构师\t"+getBonus()+"\t"+getStock();
    }

    public String toString() {
        return getDetails()+"\t架构师\t"+getStatus()+"\t"+getBonus()+"\t"+getStock()+"\t"+getEquipment().getDescription();
    }
}
