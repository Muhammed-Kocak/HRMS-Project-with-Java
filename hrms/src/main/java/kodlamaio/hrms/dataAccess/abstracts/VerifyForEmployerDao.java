package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.VerifyForEmployer;

public interface VerifyForEmployerDao extends JpaRepository<VerifyForEmployer,Integer> {

}
