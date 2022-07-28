package demo.app.rest.controller;

import demo.app.menagement.StudentMngmt;
import demo.app.rest.model.StudentModel;
import demo.app.database.dao.StudentDao;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.SQLException;
import java.util.List;

@Path("/")
public class HelloRestService {

    //List of students in Postman
    @GET
    @Path("/list")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getStudents() throws Exception {
        //medusloj
        List<StudentModel> studentList = StudentDao.getStudents();
        System.out.println("List of all students");
        return Response.status(200).entity(studentList).type(MediaType.APPLICATION_JSON).build();

        /*
        StudentDao studentList = StudentMngmt.getStudentsMngmt();
        System.out.println("List of all students");
        return Response.status(200).entity(studentList).type(MediaType.APPLICATION_JSON).build();
         */
    }

    //creating new student
    @POST
    @Path("/create")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createStudent(StudentModel sm) throws Exception {
        System.out.println("Creating a new student");
        System.out.println("rest" + sm);

        return Response.status(200).entity(StudentMngmt.createMngmt(sm)).type(MediaType.APPLICATION_JSON).build();
    }


    //deleting a student by id
    @POST
    @Path("/delete/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteStudent (@PathParam("id") int id) throws SQLException, ClassNotFoundException {
        System.out.println("Deleting student");

        return Response.status(200).entity(StudentDao.deleteStudent(id)).type(MediaType.APPLICATION_JSON).build();
        //return Response.status(200).entity(StudentMngmt.deleteMngmt(id)).type(MediaType.APPLICATION_JSON).build();
    }


}
