package MyseleniumProject.MyseleniumProject;

import java.sql.*;
import java.sql.DriverManager;


public class DB_Con {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			// This will load the MySQL driver, each DB has its own driver
			Class.forName("com.mysql.jbdc.Driver");
			Connection DB=DriverManager.getConnection("jdbc:mysql://localhost:3306/searchbox","root","");
			System.out.print(" The Database connection is working fine ");
		}
		catch(Exception e ) {
			System.out.println("There is an error with connection to the Database ");
			e.printStackTrace();
			
		}

	}

}
