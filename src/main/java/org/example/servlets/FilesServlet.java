package org.example.servlets;

import org.example.accounts.UserService;
import org.example.accounts.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.Date;

@WebServlet("/files")
public class FilesServlet extends HttpServlet {

    private final String fileManagerPath = "C:\\Users\\Lutin\\fileManager\\";
    private final UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = (String)req.getSession().getAttribute("login");
        String pass = (String)req.getSession().getAttribute("pass");

        User user = userService.getUserByLogin(login);
        if (user == null || !user.getPass().equals(pass)) {
            resp.setContentType("text/html;charset=utf-8");
            resp.sendRedirect(req.getContextPath());
            return;
        }

        String path = req.getParameter("path");
        if (!path.contains(user.getLogin())) {
            String encodePath = URLEncoder.encode(fileManagerPath + login, "UTF-8");
            resp.sendRedirect(req.getContextPath() + "/files?path=" + encodePath);
            return;
        }

        File directory = new File(path);
        File[] files = directory.listFiles();

        req.setAttribute("basePath", directory.getAbsolutePath());
        req.setAttribute("files", files);
        req.setAttribute("timestamp", new Date());

        RequestDispatcher view = req.getRequestDispatcher("files.jsp");
        view.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().removeAttribute("login");
        req.getSession().removeAttribute("pass");
        resp.sendRedirect(req.getContextPath());
    }
}
