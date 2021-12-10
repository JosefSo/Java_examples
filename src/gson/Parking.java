package gson;
import java.util.HashMap;

public class Parking
{
    private String parkingName;
    private HashMap<Integer, ICar> cars = new HashMap<Integer, ICar>();

    public Parking(String parkingName)
    {
        this.parkingName = parkingName;
    }

    public void add(ICar car)
    {
        this.cars.put(car.getCarNumber(), car);
    }

    @Override
    public String toString()
    {
        String str = this.parkingName + "\n";

        for (ICar car : cars.values())
        {
            str += car+"\n";
        }

        return str;
    }
}
