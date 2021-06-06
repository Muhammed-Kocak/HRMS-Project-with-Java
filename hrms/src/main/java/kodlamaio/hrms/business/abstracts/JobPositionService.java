package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobPosition;

public interface JobPositionService {
	DataResult<List<JobPosition>> getAll();

	DataResult<JobPosition> getById(int jobPositionId);

	DataResult<JobPosition> getByName(String jobPositionName);

	Result add(JobPosition jobPosition);

	Result delete(int jobPositionId);

	Result update(int jobPositionId, String jobPositionName);

}
