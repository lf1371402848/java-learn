package oto.mapper;

import oto.bean.Students;

public interface OtoMapper {
	public Students selectStudentWithAddress(int studId);

	public Students findStudentsWithAddressById(int id);
}
