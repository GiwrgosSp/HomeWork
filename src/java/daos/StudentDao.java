package daos;

import entities.Student;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class StudentDao extends Database {

    public StudentDao() {
        super();
    }

    String server = "localhost:3306";
    String database = "bootcampdb";
    String username = "root";
    String password = "1234";

    private static final String selectStudents = "SELECT * FROM `bootcampdb`.`students`";

    public List<Student> getStudents() {
        Student st;
        List<Student> students = new ArrayList<>();

        setOptions("?zeroDateTimeBehavior=convertToNull&serverTimezone=Europe/Athens&useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false");
        ResultSet rs = Database(server, database, username, password, selectStudents);
        if (rs == null) {
            System.out.println("Error to the database");
        }

        try {
            while (rs.next()) {
                st = new Student(rs.getInt("ID"), rs.getString("SURNAME"),
                        rs.getString("NAME"), rs.getFloat("GRADE"),
                        rs.getString("BIRTHDATE"));
                students.add(st);
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return students;
    }

    public boolean insertStudent(Student st) {
      String query = "INSERT INTO `bootcampdb`.`students` \n" +
                        "(SURNAME,NAME,GRADE,BIRTHDATE) \n" +
                        "VALUES(\"" + st.getSurname() + "\",\"" + st.getName() + "\"," + st.getGrade() + "," + "\"" + st.getBirthDate() + "\")";
        int i =Database(server, database, username, password, query,(byte)1);
        if(i>=1){
            return true;
        }else{
            
            return false;
        }
        
    }
}  

 
