import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import ventas.Venta;
import juguetes.Juguete;
import java.util.Vector;

import javax.servlet.annotation.WebServlet;

@WebServlet("/BorrarJugueteDeVenta")
public class BorrarJugueteDeVenta extends HttpServlet{

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
			int id_juguete = Integer.parseInt(request.getParameter("Id"));
			int id_venta= Integer.parseInt(request.getParameter("NumVentas"));
			int cantidad =  Integer.parseInt(request.getParameter("Cantidad"));
			Statement stat = con.createStatement();
		
			//String sql = "INSERT INTO Proveedor (nombre, contacto) VALUES ('1','1')";
			String sql = "DELETE FROM Juguete_Venta WHERE id_juguete = '"+id_juguete+"' and id_venta = "+id_venta+";";
			stat.executeUpdate(sql);
			sql = "SELECT * FROM Juguete WHERE id = '"+id_juguete+"';";
			ResultSet res = stat.executeQuery(sql);

			double precioTot=0;

			if(res.next()){
				int cantidadActualJuguete = res.getInt("cantidad")+cantidad;
				precioTot=(res.getDouble("precio")*cantidad);
				sql="UPDATE Juguete SET cantidad ='"+cantidadActualJuguete+"' WHERE Juguete.id='"+id_juguete+"';";
				stat.executeUpdate(sql);


			}
			sql = "SELECT * FROM Ventas WHERE id='"+id_venta+"';";
			res = stat.executeQuery(sql);

			if(res.next()){
				double nuevoPrecio = res.getDouble("Ventas.precio_total") - precioTot;
				sql= "UPDATE Ventas SET precio_total ="+nuevoPrecio+" WHERE Ventas.id ="+id_venta+";";
				stat.executeUpdate(sql);
			}

		
			sql= "SELECT * FROM Juguete, Ventas, Juguete_Venta WHERE Juguete.id= Juguete_Venta.id_juguete and Ventas.id = Juguete_Venta.id_venta and Ventas.id = '"+id_venta+"';";
			res=stat.executeQuery(sql);

			

			Vector<Juguete> juguetes = new Vector<Juguete>();
			Venta venta = new Venta();

			while(res.next()){
				
					Juguete jug = new Juguete();
					jug.setNombre(res.getString("Juguete.nombre"));
					jug.setPrecio(res.getDouble("Juguete_Venta.precio_actual")*res.getInt("Juguete_Venta.total_juguetes"));
					jug.setCantidad(res.getInt("Juguete_Venta.total_juguetes"));
					jug.setID(res.getInt("Juguete.id"));
					
					precioTot=res.getDouble("Ventas.precio_total");
				
					venta.setId(id_venta);
					venta.setPrecioTot(precioTot);

					juguetes.add(jug);
				
					//preguntare

					
			}
			sql="SELECT * FROM Juguete";
			res = stat.executeQuery(sql);

			Vector<Juguete> todosJuguetes = new Vector<Juguete>();
			while(res.next()){
				Juguete juguete = new Juguete();
				juguete.setID(res.getInt("id"));
				juguete.setNombre(res.getString("nombre"));

				todosJuguetes.add(juguete);
			}
	
			stat.close();
			con.close();

			request.setAttribute("ventas",venta);

			request.setAttribute("juguetes",juguetes);

			request.setAttribute("juguete",todosJuguetes);
			//preguntare

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
