package Hospital_project;

import java.util.Objects;

public class Nurse extends HealthcarePerson {
	String Specialization;

    public Nurse(String name, int ID, String Specialization) {
        super(name, ID);
        this.Specialization = Specialization;
    }

    public Nurse(Clock Ent_hour, Clock Out_hour, int PhoneNum, String name, int ID, char gender, Date DOB, String spec) {
        super(Ent_hour, Out_hour, PhoneNum, name, ID, gender, DOB);
        this.Specialization = spec;
    }

    public String getSpecialization() {
        return Specialization;
    }

    public void setSpecialization(String Specialization) {
        this.Specialization = Specialization;
    }


	@Override
	public String toString() {
		return "Nurse profile:\n"
				+ "Name = " + getName() + '\n'
				+ "Specialization = " + Specialization + "\n"
				+ "Works from = " + Ent_hour + " to " + Out_hour;
		
	}
    
	@Override
	public int hashCode() {
		return Objects.hash(Specialization, getName(), getID());
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Nurse other = (Nurse) obj;
		return Objects.equals(Specialization, other.Specialization) && getName().equals(other.getName());
	}
}
