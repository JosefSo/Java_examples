// Java program to illustrate HashMap class of java.util
// package

// Importing HashMap class
import java.util.HashMap;


public class Hash_map_example {
    // Main driver method
    public static void main(String[] args)
    {
        // Create an empty hash map by declaring object
        // of string and integer type
        HashMap<String, Integer> map = new HashMap<>();

        // Adding elements to the Map
        // using standard add() method
        map.put("vishal", 10);
        map.put("sachin", 30);
        map.put("vaibhav", 20);
        map.put("1", 200);

        int c = 1;

        System.out.println(map.get(Integer.toString(c)));

        // Print size and content of the Map
        System.out.println("Size of map is:- "
                + map.size());

        // Printing elements in object of Map
        System.out.println(map);

        // Checking if a key is present and if
        // present, print value by passing
        // random element
        if (map.containsKey("vishal")) {

            // Mapping
            Integer a = map.get("vishal");

            Integer b = map.get("visha");

            // Printing value fr the corresponding key
            System.out.println("value for key"
                    + " \"vishal\" is:- " + a);

            System.out.println("value for key"
                    + " \"visha\" is:- " + b);
        }
    }
}
