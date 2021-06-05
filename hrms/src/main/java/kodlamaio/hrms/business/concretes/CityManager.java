package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CityService;
import kodlamaio.hrms.core.utilities.constants.Messages.EUVersionMessages;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorDataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CityDao;
import kodlamaio.hrms.entities.concretes.City;

@Service
public class CityManager implements CityService {

	private CityDao cityDao;

	@Autowired
	public CityManager(CityDao cityDao) {
		super();
		this.cityDao = cityDao;
	}

	@Override
	public DataResult<List<City>> getAll() {
		
		List<City> result = this.cityDao.findAll();
		
		return new SuccessDataResult<List<City>>(
				result,
				EUVersionMessages.CitiesListed);
	}

	@Override
	public Result add(City city) {
		this.cityDao.save(city);
		return new SuccessResult(EUVersionMessages.CityAdded);
	}

	@Override
	public DataResult<City> getById(int id) {
		City city = cityDao.findById(id);
		if (city == null)
			return new ErrorDataResult<City>();
		return new SuccessDataResult<City>(city);
	}

}
