package com.msrm.hibernatedemo;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.msrm.hibernatedemo.dal.dos.EmployeeDO;

public class HQLDemo {

	public static void main(String[] args) {

		Configuration c = new Configuration();
		SessionFactory sf = c.configure().buildSessionFactory();
		Session s = sf.openSession();

		Query q = s.createQuery("from EmployeeDO");
		List<EmployeeDO> list = q.list();
		for (EmployeeDO employeeDO : list) {
			System.out.println(employeeDO);
		}
		s.close();
		sf.close();

	}

}
