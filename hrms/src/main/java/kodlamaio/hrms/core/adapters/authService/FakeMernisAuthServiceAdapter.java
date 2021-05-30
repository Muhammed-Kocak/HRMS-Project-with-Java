package kodlamaio.hrms.core.adapters.authService;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.entities.concretes.Candidate;
import kodlamaio.hrms.entities.dtos.CandidateForRegisterDto;

@Service
public class FakeMernisAuthServiceAdapter implements AuthAdapterService{

	@Override
	public boolean register(CandidateForRegisterDto candidate) {
		return true;
	}

}
