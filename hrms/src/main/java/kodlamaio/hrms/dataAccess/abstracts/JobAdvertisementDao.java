package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.hrms.entities.concretes.JobAdvertisement;

public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement, Integer> {
	
	@Query("SELECT j FROM JobAdvertisement j WHERE j.isActive=true")
	List<JobAdvertisement> findByIsActiveTrue();

	@Query("SELECT j FROM JobAdvertisement j WHERE j.isActive=true ORDER BY j.dateOfCreate ASC")
	List<JobAdvertisement> findByIsActiveTrueOrderByCreateDate();

	@Query("SELECT j FROM JobAdvertisement j WHERE j.isActive=true AND j.id=?1")
	List<JobAdvertisement> findByIsActiveTrueAndEmployer_UserId(int userId);

	@Query("SELECT j FROM JobAdvertisement j, Employer e WHERE j.id=?1 AND e.id=?2")
	JobAdvertisement findByIdAndEmployer_UserId(int jobAdvertisementId, int employerId);
}
