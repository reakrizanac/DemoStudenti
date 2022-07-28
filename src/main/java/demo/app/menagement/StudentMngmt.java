package demo.app.menagement;

import demo.app.database.dao.StudentDao;
import demo.app.rest.model.StudentModel;

import java.util.ArrayList;

public class StudentMngmt {

    //list of students
    public static ArrayList<StudentModel> getStudents() throws Exception {

        ArrayList<StudentModel> responseMngmt = StudentDao.getStudents();
        return responseMngmt;
    }

    //create a student
    public static ArrayList<StudentModel> createMngmt(StudentModel std) throws Exception {
        StudentDao studentDaoCreate = new StudentDao();
        studentDaoCreate.create(std);

        ArrayList<StudentModel> responseMngmt = StudentDao.getStudents();

        return responseMngmt;
    }

    //delete by id
    public static ArrayList<StudentModel> deleteMngmt(int id) throws Exception {

        StudentDao studentDaoDelete = new StudentDao();
        studentDaoDelete.deleteStudent(id);

        ArrayList<StudentModel> responseMngmt = StudentDao.getStudents();

        return responseMngmt;
    }

}
