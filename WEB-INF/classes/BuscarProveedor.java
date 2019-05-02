import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import proveedores.Proveedor;
import java.util.Vector;

import javax.servlet.annotation.WebServlet;


@WebServlet("/BuscarProveedor")
public class BuscarProveedor extends HttpServlet{

	public void doPost(HttpServletRequest request, HttpServletResponse response){

		try{
			String base = getServletContext().getInitParameter("base");
			String contraseña=getServletContext().getInitParameter("contraseña");
			String usuarioBase=getServletContext().getInitParameter("usuario");

			Class.forName("com.mysql.jdbc.Driver");

			String url = "jdbc:mysql://localhost/"+base+"?useSSL=false&allowPublicKeyRetrieval=true";
			
			//System.out.println(url);
			String proveedor= request.getParameter("Proveedor");
			//Parametros son direccion de la base, usuario y constraseña de mysql
			Connection con = DriverManager.getConnection(url,usuarioBase,contraseña);
			

			Statement stat = con.createStatement();
		
			String sql = "SELECT * FROM Proveedor WHERE nombre LIKE '%"+proveedor+"%'";

			ResultSet res = stat.executeQuery(sql);


			Vector<Proveedor> proveedores = new Vector<Proveedor>();

			while(res.next()){
				
				Proveedor prov = new Proveedor();
				prov.setNombre(res.getString("nombre"));
				prov.setTelefono(res.getString("contacto"));
				prov.setID(res.getInt("id"));

				proveedores.add(prov);

			}
			
			stat.close();
			con.close();

			//preguntare
			request.setAttribute("proveedores",proveedores);

			RequestDispatcher disp =  getServletContext().getRequestDispatcher("/proveedores.jsp");

			if(disp!=null){
				disp.forward(request,response);
			}


		}
		catch(Exception e){
			e.printStackTrace();
		}



	}

}
