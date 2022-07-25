package demo.app.database;

import java.sql.Connection;
import java.sql.DriverManager;

public class SqlConnection {

    private static Connection connection;

    private void DBConnection(){}

    public static Connection getConnection() throws ClassNotFoundException{
        Class.forName("org.sqlite.JDBC");
        try {
            if (connection == null){
                String url = "jdbc:sqlite:D:\\Rea\\Desktop\\Ericsson\\Database\\demo.db";
                connection = DriverManager.getConnection(url);
                System.out.println("Connection to SQLite has been established.");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return connection;
    }
}
