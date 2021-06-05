package kodlamaio.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="social_medias")
public class SocialMedia {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="social_media_id")
	private int socialMediaId;
	
	@Column(name="link")
	private String link;
	
	@ManyToOne
	@JoinColumn(name="id")
	private Candidate candidate;
	
	@ManyToOne
	@JoinColumn(name="link_type_id")
	private LinkType linkType;

}
