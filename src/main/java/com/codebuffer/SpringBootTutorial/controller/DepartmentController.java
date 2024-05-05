package com.codebuffer.SpringBootTutorial.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.codebuffer.SpringBootTutorial.entity.Department;
import com.codebuffer.SpringBootTutorial.error.DepartmentNotFoundException;
import com.codebuffer.SpringBootTutorial.service.DepartmentService;

import jakarta.validation.Valid;

@RestController
public class DepartmentController {
	
	private final Logger log = LoggerFactory.getLogger(DepartmentController.class);
	
	@Autowired
	private DepartmentService departmentService;
	
	@PostMapping("/departments")
	public Department saveDepartment(@RequestBody Department dept) {
		
		log.info("Adding dept ");
		return departmentService.saveDepartment(dept);
	}
	
	@GetMapping("/departments")
	public List<Department> getDepartments(){
		return departmentService.fetchDepartmentList();
	}
	
	@GetMapping("/departments/{id}")
	public Department fetchDeptByID(@PathVariable("id") Long id) throws DepartmentNotFoundException {		
		return departmentService.fetchDeptByID(id);
	}
	
	@DeleteMapping("/departments/{id}")
	public String deleteDeptByID(@PathVariable("id") Long deptID) {
		departmentService.deleteDeptByID(deptID);
		return "Dept. deleted successfully";
	}
	
	@PutMapping("/departments/{id}")
	public Department updateDepartment(@PathVariable("id") Long deptID,@RequestBody Department dept) {
		return departmentService.updateDept(deptID,dept);	
	}
	
	@GetMapping("/department/name/{dept}")
	public Department fetchDeptByName(@PathVariable("dept") String name) {
		return departmentService.fetchDeptByName(name);
	}
	

}
