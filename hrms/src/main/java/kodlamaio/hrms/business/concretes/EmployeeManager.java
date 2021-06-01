package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.EmployeeService;
import kodlamaio.hrms.business.validations.EmployeeValidation;
import kodlamaio.hrms.core.utilities.constants.Messages;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.EmployeeDao;
import kodlamaio.hrms.entities.concretes.Employee;


@Service
public class EmployeeManager implements EmployeeService {

private EmployeeDao employeeDao;
	
	@Autowired
	public EmployeeManager(EmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}

	@Override
	public DataResult<List<Employee>> getAll() {
		return new SuccessDataResult<List<Employee>>(this.employeeDao.findAll(),Messages.employeesListed);
	}

	@Override
	public Result add(Employee employee) {
		boolean result = this.employeeDao.findByEmployerByUser_Email(employee.getEmail());
		if(result) {
			if(EmployeeValidation.firstNameChecker(employee)&&EmployeeValidation.lastNameChecker(employee)) {
				this.employeeDao.save(employee);
				return new SuccessResult(Messages.employeeAdded);
			}
			return new ErrorResult(Messages.ValidationIsIncorrect);
		}
		return new ErrorResult("Böyle bir email yok");
		
	}
	
}
