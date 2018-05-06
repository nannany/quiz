package tryAny.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcTest1 {
    public static void main(String[] args) {
	try (Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "test", "test");
		Statement stmt = c.createStatement()) {
	    ResultSet rs = stmt.executeQuery("SELECT * FROM personal;");
	    if (rs.absolute(4)) {
		System.out.println(rs.getString(2));
	    }

	    if (stmt.execute("SELECT * from personal")) {
		ResultSet rs2 = stmt.getResultSet();
		if (rs2.next()) {
		    System.out.println(rs2.getInt(1));
		}
	    }

	    System.out.println(stmt.executeUpdate("insert into personal values(6,'ccc','dddd')"));
	} catch (SQLException e) {
	    e.printStackTrace();
	}

    }
}
