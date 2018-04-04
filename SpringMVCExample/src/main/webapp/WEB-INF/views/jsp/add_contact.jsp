<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
</head>
<body>

<div class="jumbotron">
	<div class="container">
		<h1>Add Contact</h1>
		
		<form:form action="addContact" commandName="contact" method="post">
			First Name: <form:input path="firstName"/> 
				<font color="red"><form:errors path="firstName" /></font> <br/> 
			Last Name: <form:input path="lastName"/> 
				<font color="red"><form:errors path="lastName" /></font>  <br/>
			<input type="submit" value="Save" />
			
		</form:form>
		
	</div>
</div>


</body>
</html>