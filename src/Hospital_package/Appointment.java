package Hospital_package;

import java.util.Objects;

public class Appointment {

    private Doctor doctor;
    private Patient patient;
    private Date date;
    private Clock app_hour;

    public Appointment(){}

    public Appointment(Doctor doctor, Patient patient, Date date, Clock app_hour){
        this.doctor = doctor;
        this.patient = patient;
        this.date = date;
        this.app_hour = app_hour;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Clock getApp_hour() {
        return app_hour;
    }

    public void setApp_hour(Clock app_hour) {
        this.app_hour = app_hour;
    }

    @Override
    public String toString() {
        return "\nAppointment details:" + '\n' +
                "Doctor: " + doctor.getName() + '\n' +
                "Patient: " + patient.getName() + "\n"+
                "Date of the appointment: " + date + "\n" +
                "Hour of the: " + app_hour;
    }
    public int hashCode_wDoc(){
        return Objects.hash(date, app_hour, doctor);
    }

    public int hashCode_wPat(){
        return Objects.hash(date, app_hour, patient);
    }

    /*
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Appointment other = (Appointment) obj;
        return this.getDate().equals(other.getDate());
    }
*/
    @Override
    public boolean equals(Object obj){
        Appointment a = (Appointment) obj;
        if (this.getDate() != a.getDate())
            return false;
        if (this.getApp_hour() != a.getApp_hour())
            return false;
        if (this.getPatient() != a.getPatient())
            return false;
        if (this.getDoctor() != a.getDoctor())
            return false;
        return true;
    }

}
