<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>

<head>
    <title>Editar Juguete</title>
    <meta charset=utf-8>
    <link rel="stylesheet" type="text/css" href="css/styles.css">

</head>

<body>
    <h1>Editar juguete del inventario</h1>
    <c itesm="${requestScope.jug}"/>
    <br>
    <br>
    <br>

    <form method="post" action="./EditarJuguetes">
        <br>
        <br>
        <br>

        <ul>    
            <li>Nombre: <input type="text" name="Juguete" id ="Juguete" placeholder="juguete" value="${jug.nombre}" ></li>
            <li>Cantidad: <input type="text" name="Cantidad" id ="Cantidad" placeholder="cantidad" value="${jug.cantidad}"></li>
            <li>Precio: <input type="text" name="Precio" id="Precio" placeholder="precio" value="${requestScope.jug.precio}"> </li>
            <input type= "hidden" name="Id" id = "Id" value="${jug.id}"/>
            <br>
            <li><input class="user-list" type="submit" value="Editar"></li>
        </ul>
    </form>
        
        
        <br>
        <form method="post" action="./ConsultaInventario">
        <input type="submit" value="Regresar"></a>
        </form>
    

    

</body>

</html>
