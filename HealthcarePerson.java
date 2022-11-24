package Hospital_project;

import java.util.ArrayList;

public class HealthcarePerson extends Person {
	public Clock Ent_hour;
    public Clock Out_hour;
    ArrayList <Patient> patientList = new ArrayList<Patient>();
    int PhoneNum;

    public HealthcarePerson(String name, int ID) {
        super(name, ID);
    }

    public HealthcarePerson(Clock Ent_hour, Clock Out_hour, int PhoneNum, String name, int ID, char gender, Date DOB) {
        super(name, ID, gender, DOB);
        this.Ent_hour = Ent_hour;
        this.Out_hour = Out_hour;
        this.PhoneNum = PhoneNum;
    }
    
    public String toString() {
        
        return "works from: "+Ent_hour + "\nworks to: " + Out_hour + "\n" + PhoneNum;

    }
}
