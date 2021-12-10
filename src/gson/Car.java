package gson;
public class Car implements ICar
{
    private int carNum;

    public Car(int carNum)
    {
        this.carNum = carNum;
    }

    @Override
    public int getCarNumber()
    {
        return this.carNum;
    }

    @Override
    public String toString()
    {
        return "Car Number: " + carNum;
    }


}
