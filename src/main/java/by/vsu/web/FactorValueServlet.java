package by.vsu.web;

import by.vsu.dao.FactorValueDao;
import by.vsu.domain.FactorValue;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/factor/value")
public class FactorValueServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String id = req.getParameter("id");
		String factorId = req.getParameter("factor");
		if(id != null) {
			try {
				FactorValue value = FactorValueDao.read(Integer.valueOf(id));
				if(value != null) {
					resp.setStatus(200);
					resp.setContentType("application/json");
					resp.setCharacterEncoding("UTF-8");
					ObjectMapper mapper = new ObjectMapper();
					mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
					mapper.writeValue(resp.getWriter(), value);
				} else {
					throw new IllegalArgumentException();
				}
			} catch(IllegalArgumentException e) {
				resp.sendError(404);
			}
		} else if(factorId != null) {
			try {
				List<FactorValue> values = FactorValueDao.readByFactor(Integer.valueOf(factorId));
				resp.setStatus(200);
				resp.setContentType("application/json");
				resp.setCharacterEncoding("UTF-8");
				ObjectMapper mapper = new ObjectMapper();
				mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
				mapper.writeValue(resp.getWriter(), values);
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
		FactorValue value = mapper.readValue(req.getInputStream(), FactorValue.class);
		if(value.getId() != null) {
			FactorValueDao.update(value);
			resp.setStatus(204);
		} else {
			FactorValueDao.create(value);
			resp.setStatus(201);
		}
	}

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String id = req.getParameter("id");
		if(id != null) {
			try {
				FactorValueDao.delete(Integer.valueOf(id));
				resp.setStatus(204);
			} catch(IllegalArgumentException e) {
				resp.sendError(404);
			}
		} else {
			resp.sendError(400);
		}
	}
}
