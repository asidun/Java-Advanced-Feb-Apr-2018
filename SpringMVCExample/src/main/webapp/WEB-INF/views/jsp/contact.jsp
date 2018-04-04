<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
</head>

<div class="jumbotron">
	<div class="container">
		<h1>${contact.firstName} ${contact.lastName}</h1>
		<p>
			<c:forEach items="${contact.telDetails}" var="tel">
				 ${tel.telType}: ${tel.telNumber}
				<p>
			</c:forEach>
		</p>
	</div>
</div>


</body>
</html>