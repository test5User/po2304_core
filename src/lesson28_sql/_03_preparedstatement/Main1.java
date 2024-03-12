package lesson28_sql._03_preparedstatement;

import lesson28_sql._02_statement_select.Employee;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

public class Main1 {
    public static final String URL = "jdbc:mysql://localhost:3306/po_2304";
    public static final String USER = "root";
    public static final String PASSWORD = "";

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try (var cn = DriverManager.getConnection(URL, USER, PASSWORD);
             var st = cn.createStatement()){
            var staff = new ArrayList<Employee>();
            var query = String.format("SELECT name,age,department FROM staff WHERE age > %d AND name LIKE '%s'", 20, "Emp%");

            var rs = st.executeQuery(query);
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
