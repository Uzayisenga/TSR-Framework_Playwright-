package utilities;

public class Configurations {
    public static final String ExecutionEnvnmt = System.getProperty("env"); // Valid values: QA, STAGE, PROD

    // public static final String ExecutionEnvnmt = "QA";

    //Report Config Parameter
    public static final String ProjectName = "PPL"; //PPL, PPL Status, PPL Green, PPL TravelCockpit, PPL TouchPoint
    public static final String ReleaseName = "Regression"; //Smoke, Sanity, Regression, GoLive
    public static final String Component = "Login"; // Profile, Login, CO2 Compensation, SEN FTL Cash
    public static final String BrowserName = "Chrome";

    // QA Application URL
    public final static String AppurlLoad = "https://www.lufthansa.com/de/en/homepage";
    public final static String Appurl_QA_LH_De = "https://rwanda.testsolutions.de/";
    public final static String YopMail = "https://yopmail.com/en/";

}
