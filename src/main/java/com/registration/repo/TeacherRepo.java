package com.registration.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.registration.model.Teacher;
@Repository
public interface TeacherRepo extends JpaRepository<Teacher, Integer> {

}
