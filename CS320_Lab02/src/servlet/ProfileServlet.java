package servlet;

import backend.DatabaseProvider;
import backend.DerbyDatabase;
import backend.IDatabase;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProfileServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private String username = null;
    ArrayList<String> accountInfo = new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        username = (String) req.getSession().getAttribute("username"); //session stuff

        if (username == null) {
            req.getRequestDispatcher("/login").forward(req, resp);
        } else {

            System.out.println("Profile Servlet: doGet");
            DatabaseProvider.setInstance(new DerbyDatabase());
            IDatabase db = DatabaseProvider.getInstance();


            try {
                accountInfo = db.getCardAccountData(username);
                req.setAttribute("loginId", accountInfo.get(0));
                req.setAttribute("username", accountInfo.get(1));
                req.setAttribute("password", accountInfo.get(2));
                req.setAttribute("email", accountInfo.get(3));
                req.setAttribute("name", accountInfo.get(4));
                req.setAttribute("gender", accountInfo.get(5));
                req.setAttribute("age", accountInfo.get(6));
                req.setAttribute("location", accountInfo.get(7));

            } catch (SQLException e) {
                e.printStackTrace();
            }

            req.getRequestDispatcher("/_view/profile.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        System.out.println("Profile Servlet: doPost");

    }
}
