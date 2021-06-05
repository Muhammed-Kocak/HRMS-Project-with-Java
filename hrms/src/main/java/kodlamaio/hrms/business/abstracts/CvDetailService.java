package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.CvDetail;

public interface CvDetailService {
	
	DataResult<List<CvDetail>> getAll();
	
	DataResult<CvDetail> getByCandidate_id(int candidate);

	Result add(CvDetail cvDetail);
	
//	Result add(CvDetail cvDetail, MultipartFile file);
//	MultipartFile file
	
}
