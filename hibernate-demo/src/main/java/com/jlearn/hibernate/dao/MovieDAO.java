package com.jlearn.hibernate.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.jlearn.hibernate.entity.Movie;

public class MovieDAO {

	public Integer insert(Movie movie) {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(cfg.getProperties())
				.build();
		SessionFactory sf = cfg.buildSessionFactory(serviceRegistry);
		Session s = sf.openSession();
		Transaction t = s.beginTransaction();
		Integer id = (Integer) s.save(movie);
		t.commit();
		sf.close();
		return id;
	}

	public Movie update(Movie movie) {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(cfg.getProperties())
				.build();
		SessionFactory sf = cfg.buildSessionFactory(serviceRegistry);
		Session s = sf.openSession();
		Transaction t = s.beginTransaction();
		s.update(movie);
		t.commit();
		sf.close();
		return movie;
	}

	public void delete(int id) {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(cfg.getProperties())
				.build();
		SessionFactory sf = cfg.buildSessionFactory(serviceRegistry);
		Session s = sf.openSession();
		Transaction t = s.beginTransaction();
		Movie movie = (Movie) s.get(Movie.class, id);
		s.delete(movie);
		t.commit();
		sf.close();
	}

}
