package demo.app.menagement;

import demo.app.database.dao.StudentDao;
import demo.app.exceptions.UniqueOib;
import demo.app.exceptions.WrongLengthException;
import demo.app.properties.Cfg;
import demo.app.rest.model.StudentModel;

import java.util.ArrayList;

public class StudentMgmt {

    static Cfg cfg = Cfg.getInstance();

    //list of students
    public static ArrayList<StudentModel> getStudents() throws Exception {

        return StudentDao.getStudents();

    }

    //create a student
    public static StudentModel createStudent(StudentModel sm) throws Exception {

            if (sm.getName().length() <= Integer.parseInt(cfg.minNameLenght)){
                throw new WrongLengthException();
            }

            if (sm.getOib().length() == Integer.parseInt(cfg.oibLenght)){
                throw new UniqueOib();
            }


        
        StudentDao.createNewStudent(sm);

        return StudentDao.getStudentByOib(sm.getOib());
    }

    //delete by id
    public static boolean deleteStudent(int id) throws Exception {

        StudentDao.deleteStudent(id);

        return true;
    }

    //find by id
    public static StudentModel getStudentById(int id) throws Exception {

        return StudentDao.getStudentById(id);
    }

    //find by oib
    public static StudentModel getStudentByOib(String oib) throws Exception {

        return StudentDao.getStudentByOib(oib);
    }


}
