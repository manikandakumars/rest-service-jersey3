package com.proj.bean;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement (name="person")
public class Person {
	private String name;
	private int age;
	private int id;
	private Address address;

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	@Override
	public String toString(){
		return id+"::"+name+"::"+age;
	}

}
