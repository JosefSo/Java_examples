package gson;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Main
{

    public static void main(String[] args)
    {
//		serialize();
        deserialize();
    }

    private static void serialize()
    {
        Parking parking = new Parking("Ariel University Parking");
        parking.add(new Car(111));
        parking.add(new Car(222));

        //Make JSON!!
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(parking);
        System.out.println(json);

        //Write JSON to file
        try
        {
            PrintWriter pw = new PrintWriter(new File("parking.json"));
            pw.write(json);
            pw.close();
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
            return;
        }
    }

    private static void deserialize()
    {
        try
        {
            GsonBuilder builder = new GsonBuilder();
            builder.registerTypeAdapter(Parking.class, new ParkingJsonDeserializer());
            Gson gson = builder.create();
            //continue as usual..

            FileReader reader = new FileReader("parking.json");
            Parking parking = gson.fromJson(reader, Parking.class);
            System.out.println(parking);
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}


