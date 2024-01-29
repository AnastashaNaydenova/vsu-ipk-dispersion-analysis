package by.vsu.web;

import by.vsu.dao.OrganizationDao;
import by.vsu.domain.Organization;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/organization")
public class OrganizationServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			String id = req.getParameter("id");
			if(id != null) {
				try {
					Organization organization = OrganizationDao.read(Integer.valueOf(id));
					if(organization != null) {
						resp.setStatus(200);
						resp.setContentType("application/json");
						resp.setCharacterEncoding("UTF-8");
						ObjectMapper mapper = new ObjectMapper();
						mapper.writeValue(resp.getWriter(), organization);
					} else {
						throw new IllegalArgumentException();
					}
				} catch(IllegalArgumentException e) {
					resp.sendError(404);
				}
			} else {
				List<Organization> organizations = OrganizationDao.readAll();
				resp.setStatus(200);
				resp.setContentType("application/json");
				resp.setCharacterEncoding("UTF-8");
				ObjectMapper mapper = new ObjectMapper();
				mapper.writeValue(resp.getWriter(), organizations);
			}
		} catch(SQLException | ClassNotFoundException e) {
			throw new ServletException(e);
		}
	}
}
