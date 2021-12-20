package untitled11.Employe;

public class Electrician extends Employee{
    private static Positions position = Positions.electrician;

    public Electrician(String name, double salary) {
        super(name, position, salary);
    }

    public void monitoringTheElectricalEquipment(String locomotiveName) {
        //monitor the serviceability of traffic lights and other equipment.
    }

}