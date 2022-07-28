package demo.app.menagement;

import demo.app.database.dao.StudentDao;
import demo.app.rest.controller.HelloRestService;
import demo.app.rest.model.StudentModel;

public class StudentMngmt {

    //list of students
    public static StudentDao getStudents(){
        StudentDao studentDaoList = new StudentDao();

        return studentDaoList;
    }

    //create a student
    public static StudentDao createMngmt(StudentModel std) throws Exception {
        StudentDao studentDaoCreate = new StudentDao();
        studentDaoCreate.create(std);

        //HelloRestService helloRestService = new HelloRestService();
        //helloRestService.getStudents();

        return studentDaoCreate;
    }

    //delete by id
    public static StudentDao deleteMngmt(StudentModel std) throws Exception {
        StudentDao studentDaoDelete = new StudentDao();
        studentDaoDelete.create(std);

        //HelloRestService helloRestService = new HelloRestService();
        //helloRestService.getStudents();

        return studentDaoDelete;
    }

}
