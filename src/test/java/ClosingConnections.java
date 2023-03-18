import java.sql.*;

public class ClosingConnections {
    public static void main(String[] args) throws SQLException {

        String url = "jdbc:oracle:thin:@54.144.177.34:1521:XE";
        String username = "hr";
        String password = "hr";

        // Connection con = null;
        //Statement stmt = null;
        // ResultSet rs = null;
        //try with resources -- only work with autoclosable resources
        try (Connection con = DriverManager.getConnection(url, username, password);
             Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
             ResultSet rs = stmt.executeQuery("SELECT * FROM REGIONS");) {
            rs.next();
            System.out.println(rs.getString(2));
        } catch (SQLException e) {
            System.out.println("Error has occured " + e.getMessage());
        }

      /*  try {
            con = DriverManager.getConnection(url, username, password);
            stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery("SELECT * FROM REGIONS");

            System.out.println("ALL SUCCESSFUL. ");

        } catch (SQLException e) {
            System.out.println("Error has occured " + e.getMessage());
        } finally {
            try {
                if (rs != null)
                    rs.close();
                if (stmt != null)
                    stmt.close();
                if (con != null)
                    con.close();
            } catch (SQLException e) {
                System.out.println("Error while closing resources" + e.getMessage());
            }
        }*/


    }
}
