import java.util.Hashtable;
import java.util.Map;
import java.util.Set;

public class MapExample2 {
    public static void main(String[] args) {
        Map<String,String> map = new Hashtable<>();
        map.put("key1","val1");
        map.put("key2","val2");
        map.put("key3","val3");
        Set<String> s = map.keySet();
        s.forEach((key)-> System.out.println(key+" "+map.get(key)));


        System.out.println("Using Entry");
        Set<Map.Entry<String,String>> values = map.entrySet();
        values.forEach(
                (n)-> System.out.println(n.getKey()+" "+n.getValue())
        );
    }
}