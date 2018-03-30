package com.codezlabs.Facebook_backend.Dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.codezlabs.Facebook_backend.model.Friend;
import com.codezlabs.Facebook_backend.model.RequestStatus;

@Repository("friendDao")
@EnableTransactionManagement
@Transactional
public class FriendDaoImpl implements FriendDao{
	static SessionFactory sessionFactory;

	public boolean create(Friend friend) {
		try{
			Session session=sessionFactory.getCurrentSession();
			Friend fri= new Friend();
			fri.setUser(friend.getUser());
			fri.setStatus(RequestStatus.REQ_NEW);
			fri.setOnline(false);
			
			session.saveOrUpdate(fri);
			session.saveOrUpdate(friend);
			return true;
		}catch(Exception e){
			return false;
		}
	}

	public boolean update(Friend friend) {
		try{
			sessionFactory.getCurrentSession().update(friend);
			return true;
		}catch(Exception e){
			return false;
		}
	}

	public Friend get(String userId, String friendId) {
		String hql="from friend where userId="+userId+"and friendId="+friendId;
		Friend friend=null;
		try{
			friend=(Friend)sessionFactory.getCurrentSession().createQuery(hql).getResultList();
			return friend;
		}catch (Exception e) {
			return null;
		}
	}

	public List<Friend> getFriends(String userId) {
		String hql="from friend where friendId="+userId+"and status='REQ_ACCEPTED'";
		try{
		List<Friend>friend = sessionFactory.getCurrentSession().createQuery(hql).getResultList();
		return friend;
		}catch(Exception e){
			return null;
		}
	}

	public List<Friend> getRequest(String userId) {
		String hql="from friend where friendId="+userId+"and status='REQ_NEW'";
		try{
			List<Friend>friend=sessionFactory.getCurrentSession().createQuery(hql).getResultList();
			return friend;
		}catch(Exception e){
			return null;
		}
	}

	public boolean setOnLine(String userId) {
		String hql="update friend where isOnline=true where friendId=?";
		try{
			int status= sessionFactory.getCurrentSession().createQuery(hql).executeUpdate();
			return true;
		}catch (Exception e) {
			return false;
		}
	}

	public boolean setOffLine(String userId) {
		String hql="update friend where isOnline=false where friendId=?";
		try{
			int status= sessionFactory.getCurrentSession().createQuery(hql).executeUpdate();
			return true;
		}catch (Exception e) {
			return false;
		}
	}
}
