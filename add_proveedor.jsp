<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>

<head>
    <title>Add proveedores</title>
    <%@page contentType="text/html"%>
    <%@page pageEncoding="UTF-8"%>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" type="text/css" href="css/styles.css">
    <link rel="stylesheet" type="text/css" href="css/add_proveedor-styles.css">

</head>

<body>

    <form method="post" action="./AgregarProveedores">
        <h1>Añadir nuevo proveedor</h1>
        <br>
        <br>
        <br>
        <ul>
            <li><input class="user-list formx" type="text" name="Nombre" id="Nombre" placeholder="nombre proveedor"></li>
            <li><input class="user-list formx" type="text" name="Telefono" id="Telefono" placeholder="teléfono"></li>
            <br>
            <li><input class="user-list button_settings-1" type="submit" value="Agregar"> </li>

        </ul>

    </form>
    <br>
    <form method="post" action="./ConsultarProveedor">
        <input class="button_settings-1" type="submit" value="Regresar">
    </form>



</body>

</html>
