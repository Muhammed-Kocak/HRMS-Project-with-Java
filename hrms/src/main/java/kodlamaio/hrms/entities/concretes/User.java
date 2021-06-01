package kodlamaio.hrms.entities.concretes;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name="users")
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isEmailVerified() {
		return emailVerified;
	}

	public void setEmailVerified(boolean emailVerified) {
		this.emailVerified = emailVerified;
	}

	public String getEmailVerifyCode() {
		return emailVerifyCode;
	}

	public void setEmailVerifyCode(String emailVerifyCode) {
		this.emailVerifyCode = emailVerifyCode;
	}

	public User() {
		
	}
	
	public User(int id, String email, String password, boolean emailVerified, String emailVerifyCode) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
		this.emailVerified = emailVerified;
		this.emailVerifyCode = emailVerifyCode;
	}
	
	public User(String email, String password, boolean emailVerified, String emailVerifyCode) {
		this.email = email;
		this.password = password;
		this.emailVerified = emailVerified;
		this.emailVerifyCode = emailVerifyCode;
	}
	
	
}
