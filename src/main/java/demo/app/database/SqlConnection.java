package demo.app.database;

import demo.app.menagement.StudentMgmt;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;

public class SqlConnection {

    private static Connection connection;
    private static final Logger logger = LogManager.getLogger(StudentMgmt.class);

    private void DBConnection(){}

    public static Connection getConnection() throws ClassNotFoundException{
        Class.forName("org.sqlite.JDBC");
        try {
            if (connection == null){
                String url = "jdbc:sqlite:D:\\Rea\\Desktop\\Ericsson\\Database\\demo.db";
                connection = DriverManager.getConnection(url);
                logger.info("Connection to SQLite has been established.");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return connection;
    }
}
