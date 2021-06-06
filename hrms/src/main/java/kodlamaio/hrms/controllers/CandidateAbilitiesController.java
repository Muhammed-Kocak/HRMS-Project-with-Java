package kodlamaio.hrms.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.CandidateAbilityService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.CandidateAbility;

@RestController
@RequestMapping("/api/candidateAbilitiesController")
public class CandidateAbilitiesController {

	private CandidateAbilityService candidateAbilityService;

	@Autowired
	public CandidateAbilitiesController(CandidateAbilityService candidateAbilityService) {
		this.candidateAbilityService = candidateAbilityService;
	}
	
	@GetMapping("/getAll")
	public DataResult<List<CandidateAbility>> getAll() {
		return this.candidateAbilityService.getAll();
	}
	
	@GetMapping("/getByJobSeeker_id")
	public DataResult<List<CandidateAbility>> getByJobSeeker_id(@RequestParam int candidateId) {
		return this.candidateAbilityService.getByCandidate_id(candidateId);
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody CandidateAbility candidateAbility) {
		return this.candidateAbilityService.add(candidateAbility);
	}
	
}
