import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import ventas.Venta;
import juguetes.Juguete;
import java.util.Vector;

import javax.servlet.annotation.WebServlet;

@WebServlet("/ConsultarPorVenta")
public class ConsultarPorVenta extends HttpServlet{
	
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

			int id_venta= Integer.parseInt(request.getParameter("Id"));


			Statement stat = con.createStatement();

			//double precio = 0;
		
			//String sql = "INSERT INTO Proveedor (nombre, contacto) VALUES ('1','1')";
		
			
			
			String sql= "SELECT * FROM Juguete, Ventas, Juguete_Venta WHERE Juguete.id= Juguete_Venta.id_juguete and Ventas.id = Juguete_Venta.id_venta and Ventas.id = '"+id_venta+"';";
			ResultSet res=stat.executeQuery(sql);

			double precioTot;

			Vector<Juguete> juguetes = new Vector<Juguete>();
			Venta venta = new Venta();

			while(res.next()){
				
					Juguete jug = new Juguete();
					jug.setNombre(res.getString("Juguete.nombre"));
					jug.setPrecio(res.getDouble("Juguete_Venta.precio_actual")*res.getInt("Juguete_Venta.total_juguetes"));
					jug.setCantidad(res.getInt("Juguete_Venta.total_juguetes"));
					jug.setID(res.getInt("Juguete.id"));
					
					precioTot= res.getDouble("Ventas.precio_total");
				
					venta.setId(id_venta);
					venta.setPrecioTot(precioTot);

					juguetes.add(jug);
				
					//preguntare

					
				}


			stat.close();
			con.close();

			request.setAttribute("ventas",venta );

			request.setAttribute("juguetes",juguetes);

			RequestDispatcher disp =  getServletContext().getRequestDispatcher("/cosultar_venta.jsp");

				if(disp!=null){
						disp.forward(request,response);
				}
				

					
					

			//}

			/*Statement stat2 = con.createStatement();

			sql="SELECT * FROM Ventas,Juguete, Venta_Juguete WHERE Ventas.id = Venta_Juguete.id_venta and Juguete.id= Venta_Juguete.id_juguete;";

			Vector<Juguete> juguetes = new Vector<Juguete>();

			while(res.next()){
				
					Juguete jug = new Juguete();
					jug.setNombre(res.getString("Juguete.nombre"));
					jug.setPrecio(res.getDouble("Juguete.precio")*cantidad);
					jug.setCantidad(cantidad);
					jug.setID(res.getInt("Juguete.id"));

					juguetes.add(jug);
					//double precio = precio + (res.getDouble("precio")*cantidad);
					request.setAttribute("juguetes",juguetes);
					//request.setAttribute("precio",precio);
					sql= "INSERT INTO Juguete_Venta (id_venta, id_juguete, total_juguetes, precio_actual) VALUES ('"+id_venta+"', '"+res.getInt("Juguete.id")+"', "+cantidad+","+res.getDouble("Juguete.precio")+");";

					stat.executeUpdate(sql);

					stat.close();
					con.close();

					//preguntare

					
				}
	
		}*/

			


		}
		catch(Exception e){
			e.printStackTrace();
		}



	}

}
