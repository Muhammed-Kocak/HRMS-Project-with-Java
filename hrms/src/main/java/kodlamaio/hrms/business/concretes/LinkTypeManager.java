package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.LinkTypeService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.LinkTypeDao;
import kodlamaio.hrms.entities.concretes.LinkType;

@Service
public class LinkTypeManager implements LinkTypeService {

	private LinkTypeDao linkTypeDao;
	
	@Autowired
	public LinkTypeManager(LinkTypeDao linkTypeDao) {
		this.linkTypeDao = linkTypeDao;
	}

	@Override
	public DataResult<List<LinkType>> getAll() {
		List<LinkType> result = this.linkTypeDao.findAll();
		return new SuccessDataResult<List<LinkType>>(result);
	}

	@Override
	public Result add(LinkType linkType) {
		this.linkTypeDao.save(linkType);
		return new SuccessResult();
	}

}
