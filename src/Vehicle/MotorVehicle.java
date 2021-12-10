package Vehicle;

import java.io.IOError;

/**@author simon pikalov
 * This class represents a motor vehicle
 A motor vehicle, also known as motorized vehicle or automotive vehicle,
 is a self-propelled vehicle, commonly wheeled,
 that does not operate on rails (such as trains or trams) and is used for the transportation of people or cargo.
 https://en.wikipedia.org/wiki/Motor_vehicle
 */
public abstract class MotorVehicle {

    private String manufacturer;
    private String model;
    private String registrationPlate;
    private double weight; // in kilograms
    private int maxSpeed;
    private int seats;
    private Engine engine=new Engine();


    public MotorVehicle(String manufacturer, String model, String registrationPlate, int weight,int maxSpeed,int seats) {
        if(seats< 0) throw new RuntimeException("seats must be positive number , you used  "+seats);
        if(weight< 0) throw new RuntimeException("weight must be positive number , you used  "+weight);
        if(maxSpeed< 0) throw new RuntimeException("maxSpeed must be positive number , you used  "+maxSpeed);
        this.maxSpeed = maxSpeed;
        this.manufacturer = manufacturer;
        this.model = model;
        this.registrationPlate = registrationPlate;
        this.weight = weight;

    }

    public String getEngineName() {
        return engine.engineName;
    }

    public void setEngineName(String engineName) {
        this.engine.engineName = engineName;
    }

    public String getId() {
        return engine.id;
    }

    public void setEngineId(String id) {
        this.engine.id = id;

    }

    public class Engine implements java.io.Serializable {
        public String engineName;
        public String id;


        public Engine() {

            this.engineName = "";
            this.id = "";
        }

        public Engine(String engineName, String id) {
            this.engineName = engineName;
            this.id = id;
        }



        public String getEngineName() {
            return engineName;
        }

        public void setEngineName(String engineName) {
            this.engineName = engineName;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        @Override
        public String toString() {
            return "Engine{" +
                    ", engineName='" + engineName + '\'' +
                    ", id='" + id + '\'' +
                    '}';
        }
    }


    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getRegistrationPlate() {
        return registrationPlate;
    }

    public void setRegistrationPlate(String registrationPlate) {
        this.registrationPlate = registrationPlate;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }


    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }


    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    @Override
    public String toString() {
        return "Vehicle.MotorVehicle{" +
                "manufacturer='" + manufacturer + '\'' +
                ", model='" + model + '\'' +
                ", registrationPlate='" + registrationPlate + '\'' +
                ", weight=" + weight +
                ", maxSpeed=" + maxSpeed +
                ", seats=" + seats +
                '}';
    }

    public static void main(String[] args) {
try {

    MotorVehicle kiaPicanto = new Car("Kia", "Picanto", "409-94-301", 959, 173, 3);
    System.out.println("yayyyy");
}catch (IOError     e){
    e.printStackTrace();
    System.out.println("erro");
}finally {
    System.out.println("finally");
}
        System.out.println("this is my code end");

    }

}
