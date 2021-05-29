//package kodlamaio.hrms.controllers;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RestController;
//
//import kodlamaio.hrms.business.abstracts.AuthService;
//import kodlamaio.hrms.core.utilities.results.DataResult;
//import kodlamaio.hrms.entities.concretes.User;
//
//@RestController
//@RequestMapping("/api/auth")
//public class AuthsController {
//
//	public AuthService authService;
//
//	@Autowired
//	public AuthsController(AuthService authService) {
//		this.authService = authService;
//	}
//	
//	@PostMapping("login")
//	@RequestMapping(method = RequestMethod.GET)
//	public DataResult<User> login(User user){
//		var result = this.authService.login(user);
//
//		if(result.isSuccess()) {
//			return result;
//		}else {
//			return result;
//		}
//	}
//	
//	@PostMapping("register")
//	@RequestMapping(method = RequestMethod.GET)
//	public DataResult<User> register(User user){
//		var result = this.authService.register(user);
//
//		if(result.isSuccess()) {
//			return result;
//		}else {
//			return result;
//		}
//	}
//	
//	
//	
//}
