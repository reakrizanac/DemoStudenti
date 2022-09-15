package demo.app.menagement;

import demo.app.database.dao.StudentDao;
import demo.app.properties.Cfg;
import demo.app.rest.model.StudentModel;

import java.util.ArrayList;

public class StudentMgmt {

    static Cfg app = Cfg.getInstance();

    //list of students
    public static ArrayList<StudentModel> getStudents() throws Exception {

        app.getPropValues();

        return StudentDao.getStudents();

        /*
        ArrayList<StudentModel> responseMgmt = StudentDao.getStudents();
        return responseMgmt;
         */

    }

    //create a student
    public static StudentModel createStudent(StudentModel sm) throws Exception {

        app.getPropValues();
        System.out.println(Integer.valueOf(app.nameProp));

        if (sm.getName().length() < Integer.parseInt(app.nameProp)){
            System.out.println("kriva duljina");
        }
        
        StudentDao.create(sm);

        //ArrayList<StudentModel> responseMngmt = StudentDao.getStudents();

        return StudentDao.findStudentOib(sm.getOib());
    }

    //delete by id
    public static ArrayList<StudentModel> deleteStudent(int id) throws Exception {

        StudentDao.deleteStudent(id);

        return StudentDao.getStudents();
    }

    //find by id
    public static StudentModel findId(int id) throws Exception {

        StudentModel responseMgmt = StudentDao.findStudentId(id);

        System.out.println("mngmt id: " + responseMgmt);

        return responseMgmt;
    }

    //find by oib
    public static StudentModel findOib(String oib) throws Exception {

        StudentModel responseMngmt = StudentDao.findStudentOib(oib);

        System.out.println("mgmt oib: " + responseMngmt);

        return responseMngmt;
    }


}
