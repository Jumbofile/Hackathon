package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class IndexServlet extends HttpServlet {
private static final long serialVersionUID = 1L;
private String username = null;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		username = (String) req.getSession().getAttribute("username"); //session stuff
		
		if(username == null) {
			req.getRequestDispatcher("/login.jsp").forward(req, resp);
		}
		else {
			
		
			System.out.println("Index Servlet: doGet");
			int count = 25;
			String image = "http://s4c.cymru/temp/wave1.jpg";
			String title = "Temp title";
			String name = "Greg Plachno";
			String smallDesc = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Curabitur vulputate nibh vel nibh interdum faucibus. Vivamus fermentum sed lorem ut ultrices. Proin tempor venenatis dolor, eu malesuada purus volutpat in. Sed porttitor libero urna, sed suscipit odio laoreet sed. Aliquam posuere lorem quis enim egestas, in gravida ipsum suscipit. Curabitur iaculis suscipit cursus. Nunc eleifend vehicula malesuada. Pellentesque vehicula ipsum ut cursus pharetra. Mauris commodo, erat sed ultrices malesuada, lorem ex congue tortor, ut elementum libero dolor quis arcu.";
			String response = "";
			for(int i = 0; i < count; i++) {
				response = response + "<div class=\"card\">\r\n" + 
						"						<img src=\"" +  image + "\"style=width:300px;height:200px;\">\r\n" + 
						"						<div class=\"card-title\">\r\n" + 
						"						  <a href=\"#\" class=\"toggle-info btn\">\r\n" + 
						"							<span class=\"left\"></span>\r\n" + 
						"							<span class=\"right\"></span>\r\n" + 
						"						  </a>\r\n" + 
						"						  <h2>\r\n" + 
													title+"\r\n" + 
						"							  <small> By:"+ name +"</small>\r\n" + 
						"						  </h2>\r\n" + 
						"						</div>\r\n" + 
						"						<div class=\"card-flap flap1\">\r\n" + 
						"						  <div class=\"card-description\">\r\n" + 
													smallDesc +"\r\n" + 
						"						  </div>\r\n" + 
						"						  <div class=\"card-flap flap2\">\r\n" + 
						"							<div class=\"card-actions\">\r\n" + 
						"							  <a href=\"#\" class=\"btn\">Read more</a>\r\n" + 
						"							</div>\r\n" + 
						"						  </div>\r\n" + 
						"						</div>\r\n" + 
						"					  </div>";
			}
			req.setAttribute("idea", response);
			req.getRequestDispatcher("/_view/index.jsp").forward(req, resp);
		}
	}	
}
