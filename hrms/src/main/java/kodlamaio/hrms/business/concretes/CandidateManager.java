package kodlamaio.hrms.business.concretes;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CandidateService;
import kodlamaio.hrms.business.abstracts.UserService;
import kodlamaio.hrms.core.adapters.authService.AuthAdapterService;
import kodlamaio.hrms.core.utilities.constants.Messages;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CandidateDao;
import kodlamaio.hrms.entities.concretes.Candidate;
import kodlamaio.hrms.entities.concretes.User;
import kodlamaio.hrms.entities.dtos.CandidateForRegisterDto;

@Service
public class CandidateManager implements CandidateService {

	private CandidateDao candidateDao;
	private UserService userService;
	private AuthAdapterService authAdapterService;

	@Autowired
	public CandidateManager(CandidateDao candidateDao, AuthAdapterService AuthServiceAdapter,UserService userService) {
		this.candidateDao = candidateDao;
		this.userService = userService;
		this.authAdapterService = AuthServiceAdapter;
	}

	@Override
	public DataResult<List<Candidate>> getAll() {
		return new SuccessDataResult<List<Candidate>>(this.candidateDao.findAll(), Messages.CandidateListed);
	}

	@Override
	public Result register(CandidateForRegisterDto candidate) {
		if(runAllRules(candidate) != null) return runAllRules(candidate);
		
	if(!authAdapterService.register(candidate));
	User userToRegister = new User(candidate.getEmail(), candidate.getPassword(),false, UUID.randomUUID().toString());
		userService.add(userToRegister);
		Candidate candidateToRegister = new Candidate(
				userToRegister.getId(), 
				candidate.getFirstName(),
				candidate.getLastName(), 
				candidate.getNationalityIdentityId(),
				candidate.getBirthOfDate()
				);
		this.candidateDao.save(candidateToRegister);
		return new SuccessResult("İş arayan kayıdı başarılı. Lütfen e-posta adresinize gönderilen doğrulama linkiyle hesabınızı doğrulayınız.(NOT: Doğrulama yapılmadan giriş yapılamaz)");
	}
	
	private Result runAllRules(CandidateForRegisterDto candidate) {
		if(isAllFieldsFilled(candidate) != null) return isAllFieldsFilled(candidate);
		if(isPasswordsMatch(candidate) != null) return isPasswordsMatch(candidate);
		if(isUserExistWithEmail(candidate) != null) return isUserExistWithEmail(candidate);
		if(isUserExistWithNationalityId(candidate) != null) return isUserExistWithNationalityId(candidate);
		
		return null;
	}
	
	
	private Result isAllFieldsFilled(CandidateForRegisterDto candidate) {
		if(   candidate.getVerifyPassword() == null || candidate.getVerifyPassword().equals("") 
		  ||  candidate.getPassword() == null  || candidate.getPassword().equals("")
		  ||  candidate.getEmail() == null || candidate.getEmail().equals("")
		  ||  candidate.getNationalityIdentityId() == null ||  candidate.getNationalityIdentityId().equals("")
		  ||  candidate.getLastName() == null || candidate.getLastName().equals("")
		  ||  candidate.getFirstName() == null || candidate.getFirstName().equals("")
		  ||  candidate.getBirthOfDate() == null)
			return new ErrorResult("Tüm alanları doldurmalısınız.");
		return null;
	}
	private Result isPasswordsMatch(CandidateForRegisterDto candidate) {
		if(!candidate.getPassword().equals(candidate.getVerifyPassword())) {
			return new ErrorResult("Şifreler uyuşmalıdır.");
		}
		return null;
	}
	
	private Result isUserExistWithEmail(CandidateForRegisterDto candidate) {
		if(userService.getByEmail(candidate.getEmail()).getData() != null)
			return new ErrorResult("Bu e-posta adresiyle başka bir kullanıcı mevcut.");
		return null;
	}
	private Result isUserExistWithNationalityId(CandidateForRegisterDto candidate) {
		if(candidateDao.findByNationalityId(candidate.getNationalityIdentityId()) != null)
			return new ErrorResult("Bu TCKN ile başka bir kullanıcı mevcut.");
		return null;
	}

}
