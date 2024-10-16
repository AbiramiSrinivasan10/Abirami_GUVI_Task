package Task12;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {

	public static void main(String[] args) throws SQLException {
		String URL = "jdbc:mysql://localhost:3306/jatdb1";
		String uname = "root";
		String psw = "abi2000";
		
		// Creating connection to mysql db
		Connection con = DriverManager.getConnection(URL, uname, psw);
		
		// Create statement object to create statement
		Statement s = con.createStatement();
		
		int result= s.executeUpdate("insert into empdata(empcode,empname,empage,esalary) values('101','jenny','25','10000')");
		result=s.executeUpdate("insert into empdata(empcode,empname,empage,esalary) values('102','jackey','30','20000')");
		result=s.executeUpdate("insert into empdata(empcode,empname,empage,esalary) values('103','joe','20','40000')");
		result=s.executeUpdate("insert into empdata(empcode,empname,empage,esalary) values('104','john','40','80000')");
		result=s.executeUpdate("insert into empdata(empcode,empname,empage,esalary) values('105','shameer','25','90000')");
		
		
		 if (result > 0) 
             System.out.println("successfully inserted"); 

         else
             System.out.println( 
                 "unsucessful insertion "); 

         // closing connection 
         con.close(); 
         
		
	}

}
