package dataReader;

import com.jayway.jsonpath.JsonPath;
import logs.LogsManager;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;

public class JsonReader {

    String jsonReader;
    String jsonFileName;
    private final String TEST_PATH = "src/test/resources/test-data/";

    public JsonReader (String jsonFileName) {
        this.jsonFileName = jsonFileName;
        try {
            JSONObject data = (JSONObject) new JSONParser().parse(new FileReader(TEST_PATH + jsonFileName +".json"));
            jsonReader = data.toJSONString();
        } catch (Exception e) {
            LogsManager.error(" Error Loading Json Files");
        }
    }

    public String getJsonData(String jsonPath) {
        try {
            return JsonPath.read(jsonReader,jsonPath);
        } catch (Exception e) {
            LogsManager.error(" Error Loading Json Files");
            return "";
        }
    }
}
