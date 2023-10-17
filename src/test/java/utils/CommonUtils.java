package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class CommonUtils {

    public final static String configFilePath= System.getProperty("user.dir")+"/config.properties";
    public static String getConfigProperty(String configKey) throws IOException {

        Properties prop = new Properties();
        InputStream input = new FileInputStream(configFilePath);
        prop.load(input);
        String configValue = prop.getProperty(configKey);

        return configValue;

    }
}
