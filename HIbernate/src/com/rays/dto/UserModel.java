package com.rays.dto;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;




public class UserModel {
	
	

	public void Add(UserDTO dto) {
		
			SessionFactory sf = new Configuration().configure().buildSessionFactory();
			
			Session session = sf.openSession();
			
			Transaction tx = session.beginTransaction();
			
			session.save(dto);
			
			tx.commit();
			
			session.close();

	}
	
	public void Update(UserDTO dto) {
		
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		
		Session session = sf.openSession();
		
		Transaction tx = session.beginTransaction();
		
		session.update(dto);
		
		tx.commit();
		
		session.close();

	}
	
	public void Delete(UserDTO dto) {
		
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		
		Session session = sf.openSession();
		
		Transaction tx = session.beginTransaction();
		
		session.delete(dto);
		
		tx.commit();
		
		session.close();
		
	}
	
	public UserDTO findByPk(int pk) {
		
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		
		Session session = sf.openSession();
		
		UserDTO dto = (UserDTO) session.get(UserDTO.class,pk);
		
		session.close();
		
		return dto;
		
	}
	
	public UserDTO authenticate(String login,String password) {
		
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		
		Session session = sf.openSession();
		
		Query q = session.createQuery("from UserDTO where loginId =? and password = ?");
		
		q.setString(0, login);
		q.setString(1, password);
		
		List list =  q.list();
		
		UserDTO dto = null;
		
		if (list.size()>0) {
			
			dto = (UserDTO) list.get(0);
			
		}
		
		session.close();
		
		return dto;
		
	}

}
