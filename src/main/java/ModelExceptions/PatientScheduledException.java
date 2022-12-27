package ModelExceptions;

public class PatientScheduledException extends Exception{

    public PatientScheduledException(){}

    public PatientScheduledException(String message){
        super(message);
    }

    public PatientScheduledException(String message, Throwable cause){
        super(message, cause);
    }

}
