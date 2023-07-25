package com.registration.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.registration.model.Teacher;
import com.registration.repo.TeacherRepo;
@Service
public class TeacherService implements Services{
	
	@Autowired
	TeacherRepo repo;

	@Override
	public List<Teacher> getTeachers() {
		
		return repo.findAll();
	}

	@Override
	public List<Teacher> saveTeacher(Teacher teacher) {
		repo.save(teacher);
		return repo.findAll();
	}

	@Override
	public List<Teacher> updateTeacher(Teacher teacher) {
		Optional<Teacher> teachers=repo.findById(teacher.getId());
			if(teachers.isPresent()) {
				repo.save(teacher);
				return repo.findAll();
			}
		
		return null;
	}

	@Override
	public List<Teacher> deleteTeacher(Teacher teacher) {
		Optional<Teacher> teachers=repo.findById(teacher.getId());
		if(teachers.isPresent()) {
			repo.delete(teacher);
			return repo.findAll();
		}
	
	return null;

	}

}
