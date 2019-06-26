
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


public class InsertStudent extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        RequestDispatcher rd = request.getRequestDispatcher("newstudent.jsp");
        request.setAttribute("title", "Insert New Student");
        rd.forward(request, response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       try (PrintWriter out = response.getWriter()) {
            Student st = new Student(request.getParameter("surname"),
                    request.getParameter("name"),
                    Float.parseFloat(request.getParameter("grade")),
                    request.getParameter("birthdate"));
            StudentService ss = new StudentService();
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>My First Servlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>This is a great servlet at " + request.getContextPath() + "</h1>");
            out.println("<br />");
            out.println("<p id='par1'>This is a paragraph</p>");
            if(ss.insertStudent(st)) {
                out.println("INSERTED SUCCESFULLY");
            }else{
                out.println("Student not inserted");
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
