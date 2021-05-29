package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.VerifyActivationCode;

public interface VerifyActivationCodeDao extends JpaRepository<VerifyActivationCode, Integer> {

}
