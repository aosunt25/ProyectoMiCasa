<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>

<head>
    <%@page contentType="text/html"%>
    <%@page pageEncoding="UTF-8"%>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" type="text/css" href="css/styles.css">
    <link rel="stylesheet" type="text/css" href="css/menu-styles.css">
    <!-- el link de arriba sirve para referenciar el archivo styles.css que se encuentra en la carpeta css, aquí le estás diciendo al programa que vas a usar este archivo para darle estilo a tu html-->

    <link href="https://fonts.googleapis.com/css?family=Oswald" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Ubuntu:400,700" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Sniglet" rel="stylesheet">

    <!-- el link de arriba sirve para referenciar un tipo de Font externa que se encuentra en la liga "href"-->

    <title>
        Menú principal
    </title>

</head>
<header>
    <a href="menu.jsp"><img src="img/1.jpg"> Comercializadora MiCasa </a>
    &emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;<a href="index.html"><input class="button_settings-1" id="boton" type="button" value="Cerrar sesión"> </a>


</header>

<body>
    <br>
    <br>
    <p class="lettering"> Menú principal </p><a href="index.html">
        <br>
        <a href="new_user.jsp">Crear Nuevo Usuario</a>
        <br>
        <br>



        <div class="div1">

            <form method="post" action="./ConsultarVentas">
                <div class="quinto quinto_primero"><a href="ventas.jsp"><input class="button" type="submit" value="VENTAS"></a></div>
            </form>
            <form method="post" action="./ConsultaInventario">
                <div class="quinto"><a href="inventario.jsp"><input class="button" type="submit" value="INVENTARIO"></a></div>
            </form>
            <form method="post" action="./ConsultarOrden">
                <div class="quinto"><a href="ordenes.jsp"><input class="button" type="submit" value="ÓRDENES DE COMPRA"></a></div>
            </form>
            <form method="post" action="./ConsultarProveedor">
                <div class="quinto"><a href="proveedores.jsp"><input class="button" type="submit" value="PROVEEDORES"></a></div>
            </form>
            <form method="post" action="./ConsultarCorte">
                <div class="quinto"><a href="cortes-venta.jsp"><input class="button" type="submit" value="CORTES DE VENTA"></a></div>
            </form>

            <!--<p class="charge">Charge of the Uber trip: <input type="text" name="n1" id="n1" /></p>-->


            <br />
        </div>
        <div class="div2">


        </div>
        </form>
        <br>


</body>

</html>
