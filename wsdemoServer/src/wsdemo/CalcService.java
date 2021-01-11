/**
 * CalcService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package wsdemo;

public interface CalcService extends javax.xml.rpc.Service {
    public java.lang.String getCalcAddress();

    public wsdemo.Calc getCalc() throws javax.xml.rpc.ServiceException;

    public wsdemo.Calc getCalc(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
