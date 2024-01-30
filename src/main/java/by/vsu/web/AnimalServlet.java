package by.vsu.web;

import by.vsu.dao.AnimalDao;
import by.vsu.domain.Animal;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/animal")
public class AnimalServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String id = req.getParameter("id");
		if(id != null) {
			try {
				Animal animal = AnimalDao.read(Integer.valueOf(id));
				if(animal != null) {
					resp.setStatus(200);
					resp.setContentType("application/json");
					resp.setCharacterEncoding("UTF-8");
					ObjectMapper mapper = new ObjectMapper();
					mapper.writeValue(resp.getWriter(), animal);
				} else {
					throw new IllegalArgumentException();
				}
			} catch(IllegalArgumentException e) {
				resp.sendError(404);
			}
		} else {
			List<Animal> animals = AnimalDao.readAll();
			resp.setStatus(200);
			resp.setContentType("application/json");
			resp.setCharacterEncoding("UTF-8");
			ObjectMapper mapper = new ObjectMapper();
			mapper.writeValue(resp.getWriter(), animals);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		ObjectMapper mapper = new ObjectMapper();
		Animal animal = mapper.readValue(req.getInputStream(), Animal.class);
		if(animal.getId() != null) {
			AnimalDao.update(animal);
			resp.setStatus(204);
		} else {
			AnimalDao.create(animal);
			resp.setStatus(201);
		}
	}

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String id = req.getParameter("id");
		if(id != null) {
			try {
				AnimalDao.delete(Integer.valueOf(id));
				resp.setStatus(204);
			} catch(IllegalArgumentException e) {
				resp.sendError(404);
			}
		} else {
			resp.sendError(400);
		}
	}
}
