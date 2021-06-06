package kodlamaio.hrms.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrms.business.abstracts.CandidatePhotoService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Candidate;
import kodlamaio.hrms.entities.concretes.CandidatePhoto;

@RestController
@RequestMapping("/api/candidatePhotosController")
public class CandidatePhotosController {

	private CandidatePhotoService candidatePhotoService;

	@Autowired
	public CandidatePhotosController(CandidatePhotoService candidatePhotoService) {
		this.candidatePhotoService = candidatePhotoService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestParam int jobSeekerId,@RequestParam MultipartFile file) {
		
		CandidatePhoto candidatePhoto = new CandidatePhoto();
        Candidate candidate = new Candidate();
        candidate.setId(jobSeekerId);
        candidatePhoto.setCandidate(candidate);
		
		return this.candidatePhotoService.add(candidatePhoto, file);
	}
	
	@GetMapping("/getAll")
	public DataResult<List<CandidatePhoto>> getAll() {
		return this.candidatePhotoService.getAll();
	}
	
	@GetMapping("/getByCandidate_id")
	public DataResult<CandidatePhoto> getByCandidate_id(int candidateId) {
		return this.candidatePhotoService.getByCandidate_id(candidateId);
	}
}