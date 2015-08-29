/**
 * 
 */
package com.parsa.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import org.apache.log4j.Logger;

/**
 * @author ramesh
 * @param <Employee>
 *
 */
public class EmployeeInfoService {


	Connection con = null;
	Scanner sc = new Scanner(System.in);
	Logger logger = Logger.getLogger(EmployeeInfoService.class);
	PreparedStatement ps = null;
	Employee employee = new Employee();
	/**
	 * @param employee
	 */

	
	public Employee getEmployeeInfo(int empId) {
		
		try {
			con = (new DatabaseService().getDatabaseConnection());
			String selectQuery = "select * from employee where sno=?";
			ps = con.prepareStatement(selectQuery);
			ps.setInt(1, empId);
			
			ResultSet resultSet = ps.executeQuery();
			logger.info(resultSet.getWarnings());
			logger.info("executed");
			while (resultSet.next()) {
				logger.info("Building emp object");
				employee.setSno(resultSet.getInt(1));
				employee.setName(resultSet.getString(2));
				employee.setDesignation(resultSet.getString(3));
				employee.setCompany(resultSet.getString(4));
				employee.setSalary(resultSet.getInt(5));
				logger.info("Completed Building emp object");
			}
			ps.close();
			con.close();
		} catch (SQLException e) {
			logger.error("Error message:" + e.getMessage());
		}
		return employee;

	}
	/**
	 * @param empid
	 * @param name
	 * @param designation
	 * @param company
	 * @param salary
	 * @return
	 */
	public String insertEmployeeDetails(int empid, String name, String designation, String company, int salary) {
		
	     String status = "Upload has been successful";
		try {
			con = (new DatabaseService().getDatabaseConnection());
			String insertQuery="insert into employee(sno,name,designation,company,salary) values(?,?,?,?,?)";
			ps=con.prepareStatement(insertQuery);
			 
			  ps.setInt(1, empid);
		      ps.setString(2, name);
		      ps.setString(3, designation);
		      ps.setString(4, company);
		      ps.setInt(5, salary);
		     
		     int row= ps.executeUpdate();
		   logger.info("employee details inserted successfully:"+row);
		} catch (SQLException e) {
			status="Failed to insert employee details:";
			logger.error("error message:"+e.getMessage());
		}finally{
			if(con!=null){
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return status;
	}
	
	public String deleteEmployee(int empId) {
	
		String status="deleted employee successfully";
		try {
			con = (new DatabaseService().getDatabaseConnection());
			String deleteQuery = "delete from employee where sno=?";
			ps = con.prepareStatement(deleteQuery);
			ps.setInt(1, empId);
			int row=ps.executeUpdate();
			logger.info(row);
		}catch (SQLException e) {
				status="Failed to delete employee details:";
				logger.error("error message:"+e.getMessage());
			}finally{
				if(con!=null){
					try {
						con.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			return status;
	}
	
	
	public String updateEmployee(Employee emp) {
		String status="updated employee successfully";
		try {
			con = (new DatabaseService().getDatabaseConnection());
			String updateQuery = "update employee set designation="+emp.getDesignation()+", salary="+emp.getSalary()+" where sno="+emp.getSno();
			ps = con.prepareStatement(updateQuery);			
			int row=ps.executeUpdate();
			logger.info(row);
		}catch (SQLException e) {
				status="Failed to update employee details:";
				logger.error("error message:"+e.getMessage());
			}finally{
				if(con!=null){
					try {
						con.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		return status;
	}


}
