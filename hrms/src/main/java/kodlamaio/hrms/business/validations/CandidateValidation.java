package kodlamaio.hrms.business.validations;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import kodlamaio.hrms.entities.concretes.Candidate;
import kodlamaio.hrms.entities.dtos.CandidateForRegisterDto;

public class CandidateValidation {

	public static boolean firstNameChecker(Candidate candidate) {
		if (candidate.getFirstName().isBlank() || candidate.getFirstName() == null) {
			return false;

		}
		return true;

	}

	public static boolean lastNameChecker(Candidate candidate) {
		if (candidate.getLastName().isBlank() || candidate.getLastName() == null) {
			return false;

		}
		return true;
	}

	public static boolean birthDateChecker(Candidate candidate) {
		if (candidate.getBirthOfDate().equals(null)) {
			return false;

		}
		return true;
	}

	public static boolean isValid(CandidateForRegisterDto candidateForRegisterDto) {
		String regex = "^(.+)@(.+)$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(candidateForRegisterDto.getEmail());

		if (candidateForRegisterDto.getFirstName() == null || candidateForRegisterDto.getLastName() == null || candidateForRegisterDto.getEmail() == null
				|| candidateForRegisterDto.getPassword() == null) {
			System.out.println("Boş bırakılamaz");
			return false;
		} else {
			if (!matcher.matches()) {
				System.out.println("E Mail Hatalı");
				return false;
			}

			else {
				if (candidateForRegisterDto.getFirstName().length() < 2 && candidateForRegisterDto.getLastName().length() < 2) {
					if (candidateForRegisterDto.getPassword().length() < 6) {
						System.out.println("Şifreniz en az 6 haneli olmak zorunda.");
						return false;
					}
				}

			}
		}
		return true;
	}
}
