package kodlamaio.hrms.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.CandidateService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Candidate;
import kodlamaio.hrms.entities.dtos.CandidateForRegisterDto;


@RestController
@RequestMapping("/api/candidate")
public class CandidatesController {

	
	private CandidateService candidateService;

	@Autowired
	public CandidatesController(CandidateService candidateService) {
		this.candidateService = candidateService;
	}
	
	@GetMapping("getall")
	@RequestMapping(method = RequestMethod.GET)
	public DataResult<List<Candidate>> getAll(){
		var result = this.candidateService.getAll();

		if(result.isSuccess()) {
			return result;
		}else {
			return result;
		}
	}
	
	@PostMapping("/register")
	public Result add(@RequestBody CandidateForRegisterDto candidate) {
		return this.candidateService.register(candidate);
	}
}
