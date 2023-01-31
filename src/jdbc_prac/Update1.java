package jdbc_prac;
import java.sql.*;
public class Update1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			Connection myconn = DriverManager.getConnection("jdbc:mysql://localhost:3306/prac","root","Root@123");
			Statement stmt = myconn.createStatement();
			String upd = "update fruit "+" set frname='mangoo' "+" where fid=8";
			stmt.executeUpdate(upd);
			System.out.println("update successful");
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}

}
