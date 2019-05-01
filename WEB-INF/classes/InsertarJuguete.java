import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import juguetes.Juguete;
import java.util.Vector;

import javax.servlet.annotation.WebServlet;

@WebServlet("/Juguetes")
public class InsertarJuguete extends HttpServlet{

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
			String nombre = request.getParameter("Juguete");
			Double precio = Double.parseDouble(request.getParameter("Precio"));
			Double precio_proveedor = Double.parseDouble(request.getParameter("Precio Proveedor"));
			String categoria = request.getParameter("Categoria");
			String descripcion = request.getParameter("Descripcion");
			int cantidad = Integer.parseInt(request.getParameter("Cantidad"));
			int id_proveedor=Integer.parseInt(request.getParameter("ProveedorId"));
		
			Statement stat = con.createStatement();

			String sql = "SELECT * FROM Juguete WHERE nombre = '"+nombre+"'";

			ResultSet resJug= stat.executeQuery(sql);

			if(!resJug.next()){
				
					sql = "INSERT INTO Juguete (nombre, precio, categoria, descripcion, precio_proveedor, cantidad, id_proveedor ) VALUES ( '"+nombre+"','"+precio+"','"+categoria+"', '"+descripcion+"', '"+precio_proveedor+"','"+cantidad+"', '"+id_proveedor+"' )";
					stat.executeUpdate(sql);
					stat.close();
					con.close();
					RequestDispatcher disp =  getServletContext().getRequestDispatcher("/anadir_jug.jsp");
					if(disp!=null){
						disp.forward(request,response);
					}	
			}
			else{
				stat.close();
				con.close();
				RequestDispatcher disp =  getServletContext().getRequestDispatcher("/error_jug.jsp");
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
