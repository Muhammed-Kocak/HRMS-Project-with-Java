package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.hrms.entities.concretes.JobAdvertisement;
import kodlamaio.hrms.entities.dtos.JobAdvertisementForAddDto;

public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement, Integer> {

	List<JobAdvertisement> getByActiveTrue();

	Page<JobAdvertisement> getByActiveTrue(Pageable pageable);

	List<JobAdvertisement> getByActiveTrueOrderByLastApplyDateAsc();

	List<JobAdvertisement> getByActiveTrueOrderByLastApplyDateDesc();

	List<JobAdvertisement> getByActiveTrueAndEmployer_companyName(String companyName);

	@Query("Select new kodlamaio.hrms.entities.dtos."
			+ "JobAdvertisementForAddDto(e.companyName, t.name, cty.cityName, j.numberOfOpenPositions, j.dateOfCreate, j.lastApplyDate) "
			+ "from JobAdvertisement j " + "Inner join j.jobPosition t " + "Inner join j.employer e "
			+ "Inner join j.city cty")

	List<JobAdvertisementForAddDto> getJobAdvertisementWithEmployer();
}
