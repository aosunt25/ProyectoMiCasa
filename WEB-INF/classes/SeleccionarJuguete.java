import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import juguetes.Juguete;
import proveedores.Proveedor;
import java.util.Vector;
import ordenesCompra.OrdenesCompra;


import javax.servlet.annotation.WebServlet;


@WebServlet("/SeleccionarJuguete")
public class SeleccionarJuguete extends HttpServlet{

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
			

			int id_proveedor = Integer.parseInt(request.getParameter("Id"));
			Statement stat = con.createStatement();
			String sql = "SELECT * FROM Juguete WHERE id_proveedor = '"+id_proveedor+"'";

			ResultSet res = stat.executeQuery(sql);

			Vector<Juguete> juguetes = new Vector<Juguete>();

			while(res.next()){
				
				Juguete jug = new Juguete();
					jug.setNombre(res.getString("Juguete.nombre"));
					jug.setPrecio(res.getDouble("Juguete.precio"));
					jug.setPrecioProv(res.getDouble("Juguete.precio_proveedor"));
					jug.setCategoria(res.getString("Juguete.categoria"));
					jug.setDescripcion(res.getString("Juguete.descripcion"));
					jug.setCantidad(res.getInt("Juguete.cantidad"));
					jug.setID(res.getInt("Juguete.id"));

					juguetes.add(jug);
			}

			sql = "SELECT * FROM Proveedor WHERE id = '"+id_proveedor+"'";

			res = stat.executeQuery(sql);
			Proveedor proveedor = new Proveedor();

			if(res.next()){
				proveedor.setNombre(res.getString("nombre"));
				proveedor.setID(res.getInt("id"));
			}
			
		

			sql = "SELECT * FROM Orden_Compra WHERE costo_total=0;";

			res = stat.executeQuery(sql);

			OrdenesCompra orden = new OrdenesCompra();
			if(!res.next()){
				sql= "INSERT INTO Orden_Compra(id_proveedor, fecha_solicitud, fecha_respuesta) VALUES ('"+proveedor.getId()+"', CURRENT_DATE, CURRENT_DATE);";
				stat.executeUpdate(sql);

				sql = "SELECT id FROM Orden_Compra WHERE costo_total=0;";
				res = stat.executeQuery(sql);

				if(res.next()){
					orden.setId(res.getInt("id"));
				}
				
			}
			else{
				orden.setId(res.getInt("id"));
			}
			stat.close();
			con.close();

			//preguntare
			request.setAttribute("proveedor", proveedor);
			request.setAttribute("juguetes",juguetes);
			request.setAttribute("orden",orden);

			RequestDispatcher disp =  getServletContext().getRequestDispatcher("/crear_orden_compra.jsp");

			if(disp!=null){
				disp.forward(request,response);
			}


		}
		catch(Exception e){
			e.printStackTrace();
		}



	}

}
