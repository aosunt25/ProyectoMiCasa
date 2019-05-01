import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import ordenesCompra.OrdenesCompra;
import java.util.Vector;

import javax.servlet.annotation.WebServlet;

@WebServlet("/OrdenesCompra")
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


			String fecha_solicitud= request.getParameter("AnioDeSolicitud")+"-"+request.getParameter("MesDeSolicitud")+"-"+request.getParameter("DiaDeSolicitud");
			String fecha_respuesta= request.getParameter("AnioDeEntrega")+"-"+request.getParameter("MesDeEntrega")+"-"+request.getParameter("DiaDeEntrega");
			String totalDeJuguetes = request.getParameter("totalJuguetes");
			String costoTotal = request.getParameter("CostoTotal");
			String usuario = request.getParameter("Usuario");
			String proveedor= request.getParameter("Proveedor");
		

			Statement stat = con.createStatement();
			String sql = "SELECT * FROM Proveedor, Usuario WHERE Proveedor.nombre ='"+proveedor+"' and Usuario.usuario ='"+usuario+"';";

			ResultSet res = stat.executeQuery(sql);

			if(res.next()){
				int proveedorID= res.getInt("Proveedor.id");
				int usuarioID = res.getInt("Usuario.id");

				sql="INSERT INTO Orden_Compra (total_de_juguetes, costo_total, id_proveedor, id_usuario, fecha_solicitud, fecha_respuesta) VALUES ( '"+totalDeJuguetes+"','"+costoTotal+"', '"+proveedorID+"','"+usuarioID+"','"+fecha_solicitud+"','"+fecha_respuesta+"');";

				stat.executeUpdate(sql);

				stat.close();
				con.close();

				RequestDispatcher disp =  getServletContext().getRequestDispatcher("/anadir_orden.jsp");

				if(disp!=null){
					disp.forward(request,response);
				}
			}
			else{

				stat.close();
				con.close();

				RequestDispatcher disp =  getServletContext().getRequestDispatcher("/error_orden.jsp");

				if(disp!=null){
					disp.forward(request,response);
				}

			}
		

		}
		catch(Exception e){
			e.printStackTrace();
		}



	}

}
