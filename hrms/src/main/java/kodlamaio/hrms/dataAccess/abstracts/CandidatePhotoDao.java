package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.CandidatePhoto;

public interface CandidatePhotoDao extends JpaRepository<CandidatePhoto, Integer> {
	
	CandidatePhoto getByCandidate_id(int candidateId);

}
