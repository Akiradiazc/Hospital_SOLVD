package Hospital_package;

import ModelExceptions.AppointmentScheduledException;
import ModelExceptions.DoctorSlotOccupiedException;
import ModelExceptions.PatientScheduledException;

import java.util.ArrayList;
import org.apache.logging.log4j.*;

public class AppointmentInListAdder {

    private final static Logger Logger_Hospital = LogManager.getLogger(MainClass.class.getName());

    public synchronized void setAppointmentInDocsList(ArrayList<Appointment> appointments, Appointment appointment) throws DoctorSlotOccupiedException, PatientScheduledException, AppointmentScheduledException {
        if (appointments.isEmpty()){
            appointments.add(appointment);
        } else {
            for(Appointment item: appointments){
                if(appointment.AppEquEval(item)==1){
                    Logger_Hospital.error("The appointment has already been scheduled");
                    throw new AppointmentScheduledException("Appointment duplicated");
                }
                else if(appointment.AppEquEval(item)==2){
                    Logger_Hospital.error("Supreme error call IT");
                }
                else if(appointment.AppEquEval(item)==3){
                    Logger_Hospital.error("The doctor already has an appointment at that time. Select a different one");
                    throw new DoctorSlotOccupiedException("Doctor Not Available");
                }
                else if(appointment.AppEquEval(item)==4){
                    Logger_Hospital.error("Patient already has an appointment at that time. Select a different one");
                    throw new PatientScheduledException("Patient Not Available");
                } else {
                    appointments.add(appointment);
                    break;
                }
            }
        }
    }
}
