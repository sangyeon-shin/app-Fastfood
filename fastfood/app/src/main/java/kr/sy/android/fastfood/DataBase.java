package kr.sy.android.fastfood;


import android.os.StrictMode;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class DataBase {

    private static final String DEFAULT_DRIVER = "oracle.jdbc.driver.OracleDriver";
    private static final String DEFAULT_URL = "jdbc:oracle:thin:@192.168.1.189:1521:xe";
    private static final String DEFAULT_USERNAME = "sangyeon";
    private static final String DEFAULT_PASSWORD = "0129";

    private Connection connection;

    public DataBase() {
        /*
        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }

         */
    }

    public String loadList(String category) {
        String sql = "select * from ";
        sql = sql + category;
        String result = null;

        try {
            this.connection = createConnection();
            Statement stmt=connection.createStatement();
            StringBuffer stringBuffer = new StringBuffer();
            ResultSet rs = stmt.executeQuery("sql");
            while(rs.next()) {
                stringBuffer.append( rs.getString(1)+"\n");
            }
            result = stringBuffer.toString();
            connection.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public static Connection createConnection(String driver, String url, String username, String password) throws ClassNotFoundException, SQLException {

        Class.forName(driver);
        return DriverManager.getConnection(url, username, password);
    }

    public static Connection createConnection() throws ClassNotFoundException, SQLException {
        return createConnection(DEFAULT_DRIVER, DEFAULT_URL, DEFAULT_USERNAME, DEFAULT_PASSWORD);
    }
}
