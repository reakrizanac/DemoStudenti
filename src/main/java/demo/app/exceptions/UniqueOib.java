package demo.app.exceptions;

public class UniqueOib extends Exception{

    public String toString(){
        return ("Oib is not unique");
    }

}
