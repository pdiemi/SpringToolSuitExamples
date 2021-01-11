package wsdemo;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public class Calc {

	@WebMethod
	public int add(int x, int y) {
		return x+y;
	}
}
