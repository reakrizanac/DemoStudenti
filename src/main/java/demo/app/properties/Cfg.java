package demo.app.properties;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Cfg {

    public String nameLenght;
    public String oibLenght;
    public String mobilePhoneLenght;
    public String emailLenght;
    String result = "";
    InputStream inputStream;

    private static Cfg instance = null;

    private Cfg(){}

    public String getPropValues() throws IOException {

        try {
            Properties prop = new Properties();
            String propFileName = "config.properties";

            inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);

            if (inputStream != null) {
                prop.load(inputStream);
            } else {
                throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
            }

            nameLenght = prop.getProperty("app.student.name.min.length");
            oibLenght = prop.getProperty("app.student.oib.length");
            mobilePhoneLenght = prop.getProperty("app.student.mobilePhone.min.length");
            emailLenght = prop.getProperty("app.student.email.min.length");

            result = "Validations :" + nameLenght + ", " + oibLenght + ", " + mobilePhoneLenght + ", " + emailLenght;
            System.out.println(result);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            inputStream.close();
        }
        return result;
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
