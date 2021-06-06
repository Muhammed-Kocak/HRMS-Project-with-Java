package kodlamaio.hrms.business.concretes;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobAdvertisementService;
import kodlamaio.hrms.core.utilities.constants.Messages.EUVersionMessages;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobAdvertisementDao;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;
import kodlamaio.hrms.entities.dtos.JobAdvertisementForAddDto;

@Service
public class JobAdvertisementManager implements JobAdvertisementService {

	private JobAdvertisementDao jobAdvertisementDao;

	@Autowired
	public JobAdvertisementManager(JobAdvertisementDao jobAdvertisementDao) {
		this.jobAdvertisementDao = jobAdvertisementDao;
	}

	@Override
	public DataResult<List<JobAdvertisement>> getAll() {

		List<JobAdvertisement> result = this.jobAdvertisementDao.findAll();

		return new SuccessDataResult<List<JobAdvertisement>>(result, EUVersionMessages.JobAdvertisementListed);
	}

	@Override
	public DataResult<List<JobAdvertisement>> getByActive() {
		List<JobAdvertisement> result = this.jobAdvertisementDao.getByIsActiveTrue();
		return new SuccessDataResult<List<JobAdvertisement>>(result, EUVersionMessages.JobAdvertisementListedByActive);
	}

	@Override
	public DataResult<List<JobAdvertisement>> getByActive(int pageNo, int pageSize) {

		Pageable pageable = PageRequest.of(pageNo, pageSize);

		List<JobAdvertisement> result = this.jobAdvertisementDao.getByIsActiveTrue(pageable).getContent();
		return new SuccessDataResult<List<JobAdvertisement>>(result, EUVersionMessages.JobAdvertisementPagedByActive);
	}

	@Override
	public DataResult<List<JobAdvertisement>> getByActiveSortedAsc() {

		List<JobAdvertisement> result = this.jobAdvertisementDao.getByIsActiveTrueOrderByLastApplyDateAsc();

		return new SuccessDataResult<List<JobAdvertisement>>(result, EUVersionMessages.JobAdvertisementSortedByActive);
	}

	@Override
	public DataResult<List<JobAdvertisement>> getByActiveSortedDesc() {

		List<JobAdvertisement> result = this.jobAdvertisementDao.getByIsActiveTrueOrderByLastApplyDateDesc();

		return new SuccessDataResult<List<JobAdvertisement>>(result, EUVersionMessages.JobAdvertisementSortedByActive);
	}

//	@Override
//	public DataResult<List<JobAdvertisementForAddDto>> getJobAdvertisementWithEmployer() {
//		List<JobAdvertisementForAddDto> result = this.jobAdvertisementDao.getJobAdvertisementWithEmployer();
//		return new SuccessDataResult<List<JobAdvertisementForAddDto>>(result,
//				EUVersionMessages.JobAdvertisementDtoListed);
//	}

	@Override
	public DataResult<List<JobAdvertisement>> getByActiveTrueAndEmployerCompanyName(String companyName) {
		List<JobAdvertisement> result = this.jobAdvertisementDao.getByIsActiveTrueAndEmployer_companyName(companyName);
		return new SuccessDataResult<List<JobAdvertisement>>(result,
				EUVersionMessages.JobAdvertisementListedByEmployerIdActive);
	}

	@Override
	public Result add(JobAdvertisement jobAdvertisemenet) {
		this.jobAdvertisementDao.save(jobAdvertisemenet);
		return new SuccessResult();
	}

	@Override
	public Result update(int jobAdvertisemenetId, JobAdvertisement jobAdvertisemenet) {

		JobAdvertisement result = this.jobAdvertisementDao.getById(jobAdvertisemenetId);

		result.setActive(jobAdvertisemenet.isActive());

		if (jobAdvertisemenet.getLastApplyDate().isBefore(LocalDate.now())) {
			result.setActive(false);
		}
		this.jobAdvertisementDao.save(result);
		return new SuccessResult();
	}

}
