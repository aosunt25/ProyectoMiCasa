import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import usuarios.Usuario;
import java.util.Vector;

import javax.servlet.annotation.WebServlet;

@WebServlet("/CrearUsuario")
public class CrearUsuario extends HttpServlet{

	public void doPost(HttpServletRequest request, HttpServletResponse response){

		try{
			String base = getServletContext().getInitParameter("base");
			String contraseñaBase=getServletContext().getInitParameter("contraseña");
			String usuarioBase=getServletContext().getInitParameter("usuario");

			Class.forName("com.mysql.jdbc.Driver");

			//Despues de localhost va el nombre de la base

			String url = "jdbc:mysql://localhost/"+base+"?useSSL=false&allowPublicKeyRetrieval=true";
			
			//System.out.println(url);

			//Parametros son direccion de la base, usuario y constraseña de mysql
			Connection con = DriverManager.getConnection(url,usuarioBase,contraseñaBase);
			String nombre = request.getParameter("Nombre") + " " + request.getParameter("Apellidos");
			String usuarioCliente = request.getParameter("Usuario");
			String contraseña= request.getParameter("password");
			

			Statement stat = con.createStatement();
			String sql = "INSERT INTO Usuario (nombre, contraseña, usuario) VALUES ( '"+nombre+"','"+contraseña+"','"+usuarioCliente+"')";
			//String sql = "INSERT INTO Usuario (nombre, contraseña, usuario) VALUES ('"+nombre+"','"+contraseña+"','"+usuario+"'')";

			stat.executeUpdate(sql);

			stat.close();
			con.close();

			//preguntare
			//request.setAttribute("alumnos",alumnos);

			RequestDispatcher disp =  getServletContext().getRequestDispatcher("/anadir_usuario.jsp");

			if(disp!=null){
				disp.forward(request,response);
			}


		}
		catch(Exception e){
			e.printStackTrace();
		}



	}

}
