package kodlamaio.hrms.business.validations;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import kodlamaio.hrms.entities.concretes.User;

public class UserValidation {

	public static boolean isValid(User user) {
		String regex = "^(.+)@(.+)$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(user.getEmail());

		if (user.getEmail() == null || user.getPassword() == null) {
			System.out.println("Boş bırakılamaz");
			return false;
		} else {
			if (!matcher.matches()) {
				System.out.println("E Mail Hatalı");
				return false;
			}

			else if (user.getPassword().length() < 6) {

				System.out.println("Şifreniz en az 6 haneli olmak zorunda.");
				return false;
			}

		}
		return true;
	}
}
