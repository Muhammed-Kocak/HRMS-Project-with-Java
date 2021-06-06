package kodlamaio.hrms.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.CandidateWorkplaceTitleService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.CandidateWorkplaceTitle;

@RestController
@RequestMapping("/api/candidateWorkplaceTitlesController")
public class CandidateWorkplaceTitlesController {

	private CandidateWorkplaceTitleService candidateWorkplaceTitleService;

	@Autowired
	public CandidateWorkplaceTitlesController(CandidateWorkplaceTitleService candidateWorkplaceTitleService) {
		this.candidateWorkplaceTitleService = candidateWorkplaceTitleService;
	}
	
	@GetMapping("/getAll")
	public DataResult<List<CandidateWorkplaceTitle>> getAll() {
		return this.candidateWorkplaceTitleService.getAll();
	}
	
	@GetMapping("/getByCandidate_id")
	public DataResult<List<CandidateWorkplaceTitle>> getByCandidate_id(@RequestParam int candidateId) {
		return this.candidateWorkplaceTitleService.getByCandidate_id(candidateId);
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody CandidateWorkplaceTitle candidateWorkplaceTitle) {
		return this.candidateWorkplaceTitleService.add(candidateWorkplaceTitle);
	}
	
}
