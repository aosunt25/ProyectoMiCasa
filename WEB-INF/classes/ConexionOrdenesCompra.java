import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import ordenesCompra.OrdenesCompra;
import java.util.Vector;

import javax.servlet.annotation.WebServlet;

@WebServlet("/AgregarOrdenDeCompra")
public class ConexionOrdenesCompra extends HttpServlet{

	public void doPost(HttpServletRequest request, HttpServletResponse response){

		try{
			String base = getServletContext().getInitParameter("base");
			String contraseña=getServletContext().getInitParameter("contraseña");
			String usuarioBase=getServletContext().getInitParameter("usuario");

			Class.forName("com.mysql.jdbc.Driver");


			//Despues de localhost va el nombre de la base

			String url = "jdbc:mysql://localhost/"+base+"?useSSL=false&allowPublicKeyRetrieval=true";
			
			

			//Parametros son direccion de la base, usuario y constraseña de mysql
			Connection con = DriverManager.getConnection(url,usuarioBase,contraseña);


			int id_juguete=Integer.parseInt(request.getParameter("JugueteID"));
			int cantidad = Integer.parseInt(request.getParameter("Cantidad"));
			int id_orden= Integer.parseInt(request.getParameter("NumOrden"));
			int id_proveedor=Integer.parseInt(request.getParameter("Proveedor"));
			Statement stat = con.createStatement();

			//double precio = 0;
		
			//String sql = "INSERT INTO Proveedor (nombre, contacto) VALUES ('1','1')";
			String sql = "SELECT * FROM Juguete, Orden_Compra WHERE Juguete.id = '"+id_juguete+"' and Orden_Compra.id ='"+id_orden+"';";
			//Hay que sumar todos los precios del agregar
			//Hay que restarle la cantidad a la tabla cantidad
			//Hay que mostrar el total en jsp
			//Hay que mostrar los juguetes en js
			ResultSet res = stat.executeQuery(sql);

			if(res.next()){

				double precioJuguete = res.getDouble("Juguete.precio_proveedor"); 
				double nuevoPrecio= res.getDouble("Orden_Compra.costo_total") + (cantidad * res.getDouble("Juguete.precio_proveedor"));
				sql = "UPDATE Orden_Compra SET costo_total ="+nuevoPrecio+" WHERE Orden_Compra.id ="+id_orden+";";
			
				stat.executeUpdate(sql);

				sql= "INSERT INTO Orden_Juguete (id_orden, id_juguete) VALUES ('"+id_orden+"', '"+id_juguete+"');";
				
				stat.executeUpdate(sql);
			}



		
				RequestDispatcher disp =  getServletContext().getRequestDispatcher("/error_orden.jsp");

				if(disp!=null){
					disp.forward(request,response);
				}

			
		

		}
		catch(Exception e){
			e.printStackTrace();
		}



	}

}
