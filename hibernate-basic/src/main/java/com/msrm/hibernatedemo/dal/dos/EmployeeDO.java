package com.msrm.hibernatedemo.dal.dos;

public class EmployeeDO {

	private int id;

	private String name;

	private String mail;

	private int age;

	private String mobileNumber;

	private AddressDO address;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public AddressDO getAddress() {
		return address;
	}

	public void setAddress(AddressDO address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "EmployeeDO [id=" + id + ", name=" + name + ", mail=" + mail + ", age=" + age + ", mobileNumber="
				+ mobileNumber + ", address=" + address + "]";
	}

}
