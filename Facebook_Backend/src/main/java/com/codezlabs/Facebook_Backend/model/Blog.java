package com.codezlabs.Facebook_backend.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.stereotype.Component;

@Entity
@Component
@Table(name="s_Blog")
public class Blog {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator="blog_sequence")
	@SequenceGenerator(sequenceName="blog_sequence", name = "blog_sequence")
	private long blogId;
	private String title;
	private String contents;
	@Temporal(TemporalType.DATE)
	private Date dateCreated;
	@Temporal(TemporalType.DATE)
	private Date lastModified;
	@Enumerated(EnumType.STRING)
	private BlogStatus status;
	private int incrementLikes;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "userId")
	private User user;
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="blogCommentId")
	private BlogComment blogCommentId;
	
	public long getBlogId() {
		return blogId;
	}

	public void setBlogId(long blogId) {
		this.blogId = blogId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public Date getLastModified() {
		return lastModified;
	}

	public void setLastModified(Date lastModified) {
		this.lastModified = lastModified;
	}

	public BlogStatus getStatus() {
		return status;
	}

	public void setStatus(BlogStatus status) {
		this.status = status;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	public BlogComment getBlogCommentId() {
		return blogCommentId;
	}

	public void setBlogCommentId(BlogComment blogCommentId) {
		this.blogCommentId = blogCommentId;
	}

	public int getIncrementLikes() {
		return incrementLikes;
	}

	public void setIncrementLikes(int incrementLikes) {
		this.incrementLikes = incrementLikes;
	}
	

}
