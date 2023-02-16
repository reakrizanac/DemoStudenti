package demo.app.rest.controller;

import demo.app.dto.MentorDto;
import demo.app.dto.StudentDto;
import demo.app.exceptions.UniqueOib;
import demo.app.exceptions.WrongLengthException;
import demo.app.menagement.MentorMgmt;
import demo.app.menagement.StudentMgmt;
import demo.app.properties.Cfg;
import demo.app.rest.model.ErrorModel;
import demo.app.rest.model.MentorModel;
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
    private static final Cfg cfg = Cfg.getInstance();

    //List of in Postman
    @GET
    @Path("/listStudents")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getStudents() throws Exception {

        ArrayList<StudentDto> studentDtoList = StudentMgmt.getStudents();
        logger.info("In HelloRestService class, list of all students");
        return Response.status(200).entity(studentDtoList).type(MediaType.APPLICATION_JSON).build();
    }

    @GET
    @Path("/listMentors")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getMentors() throws Exception {
        ArrayList<MentorDto> mentorList = MentorMgmt.getMentors();
        logger.info("In HelloRestService class, list of all mentors");
        return Response.status(200).entity(mentorList).type(MediaType.APPLICATION_JSON).build();
    }

    //creating new
    @POST
    @Path("/createStudent")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createStudent(StudentModel sm) throws Exception {
        logger.info("In HelloRestService class, creating a new student");
        StudentDto studentDto = StudentModel.convertToDto(sm);

        try {
            return Response.status(200).entity(StudentMgmt.createStudent(studentDto)).type(MediaType.APPLICATION_JSON).build();
        }
        catch (Exception e){
            return Response.status(400).entity(ErrorModel.ERR_001).type(MediaType.APPLICATION_JSON).build();
        }

    }

    @POST
    @Path("/createMentor")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createMentor(MentorModel mm) throws Exception {
        logger.info("In HelloRestService class, creating a new mentor");

        MentorDto mentorDto = MentorModel.ConvertToDto(mm);

        if (mentorDto.getName().length() < Integer.parseInt(cfg.minNameLength)){
            logger.debug("Minimum name length is not acquired");
            throw new WrongLengthException();
        }

        if (mentorDto.getOib().length() != Integer.parseInt(cfg.oibLength)){
            logger.debug("Oib is not unique");
            throw new UniqueOib();
        }

        return Response.status(200).entity(MentorMgmt.createMentor(mentorDto)).type(MediaType.APPLICATION_JSON).build();
    }


    //deleting by id
    @DELETE
    @Path("/deleteStudent/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteStudent (@PathParam("id") int id) throws Exception {
        StudentDto studentDto = StudentMgmt.getStudentById(id);
        logger.info("In HelloRestService class, deleting student");
        if (studentDto.getId()!=0){
            return Response.status(200).entity(StudentMgmt.deleteStudent(id)).type(MediaType.APPLICATION_JSON).build();
        }
        return Response.status(200).entity(studentDto).type(MediaType.APPLICATION_JSON).build();
    }

    @DELETE
    @Path("/deleteMentor/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteMentor (@PathParam("id") int id) throws Exception {
        MentorDto mentorDto = MentorMgmt.getMentorById(id);
        logger.info("In HelloRestService class, deleting mentor");
        if (mentorDto.getId()!=0){
            return Response.status(200).entity(MentorMgmt.deleteMentor(id)).type(MediaType.APPLICATION_JSON).build();
        }
        return Response.status(200).entity(mentorDto).type(MediaType.APPLICATION_JSON).build();
    }

    //find  by id
    @POST
    @Path("/findStudentById/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response findStudentId (@PathParam("id") int id) throws Exception {
        logger.info("In HelloRestService class, finding student by id");
        return Response.status(200).entity(StudentMgmt.getStudentById(id)).type(MediaType.APPLICATION_JSON).build();
    }

    @POST
    @Path("/findMentorById/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response findMentorId (@PathParam("id") int id) throws Exception {
        logger.info("In HelloRestService class, finding mentor by id");
        return Response.status(200).entity(MentorMgmt.getMentorById(id)).type(MediaType.APPLICATION_JSON).build();
    }

    //find by oib
    @POST
    @Path("/findStudentByOib/{oib}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response findStudentOib (@PathParam("oib") String oib) throws Exception {

        logger.info("In HelloRestService class, finding student by oib");
        return Response.status(200).entity(StudentMgmt.getStudentByOib(oib)).type(MediaType.APPLICATION_JSON).build();
    }

    @POST
    @Path("/findMentorByOib/{oib}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response findMentorOib (@PathParam("oib") String oib) throws Exception {

        logger.info("In HelloRestService class, finding mentor by oib");
        return Response.status(200).entity(MentorMgmt.getMentorByOib(oib)).type(MediaType.APPLICATION_JSON).build();
    }

}
