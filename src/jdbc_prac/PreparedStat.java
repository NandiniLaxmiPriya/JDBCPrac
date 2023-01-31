package jdbc_prac;
import java.sql.*;
public class PreparedStat {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Connection myconn = DriverManager.getConnection("jdbc:mysql://localhost:3306/prac","root","Root@123");
			PreparedStatement ps = myconn.prepareStatement("select * from fruit where frname=? and fid=?");
			ps.setInt(2, 4);
			ps.setString(1,"orange");
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				System.out.println(rs.getString(1)+" "+rs.getString(2));
			}
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}

}
