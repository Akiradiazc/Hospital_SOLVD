package ModelExceptions;

public class AppointmentPrintPersonException extends Exception{

    public AppointmentPrintPersonException(){}

    public AppointmentPrintPersonException(String message){
        super(message);
    }

    public AppointmentPrintPersonException(String message, Throwable cause){
        super(message, cause);
    }

}