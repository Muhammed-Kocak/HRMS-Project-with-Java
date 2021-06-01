package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import kodlamaio.hrms.entities.concretes.Employee;

@Repository
public interface EmployeeDao extends JpaRepository<Employee, Integer> {

	@Query("SELECT s FROM Employee s WHERE s.email=?1")
	boolean findByEmployerByUser_Email(String email);
}
