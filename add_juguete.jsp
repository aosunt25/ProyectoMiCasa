<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>

<head>
    <title>Agregar Juguete</title>
    <meta charset=utf-8>
    <link rel="stylesheet" type="text/css" href="css/styles.css">
    <link rel="stylesheet" type="text/css" href="css/add_juguete-styles.css">

</head>

<body>
    <h1>Anadir juguete a inventario</h1>
    <br>
    <br>
    <br>

    <form method="post" action="./Juguetes">
        <br>
        <br>
        <br>

        <ul>
            <li><input class="formx" type="text" name="Juguete" id ="Juguete" placeholder="juguete" required></li>
            <li><input class="formx" type="text" name="Cantidad" id ="Cantidad" placeholder="cantidad"required></li>
            <li><input class="formx" type="text" name="Precio" id="Precio" placeholder="precio"required></li>

            <li> <select class="formx" id ="ProveedorId" name="ProveedorId">
                <option value="">Nombre Proveedor</option>
                <c:forEach items="${requestScope.proveedores}" var="prov">
                                    <option value="${prov.id}">
                                        <c:out value = "${prov.nombre}"></c:out>
                                    </option>
				 </c:forEach>

            </select></li>
            <li><input class="formx" type="text" name="Precio Proveedor" id="Precio Proveedor" placeholder="precioProveedor" required></li>
            <li><input class="formx" type="text" name="Categoria" id ="Categoria" placeholder="categoria" required></li>
            <li><input class="formx" type="text" name="Descripcion" id ="Descripcion" placeholder="descripcion" required></li>
            <br>
            <li><input class="user-list button_settings-1" type="submit" value="Agregar"></li>
        
        </ul>
    </form>
        <br>
        <form method="post" action="./ConsultaInventario">
        <input class="button_settings-1" type="submit" value="Regresar">
        </form>
    

   

</body>

</html>
