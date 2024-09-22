package kidsgame;


import java.sql.*;
import java.util.*;


public class jdbc {

	public static void main(String[] args)throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		//Class.forName("com.mysql.cj.jdbc.Driver");
		 Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/game", "root", "");
		//Step-II: Creating JDBC Statements
				Statement stmt = con.createStatement();
				
				
				//Step-III: Execute SQL Statements
				Scanner ini = new Scanner(System.in);
				System.out.print("Enter Email_id : ");
				String email_id = ini.next();
				System.out.print("Enter Password: ");
				String Pass = ini.next();
				System.out.print("Re_Enter_password: ");
				String Re_Enter_Pass = ini.next();
				String sql = "insert into `access` values('"+email_id+"', '"+Pass+"', '"+Re_Enter_Pass+"')";
				stmt.executeUpdate(sql);
				String qry = "Select * from access";
				
				//Step-IV: Get ResultSet
				ResultSet rs = stmt.executeQuery(qry);
				while(rs.next()) {
					System.out.println(rs.getString("email_id") + "\t" + rs.getString("Pass")+ "\t" + rs.getString("Re_Enter_Pass"));
				}
				
				//Step=V: Close Connections
				stmt.close();
				con.close();



	}

}

