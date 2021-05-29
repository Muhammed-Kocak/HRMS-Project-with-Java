//package kodlamaio.hrms.business.concretes;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import kodlamaio.hrms.business.abstracts.VerifyActivationCodeService;
//import kodlamaio.hrms.core.utilities.constants.Messages;
//import kodlamaio.hrms.core.utilities.results.DataResult;
//import kodlamaio.hrms.core.utilities.results.Result;
//import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
//import kodlamaio.hrms.core.utilities.results.SuccessResult;
//import kodlamaio.hrms.entities.concretes.User;
//import kodlamaio.hrms.entities.concretes.VerifyActivationCode;
//
//@Service
//public class VerifyActivationCodeManager implements VerifyActivationCodeService {
//
//	private VerifyActivationCode verifyActivationCode;
//
//	@Autowired
//	public VerifyActivationCodeManager(VerifyActivationCode verifyActivationCode) {
//		this.verifyActivationCode = verifyActivationCode;
//	}
//
//	@Override
//	public Result add(User user) {
//		this.generatedCode(user);
//		this.verifyActivationCode.setActivationCode(verifyActivationCode.getActivationCode());
//		this.verifyActivationCode.setId(user.getId());
//		this.verifyActivationCode.setVerified(false);
//		return new SuccessResult(Messages.pendingVerification);
//	}
//
//	@Override
//	public DataResult<String> generatedCode(User user) {
//		int random = (int) Math.floor(Math.random() * 9999);
//		String dogrulamaKodu = user.getEmail().substring(0, 1) + "" + user.getId() + ""
//				+ user.getEmail().substring(0, 2) + "" + random;
//		return new SuccessDataResult<String>(dogrulamaKodu, Messages.codeGenerated);
//	}
//
//}
