package demo.app.database.dao;

import demo.app.database.SqlConnection;
import demo.app.rest.model.StudentModel;

import java.sql.*;
import java.util.ArrayList;

public class StudentDao extends StudentModel {

    //List of students
    public static ArrayList<StudentModel> getStudents() throws Exception{

        ArrayList<StudentModel> allStudents = new ArrayList<>();
        String query = "SELECT * FROM Studenti";

        try {
            Connection connection = SqlConnection.getConnection();
            Statement st = connection.createStatement();
            ResultSet result = st.executeQuery(query);

            while (result.next()){
                StudentModel sm = new StudentModel();
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
    public static void createNewStudent(StudentModel std) throws ClassNotFoundException {

        String query = "INSERT INTO Studenti VALUES (?, ?, ?, ?, ?, ?)";


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
    public static boolean deleteStudent(int id) throws ClassNotFoundException, SQLException {

        String sql = "delete from Studenti where id=" + id;

        try {
            Connection connection = SqlConnection.getConnection();
            Statement statement = connection.createStatement();
            //umjesto query ide statement
            ResultSet resultSet = statement.executeQuery(sql);

        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        return true;
    }

    //find a student by id
    public static StudentModel getStudentById(int id) throws ClassNotFoundException, SQLException {

        StudentModel sm = new StudentModel();
        String sql = "select * from Studenti where id=" + id;

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
    public static StudentModel getStudentByOib(String oib) throws ClassNotFoundException, SQLException {

        //System.out.println("find by oib");

        StudentModel sm = new StudentModel();
        String sql = "select * from Studenti where oib=" + oib;

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


