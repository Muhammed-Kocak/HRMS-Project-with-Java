package kodlamaio.hrms.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployerForRegisterDto {
	private String companyName;
	private String phoneNumber;
	private String webAdress;
	private String email;
	private String password;
	private String verifyPassword;
}
