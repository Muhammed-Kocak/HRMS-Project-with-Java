package kodlamaio.hrms.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="employers")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Employer extends User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="company_name")
	private String companyName;
	
	@Column(name="web_adress")
	private String webAdress;
	
	@Column(name="phone_number")
	private String phoneNumber;
	
	@Column(name="is_verified")
	private boolean isVerified;
	
	@OneToMany(mappedBy = "company")
    private List<Position> jobPostings;
}
