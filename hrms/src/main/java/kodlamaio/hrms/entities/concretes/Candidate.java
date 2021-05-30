package kodlamaio.hrms.entities.concretes;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name="candidates")
@AllArgsConstructor
@NoArgsConstructor
public class Candidate extends User{
	
	@Id
	@Column(name="`user_id`",nullable=false)
	private int userId;
	
	@Column(name="`first_name`",nullable=false)
	private String firstName;
	
	@Column(name="`last_name`",nullable=false)
	private String lastName;
	
	
	@Column(name="`nationality_identity_id`",unique=true,nullable=false)
	private String nationalityIdentityId;
	
	@Column(name="`birth_of_date`",nullable=false)
	private Date birthOfDate;
	
	@OneToOne(fetch = FetchType.LAZY)	
	@JoinColumn(name="`id`")
	private User user;

	public Candidate(int userId, String firstName, String lastName, String nationalityIdentityId, Date birthOfDate) {
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.nationalityIdentityId = nationalityIdentityId;
		this.birthOfDate = birthOfDate;
	}
}