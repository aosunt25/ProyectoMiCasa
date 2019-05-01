import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import escuela.Alumno;
import java.util.Vector;

import javax.servlet.annotation.WebServlet;

@WebServlet("/MiServlito")
public class ConexionAlumnos extends HttpServlet{

	public void doPost(HttpServletRequest request, HttpServletResponse response){

		try{

			String base = getServletContext().getInitParameter("base");
			String usuario = getServletContext().getInitParameter("usuario");
			String password = getServletContext().getInitParameter("pass");


			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost/"+base+"?useSSL=false&allowPublicKeyRetrieval=true";
			
			System.out.println(url);
			Connection con = DriverManager.getConnection(url,usuario,password);


			Statement stat = con.createStatement();
			String sql = "SELECT * FROM alumno;";

			String carrera = request.getParameter("carrera");
			if(!carrera.equals("")){
				sql = "SELECT * FROM alumno WHERE carrera=\"" + carrera + "\";";
			}

			ResultSet res = stat.executeQuery(sql);

			Vector<Alumno> alumnos = new Vector<Alumno>();

			while(res.next()){

				Alumno aux = new Alumno();

				aux.setNombre(res.getString("nombre"));
				aux.setMatricula(res.getString("matricula"));
				aux.setCarrera(res.getString("carrera"));
				aux.setEdad(res.getInt("edad"));

				alumnos.add(aux);

			}

			stat.close();
			con.close();

			request.setAttribute("alumnos",alumnos);

			RequestDispatcher disp =  getServletContext().getRequestDispatcher("/procesa.jsp");

			if(disp!=null){
				disp.forward(request,response);
			}


		}
		catch(Exception e){
			e.printStackTrace();
		}



	}

}
