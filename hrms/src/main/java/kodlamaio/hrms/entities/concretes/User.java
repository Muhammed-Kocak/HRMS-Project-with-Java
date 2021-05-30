package kodlamaio.hrms.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Data
@Table(name="users")
@AllArgsConstructor
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
public class User{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="email")
	private String email;
	
	@Column(name="password")
	private String password;
	
	@Column(name="emailVerified",nullable=false)
	private boolean emailVerified;

	@Column(name="emailVerifyCode",nullable=false)
	private String emailVerifyCode;
	
	public User(String email, String password, boolean emailVerified, String emailVerifyCode) {
		this.email = email;
		this.password = password;
		this.emailVerified = emailVerified;
		this.emailVerifyCode = emailVerifyCode;
	}
}
