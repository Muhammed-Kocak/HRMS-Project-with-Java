//package kodlamaio.hrms.business.concretes;
//
//
//import kodlamaio.hrms.core.utilities.constants.Messages;
//import kodlamaio.hrms.core.utilities.results.Result;
//import kodlamaio.hrms.core.utilities.results.SuccessResult;
//import kodlamaio.hrms.entities.concretes.User;
//import kodlamaio.hrms.entities.concretes.VerifyForCandidate;
//
//public class VerifyForCandidateManager extends VerifyActivationCodeManager{
//
//	private VerifyForCandidate verifyForCandidate;
//	
//	public VerifyForCandidateManager(VerifyForCandidate verifyForCandidate) {
//		super(verifyForCandidate);
//		this.verifyForCandidate = verifyForCandidate;
//	}
//
//	@Override
//	public Result add(User user){
//		this.generatedCode(user);
//		this.verifyForCandidate.setCandidatesId(user.getId());
//		this.verifyForCandidate.setActivationCode(verifyForCandidate.getActivationCode());
//		this.verifyForCandidate.setId(user.getId());
//		this.verifyForCandidate.setVerified(false);
//		return new SuccessResult(Messages.pendingVerification);
//	}
//
//}
