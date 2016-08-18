package io.kushal.movieflix.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table
@NamedQueries(
		{
			@NamedQuery(name="Title.topTitles", query="SELECT t from Title t WHERE t.type =:pType order by t.imdbRating DESC"),
			@NamedQuery(name="Title.findByTitle",query="SELECT t FROM Title t WHERE t.title=:pTitle"),
			@NamedQuery(name="Title.sortByVotes", query = "SELECT t from Title t ORDER BY t.imdbVotes DESC"),
			@NamedQuery(name="Title.sortByRating", query = "SELECT t from Title t ORDER BY t.imdbRating DESC"),
			@NamedQuery(name="Title.sortByYear", query = "SELECT t from Title t ORDER BY t.year DESC"),
			@NamedQuery(name="Title.filterByType", query="SELECT t from Title t WHERE t.type = :pType ORDER BY t.imdbRating DESC"),
			@NamedQuery(name="Title.filterByGenre", query="SELECT t from Title t WHERE t.genre like :pGenre ORDER BY t.imdbRating DESC"),
			@NamedQuery(name="Title.filterByYear", query="SELECT t from Title t WHERE t.year = :pYear ORDER BY t.imdbRating DESC")
		}
		
)

public class Title {

	@Id
	@Column(unique=true)
	private String imdbID;
	@Column(name="Title")
	private String title;
	@Column(name="Year")
	private String year;
	@Column(name="Rated")
	private String rated;
	@Column(name="Released")
	private String released;
	@Column(name="Runtime")
	private String runTime;
	@Column(name="Genre")
	private String genre;
	@Column(name="Director")
	private String director;
	@Column(name="Writer")
	private String writer;
	@Column(name="Actors")
	private String actors;
	@Column(name="Plot")
	private String plot;
	@Column(name="Language")
	private String language;
	@Column(name="Country")
	private String country;
	@Column(name="Awards")
	private String awards;
	@Column(name="Poster")
	private String poster;
	@Column(name="Metascore")
	private String metascore;
	private String imdbRating;
	private String imdbVotes;
	@Column(name="Type")
	private String type;
	
	@Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CreatedOn", updatable=false)
    private Date created;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "LastUpdated")
    private Date updated;

    @PrePersist
    protected void onCreate() {
    updated = created = new Date();
    }

    @PreUpdate
    protected void onUpdate() {
    updated = new Date();
    }
    
    
	public String getImdbID() {
		return imdbID;
	}

	public void setImdbID(String imdbID) {
		this.imdbID = imdbID;
	}

	@JsonProperty("Title")
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@JsonProperty("Year")
	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	@JsonProperty("Rated")
	public String getRated() {
		return rated;
	}

	public void setRated(String rated) {
		this.rated = rated;
	}

	@JsonProperty("Released")
	public String getReleased() {
		return released;
	}

	public void setReleased(String released) {
		this.released = released;
	}

	@JsonProperty("Runtime")
	public String getRunTime() {
		return runTime;
	}

	public void setRunTime(String runTime) {
		this.runTime = runTime;
	}

	@JsonProperty("Genre")
	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	@JsonProperty("Director")
	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	@JsonProperty("Writer")
	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	@JsonProperty("Actors")
	public String getActors() {
		return actors;
	}

	public void setActors(String actors) {
		this.actors = actors;
	}

	@JsonProperty("Plot")
	public String getPlot() {
		return plot;
	}

	public void setPlot(String plot) {
		this.plot = plot;
	}

	@JsonProperty("Language")
	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	@JsonProperty("Country")
	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@JsonProperty("Awards")
	public String getAwards() {
		return awards;
	}

	public void setAwards(String awards) {
		this.awards = awards;
	}

	@JsonProperty("Poster")
	public String getPoster() {
		return poster;
	}

	public void setPoster(String poster) {
		this.poster = poster;
	}

	@JsonProperty("Metascore")
	public String getMetascore() {
		return metascore;
	}

	public void setMetascore(String metascore) {
		this.metascore = metascore;
	}

	
	public String getImdbRating() {
		return imdbRating;
	}

	public void setImdbRating(String imdbRating) {
		this.imdbRating = imdbRating;
	}

	public String getImdbVotes() {
		return imdbVotes;
	}

	public void setImdbVotes(String imdbVotes) {
		this.imdbVotes = imdbVotes;
	}

	@JsonProperty("Type")
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Date getUpdated() {
		return updated;
	}

	public void setUpdated(Date updated) {
		this.updated = updated;
	}
	
	
}
