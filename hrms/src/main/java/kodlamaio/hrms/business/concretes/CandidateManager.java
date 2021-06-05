package kodlamaio.hrms.business.concretes;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CandidateAbilityService;
import kodlamaio.hrms.business.abstracts.CandidateLanguageService;
import kodlamaio.hrms.business.abstracts.CandidateSchoolDepartmentService;
import kodlamaio.hrms.business.abstracts.CandidateService;
import kodlamaio.hrms.business.abstracts.CandidateWorkplaceTitleService;
import kodlamaio.hrms.business.abstracts.CvDetailService;
import kodlamaio.hrms.business.abstracts.SocialMediaService;
import kodlamaio.hrms.core.adapters.authService.FakeMernisAuthServiceAdapter;
import kodlamaio.hrms.core.business.BusinessRules;
import kodlamaio.hrms.core.utilities.constants.Messages.EUVersionMessages;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorDataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CandidateDao;
import kodlamaio.hrms.entities.concretes.Candidate;
import kodlamaio.hrms.entities.dtos.CandidateForRegisterDto;
import kodlamaio.hrms.entities.dtos.CvDto;

@Service
public class CandidateManager implements CandidateService {

	private CandidateDao candidateDao;
	private FakeMernisAuthServiceAdapter fakeMernisAuthServiceAdapter;
	private CandidateWorkplaceTitleService candidateWorkplaceTitleService;
	private CandidateSchoolDepartmentService candidateSchoolDepartmentService;
	private CandidateLanguageService candidateLanguageService;
	private CandidateAbilityService candidateAbilityService;
	private SocialMediaService socialMediaService;
	private CvDetailService cvDetailService;

	public CandidateManager(CandidateDao candidateDao,
			FakeMernisAuthServiceAdapter fakeMernisAuthServiceAdapter,
			CandidateWorkplaceTitleService candidateWorkplaceTitleService,
			CandidateSchoolDepartmentService candidateSchoolDepartmentService,
			CandidateLanguageService candidateLanguageService, CandidateAbilityService candidateAbilityService,
			SocialMediaService socialMediaService, CvDetailService cvDetailService) {
		this.candidateDao = candidateDao;
		this.fakeMernisAuthServiceAdapter = fakeMernisAuthServiceAdapter;
		this.candidateWorkplaceTitleService = candidateWorkplaceTitleService;
		this.candidateSchoolDepartmentService = candidateSchoolDepartmentService;
		this.candidateLanguageService = candidateLanguageService;
		this.candidateAbilityService = candidateAbilityService;
		this.socialMediaService = socialMediaService;
		this.cvDetailService = cvDetailService;
	}

	@Override
	public DataResult<List<Candidate>> getAll() {
		List<Candidate> result = this.candidateDao.findAll();
		return new SuccessDataResult<List<Candidate>>(result, EUVersionMessages.CandidatesListed);
	}

	@Override
	public DataResult<Candidate> getById(int CandidateId) {

		Result rules = BusinessRules.Run(checkUserExistsById(CandidateId));

		if (rules != null) {
			return new ErrorDataResult<Candidate>(rules.getMessage());
		}

		Candidate result = this.candidateDao.findById(CandidateId).get();

		return new SuccessDataResult<Candidate>(result, EUVersionMessages.CandidateListedById);
	}

	@Override
	public DataResult<CvDto> getCandidateResumeByCandidateId(int candidateId) {

		CvDto cvDto = new CvDto();

		cvDto.setCandidate(this.candidateDao.getOne(candidateId));
		cvDto.setCandidateAbilities(this.candidateAbilityService.getByCandidate_id(candidateId).getData());
		cvDto.setCandidateLanguages(this.candidateLanguageService.getByCandidate_id(candidateId).getData());
		cvDto.setCandidateSchoolDepartments(this.candidateSchoolDepartmentService
				.getByCandidate_candidateIdOrderByDateOfGraduationDesc(candidateId).getData());
		cvDto.setCandidateWorkplaceTitles(this.candidateWorkplaceTitleService.getByCandidate_id(candidateId).getData());
		cvDto.setSocialMedias(this.socialMediaService.getByCandidate_id(candidateId).getData());
		cvDto.setCvDetail(this.cvDetailService.getByCandidate_id(candidateId).getData());

		return new SuccessDataResult<CvDto>(cvDto);
	}

	@Override
	public Result add(Candidate candidate) {

		Result rules = BusinessRules.Run(checkUserExists(candidate.getEmail(), candidate.getNationalityIdentityId()),
				this.fakeMernisAuthServiceAdapter.register(new CandidateForRegisterDto()));

		if (rules != null) {
			return rules;
		}

		Result isEmailVerificate = checkEmailVerification(candidate);
		if (!isEmailVerificate.isSuccess()) {
			return isEmailVerificate;
		}

		candidate.setEmailVerified(true);
		this.candidateDao.save(candidate);
		return new SuccessResult(EUVersionMessages.CandidateAdded);
	}

	@Override
	public Result delete(int CandidateId) {

		Result rules = BusinessRules.Run(checkUserExistsById(CandidateId));

		if (rules != null) {
			return rules;
		}

		this.candidateDao.deleteById(CandidateId);

		return new SuccessResult(EUVersionMessages.CandidateDeleted);
	}

	@Override
	public Result update(int CandidateId, Candidate Candidate) {

		Result rules = BusinessRules.Run(checkUserExistsById(CandidateId));

		if (rules != null) {
			return rules;
		}

		Candidate result = getById(CandidateId).getData();

		result.setFirstName(Candidate.getFirstName());
		result.setLastName(Candidate.getLastName());
		result.setPassword(Candidate.getPassword());

		return null;
	}

//	-----------------------------------------------------------------------------

	public Result checkUserExistsById(int CandidateId) {

		Optional<Candidate> result = this.candidateDao.findById(CandidateId);

		boolean isPresent = result.isPresent();

		if (!isPresent) {
			return new ErrorResult(EUVersionMessages.ErrorCandidateNotFound);
		}

		return new SuccessResult();
	}

	@Override
	public Result checkUserExists(String email, String nationalityIdentityId) {

		boolean userEmailExists = this.candidateDao.findByEmail(email).isPresent();
		boolean userNationalityIdExists = this.candidateDao.findByNationalityIdentityId(nationalityIdentityId).isPresent();
		if (userEmailExists || userNationalityIdExists) {
			return new ErrorResult(EUVersionMessages.ErrorCandidatesExist);
		}

		return new SuccessResult();
	}

	// ..
	public Result checkEmailVerification(Candidate Candidate) {

//		String email = Candidate.getEmail();
//
//		Result verificationMailResult = this.verificationManager.verificateMail(email);
//
//		if (!verificationMailResult.isSuccess()) {
//			return verificationMailResult;
//		}
//
//		return verificationMailResult; Farklı bir doğrulama işlemi yapacağım.
		return new SuccessResult();
	}

}
