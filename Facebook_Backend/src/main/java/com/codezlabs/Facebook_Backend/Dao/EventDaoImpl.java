package com.codezlabs.Facebook_backend.Dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.codezlabs.Facebook_backend.model.Event;

@Repository("EventDao")
@EnableTransactionManagement
@Transactional
public class EventDaoImpl implements EventDao {
	
	@Autowired
	SessionFactory sessionFactory;

	public boolean create(Event event) {
		try{
			sessionFactory.getCurrentSession().saveOrUpdate(event);
			return true;
		}catch(Exception e){
			return false;
		}
	}

	public boolean update(Event event) {
		try{
			sessionFactory.getCurrentSession().update(event);
			return true;
		}catch(Exception e){
			return false;
		}
		
	}

	public Event getById(long eventId) {
		String hql="from event where eventId"+eventId;
		Event event = null;
		try{
			event=(Event)sessionFactory.getCurrentSession().createQuery(hql).getResultList();
			return event;
		}catch(Exception e){
			return null;			
		}
	}

	public List<Event> getAll() {
		String hql="from event";
		List<Event> event= sessionFactory.getCurrentSession().createQuery(hql).getResultList();
		return event;
	}

}
