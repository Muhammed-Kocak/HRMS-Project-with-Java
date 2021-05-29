package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.EmployersActivationForEmployee;

public interface EmployersActivationForEmployeeDao extends JpaRepository<EmployersActivationForEmployee,Integer>{

}
