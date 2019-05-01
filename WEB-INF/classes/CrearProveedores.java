import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import proveedores.Proveedor;
import java.util.Vector;

import javax.servlet.annotation.WebServlet;

@WebServlet("/AgregarProveedores")
public class CrearProveedores extends HttpServlet{

	public void doPost(HttpServletRequest request, HttpServletResponse response){

		try{
			String base = getServletContext().getInitParameter("base");
			String contraseña=getServletContext().getInitParameter("contraseña");
			String usuarioBase=getServletContext().getInitParameter("usuario");

			Class.forName("com.mysql.jdbc.Driver");

			//Despues de localhost va el nombre de la base

			//Despues de localhost va el nombre de la base

			String url = "jdbc:mysql://localhost/"+base+"?useSSL=false&allowPublicKeyRetrieval=true";
			

			//Parametros son direccion de la base, usuario y constraseña de mysql
			Connection con = DriverManager.getConnection(url,usuarioBase,contraseña);

			//Manda a buscar los valores  en el HTML con los ID "Nombre" y "Telefono" 
			String nombre = request.getParameter("Nombre");
			String telefono = request.getParameter("Telefono");

			Statement stat = con.createStatement();

			String sql = "SELECT * FROM Proveedor WHERE nombre = '"+nombre+"';";

			ResultSet resProv= stat.executeQuery(sql);

			if(!resProv.next()){	

				sql =  "INSERT INTO Proveedor (nombre, contacto) VALUES ( '"+nombre+"','"+telefono+"')";
				
				stat.executeUpdate(sql);

				stat.close();
				con.close();

				RequestDispatcher disp =  getServletContext().getRequestDispatcher("/anadir_prov.jsp");
				if(disp!=null){
						disp.forward(request,response);
				}
				
			}
			else{
				stat.close();
				con.close();
				RequestDispatcher disp =  getServletContext().getRequestDispatcher("/error_prov.jsp");
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
