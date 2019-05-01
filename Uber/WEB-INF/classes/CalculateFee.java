import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import javax.servlet.annotation.WebServlet;

@WebServlet("/fee")

public class CalculateFee extends HttpServlet{

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
				
				double trip = Double.parseDouble(req.getParameter("trip1"));

				double totalFee = trip*0.25;

				res.setContentType("text/html");
				PrintWriter out = res.getWriter();

				req.setAttribute("res",totalFee);

				RequestDispatcher disp = getServletContext().getRequestDispatcher("/calculateFee.jsp");

				if(disp!=null){
					disp.forward(req,res);
				}
			}
		catch(Exception e){
			e.printStackTrace();
		}

		
	}


}
