package kodlamaio.hrms.dataAccess.abstracts;

import java.util.Optional;

import kodlamaio.hrms.core.dataAccess.UserDao;
import kodlamaio.hrms.entities.concretes.Candidate;

public interface CandidateDao extends UserDao<Candidate, Integer> {
	
	Optional<Candidate> findByNationalityIdentityId(String nationalityIdentityId);
}
