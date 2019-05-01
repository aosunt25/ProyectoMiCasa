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
    <link rel="stylesheet" type="text/css" href="css/styles.css">
    <link rel="stylesheet" type="text/css" href="css/menu-styles.css">
    <!-- el link de arriba sirve para referenciar el archivo styles.css que se encuentra en la carpeta css, aquí le estás diciendo al programa que vas a usar este archivo para darle estilo a tu html-->

    <link href="https://fonts.googleapis.com/css?family=Oswald" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Ubuntu:400,700" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Sniglet" rel="stylesheet">

    <!-- el link de arriba sirve para referenciar un tipo de Font externa que se encuentra en la liga "href"-->

    <title>
        Ventas
    </title>

</head>
<header>
    <a href="menu.jsp"><img src="img/1.jpg"> Comercializadora MiCasa </a>

    &emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;<a href="index.html"><input class="button_settings-1" id="boton" type="button" value="Cerrar sesion"> </a>

</header>

<body>
    <br>
    <br>
    <p class="lettering"> Ventas </p>
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
        <!--<p class="charge">Charge of the Uber trip: <input type="text" name="n1" id="n1" /></p>-->


        <br />
    </div>
    <br>
    <section>


        <div class="edicion">
            <div class="tercio tercio_primero">
                <form method="post" action="./CrearVenta">
                    <input class="button_settings" type="submit" name="+" value="+">
                </form>
            </div>
            <form method="post" action="./BuscarVenta">
                <input type="text" name="Venta" id="Venta" placeholder="Buscar Venta"><input class="user-list button_settings"  type="submit" value="Buscar">
            </form>
               
            <form method="post" action="./ConsultarVentas">
                 <input class="user-list button_settings"  type="submit" value="Reiniciar Busqueda">
            </form>


        </div>
        <br><br><br><br><br><br>

        <div class="div3">
            <div class="quinto quinto_primero center">No.</div>
            <div class="quinto center">FECHA</div>
            <div class="quinto center">HORA</div>
            <div class="quinto center">PRECIO TOTAL</div>

        </div>



    </section>
    <div class = "div2">
        <div class="ex1">
            <table border="1">
                <c:forEach items="${requestScope.ventas}" var="ven">
                    <tr>
                        <td>
                             &emsp;&emsp;&emsp;&emsp;<c:out value="${ven.id}" />
                            <br />
                        </td>
                        <td>
                             &emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;<c:out value="${ven.fecha}" />
                            <br />
                        </td>
                        <td>
                            &emsp;&emsp;&emsp;&emsp;&emsp;&emsp;<c:out value="${ven.hora}" />
                            <br />

                        <td>
                            &emsp;&emsp;&emsp;&emsp;&emsp;&emsp;<c:out value="${ven.precioTot}" />
                            &emsp;&emsp;&emsp;&emsp;&emsp;&emsp;
                            <br />
                        </td>
                        <td>
                        <td>
                            <form method="post" action= "./ConsultarPorVenta">
                            <input class="user-list button_settings" type="submit" value="Mostrar">
                            <input type= "hidden" name="Id" id = "Id" value="${ven.id}"/>  
                            </form>
                        </td>
                        
                        </form>
                            
                        </td>
                    </tr>
                </c:forEach>
            </table>

        </div>
    </div>

</body>

</html>
