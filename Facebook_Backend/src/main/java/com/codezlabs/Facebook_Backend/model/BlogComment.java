package com.codezlabs.Facebook_backend.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Component
@Table(name="S_blogComment")
public class BlogComment {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="blogComment_sequence")
	@SequenceGenerator(sequenceName="blogComment_sequence",name="blogComment_sequence")
	private long blogCommentId;
	private String blogComment;
	private String blogRemove;
	
	public long getBlogCommentId() {
		return blogCommentId;
	}
	public void setBlogCommentId(long blogCommentId) {
		this.blogCommentId = blogCommentId;
	}
	public String getBlogComment() {
		return blogComment;
	}
	public void setBlogComment(String blogComment) {
		this.blogComment = blogComment;
	}
	public String getBlogRemove() {
		return blogRemove;
	}
	public void setBlogRemove(String blogRemove) {
		this.blogRemove = blogRemove;
	}	
}
