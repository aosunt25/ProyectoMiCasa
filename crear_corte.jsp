<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>

<head>
    <title>Registrar Corte</title>
    <meta charset=utf-8>
    <link rel="stylesheet" type="text/css" href="css/styles.css">

</head>

<body>
    <h1>Registrar un nuevo corte de ventas</h1>
    <br>
    <br>
    <br>

    <ul>
      <li><input class="user-list" type="text" name="Numero Id" placeholder="numero id"></li>  
      <li><input class="user-list" type="text" name="Fecha" placeholder="fecha"></li>  
      <li><input class="user-list" type="text" name="Hora" placeholder="hora"></li>  
      <li><input class="user-list" type="text" name="Artículos vendidos" placeholder="artículos"></li>  
      <li><input class="user-list" type="text" name="Precio Total" placeholder="precio total"></li>  <input class="user-list" type="text" name="Precio Total" placeholder="precio total">
      <br>
      <li><input class="user-list" type="button" value="ADD"></li>  

    </ul>


    <br>
    <form method="post" action="./ConsultarOrden">
    <input type="submit" value="Regresar"></a>
    </form>

</body>

</html>
