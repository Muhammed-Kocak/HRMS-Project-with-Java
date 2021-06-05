package kodlamaio.hrms.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.UserService;
import kodlamaio.hrms.core.entities.User;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;

@RestController
@RequestMapping("/api/user")
public class UsersController {

	private UserService userService;

	public UsersController(UserService userService) {
		super();
		this.userService = userService;
	}
	
	@GetMapping("/getAll")
	public DataResult<List<User>> getAll(){
		var result = this.userService.getAll();

		if(result.isSuccess()) {
			return result;
		}else {
			return result;
		}
	}
	
	@GetMapping("/getByEmail")
	public DataResult<User> getByEmail(String email){
		var result = this.userService.getByEmail(email);

		if(result.isSuccess()) {
			return result;
		}else {
			return result;
		}
	}
	
	@GetMapping("/verifyUser")
	public Result verifyUser(String email,String verificationCode){
		var result = this.userService.verifyUser(email,verificationCode);

		if(result.isSuccess()) {
			return result;
		}else {
			return result;
		}
	}
	
	@PostMapping("/add")
	public Result add(User user){
		var result = this.userService.add(user);

		if(result.isSuccess()) {
			return result;
		}else {
			return result;
		}
	}
	
	
}
