import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import juguetes.Juguete;
import java.util.Vector;

import javax.servlet.annotation.WebServlet;

@WebServlet("/BorrarOrden")
public class BorrarOrden extends HttpServlet{

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
			int id_orden = Integer.parseInt(request.getParameter("ID"));
			Statement stat = con.createStatement();
		
			//String sql = "INSERT INTO Proveedor (nombre, contacto) VALUES ('1','1')";
			String sql = "DELETE FROM Orden_Compra WHERE id ="+id_orden+";";
			stat.executeUpdate(sql);
	
			stat.close();
			con.close();

			//preguntare

			RequestDispatcher disp =  getServletContext().getRequestDispatcher("/borrar_ord.jsp");

			if(disp!=null){
				disp.forward(request,response);
			}


		}
		catch(Exception e){
			e.printStackTrace();
		}



	}

}
