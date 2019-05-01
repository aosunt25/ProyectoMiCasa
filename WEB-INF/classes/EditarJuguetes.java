import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import juguetes.Juguete;
import java.util.Vector;

import javax.servlet.annotation.WebServlet;

@WebServlet("/EditarJuguetes")
public class EditarJuguetes extends HttpServlet{

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
			int id = Integer.parseInt(request.getParameter("Id"));
			Double precio = Double.parseDouble(request.getParameter("Precio"));
			int cantidad = Integer.parseInt(request.getParameter("Cantidad"));

		
			Statement stat = con.createStatement();

			String sql = "SELECT * FROM Juguete WHERE id = '"+id+"';";

			ResultSet res = stat.executeQuery(sql);

			if(res.next()){
				if(res.getString("nombre")!= nombre || res.getInt("cantidad")!=cantidad || res.getDouble("precio")!=precio){
					String mensaje = "Se edito correctamente el juguete";
					request.setAttribute("mensaje",mensaje);
				}
				
			}

			sql = "UPDATE Juguete SET cantidad= "+cantidad+", precio = "+precio+", nombre ='"+nombre+"' WHERE id ='"+id+"';";

			stat.executeUpdate(sql);

			Juguete jug = new Juguete();

			jug.setID(id);
			jug.setNombre(nombre);
			jug.setPrecio(precio);
			jug.setCantidad(cantidad);

			

			request.setAttribute("jug",jug);
			String mensaje = "Se edito correctamente el juguete";
			request.setAttribute("mensaje",mensaje);
			
			stat.close();
			con.close();

			RequestDispatcher disp =  getServletContext().getRequestDispatcher("/editar_juguete.jsp");
			if(disp!=null){
				disp.forward(request,response);
			}
			

			


		}
		catch(Exception e){
			e.printStackTrace();
		}



	}

}
