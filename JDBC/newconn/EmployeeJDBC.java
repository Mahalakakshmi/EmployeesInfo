package newconn;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class EmployeeJDBC {

	public static void main(String[] args) {
		
		String connectionUrl = "jdbc:sqlserver://localhost:50718;" 
		                         + "databaseName=Employee;integratedSecurity=true;";
		
		Connection con = null;
		Statement stmt = null;
		ResultSet  rs = null;
		
		try{
		 
 	 con = DriverManager.getConnection(connectionUrl);
 	 
 	System.out.println("Connection Established");
 	// creating table
 	   stmt = con.createStatement();
 	
 	 String sql =  "create table EmployeesInfo2("+"emp_id int not null," +
 			 "first_name varchar(50) , " + "last_name varchar(50) , " + "Dept varchar(50)" 
 			 + "Primary key(emp_id))";
		
 	stmt.executeUpdate(sql);
 	
 	System.out.println("EmployeeInfo2 table created");
 	 
 	
 // 2. Insert data
    Integer ids[] = new Integer[] { 11, 2, 101, 102 };
    String firstNames[] = new String[] { "John", "Catherine", "Michael", "Alice" };
    String lastNames[] = new String[] { "Doe", "Abel", "Zwilling", "Wein" };
    String deptName[] = new String[]{"IT" , "Finance" , "Marketing" , "Management"};  
 	
 // insert employee data
    PreparedStatement ps = con.prepareStatement("INSERT INTO EmployeesInfo2 VALUES (?,?,?,?)");
    for (int i = 0; i < 4; ++i) {

        // perform insert in standard fashion
        ps.setInt(1, ids[i]);
        ps.setString(2, firstNames[i]);
        ps.setString(3, lastNames[i]);
        ps.setString(4, deptName[i]);
        ps.executeUpdate();
    }
    
    System.out.println(" Data successsfully inserted into EmployeesInfo2 table ");
      
       
       System.out.println("Querying EmployeesInfo2");
       

    System.out.format("%7s | %-20s | %-20s | %-20s%n ", "emp_id", "first_name", "last_name" , "dept");
    
    System.out.println("--------+---------------------+-----------------------+-------------------");
    	
    String sql2 = "SELECT * From EmployeesInfo2";
    
    ResultSet rs2 = stmt.executeQuery(sql2);
    
    while(rs2.next()){
		   System.out.format("%7s | %-20s | %-20s | %-20s%n ", rs2.getInt(1)  ,   rs2.getString(2)   ,    rs2.getString(3)  ,  rs2.getString(4));
	  	   
    
    }
    
    // update the data
    
   int rows = stmt.executeUpdate("Update EmployeesInfo2 set  first_name = 'Ken' where emp_id= 11 "); 
    
   int rows2 = stmt.executeUpdate("insert into EmployeesInfo2  values(16,'Jake' , 'Zukowski' , 'HR')");
   
   int rows3 = stmt.executeUpdate("insert into EmployeesInfo2  values(24,'Syed' , 'Abbas' , 'IT')");
   
   // delete the data
   
   int row4 = stmt.executeUpdate("delete EmployeesInfo2 where emp_id=102");
   
   
   System.out.println("________________________________________________________________");
   
   System.out.println("Updated EmployeeInfo2");
   
   System.out.println("=============================");
   
   
   String sql3 = "SELECT * From EmployeesInfo2";
   
   ResultSet rs3 = stmt.executeQuery(sql3);
   
   while(rs3.next()){
		   System.out.format("%7s | %-20s | %-20s | %-20s%n ", rs3.getInt(1)  , 
				   rs3.getString(2)   ,    rs3.getString(3)  ,  rs3.getString(4));
	  	     
   }
   
   
		}
		catch(SQLException e){
			
			e.printStackTrace();
		}
	}

	 
}
