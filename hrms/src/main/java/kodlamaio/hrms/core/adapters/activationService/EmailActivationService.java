package kodlamaio.hrms.core.adapters.activationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;

@Service
public class EmailActivationService implements Activation{

	@Autowired
	public EmailActivationService() {
		
	}
	
	//To be Refactor
	@Override
	public Result Send() {
		return new SuccessResult("Kod Gönderildi");
	}

	@Override
	public Result Control() {
		return new SuccessResult("Kontrol edildi"+" "+"Giriş başarısız activasyon kodu yanlış");
	}

}
