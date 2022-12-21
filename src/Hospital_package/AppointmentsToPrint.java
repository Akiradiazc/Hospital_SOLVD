package Hospital_package;

import Interfaces.AppointmentPrintable;
import ModelExceptions.AppointmentPrintPersonException;
import org.apache.logging.log4j.*;

import javax.print.Doc;
import java.util.ArrayList;
import java.util.HashMap;

public class AppointmentsToPrint<T extends Person,A extends ArrayList<Appointment>> implements AppointmentPrintable<T, A> {
    private final static Logger Logger_AppPrint = LogManager.getLogger(MainClass.class.getName());

    private T person;
    private A AppointmentList;

    private HashMap<String, String> PatientsAppointments = new HashMap<>();
    private HashMap<String, String>DoctorsAppointments = new HashMap<>();

    AppointmentsToPrint(T person, A AppointmentList){
        this.person = person;
        this.AppointmentList = AppointmentList;
    }

    @Override
    public void PrintAppointment(T person, A AppointmentList) throws AppointmentPrintPersonException {
        if(person.getClass()== Doctor.class){
            DoctorsAppointments.clear();
            for(Appointment item: AppointmentList){
                if(item.getDoctor().equals(person)){
                    DoctorsAppointments.put(item.getPatient().getName(), (item.getDate().toString()+" @ "+item.getApp_hour().toString()));
                }
            }
            Logger_AppPrint.info("...");
            Logger_AppPrint.info("Showing the appointments scheduled for doctor "+person.getName() +":");
            for(String key: DoctorsAppointments.keySet()){
                Logger_AppPrint.info("Patient: "+key+" Date: "+DoctorsAppointments.get(key));
            }
        }
        else if(person.getClass()== Patient.class){
            PatientsAppointments.clear();
            for(Appointment item: AppointmentList){
                if(item.getPatient().equals(person)){
                    PatientsAppointments.put(item.getDoctor().getName(), (item.getDate().toString()+" @ "+item.getApp_hour().toString()));
                }
            }
            Logger_AppPrint.info("...");
            Logger_AppPrint.info("Showing the future appointments scheduled for patient " +person.getName()+ ":");
            for(String key: PatientsAppointments.keySet()){
                Logger_AppPrint.info("Doctor: "+key+ "Date: "+PatientsAppointments.get(key));
            }

        }
        else {
            Logger_AppPrint.error("Incapable to show appointments. Check Doctor or Patient provided");
            throw new AppointmentPrintPersonException("F. Person class not allowed");

        }

    }

}
