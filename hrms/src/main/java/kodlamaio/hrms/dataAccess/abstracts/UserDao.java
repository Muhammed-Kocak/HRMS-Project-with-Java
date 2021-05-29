package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.hrms.entities.concretes.User;


public interface UserDao extends JpaRepository<User, Integer> {

	@Query("From User where email=:userMail")
	User getByUserDetail(String userMail);
}
