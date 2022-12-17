package Hospital_package;

import ModelExceptions.BelowZeroException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import ModelExceptions.DoctorSlotOccupiedException;
import ModelExceptions.PatientScheduledException;
import org.apache.logging.log4j.*;

public class Hospital {
    private String Hospital_name;
    private int Capacity;
    private boolean Appointment_dr_available = false;
    private ArrayList<Speciality> Specialities;

    private HashMap<Integer, Doctor> AppoDoctor = new HashMap<>();
    private HashMap<Integer, Patient>AppoPatient = new HashMap<>();

    private final static Logger LoggerBZE_Hospital = LogManager.getLogger(MainClass.class.getName());

    public Hospital(){}

    public Hospital(String Hospital_name, int Capacity, ArrayList<Speciality> Specialities) {
        this.Hospital_name = Hospital_name;
        this.Capacity= Capacity;
        this.Specialities = Specialities;
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
            LoggerBZE_Hospital.error("Hospital capacity was set with a number less than zero");
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
    public void setAppointmentInDocsList(HashMap<Integer, Doctor> AppoDoctor, Appointment appointment) throws DoctorSlotOccupiedException {
        if ((AppoDoctor.containsValue(appointment.hashCode_wDoc())) ){
            LoggerBZE_Hospital.error("The doctor already has an appointment at that time. Select a different one");
            throw new DoctorSlotOccupiedException("F");
        } else {
            Appointment_dr_available = true;
        }
    }
    public void setAppointmentPatientsList(HashMap<Integer, Patient>AppoPatient, Appointment appointment, Patient patient, Doctor doctor) throws PatientScheduledException{
        if ((AppoPatient.containsValue(appointment.hashCode_wPat()))){
            LoggerBZE_Hospital.error("Patient already has an appointment at the same time. Select a different one ");
            throw new PatientScheduledException("F");
        } else if (Appointment_dr_available==true){
            AppoDoctor.put(appointment.hashCode_wDoc(), doctor);
            AppoPatient.put(appointment.hashCode_wPat(), patient);
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
