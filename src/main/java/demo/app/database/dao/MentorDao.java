package demo.app.database.dao;

import demo.app.database.SqlConnection;
import demo.app.rest.model.MentorModel;

import java.sql.*;
import java.util.ArrayList;

public class MentorDao extends MentorModel {


    //List of mentors
    public static ArrayList<MentorModel> getMentors() throws Exception{

        ArrayList<MentorModel> allMentors = new ArrayList<>();
        String query = "SELECT * FROM Mentor";

        try {
            Connection connection = SqlConnection.getConnection();
            Statement st = connection.createStatement();
            ResultSet result = st.executeQuery(query);

            while (result.next()){
                MentorModel mm = new MentorModel();
                mm.setId(result.getInt(1));
                mm.setName(result.getString(2));
                mm.setOib(result.getString(3));
                mm.setMobilePhone(result.getString(4));
                mm.setEmail(result.getString(5));

                allMentors.add(mm);
            }

        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        return allMentors;
    }

    //Creating a new mentor
    public static void createNewMentor(MentorModel mtd) throws ClassNotFoundException {

        String query = "INSERT INTO Mentor VALUES (?, ?, ?, ?, ?)";


        try {
            Connection connection = SqlConnection.getConnection();
            PreparedStatement st = connection.prepareStatement(query);

            st.setString(2, mtd.getName());
            st.setString(3, mtd.getOib());
            st.setString(4, mtd.getMobilePhone());
            st.setString(5, mtd.getEmail());

            st.executeUpdate();

        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //deleting a mentor by id
    public static boolean deleteMentor(int id) throws ClassNotFoundException {

        String sql = "delete from Mentor where id=" + id;

        try {
            Connection connection = SqlConnection.getConnection();
            Statement statement = connection.createStatement();
            //umjesto query ide statement
            //ResultSet resultSet = statement.executeQuery(sql);

        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        return true;
    }

    //find a mentor by id
    public static MentorModel getMentorById(int id) throws ClassNotFoundException {

        MentorModel mm = new MentorModel();
        String sql = "select * from Mentor where id=" + id;

        try {
            Connection connection = SqlConnection.getConnection();
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(sql);

            if (result.next()){

                mm.setId(result.getInt(1));
                mm.setName(result.getString(2));
                mm.setOib(result.getString(3));
                mm.setMobilePhone(result.getString(4));
                mm.setEmail(result.getString(5));

            }

        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        //System.out.println("dao: " + sm);
        return mm;
    }

    //find a mentor by oib
    public static MentorModel getMentorByOib(String oib) throws ClassNotFoundException {

        //System.out.println("find by oib");

        MentorModel mm = new MentorModel();
        String sql = "select * from Mentor where oib=" + oib;

        try {
            Connection connection = SqlConnection.getConnection();
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(sql);

            if (result.next()){

                mm.setId(result.getInt(1));
                mm.setName(result.getString(2));
                mm.setOib(result.getString(3));
                mm.setMobilePhone(result.getString(4));
                mm.setEmail(result.getString(5));

            }

        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        //System.out.println("dao oib: " + sm);
        return mm;
    }



}
