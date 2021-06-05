package kodlamaio.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.AuthService;
import kodlamaio.hrms.business.abstracts.CandidateService;
import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.core.utilities.constants.Messages.EUVersionMessages;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.entities.concretes.Candidate;
import kodlamaio.hrms.entities.concretes.Employer;
import kodlamaio.hrms.entities.dtos.CandidateForRegisterDto;
import kodlamaio.hrms.entities.dtos.EmployerForRegisterDto;

@Service
public class AuthManager implements AuthService {

	private CandidateService candidateService;
	private EmployerService employerService;
	
	@Autowired
	public AuthManager(
			CandidateService candidateService,
			EmployerService employerService) {
		this.candidateService = candidateService;
		this.employerService = employerService;
	}

	@Override
	public Result CandidateRegister(CandidateForRegisterDto candidateDto) {
		
		if (candidateDto.getFirstName().equals(null) &&
				candidateDto.getLastName().equals(null) &&
				candidateDto.getEmail().equals(null) &&
				candidateDto.getNationalityIdentityId().equals(null) &&
				candidateDto.getPassword().equals(null) &&
				candidateDto.getVerifyPassword().equals(null)
				) {
			return new SuccessResult();
		}
		
		if (!candidateDto.getPassword().equals(candidateDto.getVerifyPassword())) {
			return new ErrorResult(EUVersionMessages.ErrorPasswordConfirm);
		}
		Result result = this.candidateService.add(new Candidate(
				candidateDto.getEmail(),
				candidateDto.getPassword(),
				false,
				"123456", //TO DO verifiy code gelecek 
				candidateDto.getFirstName(),
				candidateDto.getLastName(),
				candidateDto.getNationalityIdentityId(),
				candidateDto.getBirthOfDate()
		));
		
		return new SuccessResult(result.getMessage());
	}

	@Override
	public Result EmployerRegister(EmployerForRegisterDto employerDto) {
		if (!employerDto.getPassword().equals(employerDto.getVerifyPassword())) {
			return new ErrorResult(EUVersionMessages.ErrorPasswordConfirm);
		}
		
		Result result = this.employerService.add(new Employer(
				employerDto.getEmail(),
				employerDto.getPassword(),
				false,
				"123456", //TO DO verifiy code gelecek 
				employerDto.getCompanyName(),
				employerDto.getPhoneNumber(),
				false,
				employerDto.getWebAdress()
		));
		if (!result.isSuccess()) {
			return new ErrorResult(result.getMessage());
		}
		return new SuccessResult(result.getMessage());
	}

}
