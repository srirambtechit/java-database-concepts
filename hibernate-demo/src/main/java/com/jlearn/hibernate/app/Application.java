package com.jlearn.hibernate.app;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Projections;
import org.hibernate.service.ServiceRegistry;

import com.jlearn.hibernate.dao.AddressDAO;
import com.jlearn.hibernate.dao.MovieDAO;
import com.jlearn.hibernate.entity.Address;
import com.jlearn.hibernate.entity.Movie;

public class Application {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(cfg.getProperties())
				.build();
		SessionFactory sf = cfg.buildSessionFactory(serviceRegistry);
		Session s = sf.openSession();

		Criteria c = s.createCriteria(Address.class);
//		c.setProjection(Projections.rowCount());
		List list = c.list();
		System.out.println(list);
		sf.close();
	}

	public void saveDtls() {
		AddressDAO addrDao = new AddressDAO();
		Address address = new Address();
		address.setStreet("22, south mada street");
		address.setArea("Guindy");
		address.setCity("Chennai");
		address.setPinCode(600001);
		Integer id = addrDao.insert(address);
		System.out.println("Saved: " + id);

		MovieDAO mDao = new MovieDAO();
		Movie movie = new Movie();
		movie.setName("Mahabhalipuram");
		id = mDao.insert(movie);
		System.out.println("Movie saved: " + id);
	}

}
