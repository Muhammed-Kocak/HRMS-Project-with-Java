package kodlamaio.hrms.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@Table(name = "Employers")
@EqualsAndHashCode(callSuper = false)
@PrimaryKeyJoinColumn(name = "user_id", referencedColumnName = "id")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler", "jobAdvertisements" })
public class Employer extends User {

	@Column(name = "`company_name`")
	private String companyName;

	@Column(name = "`phone_number`")
	private String phoneNumber;

	@Column(name = "`is_verified`")
	private boolean isVerified;

	@Column(name = "`web_adress`")
	private String webAdress;

	@OneToMany(mappedBy = "employer", fetch = FetchType.LAZY)
	private List<JobAdvertisement> jobAdvertisements;

	public Employer() {
		
	}

	public Employer(String email, String password, boolean emailVerified, String emailVerifyCode,
			String companyName, String phoneNumber, boolean isVerified, String webAdress) {
		super(email, password, emailVerified, emailVerifyCode);
		this.companyName = companyName;
		this.phoneNumber = phoneNumber;
		this.isVerified = isVerified;
		this.webAdress = webAdress;
	}

}
