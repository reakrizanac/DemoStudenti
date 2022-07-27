package demo.app.menagement;

import demo.app.database.dao.StudentDao;
import demo.app.rest.controller.HelloRestService;
import demo.app.rest.model.StudentModel;

public class StudentMngmt {

    //create a student
    public static StudentDao createMngmt(StudentModel std) throws Exception {
        StudentDao studentDaoMngmt = new StudentDao();
        studentDaoMngmt.create(std);

        //HelloRestService helloRestService = new HelloRestService();
        //helloRestService.getStudents();

        return studentDaoMngmt;
    }

}
