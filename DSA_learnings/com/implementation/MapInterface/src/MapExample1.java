import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapExample1 {
    public static void main(String[] args) {
        Map<String,String> map = new HashMap<>();
        map.put("key1","val1");
        map.put("key2","val2");
        map.put("key3","val3");
        System.out.println(map);
        Set<String> keys = map.keySet();
        System.out.println(map.containsKey("key2"));
        System.out.println(map.containsValue("val9"));

        keys.forEach((n)->{
            System.out.println(n+" "+map.get(n));
        });

        System.out.println("Difference between put and replace: ");
        map.put("key3","updatedValue");//adds key if doesn't exists and updates value if key already exists
        System.out.println(map);
        map.replace("key4","val4");//doesn't add if key doesn't exist
        System.out.println(map);
        System.out.println("Using putIfAbsent");
        map.putIfAbsent("key3","val3");
        System.out.println(map);
        map.putIfAbsent("key4","val4");
        System.out.println(map);
        System.out.println("Using remove");
        map.remove(("key3"));
        System.out.println(map);

    }


}
