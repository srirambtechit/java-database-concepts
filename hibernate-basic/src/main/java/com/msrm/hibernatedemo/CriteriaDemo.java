package com.msrm.hibernatedemo;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.msrm.hibernatedemo.dal.dos.EmployeeDO;

public class CriteriaDemo {

	public static void main(String[] args) {

		Configuration cfg = new Configuration();
		SessionFactory sf = cfg.configure().buildSessionFactory();
		Session s = sf.openSession();

		Criteria c = s.createCriteria(EmployeeDO.class);
		List<EmployeeDO> list = c.list();

		for (EmployeeDO employeeDO : list) {
			System.out.println(employeeDO);
		}

		s.close();
		sf.close();

	}

}
