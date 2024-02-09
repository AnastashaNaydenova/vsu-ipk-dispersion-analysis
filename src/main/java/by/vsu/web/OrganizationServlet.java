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

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			ObjectMapper mapper = new ObjectMapper();
			Organization organization = mapper.readValue(req.getInputStream(), Organization.class);
			if(organization.getId() != null) {
				OrganizationDao.update(organization);
				resp.setStatus(204);
			} else {
				OrganizationDao.create(organization);
				resp.setStatus(201);
			}
		} catch(SQLException | ClassNotFoundException e) {
			throw new ServletException(e);
		}
	}

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			String id = req.getParameter("id");
			if(id != null) {
				try {
					OrganizationDao.delete(Integer.valueOf(id));
					resp.setStatus(204);
				} catch(IllegalArgumentException e) {
					resp.sendError(404);
				}
			} else {
				resp.sendError(400);
			}
		} catch(SQLException | ClassNotFoundException e) {
			throw new ServletException(e);
		}
	}
}
