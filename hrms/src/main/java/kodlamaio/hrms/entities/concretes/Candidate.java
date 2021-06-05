package kodlamaio.hrms.entities.concretes;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import kodlamaio.hrms.core.entities.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "candidates")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@PrimaryKeyJoinColumn(name = "user_id", referencedColumnName = "id")
public class Candidate extends User {

	@Column(name = "`first_name`", nullable = false)
	private String firstName;

	@Column(name = "`last_name`", nullable = false)
	private String lastName;

	@Column(name = "`nationality_identity_id`", unique = true, nullable = false)
	private String nationalityIdentityId;

	@Column(name = "`birth_of_date`", nullable = false)
	private LocalDate birthOfDate;

	@JsonIgnore
	@OneToMany(mappedBy = "candidate")
	private List<CandidateSchoolDepartment> candidateSchoolDepartments;

	@JsonIgnore
	@OneToMany(mappedBy = "candidate")
	private List<CandidateLanguage> candidateLanguages;

	@JsonIgnore
	@OneToMany(mappedBy = "candidate")
	private List<CandidateAbility> candidateAbilities;

	@JsonIgnore
	@OneToMany(mappedBy = "candidate")
	private List<CandidateWorkplaceTitle> candidateWorkplaceTitles;

	@JsonIgnore
	@OneToMany(mappedBy = "candidate")
	private List<SocialMedia> socialMedias;

	@JsonIgnore
	@OneToOne(mappedBy = "candidate")
	private CvDetail cvDetail;

	@JsonIgnore
	@OneToOne(mappedBy = "candidate")
	private CandidatePhoto candidatePhoto;

	public Candidate(String firstName, String lastName, String nationalityIdentityId, LocalDate birthOfDate) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.nationalityIdentityId = nationalityIdentityId;
		this.birthOfDate = birthOfDate;
	}

	public Candidate(String email, String password, boolean emailVerified, String emailVerifyCode,
			String firstName, String lastName, String nationalityIdentityId, LocalDate birthOfDate) {
		super(email, password, emailVerified, emailVerifyCode);
		this.firstName = firstName;
		this.lastName = lastName;
		this.nationalityIdentityId = nationalityIdentityId;
		this.birthOfDate = birthOfDate;
	}

}