package kodlamaio.hrms.business.validations;

import kodlamaio.hrms.entities.concretes.Employee;

public class EmployeeValidation {

	public static boolean firstNameChecker(Employee employee) {
		if (employee.getFirstName().isBlank() || employee.getFirstName() == null) {
			return false;

		}
		return true;

	}

	public static boolean lastNameChecker(Employee employee) {
		if (employee.getLastName().isBlank() || employee.getLastName() == null) {
			return false;

		}
		return true;
	}
}
