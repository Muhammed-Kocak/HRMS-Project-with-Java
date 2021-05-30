package kodlamaio.hrms.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.JobPositionService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobPosition;

@RestController
@RequestMapping("/api/position")
public class JobPositionsController {

	private JobPositionService jobPositionService;

	@Autowired
	public JobPositionsController(JobPositionService jobPositionService) {
		this.jobPositionService = jobPositionService;
	}

	@GetMapping("/getall")
	@RequestMapping(method = RequestMethod.GET)
	public DataResult<List<JobPosition>> getAll() {
		var result = this.jobPositionService.getAll();

		if (result.isSuccess()) {
			return result;
		} else {
			return result;
		}
	}

	@PostMapping("/add")
	@RequestMapping(method = RequestMethod.POST)
	public Result add(JobPosition jobPosition) {
		Result result = this.jobPositionService.add(jobPosition);

		if (result.isSuccess()) {
			return result;
		} else {
			return result;
		}
	}

	@GetMapping("/getbyname")
	@RequestMapping(method = RequestMethod.GET)
	public DataResult<JobPosition> getByPositionName(String positionName) {
		var result = this.jobPositionService.getByPositionName(positionName);

		if (result.isSuccess()) {
			return result;
		} else {
			return result;
		}
	}

	@GetMapping("/getbyid")
	@RequestMapping(method = RequestMethod.GET)
	public DataResult<JobPosition> getById(int id) {

		var result = this.jobPositionService.getById(id);

		if (result.isSuccess()) {
			return result;
		} else {
			return result;
		}
	}
}
