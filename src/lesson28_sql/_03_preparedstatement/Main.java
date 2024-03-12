package lesson28_sql._03_preparedstatement;

import lesson28_sql._02_statement_select.Employee;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

public class Main {
    public static final String URL = "jdbc:mysql://localhost:3306/po_2304";
    public static final String USER = "root";
    public static final String PASSWORD = "";

    public static void main(String[] args) {
        var query = "SELECT name,age, department FROM staff WHERE age > ? AND name LIKE ?";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try (var cn = DriverManager.getConnection(URL, USER, PASSWORD);
            var ps = cn.prepareStatement(query)){
            var staff = new ArrayList<Employee>();
            ps.setInt(1, 20);
            ps.setString(2, "Emp%");
            var rs = ps.executeQuery();
            while (rs.next()) {
                var name = rs.getString(1);
                var age = rs.getInt("age");
                var dep = rs.getInt(3);
                staff.add(new Employee(name, age, dep));
            }
            staff.forEach(System.out::println);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
