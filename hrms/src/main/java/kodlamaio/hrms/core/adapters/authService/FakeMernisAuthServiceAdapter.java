package kodlamaio.hrms.core.adapters.authService;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.entities.dtos.CandidateForRegisterDto;

@Service
public class FakeMernisAuthServiceAdapter implements AuthAdapterService{

	@Override
	public Result register(CandidateForRegisterDto candidate) {
		return new SuccessResult();
	}

}
