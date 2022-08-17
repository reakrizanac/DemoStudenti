package demo.app.rest.controller;

import demo.app.database.dao.StudentDao;
import demo.app.menagement.StudentMngmt;
import demo.app.rest.model.StudentModel;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;

@Path("/")
public class HelloRestService {

    //List of students in Postman
    @GET
    @Path("/list")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getStudents() throws Exception {
        //medusloj
        ArrayList<StudentModel> studentList = StudentMngmt.getStudentsMngmt();
        System.out.println("List of all students");
        return Response.status(200).entity(studentList).type(MediaType.APPLICATION_JSON).build();

    }

    //creating new student
    @POST
    @Path("/create")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createStudent(StudentModel sm) throws Exception {
        System.out.println("Creating a new student");
        System.out.println("rest: " + sm);

        return Response.status(200).entity(StudentMngmt.createMngmt(sm)).type(MediaType.APPLICATION_JSON).build();
    }


    //deleting a student by id
    @POST
    @Path("/delete/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteStudent (@PathParam("id") int id) throws Exception {

        System.out.println("Deleting student");
        return Response.status(200).entity(StudentMngmt.deleteMngmt(id)).type(MediaType.APPLICATION_JSON).build();
    }

    //find a student by id
    @POST
    @Path("/findid/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response findStudentId (@PathParam("id") int id) throws Exception {

        System.out.println("Finding student");
        return Response.status(200).entity(StudentMngmt.findIdMngmt(id)).type(MediaType.APPLICATION_JSON).build();
    }

    //find a student by oib
    @POST
    @Path("/findoib/{oib}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response findStudentOib (@PathParam("oib") String oib) throws Exception {

        System.out.println("Finding student");
        return Response.status(200).entity(StudentMngmt.findOibMngmt(oib)).type(MediaType.APPLICATION_JSON).build();
    }


}
