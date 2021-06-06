package kodlamaio.hrms.business.concretes;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import kodlamaio.hrms.business.abstracts.JobPositionService;
import kodlamaio.hrms.core.utilities.constants.Messages.EUVersionMessages;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorDataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobPositionDao;
import kodlamaio.hrms.entities.concretes.JobPosition;

@Service
public class JobPositionManager implements JobPositionService {

	private JobPositionDao jobPositionDao;
	
	@Autowired
	public JobPositionManager(JobPositionDao jobPositionDao) {
		super();
		this.jobPositionDao = jobPositionDao;
	}

	@Override
	public DataResult<List<JobPosition>> getAll() {
		return new SuccessDataResult<List<JobPosition>>(this.jobPositionDao.findAll());
	}

	@Override
	public DataResult<JobPosition> getByName(String positionName) {
		return new SuccessDataResult<JobPosition>(this.jobPositionDao.findByPositionName(positionName));
	}

	@Override
	public Result add(JobPosition jobPosition) {
		if(jobPosition.getPositionName() == null || jobPosition.getPositionName() == "")
			return new ErrorResult(EUVersionMessages.ErrorJobPositionNotFound);
		if(getByName(jobPosition.getPositionName()) != null)
			return new ErrorResult(EUVersionMessages.ErrorWithTheSameName);
		this.jobPositionDao.save(jobPosition);
		return new SuccessResult(EUVersionMessages.JobPositionAdded);
	}

	@Override
	public DataResult<JobPosition> getById(int id) {
		JobPosition jobPosition = jobPositionDao.findById(id);
		if(jobPosition==null) return new ErrorDataResult<JobPosition>();
	    return new SuccessDataResult<JobPosition>(jobPosition);
	}

	@Override
	public Result delete(int jobPositionId) {
		this.jobPositionDao.deleteById(jobPositionId);
		return new SuccessResult(EUVersionMessages.JobPositionDeleted);
	}

	@Override
	public Result update(int jobPositionId, String jobPositionName) {
		JobPosition jobTitle = getById(jobPositionId).getData();
		jobTitle.setPositionName(jobPositionName);
		return new SuccessResult(EUVersionMessages.JobPositionUpdated);
	}
}