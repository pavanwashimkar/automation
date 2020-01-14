package com.automationCore.commonFuntionality;


import com.fasterxml.jackson.databind.JsonNode;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.IOUtils;
import org.apache.log4j.lf5.util.Resource;
import org.json.JSONException;
import org.json.JSONObject;


import java.io.IOException;

public class JsonFileReader {
    public static final JSONObject RESPONCE_JSON_OBJECT = null;

    public static JSONObject reader(String filepath) throws JSONException, IOException {

        Resource resource = new Resource(filepath);
        System.out.println("Debugger :: " + resource.getClass().getResourceAsStream(filepath));
        String content = IOUtils.toString(resource.getClass().getResourceAsStream(filepath));
        ObjectMapper objectMapper = new ObjectMapper() ;
            JsonNode bodyObj = null;

            try {
            bodyObj = objectMapper.readTree(content);
        } catch (IOException e) {
                e.printStackTrace();
            }

            JSONObject RESPONSE_JSON_OBJECT = new JSONObject(content);
            return RESPONSE_JSON_OBJECT;
    }
}
