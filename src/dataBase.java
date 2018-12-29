import java.security.PublicKey;
import java.sql.*;
import java.util.Arrays;
import java.util.stream.Collectors;

public class dataBase {

    protected String connectionString;
    protected String databaseName;
    protected String username;
    protected String password;
    protected Connection conn;

    public dataBase(String connectionString, String databaseName, String username, String password) {
        this.connectionString = connectionString;
        this.databaseName = databaseName;
        this.username = username;
        this.password = password;
    }


    public dataBase(String connectionString, String databaseName) {
        this.connectionString = connectionString;
        this.databaseName = databaseName;
        this.username = "";
        this.password = "";
    }

    public dataBase(String databaseName) {
        this.connectionString =  "jdbc:sqlserver:1433//localhost;integratedSecurity=true";
        this.databaseName = databaseName;
        this.username = "";
        this.password = "";
    }
    //</editor-fold>

    //<editor-fold desc="Getters">
    public String getConnectionString() {
        return connectionString;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getDatabaseName() {
        return databaseName;
    }
    //</editor-fold>

    //<editor-fold desc="Connection Methods">
    public void startConnection() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection(this.connectionString, this.username, this.password);
            System.out.println(String.format("Connection established to: '%s'", connectionString));
            selectDatabase(this.databaseName);
        } catch (Exception e) {
            System.out.println(String.format("Cannot start connection to: %s", connectionString));
            System.out.println(e.getMessage());
        }
    }

    /**
     * Selects dataBase to work on.
     *
     * @return true if the dataBase exists and been selected.
     */
    private void selectDatabase(String databaseName) {
        try {
            Statement stmt = conn.createStatement();
            stmt.execute("use " + databaseName);
            stmt.close();
            System.out.println(String.format("dataBase selected: '%s'", databaseName));
        } catch (Exception e) {
            System.out.println(String.format("dataBase '%s' not found at: %s", databaseName, connectionString));
            System.out.println(e.getMessage());
        }
    }

    /**
     * Close the connection
     *
     * @return true if the connection is closed properly
     */
    public void closeConnection() {
        try {
            if (conn != null && !conn.isClosed()) {
                conn.close();
                conn = null;
                System.out.println(String.format("dataBase connection closed!", connectionString));
            }
        } catch (Exception e) {
            System.out.println(String.format("Error closing connection to: %s", connectionString));
            System.out.println(e.getMessage());
        }
    }
    //</editor-fold>

    //<editor-fold desc="Execute Queries">

    /**
     * @param query SQL query
     * @return ResultSet holds the query results
     */
    //Execute Queries
    public ResultSet executeQuerySelect(String query) {
        ResultSet resultSet = null;
        if (conn != null) {
            try {
                Statement sqlStatement = conn.createStatement();
                resultSet = sqlStatement.executeQuery(query);
                System.out.println(String.format("Query executed: '%s'", query));
            } catch (SQLException e) {
                System.out.println(String.format("Error executing query: '%s'", query));
                System.out.println(e.getMessage());
            }
        }
        return resultSet;
    }
    //</editor-fold>
}
