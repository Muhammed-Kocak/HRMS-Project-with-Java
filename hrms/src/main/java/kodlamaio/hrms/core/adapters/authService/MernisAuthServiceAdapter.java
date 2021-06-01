package kodlamaio.hrms.core.adapters.authService;

import java.rmi.RemoteException;


import kodlamaio.hrms.entities.dtos.CandidateForRegisterDto;
import tr.gov.nvi.tckimlik.WS.KPSPublicSoap;
import tr.gov.nvi.tckimlik.WS.KPSPublicSoapProxy;

public class MernisAuthServiceAdapter implements AuthAdapterService{
	
	@Override
	public boolean register(CandidateForRegisterDto candidate){
		KPSPublicSoap proxy = new KPSPublicSoapProxy();
		try {
			proxy.TCKimlikNoDogrula(
					Long.parseLong(candidate.getNationalityIdentityId()),
					candidate.getFirstName(),
					candidate.getLastName(),
					candidate.getBirthOfDate().getYear());
			return true;
		} catch (NumberFormatException | RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

}

