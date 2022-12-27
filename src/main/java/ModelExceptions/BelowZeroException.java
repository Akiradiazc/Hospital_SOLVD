package ModelExceptions;

import Hospital_package.MainClass;
import org.apache.logging.log4j.*;

public class BelowZeroException extends Exception{

    private static Logger LoggerBZE = LogManager.getLogger(MainClass.class.getName());

    public BelowZeroException(){}

    public BelowZeroException(String message){
        super(message);
    }

    public BelowZeroException(String message, Throwable cause){
        super(message, cause);
    }

}
