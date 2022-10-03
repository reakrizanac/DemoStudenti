package demo.app.exceptions;

public class WrongLengthException extends Exception{

    public String toString(){
        System.out.println("Name must be at least 3 characters");
        return ("Name length is wrong");
    }

}
