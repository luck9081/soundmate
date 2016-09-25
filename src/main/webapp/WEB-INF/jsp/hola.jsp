<!DOCTYPE html>
<html>
	<head>
	</head>
	
	<body>
	<%@ taglib uri="http://www.springframework.org/tags/form/" prefix="form" %>
		<form:form action="saludo" method="post" modelAttribute="Persona">
			<form:label>Nombre</form:label>
			<form:input path="Nombre" />
			<form:label>Apellido</form:label>
			<form:input path="Apellido" />
			<input type="submit" value="aceptar" />
		</form:form>	
	</body>
</html>
