package com.example.demo.serviceImpl;

import java.util.List;

import com.example.demo.constant.UserConstant;
import com.example.demo.exception.UserException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import com.example.demo.entity.Employee;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;

	List<Employee> list;

	@Override
	public Employee getEmployee(Long employeeId) {
		Employee employee = new Employee();
		employee =  employeeRepository.findByEmpId(employeeId);

				if(employee==null){
					System.out.print("++++++++++++++++++++++++++++++++++++++");
					throw new UserException(HttpStatus.NOT_FOUND,UserConstant.Record_Not_Found);
				}

				return  employeeRepository.findByEmpId(employeeId);
	}

	//
	@Override
	public Employee saveEmployee(Employee employee) {
		if (employee.getEmpId() == null || employee.getEmpName().isEmpty() || employee.getEmpName().length() == 0 || employee.getCity().isEmpty() || employee.getCity().length() == 0) {
			throw new UserException(HttpStatus.BAD_REQUEST, UserConstant.Empty_Fields);
		}
		return employeeRepository.save(employee);
}
	
	@Override
	public Employee updateEmployee(Employee employee){

		Employee emp = new Employee();

			if(employee.getEmpId()==null||employee.getEmpName().isEmpty()||employee.getEmpName().length()==0 ||employee.getCity().isEmpty()||employee.getCity().length()==0){
				throw new UserException(HttpStatus.BAD_REQUEST,UserConstant.Empty_Fields);
			}

		emp.setEmpId(employee.getEmpId());
		emp.setEmpName(employee.getEmpName());
		emp.setCity(employee.getCity());
			return employeeRepository.save(emp);
		}

	@Override
	public String deleteEmployee(long employeeId) {
		
		  employeeRepository.deleteById(employeeId);
		  return "deleted successfully";
	}
	@Override
	public List<Employee> saveMultipleRecords(List<Employee> employee) {
		return employeeRepository.saveAll(employee);
		
	}

	@Override
	public List<Employee> getListOfEmployees() {

		return employeeRepository.findAll();
	}

	

}
