package jdbc_prac;
import java.sql.*;
public class Insert1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Connection myconn = DriverManager.getConnection("jdbc:mysql://localhost:3306/prac","root","Root@123");
			Statement mystmt = myconn.createStatement();
			String ins = "insert into fruit"+"(fid,frname)"+"values(8,'grapes')";
			mystmt.executeUpdate(ins);
			System.out.println("insert successfull!");
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}

}
