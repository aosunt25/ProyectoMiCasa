<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>

<head>
    <title>Editar Juguete</title>
    <meta charset=utf-8>
    <link rel="stylesheet" type="text/css" href="css/styles.css">

</head>

<body>
    <h1>Editar juguete del inventario</h1>
    <c itesm="${requestScope.prov}"/>
    <br>
    <br>
    <br>

    <form method="post" action="./EditarProveedor">
        <br>
        <br>
        <br>

        <ul>    
            <li>Nombre: <input type="text" name="Proveedor" id ="Proveedor" placeholder="proveedor" value="${prov.nombre}" ></li>
            <li>Telefono: <input type="text" name="Telefono" id ="Telefono" placeholder="contacto" value="${prov.telefono}"></li>
            <input type= "hidden" name="Id" id = "Id" value="${prov.id}"/>
            <br>
            <li><input class="user-list" type="submit" value="Editar"></li>
        </ul>
    </form>
        
        
        <br>
    
        <br>
        <form method="post" action="./ConsultarProveedor">
        <input type="submit" value="Regresar"></a>
        </form>
    

    

</body>

</html>
