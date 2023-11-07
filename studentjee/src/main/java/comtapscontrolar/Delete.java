package comtapscontrolar;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import comtapsdao.StudentBoImp;
import comtapsmodules.Student;
@WebServlet("/Delete")
public class Delete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		 int id = Integer.parseInt(request.getParameter("id"));

	        StudentBoImp sbo = new StudentBoImp();
	        int i = sbo.delete(id);
		
		
		 if (i == 1) {
			response.getWriter().write("Student record deleted successfully.");
	     } else {
           response.getWriter().write("Failed to delete student record.");
	     }

		
				
	}

}
