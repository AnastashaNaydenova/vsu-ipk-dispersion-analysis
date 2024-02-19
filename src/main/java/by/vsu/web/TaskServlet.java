package by.vsu.web;

import by.vsu.dao.TaskDao;
import by.vsu.domain.Task;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/task")
public class TaskServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String id = req.getParameter("id");
		String userId = req.getParameter("user");
		if(id != null) {
			try {
				Task task = TaskDao.read(Integer.valueOf(id));
				if(task != null) {
					resp.setStatus(200);
					resp.setContentType("application/json");
					resp.setCharacterEncoding("UTF-8");
					ObjectMapper mapper = new ObjectMapper();
					mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
					mapper.writeValue(resp.getWriter(), task);
				} else {
					throw new IllegalArgumentException();
				}
			} catch(IllegalArgumentException e) {
				resp.sendError(404);
			}
		} else if(userId != null) {
			try {
				List<Task> tasks = TaskDao.readByUser(Integer.valueOf(userId));
				resp.setStatus(200);
				resp.setContentType("application/json");
				resp.setCharacterEncoding("UTF-8");
				ObjectMapper mapper = new ObjectMapper();
				mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
				mapper.writeValue(resp.getWriter(), tasks);
			} catch(NumberFormatException e) {
				resp.sendError(404);
			}
		} else {
			resp.sendError(400);
		}
	}
}
