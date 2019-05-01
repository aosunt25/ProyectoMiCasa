<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>

<head>
    <title>Editar Juguete</title>
    <meta charset=utf-8>
    <link rel="stylesheet" type="text/css" href="css/styles.css">
    <link rel="stylesheet" type="text/css" href="css/editar_juguete-styles.css">

</head>

<body>
    <h1>Editar datos del proveedor</h1>
    <c itesm="${requestScope.prov}"/>
    <br>
    

    <form method="post" action="./EditarProveedor">
        <br>
        <br>
        <br>

        <ul>    
            <li>Nombre: <input class="formx" type="text" name="Proveedor" id ="Proveedor" placeholder="proveedor" value="${prov.nombre}" ></li>
            <li>Telefono: <input class="formx" type="text" name="Telefono" id ="Telefono" placeholder="contacto" value="${prov.telefono}"></li>
            <input type= "hidden" name="Id" id = "Id" value="${prov.id}"/>
            <input type="hidden" name="Editado" id="Editado" value="1">
            <br>
            <li><input class="user-list button_settings-1" type="submit" value="Editar"></li>
        </ul>
    </form>
        
        
        <br>
    
        <br>
        <form method="post" action="./ConsultarProveedor">
        <input class="button_settings-1" type="submit" value="Regresar">
        </form>
    

    

</body>

</html>
