package kodlamaio.hrms.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.EmployeeService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Employee;

@RestController
@RequestMapping("/api/employee")
public class EmployeesController {

	private EmployeeService employeeService;

	@Autowired
	public EmployeesController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	
	@GetMapping("getall")
	@RequestMapping(method = RequestMethod.GET)
	public DataResult<List<Employee>> getAll(){
		var result = this.employeeService.getAll();

		if(result.isSuccess()) {
			return result;
		}else {
			return result;
		}
	}
	
	@PostMapping("add")
	@RequestMapping(method = RequestMethod.POST)
	public Result add(Employee employee){
		var result = this.employeeService.add(employee);

		if(result.isSuccess()) {
			return result;
		}else {
			return result;
		}
	}
}
