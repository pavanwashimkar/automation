package com.automationCore.commonFuntionality;



import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class EnvironmentConfig {

       public Properties prop = new Properties();
       private InputStream inputStream = null;
       private Map<String,String> propMap = new HashMap<>();

       public Map<String,String> readEnvFile(String fileName) throws IOException {
           try {
               inputStream = new FileInputStream(fileName);
               prop.load(inputStream);
               for (Map.Entry<Object, Object> entry : prop.entrySet()) {
                   propMap.put(entry.getKey().toString(), entry.getValue().toString());
               }
           } catch (IOException e) {
               e.printStackTrace();
           } finally {
               if (inputStream != null) {
                   try {
                       inputStream.close();
                   } catch (IOException e) {
                       e.printStackTrace();
                   }
               }
           }
           return propMap;
       }

}
