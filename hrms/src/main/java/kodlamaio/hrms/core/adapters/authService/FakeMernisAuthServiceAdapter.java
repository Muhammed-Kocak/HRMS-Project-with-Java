package kodlamaio.hrms.core.adapters.authService;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.entities.concretes.Candidate;

@Service
public class FakeMernisAuthServiceAdapter implements AuthAdapterService{

	@Override
	public boolean register(Candidate candidate) {
		return true;
	}

}
