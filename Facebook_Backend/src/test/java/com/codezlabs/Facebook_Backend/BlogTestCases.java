package com.codezlabs.Facebook_backend;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.codezlabs.Facebook_backend.Dao.BlogDao;
import com.codezlabs.Facebook_backend.config.AppContextConfig;
import com.codezlabs.Facebook_backend.model.Blog;
import com.codezlabs.Facebook_backend.model.BlogComment;
import com.codezlabs.Facebook_backend.model.BlogStatus;

import junit.framework.Assert;

public class BlogTestCases {
	
	@Autowired
	static BlogDao blogDao;
	@Autowired
	static Blog blog;
	@Autowired
	static BlogComment blogComment;
	static AnnotationConfigApplicationContext context;

	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext(AppContextConfig.class);
		context.scan("com.codezlabs.Facebook_backend");
		// context.refresh();
		blogDao = (BlogDao) context.getBean("blogDao");
		blog = (Blog) context.getBean("blog");
	}
	@Ignore
	@Test
	public void addBlogTestCase() {
		blog.setContents("yo");
		blog.setIncrementLikes(0);		
		blog.setStatus(BlogStatus.BLOG_NEW);
		blog.setTitle("yo");
		blog.setDateCreated(new java.util.Date());
		blogDao.addBlog(blog);
		Assert.assertEquals(blog, true);
	}

	@Ignore
	@Test
	public void updateBlogTestCase() {
		blog.setContents("Hello");
		blog.setIncrementLikes(2);
		blog.setBlogId(1);
		blogDao.updateBlog(blog);
		Assert.assertEquals(blog, true);
	}

	@Ignore
	@Test
	public void deleteBlogTestCase() {
		blog.setBlogId(1);
		blogDao.deleteBlog(blog.getBlogId());
		Assert.assertEquals(blog, true);
	}

	@Ignore
	@Test
	public void getListBlogTestCase() {
		List<Blog> blogComment = blogDao.listAllBlogs();
		System.out.println(blogComment);
		Assert.assertEquals("Get all category test", 2, blogComment.size());
	}

	@Ignore
	@Test
	public void addBlogCommentTestCase() {
		blogComment.setBlogComment("Welcome");
		blogDao.addBlogComment(blogComment);
		Assert.assertEquals(blogComment, true);
	}
	
	@Ignore
	@Test
	public void deleteBlogCommentTestCase(){
		blogComment.setBlogRemove("Welcome To Java");
		//blogComment.setBlogCommentId(blogCommentId);
		blogDao.deleteBlogComment(blogComment);
	}
	@Ignore
	@Test
	public void listBlogCommentsTestCase(){
	List<BlogComment>blogComments=blogDao.listBlogComments(0);
	System.out.println(blogComments);
	Assert.assertEquals("Get all blogs", 2,blogComments.size());
	}
}
