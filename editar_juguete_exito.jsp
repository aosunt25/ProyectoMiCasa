<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>

<head>
    <title>Editar  juguete</title>
    <meta charset=utf-8>
    <link rel="stylesheet" type="text/css" href="css/styles.css">
    <link rel="stylesheet" type="text/css" href="css/add_venta-styles.css">    
</head>

<h1>Se edito con exito el juguete</h1>
<br>
<h1></h1>
<br>
<br>

<body>

    
    <div>
        <form action="./EditarJuguetes" method="post">
            <input class="button_settings-1" type="submit" value="Regresar">
            <input type="hidden" name="Juguete" id="Juguete" placeholder="juguete" value="${jug.nombre}"></li>
            <input type="hidden" name="Cantidad" id="Cantidad" placeholder="cantidad" value="${jug.cantidad}"></li>
            <input type="hidden" name="Precio" id="Precio" placeholder="precio" value="${requestScope.jug.precio}"> </li>
            <input type="hidden" name="Id" id="Id" value="${jug.id}" />
            <input type="hidden" name="Editado" id="Editado" value="0">
        </form>

    </div>
</body>

</html>
