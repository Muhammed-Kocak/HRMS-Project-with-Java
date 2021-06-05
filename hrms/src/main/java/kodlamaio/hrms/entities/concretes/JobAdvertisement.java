package kodlamaio.hrms.entities.concretes;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="job_advertisement")
public class JobAdvertisement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",nullable = false)
    private int id;

    @Column(name = "description",nullable = false)
    private String description;

    @Column(name = "number_of_open_positions",nullable = false)
    private int numberOfOpenPositions;

    @Column(name = "min_salary",nullable = true)
    private double minSalary;

    @Column(name = "max_salary",nullable = true)
    private double maxSalary;

    @Column(name = "date_of_create",nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dateOfCreate = new Date(System.currentTimeMillis());

    @Column(name="last_apply_date",nullable = false)
    private LocalDate lastApplyDate;

    @Column(name = "is_active",nullable = false)
    private boolean isActive;

    @ManyToOne(fetch = FetchType.LAZY, cascade={ CascadeType.PERSIST, CascadeType.MERGE })
	@JoinColumn(name="city_id")
	private City city;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade={ CascadeType.PERSIST, CascadeType.MERGE })
	@JoinColumn(name="job_position_id")
	private JobPosition jobPosition;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade={ CascadeType.PERSIST, CascadeType.MERGE })
	@JoinColumn(name="employer_id")
	private Employer employer;
	
	public JobAdvertisement(String description, Double minSalary, Double maxSalary, int numberOfOpenPositions,
			LocalDate lastApplyDate, Date dateOfCreate, boolean isActive) {
		super();
		this.description = description;
		this.minSalary = minSalary;
		this.maxSalary = maxSalary;
		this.numberOfOpenPositions = numberOfOpenPositions;
		this.lastApplyDate = lastApplyDate;
		this.dateOfCreate = dateOfCreate;
		this.isActive = isActive;
	}
}

