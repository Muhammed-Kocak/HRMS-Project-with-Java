package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.UserService;
import kodlamaio.hrms.core.adapters.activationService.simplifiedStructure.EmailService;
import kodlamaio.hrms.core.dataAccess.UserDao;
import kodlamaio.hrms.core.entities.User;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;

@Service
public class UserManager implements UserService {

	private UserDao userDao;
	private EmailService emailService;

	@Autowired
	public UserManager(UserDao userDao, EmailService emailService) {
		super();
		this.userDao = userDao;
		this.emailService = emailService;
	}

	@Override
	public DataResult<List<User>> getAll() {
		return new SuccessDataResult<List<User>>(userDao.findAll());
	}

	@Override
	public DataResult<User> getByEmail(String email) {
		return new SuccessDataResult<User>(userDao.findByEmail(email));
	}

	@Override
	public Result add(User user) {
		this.userDao.save(user);
		this.emailService.send(user.getEmail(), "Doğrulama Linki",
				"HRMS Sistemine hoşgeldiniz. " + "Aşşağıdaki linke tıklayarak üyeliğinizi doğrulayabilirsiniz \n "
						+ "www.localhost:8080/api/users/verify?email=" + user.getEmail() + "&verifycode="
						+ user.getEmailVerifyCode());
		return new SuccessResult();
	}

	@Override
	public Result verifyUser(String email, String verificationCode) {
		boolean user = userDao.findByEmail(email).isPresent();
		if (!user)
			return new ErrorResult("Doğrulama başarısız lütfen bilgileri doğru girdiğinizden emin olun.");

		user.setEmailVerified(true);
		userDao.save(user);
		return new SuccessResult("Kullanıcı e-postası başarıyla doğrulandı.");
		
		//TO DO düzenleme yapılacak
	}

}
