package Hospital_package;

import java.util.ArrayList;
import org.apache.logging.log4j.*;

public class AppointmentInListThread extends Thread{
    private AppointmentInListAdder AppointmentAdder;
    private ArrayList<Appointment> AppointmentList;
    private Appointment appointment;
    private final static Logger Logger_Hospital = LogManager.getLogger(MainClass.class.getName());

    AppointmentInListThread(AppointmentInListAdder AppointmentAdder, ArrayList<Appointment> AppointmentList, Appointment appointment){
        this.AppointmentAdder = AppointmentAdder;
        this.AppointmentList = AppointmentList;
        this.appointment = appointment;
    }

    @Override
    public void run(){
        try {
            AppointmentAdder.setAppointmentInDocsList(AppointmentList, appointment);
        } catch(Exception e){
            Logger_Hospital.error("An exception has been thrown!");
        }
    }

}
