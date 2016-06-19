package com.msrm.hibernatedemo;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.msrm.hibernatedemo.dal.dos.EmployeeDO;

public class ProjectionDemo {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		SessionFactory sf = cfg.configure().buildSessionFactory();

		Session s = sf.openSession();
		Criteria c = s.createCriteria(EmployeeDO.class);

		ProjectionList pl = Projections.projectionList();
		pl.add(Projections.property("name"));
		pl.add(Projections.property("id"));
		c.setProjection(pl);

		// c.setResultTransformer(resultTransformer);

		// c.setFirstResult(1)
		// c.setMaxResults(100);

		List list = c.list();

		Iterator<List> itr = list.iterator();
		while (itr.hasNext()) {

			// List l = itr.next();
			// System.out.println(l);

		}

		s.close();
		sf.close();
	}

}
