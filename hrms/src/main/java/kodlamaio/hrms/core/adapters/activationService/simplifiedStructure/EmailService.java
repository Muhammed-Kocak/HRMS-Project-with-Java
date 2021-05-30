package kodlamaio.hrms.core.adapters.activationService.simplifiedStructure;

import kodlamaio.hrms.core.utilities.results.Result;

public interface EmailService {
	Result send(String to, String title, String message);
}
