package wsdemo;

public class EmployeeProxy implements wsdemo.Employee {
  private String _endpoint = null;
  private wsdemo.Employee employee = null;
  
  public EmployeeProxy() {
    _initEmployeeProxy();
  }
  
  public EmployeeProxy(String endpoint) {
    _endpoint = endpoint;
    _initEmployeeProxy();
  }
  
  private void _initEmployeeProxy() {
    try {
      employee = (new wsdemo.EmployeeServiceLocator()).getEmployee();
      if (employee != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)employee)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)employee)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (employee != null)
      ((javax.xml.rpc.Stub)employee)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public wsdemo.Employee getEmployee() {
    if (employee == null)
      _initEmployeeProxy();
    return employee;
  }
  
  public java.lang.String greet(java.lang.String message) throws java.rmi.RemoteException{
    if (employee == null)
      _initEmployeeProxy();
    return employee.greet(message);
  }
  
  public int calculateLeaves() throws java.rmi.RemoteException{
    if (employee == null)
      _initEmployeeProxy();
    return employee.calculateLeaves();
  }
  
  public double calculateSalary(double salary) throws java.rmi.RemoteException{
    if (employee == null)
      _initEmployeeProxy();
    return employee.calculateSalary(salary);
  }
  
  
}