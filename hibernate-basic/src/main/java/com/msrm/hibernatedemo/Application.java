package com.msrm.hibernatedemo;

import com.msrm.hibernatedemo.dal.dao.EmployeeDAO;
import com.msrm.hibernatedemo.dal.dao.hibimpl.EmployeeDAOImpl;
import com.msrm.hibernatedemo.dal.dos.EmployeeDO;

public class Application {

	public static void main(String[] args) {

		EmployeeDO e = new EmployeeDO();
		e.setName("Kannan");
		e.setAge(24);
		e.setMail("kannan@gmail.com");
		e.setMobileNumber("9849312345");

		EmployeeDAO dao = new EmployeeDAOImpl();
		// dao.insert(e);
		// System.out.println("Inserted");

		EmployeeDO e1 = dao.fetchById(1);
		System.out.println(e1);

		e1.setMobileNumber("9892356784");
		dao.update(e1);

	}

}
