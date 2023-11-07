package comtapscontrolar;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import comtapsdao.StudentBoImp;
import comtapsmodules.Student;

@WebServlet("/DisplaySingleStudent")
public class DisplayRecord extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Get the student ID from the request parameters
        int id = Integer.parseInt(request.getParameter("id"));

        StudentBoImp sbo = new StudentBoImp();
        Student student = sbo.get(id);

        // Set the student object as an attribute in the request
        request.setAttribute("student", student);

        // Forward the request to the JSP page for displaying the single student's details
        request.getRequestDispatcher("/displaySingleStudent.jsp").forward(request, response);
    }
}
