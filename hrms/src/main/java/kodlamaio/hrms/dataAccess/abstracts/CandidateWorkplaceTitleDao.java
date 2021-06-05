package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.CandidateWorkplaceTitle;

public interface CandidateWorkplaceTitleDao extends JpaRepository<CandidateWorkplaceTitle, Integer> {
	
	List<CandidateWorkplaceTitle> getByCandidate_id(int candidateId);

}
