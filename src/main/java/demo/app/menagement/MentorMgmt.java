package demo.app.menagement;

import demo.app.database.dao.MentorDao;
import demo.app.dto.MentorDto;
import demo.app.properties.Cfg;
import demo.app.rest.model.ErrorModel;
import demo.app.rest.model.MentorModel;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.ArrayList;

public class MentorMgmt {

    private static final Logger logger = LogManager.getLogger(MentorMgmt.class);

    private static final Cfg cfg = Cfg.getInstance();

    //list of mentors
    public static ArrayList<MentorDto> getMentors() throws Exception {

        return MentorDao.getMentors();

    }

    //create a mentor
    public static Object createMentor(MentorDto mm) throws Exception {

        logger.info("U metodi create mentor");

        if (mm.getName().length() < Integer.parseInt(cfg.minNameLength)){
            logger.debug("Minimum name length is not acquired");
            return ErrorModel.ERR_MIN_LENGTH;
        }

        if (mm.getOib().length() != Integer.parseInt(cfg.oibLength)){
            logger.debug("Oib is not unique");
            return ErrorModel.ERR_MIN_LENGTH;
        }

        MentorDao.createNewMentor(mm);

        return MentorModel.convertToEntity(MentorDao.getMentorByOib(mm.getOib()));

    }

    //delete by id
    public static boolean deleteMentor(int id) throws Exception {

        MentorDao.deleteMentor(id);

        return true;
    }

    //find by id
    public static MentorDto getMentorById(int id) throws Exception {

        return MentorDao.getMentorById(id);
    }

    //find by oib
    public static MentorDto getMentorByOib(String oib) throws Exception {

        return MentorDao.getMentorByOib(oib);
    }


}
