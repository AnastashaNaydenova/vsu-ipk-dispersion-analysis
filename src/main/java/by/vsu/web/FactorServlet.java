package by.vsu.web;

import by.vsu.dao.FactorDao;
import by.vsu.domain.Factor;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/factor")
public class FactorServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String id = req.getParameter("id");
		String animalId = req.getParameter("animal");
		if(id != null) {
			try {
				Factor factor = FactorDao.read(Integer.valueOf(id));
				if(factor != null) {
					resp.setStatus(200);
					resp.setContentType("application/json");
					resp.setCharacterEncoding("UTF-8");
					ObjectMapper mapper = new ObjectMapper();
					mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
					mapper.writeValue(resp.getWriter(), factor);
				} else {
					throw new IllegalArgumentException();
				}
			} catch(IllegalArgumentException e) {
				resp.sendError(404);
			}
		} else if(animalId != null) {
			try {
				List<Factor> factors = FactorDao.readByAnimal(Integer.valueOf(animalId));
				resp.setStatus(200);
				resp.setContentType("application/json");
				resp.setCharacterEncoding("UTF-8");
				ObjectMapper mapper = new ObjectMapper();
				mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
				mapper.writeValue(resp.getWriter(), factors);
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
		Factor factor = mapper.readValue(req.getInputStream(), Factor.class);
		if(factor.getId() != null) {
			FactorDao.update(factor);
			resp.setStatus(204);
		} else {
			FactorDao.create(factor);
			resp.setStatus(201);
		}
	}

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String id = req.getParameter("id");
		if(id != null) {
			try {
				FactorDao.delete(Integer.valueOf(id));
				resp.setStatus(204);
			} catch(IllegalArgumentException e) {
				resp.sendError(404);
			}
		} else {
			resp.sendError(400);
		}
	}
}
