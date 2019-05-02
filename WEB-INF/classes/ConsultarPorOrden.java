import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import juguetes.Juguete;
import proveedores.Proveedor;
import java.util.Vector;
import ordenesCompra.OrdenesCompra;


import javax.servlet.annotation.WebServlet;

@WebServlet("/ConsultarPorOrden")
public class ConsultarPorOrden extends HttpServlet{
	
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

			int id_orden= Integer.parseInt(request.getParameter("Id"));


			Statement stat = con.createStatement();

			//double precio = 0;
		
			//String sql = "INSERT INTO Proveedor (nombre, contacto) VALUES ('1','1')";
		
			
			
		

			double precioTot;

			String sql = "SELECT * FROM Orden_Juguete, Juguete, Proveedor WHERE Juguete.id=Orden_Juguete.id_juguete and id_orden = "+id_orden+" and Juguete.id_proveedor = Proveedor.id;";
			ResultSet res = stat.executeQuery(sql);
			
			Vector<Juguete>  jugOrden = new Vector<Juguete> ();
			Proveedor prov = new Proveedor();

			while(res.next()){
				
				prov.setNombre(res.getString("Proveedor.nombre"));
				Juguete jug = new Juguete();
				jug.setNombre(res.getString("Juguete.nombre"));
				jug.setPrecioProv(res.getDouble("Juguete.precio_proveedor"));
				jug.setID(res.getInt("Juguete.id"));

				jugOrden.add(jug);

			}

			sql= "SELECT * FROM Orden_Compra WHERE id='"+id_orden+"';";

			res=stat.executeQuery(sql);

			OrdenesCompra orden = new OrdenesCompra();
			orden.setId(id_orden);

			if(res.next()){

				orden.setCantidadTotal(res.getDouble("costo_total"));
			}


			stat.close();
			con.close();

			request.setAttribute("orden",orden );

			request.setAttribute("juguetes",jugOrden);

			request.setAttribute("prov",prov);

			RequestDispatcher disp =  getServletContext().getRequestDispatcher("/cosultar_orden.jsp");

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
