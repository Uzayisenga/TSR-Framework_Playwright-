package connectionHandler;

import connection.DBConnection;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DBHandler {
    public static long startTime;
    public static String currentStep;
    private static String status;
    private static String fileName;
    public static String tenantName;

    public static void startTime() {
        startTime = System.currentTimeMillis();
    }

    /**
     * TO log launch steps
     **/
//    public static void logStep( String TC_Name, String currentStep, String status) {
//        double timeTaken = (System.currentTimeMillis() - startTime) / 1000.0;
//        startTime = System.currentTimeMillis();
//        String file_name = fileName;
//
//
//        try {
//            DBConnection.InsertData( TC_Name, currentStep, status, timeTaken, getCurrentTimestamp());
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//    }

    /**
     * TO log other steps
     **/
    public static void logStep(String TC_Name, String currentStep, String status) {
        double timeTaken = (System.currentTimeMillis() - startTime) / 1000.0;
//        currentStep = getCallingMethodName();
        startTime = System.currentTimeMillis();
        String file_name = fileName;

        try {
            DBConnection.InsertData( TC_Name, currentStep, status, timeTaken, getCurrentTimestamp());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public static void updateLogStep(String uniqueRequestId) {
//        double timeTaken = (System.currentTimeMillis() - startTime) / 1000.0;
////        currentStep = getCallingMethodName();
//        startTime = System.currentTimeMillis();
//        String file_name = fileName;

        try {
            DBConnection.UpdateData(uniqueRequestId);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private static String getCurrentTimestamp() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return dateFormat.format(new Date());
//        return new Timestamp(System.currentTimeMillis());
    }

}
