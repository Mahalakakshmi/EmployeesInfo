import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcConnection {
	
	
	public static void main (String [] args) throws SQLException{
		
		String connectionUrl = "jdbc:sqlserver://localhost:xxxxx;" + "databaseName=Employee;integratedSecurity=true;";
		Connection con = null;
		Statement stmt = null;
		ResultSet  rs = null;
		
		 
			
			//Class.forName("com.microsoft.sqlserver.dbc.SQLDriver");
			
			con = DriverManager.getConnection(connectionUrl);
			
			System.out.println("Connection Established");
			
			String SQL = "SELECT * From EmployeeInfo";
			
			  stmt = con.createStatement();
			  
			   rs = stmt.executeQuery(SQL);
			 
			   while(rs.next()){
				   System.out.println(rs.getString(1)+ "  "+rs.getString(2)+ "   " +rs.getString(3)+ "  "+rs.getString(4));
		 	  
			   
	}
		   	
			   
			   int   rows = stmt.executeUpdate("delete from EmployeeInfo where EmployeeId = 3");
			
		      System.out.println("Deleted rows = "+rows);
		
		      rows = stmt.executeUpdate("insert into EmployeeInfo(EmployeeId,EmployeeFName,EmployeeLName,EmployeeDept) values(13,'Brad' , 'Guzan', 'HR')");
		
		      rows = stmt.executeUpdate("Update EmployeeInfo set EmployeeId = 11 where EmployeeLName = 'Abbas'"); 
	     
	    
		      rows = stmt.executeUpdate("insert into EmployeeInfo(EmployeeId,EmployeeFName,EmployeeLName,EmployeeDept) values(12,'Raees' , 'Ahmad', 'Finance')");
				
		
		
	}
	
}
