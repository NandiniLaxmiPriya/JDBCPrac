package jdbc_prac;
import java.sql.*;
public class BatchUpdatesPreparedstmt {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Connection myconn = DriverManager.getConnection("jdbc:mysql://localhost:3306/prac","root","Root@123");
			String sql =  "insert into bulk(id,bname,age) values(?,?,?)";
			PreparedStatement ps = myconn.prepareStatement(sql);
			
			ps.setInt(1, 10);
			ps.setString(2,"eow");
			ps.setInt(3,24);
			ps.addBatch();
			
			ps.setInt(1, 11);
			ps.setString(2,"eew");
			ps.setInt(3,23);
			ps.addBatch();
			int[] ofo=ps.executeBatch();
			System.out.println("rows inserted successfully");
			 
		}catch(Exception ep)
		{
			ep.printStackTrace();
		}
	}

}
