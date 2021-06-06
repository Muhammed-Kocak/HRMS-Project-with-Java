package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.hrms.entities.concretes.JobAdvertisement;
import kodlamaio.hrms.entities.dtos.JobAdvertisementForAddDto;

public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement, Integer> {

	JobAdvertisement getById(int jobAdvertisemenetId);
	
	List<JobAdvertisement> getByIsActiveTrue();

	Page<JobAdvertisement> getByIsActiveTrue(Pageable pageable);

	List<JobAdvertisement> getByIsActiveTrueOrderByLastApplyDateAsc();

	List<JobAdvertisement> getByIsActiveTrueOrderByLastApplyDateDesc();

	List<JobAdvertisement> getByIsActiveTrueAndEmployer_companyName(String companyName);

//	@Query("Select new kodlamaio.hrms.entities.dtos."
//			+ "JobAdvertisementForAddDto(e.companyName, t.name, cty.cityName, j.numberOfOpenPositions, j.dateOfCreate, j.lastApplyDate) "
//			+ "from JobAdvertisement j " + "Inner join j.jobPosition t " + "Inner join j.employer e "
//			+ "Inner join j.city cty")
//	List<JobAdvertisementForAddDto> getJobAdvertisementWithEmployer();



	
}
