package kodlamaio.hrms.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.CandidateSchoolDepartmentService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.CandidateSchoolDepartment;

@RestController
@RequestMapping("/api/candidateSchoolDepartmentsController")
public class CandidateSchoolDepartmentsController {
	
	private CandidateSchoolDepartmentService candidateSchoolDepartmentService;

	@Autowired
	public CandidateSchoolDepartmentsController(CandidateSchoolDepartmentService candidateSchoolDepartmentService) {
		this.candidateSchoolDepartmentService = candidateSchoolDepartmentService;
	}
	
	@GetMapping("/getAll")
	public DataResult<List<CandidateSchoolDepartment>> getAll() {
		return this.candidateSchoolDepartmentService.getAll();
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody CandidateSchoolDepartment candidateSchoolDepartment) {
		return this.candidateSchoolDepartmentService.add(candidateSchoolDepartment);
	}

	@GetMapping("/getByCandidate_candidateIdOrderByDateOfGraduation")
	public DataResult<List<CandidateSchoolDepartment>> getByJobSeeker_jobSeekerIdOrderByDateOfGraduation(
			@RequestParam int candidateId) {
		return this.candidateSchoolDepartmentService.getByCandidate_candidateIdOrderByDateOfGraduationDesc(candidateId);
	}

}