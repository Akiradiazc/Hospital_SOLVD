package Hospital_package;

import ModelExceptions.AppointmentScheduledException;
import ModelExceptions.BelowZeroException;
import ModelExceptions.DoctorSlotOccupiedException;
import ModelExceptions.PatientScheduledException;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.logging.log4j.*;

public class Hospital {
    private String Hospital_name;
    private int Capacity;
    private ArrayList<Appointment> Appointments;
    private ArrayList<Speciality> Specialities;
    private HashMap<Integer, Patient> PatientsAppointments = new HashMap<>();
    private HashMap<String, String>DoctorsAppointments = new HashMap<>();


    private final static Logger Logger_Hospital = LogManager.getLogger(MainClass.class.getName());

    public Hospital(){}

    public Hospital(String Hospital_name, int Capacity, ArrayList<Speciality> Specialities, ArrayList<Appointment> Appointments) {
        this.Hospital_name = Hospital_name;
        this.Capacity= Capacity;
        this.Specialities = Specialities;
        this.Appointments = Appointments;
    }

    public String getHospital_name() {
        return Hospital_name;
    }

    public void setHospital_name(String hospital_name) {
        Hospital_name = hospital_name;
    }

    public int getCapacity() {
        return Capacity;
    }

    public void setCapacity(int capacity) throws BelowZeroException {
        if (capacity > 0){
            Capacity = capacity;
        } else {
            Logger_Hospital.error("Hospital capacity was set with a number less than zero");
            throw new BelowZeroException("F");
        }
        /*
        try{
            if (capacity > 0){
                Capacity = capacity;
            } else {
                throw new BelowZeroException();
            }
        } catch (BelowZeroException BZE){
            LoggerBZE_Hospital.error(BZE.getCause());
            LoggerBZE_Hospital.error("Hospital capacity was set with a number less than zero");
        }
         */
    }

    public ArrayList<Speciality> getSpecialities() {
        return Specialities;
    }

    public void setSpecialities(ArrayList<Speciality> specialities) {
        Specialities = specialities;
    }
    public HashMap<Integer, Patient> getAppoPatient() {
        return PatientsAppointments;
    }

    public void setAppoPatient(HashMap<Integer, Patient> appoPatient) {
        PatientsAppointments = appoPatient;
    }

    public ArrayList<Appointment> getAppointments() {
        return Appointments;
    }

    public void setAppointments(ArrayList<Appointment> appointments) {
        Appointments = appointments;
    }

    public void setAppointmentInDocsList(ArrayList<Appointment> appointments, Appointment appointment) throws DoctorSlotOccupiedException, PatientScheduledException, AppointmentScheduledException {
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

    public void showDoctorsAppointments(ArrayList<Appointment> appointments, Doctor doctor){
        DoctorsAppointments.clear();
        for(Appointment item: appointments){
            if(item.getDoctor().equals(doctor)){
                DoctorsAppointments.put(item.getPatient().getName(), (item.getDate().toString()+" @ "+item.getApp_hour().toString()));
            }
        }
        Logger_Hospital.info("...");
        Logger_Hospital.info("Showing the appointments scheduled for doctor "+doctor.getName() +":");
        for(String key: DoctorsAppointments.keySet()){
            Logger_Hospital.info("Patient: "+key+" Date: "+DoctorsAppointments.get(key));
        }
    }

    @Override
    public String toString() {
        return "\nHospital Data" + '\n'
                +"----------------------------------\n"
                +"Hospital name: " + Hospital_name + '\n'
                + "Capacity: " + Capacity + " people" + '\n'
                + "Specialities that are handled: " + Specialities;
    }
}
