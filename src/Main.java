import java.sql.*;

public class Main {
    public static final String DB_URL = "jdbc:mysql://employee";
    public static final String DB_USERNAME = "root";
    public static final String DB_PASSWORD = "";

    public static void main(String[] args) {
        Connection conn = null;
        Statement st = null;
        try {
            conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            st = conn.createStatement();

            ResultSet resultSet = st.executeQuery("SELECT * FROM employees");
            while (resultSet.next()) {
                System.out.println("ID : " + resultSet.getInt("id"));
                System.out.println("Name : " + resultSet.getString("name"));
                System.out.println("Position : " + resultSet.getString("position"));
                System.out.println("Salary : " + resultSet.getInt("salary"));
                System.out.println("#################");
            }
            st.close();
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
    }
}