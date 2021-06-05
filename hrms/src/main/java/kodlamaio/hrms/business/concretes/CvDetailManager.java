package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CvDetailService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CvDetailDao;
import kodlamaio.hrms.entities.concretes.CvDetail;

@Service
public class CvDetailManager implements CvDetailService {
	
	private CvDetailDao cvDetailDao;

	@Autowired
	public CvDetailManager(CvDetailDao cvDetailDao) {
		this.cvDetailDao = cvDetailDao;
	}

	@Override
	public DataResult<CvDetail> getByCandidate_id(int candidate) {
		CvDetail result = this.cvDetailDao.getByCandidate_id(candidate);
		return new SuccessDataResult<CvDetail>(result);
	}

	@Override
	public DataResult<List<CvDetail>> getAll() {
		List<CvDetail> result = this.cvDetailDao.findAll();
		return new SuccessDataResult<List<CvDetail>>(result);
	}

	@Override
	public Result add(CvDetail cvDetail) {
		
//		Map<String, String> uploadResult = (Map<String, String>) this.imageUploadService.save(file).getData();
//		
//		cvDetail.setCvPhotoUrl(uploadResult.get("url"));

		this.cvDetailDao.save(cvDetail);
		return new SuccessResult();
	}

	
}
