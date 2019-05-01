<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
	<head>
		 <meta charset="utf-8">
		 <link rel="stylesheet" type="text/css" href="css/styles.css">
		 <link rel="stylesheet" type="text/css" href="css/prov-styles.css">
		 <!-- el link de arriba sirve para referenciar el archivo styles.css que se encuentra en la carpeta css, aquí le estás diciendo al programa que vas a usar este archivo para darle estilo a tu html-->

		  <link href="https://fonts.googleapis.com/css?family=Oswald" rel="stylesheet"> 
		  <link href="https://fonts.googleapis.com/css?family=Ubuntu:400,700" rel="stylesheet"> 
		  <link href="https://fonts.googleapis.com/css?family=Sniglet" rel="stylesheet"> 

		  <!-- el link de arriba sirve para referenciar un tipo de Font externa que se encuentra en la liga "href"-->

		<title>
			Proveedores
		</title>

	</head>
	<header>
    Proveedores

	</header>
	<body>
				<div class="div2">
					<table border="1">
					<c:forEach items="${requestScope.proveedores}" var="prov">
								<tr>
										<td>
							        <c:out value="${prov.nombre}" />
							      	<br />
										</td>
										<td>
									<form method="post" action="./SeleccionarJuguete">
										<input class="user-list button_settings" type="submit" value="Seleccionar">
										<input type= "hidden" name="Id" id = "Id" value="${prov.id}"/>
									</form>
								</tr>
							  </c:forEach>
				</table>				
					
				</div>
			
		
	</body>
</html>

