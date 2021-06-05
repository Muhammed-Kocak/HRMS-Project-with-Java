package kodlamaio.hrms.business.concretes;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrms.business.abstracts.CandidatePhotoService;
import kodlamaio.hrms.core.utilities.helpers.imageHelpers.ImageUploadService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CandidatePhotoDao;
import kodlamaio.hrms.entities.concretes.CandidatePhoto;

@Service
public class CandidatePhotoManager implements CandidatePhotoService {
	
	private CandidatePhotoDao candidatePhotoDao;
	private ImageUploadService imageUploadService;

	@Autowired
	public CandidatePhotoManager(
			CandidatePhotoDao candidatePhotoDao,
			ImageUploadService imageUploadService) {
		this.candidatePhotoDao = candidatePhotoDao;
		this.imageUploadService = imageUploadService;
	}
	
	@Override
	public DataResult<List<CandidatePhoto>> getAll() {
		List<CandidatePhoto> result = this.candidatePhotoDao.findAll();
		return new SuccessDataResult<List<CandidatePhoto>>(result);
	}

	@Override
	public DataResult<CandidatePhoto> getByCandidate_id(int candidateId) {
		CandidatePhoto result = this.candidatePhotoDao.getByCandidate_id(candidateId);
		return new SuccessDataResult<CandidatePhoto>(result);
	}
	
	@Override
	public Result add(CandidatePhoto jobSeekerPhoto) {
		
		this.candidatePhotoDao.save(jobSeekerPhoto);
		
		return new SuccessResult();
	}

	@Override
	public Result add(CandidatePhoto candidatePhoto, MultipartFile file) {
		
		 Map<String,String> result = (Map<String,String>) this.imageUploadService.save(file).getData();
		 
	     String url = result.get("url");
		 
	     candidatePhoto.setPhotoUrl(url);
	     candidatePhoto.setUploadedDate(LocalDate.now());
	     
	     return add(candidatePhoto);
	}

}
