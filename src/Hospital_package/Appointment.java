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

    public int AppEquEval(Appointment o){
        if (patient.equals(o.patient) && doctor.equals(o.doctor) && date.equals(o.date) && app_hour.equals(o.app_hour)) return 1;
        if (getClass() != o.getClass()) return 2;
        if (doctor.equals(o.doctor) && date.equals(o.date) && app_hour.equals(o.app_hour)) return 3;
        if (patient.equals(o.patient) &&  date.equals(o.date) && app_hour.equals(o.app_hour)) return 4;
        return 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(doctor, patient, date, app_hour);
    }
}
