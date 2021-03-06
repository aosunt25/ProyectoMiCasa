<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>

<style type="text/css">
    article {
        float: left;
        padding: 20px;
        width: 60%;
        text-align: left;
        background-color: #f1f1f1;
        height: 300px;
        /* only for demonstration, should be removed */
    }

    nav {
        float: left;
        width: 40%;
        height: 300px;
        padding: 20px;
        text-align: center;
        /* only for demonstration, should be removed */
        background: #ccc;

    }

    section:after {
        content: "";
        display: table;
        clear: both;
    }


    header {
        background-color: #666;
        padding: 15px;
        text-align: center;
    }

    div.ex1 {
        width: 100%;
        height: 500px;
        overflow: scroll;
    }

</style>

<head>
    <title>Crear Órdenes</title>
    <%@page contentType="text/html"%>
    <%@page pageEncoding="UTF-8"%>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" type="text/css" href="css/styles.css">
    <link rel="stylesheet" type="text/css" href="css/crear_oc-styles.css">
    <link rel="stylesheet" type="text/css" href="css/especial.css">
    <link rel="stylesheet" type="text/css" href="css/crear_corte-styles.css">

</head>

<body>
    <h1>Crear una nueva órden de compra</h1>
    <br>
    <br>
    <br>
    <form method="post" action="./AgregarOrdenDeCompra">
        <section>
            <nav>
                <footer>
                    <br>
                    <h2> Nombre del Proveedor:
                        <c:out value="${requestScope.proveedor.nombre}" />
                    </h2>
                    <br>
                    <br>
                </footer>
                <br>
                <tab class="ex1">
                    <select class="especial" id="JugueteID" name="JugueteID">
                        <option value="">Nombre Juguetes</option>
                        <c:forEach items="${requestScope.juguetes}" var="jug">
                            <option value="${jug.id}">
                                <c:out value="${jug.nombre}"></c:out>
                            </option>
                        </c:forEach>

                    </select>
                    <br>
                    <br>
                    <input class="especial" type="text" name="Cantidad" placeholder="cantidad">
                    <br>
                    <br>
                    <br>
                    <input class="btt-settings" type="submit" value="Agregar">
                    <input type="hidden" name="Proveedor" id="Proveedor" value="${requestScope.proveedor.id}">
                    <input type="hidden" name="NumOrden" id="NumOrden" value="${requestScope.orden.id}" />

            </nav>
    </form>
    <article>
        <footer>
            <br>
            <h2>
                Total de Órden
            </h2>
        </footer>
        <br>
        <h2>
            <table border="1">
                <c:forEach items="${requestScope.jugOrden}" var="jug">
                    <tr>
                        <td>
                            <c:out value="${jug.nombre}" />
                            <br />
                        </td>
                        <td>
                            $
                            <c:out value="${jug.precio_proveedor}" /> por unidad
                            <br />
                        </td>

                        <td>
                            <!-- <form method="post" action="./BorrarJugueteDeOrden">
                                    <input class="user-list button_settings" type="submit" value="Borrar">
                                    <input type="hidden" name="Id" id="Id" value="${jug.id}" />
                                    <input type="hidden" name="NumVentas" id="NumVentas" value="${requestScope.ventas.id}" />
                                    <input type="hidden" name="Cantidad" id="Cantidad" value="${jug.precio_proveedor}" />

                                </form> -->
                        </td>

                    </tr>


                </c:forEach>

                <c:out value="${requestScope.error}" />
            </table>
        </h2>


    </article>
    <footer>
        <h2>Precio: $
            <c:out value="${requestScope.orden.cantidad_total}" />
        </h2>
        <br>
        <br>
        <br>
        </form>

        <div>
            <form method="post" action="./TerminarOrdenDeCompra">
                <ul class="user-list">
                    <li><input type="text" name="DiaDeSolicitud" placeholder="Día" class="formx"><input type="text" name="MesDeSolicitud" placeholder="Mes" class="formx"><input type="text" name="AnioDeSolicitud" placeholder="Año" class="formx" required></li>

                    <li><input type="text" name="DiaDeEntrega" placeholder="Día" class="formx"><input type="text" name="MesDeEntrega" placeholder="Mes" class="formx"><input type="text" name="AnioDeEntrega" placeholder="Año" class="formx" required></li>


        </div>





        <br>



        <br>
        <br>
    </footer>
    </section>
    <br>
    <input class="button_settings-1" type="submit" value="Terminar">
    <input type="hidden" name="NumOrden" id="NumOrden" value="${requestScope.orden.id}" />
    </form>

</body>

</html>
