package wsdemo;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public class Employee {

	@WebMethod
	public String greet(String message) {
		return message;
	}
	
	@WebMethod
	public double calculateSalary(double salary) {
		return salary;
	}
	
	@WebMethod
	public int calculateLeaves() {
		return 9;
	}
}
