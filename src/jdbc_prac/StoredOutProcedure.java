package jdbc_prac;
import java.sql.*;
public class StoredOutProcedure {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Connection myconn = DriverManager.getConnection("jdbc:mysql://localhost:3306/prac","root","Root@123");
			CallableStatement cs = myconn.prepareCall("{call readsvaluer(?)}");
			cs.registerOutParameter(1,Types.VARCHAR);
			cs.setString(1,"lilluy");
			cs.execute();
			String rs = cs.getString(1);
			System.out.println(rs);
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}

}
