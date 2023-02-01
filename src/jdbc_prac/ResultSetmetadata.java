package jdbc_prac;
import java.sql.*;
public class ResultSetmetadata {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Connection myconn = DriverManager.getConnection("jdbc:mysql://localhost:3306/prac","root","Root@123");
			Statement stmt = myconn.createStatement();
			ResultSet rs= stmt.executeQuery("select * from bulk");
			ResultSetMetaData rsmd = rs.getMetaData();
			int count = rsmd.getColumnCount();
			System.out.println("no of columns"+count);
			for(int i=1;i<=count;i++)
			{
				System.out.println("columname "+rsmd.getColumnName(i));
				System.out.println("Column type "+rsmd.getColumnTypeName(i));
				System.out.println("colum nullable "+rsmd.isNullable(i));
			}
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}

}
