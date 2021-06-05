package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CandidateSchoolDepartmentService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CandidateSchoolDepartmentDao;
import kodlamaio.hrms.entities.concretes.CandidateSchoolDepartment;

@Service
public class CandidateSchoolDepartmentManager implements CandidateSchoolDepartmentService {

	private CandidateSchoolDepartmentDao candidateSchoolDepartmentDao;
	
	@Autowired
	public CandidateSchoolDepartmentManager(CandidateSchoolDepartmentDao candidateSchoolDepartmentDao) {
		this.candidateSchoolDepartmentDao = candidateSchoolDepartmentDao;
	}

	@Override
	public DataResult<List<CandidateSchoolDepartment>> getAll() {
		List<CandidateSchoolDepartment> result = this.candidateSchoolDepartmentDao.findAll();
		return new SuccessDataResult<List<CandidateSchoolDepartment>>(result);
	}

	@Override
	public Result add(CandidateSchoolDepartment jobSeekerSchoolDepartment) {
		this.candidateSchoolDepartmentDao.save(jobSeekerSchoolDepartment);
		return new SuccessResult();
	}

	@Override
	public DataResult<List<CandidateSchoolDepartment>> getByCandidate_candidateIdOrderByDateOfGraduationDesc(
			int candidateId) {
		List<CandidateSchoolDepartment> result = this.candidateSchoolDepartmentDao
				.getByCandidate_idOrderByDateOfGraduationDesc(candidateId);
		return new SuccessDataResult<List<CandidateSchoolDepartment>>(result);
	}

}
