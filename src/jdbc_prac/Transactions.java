package jdbc_prac;
import java.sql.*;
import java.util.*;
public class Transactions {

	public static void showdata(Connection myconn) throws SQLException
	{
		Statement st = myconn.createStatement();
		ResultSet rs = st.executeQuery("select * from bulk");
		while(rs.next())
		{
			System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3));
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Scanner sc = new Scanner(System.in);
			Connection myconn = DriverManager.getConnection("jdbc:mysql://localhost:3306/prac","root","Root@123");
			myconn.setAutoCommit(false);
			Statement st = myconn.createStatement();
			showdata(myconn);
			String sql1 = "delete from bulk where age=20;";
			st.executeUpdate(sql1);
			String sql2 = "update bulk set age=30 where bname='klm'";
			st.executeUpdate(sql2);
			System.out.println("Save or not save");
			boolean ok = sc.nextBoolean();
			if(ok)
			{
				myconn.commit();
			}else {
				myconn.rollback();
			}
			showdata(myconn);
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}

}
