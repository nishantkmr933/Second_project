package com.codezlabs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codezlabs.Facebook_backend.Dao.BlogDao;
import com.codezlabs.Facebook_backend.model.Blog;
import com.codezlabs.Facebook_backend.model.BlogComment;

@RestController
public class BlogController {

	@Autowired
	BlogDao blogDao;
	@Autowired
	BlogComment blogComment;

	@GetMapping("/listAllBlogs")
	public ResponseEntity<List<Blog>> listAllBlogs() {
		List<Blog> listBlogs = blogDao.listAllBlogs();
		if (listBlogs != null) {
			return new ResponseEntity<List<Blog>>(listBlogs, HttpStatus.OK);
		} else {
			return new ResponseEntity<List<Blog>>(listBlogs, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/addBlog")
	public ResponseEntity<String> addBlog(@RequestBody Blog blog) {
		if (blogDao.addBlog(blog)) {
			return new ResponseEntity<String>("Blog Added", HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("Failure", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/updateBlog")
	public ResponseEntity<String> updateBlog(@RequestBody Blog blog) {
		if (blogDao.updateBlog(blog)) {
			return new ResponseEntity<String>("Blog Updated", HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("Failure", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/deleteBlog/{blogId}")
	public ResponseEntity<String> deleteBlog(@PathVariable("blogId") int blogId) {
		if (blogDao.deleteBlog(blogId)) {
			return new ResponseEntity<String>("Delete blog", HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("unable to delete", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/approveBlog/{status}")
	public ResponseEntity<List<Blog>> approveBlog(@PathVariable("status") Blog status) {
		List<Blog> listBlogs = blogDao.approveBlog(status);
		if (listBlogs != null) {
			return new ResponseEntity<List<Blog>>(listBlogs, HttpStatus.OK);
		} else {
			return new ResponseEntity<List<Blog>>(listBlogs, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/rejectBlog/{status}")
	public ResponseEntity<List<Blog>> rejectBlog(@PathVariable("status") Blog status) {
		List<Blog> listBlogs = blogDao.rejectBlog(status);
		if (listBlogs != null) {
			return new ResponseEntity<List<Blog>>(listBlogs, HttpStatus.OK);
		} else {
			return new ResponseEntity<List<Blog>>(listBlogs, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/getBlog/{blogId}")
	public ResponseEntity getBlog(@PathVariable("blogId") int blogId) {
		Blog listBlog = blogDao.getBlog(blogId);
		if (listBlog != null) {
			return new ResponseEntity(blogId, HttpStatus.OK);
		} else {
			return new ResponseEntity(blogId, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/addBlogComment")
	public ResponseEntity<String> addBlogComment(@RequestBody BlogComment blogComment) {
		if (blogDao.addBlogComment(blogComment)) {
			return new ResponseEntity<String>("Add Blog Comment", HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("Unable to add Blog", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/deleteBlogComment/{blogCommentId}")
	public ResponseEntity<String> deleteBlogComment(@PathVariable("blogCommentId") int blogCommentId) {
		if (blogDao.deleteBlogComment(blogComment)) {
			return new ResponseEntity<String>("Delete BlogComment", HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("Unable to delete blog comment", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/getBlogComment/{blogCommentId}")
	public ResponseEntity<String>getBlogComment(@PathVariable("blogCommentId") int blogCommentId){
		BlogComment blogComment =blogDao.getBlogComment(blogCommentId);
		if(blogDao.getBlogComment(blogCommentId)!=null){
			return new ResponseEntity<String>(HttpStatus.OK);
		}else{
			return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/listBlogComments/{blogId}")
	public ResponseEntity<List<BlogComment>>listBlogComments(@PathVariable("blogId") int blogId){
		List<BlogComment>listBlogComments=blogDao.listBlogComments(blogId);
		if(listBlogComments != null){
			return new ResponseEntity<List<BlogComment>>(listBlogComments,HttpStatus.OK);
		}else{
			return new ResponseEntity<List<BlogComment>>(listBlogComments,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
