package untitled10.Locomotive;

public abstract class Locomotive {

    private static int counter = -1;
    protected int id;
    private int power;
    private final String name;

    public Locomotive(String name, int power){
        counter++;
        id = counter;
        this.name = name;
        this.power = power;
    }

    public abstract boolean pull () throws Exception;
    public abstract void powerConsumption();
    public abstract void connectThePowerSupply();
    public int getPower(){
        return power;
    }

    public String getName() {
        return name;
    }
}


