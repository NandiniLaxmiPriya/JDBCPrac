package jdbc_prac;
import java.sql.*;
public class BatchUpdatesStatement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Connection myconn = DriverManager.getConnection("jdbc:mysql://localhost:3306/prac","root","Root@123");
			Statement stmt = myconn.createStatement();
			stmt.addBatch("insert into bulk(id,bname,age) values(1,'kop',34)");
			stmt.addBatch("insert into bulk(id,bname,age) values(2,'lll',30)");
			stmt.addBatch("insert into bulk(id,bname,age) values(3,'ooo',38)");
			int rowseffetecd []=stmt.executeBatch();
			System.out.println("successfull insertion");
			
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}

}
