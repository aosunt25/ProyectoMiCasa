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
  text-align: left;
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
    <form method="post" action = "./CrearOrdenCompra">
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
            <c:forEach items="${requestScope.juguetes}" var="jug" >
                        <input type="checkbox" name= "id" value="${jug.id}" id="id">
                        <c:out value="${jug.nombre}  ${jug.precio_proveedor}" />
                        <input type="number" name="cantidad" id = "cantidad" placeholder="Cantidad">
                        </br>
                        
                        
                
            </c:forEach>
            </div>
   
    </nav>
    <article>
        
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
    <input class="button_settings-1" type="submit" value="Regresar">
    </form>
 
</body>

</html>
