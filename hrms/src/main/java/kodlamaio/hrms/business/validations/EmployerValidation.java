package kodlamaio.hrms.business.validations;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import kodlamaio.hrms.entities.concretes.Employer;

public class EmployerValidation {

	private static String Webregex = "^(http:\\/\\/|https:\\/\\/)?(www.)?([a-zA-Z0-9]+).[a-zA-Z0-9]*.[a-z]{3}.?([a-z]+)?$";

	public static boolean result(Employer employer) {
		if (checkCompanyName(employer) &&
				checkWebsite(employer) &&
				isRealPhoneNumber(employer)
				) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean checkCompanyName(Employer employer) {
		if (employer.getCompanyName().isEmpty() || employer.getCompanyName() == null
				|| employer.getCompanyName().length() <= 2 || employer.getCompanyName().length() >= 100) {
			return false;
		} else {
			return true;
		}
	}

	public static boolean checkWebsite(Employer employer) {
		Pattern pattern = Pattern.compile(Webregex);
		Matcher matcher = pattern.matcher(employer.getWebAdress());

		if (!matcher.matches()) {
			return false;
		} else {
			return true;
		}
	}
	
	public static boolean isRealPhoneNumber(Employer employer) {
		String phonePatterns 
	      = "^(\\+\\d{1,3}( )?)?((\\(\\d{3}\\))|\\d{3})[- .]?\\d{3}[- .]?\\d{4}$" 
	      + "|^(\\+\\d{1,3}( )?)?(\\d{3}[ ]?){2}\\d{3}$" 
	      + "|^(\\+\\d{1,3}( )?)?(\\d{3}[ ]?)(\\d{2}[ ]?){2}\\d{2}$";
		
		Pattern pattern = Pattern.compile(phonePatterns);
		Matcher matcher = pattern.matcher(employer.getPhoneNumber());
		if(!matcher.matches()) {
			return false;
		}
		return true;
		
	}

}
