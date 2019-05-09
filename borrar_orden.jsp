<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>

<head>
    <title>Borrar Juguete</title>
    <%@page contentType="text/html"%>
    <%@page pageEncoding="UTF-8"%>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" type="text/css" href="css/styles.css">
    <link rel="stylesheet" type="text/css" href="css/borrar_oc-styles.css">

</head>

<body>
    <h1>Borrar órden de Compra </h1>
    <br>
    <br>
    <br>

    <form method="post" action="./BorrarOrden">
        <br>
        <br>
        <br>

        <ul>
            <li><input type="text" name="Orden" id="borrarOrd" placeholder="órden"></li>
            <li><input type="text" name="ID" id="borrarOrd" placeholder="id órden"></li>

            <li><input class="user-list button_settings-1" type="submit" value="Borrar"></li>

        </ul>
        <br>
        <form method="post" action="./ConsultarOrden">
            <a href="ordenes.jsp"><input class="button_settings-1" type="button" value="Regresar"></a>
        </form>


    </form>

</body>

</html>
