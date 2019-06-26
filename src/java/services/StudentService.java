package services;

import daos.StudentDao;
import entities.Student;
import java.util.List;

public class StudentService {

    public String getStudents() {
        StudentDao stuDao = new StudentDao();
        List<Student> students = stuDao.getStudents();
        StringBuilder str = new StringBuilder();

        str.append("<!DOCTYPE html>")
                .append("<html>")
                .append("<head>")
                .append("<title>Servlet StudentServlet</title>")
                .append("</head>")
                .append("<body>");

        for (Student s : students) {
            String delete = "<a href = 'DeleteStudent?delete=" +s.getId()+"'> Delete</a>";
            str.append("<p>").append(s).append(delete).append("</p>");
        }

        str.append("</body>")
                .append("</html>");

        return str.toString();
    }

    
    public boolean insertStudent(Student st){
        StudentDao stuDao = new StudentDao();
        if(stuDao.insertStudent(st)){
            return true;
        }
        return false;
    }
}
