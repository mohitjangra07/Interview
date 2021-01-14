package test.app.utils;


import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import test.app.model.BaseConfig;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class JSONData {

    public static BaseConfig baseConfig() {
        Gson gson = new Gson();
        JsonReader reader = null;
        try {
            reader = new JsonReader(new FileReader("src/test/resources/Config/baseConfig.json"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return gson.fromJson(reader, BaseConfig.class);
    }


}
