package jdbc_prac;
import java.sql.*;
public class StoredInProcedure {

	public static void show(Connection myconn)
	{
		try {
			Statement mystmt = myconn.createStatement();
			ResultSet rs = mystmt.executeQuery("select * from human");
			System.out.println("Hid"+" "+"Hname"+" "+"Fid");
			while(rs.next())
			{
				System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3));
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Connection myconn = DriverManager.getConnection("jdbc:mysql://localhost:3306/prac","root","Root@123");
			System.out.println("BEFORE UPDATE");
			show(myconn);
			CallableStatement cs = myconn.prepareCall("{call ssetvalues(?,?)}");
			cs.setString(1, "yum");
			cs.setInt(2, 14);
			cs.execute();
		
			System.out.println("Finised calling stored in proc");
			System.out.println("AFTER UPDATE");
			show(myconn);
		}catch(Exception ex)
		{
			
		}
	}

}
