package ModelExceptions;

public class NoMatchException extends Exception{
    public NoMatchException(){}

    public NoMatchException(String message){
        super(message);
    }

    public NoMatchException(String message, Throwable cause){
        super(message, cause);
    }
}
