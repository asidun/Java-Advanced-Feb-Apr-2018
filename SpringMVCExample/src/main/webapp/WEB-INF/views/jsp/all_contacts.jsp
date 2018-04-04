<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
</head>

<div class="jumbotron">
	<div class="container">
		<h1>${title}</h1>
		<p>
			<c:forEach items="${contacts}" var="contact">
				<a href="contact/${contact.id}"> ${contact.firstName}
					${contact.lastName} </a>
				<p>
			</c:forEach>
		</p>
	</div>
</div>


</body>
</html>