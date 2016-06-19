package com.msrm.hibernatedemo.dal.dao.hibimpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.msrm.hibernatedemo.dal.dao.EmployeeDAO;
import com.msrm.hibernatedemo.dal.dos.EmployeeDO;

public class EmployeeDAOImpl implements EmployeeDAO {

	public void insert(EmployeeDO e) {
		Configuration cfg = new Configuration();
		SessionFactory sf = cfg.configure().buildSessionFactory();
		Session s = sf.openSession();
		Transaction t = s.beginTransaction();
		s.save(e);
		t.commit();
	}

	public void update(EmployeeDO e) {
		Configuration cfg = new Configuration();
		SessionFactory sf = cfg.configure().buildSessionFactory();
		Session s = sf.openSession();
		Transaction t = s.beginTransaction();
		s.update(e);
		t.commit();
		s.close();
		sf.close();
	}

	public void delete(EmployeeDO e) {
		Configuration cfg = new Configuration();
		SessionFactory sf = cfg.configure().buildSessionFactory();
		Session s = sf.openSession();
		Transaction t = s.beginTransaction();
		s.delete(e);
		t.commit();
	}

	public List<EmployeeDO> select() {
		return null;
	}

	public EmployeeDO fetchById(int id) {
		Configuration cfg = new Configuration();
		SessionFactory sf = cfg.configure().buildSessionFactory();
		Session s = sf.openSession();
		EmployeeDO e = s.get(EmployeeDO.class, id);
		s.close();
		sf.close();
		return e;
	}

}
