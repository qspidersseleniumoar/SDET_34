package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;



public class Sample_SelectQuery_Test {

	public static void main(String[] args) throws Throwable {
		
	 /*step 1 : load / register to MySql database*/
	 Driver driverRef = new Driver();
	 DriverManager.registerDriver(driverRef);
		
	 /*step 2 : connect to database*/
	 Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/students", "root", "root");
		
	 /*step 3 : issue / create SQL query*/
	 Statement stat=conn.createStatement();
	
	 /*step 4 : execute query*/
	 ResultSet result=stat.executeQuery("select * from students_info");
	 while (result.next()) {
		System.out.println(result.getInt(1) + "\t" + result.getString(2)+ "\t" + result.getString(3)+ "\t" + result.getString(4));
	}
	 
	 /*step 5 : close the Connection*/
	 conn.close();

	}

}
