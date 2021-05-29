package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.VerifyForCandidate;

public interface VerifyForCandidateDao extends JpaRepository<VerifyForCandidate,Integer> {

}
