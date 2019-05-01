import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import javax.servlet.annotation.WebServlet;

@WebServlet("/addition")
public class Sum extends HttpServlet{

	public void init(ServletConfig config){
		try{
			super.init(config);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		
	}

	public void doGet(HttpServletRequest req, HttpServletResponse res){

		try{
			double number1 = Double.parseDouble(req.getParameter("n1"));
			double number2 = Double.parseDouble(req.getParameter("n2"));

			double result = number1 + number2;

			res.setContentType("text/html");
			PrintWriter out = res.getWriter();
			//out.print("<html><head><title>Result</title></head><body>"+result+"</body></html>");

			req.setAttribute("res",result);

			RequestDispatcher disp = getServletContext().getRequestDispatcher("/process.jsp");

			if(disp!=null){
				disp.forward(req,res);
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}

		/*Request
		String getParameter(String name);
		String[] getParameterValues(String name);
		String getMethod();
		HTTPSession getSession();
		String getServerName();
		int getServerPort();
		
		Response
		void setContentType(String type);
		PrintWriter getWriter();
		out.print(…);*/
	}

	//doPost(…)

}
