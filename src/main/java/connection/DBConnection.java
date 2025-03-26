package connection;

import utils.PropertiesHandler;

import java.sql.*;
import java.util.logging.Logger;

public class DBConnection {
    private static final Logger log = Logger.getLogger(DBConnection.class.getName());
    public static Connection connection;

    public static String url = PropertiesHandler.getDBUrl();
    public static String username = PropertiesHandler.getDBUserName();
    public static String password = PropertiesHandler.getDBPassword();

    // Specify table name
    public static String tableName = "Prod_Monitoring_Log";

    public static void getConnection() {

        // Register the JDBC driver
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException e) {
            System.err.println("Failed to load JDBC driver.");
            e.printStackTrace();
            return;
        }
        try {
            log.info("Loading application properties");
            connection = DriverManager.getConnection(url, username, password);
            if (connection != null) {
                log.info("DB Connection successful!");

                // Fetch metadata
                DatabaseMetaData metaData = connection.getMetaData();

                // Fetch table names
                ResultSet tables = metaData.getTables(null, null, "%", new String[]{"TABLE"});
                System.out.println("Table Names:");
                while (tables.next()) {
                    String tableName = tables.getString("TABLE_NAME");
                    System.out.println(tableName);
                }

                // Fetch column names
                ResultSet columns = metaData.getColumns(null, null, tableName, null);
                System.out.println("Column Names for table " + tableName + ":");
                while (columns.next()) {
                    String columnName = columns.getString("COLUMN_NAME");
                    System.out.println(columnName);
                }

                // Fetch schemas
                ResultSet schemas = metaData.getSchemas();
                System.out.println("\nSchemas:");
                while (schemas.next()) {
                    String schemaName = schemas.getString("TABLE_SCHEM");
                    System.out.println(schemaName);
                }
            }
            log.info("Database connection test: " + connection.getCatalog());

        } catch (SQLException e) {
            System.err.println("Failed to connect to the database.");
            log.info(e.getMessage());
        }

    }

    public static void createTable() {
        // Establish the connection
        try {
            if (connection != null) {

                // Create table SQL statement
                String createTableSQL = "CREATE TABLE custcockpit01n.functional_tests_results.Prod_Monitoring_Log (\n" +
                        "\tid int IDENTITY(0,1) NOT NULL,\n" +
                        "\ttenant varchar(100) NULL,\n" +
                        "\ttest_case_name varchar(100) NULL,\n" +
                        "\tcurrent_step varchar(100) NULL,\n" +
                        "\tstatus varchar(100) NULL,\n" +
                        "\ttime_taken float NULL,\n" +
                        "\ttime_stamp timestamp NULL,\n" +
                        "\tCONSTRAINT Prod_Monitoring_Log_PK PRIMARY KEY (id)\n" +
                        ");";

                // Execute the SQL statement
                try (Statement statement = connection.createStatement()) {
                    statement.executeUpdate(createTableSQL);
                    System.out.println("Table created successfully.");
                } catch (SQLException e) {
                    System.err.println("Failed to execute create table SQL statement.");
                    e.printStackTrace();
                }
            }
        } catch (Exception e) {
            System.err.println("Failed to connect to the database.");
            e.printStackTrace();
        }

    }

    public static void alterTable() {
        // Establish the connection
        try {
            if (connection != null) {
                System.out.println("Connection successful!");

                // Define the SQL statement to alter the table
                String sql = "ALTER TABLE "+tableName+
                        " ADD id INT IDENTITY(1,1) PRIMARY KEY";

                // Execute the SQL statement
                try (Statement statement = connection.createStatement()) {
                    statement.executeUpdate(sql);
                    System.out.println("Table altered successfully.");
                } catch (SQLException e) {
                    System.err.println("Failed to execute SQL statement.");
                    e.printStackTrace();
                }
            }
        } catch (Exception e) {
            System.err.println("Failed to connect to the database.");
            e.printStackTrace();
        }

    }

    public static void InsertData(String tenant, String TC_Name, String currentStep, double timeTaken, String time_stamp) {
        log.info("In Execution : Insert Data");
        try {
            if (connection != null) {
                System.out.println("Connection successful!");

                // Define SQL statement with parameters
                String sql = "INSERT INTO " + tableName + " (tenant, test_case_name, current_step, status, time_taken, time_stamp) VALUES (?, ?, ?, ?, ?, ?)";

                // Create a PreparedStatement
                try (PreparedStatement statement = connection.prepareStatement(sql)) {
                    // Set values for parameters
//                    statement.setInt(1, 1);
                    statement.setString(1, tenant);
                    statement.setString(2, TC_Name);
                    statement.setString(3, currentStep);
                    statement.setDouble(5, timeTaken);// Example for time_taken
                    statement.setString(6, time_stamp); // Example for time_stamp

                    // Execute the statement
                    int rowsInserted = statement.executeUpdate();
                    if (rowsInserted > 0) {
                        System.out.println("Data inserted successfully.");
                    }
                } catch (SQLException e) {
                    System.err.println("Failed to execute insert data SQL statement.");
                    e.printStackTrace();
                }
            }
        } catch (Exception e) {
            System.err.println("Failed to connect to the database.");
            e.printStackTrace();
        }

    }

    public static void UpdateData(String traceID) {
        log.info("In Execution : update Data");
        try {
            if (connection != null) {
                System.out.println("Connection successful!");

                // Define SQL statement to update last inserted row
                String updateSql = "UPDATE "+ tableName +  "SET column8 = ? WHERE time_stamp = (SELECT MAX(time_stamp) FROM "+tableName+")";

                // Create a PreparedStatement
                try (PreparedStatement statement = connection.prepareStatement(updateSql)) {
                    // Set values for columns to update
                    statement.setString(8, traceID);

                    // Execute the update statement
                    int rowsUpdated = statement.executeUpdate();
                    if (rowsUpdated > 0) {
                        System.out.println("Last inserted row updated successfully.");
                    } else {
                        System.out.println("Failed to update last inserted row.");
                    }
                } catch (SQLException e) {
                    System.err.println("Failed to execute SQL statement.");
                    e.printStackTrace();
                }

            }
        } catch (Exception e) {
            System.err.println("Failed to connect to the database.");
            e.printStackTrace();
        }

    }


    public static void closeConnection() {
        try {
            log.info("Closing database connection");
            connection.close();
        } catch (SQLException e) {
            System.err.println("Failed to close connection to the database.");
            log.info(e.getMessage());
        }
    }
}
