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
    <title>Consultar Orden De Compra</title>
    <meta charset=utf-8>
    <link rel="stylesheet" type="text/css" href="css/styles.css">
    <link rel="stylesheet" type="text/css" href="css/add_venta-styles.css">

</head>

<body>
    <h1>Consultar Orden de Compra</h1>
    <br>
    <br>
    <br>

    
        <section>

             <nav>
                <br>
                <h2>
                Num. De Orden de Compra:
                    <c:out value="${requestScope.orden.id}" />
                </h2>
                <br><br>
                <h3>
                Nombre del Proveedor:
                    <c:out value="${requestScope.prov.nombre}"/>
                </h3>
            
                <br>
                <br>
                <br><br><br><br><br><br><br><br>
                Precio $
                <c:out value="${requestScope.orden.cantidad_total}" />

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
                                    $
                                    <c:out value="${jug.precio_proveedor}" />
                                    <br />
                                </td>
                            </tr>
                        </c:forEach>

                        
                    </table>

               
            </article>
            
            
        </section>
        </ul>
        
        <br>
        <form method="post" action="./ConsultarOrden">
            <input class="button_settings-1" type="submit" value="Regresar">
        </form>
        <br>
        <br>


</body>

</html>
