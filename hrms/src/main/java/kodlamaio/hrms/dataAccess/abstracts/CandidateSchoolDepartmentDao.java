package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.CandidateSchoolDepartment;

public interface CandidateSchoolDepartmentDao extends JpaRepository<CandidateSchoolDepartment, Integer> {
	
//	TODO: JobSeeker Id ye göre JobSeekerSchoolDepartment listesi getir,
//	 ancak mezuniyet tarihine göre sıralanmış olucak.
	
	List<CandidateSchoolDepartment> getByCandidate_idOrderByDateOfGraduationDesc(
			int candidateId);
}