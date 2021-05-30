package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;
import kodlamaio.hrms.entities.dtos.JobAdvertisementForAddDto;

public interface JobAdvertisementService {
	DataResult<List<JobAdvertisement>> findByIsActiveTrue();

	DataResult<List<JobAdvertisement>> findByIsActiveTrueOrderByCreateDate();

	DataResult<List<JobAdvertisement>> findByEmployer_EmployerId(int employerId);

	Result addNew(JobAdvertisementForAddDto jobAdvertisement);

	Result changeStatus(int advertisementId, int employerId);
}
