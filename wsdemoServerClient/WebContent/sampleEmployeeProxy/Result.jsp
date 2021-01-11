<%@page contentType="text/html;charset=UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<HTML>
<HEAD>
<TITLE>Result</TITLE>
</HEAD>
<BODY>
<H1>Result</H1>

<jsp:useBean id="sampleEmployeeProxyid" scope="session" class="wsdemo.EmployeeProxy" />
<%
if (request.getParameter("endpoint") != null && request.getParameter("endpoint").length() > 0)
sampleEmployeeProxyid.setEndpoint(request.getParameter("endpoint"));
%>

<%
String method = request.getParameter("method");
int methodID = 0;
if (method == null) methodID = -1;

if(methodID != -1) methodID = Integer.parseInt(method);
boolean gotMethod = false;

try {
switch (methodID){ 
case 2:
        gotMethod = true;
        java.lang.String getEndpoint2mtemp = sampleEmployeeProxyid.getEndpoint();
if(getEndpoint2mtemp == null){
%>
<%=getEndpoint2mtemp %>
<%
}else{
        String tempResultreturnp3 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(getEndpoint2mtemp));
        %>
        <%= tempResultreturnp3 %>
        <%
}
break;
case 5:
        gotMethod = true;
        String endpoint_0id=  request.getParameter("endpoint8");
            java.lang.String endpoint_0idTemp = null;
        if(!endpoint_0id.equals("")){
         endpoint_0idTemp  = endpoint_0id;
        }
        sampleEmployeeProxyid.setEndpoint(endpoint_0idTemp);
break;
case 10:
        gotMethod = true;
        wsdemo.Employee getEmployee10mtemp = sampleEmployeeProxyid.getEmployee();
if(getEmployee10mtemp == null){
%>
<%=getEmployee10mtemp %>
<%
}else{
        if(getEmployee10mtemp!= null){
        String tempreturnp11 = getEmployee10mtemp.toString();
        %>
        <%=tempreturnp11%>
        <%
        }}
break;
case 13:
        gotMethod = true;
        String message_1id=  request.getParameter("message16");
            java.lang.String message_1idTemp = null;
        if(!message_1id.equals("")){
         message_1idTemp  = message_1id;
        }
        java.lang.String greet13mtemp = sampleEmployeeProxyid.greet(message_1idTemp);
if(greet13mtemp == null){
%>
<%=greet13mtemp %>
<%
}else{
        String tempResultreturnp14 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(greet13mtemp));
        %>
        <%= tempResultreturnp14 %>
        <%
}
break;
case 18:
        gotMethod = true;
        int calculateLeaves18mtemp = sampleEmployeeProxyid.calculateLeaves();
        String tempResultreturnp19 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(calculateLeaves18mtemp));
        %>
        <%= tempResultreturnp19 %>
        <%
break;
case 21:
        gotMethod = true;
        String salary_2id=  request.getParameter("salary24");
        double salary_2idTemp  = Double.parseDouble(salary_2id);
        double calculateSalary21mtemp = sampleEmployeeProxyid.calculateSalary(salary_2idTemp);
        String tempResultreturnp22 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(calculateSalary21mtemp));
        %>
        <%= tempResultreturnp22 %>
        <%
break;
}
} catch (Exception e) { 
%>
Exception: <%= org.eclipse.jst.ws.util.JspUtils.markup(e.toString()) %>
Message: <%= org.eclipse.jst.ws.util.JspUtils.markup(e.getMessage()) %>
<%
return;
}
if(!gotMethod){
%>
result: N/A
<%
}
%>
</BODY>
</HTML>