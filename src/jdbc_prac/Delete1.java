package jdbc_prac;
import java.sql.*;
public class Delete1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try
		{
			Connection myconn = DriverManager.getConnection("jdbc:mysql://localhost:3306/prac","root","Root@123");
			Statement stmt = myconn.createStatement();
			stmt.executeUpdate("delete from fruit where fid=8");
			System.out.println("delete successfull");
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}

}
