package io.kushal.movieflix.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table
@NamedQueries(
		{
			@NamedQuery(name = "UserRating.AvgRating", query = "SELECT AVG(u.rating) FROM UserRating u WHERE u.title =:pTitle"),
		}
)
public class UserRating {
	@Id
	@GenericGenerator(name = "system-uuid", strategy = "uuid2")
	@GeneratedValue(generator = "system-uuid")
	private String rateID;
	private String ratedBy;
	private String rating;
	private String title;
	
	@Temporal(TemporalType.TIMESTAMP)
    @Column(updatable=false)
    private Date rateTime;

    @PrePersist
    protected void onCreate() {
    	rateTime = new Date();
    }

	public String getRateID() {
		return rateID;
	}

	public String getRatedBy() {
		return ratedBy;
	}

	public void setRatedBy(String ratedBy) {
		this.ratedBy = ratedBy;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getRateTime() {
		return rateTime;
	}

	public void setRateTime(Date rateTime) {
		this.rateTime = rateTime;
	}
}
