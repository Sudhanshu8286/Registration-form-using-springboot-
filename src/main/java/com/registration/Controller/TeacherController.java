package com.registration.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.registration.Service.TeacherService;
import com.registration.model.Teacher;

@Controller
public class TeacherController {
	@Autowired
	TeacherService service;
	
//	@GetMapping("/inde")
//	public List<Teacher> getTeachers(Teacher teacher){
//		return this.service.getTeachers();
//	}
	
	@GetMapping("/index")
	public String index(Model model) {
		List<Teacher> teachers=service.getTeachers();
		model.addAttribute("teachers",teachers);
		return "index";
	}
	@GetMapping("/register")
	public String register(Model model) {
		Teacher teachers=new Teacher();
		model.addAttribute("teachers",teachers);
		return "register";
	}
//	@PostMapping("/saveteacher")
//	public List<Teacher> saveTeacher(@RequestBody Teacher teacher){
//		return this.service.saveTeacher(teacher);
//	}
	
	@PostMapping("/save")
	public String save(@ModelAttribute("teacher") Teacher teacher) {
		service.saveTeacher(teacher);
		return "redirect:/index";
	}
	@PutMapping("/updateteacher")
	public ResponseEntity<List<Teacher>> updateTeacher(@RequestBody Teacher teacher){
		List<Teacher> teachers =this.service.updateTeacher(teacher);
		if(teachers==null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(teachers);
		}
		else {
			return ResponseEntity.status(HttpStatus.OK).body(teachers);
			}
	}
	@DeleteMapping("/deleteteacher")
	public ResponseEntity<List<Teacher>> deleteTeacher(@RequestBody Teacher teacher){
		List<Teacher> teachers =this.service.deleteTeacher(teacher);
		if(teachers==null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(teachers);
		}
		else {
			return ResponseEntity.status(HttpStatus.OK).body(teachers);
			}
	}
	

}
