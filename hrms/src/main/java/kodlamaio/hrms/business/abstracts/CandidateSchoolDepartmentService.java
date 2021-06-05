package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.CandidateSchoolDepartment;

public interface CandidateSchoolDepartmentService {
	DataResult<List<CandidateSchoolDepartment>> getAll();

	Result add(CandidateSchoolDepartment candidateSchoolDepartment);

	DataResult<List<CandidateSchoolDepartment>> getByCandidate_candidateIdOrderByDateOfGraduationDesc(int candidateId);
}
