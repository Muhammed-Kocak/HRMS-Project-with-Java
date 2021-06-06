package kodlamaio.hrms.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

import kodlamaio.hrms.core.utilities.helpers.imageHelpers.ImageUploadService;
import kodlamaio.hrms.core.utilities.helpers.imageHelpers.cloudinary.CloudinaryImageManager;

@Configuration
public class AppConfiguration {

//    @Bean
//    public ModelMapper modelMapper() {
//        ModelMapper modelMapper = new ModelMapper();
//        return modelMapper;
//    }

//    @Bean
//    public ValidatePersonService validatePersonService(){
//        return new ValidatePersonMernisAdapter();
//    }

//    @Bean
//    public MailService mailService(){
//        return new MailManager();
//    }

	public Environment environment;
	
    @Bean
    public Cloudinary cloudinaryService(){
        return new Cloudinary(ObjectUtils.asMap(
                "cloud_name", "luxxiescienfield",
                "api_key", "363883747994223",
                "api_secret", "rsY_A79LyQ4N9BZkxMhtHUEcGtQ"));
    }

    @Bean
    public ImageUploadService imageService(){
        return new CloudinaryImageManager(cloudinaryService());
    }
}
