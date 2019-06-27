<%-- 
    Document   : newstudent
    Created on : 26 Ιουν 2019, 11:58:21 πμ
    Author     : George
--%>

<%@page import="entities.Student"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>

        <h1><%=request.getAttribute("title")%></h1>

        <form method = "POST" action="UpdateStudent">
            
            <jsp:useBean id = "student" class="entities.Student" scope = "page" />
            Student to update:<%=request.getAttribute("student")%><br>
            <%! Student s = new Student();%>
            <% s= (Student)request.getAttribute("student"); %>


            Name: <input name ="name" type ="text" value="<%=s.getName() %>"/><br>
            Surname <input name ="surname" type ="text" value="<%=s.getSurname() %>"  /><br>
            Grade: <input name ="grade" type ="number" value="<%=s.getGrade() %>"/><br>
            BirthDate: <input name ="birthdate" type ="date"  value="<%=s.getBirthDate()%>"/><br>
            <input type="Submit" name="new" value ="Update Student"/> <br>
        </form>
    </body>
</html>
