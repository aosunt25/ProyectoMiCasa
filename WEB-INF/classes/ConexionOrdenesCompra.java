import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import ordenesCompra.OrdenesCompra;
import juguetes.Juguete;
import java.util.Vector;
import proveedores.Proveedor;

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

			double nuevoPrecio=0;

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
				nuevoPrecio= res.getDouble("Orden_Compra.costo_total") + (cantidad * res.getDouble("Juguete.precio_proveedor"));
				int cantidadTotal= res.getInt("Orden_Compra.total_de_juguetes")+cantidad;
				sql = "UPDATE Orden_Compra SET costo_total ="+nuevoPrecio+" WHERE Orden_Compra.id ="+id_orden+";";
			
				stat.executeUpdate(sql);

				sql = "UPDATE Orden_Compra SET total_de_juguetes ="+cantidadTotal+" WHERE Orden_Compra.id ="+id_orden+";";

				stat.executeUpdate(sql);

				sql= "INSERT INTO Orden_Juguete (id_orden, id_juguete) VALUES ("+id_orden+","+id_juguete+");";
				
				stat.executeUpdate(sql);
			}

			sql = "SELECT * FROM Juguete WHERE id_proveedor = '"+id_proveedor+"'";

			res = stat.executeQuery(sql);

			Vector<Juguete> juguetes = new Vector<Juguete>();

			while(res.next()){
				
				Juguete jug = new Juguete();
					jug.setNombre(res.getString("Juguete.nombre"));
					jug.setPrecio(res.getDouble("Juguete.precio"));
					jug.setPrecioProv(res.getDouble("Juguete.precio_proveedor"));
					jug.setCategoria(res.getString("Juguete.categoria"));
					jug.setDescripcion(res.getString("Juguete.descripcion"));
					jug.setCantidad(res.getInt("Juguete.cantidad"));
					jug.setID(res.getInt("Juguete.id"));

					juguetes.add(jug);
			}

			sql = "SELECT * FROM Proveedor WHERE id = '"+id_proveedor+"'";

			res = stat.executeQuery(sql);
			Proveedor proveedor = new Proveedor();

			if(res.next()){
				proveedor.setNombre(res.getString("nombre"));
				proveedor.setID(res.getInt("id"));
			}

			OrdenesCompra orden = new OrdenesCompra();
			orden.setId(id_orden);


			sql = "SELECT * FROM Orden_Juguete, Juguete WHERE Juguete.id=Orden_Juguete.id_juguete and id_orden = "+id_orden+";";
			res = stat.executeQuery(sql);
			
			Vector<Juguete>  jugOrden = new Vector<Juguete> ();

			while(res.next()){
				
				Juguete jug = new Juguete();
				jug.setNombre(res.getString("Juguete.nombre"));
				jug.setPrecioProv(res.getDouble("Juguete.precio_proveedor"));
				jug.setID(res.getInt("Juguete.id"));

				jugOrden.add(jug);

			}

			sql= "SELECT * FROM Orden_Compra WHERE id='"+id_orden+"';";

			res=stat.executeQuery(sql);

			if(res.next()){
				orden.setCantidadTotal(res.getDouble("costo_total"));
			}

			stat.close();
			con.close();

			request.setAttribute("orden",orden);
			request.setAttribute("jugOrden",jugOrden);
			request.setAttribute("proveedor", proveedor);
			request.setAttribute("juguetes",juguetes);
		
			RequestDispatcher disp =  getServletContext().getRequestDispatcher("/crear_orden_compra.jsp");

			if(disp!=null){
				disp.forward(request,response);
			}

			
		

		}
		catch(Exception e){
			e.printStackTrace();
		}



	}

}
