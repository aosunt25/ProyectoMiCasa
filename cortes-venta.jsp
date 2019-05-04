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
    <meta charset="utf-8">
    <link rel="stylesheet" type="text/css" href="css/styles.css">
    <link rel="stylesheet" type="text/css" href="css/crear_corte-styles.css">
    <!-- el link de arriba sirve para referenciar el archivo styles.css que se encuentra en la carpeta css, aquí le estás diciendo al programa que vas a usar este archivo para darle estilo a tu html-->

    <link href="https://fonts.googleapis.com/css?family=Oswald" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Ubuntu:400,700" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Sniglet" rel="stylesheet">

    <!-- el link de arriba sirve para referenciar un tipo de Font externa que se encuentra en la liga "href"-->

    <title>
        Cortes
    </title>

</head>
<header>
    <a href="menu.jsp"><img src="img/1.jpg"> Comercializadora MiCasa </a>
    &emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;<a href="index.html"><input class="button_settings-1" id="boton" type="button" value="Cerrar sesion"> </a>

    <br>




</header>

<body>
    <br>
    <br>
    <p class="lettering"> Cortes </p>
    <br>


    <div class="div1">
        <form method="post" action="./ConsultarVentas">
            <div class="quinto quinto_primero"><a href="ventas.jsp"><input class="button" type="submit" value="VENTAS"></a></div>
        </form>
        <form method="post" action="./ConsultaInventario">
            <div class="quinto"><a href="inventario.jsp"><input class="button" type="submit" value="INVENTARIO"></a></div>
        </form>
        <form method="post" action="./ConsultarOrden">
            <div class="quinto"><a href="ordenes.jsp"><input class="button" type="submit" value="ORDENES DE COMPRA"></a></div>
        </form>
        <form method="post" action="./ConsultarProveedor">
            <div class="quinto"><a href="proveedores.jsp"><input class="button" type="submit" value="PROVEEDORES"></a></div>
        </form>
        <form method="post" action="./ConsultarCorte">
            <div class="quinto"><a href="cortes-venta.jsp"><input class="button" type="submit" value="CORTES DE VENTA"></a></div>
        </form>
        </form>
        <!--<p class="charge">Charge of the Uber trip: <input type="text" name="n1" id="n1" /></p>-->


        <br />
    </div>
    <br>

    <br>
    <section>


        <div class="edicion">
            <div class="tercio tercio_primero">
                Intervalo de fechas
            </div>

        </div>
        <section>
            <form method="post" action="./Corte">
                <ul class="user-list">
                    <li><input type="text" name="DiaDeSolicitud" placeholder="Dia" class="formx"><input type="text" name="MesDeSolicitud" placeholder="Mes" class="formx"><input type="text" name="AnioDeSolicitud" placeholder="Anio" class="formx" required></li>

                    <li><input type="text" name="DiaDeEntrega" placeholder="Dia" class="formx"><input type="text" name="MesDeEntrega" placeholder="Mes" class="formx"><input type="text" name="AnioDeEntrega" placeholder="Anio" class="formx" required></li>

                    <br>
                    <li><input class="button_settings-1" type="submit" value="Filtrar"></li>
                    <br>
                    Ventas Realizadas:
                    <c:out value="${requestScope.cantidad}" />
                    <br>
                    Ganancias en el periodo: $
                    <c:out value="${requestScope.precioTot}" />

                </ul>
            </form>

            </div>
        </section>
        <br>
        <br>
        <div class="div3">
            <div class="quinto center">No.</div>
            <div class="quinto center">FECHA</div>
            <div class="quinto center">HORA</div>
            <div class="quinto center">TOTAL</div>

        </div>


    </section>
    <div class="div2">
        <div class="ex1 ">
            <table border="1">
                <c:forEach items="${requestScope.ventas}" var="ven">
                    <tr>
                        <td>
                            &emsp;&emsp;&emsp;
                            <c:out value="${ven.id}" />
                            <br />
                        </td>
                        <td>
                            &emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;
                            <c:out value="${ven.fecha}" />
                            <br />
                        </td>
                        <td>
                            &emsp;&emsp;&emsp;&emsp;&emsp;&emsp;
                            <c:out value="${ven.hora}" />
                            <br />

                        <td>
                            &emsp;&emsp;&emsp;&emsp;&emsp;&emsp;$
                            <c:out value="${ven.precioTot}" />
                            <br />
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>

    </div>

</body>

</html>
