package com.codezlabs.restcontroller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.codezlabs.Facebook_backend.Dao.BlogDao;
import com.codezlabs.Facebook_backend.model.Blog;
import com.codezlabs.Facebook_backend.model.BlogComment;

@RestController
public class BlogController {

	@Autowired
	BlogDao blogDao;

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
			return new ResponseEntity<String>("Updated Blog", HttpStatus.OK);
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

	@GetMapping("/listBlogs")
	public ResponseEntity<List<Blog>> listBlogs(@RequestBody Blog blog) {
		List<Blog> listBlogs = blogDao.listAllBlogs();
		if (listBlogs != null) {
			return new ResponseEntity<List<Blog>>(listBlogs, HttpStatus.OK);
		} else {
			return new ResponseEntity<List<Blog>>(listBlogs, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/approveBlog")
	public ResponseEntity<List<Blog>> approveBlog(@RequestBody Blog blog) {
		List<Blog> approve = blogDao.approveBlog(blog);
		// if()
		return new ResponseEntity<List<Blog>>(approve, HttpStatus.OK);
	}

	@GetMapping("/rejectBlog")
	public ResponseEntity<List<Blog>> rejectBlog(@RequestBody Blog blog) {
		List<Blog> reject = blogDao.rejectBlog(blog);
		return new ResponseEntity<List<Blog>>(reject, HttpStatus.OK);
	}

	@PutMapping("/incrementLikes/{blogId}")
	public ResponseEntity<String> incrementLikes(@RequestBody Blog blog) {
		if (blogDao.incrementLikes(blog)) {
			return new ResponseEntity<String>("Likes", HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("failure", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/addBlogComment")
	public ResponseEntity<String> addBlogComment(@RequestBody BlogComment blog) {
		if (blogDao.addBlogComment(blog)) {
			return new ResponseEntity<String>("Blog comment Added", HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("Fail to add Comment", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/deleteBlogComment/{blogId}")
	public ResponseEntity<String> deleteBlogComment(@RequestBody BlogComment blog) {
		if (blogDao.deleteBlogComment(blog)) {
			return new ResponseEntity<String>("Comment deleted", HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("Unable to delete", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/*
	@GetMapping("/getBlogComment")
	public ResponseEntity<String> getBlogComment(@RequestBody BlogComment blog) {
		if (blogDao.getBlogComment(blog)) {
			return new ResponseEntity<String>(blog, HttpStatus.OK);
		}
	}*/

}
