package com.codebuffer.SpringBootTutorial.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.codebuffer.SpringBootTutorial.entity.Department;
import com.codebuffer.SpringBootTutorial.repository.DepartmentRepository;

@SpringBootTest
class DepartmentServiceTest {
	
	@Autowired
	private DepartmentService deptService;
	
	@MockBean
	private DepartmentRepository deptRepo;

	@BeforeEach
	void setUp() throws Exception {
		Department dept = Department.builder()
				.departmentAddress("BLR")
				.departmentCode("IT-01")
				.departmentName("IT")
				.build();
		
		Mockito.when(deptRepo.findByDepartmentNameIgnoreCase("IT"))
		.thenReturn(dept);
	}
	
	@Test
//	@Disabled
	public void whenValidDeptName_thenDeptShouldFound() {
		String deptName = "IT";
		Department found = deptService.fetchDeptByName(deptName);
		System.out.println(found.getDepartmentName()+ " <--> "+deptName);
		assertEquals(deptName, found.getDepartmentName());
	}

}
