package com.codebuffer.SpringBootTutorial.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codebuffer.SpringBootTutorial.entity.Department;
import com.codebuffer.SpringBootTutorial.error.DepartmentNotFoundException;
import com.codebuffer.SpringBootTutorial.repository.DepartmentRepository;

@Service
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	private DepartmentRepository deptRepo;
	
	@Override
	public Department saveDepartment(Department dept) {
		// TODO Auto-generated method stub
		return deptRepo.save(dept);
	}

	@Override
	public List<Department> fetchDepartmentList() {
		// TODO Auto-generated method stub
		return deptRepo.findAll();
	}

	@Override
	public Department fetchDeptByID(Long id) throws DepartmentNotFoundException {
		// TODO Auto-generated method stub
		Optional<Department> dept = deptRepo.findById(id);
		if(!dept.isPresent()) {
			throw new DepartmentNotFoundException("Department not found");
		}
		return dept.get();
	}

	@Override
	public void deleteDeptByID(Long id) {
		try {
			deptRepo.deleteById(id);
		}catch(Exception e) {
			System.out.println(e);
		}
	}

	@Override
	public Department updateDept(Long deptID, Department dept) {
		Department dbDept = deptRepo.findById(deptID).get();
		if(Objects.nonNull(dept.getDepartmentName()) && !dept.getDepartmentName().equalsIgnoreCase("")) {
			dbDept.setDepartmentName(dept.getDepartmentName());
		}
		if(Objects.nonNull(dept.getDepartmentCode()) && !dept.getDepartmentCode().equalsIgnoreCase("")) {
			dbDept.setDepartmentCode(dept.getDepartmentCode());
		}
		
		if(Objects.nonNull(dept.getDepartmentAddress()) && !dept.getDepartmentAddress().equalsIgnoreCase("")) {
			dbDept.setDepartmentAddress(dept.getDepartmentAddress());
		}
		return deptRepo.save(dbDept);
	}

	@Override
	public Department fetchDeptByName(String name) {
		return deptRepo.findByDepartmentNameIgnoreCase(name);
	}

}
