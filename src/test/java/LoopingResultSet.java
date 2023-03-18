import java.sql.*;

public class LoopingResultSet {
    public static void main(String[] args) {
        String url = "jdbc:oracle:thin:@54.144.177.34:1521:XE";
        String username = "hr";
        String password = "hr";

        try {

            Connection con = DriverManager.getConnection(url, username, password);
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = stmt.executeQuery("SELECT * FROM REGIONS");
            //next method is moving the cursor to next line and returning true/false according to whether we have next row

            while (rs.next()) {
                System.out.println(rs.getString(1) + " : " + rs.getString(2));
            }
            rs.beforeFirst();
            while (rs.next()) {
                System.out.println("ROW NUMBER İS " + rs.getRow());
                System.out.println(rs.getString(1) + " : " + rs.getString(2));
            }
// Getting row count --> move cursor to the row and get the row number
            rs.last();
            System.out.println("ROW COUNT IS " + rs.getRow());
        } catch (SQLException e) {
            System.out.println("Connection has failed  " + e.getMessage());
        }


    }
}
