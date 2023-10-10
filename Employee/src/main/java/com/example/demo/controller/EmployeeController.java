package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.demo.entity.Employee;
import com.example.demo.service.EmployeeService;


@RestController
@RequestMapping("/api")
//@Api(tags="Employee API")
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;

	@GetMapping("/getListOfEmployees")
	public List<Employee> getListOfEmployees() {
		return employeeService.getListOfEmployees();

	}

	@PostMapping("/multipleStudentSave")
	public List<Employee> saveListOfEmployee(@RequestBody List<Employee> employee) {
		return employeeService.saveMultipleRecords(employee);
	}

	@GetMapping("/employees/{employeeId}")
	public Employee getEmployee(@PathVariable Long employeeId) {

		return employeeService.getEmployee(employeeId);
	}

	@PostMapping("/saveEmployees")
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee) {
		Employee employeeSaved = employeeService.saveEmployee(employee);
		return new ResponseEntity<Employee>(employeeSaved, HttpStatus.CREATED);
	}

	@PutMapping("/updateEmployees/{employeeId}")
	public Employee updateEmployee(@RequestBody Employee employee) {
		return employeeService.updateEmployee(employee);
	}

	@DeleteMapping("/deleteEmployees/{employeeId}")
	public String deleteEmployee(@PathVariable Long employeeId) {
		return employeeService.deleteEmployee(employeeId);
	}

}