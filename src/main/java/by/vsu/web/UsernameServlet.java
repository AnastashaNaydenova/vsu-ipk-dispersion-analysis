package by.vsu.web;

import by.vsu.dao.UsernameDao;
import by.vsu.domain.Username;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/username")
public class UsernameServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String id = req.getParameter("id");
            if(id != null) {
                try {
                    Username username = UsernameDao.read(Integer.valueOf(id));
                    if(username != null) {
                        resp.setStatus(200);
                        resp.setContentType("application/json");
                        resp.setCharacterEncoding("UTF-8");
                        ObjectMapper mapper = new ObjectMapper();
                        mapper.writeValue(resp.getWriter(), username);
                    } else {
                        throw new IllegalArgumentException();
                    }
                } catch(IllegalArgumentException e) {
                    resp.sendError(404);
                }
            } else {
                List<Username> usernames = UsernameDao.readAll();
                resp.setStatus(200);
                resp.setContentType("application/json");
                resp.setCharacterEncoding("UTF-8");
                ObjectMapper mapper = new ObjectMapper();
                mapper.writeValue(resp.getWriter(), usernames);
            }
        } catch(SQLException | ClassNotFoundException e) {
            throw new ServletException(e);
        }
    }
}
