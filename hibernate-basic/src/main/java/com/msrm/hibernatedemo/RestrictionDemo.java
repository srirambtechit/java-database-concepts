package com.msrm.hibernatedemo;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import com.msrm.hibernatedemo.dal.dos.EmployeeDO;

public class RestrictionDemo {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		SessionFactory sf = cfg.configure().buildSessionFactory();

		Session s = sf.openSession();
		Criteria c = s.createCriteria(EmployeeDO.class);
		c.add(Restrictions.eq("age", 23));

		List list = c.list();

		for (Object object : list) {
			System.out.println(object);
		}

		s.close();
		sf.close();
	}

}
