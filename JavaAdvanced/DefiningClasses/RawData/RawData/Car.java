package DefiningClasses.RawData;

public class Car {
    private String model;
    private int engineSpeed;
    private int enginePower;
    private int cargoWeight;
    private String cargoType;
    private double tireOnePressure;
    private int tireOneAge;
    private double tireTwoPressure;
    private int tireTwoAge;
    private double tireThreePressure;
    private int tireThreeAge;
    private double tireFourPressure;
    private int tireFourAge;


    public Car(String model, int engineSpeed, int enginePower, int cargoWeight, String cargoType,
               double tireOnePressure, int tireOneAge, double tireTwoPressure, int tireTwoAge,
               double tireThreePressure, int tireThreeAge, double tireFourPressure, int tireFourAge) {
        this.model = model;
        this.engineSpeed = engineSpeed;
        this.enginePower = enginePower;
        this.cargoWeight = cargoWeight;
        this.cargoType = cargoType;
        this.tireOnePressure = tireOnePressure;
        this.tireOneAge = tireOneAge;
        this.tireTwoPressure = tireTwoPressure;
        this.tireTwoAge = tireTwoAge;
        this.tireThreePressure = tireThreePressure;
        this.tireThreeAge = tireThreeAge;
        this.tireFourPressure = tireFourPressure;
        this.tireFourAge = tireFourAge;
    }

    public String getCargoType() { return this.cargoType; }

    public double getTireOnePressure() { return this.tireOnePressure; }

    public double getTireTwoPressure() { return this.tireTwoPressure; }

    public double getTireThreePressure() { return this.tireThreePressure; }

    public double getTireFourPressure() { return this.tireFourPressure; }

    public int getEnginePower() { return this.enginePower; }

    public String getModel() { return this.model; }
}
