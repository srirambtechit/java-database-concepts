package com.msrm.hibernatedemo.dal.dao;

import java.util.List;

import com.msrm.hibernatedemo.dal.dos.EmployeeDO;

public interface EmployeeDAO {

	public void insert(EmployeeDO e);

	public void update(EmployeeDO e);

	public void delete(EmployeeDO e);
	
	public EmployeeDO fetchById(int id);

	public List<EmployeeDO> select();

}
