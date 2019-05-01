<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>

<head>
    <title>Editar proveedor</title>
    <meta charset=utf-8>
    <link rel="stylesheet" type="text/css" href="css/styles.css">
    <link rel="stylesheet" type="text/css" href="css/add_venta-styles.css">    
</head>

<h1>Se edito con exito el proveedor</h1>
<br>
<h1></h1>
<br>
<br>

<body>

    
    <div>
        <form action="./EditarProveedor" method="post">
            <input class="button_settings-1" type="submit" value="Regresar">
            <input type= "hidden" name="Id" id = "Id" value="${prov.id}"/>
            <input type= "hidden" name="Proveedor" id = "Proveedor" value="${prov.nombre}"/>
            <input type= "hidden" name="Telefono" id = "Telefono" value="${prov.telefono}"/>
            <input type="hidden" name="Editado" id="Editado" value="0">
        </form>

    </div>
</body>

</html>
