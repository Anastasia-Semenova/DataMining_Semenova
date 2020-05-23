import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class MyThemes {
    public static void myTheme(int myId) throws IOException {
        String group = "https://api.vk.com/method/groups.get?v=5.52&group_id="+myId+"&fields=activity&description&access_token=";
        URL url = new URL(group);
        Scanner sc = new Scanner((InputStream) url.getContent());
        String result = "";
        while(sc.hasNext()){
            result+=sc.nextLine();
        }
        JSONObject object = new JSONObject(result);
        JSONObject object1 = object.getJSONObject("response");
        JSONArray array = object1.getJSONArray("response");
        try{
            String id = array.get("id").toString();
        }
        catch(Exception e){
        }

    }
}
