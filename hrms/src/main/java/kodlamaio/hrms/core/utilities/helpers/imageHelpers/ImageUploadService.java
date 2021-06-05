package kodlamaio.hrms.core.utilities.helpers.imageHelpers;

import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrms.core.utilities.results.DataResult;

public interface ImageUploadService {
	
	DataResult<?> save(MultipartFile image);

}