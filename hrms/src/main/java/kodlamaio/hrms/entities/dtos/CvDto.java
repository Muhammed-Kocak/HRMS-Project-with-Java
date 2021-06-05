package kodlamaio.hrms.entities.dtos;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import kodlamaio.hrms.entities.concretes.Candidate;
import kodlamaio.hrms.entities.concretes.CandidateAbility;
import kodlamaio.hrms.entities.concretes.CandidateLanguage;
import kodlamaio.hrms.entities.concretes.CandidateSchoolDepartment;
import kodlamaio.hrms.entities.concretes.CandidateWorkplaceTitle;
import kodlamaio.hrms.entities.concretes.CvDetail;
import kodlamaio.hrms.entities.concretes.SocialMedia;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CvDto {
	
	@JsonIgnore
	private Candidate candidate;
	
	private List<CandidateSchoolDepartment> candidateSchoolDepartments;
	
	private List<CandidateWorkplaceTitle> candidateWorkplaceTitles;
	
	private List<CandidateLanguage> candidateLanguages;
	
	private List<CandidateAbility> candidateAbilities;
	
	private List<SocialMedia> socialMedias;
	
	private CvDetail cvDetail;
	
}
