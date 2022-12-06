package Hospital_package;

public class Appointment {

    private Doctor doctor;
    private Patient patient;
    private Date date;
    private Clock app_hour;

    public Appointment(Doctor doctor, Patient patient, Date date, Clock app_hour){
        this.doctor = doctor;
        this.patient = patient;
        this.date = date;
        this.app_hour = app_hour;
    }

    public void setAppointment(){
        System.out.println("The appointment has been set!");
        System.out.println("Doctor: " + doctor.getName());
        System.out.printf("Date: %d/$d/%d",date.getDay(), date.getMonth(), date.getYear());
        System.out.println("At: " + app_hour);
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
}
