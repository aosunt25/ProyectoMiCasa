import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import proveedores.Proveedor;
import java.util.Vector;

import javax.servlet.annotation.WebServlet;

@WebServlet("/EditarProveedor")
public class EditarProveedor extends HttpServlet{

	public void doPost(HttpServletRequest request, HttpServletResponse response){

		try{
			String base = getServletContext().getInitParameter("base");
			String contraseña=getServletContext().getInitParameter("contraseña");
			String usuarioBase=getServletContext().getInitParameter("usuario");

			Class.forName("com.mysql.jdbc.Driver");

			//Despues de localhost va el nombre de la base

			//Despues de localhost va el nombre de la base

			String url = "jdbc:mysql://localhost/"+base+"?useSSL=false&allowPublicKeyRetrieval=true";
			
			//System.out.println(url);

			//Parametros son direccion de la base, usuario y constraseña de mysql
			Connection con = DriverManager.getConnection(url,usuarioBase,contraseña);
			String nombre = request.getParameter("Proveedor");
			int id = Integer.parseInt(request.getParameter("Id"));
			String telefono = request.getParameter("Telefono");
			

		
			Statement stat = con.createStatement();

		
		

			
			String sql = "UPDATE Proveedor SET nombre= '"+nombre+"', contacto = "+telefono+" WHERE id ='"+id+"';";

			stat.executeUpdate(sql);

			Proveedor prov = new Proveedor();

			prov.setID(id);
			prov.setNombre(nombre);
			prov.setTelefono(telefono);

			
			

			
			stat.close();
			con.close();

			String mensaje = "Se edito correctamente el proveedor";
			request.setAttribute("mensaje",mensaje);
			request.setAttribute("prov",prov);

			RequestDispatcher disp =  getServletContext().getRequestDispatcher("/editar_proveedor.jsp");
			if(disp!=null){
				disp.forward(request,response);
			}
			

			


		}
		catch(Exception e){
			e.printStackTrace();
		}



	}

}
