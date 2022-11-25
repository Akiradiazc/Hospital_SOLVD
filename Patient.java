package Hospital_project;

import java.util.Objects;

public class Patient extends Person {

	//private boolean hasAppointment;
    private String Disease;
    //private boolean hasHealthInsurance;
    //private Medicine prescription;
    //private Date AdmittedDate;
    //private Double bill;

    public Patient(String name, int ID) {
        super(name, ID);
    }

    public Patient(String name, int ID, char gender, Date DOB) {
        super(name, ID, gender, DOB);
    }

    //public void setHasAppointment(boolean hasAppointment) {
    //    this.hasAppointment = hasAppointment;
    //}

    public void setDisease(String Disease) {
        this.Disease = Disease;
    }
    
    public String getDisease() {
        return Disease;
    }
    
    //public void setHasHealthInsurance(boolean hasHealthInsurance) {
    //    this.hasHealthInsurance = hasHealthInsurance;
    //}

    @Override
	public String toString() {
		return "Patient profile:\n"
				+ "Name = " + getName() + '\n'
				+ "Gender = " + getGender() + "\n"
				+ "ID = " + getID() + '\n'
				+ "Date of Birth = " + getDOB() + '\n'
				+ "Disease = " + getDisease() + '\n'
				;
	}

	@Override
	public int hashCode() {
		return Objects.hash(Disease, getName(), getGender(), getID(), getDOB());
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Patient other = (Patient) obj;
		return Objects.equals(Disease, other.Disease) && getName().equals(other.getName()) && getDOB().equals(other.getDOB());
	}
    
    

}
