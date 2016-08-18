package io.kushal.movieflix.entity;




import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

@Entity
@Table
@NamedQueries(
	{	
		@NamedQuery(name="TitleComment.ViewComment", query="Select c from TitleComment c WHERE c.Title =:pTitle ORDER BY CommentTime ")
	}
)
public class TitleComment {
	@Id
	@GenericGenerator(name = "system-uuid", strategy = "uuid2")
	@GeneratedValue(generator = "system-uuid")
	private String CommentID;
	
	@PrePersist
    protected void onCreate() {
    	CommentTime = new Date();
    }
	public String getComment() {
		return Comment;
	}
	public void setComment(String comment) {
		this.Comment = comment;
	}
	public String getUser() {
		return User;
	}
	public void setUser(String user) {
		this.User = user;
	}
	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		Title = title;
	}
	@Lob
	@Type(type = "org.hibernate.type.TextType")
	private String Comment;
	private String User;
	public String getCommentID() {
		return CommentID;
	}
	
	private String Title;
	
	@Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CommentTime", updatable=false)
	private Date CommentTime;
	public Date getCommentTime() {
		return CommentTime;
	}
	public void setCommentTime(Date commentTime) {
		CommentTime = commentTime;
	}
	
	
}
