package kodlamaio.hrms.core.adapters.authService;

import kodlamaio.hrms.entities.dtos.CandidateForRegisterDto;

public interface AuthAdapterService {

	public boolean register(CandidateForRegisterDto candidate);
}
