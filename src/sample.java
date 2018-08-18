import org.json.JSONObject;

public class sample {

    public static void main(String[] args) {
        JSONObject obj = new JSONObject();
        obj.put("name", "Taro Tanaka");
        obj.put("age", 30);
        System.out.println(obj);
    }

}
