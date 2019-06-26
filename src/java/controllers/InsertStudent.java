
package controllers;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


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
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet InsertStudent</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet InsertStudent at " + request.getContextPath() + "</h1>");
            out.println(request.getParameter("name")+" "+request.getParameter("surname"));
            
            out.println("</body>");
            out.println("</html>");
        } 
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
