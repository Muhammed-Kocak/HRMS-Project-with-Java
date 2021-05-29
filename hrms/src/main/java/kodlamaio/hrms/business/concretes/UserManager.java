package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sun.istack.NotNull;

import kodlamaio.hrms.business.abstracts.UserService;
import kodlamaio.hrms.business.validations.UserValidation;
import kodlamaio.hrms.core.utilities.constants.Messages;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.UserDao;
import kodlamaio.hrms.entities.concretes.User;

@Service
public class UserManager implements UserService {

	private UserDao userDao;

	@Autowired
	public UserManager(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public DataResult<List<User>> getAll() {
		return new SuccessDataResult<List<User>>(this.userDao.findAll(), Messages.usersListed);
	}

	@Override
	public Result add(@NotNull User user) {
		if (UserValidation.isValid(user)) {
			var result = this.checkUser(user.getEmail());
			if (!result.isSuccess()) {
				return new ErrorResult(result.getMessage());
			}
			this.userDao.save(user);
			return new SuccessResult(Messages.userAdded);
		}
		return new ErrorResult(Messages.ValidationIsIncorrect);
	}

	@Override
	public Result checkUser(@NotNull String email) {

		var result = this.userDao.getByUserDetail(email);
		if (result.getEmail() != null) {
			return new ErrorResult(Messages.userValid);
		}
		return new SuccessResult();
	}

	@Override
	public DataResult<User> getUserDetailByMail(String userMail) {
		return new SuccessDataResult<User>(this.userDao.getByUserDetail(userMail));
	}

}
