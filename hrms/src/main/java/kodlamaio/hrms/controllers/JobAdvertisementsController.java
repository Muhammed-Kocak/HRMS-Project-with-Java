package kodlamaio.hrms.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.JobAdvertisementService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;
import kodlamaio.hrms.entities.dtos.JobAdvertisementForAddDto;

@RestController
@RequestMapping("/api/jobAdvertisements")
public class JobAdvertisementsController {
	
	private JobAdvertisementService jobAdvertisementService;

	@Autowired
	public JobAdvertisementsController(
			JobAdvertisementService jobAdvertisementService) {
		this.jobAdvertisementService = jobAdvertisementService;
	}
	
	@GetMapping("/getAll")
	public DataResult<List<JobAdvertisement>> getAll() {
		return this.jobAdvertisementService.getAll();
	}
	
	@GetMapping("/getByActive")
	public DataResult<List<JobAdvertisement>> getByActive() {
		return this.jobAdvertisementService.getByActive();
	}
	
	@GetMapping("/getByActivePage")
	public DataResult<List<JobAdvertisement>> getByActive(int pageNo, int pageSize) {
		return this.jobAdvertisementService.getByActive(pageNo - 1, pageSize);
	}
	
	@GetMapping("/getByActiveSortedAsc")
	public DataResult<List<JobAdvertisement>> getByActiveSortedAsc() {
		
		return this.jobAdvertisementService.getByActiveSortedAsc();
	}
	
	@GetMapping("/getByActiveSortedDesc")
	public DataResult<List<JobAdvertisement>> getByActiveSortedDesc() {
		
		return this.jobAdvertisementService.getByActiveSortedDesc();
	}
	
//	@GetMapping("/getJobAdvertisementWithEmployer")
//	public DataResult<List<JobAdvertisementForAddDto>> getJobAdvertisementWithEmployer() {
//		
//		return this.jobAdvertisementService.getJobAdvertisementWithEmployer();
//	}

	@GetMapping("/getByEnableAndEmployerCompanyName")
	public DataResult<List<JobAdvertisement>> getByActiveTrueAndEmployerCompanyName(
			@RequestParam("companyName") String companyName) {
		return this.jobAdvertisementService.getByActiveTrueAndEmployerCompanyName(companyName);
	}
	
	@PostMapping("/add")
	public Result add(
			@RequestBody JobAdvertisement jobAdvertisement) {
		return this.jobAdvertisementService.add(jobAdvertisement);
	}
	
	@PutMapping("/update")
	public Result update(
			@RequestParam("jobAdvertisemenetId") int jobAdvertisemenetId,
			@RequestBody JobAdvertisement jobAdvertisement) {
		return this.jobAdvertisementService.update(jobAdvertisemenetId, jobAdvertisement);
	}
	
}
