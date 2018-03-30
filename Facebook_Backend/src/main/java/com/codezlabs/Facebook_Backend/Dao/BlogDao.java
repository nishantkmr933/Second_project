package com.codezlabs.Facebook_backend.Dao;

import java.util.List;

import com.codezlabs.Facebook_backend.model.Blog;
import com.codezlabs.Facebook_backend.model.BlogComment;

public interface BlogDao {
	
	public boolean addBlog(Blog blog);
	public boolean updateBlog(Blog blog);
	public boolean deleteBlog(int blogId);

	public List<Blog> listBlogs(String username);
	public List<Blog> approveBlog(Blog blog);
	public List<Blog> rejectBlog(Blog blog);
	public Blog getBlog(int blogId);
	public List<Blog> listAllBlogs();
	public boolean incrementLikes(Blog blog);
	
	public boolean addBlogComment(BlogComment blogComment);
	public boolean deleteBlogComment(BlogComment blogComment);
	public BlogComment getBlogComment(int commentId);
	public List<BlogComment> listBlogComments(int blogid);
}
