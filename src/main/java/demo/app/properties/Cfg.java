package demo.app.properties;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Cfg {

    public String minNameLength;
    public String oibLength;
    public String minMobilePhoneLength;
    public String maxEmailLength;
    InputStream inputStream;

    private static Cfg instance = null;

    private Cfg(){
        getPropValues();
    }


    private void getPropValues() {

        try {
            Properties prop = new Properties();
            String propFileName = "config.properties";

            inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);

            if (inputStream != null) {
                prop.load(inputStream);
            } else {
                throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
            }

            minNameLength = prop.getProperty("app.student.name.min.length");
            oibLength = prop.getProperty("app.student.oib.length");
            minMobilePhoneLength = prop.getProperty("app.student.mobilePhone.min.length");
            maxEmailLength = prop.getProperty("app.student.email.max.length");


        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                if (inputStream != null){
                    inputStream.close();
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
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
