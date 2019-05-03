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
                Total de Orden
                </h2>
                </footer>
                <br>
                <table border="1">
                    <c:forEach items="${requestScope.jugOrden}" var="jug">
                        <tr>
                            <td>
                                <c:out value="${jug.nombre}" />
                                <br />
                            </td>
                            <td>
                            	$
                                <c:out value="${jug.precio_proveedor}" />
                                <br />
                            </td>
                        </tr>

                        
                    </c:forEach>

                    <c:out value="${requestScope.error}" />
                </table>

    </article>
       <footer>
       Precio: $<c:out value ="${requestScope.orden.cantidad_total}" />
        <br>
        <br>
         <br>
    </form>

    <form method="post" action="./TerminarOrdenDeCompra">
	        <input type="text" id="DiaDeSolicitud"  name="DiaDeSolicitud" placeholder="Dia solicitud" >
	        <input type="text" name="MesDeSolicitud" id="MesDeSolicitud" placeholder="Mes solicitud" >
	        <input type="text" name="AnioDeSolicitud" id= "AnioDeSolicitud" placeholder="Anio solicitud" >
	        <br>
	        <input type="text" id="DiaDeEntrega" name="DiaDeEntrega" placeholder="Dia entrega" >
	        <input type="text" name="MesDeEntrega" id="MesDeEntrega" placeholder="Mes entrega" >
	        <input type="text" name="AnioDeEntrega" id="AnioDeEntrega" placeholder="Anio entrega" >
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
