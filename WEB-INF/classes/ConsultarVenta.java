import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import ventas.Venta;
import juguetes.Juguete;
import java.util.Vector;

import javax.servlet.annotation.WebServlet;

@WebServlet("/ConsultarVenta")
public class ConsultarVenta extends HttpServlet{
	
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
			String nombre_juguete = request.getParameter("Juguete");
			int cantidad = Integer.parseInt(request.getParameter("Cantidad"));
			int id_venta= Integer.parseInt(request.getParameter("NumVentas"));
			Statement stat = con.createStatement();

			//double precio = 0;
		
			//String sql = "INSERT INTO Proveedor (nombre, contacto) VALUES ('1','1')";
			String sql = "SELECT * FROM Juguete, Ventas WHERE Juguete.nombre = '"+nombre_juguete+"' and Ventas.id ='"+id_venta+"';";
			//Hay que sumar todos los precios del agregar
			//Hay que restarle la cantidad a la tabla cantidad
			//Hay que mostrar el total en jsp
			//Hay que mostrar los juguetes en js
			ResultSet res = stat.executeQuery(sql);
		
			
			if(res.next()){
				if(cantidad>res.getInt("Juguete.cantidad")){
					String error = "Agregaste de más, compa";
					request.setAttribute("error",error);
					stat.close();
					con.close();
	
					//preguntare
					Venta venta = new Venta();
					venta.setId(id_venta);
					
					request.setAttribute("ventas",venta );
					RequestDispatcher disp =  getServletContext().getRequestDispatcher("/add_venta.jsp");
	
					if(disp!=null){
						disp.forward(request,response);
					}
				}
				else{
				int id_juguete=res.getInt("Juguete.id");
				int cantidadActualJuguete= res.getInt("Juguete.cantidad")-cantidad;
				double precioJuguete = res.getDouble("Juguete.precio"); 
				double nuevoPrecio= res.getDouble("Ventas.precio_total") + (cantidad * res.getDouble("Juguete.precio"));
				sql = "UPDATE Ventas SET precio_total ="+nuevoPrecio+" WHERE Ventas.id ="+id_venta+";";
			
				stat.executeUpdate(sql);

				sql = "UPDATE Juguete SET cantidad ='"+cantidadActualJuguete+"' WHERE Juguete.id='"+id_juguete+"';";

				stat.executeUpdate(sql);

				sql= "INSERT INTO Juguete_Venta (id_venta, id_juguete, total_juguetes, precio_actual) VALUES ('"+id_venta+"', '"+id_juguete+"', "+cantidad+","+precioJuguete+");";
				
				stat.executeUpdate(sql);
				}
			
			}
			sql= "SELECT * FROM Juguete, Ventas, Juguete_Venta WHERE Juguete.id= Juguete_Venta.id_juguete and Ventas.id = Juguete_Venta.id_venta and Ventas.id = '"+id_venta+"';";
			res=stat.executeQuery(sql);

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

			RequestDispatcher disp =  getServletContext().getRequestDispatcher("/add_venta.jsp");

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
