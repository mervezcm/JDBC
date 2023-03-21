import java.sql.*;

public class LibraryConnection {
    public static void main(String[] args) throws SQLException {
        String dbUrl = "jdbc:mysql://34.230.35.214:3306/library1";
        String dbUsername = "library1_client";
        String dbPassword = " WVF4NdGXCKHeE6VQ";

        Connection connection = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM books");

        //once you set up connection default pointer looks for 0
        //next() --> move pointer to first row
        resultSet.next();
    }
}
