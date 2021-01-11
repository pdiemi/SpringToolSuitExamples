/**
 * Employee.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package wsdemo;

public interface Employee extends java.rmi.Remote {
    public java.lang.String greet(java.lang.String message) throws java.rmi.RemoteException;
    public int calculateLeaves() throws java.rmi.RemoteException;
    public double calculateSalary(double salary) throws java.rmi.RemoteException;
}
