package jdbc_prac;
import java.sql.*;
import java.util.*;
public class Employee {
	public static void createTable(Connection myconn)
	{
		try {
			Statement mystmt = myconn.createStatement();
			String sql = "create table employeee"+"(eid int,ename varchar(10),age int,pid int)";
			mystmt.executeUpdate(sql);
			System.out.println("table created");
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}
	public static void insertInto(Connection myconn,int eid,String name,int  age,int pid)
	{
		String sql ="insert into employeee"+"(eid,ename,age,pid)"+"values(?,?,?,?)";
		try {
			PreparedStatement ps = myconn.prepareStatement(sql);
			ps.setInt(1,eid);
			ps.setString(2,name);
			ps.setInt(3,age);
			ps.setInt(4, pid);
			
			ps.executeUpdate();
			System.out.println("Values inserted successfully");
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	public static void readData(Connection myconn)
	{
		try {
			Statement mystmt = myconn.createStatement();
			ResultSet rs = mystmt.executeQuery("select * from employeee order by age");
			System.out.printf("%5S %5S %5S %5S\n","Eid"," Ename", "age", "Pid");
			while(rs.next())
			{
				System.out.printf("%5S %5S %5S %5S\n",rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4));
			}
			
		} catch (SQLException e) {
		e.printStackTrace();
		}
		
	}
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
	
			Connection myconn = DriverManager.getConnection("jdbc:mysql://localhost:3306/prac","root","Root@123");
			while(true)
			{
				System.out.println("Enter \n 1: create new table \n 2:insert into table \n 3:Read table by asc of age \n 4:exit ");
				int n =sc.nextInt();
				switch(n)
				{
				case 1:
					
					createTable(myconn);
					break;
				case 2:
					System.out.println("Enter Eid");
					int eid = sc.nextInt();
					System.out.println("Enter name");
					String name =sc.next();
					System.out.println("Enter age");
					int age = sc.nextInt();
					System.out.println("Enter pid");
					int pid = sc.nextInt();
					insertInto(myconn,eid,name,age,pid);
					break;
				case 3:
					readData(myconn);
					break;
				case 4:
					System.out.println("BYE :(");
					System.exit(0);
					
				}
			}
		

	}
	

}
