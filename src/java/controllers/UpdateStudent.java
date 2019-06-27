package controllers;

import entities.Student;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import services.StudentService;

public class UpdateStudent extends HttpServlet {

    String stid="";
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        RequestDispatcher rd = request.getRequestDispatcher("updatestudent.jsp");
        request.setAttribute("title", "Update  Student");
        stid = request.getParameter("update");
        int stidint = Integer.parseInt(stid);
        StudentService ss = new StudentService();
        
        request.setAttribute("student", ss.getStudentById(stidint));
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try (PrintWriter out = response.getWriter()) {
         int stidint=Integer.parseInt(stid);
            
            Student st = new Student(stidint,request.getParameter("surname"),
                    request.getParameter("name"),
                    Float.parseFloat(request.getParameter("grade")),
                    request.getParameter("birthdate"));
            StudentService ss = new StudentService();

            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Update Student Servlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>UpdateStudent servlet " + request.getContextPath() + "</h1>");
            out.println("<br />");
            if (ss.updateStudent(st)) {
                out.println("updated SUCCESFULLY");
            } else {
                out.println("Student not updated");
            }
            out.println("</body>");
            out.println("</html>");

        }

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
