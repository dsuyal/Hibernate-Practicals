package com.rays.dto;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.sql.Update;


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

}
