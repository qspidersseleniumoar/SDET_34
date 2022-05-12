package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;



public class Non_SelectQuery_Test2 {

	public static void main(String[] args) throws Throwable {
		Connection conn = null;
	try {	
		 /*step 1 : load / register to MySql database*/
		 Driver driverRef = new Driver();
		 DriverManager.registerDriver(driverRef);
			
		 /*step 2 : connect to database*/
		  conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/students", "root", "root");
			
		 /*step 3 : issue / create SQL query*/
		 Statement stat=conn.createStatement();
		
		 /*step 4 : execute query*/
		 int result=stat.executeUpdate("insert into students_info values('11', 'pam','gowda', 'h')");
	      System.out.println(result);
	}catch (Exception e) {
           System.out.println("handle the Problem");
	}finally {
		 /*step 5 : close the Connection*/
		 conn.close();
		 System.out.println("Close");
	}


	}

}
