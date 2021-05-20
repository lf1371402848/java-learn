package otm.mapper;

import otm.bean.Course;
import otm.bean.Tutor;
import oto.bean.Addresses;

public interface OtmMapper {
	public void insertAddress(Addresses address);
	public void insertTutor(Tutor tutor);
	public void insertCourse(Course course);
	
	public Tutor findTutorWithAddressAndCourseById(int id);
}
