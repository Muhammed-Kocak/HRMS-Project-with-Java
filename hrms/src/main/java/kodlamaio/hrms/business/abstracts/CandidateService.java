package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Candidate;
import kodlamaio.hrms.entities.dtos.CvDto;

public interface CandidateService {
	
	DataResult<List<Candidate>> getAll();

	DataResult<Candidate> getById(int candidateId);
	
	DataResult<CvDto> getCandidateResumeByCandidateId(int candidateId);
	
	Result add(Candidate candidate);
	
	Result delete(int candidateId);
	
	Result update(int candidateId, Candidate candidate);
	
	Result checkUserExists(String email, String nationalityIdentityId);

}
