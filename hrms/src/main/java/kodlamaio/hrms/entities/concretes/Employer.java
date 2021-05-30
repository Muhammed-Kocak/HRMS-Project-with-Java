package kodlamaio.hrms.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name="Employers")
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","jobAdvertisements"})
public class Employer extends User{
	
	@Id
	@Column(name="`user_id`")
	private int userId;

	@Column(name="`company_name`")
	private String companyName;
	
	@Column(name="`phone_number`")
	private String phoneNumber;
	
	@Column(name="`is_verified`")
	private boolean isVerified;
	
	@Column(name="`web_adress`")
	private String webAdress;
	
	@OneToOne(fetch = FetchType.LAZY)	
	@JoinColumn(name="`user_id`")
	private User user;
	
	@OneToMany(mappedBy="employer",fetch = FetchType.LAZY)
	private List<JobAdvertisement> jobAdvertisements;
	
	public Employer(int userId, String companyName, String phoneNumber, boolean isVerified, String webAdress) {
		this.userId = userId;
		this.companyName = companyName;
		this.phoneNumber = phoneNumber;
		this.isVerified = isVerified;
		this.webAdress = webAdress;
	}
}
