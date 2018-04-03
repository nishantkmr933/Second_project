package com.codezlabs.Facebook_backend.Dao;

import java.util.List;

import javax.management.Query;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.codezlabs.Facebook_backend.model.Blog;
import com.codezlabs.Facebook_backend.model.BlogComment;

@Repository("blogDao")
@EnableTransactionManagement
@Transactional
public class BlogDaoImpl implements BlogDao {

	@Autowired
	SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public boolean addBlog(Blog blog) {
		try {
			blog.setIncrementLikes(0);
			sessionFactory.getCurrentSession().saveOrUpdate(blog);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean updateBlog(Blog blog) {
		try {
			sessionFactory.getCurrentSession().update(blog);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean deleteBlog(long blogId) {
		try {
			sessionFactory.getCurrentSession().delete(blogId);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public List<Blog> listBlogs(String username) {
		try {
			String hql = "from Blog where loginname" + username;
			List<Blog> blog = sessionFactory.getCurrentSession().createQuery(hql).getResultList();
			return blog;
		} catch (Exception e) {
			return null;
		}

	}

	public List<Blog> approveBlog(Blog blog) {
		try {
			String hql = "from Blog where status='BLOG_NEW'";
			List<Blog> blogs = sessionFactory.getCurrentSession().createQuery(hql).getResultList();
			return blogs;
		} catch (Exception e) {
			return null;
		}
	}

	public List<Blog> rejectBlog(Blog blog) {
		try {
			String hql = "from Blog where status='Blog_Reject'";
			List<Blog> blogs = sessionFactory.getCurrentSession().createQuery(hql).getResultList();
			return blogs;
		} catch (Exception e) {
			return null;
		}
	}

	public Blog getBlog(long blogId) {		
			String hql="form Blog where blogId="+ blogId;
			Blog blog=null;
			try {
				blog=(Blog)sessionFactory.getCurrentSession().createQuery(hql).getResultList();
				return blog;
		} catch (Exception e) {
			return null;
		}
	}

	public List<Blog> listAllBlogs() {
		String hql="from Blog";
		List<Blog>blogs=sessionFactory.getCurrentSession().createQuery(hql).getResultList();
		return blogs;
	}

	public boolean incrementLikes(Blog blog) {
		try{
			int likes=blog.getIncrementLikes();
			likes++;
			blog.setIncrementLikes(likes);
			sessionFactory.getCurrentSession().update(blog);
			return true;
		}catch (Exception e) {
			return false;
		}		
	}

	public boolean addBlogComment(BlogComment blogComment) {
		try{
			sessionFactory.getCurrentSession().saveOrUpdate(blogComment);
			return true;			
		}catch(Exception e){
			return false;
		}
	}

	public boolean deleteBlogComment(BlogComment blogComment) {
		try{
			sessionFactory.getCurrentSession().delete(blogComment);
			return true;
		}catch(Exception e){
			return false;
		}
	}

	public BlogComment getBlogComment(long commentId) {
		String hql="where BlogComment where blogCommentId"+commentId;
		BlogComment blogComment=null;
		try{
			blogComment=(BlogComment) sessionFactory.getCurrentSession().createQuery(hql).getResultList();
			return blogComment;
		}catch(Exception e){
			return null;
		}
	}

	public List<BlogComment> listBlogComments(long blogid) {
		String hql="from BlogComment where blogCommentId"+blogid;
		List<BlogComment>blogComment=sessionFactory.getCurrentSession().createQuery(hql).getResultList();
		return blogComment;
	}

			
}
