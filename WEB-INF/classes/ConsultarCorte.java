import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import ventas.Venta;
import java.util.Vector;
import java.util.Date;
import java.text.SimpleDateFormat;


import javax.servlet.annotation.WebServlet;

@WebServlet("/ConsultarCorte")
public class ConsultarCorte extends HttpServlet{

	public void doPost(HttpServletRequest request, HttpServletResponse response){

		try{
			String base = getServletContext().getInitParameter("base");
			String contraseña=getServletContext().getInitParameter("contraseña");
			String usuarioBase=getServletContext().getInitParameter("usuario");

			Class.forName("com.mysql.jdbc.Driver");

			String url = "jdbc:mysql://localhost/"+base+"?useSSL=false&allowPublicKeyRetrieval=true";
			
			
			//System.out.println(url);

			//Parametros son direccion de la base, usuario y constraseña de mysql
			Connection con = DriverManager.getConnection(url,usuarioBase,contraseña);
			

			Statement stat = con.createStatement();
			String sql = "SELECT * FROM Ventas";

			ResultSet res = stat.executeQuery(sql);

			Vector<Venta> ventas = new Vector<Venta>();

			while(res.next()){

				Venta ven = new Venta();

				String fecha = res.getString("Ventas.fecha");
				Date datEnt = new SimpleDateFormat("yyyy-MM-dd").parse(fecha);
				SimpleDateFormat sm = new SimpleDateFormat("dd-MM-yyyy");
				fecha = sm.format(datEnt);

                ven.setHora(res.getString("Ventas.hora"));
                ven.setFecha(fecha);
                ven.setPrecioTot(res.getDouble("Ventas.precio_total"));
                ven.setId(res.getInt("id"));

                ventas.add(ven);
		
			}
			
			stat.close();
			con.close();

			//preguntare
			request.setAttribute("ventas",ventas);

			RequestDispatcher disp =  getServletContext().getRequestDispatcher("/cortes-venta.jsp");

			if(disp!=null){
				disp.forward(request,response);
			}


		}
		catch(Exception e){
			e.printStackTrace();
		}



	}

}
