package comtapscontrolar;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import comtapsdao.StudentBoImp;
import comtapsmodules.Student;

@WebServlet("/DisplayAll")
public class DisplayAll extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        StudentBoImp sbo = new StudentBoImp();
        List<Student> students = sbo.getAll();

        // Set the students list as an attribute in the request
        request.setAttribute("students", students);

        // Forward the request to the JSP page for displaying students
        request.getRequestDispatcher("/displayall.jsp").forward(request, response);
    }
}
