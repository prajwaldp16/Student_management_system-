package comtapscontrolar;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import comtapsdao.StudentBoImp;
import comtapsmodules.Student;


@WebServlet("/Update")
public class Update extends HttpServlet {
  
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int id = Integer.parseInt(req.getParameter("id"));
		String name = req.getParameter("name");
		int age = Integer.parseInt(req.getParameter("age"));
		String address = req.getParameter("address");
		String dept = req.getParameter("dept");
		
		Student s = new Student(id, name, age, address, dept);

		StudentBoImp sbo = new StudentBoImp();
		int i = sbo.update(s);
		
		
        resp.setContentType("text/html"); // Set content type to HTML
        PrintWriter out = resp.getWriter();

        out.println("<html>"); // Start HTML
        out.println("<body>"); // Start BODY

        if (i == 1) {
            out.println("<p>Student registration saved</p>");
            out.println("<form action=\"update.html\">");
            out.println("<input type=\"submit\" value=\"update More Student\">");
            out.println("</form>");
            out.println("<form action=\"index.html\">");
            out.println("<input type=\"submit\" value=\"Home Page\">");
            out.println("</form>");
        } else {
            out.println("<p>Student registration failed</p>");
            out.println("<form action=\"update.html\">");
            out.println("<input type=\"submit\" value=\"update More Student\">");
            out.println("</form>");
            out.println("<form action=\"index.html\">");
            out.println("<input type=\"submit\" value=\"Home Page\">");
            out.println("</form>");
        }


        out.println("</body>"); // End BODY
        out.println("</html>"); // End HTML
	}

}
