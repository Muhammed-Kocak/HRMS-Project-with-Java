package kodlamaio.hrms.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.CityService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.City;

@RestController
@RequestMapping("/api/city")
public class CitiesController {

	private CityService cityService;

	@Autowired
	public CitiesController(CityService cityService) {
		this.cityService = cityService;
	}

	@GetMapping("/getall")
	public DataResult<List<City>> getAll() {
		var result = this.cityService.getAll();

		if (result.isSuccess()) {
			return result;
		} else {
			return result;
		}
	}

	@GetMapping("/getById")
	DataResult<City> getById(int id) {
		var result = this.cityService.getById(id);

		if (result.isSuccess()) {
			return result;
		} else {
			return result;
		}
	}

	@PostMapping("/add")
	public Result add(@RequestBody City city) {
		var result = this.cityService.add(city);

		if (result.isSuccess()) {
			return result;
		} else {
			return result;
		}
	}
}
