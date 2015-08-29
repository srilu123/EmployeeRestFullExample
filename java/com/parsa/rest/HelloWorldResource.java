/**
 * 
 */
package com.parsa.rest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.xml.bind.JAXBElement;

import org.apache.log4j.Logger;

import com.parsa.service.DatabaseService;
import com.parsa.service.Employee;
import com.parsa.service.EmployeeInfoService;
import com.parsa.service.FactorialService;
import com.sun.jersey.multipart.FormDataParam;

@Path("/hello")
public class HelloWorldResource {
	Logger logger = Logger.getLogger(HelloWorldResource.class);
	private FactorialService factorialService = new FactorialService();
	private EmployeeInfoService employeeInfoService=new EmployeeInfoService();
	
	
	@GET
	@Path("/employee/{param}")
	@Produces(MediaType.APPLICATION_JSON)
	public Employee findEmployeeById(@PathParam("param") int empId) {

		Employee emp = findEmployee(empId);
		return emp;
	}
	

	

	

	private Employee findEmployee(int empId) {
		return employeeInfoService.getEmployeeInfo(empId);
	}

	@POST
	@Path("/upload")
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	public Response uploadEmployee(@FormDataParam("empId") int empid,
			@FormDataParam("empName") String name,
			@FormDataParam("designation") String designation,
			@FormDataParam("company") String company,
			@FormDataParam("salary") int salary
			)
	{
	
         String status = employeeInfoService.insertEmployeeDetails(empid, name, designation,
				company, salary);
		return Response.status(200).entity(status).build();

	}
	@PUT
	@Consumes(MediaType.APPLICATION_XML)	
	@Path("/update")
	public Response updateEmployeeDetails(JAXBElement<Employee> emp) {
    System.out.println("inside method put");
	Employee emp1 = emp.getValue();
	 String status = employeeInfoService.updateEmployee(emp1);
		
		return Response.status(204).entity(status).build();

	}
	@DELETE	
	@Path("/delete/{param}")
	public Response deleteEmployeeDetails(@PathParam("param") int empId) {
     String status=employeeInfoService.deleteEmployee(empId);
			return Response.status(204).entity(status).build();

	}

	
	
	@GET
	@Path("/{param}")
	public Response getMsg(@PathParam("param") String msg) {

		String output = "Jersey say : " + msg;

		return Response.status(200).entity(output).build();

	}

	@GET
	@Path("/add/{param1},{param2}")
	public Response getAddedValue(@PathParam("param1") int number1,
			@PathParam("param2") int number2) {

		String output = "result : " + (number1 + number2);

		return Response.status(200).entity(output).build();

	}

	@GET
	@Path("/mul/{param1},{param2}")
	public Response getMultipliedValue(@PathParam("param1") int number1,
			@PathParam("param2") int number2) {

		String output = "result : " + (number1 * number2);

		return Response.status(200).entity(output).build();

	}

	@GET
	@Path("/div/{param1},{param2}")
	public Response getDividedValue(@PathParam("param1") int number1,
			@PathParam("param2") int number2) {

		String output = "result : " + (number1 / number2);

		return Response.status(200).entity(output).build();

	}

	@GET
	@Path("/fact/{param}")
	public Response getFactorial(@PathParam("param") int number) {
		if (number < 0) {
			throw new RuntimeException("Number can't be lessthan zero");
		}
		String output = "result : "
				+ (getFactorialService().getFactorialOfNumber(number));
		return Response.status(200).entity(output).build();
	}
	
	
	/**
	 * @return the factorialService
	 */
	protected FactorialService getFactorialService() {
		return factorialService;
	}

	/**
	 * @param factorialService
	 *            the factorialService to set
	 */
	protected void setFactorialService(FactorialService factorialService) {
		this.factorialService = factorialService;
	}
	/**
	 * @return the employeeInfoService
	 */
	
}