package Hospital_project;

public class Doctor extends HealthcarePerson{
	
	String Specialization;

    public Doctor(String name, int ID, String Specialization) {
        super(name, ID);
        this.Specialization = Specialization;
    }

    public Doctor(Clock Ent_hour, Clock Out_hour, int PhoneNum, String name, int ID, char gender, Date DOB, String spec) {
        super(Ent_hour, Out_hour, PhoneNum, name, ID, gender, DOB);
        this.Specialization = spec;
    }

    public String getSpecialization() {
        return Specialization;
    }

    public void setSpecialization(String Specialization) {
        this.Specialization = Specialization;
    }
    
    
    
}
