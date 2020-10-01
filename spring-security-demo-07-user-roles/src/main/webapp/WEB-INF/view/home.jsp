<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<html>

<head>
  <title>Hello homee world</title>

</head>

<body>
 love to sleep....
 
 <hr>
 
   <p> 
   
   User : <security:authentication property="principal.username" />
 
  </p>
  
  <p> 
   
   Roles : <security:authentication property="principal.authorities" />
 
  </p>
  
  
 <hr>
 
 <security:authorize access="hasRole('MANAGER')">
 <p>
  <a href="${pageContext.request.contextPath}/leaders">LeaderShip meeting</a>
 
 </p>
 </security:authorize>
 
 
 <security:authorize access="hasRole('ADMIN')">
 <p>
  <a href="${pageContext.request.contextPath}/admin">Admin meeting</a>
 
 </p>
  </security:authorize>
  
 
 
 
 <form:form action="${pageContext.request.contextPath}/logout" 
							   method="POST" >
							   
	<input type="submit" value="logout">				   
							   
 </form:form>

</body>

</html>