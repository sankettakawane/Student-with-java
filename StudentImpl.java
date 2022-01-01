
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.sql.*;
import java.sql.SQLException;
import java.io.*;
import java.util.*;
import java.sql.Date;
import java.text.SimpleDateFormat;

public class StudentImpl implements StudentDAO {
	
	String username ="sanket";
	String password="Sanket";
	String url = "jdbc:postgresql://localhost/postgres";
	Student1 s = new Student1();
	
		public void getAllStudents() {
		try
		{
			String query = "select * from Student";
			Class.forName("org.postgresql.Driver");	
			Connection conn = DriverManager.getConnection(url, username, password);
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(query);
			
			while(rs.next())
			{		
				int id = rs.getInt(1);
				s.setID(id);
				String name = rs.getString(2);
				s.setName(name);
				Date bdate = rs.getDate(3);
				s.setBirthDate(bdate);
				Date jdate = rs.getDate(4);
				s.setJoiningDate(jdate);
				System.out.printf("|%5s|%-10s|%-10s|%-10s|\n", id, name, bdate, jdate);
			}
			
			rs.close();
			st.close();
			conn.close();
		}
		catch (ClassNotFoundException | SQLException e) {		
			e.printStackTrace();
			}
		}
	
		@Override
		public Student1 getStudentById(int ID) {
			try
			{
				String query = "select * from Student where ID="+ID;
				Class.forName("org.postgresql.Driver");
				Connection conn = DriverManager.getConnection(url, username, password);
				Statement st = conn.createStatement();
				ResultSet rs = st.executeQuery(query);
				SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
				
					while(rs.next())
					{					
						int i = rs.getInt(1);
						s.setID(i);
						String name = rs.getString(2);
						s.setName(name);
						Date date1 = rs.getDate(3);
						s.setBirthDate(date1);
						Date jdate = rs.getDate(4);
                                                s.setJoiningDate(jdate);
						System.out.println("         Student Data          ");
						System.out.println("-----------------------------");
						System.out.printf("|%5s|%-10s|%-10s|%-10s|\n", "ID", "Name", "DOB", "DOJ");
						System.out.println("-----------------------------");
						System.out.printf("|%5s|%-10s|%-10s|%-10s|\n", i, name, date1, jdate);
						System.out.println("-----------------------------");
					}
				
				
				rs.close();
				st.close();
				conn.close();
			}
			catch (ClassNotFoundException | SQLException e) {		
				e.printStackTrace();
			}
			return s;
		}
	
			
		
		public Student1 addStudent(Student1 s) 
		{
		try {
			Class.forName("org.postgresql.Driver");
			Connection conn = DriverManager.getConnection(url, username, password);
		        PreparedStatement ps = conn.prepareStatement("INSERT INTO Student VALUES (?, ?, ?,?)");
		       	ps.setInt(1, s.getID());
		       	ps.setString(2, s.getName());
		       	ps.setDate(3, s.getBirthDate());
		       	ps.setDate(4, s.getJoiningDate());
		      	int i =  ps.executeUpdate();
		      	if(i > 0) {
		    		  System.out.println("Student added successfully...!");		      	     
		    	  }
		    	  else
		    		  System.out.println("Failed to add a record........!");
		    	  ps.close();
		    	  conn.close();
		    	}
	       	catch (ClassNotFoundException | SQLException ex) {
		   	    ex.printStackTrace();
		   	 }
		    	return null;
			
		}
	
		
		public Student1 delStudent(int ID) {
			try
			{
				Class.forName("org.postgresql.Driver");
				Connection conn = DriverManager.getConnection(url, username, password);
				String sql = "DELETE FROM Student WHERE ID=?";
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setInt(1, ID);
												 
				int i = ps.executeUpdate();
				if (i > 0) {
				    System.out.println("Data deleted successfully!");
				}
				else
					System.out.println("Failed to delete data..!");
				
				ps.close();
				conn.close();
				
			}catch (ClassNotFoundException | SQLException ex) {
		        ex.printStackTrace();
		    }
			return null;
			
		}


		
		public Student1 updateStudent(int ID, String name) {
			try
			{
				Class.forName("org.postgresql.Driver");
				Connection conn = DriverManager.getConnection(url, username, password);
				String sql = "UPDATE Student SET Name= ? WHERE ID=?";
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setString(1, name);
				ps.setInt(2, ID);
								 
				int i = ps.executeUpdate();
				if (i > 0) {
				    System.out.println("An existing user was updated successfully!");
				}
				else
					System.out.println("Failed to update data..!");
				
				ps.close();
				conn.close();
				
			}catch (ClassNotFoundException | SQLException ex) {
		        ex.printStackTrace();
		    }
			return null;
			
		}
}
