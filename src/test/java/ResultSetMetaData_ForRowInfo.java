import java.sql.*;

public class ResultSetMetaData_ForRowInfo {
    public static void main(String[] args) {
        String url = "jdbc:oracle:thin:@54.144.177.34:1521:XE";
        String username = "hr";
        String password = "hr";

        try {
            Connection con = DriverManager.getConnection(url, username, password);
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = stmt.executeQuery("SELECT * FROM EMPLOYEES");

            ResultSetMetaData rsmd = rs.getMetaData();
            int columnCount = rsmd.getColumnCount();
            //  String firstColName=rsmd.getColumnName(1);

          /*  System.out.println("columnCount = " + columnCount);
            System.out.println("firstColName = " + firstColName);*/




            //printing all data in one row
            for (int colIndex = 1; colIndex <= columnCount; colIndex++) {
                System.out.println(  rsmd.getColumnName(colIndex)+ " \t");
            }


            while(rs.next()){
                for (int colIndex = 1; colIndex <= columnCount; colIndex++) {
                    System.out.println( rs.getString(colIndex)+ " \t");
                }
                System.out.println();

            }

            /*rs.next();
            for (int colIndex = 1; colIndex <= columnCount; colIndex++) {

                System.out.println("rs.getString(" + colIndex + ") = " + rs.getString(colIndex));
            }
            rs.next();
            for (int colIndex = 1; colIndex <= columnCount; colIndex++) {

                System.out.println("rs.getString(" + colIndex + ") = " + rs.getString(colIndex));

            }*/

        } catch (SQLException e) {
            System.out.println("Error has occured" + e.getMessage());
        }


    }
}
