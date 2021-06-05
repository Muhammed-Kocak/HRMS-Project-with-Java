package kodlamaio.hrms.business.abstracts;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.CandidatePhoto;

public interface CandidatePhotoService {
	DataResult<List<CandidatePhoto>> getAll();

	DataResult<CandidatePhoto> getByCandidate_id(int candidateId);

	Result add(CandidatePhoto candidate);

	Result add(CandidatePhoto jobSeekerPhoto, MultipartFile file);
}
