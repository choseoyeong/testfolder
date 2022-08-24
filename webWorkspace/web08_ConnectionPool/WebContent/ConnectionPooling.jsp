<%@page import="java.sql.Connection"%>
<%@page import="javax.sql.DataSource"%>
<%@page import="javax.naming.InitialContext"%>
<%@page import="javax.naming.Context"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>Connection Pooling Test...Using JDNI Service</h2>

<%
	Context ic = new InitialContext();
	DataSource ds = (DataSource)ic.lookup("java:comp/env/jdbc/oracleDB");
	out.print("<b>1. DataSource Lookup....</b>");
	
	
	Connection conn = ds.getConnection();
	out.print("<br><b>2. Connection...Return OK....</b>");
%>
</body>
</html>