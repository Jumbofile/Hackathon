package servlet;

import backend.DerbyDatabase;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class IndexServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private String username = null;
    private DerbyDatabase db = new DerbyDatabase();
    ArrayList<String> accountInfo = new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        username = (String) req.getSession().getAttribute("username"); //session stuff

        if (username == null) {
            req.getRequestDispatcher("/login").forward(req, resp);
        } else {

            int count = 0;
            System.out.println("Index Servlet: doGet");
            try {
                count = db.getCardCount();
            } catch (Exception e) {
                e.printStackTrace();
            }
            String response = "";
            if (count < 1) {
                response = "<h1>No projects available :(</h1>";
            } else {
                for (int i = 0; i < count; i++) {
                    try {
                        accountInfo = db.getCardData(i + 1);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    String image = accountInfo.get(6);
                    String title = accountInfo.get(1);
                    String name = accountInfo.get(4);
                    String smallDesc = accountInfo.get(2);
                    response = response + "<div class=\"card\">\r\n" +
                            "						<img src=\"" + image + "\"style=width:300px;height:200px;\">\r\n" +
                            "						<div class=\"card-title\">\r\n" +
                            "						  <a href=\"#\" class=\"toggle-info btn\">\r\n" +
                            "							<span class=\"left\"></span>\r\n" +
                            "							<span class=\"right\"></span>\r\n" +
                            "						  </a>\r\n" +
                            "						  <h2>\r\n" +
                            title + "\r\n" +
                            "							  <small> By:" + name + "</small>\r\n" +
                            "						  </h2>\r\n" +
                            "						</div>\r\n" +
                            "						<div class=\"card-flap flap1\">\r\n" +
                            "						  <div class=\"card-description\">\r\n" +
                            smallDesc + "\r\n" +
                            "						  </div>\r\n" +
                            "						  <div class=\"card-flap flap2\">\r\n" +
                            "							<div class=\"card-actions\">\r\n" +
                            "							  <a href=\"#\" class=\"btn\">Join</a>\r\n" +
                            "							</div>\r\n" +
                            "						  </div>\r\n" +
                            "						</div>\r\n" +
                            "					  </div>";
                }

            }
            req.setAttribute("idea", response);
            req.getRequestDispatcher("/_view/index.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        username = (String) req.getSession().getAttribute("username"); //session stuff

        if (username == null) {
            req.getRequestDispatcher("/login").forward(req, resp);
        } else {

            int count = 0;
            System.out.println("Index Servlet: doPost");
            try {
                count = db.getCardCount();
            } catch (Exception e) {
                e.printStackTrace();
            }

            backend.HelpEmail.helpEmail();
            String response = "";
            if (count < 1) {
                response = "<h1>No projects available :(</h1>";
            } else {
                for (int i = 0; i < count; i++) {
                    try {
                        accountInfo = db.getCardData(i + 1);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    String image = accountInfo.get(6);
                    String title = accountInfo.get(1);
                    String name = accountInfo.get(4);
                    String smallDesc = accountInfo.get(2);
                    response = response + "<div class=\"card\">\r\n" +
                            "						<img src=\"" + image + "\"style=width:300px;height:200px;\">\r\n" +
                            "						<div class=\"card-title\">\r\n" +
                            "						  <a href=\"#\" class=\"toggle-info btn\">\r\n" +
                            "							<span class=\"left\"></span>\r\n" +
                            "							<span class=\"right\"></span>\r\n" +
                            "						  </a>\r\n" +
                            "						  <h2>\r\n" +
                            title + "\r\n" +
                            "							  <small> By:" + name + "</small>\r\n" +
                            "						  </h2>\r\n" +
                            "						</div>\r\n" +
                            "						<div class=\"card-flap flap1\">\r\n" +
                            "						  <div class=\"card-description\">\r\n" +
                            smallDesc + "\r\n" +
                            "						  </div>\r\n" +
                            "						  <div class=\"card-flap flap2\">\r\n" +
                            "							<div class=\"card-actions\">\r\n" +
                            "							  <a href=\"#\" class=\"btn\">Join</a>\r\n" +
                            "							</div>\r\n" +
                            "						  </div>\r\n" +
                            "						</div>\r\n" +
                            "					  </div>";
                }

            }
            req.setAttribute("idea", response);
            req.getRequestDispatcher("/_view/index.jsp").forward(req, resp);
        }

    }
}