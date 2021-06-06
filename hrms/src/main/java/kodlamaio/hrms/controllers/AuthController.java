package kodlamaio.hrms.controllers;

import org.springframework.http.ResponseEntity;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.concretes.AuthManager;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.dtos.CandidateForRegisterDto;
import kodlamaio.hrms.entities.dtos.EmployerForRegisterDto;

@RestController
@RequestMapping("/api/")
public class AuthController {
	
	private AuthManager authManager;

	public AuthController(AuthManager authManager) {
		this.authManager = authManager;
	}
	
	@PostMapping("candidates/register")
	public ResponseEntity<?> candidateRegister(
			@Valid @RequestBody CandidateForRegisterDto candidateDto) {
		Result result = this.authManager.CandidateRegister(candidateDto);
		return ResponseEntity.ok(result);
	}
	
	
	@PostMapping("employers/register")
	public ResponseEntity<?> employerRegister(
			@Valid @RequestBody EmployerForRegisterDto employerDto) {
		Result result = this.authManager.EmployerRegister(employerDto);
		return ResponseEntity.ok(result);
	}
}
