<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<style type="text/css">
    div.ex1 {
        width: 800px;
        height: 500px;
        overflow: scroll;
    }

</style>

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
        Órdenes de compra
    </title>

</head>
<header>
    <a href="menu.jsp"><img src="img/1.jpg"> Comercializadora MiCasa</a>
    &emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;<a href="index.html"><input class="button_settings-1" id="boton" type="button" value="Cerrar sesión"> </a>

</header>

<body>
    <br>
    <br>
    <p class="lettering"> Órdenes de compra </p>
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
    <br>
    <section>


        <div class="edicion">
            <div class="tercio tercio_primero">
                <form method="post" action="./ConsultarProveedorOrden">
                    <input class="button_settings" type="submit" name="+" value="+"></a>
                </form>
            </div>






        </div>


        <div class="div3">
            <div class="quinto quinto_primero center">No.</div>
            <div class="quinto quinto_primero center">PROVEEDOR</div>
            <div class="quinto center">FECHA DE ENTREGA</div>
            <div class="quinto center">COSTO TOTAL</div>

        </div>



    </section>
    <div class="div2">
        <div class="ex1">
            <table border="1">
                <c:forEach items="${requestScope.ordenes}" var="orden">
                    <tr>
                        <td>
                            &emsp;&emsp;&emsp;&emsp;
                            <c:out value="${orden.id}" />
                            <br />
                        </td>
                        <td>
                            &emsp;&emsp;&emsp;&emsp;&emsp;&emsp;
                            <c:out value="${orden.proveedor}" />
                            <br />
                        </td>
                        <td>
                            &emsp;&emsp;&emsp;&emsp;
                            <c:out value="${orden.fechaPedido}" />
                            <br />
                        </td>
                        <td>
                            &emsp;&emsp;&emsp;&emsp;&emsp;&emsp;
                            <c:out value="${orden.cantidad_total}" />&emsp;&emsp;&emsp;&emsp;
                            <br />
                        </td>
                        <td>
                            <form method="post" action="./ConsultarPorOrden">
                                <input class="user-list button_settings" type="submit" value="Mostrar">
                                <input type="hidden" name="Id" id="Id" value="${orden.id}" />
                            </form>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>

</body>

</html>
