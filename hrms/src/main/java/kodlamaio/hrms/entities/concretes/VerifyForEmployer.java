package kodlamaio.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name="verify_for_employers")
@AllArgsConstructor
@NoArgsConstructor
public class VerifyForEmployer extends VerifyActivationCode{

	@Id
	@Column(name="id")
	private int id;
	
	@Column(name="employer_id")
	private int employerId;

}