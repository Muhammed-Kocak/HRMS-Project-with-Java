package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.core.business.BusinessRules;
import kodlamaio.hrms.core.utilities.constants.Messages.EUVersionMessages;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.EmployerDao;
import kodlamaio.hrms.entities.concretes.Employer;

@Service
public class EmployerManager implements EmployerService {

	private EmployerDao employerDao;
	

	@Autowired
	public EmployerManager(
			EmployerDao employerDao) {
		this.employerDao = employerDao;
	}

	@Override
	public DataResult<List<Employer>> getAll() {
		List<Employer> result = this.employerDao.findAll();
		return new SuccessDataResult<List<Employer>>(result, EUVersionMessages.EmployersListed);
	}

	@Override
	public DataResult<Employer> getById(int employerId) {
		return null;
	}

	@Override
	public Result add(Employer employer) {
			
		
		Result rules = BusinessRules.Run(
				checkEmployerExists(employer.getEmail())
		);
		if(rules != null) {
			return rules;
		}
		
		Result isEmailVerificate = checkEmailVerification(employer);		
		if(!isEmailVerificate.isSuccess()) {
			return isEmailVerificate;
		}
		
		Result isConfirm = checkEmployeesConfirmation(employer);
		if(!isConfirm.isSuccess()) {
			return isConfirm;
		}
		
		employer.setVerified(true);
		employerDao.save(employer);
		
		return new SuccessResult(EUVersionMessages.EmployerAdded);
	}

	@Override
	public Result delete(int employerId) {
		return null;
	}
	
	public Result checkEmployeesConfirmation(Employer employer) {
//		Result employerVerificationResult = this.verificationManager
//				.employerVerificationByEmployee(employer);
//		if (!employerVerificationResult.isSuccess()) {
//			return new ErrorResult(employerVerificationResult.getMessage());
		
//		} //TO DO verification işlemleri değiştirilecek
//		
		return new SuccessResult();
	}
	
	public Result checkEmployerExists(String email) {
		boolean employerExists = this.employerDao
				.findByEmail(email)
				.isPresent();
		if (employerExists) {
			return new ErrorResult(EUVersionMessages.ErrorEmployerExists);
		}
		
		return new SuccessResult();
	}
	
	public Result checkEmailVerification(Employer company) {
		
//		String email = company.getEmail();
//		
//		Result verificationMailResult = this.verificationManager
//				.verificateMail(email);
//		
//		if (!verificationMailResult.isSuccess()) {
//			return verificationMailResult;
//		}
		return new SuccessResult();
	
			//TO DO verification işlemleri değiştirilecek
	}

}