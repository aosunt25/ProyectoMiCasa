import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import ordenesCompra.OrdenesCompra;
import juguetes.Juguete;
import java.util.Vector;
import proveedores.Proveedor;

import javax.servlet.annotation.WebServlet;

@WebServlet("/TerminarOrdenDeCompra")
public class TerminarOrdenDeCompra extends HttpServlet{

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


			
			int id_orden= Integer.parseInt(request.getParameter("NumOrden"));

			String fecha_solicitud= request.getParameter("AnioDeSolicitud")+"-"+request.getParameter("MesDeSolicitud")+"-"+request.getParameter("DiaDeSolicitud");
			String fecha_entrega= request.getParameter("AnioDeEntrega")+"-"+request.getParameter("MesDeEntrega")+"-"+request.getParameter("DiaDeEntrega");

			Statement stat = con.createStatement();

			//double precio = 0;
		
			//String sql = "INSERT INTO Proveedor (nombre, contacto) VALUES ('1','1')";
			String sql = "UPDATE Orden_Compra SET fecha_solicitud = '"+fecha_solicitud+"' WHERE Orden_Compra.id ="+id_orden+";";

			stat.executeUpdate(sql);

			sql = "UPDATE Orden_Compra SET fecha_respuesta ='"+fecha_entrega+"' WHERE Orden_Compra.id ="+id_orden+";";

			stat.executeUpdate(sql);	
		
			RequestDispatcher disp =  getServletContext().getRequestDispatcher("/ConsultarOrden");

			if(disp!=null){
				disp.forward(request,response);
			}

			
		

		}
		catch(Exception e){
			e.printStackTrace();
		}



	}

}
