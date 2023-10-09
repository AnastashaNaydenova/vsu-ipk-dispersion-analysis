package by.vsu;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

@WebServlet("/test.html")
public class TestServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		Random rnd = new Random();
		int redColor = rnd.nextInt(128);
		int greenColor = rnd.nextInt(128);
		int blueColor = rnd.nextInt(128);
		int redBackgroundColor = rnd.nextInt(128) + 128;
		int greenBackgroundColor = rnd.nextInt(128) + 128;
		int blueBackgroundColor = rnd.nextInt(128) + 128;
		resp.setStatus(200);
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		PrintWriter pw = resp.getWriter();
		pw.println("<!DOCTYPE html>");
		pw.println("<html>");
		pw.println("<head>");
		pw.println("<meta charset=\"UTF-8\">");
		pw.println("<title>Внутренняя страница</title>");
		pw.println("</head>");
		pw.println("<body>");
		pw.printf("<h1 style=\"background: rgb(%d, %d, %d); color: rgb(%d, %d, %d)\">Тестовое сообщение</h1>\n", redBackgroundColor, greenBackgroundColor, blueBackgroundColor, redColor, greenColor, blueColor);
		pw.println("</body>");
		pw.println("</html>");
	}
}
