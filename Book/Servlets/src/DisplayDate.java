

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DisplayDate extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		Date dt = new Date();
		SimpleDateFormat df = new SimpleDateFormat("E yyyy.MM.dd 'at' hh:mm:ss a zzz");
		out.print("<html><body bgcolor = \"f0f0f0\">");
		out.print("<h1 align = \"center\">Server Date & Time</h1>");
		out.print("<h2 align = \"center\">" + df.format(dt) + "</h1>");
		out.print("</body><html>");
	}

}
