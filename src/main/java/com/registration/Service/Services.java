package com.registration.Service;

import java.util.List;

import com.registration.model.Teacher;

public interface Services {

	public List<Teacher> getTeachers();
	
	public List<Teacher> saveTeacher(Teacher teacher);
	public List<Teacher> updateTeacher(Teacher teacher);
	public List<Teacher> deleteTeacher(Teacher teacher);
	
	
}
