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
            String delete = "<a href = 'DeleteStudent?delete=" + s.getId() + "'> Delete</a>";
            String update = "<a href = 'UpdateStudent?update=" + s.getId() + "'> Update</a>";
            str.append("<p>").append(s).append(delete).append(update).append("</p>");
        }

        str.append("</body>")
                .append("</html>");

        return str.toString();
    }

    public boolean insertStudent(Student st) {
        StudentDao stuDao = new StudentDao();
        if (stuDao.insertStudent(st)) {
            return true;
        }
        return false;
    }

    public boolean deleteStudent(int id) {
        StudentDao stuDao = new StudentDao();
        if (stuDao.deleteStudent(id)) {
            return true;
        }
        return false;
    }

    public Student getStudentById(int id) {
        StudentDao ss= new StudentDao();
        return ss.getStudentById(id);
    
    }
    
    public boolean updateStudent(Student st) {
        StudentDao stuDao = new StudentDao();
        Student stupdate = getStudentById(st.getId());
        if(st.getName()!=""){
           stupdate.setName(st.getName());  
       }
        if(st.getSurname()!=""){
           stupdate.setSurname(st.getSurname());  
       }
        if(st.getGrade()!=0){
           stupdate.setGrade(st.getGrade());  
       }
        if(st.getBirthDate()!=""){
           stupdate.setBirthDate(st.getBirthDate());  
       }
         
        if (stuDao.updateStudent(stupdate)) {
            return true;
        }
        return false;
    }

}
