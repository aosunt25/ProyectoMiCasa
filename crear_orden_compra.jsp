<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>

<style type="text/css">
    article {
  float: left;
  padding: 20px;
  width: 60%;
  text-align: left;
  background-color: #f1f1f1;
  height: 300px; /* only for demonstration, should be removed */
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
    <title>Crear Ordenes</title>
    <meta charset=utf-8>
    <link rel="stylesheet" type="text/css" href="css/styles.css">
    <link rel="stylesheet" type="text/css" href="css/crear_oc-styles.css">

</head>

<body>
    <h1>Crear una nueva orden de compra</h1>
    <br>
    <br>
    <br>
    <form method="post" action = "./AgregarOrdenDeCompra">
    <section>
    <nav>
        <footer>
             <br>
            Nombre del Proveedor: <c:out value = "${requestScope.proveedor.nombre}"/>
             <br>
             <br>
        </footer>      
            <br>
            <tab class = "ex1">
            <select id ="JugueteID" name="JugueteID">
                <option value="">Nombre Juguetes</option>
                <c:forEach items="${requestScope.juguetes}" var="jug">
                    <option value="${jug.id}">
                        <c:out value = "${jug.nombre}"></c:out>
                    </option>
                 </c:forEach>

            </select>
            <br>
            <br>
            <input type="text" name="Cantidad" placeholder="cantidad">
                <br>
                <br>
             	<br>
               <input type="submit" value="Agregar">
               <input type="hidden" name="Proveedor" id = "Proveedor" value="${requestScope.proveedor.id}">
               <input type="hidden" name="NumOrden" id="NumOrden" value="${requestScope.orden.id}" />
   
    </nav>
   </form>
    <article>
        <footer>
                <h2>
                Total de venta
                </h2>
                </footer>
                <br>
                <table border="1">
                    <c:forEach items="${requestScope.juguete}" var="jug">
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
    </article>
       <footer>
        <br>
        <br>
         <br>
        <input type="text" name="DiaDeSolicitud" placeholder="Dia solicitud" ><input type="text" name="MesDeSolicitud" placeholder="Mes solicitud" ><input type="text" name="AnioDeSolicitud" placeholder="Anio solicitud" >
        <br>
        <input type="text" name="DiaDeEntrega" placeholder="Dia entrega" ><input type="text" name="MesDeEntrega" placeholder="Mes entrega" ><input type="text" name="AnioDeEntrega" placeholder="Anio entrega" >
        <br>
        <br>
    </footer>
    </section>
    </form>
    <br>
    <form method="post" action="./ConsultarOrden">
    <input class="button_settings-1" type="submit" value="Terminar">
    </form>
 
</body>

</html>
