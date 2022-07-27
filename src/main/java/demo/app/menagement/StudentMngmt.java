package demo.app.menagement;

import demo.app.database.dao.StudentDao;
import demo.app.rest.model.StudentModel;

public class StudentMngmt {

    //create a student
    public static StudentDao createMngmt(StudentModel std) throws ClassNotFoundException {
        StudentDao studentDaoMngmt = new StudentDao();
        studentDaoMngmt.create(std);

        return studentDaoMngmt;
    }

}
