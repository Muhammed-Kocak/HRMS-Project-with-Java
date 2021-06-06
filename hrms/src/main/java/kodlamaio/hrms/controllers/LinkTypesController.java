package kodlamaio.hrms.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.LinkTypeService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.LinkType;

@RestController
@RequestMapping("/api/linkTypesController")
public class LinkTypesController {

	private LinkTypeService linkTypeService;

	@Autowired
	public LinkTypesController(LinkTypeService linkTypeService) {
		this.linkTypeService = linkTypeService;
	}
	
	@GetMapping("/getAll")
	public DataResult<List<LinkType>> getAll() {
		return this.linkTypeService.getAll();
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody LinkType linkType) {
		return this.linkTypeService.add(linkType);
	}
	
}
