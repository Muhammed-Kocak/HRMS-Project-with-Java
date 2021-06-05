package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.CandidateWorkplaceTitle;

public interface CandidateWorkplaceTitleService {

	DataResult<List<CandidateWorkplaceTitle>> getAll();

	DataResult<List<CandidateWorkplaceTitle>> getByCandidate_id(int candidateId);

	Result add(CandidateWorkplaceTitle candidateWorkplaceTitle);
}
