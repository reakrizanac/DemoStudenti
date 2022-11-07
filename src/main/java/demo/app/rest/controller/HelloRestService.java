package demo.app.rest.controller;

import demo.app.menagement.StudentMgmt;
import demo.app.rest.model.StudentModel;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;

@Path("/")
public class HelloRestService {

    private static final Logger logger = LogManager.getLogger(StudentMgmt.class);

    //List of students in Postman
    @GET
    @Path("/list")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getStudents() throws Exception {
        ArrayList<StudentModel> studentList = StudentMgmt.getStudents();
        logger.info("In HelloRestService class, list of all students");
        return Response.status(200).entity(studentList).type(MediaType.APPLICATION_JSON).build();

    }

    //creating new student
    @POST
    @Path("/create")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createStudent(StudentModel sm) throws Exception {
        logger.info("In HelloRestService class, creating a new student");
        return Response.status(200).entity(StudentMgmt.createStudent(sm)).type(MediaType.APPLICATION_JSON).build();
    }


    //deleting a student by id
    @POST
    @Path("/delete/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteStudent (@PathParam("id") int id) throws Exception {
        logger.info("In HelloRestService class, deleting student");
        return Response.status(200).entity(StudentMgmt.deleteStudent(id)).type(MediaType.APPLICATION_JSON).build();
    }

    //find a student by id
    @POST
    @Path("/findbyid/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response findStudentId (@PathParam("id") int id) throws Exception {
        logger.info("In HelloRestService class, finding student by id");
        return Response.status(200).entity(StudentMgmt.getStudentById(id)).type(MediaType.APPLICATION_JSON).build();
    }

    //find a student by oib
    @POST
    @Path("/findbyoib/{oib}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response findStudentOib (@PathParam("oib") String oib) throws Exception {
        logger.info("In HelloRestService class, finding student by oib");
        return Response.status(200).entity(StudentMgmt.getStudentByOib(oib)).type(MediaType.APPLICATION_JSON).build();
    }


}
