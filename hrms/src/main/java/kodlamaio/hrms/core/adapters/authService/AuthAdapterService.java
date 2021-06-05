package kodlamaio.hrms.core.adapters.authService;

import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.dtos.CandidateForRegisterDto;

public interface AuthAdapterService {

	public Result register(CandidateForRegisterDto candidate);
}
