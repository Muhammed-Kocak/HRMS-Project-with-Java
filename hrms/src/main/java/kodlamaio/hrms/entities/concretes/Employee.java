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
@Table(name="employees")
@AllArgsConstructor
@NoArgsConstructor
public class Employee extends User{
	@Id
	@Column(name="`user_id`",nullable=false)
	private int userId;

	@Column(name="`roles`",nullable=false)
	private String roles;
	
	@Column(name="`first_name`",nullable=false)
	private String firstName;
	
	@Column(name="`last_name`",nullable=false)
	private String lastName;
	
}
