package Hospital_project;

public class Patient extends Person {

	private boolean hasAppointment;
    private String Disease;
    private boolean hasHealthInsurance;
    private Medicine prescription;
    private Date AdmittedDate;
    private Double bill;

    public Patient(String name, int ID) {
        super(name, ID);
    }

    public Patient(String name, int ID, char gender, Date DOB) {
        super(name, ID, gender, DOB);
    }

    public void setHasAppointment(boolean hasAppointment) {
        this.hasAppointment = hasAppointment;
    }

    public void setDisease(String Disease) {
        this.Disease = Disease;
    }
    
    public void setHasHealthInsurance(boolean hasHealthInsurance) {
        this.hasHealthInsurance = hasHealthInsurance;
    }
    
    public String getDisease() {
        return Disease;
    }

}
