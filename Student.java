//import java.util.*;
import java.sql.Date;
class Student1 
{
	private int ID;
	private String name;
	private Date birthdate;
	private Date joiningdate;
	
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getBirthDate() {
		return birthdate;
	}
	public void setBirthDate(Date birthdate) {
		this.birthdate = birthdate;
	}
	public Date getJoiningDate() {
		return joiningdate;
	}
	public void setJoiningDate(Date joiningdate) {
		this.joiningdate = joiningdate;
	}
	public Student1(int iD, String name, Date birthdate,Date joiningdate) {
		super();
		ID = iD;
		this.name = name;
		this.birthdate = birthdate;
		this.joiningdate = joiningdate;
	}
	public Student1() {
		super();
	}

	public String toString() {
		return "Employee ID=" + ID + ", name=" + name + ", DOB=" + birthdate + ", DOJ=" +joiningdate;
	}
	
	
}
