package kodlamaio.hrms.entities.concretes;

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
@Table(name = "employees")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@PrimaryKeyJoinColumn(name = "user_id",referencedColumnName = "id")
public class Employee extends User {


	@Column(name = "`first_name`", nullable = false)
	private String firstName;

	@Column(name = "`last_name`", nullable = false)
	private String lastName;

	@Column(name = "`roles`", nullable = false)
	private String roles;
	
}
