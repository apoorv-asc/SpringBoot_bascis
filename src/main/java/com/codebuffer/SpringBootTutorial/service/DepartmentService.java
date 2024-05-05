package com.codebuffer.SpringBootTutorial.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.codebuffer.SpringBootTutorial.entity.Department;
import com.codebuffer.SpringBootTutorial.error.DepartmentNotFoundException;

@Service
public interface DepartmentService {

	public Department saveDepartment(Department dept);

	public List<Department> fetchDepartmentList();

	public Department fetchDeptByID(Long id) throws DepartmentNotFoundException;

	public void deleteDeptByID(Long id);

	public Department updateDept(Long deptID, Department dept);

	public Department fetchDeptByName(String name);
	
}
