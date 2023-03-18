import java.sql.*;
import java.sql.DriverManager;
import java.sql.SQLException;

public class NavigatingQueryResult {
    public static void main(String[] args) {
        String url = "jdbc:oracle:thin:@54.144.177.34:1521:XE";
        String username = "hr";
        String password = "hr";

        try {
            Connection con = DriverManager.getConnection(url, username, password);

            Statement stmt = con.createStatement();

            ResultSet rs = stmt.executeQuery("SELECT * FROM REGIONS");



            rs.next();
            System.out.println("Region ID on first row is " + rs.getString(1));
            System.out.println("Region ID on first row is " + rs.getString("REGION ID"));
            System.out.println("Region NAME on first row is " + rs.getString(2));
            System.out.println("Region NAME on first row is " + rs.getString("REGION NAME"));

            rs.next();
            System.out.println("Region NAME on SECOND row is " + rs.getString("REGION NAME"));
            rs.next();
            System.out.println("Region NAME on THIRD row is " + rs.getString("REGION NAME"));
            rs.next();
            System.out.println("Region NAME on FOURTH row is " + rs.getString("REGION NAME"));
            System.out.println("DO WE HAVE MORE DATA " + rs.next());
            //   System.out.println("Region NAME AFTER LAST row is "+ rs.getString("REGION NAME"));

           // rs.previous();


        } catch (SQLException e) {
            System.out.println("Error has occurred." + e.getMessage());
        }
    }
}
