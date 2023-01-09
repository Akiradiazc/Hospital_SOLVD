package ConnectionPoolPackage;
import Hospital_package.MainClass;
import org.apache.logging.log4j.*;

public class PoolThread extends Thread{

    private final static Logger Logger_pthread = LogManager.getLogger(MainClass.class.getName());

    public void run(){
        Logger_pthread.info("Message from a pool thread");
        CustomConnection con = ConnectionPool.newInstance().getConnection();
        if (con != null){
            Logger_pthread.info("Connection will be busy for "+ 5+" seconds");
            try {
                sleep(5000);
            } catch(InterruptedException e){
                throw new RuntimeException(e);
            }
            Logger_pthread.info("Releasing connection");
            ConnectionPool.newInstance().releaseConnection(con);
        }
    }
}
