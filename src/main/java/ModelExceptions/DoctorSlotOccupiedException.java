package ModelExceptions;

public class DoctorSlotOccupiedException extends Exception {
    public DoctorSlotOccupiedException(){}

    public DoctorSlotOccupiedException(String message){
        super(message);
    }

    public DoctorSlotOccupiedException(String message, Throwable cause){
        super(message, cause);
    }
}
