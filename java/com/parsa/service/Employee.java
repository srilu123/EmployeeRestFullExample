/**
 * 
 */
package com.parsa.service;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author ramesh
 *
 */
@XmlRootElement
public class Employee {
	private int sno;
private String name;
private String designation;
private String company;
private int salary;

/**
 * @return the sno
 */
public int getSno() {
	return sno;
}

/**
 * @return the name
 */
public String getName() {
	return name;
}

/**
 * @return the designation
 */
public String getDesignation() {
	return designation;
}

/**
 * @return the company
 */
public String getCompany() {
	return company;
}

/**
 * @return the salary
 */
public int getSalary() {
	return salary;
}

/**
 * @param sno the sno to set
 */
public void setSno(int sno) {
	this.sno = sno;
}

/**
 * @param name the name to set
 */
public void setName(String name) {
	this.name = name;
}

/**
 * @param designation the designation to set
 */
public void setDesignation(String designation) {
	this.designation = designation;
}

/**
 * @param company the company to set
 */
public void setCompany(String company) {
	this.company = company;
}

/**
 * @param salary the salary to set
 */
public void setSalary(int salary) {
	this.salary = salary;
}

/* (non-Javadoc)
 * @see java.lang.Object#toString()
 */
@Override
public String toString() {
	return "Employee [sno=" + sno + ", name=" + name + ", designation="
			+ designation + ", company=" + company + ", salary=" + salary + "]";
}





}
