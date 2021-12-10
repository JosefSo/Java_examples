package gson;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

import Vehicle.MotorVehicle;
import com.google.gson.*;

public class ParkingJsonDeserializer implements JsonDeserializer<Parking>
{

    @Override
    public Parking deserialize(JsonElement json, Type arg1, JsonDeserializationContext arg2) throws JsonParseException
    {
        JsonObject jsonObject = json.getAsJsonObject();
        String parkingName = jsonObject.get("parkingName").getAsString();
        Parking parking = new Parking(parkingName);

        JsonObject carsJsonObj = jsonObject.get("cars").getAsJsonObject();

        for (Entry<String, JsonElement> set : carsJsonObj.entrySet())
        {
            String hashKey = set.getKey(); //the key of the hashmap
            JsonElement jsonValueElement = set.getValue(); //the value of the hashmap as json element
            int carNum = jsonValueElement.getAsJsonObject().get("carNum").getAsInt();
            Car car = new Car(carNum);
            parking.add(car);
        }


        return parking;
    }

}
