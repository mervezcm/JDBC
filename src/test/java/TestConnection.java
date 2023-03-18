import java.sql.*;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestConnection {
    public static void main(String[] args) {
        String url = "jdbc:oracle:thin:@54.144.177.34:1521:XE";
        String username = "hr";
        String password = "hr";

        try {
            Connection con = DriverManager.getConnection(url,username,password);

            System.out.println("Connection was successful");
        } catch (SQLException e) {
            System.out.println("Connection has failed"+ e.getMessage());
        }


    }


}



