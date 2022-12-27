package ModelExceptions;

public class PatientNotMatchException extends Exception{

    public PatientNotMatchException(){}

    public PatientNotMatchException(String message){
        super(message);
    }

    public PatientNotMatchException(String message, Throwable cause){
        super(message, cause);
    }

}