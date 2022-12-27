package Hospital_package;

import ModelExceptions.PatientNotMatchException;
import org.apache.logging.log4j.*;

public class Bill {
    private AppointmentsPrices appointmentsPrices;
    private final static Logger Logger_Bill = LogManager.getLogger(MainClass.class.getName());
    private Patient patient;
    private Appointment appointment;
    private int Price;

    public Bill(){}
    public Bill(Patient patient, Appointment appointment){
        this.patient = patient;
        this.appointment = appointment;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Appointment getAppointment() {
        return appointment;
    }

    public void setAppointment(Appointment appointment) {
        this.appointment = appointment;
    }

    public void generateBill() throws PatientNotMatchException {
        if (this.patient.equals(this.appointment.getPatient())){
            String speciality_name = appointment.getDoctor().getSpecialization().toUpperCase();
            Price = AppointmentsPrices.valueOf(speciality_name).getAppointmentPrice();
        } else {
            Logger_Bill.info("Patient doesn't match with the appointment given.");
            throw new PatientNotMatchException("F");
        }
    }

    @Override
    public String toString() {
        return "\nYour Bill details are: " + "\n"+
                "Patient: " + patient.getName() + "\n" +
                "Appointment with Doctor: " + appointment.getDoctor().getName() + "\n" +
                "Speciality of appointment: " + appointment.getDoctor().getSpecialization() + "\n" +
                "Date: " + appointment.getDate() +" @ " + appointment.getApp_hour() + "\n" +
                "Total price: " + Price + "$";
    }
}
