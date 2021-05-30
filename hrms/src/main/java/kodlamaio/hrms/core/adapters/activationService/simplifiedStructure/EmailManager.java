package kodlamaio.hrms.core.adapters.activationService.simplifiedStructure;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;

@Service
public class EmailManager implements EmailService{

	@Override
	public Result send(String to, String title, String message) {
		return new SuccessResult("E-posta başarıyla gönderildi.");
	}

}
