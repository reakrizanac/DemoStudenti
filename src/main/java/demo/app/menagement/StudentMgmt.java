package demo.app.menagement;

import demo.app.database.dao.StudentDao;
import demo.app.dto.StudentDto;
import demo.app.exceptions.UniqueOib;
import demo.app.exceptions.WrongLengthException;
import demo.app.properties.Cfg;
import demo.app.rest.model.StudentModel;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.ArrayList;

public class StudentMgmt {

    private static final Logger logger = LogManager.getLogger(StudentMgmt.class);

    private static final Cfg cfg = Cfg.getInstance();

    //list of students
    public static ArrayList<StudentDto> getStudents() throws Exception {

        return StudentDao.getStudents();

    }

    //create a student
    public static StudentDto createStudent(StudentDto sm) throws Exception {

        logger.info("U metodi create student");

        if (sm.getName().length() < Integer.parseInt(cfg.minNameLength)){
            logger.debug("Minimum name length is not acquired");
            throw new WrongLengthException();
        }

        if (sm.getOib().length() != Integer.parseInt(cfg.oibLength)){
            logger.debug("Oib is not unique");
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
    public static StudentDto getStudentById(int id) throws Exception {

        return StudentDao.getStudentById(id);
    }

    //find by oib
    public static StudentDto getStudentByOib(String oib) throws Exception {

        return StudentDao.getStudentByOib(oib);
    }


}
