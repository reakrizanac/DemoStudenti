package demo.app.database.dao;

import demo.app.database.SqlConnection;
import demo.app.rest.model.StudentModel;

import java.sql.*;
import java.util.ArrayList;

public class StudentDao {

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
    public static void create(StudentModel std) throws ClassNotFoundException {

        String query = "INSERT INTO Studenti VALUES (?, ?, ?, ?, ?, ?)";
        //novi request njega return

        try {
            Connection connection = SqlConnection.getConnection();
            PreparedStatement st = connection.prepareStatement(query);

            st.setString(2, std.getName());
            st.setString(3, std.getOib());
            st.setString(4, std.getMobilePhone());
            st.setString(5, std.getEmail());
            st.setInt(6, std.getMentorId());

            st.executeUpdate();

            System.out.println("Test 2");

        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        //novi queri
        //return std;
        //return null;
    }

    //deleting a student by id
    public static StudentModel deleteStudent(int id) throws ClassNotFoundException, SQLException {

        StudentModel sm = new StudentModel();
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
        return null;

    }




    /*

    //Getting al the student second way
    //Test trial
    public static ArrayList<StudentModel> getStudents() throws Exception{

        ArrayList<StudentModel> allStudents = new ArrayList<>();
        Connection connection = SqlConnection.getConnection();

        String query = "SELECT * FROM Student";
        Statement st = connection.createStatement();
        ResultSet result = st.executeQuery(query);

        while (result.next()){
            StudentModel tmp = new StudentModel(result.getInt("id"), result.getString("name"), result.getString("oib"), result.getString("mobilePhone"), result.getString("email"), result.getInt("mentorId"));
            allStudents.add(tmp);
        }
        return allStudents;
    }

 */

    /*
    //Test trial
    //creating a new student second way

    public static void createSec(StudentModel std) throws ClassNotFoundException {


        StudentModel newStudent = new StudentModel();
        String query = "INSERT INTO student VALUES (" + std.getId() + ",'" + std.getName() + "','" + std.getOib() + "','" + std.getMobilePhone() + "','" + std.getEmail() + "','" + std.getMentorId() + "')";
        System.out.println(query);

        try {
            Connection connection = SqlConnection.getConnection();
            PreparedStatement st = connection.prepareStatement(query);

        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

 */

}


