//package kodlamaio.hrms.business.concretes;
//
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import kodlamaio.hrms.business.abstracts.AuthService;
//import kodlamaio.hrms.business.abstracts.UserService;
//import kodlamaio.hrms.business.abstracts.VerifyActivationCodeService;
//import kodlamaio.hrms.core.adapters.activationService.Activation;
//import kodlamaio.hrms.core.utilities.constants.Messages;
//import kodlamaio.hrms.core.utilities.results.DataResult;
//import kodlamaio.hrms.core.utilities.results.ErrorDataResult;
//import kodlamaio.hrms.core.utilities.results.ErrorResult;
//import kodlamaio.hrms.core.utilities.results.Result;
//import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
//import kodlamaio.hrms.core.utilities.results.SuccessResult;
//import kodlamaio.hrms.entities.concretes.User;
//
//@Service
//public class AuthManager implements AuthService {
//
//	private UserService userService;
//	private VerifyActivationCodeService verifyActivationCodeService;
//	private Activation activation;
//	
//	@Autowired
//	public AuthManager(UserService userService, VerifyActivationCodeService verifyActivationCodeService,
//			Activation activation) {
//		this.userService = userService;
//		this.verifyActivationCodeService = verifyActivationCodeService;
//		this.activation = activation;
//	}
//
//	@Override
//	public DataResult<User> login(User user) {
//		var result = this.activation.Control();
//		if(result.isSuccess()) {
//			var userToCheckResult = this.userService.getUserDetailByMail(user.getEmail());
//			if(!userToCheckResult.isSuccess()) {
//				return new ErrorDataResult<User>(userToCheckResult.getMessage());
//			}
//			var userToCheck = userToCheckResult.getData();
//			if(userToCheck == null) {
//				return new ErrorDataResult<User>(Messages.userNotFound);
//			}
//			return new SuccessDataResult<User>(userToCheck, Messages.successfulLogin);
//		}
//		return new ErrorDataResult<User>(Messages.pendingVerification);
//	}
//
//	@Override
//	public DataResult<User> register(User user) {
//		this.userService.add(user);
//		this.verifyActivationCodeService.add(user);
//		this.activation.Send();
//		return new SuccessDataResult<User>(user, Messages.userRegistered);
//	}
//
//	@Override
//	public Result userCheck(String email) {
//		var result = this.userService.getUserDetailByMail(email);
//		if(!result.isSuccess()) {
//			 return new ErrorResult(result.getMessage());
//		}
//		if (result.getData() != null) {
//			return new ErrorResult(Messages.userAlreadyExists);
//		}
//		return new SuccessResult();
//	}
//
//}
