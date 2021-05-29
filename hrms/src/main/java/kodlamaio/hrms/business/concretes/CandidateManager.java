package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CandidateService;
import kodlamaio.hrms.business.validations.CandidateValidation;
import kodlamaio.hrms.core.adapters.authService.AuthAdapterService;
import kodlamaio.hrms.core.utilities.constants.Messages;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CandidateDao;
import kodlamaio.hrms.entities.concretes.Candidate;

@Service
public class CandidateManager implements CandidateService {

	private CandidateDao candidateDao;
	private AuthAdapterService authAdapterService;

	@Autowired
	public CandidateManager(CandidateDao candidateDao, AuthAdapterService AuthServiceAdapter) {
		this.candidateDao = candidateDao;
		this.authAdapterService = AuthServiceAdapter;
	}

	@Override
	public DataResult<List<Candidate>> getAll() {
		return new SuccessDataResult<List<Candidate>>(this.candidateDao.findAll(), Messages.CandidateListed);
	}

	@Override
	public Result add(Candidate candidate) {

		if (CandidateValidation.birthDateChecker(candidate) && CandidateValidation.firstNameChecker(candidate)
				&& CandidateValidation.lastNameChecker(candidate) && CandidateValidation.isValid(candidate)) {
			if (this.authAdapterService.register(candidate)) {
				this.candidateDao.save(candidate);
				return new SuccessResult(Messages.CandidateAdded);
			} else {
				return new ErrorResult(Messages.CandidateAuthUnsuccessful);
			}
		}
		return new ErrorResult(Messages.ValidationIsIncorrect);

	}

}
