package kodlamaio.hrms.entities.concretes;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "verify_activation_codes")
@AllArgsConstructor
@NoArgsConstructor
public class VerifyActivationCode {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;


	@Column(name = "activation_code")
	private String activationCode;

	@Column(name = "is_verified")
	private boolean isVerified;
	
	@Column(name = "confirm_date")
	private LocalDate date;
	
	@Column(name = "verification_type_id")
	private LocalDate verificationTypeId;

}
