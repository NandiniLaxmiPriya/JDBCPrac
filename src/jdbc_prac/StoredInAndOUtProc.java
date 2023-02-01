package jdbc_prac;
import java.sql.*;
public class StoredInAndOUtProc {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try
		{
			Connection myconn = DriverManager.getConnection("jdbc:mysql://localhost:3306/assignment","root","Root@123");
			CallableStatement cs = myconn.prepareCall("{call retrieve(?,?)}");
			cs.setString(1,"P189");
			cs.registerOutParameter(2,Types.INTEGER);
			cs.execute();
			Integer rs = cs.getInt(2);
			System.out.println("the total count of P189 is"+rs);
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}

}
