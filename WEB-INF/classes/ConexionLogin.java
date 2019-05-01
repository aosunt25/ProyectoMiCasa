import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import usuarios.Usuario;
import java.util.Vector;

import javax.servlet.annotation.WebServlet;

@WebServlet("/login")
public class ConexionLogin extends HttpServlet{

	public void doPost(HttpServletRequest request, HttpServletResponse response){

		try{
			String base = getServletContext().getInitParameter("base");
			String contraseña=getServletContext().getInitParameter("contraseña");
			String usuarioBase=getServletContext().getInitParameter("usuario");

			Class.forName("com.mysql.jdbc.Driver");


			String url = "jdbc:mysql://localhost/"+base+"?useSSL=false&allowPublicKeyRetrieval=true";
			

			//Parametros son direccion de la base, usuario y constraseña de mysql
			Connection con = DriverManager.getConnection(url,usuarioBase,contraseña);
			String username = request.getParameter("username");
			String password = request.getParameter("password");
            int check = 0;
			Statement stat = con.createStatement();

            String sql = "SELECT contraseña, usuario FROM Usuario WHERE usuario='"+username+"' and contraseña ='"+password+"';";
            
            ResultSet res = stat.executeQuery(sql);

          

  
           	
            //No se si aqui se pone usuario base y contraseña 
            if(!res.next()){
            	String up = username + password;
            	//request.setAttribute("result",up);
                RequestDispatcher disp = getServletContext().getRequestDispatcher("/login.jsp");;
           		disp.forward(request,response);
			}
            else {
                RequestDispatcher disp = getServletContext().getRequestDispatcher("/menu.jsp");;
           		disp.forward(request,response);
            }
             stat.close();
			con.close();
			/*
				Vector<Usuario> usuarios = new Vector<Usuario>();

				while(res.next()){

					Usuario usuario = new Usuario();
					//Checar que valores son los de usuario y contraseña y porque no salen el jsp con el ciclo

					if(username.equals(res.getString(usuario)) && password.equals(res.getString(contraseña))){
						check = 1;
						disp =  getServletContext().getRequestDispatcher("/menu.html");
					}
					else if(username.equals(null) || password.equals(null)){
						check = 0;
						disp =  getServletContext().getRequestDispatcher("/login.jsp");
					}

				}

			*/
            

            

		}
		catch(Exception e){
			e.printStackTrace();
		}



	}

}