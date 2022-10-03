package demo.app.properties;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Cfg {

    public String minNameLenght;
    public String oibLenght;
    public String minMobilePhoneLenght;
    public String maxEmailLenght;
    InputStream inputStream;

    private static Cfg instance = null;

    private Cfg(){
        getPropValues();
    }


    private String getPropValues() {

        try {
            Properties prop = new Properties();
            String propFileName = "config.properties";

            inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);

            if (inputStream != null) {
                prop.load(inputStream);
            } else {
                throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
            }

            minNameLenght = prop.getProperty("app.student.name.min.length");
            oibLenght = prop.getProperty("app.student.oib.length");
            minMobilePhoneLenght = prop.getProperty("app.student.mobilePhone.min.length");
            maxEmailLenght = prop.getProperty("app.student.email.max.length");


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public static Cfg getInstance()
    {
        if (instance == null){

            synchronized (Cfg.class){
                if (instance == null){
                    instance = new Cfg();
                }
            }
        }
        return instance;
    }



}
