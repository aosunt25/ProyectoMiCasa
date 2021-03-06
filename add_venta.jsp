<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>

<head>
    <title>Add Venta</title>
    <%@page contentType="text/html"%>
    <%@page pageEncoding="UTF-8"%>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" type="text/css" href="css/styles.css">
    <link rel="stylesheet" type="text/css" href="css/add_venta-styles.css">
    <link rel="stylesheet" type="text/css" href="css/especial.css">

</head>

<style type="text/css">
    article {
        float: left;
        padding: 20px;
        width: 60%;
        background-color: #f1f1f1;
        height: 300px;
        /* only for demonstration, should be removed */
    }

    nav {
        float: left;
        width: 30%;
        height: 300px;
        padding: 20px;
        /* only for demonstration, should be removed */
        background: #ccc;

    }

    section:after {
        content: "";
        display: table;
        clear: both;
    }

    footer {
        background-color: #777;
        padding: 10px;
        text-align: center;
        color: white;


    }

</style>

<body>
    <h1>Añadir nueva venta</h1>
    <br>


    <form method="post" action="./AgregarVenta">
        <br>


        <ul>
            <section>
                <nav>
                    <li>
                        <h2>Num. De Venta:
                            <c:out value="${requestScope.ventas.id}" />
                        </h2>

                    </li>
                    <input type="hidden" name="NumVentas" id="NumVentas" value="${requestScope.ventas.id}" />

                    <br>
                    <br>
                    <li> <select class="especial" id="JugueteID" name="JugueteID">
                            <option value="">Nombre Juguetes</option>
                            <c:forEach items="${requestScope.juguete}" var="jug">
                                <option value="${jug.id}">
                                    <c:out value="${jug.nombre}"></c:out>
                                </option>
                            </c:forEach>

                        </select></li>
                    <br>
                    <br>
                    <li><input class="especial" type="text" name="Cantidad" placeholder="cantidad"></li>
                    <br>

                    <li><input class="btt-settings" type="submit" value="Agregar"></li>
                    <br>
                </nav>





                <article>
                    <footer>
                        <h2>
                            Total de venta
                        </h2>
                    </footer>
                    <br>
                    <h2>
                        <table border="1">
                            <c:forEach items="${requestScope.juguetes}" var="jug">
                                <tr>
                                    <td>
                                        <c:out value="${jug.nombre}" />
                                        <br />
                                    </td>
                                    <td>
                                        <c:out value="${jug.cantidad}" />
                                        <br />
                                    </td>
                                    <td>
                                        $
                                        <c:out value="${jug.precio}" />
                                        <br />
                                    </td>
                                    <td>
                                        <form method="post" action="./BorrarJugueteDeVenta">
                                            <input class="user-list button_settings" type="submit" value="Borrar">
                                            <input type="hidden" name="Id" id="Id" value="${jug.id}" />
                                            <input type="hidden" name="NumVentas" id="NumVentas" value="${requestScope.ventas.id}" />
                                            <input type="hidden" name="Cantidad" id="Cantidad" value="${jug.cantidad}" />

                                        </form>
                                    </td>
                                </tr>


                            </c:forEach>

                            <c:out value="${requestScope.error}" />
                        </table>
                    </h2>



                </article>
                <footer>
                    <br>
                    <h2>
                        Precio $
                        <c:out value="${requestScope.ventas.precioTot}" />
                    </h2>
                </footer>
            </section>



        </ul>
        <br>
        <form method="post" action="./ConsultarVentas">
            <input class="button_settings-1" type="submit" value="Terminar">
        </form>
        <br>
        <br>


</body>

</html>
