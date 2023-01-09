package ConnectionPoolPackage;

import java.util.concurrent.ConcurrentLinkedQueue;

import Hospital_package.MainClass;
import org.apache.logging.log4j.*;

public class ConnectionPool {
    private static final int TOTAL_CONNECTIONS = 5;
    private ConcurrentLinkedQueue<CustomConnection> connections;

    private static ConnectionPool pool;
    private final static Logger Logger_pool = LogManager.getLogger(MainClass.class.getName());

    public ConnectionPool(){
        connections = new ConcurrentLinkedQueue<>();
        for(int i=0; i<TOTAL_CONNECTIONS; i++){
            connections.add(new CustomConnection());
        }
    }

    synchronized public static ConnectionPool newInstance(){
        if(pool == null){
            pool = new ConnectionPool();
        }
        return pool;
    }
    public synchronized CustomConnection getConnection(){
        while (connections.isEmpty()){
            try{
                Logger_pool.info("No free connections");
                wait();
            } catch (InterruptedException e){
                //ignore
            }
        }
        return connections.remove();
    }

    public synchronized void releaseConnection(CustomConnection con){
        connections.add(con);
        notifyAll();
    }
}
