

import java.util.Scanner;
import java.util.*;
import java. text. SimpleDateFormat;


public class App {
	public static void main(String[] args) throws Exception {
		int choice,num;
		
		StudentDAO dao = new StudentImpl();
		Student1 s;
		
		do {
			System.out.println("<-------Menu------>");
			System.out.println("1.Get Student by ID");
			System.out.println("2.Add Student");
			System.out.println("3.Update Student");
			System.out.println("4.Delete Student");
			System.out.println("5.Get all Student");
			Scanner sc = new Scanner(System.in);
			choice = sc.nextInt();
		
		switch(choice)
		{
		case 1: System.out.println("Enter the ID of Student: ");
				int id1 = sc.nextInt();
				s = dao.getStudentById(id1);
			break;
			
		case 2: try
			{
				System.out.println("Enter Student Details: ");
				System.out.println("Enter Student ID: ");
				int id2 = sc.nextInt();
				System.out.println("Enter Student Name: ");
				String name = sc.next();
				System.out.println("Enter DOB: ");
				String Date1=sc.next();
				SimpleDateFormat sdf=new SimpleDateFormat("yyyy/MM/dd");
				Date birthdate=sdf.parse(Date1);
				java.sql.Date birthdate1=new java.sql.Date(birthdate.getTime());
				System.out.println("Enter DOJ: ");
				String Date2 = sc.next();
				Date joiningdate =new SimpleDateFormat("yyyy/MM/dd").parse(Date2);
				java.sql.Date joiningdate1=new java.sql.Date(joiningdate.getTime());
				
				
				Student1 s1 = new Student1(id2, name, birthdate1, joiningdate1);
				s = dao.addStudent(s1);
			}
			catch (Exception ex) 
			{
				ex.printStackTrace();
			}
			break;
			
		case 3:	System.out.println("Enter the ID to change record: ");
				int id3 = sc.nextInt();
				System.out.println("Enter the new Name: ");
				String name1 = sc.next();
				s = dao.updateStudent(id3, name1);
			break;
			
		case 4: System.out.println("Enter the ID to delete record");
				int id4 = sc.nextInt();
				s = dao.delStudent(id4);
				break;
			
		case 5: System.out.println("Student Data");
				System.out.println("-------------------------------------------");
				System.out.printf("|%5s|%-10s|%-10s|%-10s|\n", "ID", "Name", "DOB", "DOJ");
				System.out.println("-------------------------------------------");
				dao.getAllStudents();
				System.out.println("-------------------------------------------");
				break;
		default:
			System.out.println("Wrong input..!"); 
			break;
		}
		System.out.println("Enter 9 to continue..!");
		num = sc.nextInt();
		}while(num == 9);
	}
}
