import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Scanner;

public class GroubById {
    public static String groupById(int groupId) throws IOException {
        String group = "https://api.vk.com/method/groups.getById?v=5.52&group_id="+groupId+"&fields=activity&description&access_token=";
        URL url = new URL(group);
        Scanner sc = new Scanner((InputStream) url.getContent());
        String result = "";
        while(sc.hasNext()){
            result+=sc.nextLine();
        }
        JSONObject object = new JSONObject(result);
        JSONArray array = object.getJSONArray("response");
        JSONObject info = array.getJSONObject(0);
        String name = info.get("name").toString();
        if(name.contains("delete")){
            return "delete";
        }
        String activity = "";
        try{
            activity = info.get("activity").toString();
        }
        catch(Exception e){
        }
        System.out.println(activity);
        return activity;
    }
}
