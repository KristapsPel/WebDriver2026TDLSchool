package utils;

import java.io.*;
import java.util.Properties;

public class ConfigFileReader {
    private Properties properties;
    private final String propertyFilePath = "src" + File.separator +
            "test" + File.separator + "resources" + File.separator + "configFiles"+ File.separator;
    private String configFileName;

    public ConfigFileReader(String configFileName) {
        this.configFileName = configFileName;
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(propertyFilePath + configFileName));
            properties = new Properties();
            try {
                properties.load(reader);
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
        }
    }

    public String getBrowser(){
        String browser = properties.getProperty("browser");
        if(browser != null) {
            return browser;
        } else {
            throw new RuntimeException("browser not specified in the "+configFileName+ " file.");
        }
    }
    public String getUrl(){
        String url = properties.getProperty("url");
        if(url != null) {
            return url;
        } else {
            throw new RuntimeException("URL not specified in the "+configFileName+ " file.");
        }
    }
    public String getValueFromProperties(String key){
        String item = properties.getProperty(key);
        if(item != null) {
            return item;
        } else {
            throw new RuntimeException(key+" not specified in the "+configFileName+ " file.");
        }
    }
}
