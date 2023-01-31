package jdbc_prac;
import java.sql.*;
public class Connect1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try
		{
			Connection myconn = DriverManager.getConnection("jdbc:mysql://localhost:3306/prac","root","Root@123");
			Statement mystmt = myconn.createStatement();
			ResultSet rs = mystmt.executeQuery("select * from Employee");
			System.out.printf("%2s %2s %2s\n","Eid","Ename"," Pid");
			while(rs.next())
			{
				System.out.printf("%2s %2s %2s\n",rs.getString(1),rs.getString(2),rs.getString(3));
			}
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}

}
