
public interface StudentDAO
{
	public void getAllStudents();
	public Student1 getStudentById(int ID);
	public Student1 addStudent(Student1 s);
	public Student1 delStudent(int ID);
	public Student1 updateStudent(int ID, String name);
	
}
