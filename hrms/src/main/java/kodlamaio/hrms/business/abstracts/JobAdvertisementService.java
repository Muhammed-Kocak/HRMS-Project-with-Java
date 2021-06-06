package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;
import kodlamaio.hrms.entities.dtos.JobAdvertisementForAddDto;

public interface JobAdvertisementService {
	DataResult<List<JobAdvertisement>> getAll();

	DataResult<List<JobAdvertisement>> getByActive();

	DataResult<List<JobAdvertisement>> getByActive(int pageNo, int pageSize);

	DataResult<List<JobAdvertisement>> getByActiveSortedAsc();

	DataResult<List<JobAdvertisement>> getByActiveSortedDesc();

//	DataResult<List<JobAdvertisementForAddDto>> getJobAdvertisementWithEmployer();

	DataResult<List<JobAdvertisement>> getByActiveTrueAndEmployerCompanyName(String companyName);

	Result add(JobAdvertisement jobAdvertisemenet);

	Result update(int jobAdvertisemenetId, JobAdvertisement jobAdvertisemenet);
}
