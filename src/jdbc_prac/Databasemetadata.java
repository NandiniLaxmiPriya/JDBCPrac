package jdbc_prac;
import java.sql.*;
public class Databasemetadata {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String catalog=null;
		String schemaPattern=null;
		String tableNamePattern=null;
		String[] types=null;
		try {
			Connection myconn = DriverManager.getConnection("jdbc:mysql://localhost:3306/prac","root","Root@123");
			
			DatabaseMetaData dmd = myconn.getMetaData();
			System.out.println("Product name "+dmd.getDatabaseProductName());
			System.out.println("Product version "+dmd.getDatabaseProductVersion());
			System.out.println("Driver name "+dmd.getDriverName());
			System.out.println("Driver version "+dmd.getDriverVersion());
			
			/*System.out.println("list of Tables");
			ResultSet rs = dmd.getTables(catalog,schemaPattern,tableNamePattern,types);
			while(rs.next())
			{
				System.out.println(rs.getString("TABLE_NAME"));
			}*/
			ResultSet rs = dmd.getColumns(catalog, schemaPattern, tableNamePattern, tableNamePattern);
			while(rs.next())
			{
				System.out.println(rs.getString("COLUMN_NAME"));
			}
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}

}
