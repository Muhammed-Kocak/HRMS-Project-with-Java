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
@Table(name="verify_for_candidates")
@AllArgsConstructor
@NoArgsConstructor
public class VerifyForCandidate{
	
	@Id
	@Column(name="id")
	private int id;
	
	
	@Column(name="candidates_id")
	private int candidatesId;

}
