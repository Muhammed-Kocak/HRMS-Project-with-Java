package kodlamaio.hrms.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "cities")
@AllArgsConstructor
@NoArgsConstructor
public class City {

    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "city_name")
    private String cityName;
    
    @OneToMany(mappedBy="city",fetch = FetchType.LAZY)
	private List<JobAdvertisement> jobAdvertisements;
}
