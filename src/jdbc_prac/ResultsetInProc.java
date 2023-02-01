package jdbc_prac;
import java.sql.*;
public class ResultsetInProc {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Connection myconn = DriverManager.getConnection("jdbc:mysql://localhost:3306/assignment","root","Root@123");
			CallableStatement cs = myconn.prepareCall("{call showdata(?)}");
			cs.setString(1,"P189");
			cs.execute();
			ResultSet rs = cs.getResultSet();
			while(rs.next()) {
			System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3));
			}
		}catch(SQLException ex)
		{
			ex.printStackTrace();
		}
	}

}
