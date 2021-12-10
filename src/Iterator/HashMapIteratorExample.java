package Iterator;
import java.util.HashMap;
import java.util.Set;
import java.util.Iterator;
import java.util.Map;

public class HashMapIteratorExample {

    public static void main(String[] args) {

        // Creating a HashMap of int keys and String values
        HashMap<Integer, String> hashmap = new HashMap<Integer, String>();

        // Adding Key and Value pairs to HashMap
        hashmap.put(11,"Value1");
        hashmap.put(22,"Value2");
        hashmap.put(33,"Value3");
        hashmap.put(44,"Value4");
        hashmap.put(55,"Value5");

        // Getting a Set of Key-value pairs
        Set entrySet = hashmap.entrySet();

        // Obtaining an iterator for the entry set
        Iterator it = entrySet.iterator();

        // Iterate through HashMap entries(Key-Value pairs)
        System.out.println("HashMap Key-Value Pairs : ");
        while(it.hasNext()){
            Map.Entry me = (Map.Entry)it.next();
            System.out.println("Key is: "+me.getKey() +
                    " & " +
                    " value is: "+me.getValue());
        }
    }
}
