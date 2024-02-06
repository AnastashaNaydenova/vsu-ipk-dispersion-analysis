package by.vsu.web;

import by.vsu.dao.PropertyDao;
import by.vsu.domain.Property;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/property")
public class PropertyServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String id = req.getParameter("id");
		String animalId = req.getParameter("animal");
		if(id != null) {
			try {
				Property property = PropertyDao.read(Integer.valueOf(id));
				if(property != null) {
					resp.setStatus(200);
					resp.setContentType("application/json");
					resp.setCharacterEncoding("UTF-8");
					ObjectMapper mapper = new ObjectMapper();
					mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
					mapper.writeValue(resp.getWriter(), property);
				} else {
					throw new IllegalArgumentException();
				}
			} catch(IllegalArgumentException e) {
				resp.sendError(404);
			}
		} else if(animalId != null) {
			try {
				List<Property> properties = PropertyDao.readByAnimal(Integer.valueOf(animalId));
				resp.setStatus(200);
				resp.setContentType("application/json");
				resp.setCharacterEncoding("UTF-8");
				ObjectMapper mapper = new ObjectMapper();
				mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
				mapper.writeValue(resp.getWriter(), properties);
			} catch(NumberFormatException e) {
				resp.sendError(404);
			}
		} else {
			resp.sendError(400);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		ObjectMapper mapper = new ObjectMapper();
		Property property = mapper.readValue(req.getInputStream(), Property.class);
		if(property.getId() != null) {
			PropertyDao.update(property);
			resp.setStatus(204);
		} else {
			PropertyDao.create(property);
			resp.setStatus(201);
		}
	}

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String id = req.getParameter("id");
		if(id != null) {
			try {
				PropertyDao.delete(Integer.valueOf(id));
				resp.setStatus(204);
			} catch(IllegalArgumentException e) {
				resp.sendError(404);
			}
		} else {
			resp.sendError(400);
		}
	}
}
