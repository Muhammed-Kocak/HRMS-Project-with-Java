package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.CandidateAbility;

public interface CandidateAbilityService {
	DataResult<List<CandidateAbility>> getAll();

	DataResult<List<CandidateAbility>> getByCandidate_id(int jcandidateId);

	Result add(CandidateAbility candidateAbility);
}
