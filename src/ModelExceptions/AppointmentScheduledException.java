package ModelExceptions;

public class AppointmentScheduledException extends Exception{

    public AppointmentScheduledException(){}

    public AppointmentScheduledException(String message){
        super(message);
    }

    public AppointmentScheduledException(String message, Throwable cause){
        super(message, cause);
    }

}