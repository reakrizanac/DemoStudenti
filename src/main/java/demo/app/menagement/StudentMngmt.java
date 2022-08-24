package demo.app.menagement;

import demo.app.database.dao.StudentDao;
import demo.app.rest.model.StudentModel;

import java.util.ArrayList;

public class StudentMngmt {

    //list of students
    public static ArrayList<StudentModel> getStudentsMngmt() throws Exception {

        ArrayList<StudentModel> responseMngmt = StudentDao.getStudents();
        return responseMngmt;
    }

    //create a student
    public static StudentModel createMngmt(StudentModel sm) throws Exception {

        if (sm.getName().length() < 5){
            System.out.println("kriva duljina");
        }

        StudentDao studentDaoCreate = new StudentDao();
        studentDaoCreate.create(sm);


        System.out.println("test2");
        StudentModel responseMngmt = studentDaoCreate.findStudentOib(sm.getOib());
        System.out.println("mngmt: " + responseMngmt);


        //ArrayList<StudentModel> responseMngmt = StudentDao.getStudents();

        return responseMngmt;
    }

    //delete by id
    public static ArrayList<StudentModel> deleteMngmt(int id) throws Exception {

        StudentDao studentDaoDelete = new StudentDao();
        studentDaoDelete.deleteStudent(id);

        ArrayList<StudentModel> responseMngmt = StudentDao.getStudents();

        return responseMngmt;
    }

    //find by id
    public static StudentModel findIdMngmt(int id) throws Exception {

        StudentDao studentDaoFind = new StudentDao();
        StudentModel responseMngmt = studentDaoFind.findStudentId(id);

        System.out.println("mngmt id: " + responseMngmt);

        return responseMngmt;
    }

    //find by oib
    public static StudentModel findOibMngmt(String oib) throws Exception {

        StudentDao studentDaoFind = new StudentDao();
        StudentModel responseMngmt = studentDaoFind.findStudentOib(oib);

        System.out.println("mngmt oib: " + responseMngmt);

        return responseMngmt;
    }


}
