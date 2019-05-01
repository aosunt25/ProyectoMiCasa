import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import java.util.Date;
import java.text.SimpleDateFormat; 
import ordenesCompra.OrdenesCompra;
import java.util.Vector;

import javax.servlet.annotation.WebServlet;


@WebServlet("/ConsultarOrden")
public class ConsultarOrden extends HttpServlet{

	public void doPost(HttpServletRequest request, HttpServletResponse response){

		try{
			String base = getServletContext().getInitParameter("base");
			String contraseña=getServletContext().getInitParameter("contraseña");
			String usuarioBase=getServletContext().getInitParameter("usuario");

			Class.forName("com.mysql.jdbc.Driver");

			String url = "jdbc:mysql://localhost/"+base+"?useSSL=false&allowPublicKeyRetrieval=true";
			
			//System.out.println(url);

			//Parametros son direccion de la base, usuario y constraseña de mysql
			Connection con = DriverManager.getConnection(url,usuarioBase,contraseña);
			

			Statement stat = con.createStatement();
			String sql = "SELECT * FROM Orden_Compra, Proveedor";

			ResultSet res = stat.executeQuery(sql);
			

			Vector<OrdenesCompra> ordenes = new Vector<OrdenesCompra>();

			while(res.next()){

				if(res.getInt("Orden_Compra.id_proveedor") == res.getInt("Proveedor.id")){

					OrdenesCompra orden = new OrdenesCompra();

					orden.setId(res.getInt("id"));
					//orden.setCantidadJug(res.getInt("total_de_juguetes"));
					//orden.setCantidadTotal(res.getDouble("costo_total"));

					String fechaRes = res.getString("fecha_respuesta");
					String fechaEnt = res.getString("fecha_solicitud");
					Date dateRes = new SimpleDateFormat("yyyy-MM-dd").parse(fechaRes);
					Date datEnt = new SimpleDateFormat("yyyy-MM-dd").parse(fechaRes);

					SimpleDateFormat sm = new SimpleDateFormat("dd-MM-yyyy");

					fechaRes = sm.format(dateRes);
					fechaEnt = sm.format(datEnt);
					orden.setProveedor(res.getString("Proveedor.nombre"));
					orden.setFechaEntrega(fechaEnt);
					orden.setFechaPedido(fechaRes);
					orden.setCantidadJug(res.getInt("total_de_juguetes"));
					orden.setCantidadTotal(res.getDouble("costo_total"));

					ordenes.add(orden);
				 }
				/*sql="SELECT * FROM Proveedor WHERE id ="+res.getInt("id_proveedor")+";";
				
				ResultSet resProv = stat.executeQuery(sql);

				if(resProv.next()){
					orden.setProveedor(resProv.getString("nombre"));
				}*/
			
			
				
			}
			
			stat.close();
			con.close();

			//preguntare
			request.setAttribute("ordenes",ordenes);

			RequestDispatcher disp =  getServletContext().getRequestDispatcher("/ordenes.jsp");

			if(disp!=null){
				disp.forward(request,response);
			}


		}
		catch(Exception e){
			e.printStackTrace();
		}



	}

}
