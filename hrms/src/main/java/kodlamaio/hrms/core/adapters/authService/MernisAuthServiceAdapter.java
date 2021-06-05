package kodlamaio.hrms.core.adapters.authService;

import java.rmi.RemoteException;

import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.entities.dtos.CandidateForRegisterDto;
import tr.gov.nvi.tckimlik.WS.KPSPublicSoap;
import tr.gov.nvi.tckimlik.WS.KPSPublicSoapProxy;

public class MernisAuthServiceAdapter implements AuthAdapterService{
	
	@Override
	public Result register(CandidateForRegisterDto candidate){
		KPSPublicSoap proxy = new KPSPublicSoapProxy();
		try {
			proxy.TCKimlikNoDogrula(
					Long.parseLong(candidate.getNationalityIdentityId()),
					candidate.getFirstName(),
					candidate.getLastName(),
					candidate.getBirthOfDate().getYear());
			return new SuccessResult();
		} catch (NumberFormatException | RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ErrorResult();
		}
	}

}

