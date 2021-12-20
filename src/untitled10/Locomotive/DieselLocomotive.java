package untitled10.Locomotive;
import untitled12.Exceptions.NotEnoughFuelInTankException;

public class DieselLocomotive extends Locomotive {
    private int tankCapacity;
    private int fuelInTheTank;
    private int fuelConsumption;
    public DieselLocomotive(String name, int power ,int tankCapacity, int fuelConsumption) {
        super(name, power);
        this.tankCapacity = tankCapacity;
        this.fuelConsumption = fuelConsumption;
    }

    @Override
    public boolean pull() throws Exception {
        if(fuelInTheTank >= tankCapacity) {
            System.out.println("The locomotive is ok");
            return true;
        }
        else{
            throw new NotEnoughFuelInTankException(getName());
        }
    }

    @Override
    public void connectThePowerSupply() {
        refuel(fuelConsumption - fuelInTheTank);
    }

    @Override
    public void powerConsumption() {
        fuelInTheTank -= fuelConsumption;
        System.out.println(fuelConsumption + " liters of fuel was burned");
    }

    void refuel(int quantityOfFuel){
        if(fuelInTheTank + quantityOfFuel > tankCapacity)
        {
            fuelInTheTank = tankCapacity;
        }
        else {
            tankCapacity += quantityOfFuel;
        }
    }



}