package demo.app.database.dao;

import demo.app.database.SqlConnection;
import demo.app.dto.StudentDto;
import demo.app.rest.model.StudentModel;

import java.sql.*;
import java.util.ArrayList;

public class StudentDao extends StudentModel {

    //List of
    public static ArrayList<StudentDto> getStudents() throws Exception{

        ArrayList<StudentDto> allStudents = new ArrayList<>();
        String query = "SELECT * FROM Student";

        try {
            Connection connection = SqlConnection.getConnection();
            Statement st = connection.createStatement();
            ResultSet result = st.executeQuery(query);

            while (result.next()){
                StudentDto sm = new StudentDto();
                sm.setId(result.getInt(1));
                sm.setName(result.getString(2));
                sm.setOib(result.getString(3));
                sm.setMobilePhone(result.getString(4));
                sm.setEmail(result.getString(5));
                sm.setMentorId(result.getInt(6));

                allStudents.add(sm);
            }

        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        return allStudents;
    }

    //Creating a new student
    public static void createNewStudent(StudentDto std) throws ClassNotFoundException {

        String query = "INSERT INTO Student VALUES (?, ?, ?, ?, ?, ?)";


        try {
            Connection connection = SqlConnection.getConnection();
            PreparedStatement st = connection.prepareStatement(query);


            st.setString(2, std.getName());
            st.setString(3, std.getOib());
            st.setString(4, std.getMobilePhone());
            st.setString(5, std.getEmail());
            st.setInt(6, std.getMentorId());

            st.executeUpdate();

        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //deleting a student by id
    public static void deleteStudent(int id) throws ClassNotFoundException{

        String sql = "delete from Student where id=?";

        try {
            Connection connection = SqlConnection.getConnection();
            PreparedStatement st = connection.prepareStatement(sql);

            st.setInt(1,id);
            st.executeUpdate();
        }
        catch (Exception e) {
            System.out.println(e);;
        }

    }

    //find a student by id
    public static StudentDto getStudentById(int id) throws ClassNotFoundException{

        StudentDto sm = new StudentDto();
        String sql = "select * from Student where id=" + id;

        try {
            Connection connection = SqlConnection.getConnection();
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(sql);

            if (result.next()){

                sm.setId(result.getInt(1));
                sm.setName(result.getString(2));
                sm.setOib(result.getString(3));
                sm.setMobilePhone(result.getString(4));
                sm.setEmail(result.getString(5));
                sm.setMentorId(result.getInt(6));
            }

        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        //System.out.println("dao: " + sm);
        return sm;
    }

    //find a student by oib
    public static StudentDto getStudentByOib(String oib) throws ClassNotFoundException{


        StudentDto sm = new StudentDto();
        String sql = "select * from Student where oib=" + oib;

        try {
            Connection connection = SqlConnection.getConnection();
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(sql);

            if (result.next()){

                sm.setId(result.getInt(1));
                sm.setName(result.getString(2));
                sm.setOib(result.getString(3));
                sm.setMobilePhone(result.getString(4));
                sm.setEmail(result.getString(5));
                sm.setMentorId(result.getInt(6));
            }

        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        //System.out.println("dao oib: " + sm);
        return sm;
    }

}


