package untitled10.Locomotive;
import untitled11.Employe.Electrician;

public class ElectricLocomotive extends Locomotive {

    public ElectricLocomotive(String name, int power) {
        super(name, power);
    }

    @Override
    public void connectThePowerSupply() {
        Electrician electrician = new Electrician("Dmitry", 20000.0);
        electrician.monitoringTheElectricalEquipment(getName());
    };

    @Override
    public boolean pull() {
        System.out.println("The locomotive pulls");
        return true;
    }

    @Override
    public void powerConsumption() {
        System.out.println("A lot of electricity is used");
    }
}
