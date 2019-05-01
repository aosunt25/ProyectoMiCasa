<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>

<style type="text/css">
    article {
  float: left;
  padding: 20px;
  width: 60%;
  background-color: #f1f1f1;
  height: 300px; /* only for demonstration, should be removed */
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

</style>

<head>
    <title>Consultar Venta</title>
    <meta charset=utf-8>
    <link rel="stylesheet" type="text/css" href="css/styles.css">
    <link rel="stylesheet" type="text/css" href="css/add_venta-styles.css">

</head>

<body>
    <h1>Consultar venta</h1>
    <br>
    <br>
    <br>

    
        <section>

             <nav>
                <br>
                <h2>
                Num. De Venta:
                    <c:out value="${requestScope.ventas.id}" />
                </h2>
                <input type="hidden" name="NumVentas" id="NumVentas" value="${requestScope.ventas.id}" />

                <br>
                <br>
                <br><br><br><br><br><br><br><br><br><br>
                Precio $
                <c:out value="${requestScope.ventas.precioTot}" />

                <br>    
               
                <br>
            </nav>

        
            <article>
                <br>
                    <table border="1">
                        <c:forEach items="${requestScope.juguetes}" var="jug">
                            <tr>
                                <td>
                                    &emsp;<c:out value="${jug.nombre}" />
                                    <br />
                                </td>
                                <td>
                                    x <c:out value="${jug.cantidad}" />
                                    <br />
                                </td>
                                <td>
                                    $
                                    <c:out value="${jug.precio}" />
                                    <br />
                                </td>
                            </tr>
                        </c:forEach>

                        <c:out value="${requestScope.error}" />
                    </table>

               
            </article>
            
            
        </section>
        </ul>
        
        <br>
        <form method="post" action="./ConsultarVentas">
            <input class="button_settings-1" type="submit" value="Regresar">
        </form>
        <br>
        <br>


</body>

</html>
