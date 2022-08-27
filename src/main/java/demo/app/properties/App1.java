package demo.app.properties;

import demo.app.rest.model.StudentModel;

import java.io.*;
import java.util.Properties;

public class App1 {

    public String nameProp;
    public String oibProp;
    public String mobilePhoneProp;
    public String emailProp;
    String result = "";
    InputStream inputStream;

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

            nameProp = prop.getProperty("app.student.name.min.length");
            oibProp = prop.getProperty("app.student.oib.length");
            mobilePhoneProp = prop.getProperty("app.student.mobilePhone.min.length");
            emailProp = prop.getProperty("app.student.email.min.length");

            result = "Validations " + nameProp + ", " + oibProp + ", " + mobilePhoneProp + ", " + emailProp;
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

}
