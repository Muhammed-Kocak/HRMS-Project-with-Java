package kodlamaio.hrms.entities.concretes;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name="candidates")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@PrimaryKeyJoinColumn(name = "user_id",referencedColumnName = "id")
public class Candidate extends User{
	
	
	@Column(name="`first_name`",nullable=false)
	private String firstName;
	
	@Column(name="`last_name`",nullable=false)
	private String lastName;
	
	
	@Column(name="`nationality_identity_id`",unique=true,nullable=false)
	private String nationalityIdentityId;
	
	@Column(name="`birth_of_date`",nullable=false)
	private Date birthOfDate;

	public Candidate(int id, String email, String password, boolean emailVerified, String emailVerifyCode,
			String firstName, String lastName, String nationalityIdentityId, Date birthOfDate) {
		super(id, email, password, emailVerified, emailVerifyCode);
		this.firstName = firstName;
		this.lastName = lastName;
		this.nationalityIdentityId = nationalityIdentityId;
		this.birthOfDate = birthOfDate;
	}

}