package kodlamaio.hrms.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Employer;
import kodlamaio.hrms.entities.dtos.EmployerForRegisterDto;

@RestController
@RequestMapping("/api/employer")
public class EmployersController {

	private EmployerService employerService;

	@Autowired
	public EmployersController(EmployerService employerService) {
		this.employerService = employerService;
	}
	
	@GetMapping("getall")
	@RequestMapping(method = RequestMethod.GET)
	public DataResult<List<Employer>> getAll(){
		var result = this.employerService.getAll();

		if(result.isSuccess()) {
			return result;
		}else {
			return result;
		}
	}
	
	@PostMapping("/register")
	public Result add(@RequestBody EmployerForRegisterDto employer) {
		return this.employerService.register(employer);
	}
}
