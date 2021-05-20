package mapper;

import bean.Student;

import java.util.List;


public interface StudentMapper {
	public List<Student> findAllStudents();

	public Student findStudentById(int studId);

	public int insertStudent(Student student);

	public int updateStudent(Student student);

	public int deleteStudentById(int studId);
}