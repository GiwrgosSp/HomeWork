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

    public StudentDao(){
        super();
    }
    
    
    
    private static final String selectStudents = "SELECT * FROM `bootcampdb`.`students`";
    private static final String insertStudent = "insert into student(surname,name,grade,birthdate) values(?,?,?,?)";

    

    public  List<Student> getStudents() {
        Student st;
        List<Student> students = new ArrayList<>();
        String server = "localhost:3306";
        String database = "bootcampdb";
        String username = "root";
        String password = "1234";
        String query = "SELECT * FROM `bootcampdb`.`students`";
        
        
        setOptions("?zeroDateTimeBehavior=convertToNull&serverTimezone=Europe/Athens&useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false");
        ResultSet rs = Database(server, database, username, password, query);
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

    public static void insertStudent() {
        
     
    }

    private static Date checkDate(Scanner input) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        Date d = null;
        try {
            System.out.println("Give date of birth in dd/mm/yyyy format");
            String date = input.nextLine();
            LocalDate ld = LocalDate.parse(date, formatter);
            d = Date.valueOf(ld);

        } catch (Exception e) {
            System.out.println("Invalid input.Try again");
            checkDate(input);
        }

        return d;

    }

}
