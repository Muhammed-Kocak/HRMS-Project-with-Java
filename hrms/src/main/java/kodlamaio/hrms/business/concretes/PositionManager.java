package kodlamaio.hrms.business.concretes;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sun.istack.NotNull;
import kodlamaio.hrms.business.abstracts.PositionService;
import kodlamaio.hrms.core.utilities.constants.Messages;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorDataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.PositionDao;
import kodlamaio.hrms.entities.concretes.Position;

@Service
public class PositionManager implements PositionService {

	private PositionDao positionDao;

	@Autowired
	public PositionManager(PositionDao positionDao) {
		this.positionDao = positionDao;
	}

	@Override
	public DataResult<List<Position>> getAll() {
		return new SuccessDataResult<List<Position>>(this.positionDao.findAll());
	}

	@Override
	public Result add(@NotNull Position position) {
		DataResult<Boolean> result = exist(position);
		
		if (result.isSuccess()) {
			this.positionDao.save(position);
			return new SuccessResult(Messages.positionAdded);
		} else {
			return new ErrorResult(Messages.positionValid);
		}
	}

	@Override
	public DataResult<Boolean> exist(Position position) {
		List<Position> positions = this.positionDao.findAll();
		
		for (Position positionControl : positions) {
			if(position.getTitle()==positionControl.getTitle()) {
				
				return new SuccessDataResult<Boolean>(true,Messages.positionValid);
			}
		}
		
		return new ErrorDataResult<Boolean>(false);
		
	}
	
	
}
