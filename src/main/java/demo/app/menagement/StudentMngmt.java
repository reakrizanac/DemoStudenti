package demo.app.menagement;

import demo.app.database.dao.StudentDao;
import demo.app.properties.App1;
import demo.app.rest.model.StudentModel;

import java.util.ArrayList;

public class StudentMngmt {


    //list of students
    public static ArrayList<StudentModel> getStudentsMngmt() throws Exception {

        App1 app = new App1();
        app.getPropValues();

        ArrayList<StudentModel> responseMngmt = StudentDao.getStudents();
        return responseMngmt;


    }

    //create a student
    public static StudentModel createMngmt(StudentModel sm) throws Exception {

        App1 app = new App1();
        app.getPropValues();
        System.out.println(Integer.valueOf(app.nameProp));

        if (sm.getName().length() < Integer.valueOf(app.nameProp)){
            System.out.println("kriva duljina");
        }

        StudentDao studentDaoCreate = new StudentDao();
        studentDaoCreate.create(sm);

        StudentModel responseMngmt = studentDaoCreate.findStudentOib(sm.getOib());

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
