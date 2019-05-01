<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>

<head>
    <title>Editar Juguete</title>
    <meta charset=utf-8>
    <link rel="stylesheet" type="text/css" href="css/styles.css">
    <link rel="stylesheet" type="text/css" href="css/editar_juguete-styles.css">

</head>

<body>
    <h1>Editar juguete del inventario</h1>
    <c itesm="${requestScope.jug}" />
    <br>
    <br>
    <br>

    <form method="post" action="./EditarJuguetes">
        <br>
        <br>
        <br>

        <ul>
            <li>Nombre: <input class="formx" type="text" name="Juguete" id="Juguete" placeholder="juguete" value="${jug.nombre}"></li>
            <li>Cantidad: <input class="formx" type="text" name="Cantidad" id="Cantidad" placeholder="cantidad" value="${jug.cantidad}"></li>
            <li>Precio: <input class="formx" type="text" name="Precio" id="Precio" placeholder="precio" value="${requestScope.jug.precio}"> </li>
            <input type="hidden" name="Id" id="Id" value="${jug.id}" />
            <br>
            <li><input class="user-list button_settings-1" type="submit" value="Editar"></li>
        </ul>
    </form>


    <br>
    <form method="post" action="./ConsultaInventario">
        <input class="button_settings-1" type="submit" value="Regresar">
    </form>




</body>

</html>
