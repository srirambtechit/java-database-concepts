package com.jlearn.hibernate.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.jlearn.hibernate.entity.Address;

public class AddressDAO {

	public Integer insert(Address address) {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(cfg.getProperties())
				.build();
		SessionFactory sf = cfg.buildSessionFactory(serviceRegistry);
		Session s = sf.openSession();
		Transaction t = s.beginTransaction();
		Integer id = (Integer) s.save(address);
		t.commit();
		sf.close();
		return id;
	}

}
