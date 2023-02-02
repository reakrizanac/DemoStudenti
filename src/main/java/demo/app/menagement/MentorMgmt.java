package demo.app.menagement;

import demo.app.database.dao.MentorDao;
import demo.app.exceptions.UniqueOib;
import demo.app.exceptions.WrongLengthException;
import demo.app.properties.Cfg;
import demo.app.rest.model.MentorModel;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.ArrayList;

public class MentorMgmt {

    private static final Logger logger = LogManager.getLogger(MentorMgmt.class);

    private static final Cfg cfg = Cfg.getInstance();

    //list of mentors
    public static ArrayList<MentorModel> getMentors() throws Exception {

        return MentorDao.getMentors();

    }

    //create a mentor
    public static MentorModel createMentor(MentorModel mm) throws Exception {

        logger.info("U metodi create mentor");

        if (mm.getName().length() <= Integer.parseInt(cfg.minNameLength)){
            logger.debug("Minimum name length is not acquired");
            throw new WrongLengthException();
        }

        if (mm.getOib().length() != Integer.parseInt(cfg.oibLength)){
            logger.debug("Oib is not unique");
            throw new UniqueOib();
        }

        MentorDao.createNewMentor(mm);

        return MentorDao.getMentorByOib(mm.getOib());
    }

    //delete by id
    public static boolean deleteMentor(int id) throws Exception {

        MentorDao.deleteMentor(id);

        return true;
    }

    //find by id
    public static MentorModel getMentorById(int id) throws Exception {

        return MentorDao.getMentorById(id);
    }

    //find by oib
    public static MentorModel getMentorByOib(String oib) throws Exception {

        return MentorDao.getMentorByOib(oib);
    }


}
