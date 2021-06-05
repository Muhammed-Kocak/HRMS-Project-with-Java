package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CandidateLanguageService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CandidateLanguageDao;
import kodlamaio.hrms.entities.concretes.CandidateLanguage;

@Service
public class CandidateLanguageManager implements CandidateLanguageService {

	private CandidateLanguageDao candidateLanguageDao;
	
	@Autowired
	public CandidateLanguageManager(CandidateLanguageDao candidateLanguageDao) {
		this.candidateLanguageDao = candidateLanguageDao;
	}

	@Override
	public DataResult<List<CandidateLanguage>> getAll() {
		List<CandidateLanguage> result = this.candidateLanguageDao.findAll();
		return new SuccessDataResult<List<CandidateLanguage>>(result);
	}

	@Override
	public DataResult<List<CandidateLanguage>> getByCandidate_id(int candidateId) {
		List<CandidateLanguage> result = this.candidateLanguageDao.getByCandidate_id(candidateId);
		return new SuccessDataResult<List<CandidateLanguage>>(result);
	}
	
	@Override
	public Result add(CandidateLanguage candidateLanguage) {
		this.candidateLanguageDao.save(candidateLanguage);
		return new SuccessResult();
	}


}
