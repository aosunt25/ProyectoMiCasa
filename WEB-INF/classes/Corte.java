import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import ventas.Venta;
import java.util.Vector;
import java.util.Date;
import java.text.SimpleDateFormat;

import javax.servlet.annotation.WebServlet;


@WebServlet("/Corte")
public class Corte extends HttpServlet{

	public void doPost(HttpServletRequest request, HttpServletResponse response){

		try{
			String base = getServletContext().getInitParameter("base");
			String contraseña=getServletContext().getInitParameter("contraseña");
			String usuarioBase=getServletContext().getInitParameter("usuario");

			Class.forName("com.mysql.jdbc.Driver");

			String url = "jdbc:mysql://localhost/"+base+"?useSSL=false&allowPublicKeyRetrieval=true";
			
			//System.out.println(url);
            String fecha_inicial= request.getParameter("AnioDeSolicitud")+"-"+request.getParameter("MesDeSolicitud")+"-"+request.getParameter("DiaDeSolicitud");
			String fecha_final= request.getParameter("AnioDeEntrega")+"-"+request.getParameter("MesDeEntrega")+"-"+request.getParameter("DiaDeEntrega");
			//Parametros son direccion de la base, usuario y constraseña de mysql
			Connection con = DriverManager.getConnection(url,usuarioBase,contraseña);
			

			Statement stat = con.createStatement();
			double precioTot=0;
			int cantidad=0;
            
			String sql = "SELECT * FROM Ventas WHERE fecha >= '"+fecha_inicial+"' and fecha <= '"+fecha_final+"'" ;

			ResultSet res = stat.executeQuery(sql);



			Vector<Venta> ventas = new Vector<Venta>();

			while(res.next()){

				Venta ven = new Venta();

				precioTot = precioTot + res.getDouble("precio_total");
				cantidad++;

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

			request.setAttribute("cantidad",cantidad);

			request.setAttribute("precioTot",precioTot);

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