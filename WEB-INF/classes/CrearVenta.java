import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import juguetes.Juguete;
import ventas.Venta;
import java.util.Vector;

import javax.servlet.annotation.WebServlet;

@WebServlet("/CrearVenta")
public class CrearVenta extends HttpServlet{

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
            Connection con = DriverManager.getConnection(url,usuarioBase,contraseña);
			
			Statement stat = con.createStatement();
			
			
			

			String sql = "SELECT * FROM Ventas WHERE precio_total=0";

			ResultSet res = stat.executeQuery(sql);

			Venta ventas = new Venta();
			if(!res.next()){
				sql = "INSERT INTO Ventas(precio_total, hora, fecha) VALUES (0, CURRENT_TIMESTAMP, CURRENT_DATE);";
				stat.executeUpdate(sql);

				sql = "SELECT id FROM Ventas WHERE precio_total=0";
				res = stat.executeQuery(sql);

				if(res.next()){
					ventas.setId(res.getInt("id"));
				}
				
			}
			else{
				ventas.setId(res.getInt("id"));
			}
			
			sql = "SELECT * FROM Juguete";

			res = stat.executeQuery(sql);

			Vector<Juguete> juguetes = new Vector<Juguete>();
			while(res.next()){
				Juguete juguete = new Juguete();
				juguete.setID(res.getInt("id"));
				juguete.setNombre(res.getString("nombre"));

				juguetes.add(juguete);
			}
			
			stat.close();
			con.close();

			request.setAttribute("ventas",ventas);
			request.setAttribute("juguete", juguetes);

			RequestDispatcher disp =  getServletContext().getRequestDispatcher("/add_venta.jsp");

			if(disp!=null){
				disp.forward(request,response);
			}

		}
		catch(Exception e){
			e.printStackTrace();
		}



	}

}
