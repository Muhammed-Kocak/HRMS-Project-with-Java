package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CandidateWorkplaceTitleService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CandidateWorkplaceTitleDao;
import kodlamaio.hrms.entities.concretes.CandidateWorkplaceTitle;

@Service
public class CandidateWorkplaceTitleManager implements CandidateWorkplaceTitleService {

	private CandidateWorkplaceTitleDao candidateWorkplaceTitleDoa;
	
	@Autowired
	public CandidateWorkplaceTitleManager(CandidateWorkplaceTitleDao candidateWorkplaceTitleDoa) {
		this.candidateWorkplaceTitleDoa = candidateWorkplaceTitleDoa;
	}

	@Override
	public DataResult<List<CandidateWorkplaceTitle>> getAll() {
		List<CandidateWorkplaceTitle> result = this.candidateWorkplaceTitleDoa.findAll();
		return new SuccessDataResult<List<CandidateWorkplaceTitle>>(result);
	}

	@Override
	public DataResult<List<CandidateWorkplaceTitle>> getByCandidate_id(int candidateId) {
		List<CandidateWorkplaceTitle> result = this.candidateWorkplaceTitleDoa.getByCandidate_id(candidateId);
		return new SuccessDataResult<List<CandidateWorkplaceTitle>>(result);
	}

	@Override
	public Result add(CandidateWorkplaceTitle candidateIdWorkplaceTitle) {
		this.candidateWorkplaceTitleDoa.save(candidateIdWorkplaceTitle);
		return new SuccessResult();
	}

}
