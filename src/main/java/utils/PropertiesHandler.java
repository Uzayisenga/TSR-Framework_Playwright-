package utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class PropertiesHandler {
    static String strConfPath = "src/main/java/com/lh/core/config/config.properties";

    public PropertiesHandler() {
    }

    public static void setConfigPath(String value) {
        strConfPath = value;
    }

    private static String getProperty(String strPropertyName) {
        String result = null;
        Properties prop = new Properties();

        try {
            prop.load(new FileInputStream(strConfPath));
            result = prop.getProperty(strPropertyName);
        } catch (Exception var4) {
            System.out.println("unable to find specified properties file");
            var4.printStackTrace();
        }

        return result;
    }

    public static String getLogsFolder() {
        String path = getProperty("path_logfiles");
        File fileToZip = new File(path);
        if (!fileToZip.exists()) {
            fileToZip.mkdir();
        }
        return path;
    }

    public static String getHtmlReportsFolder() {
        return getProperty("path_report_html");
    }

    public static String getZipReportsFolder() {
        String path = getProperty("path_report_zip");
        File fileToZip = new File(path);
        if (!fileToZip.exists()) {
            fileToZip.mkdir();
        }

        return path;
    }
    public static String getLogPropertyFile() {
        String path = getProperty("path_logPropertiesFile");

        return path;
    }
    public static String getDBUrl() {
        String path = getProperty("DB_url");

        return path;
    }
    public static String getDBUserName() {
        String path = getProperty("DB_userName");

        return path;
    }
    public static String getDBPassword() {
        String path = getProperty("DB_password");

        return path;
    }

    public static boolean isLoggerActivated() {
        return getProperty("logger").toLowerCase().contains("y");
    }

}