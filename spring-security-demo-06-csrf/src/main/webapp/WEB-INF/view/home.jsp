<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  

<html>

<head>
  <title>Hello homee world</title>

</head>

<body>
 love to sleep....
 
 <form:form action="${pageContext.request.contextPath}/logout" 
							   method="POST" >
							   
	<input type="submit" value="logout">				   
							   
 </form:form>

</body>

</html>