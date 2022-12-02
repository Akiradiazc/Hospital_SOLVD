package Hospital_package;

import java.util.Objects;

public class Student extends HealthcarePerson{
    String Specialization;
    public Doctor doctor;

    public Student(String name, int ID, String Specialization, Doctor doctor) {
        super(name, ID);
        this.Specialization = Specialization;
        this.doctor = doctor;
    }

    public Student(Clock Ent_hour, Clock Out_hour, int PhoneNum, String name, int ID, char gender, Date DOB, String spec, Doctor doctor) {
        super(Ent_hour, Out_hour, PhoneNum, name, ID, gender, DOB);
        this.Specialization = spec;
        this.doctor = doctor;
    }

    public String getSpecialization() {
        return Specialization;
    }

    public void setSpecialization(String Specialization) {
        this.Specialization = Specialization;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }


    @Override
    public String toString() {
        return "Medicine student profile:\n"
                + "Name = " + getName() + '\n'
                + "Specialization = " + Specialization + "\n"
                + "Works from = " + Ent_hour + " to " + Out_hour + '\n'
                + "Works with doctor = " + doctor.getName();

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
        Student other = (Student) obj;
        return Objects.equals(Specialization, other.Specialization) && getName().equals(other.getName()) && doctor.getName().equals(other.doctor.getName());
    }
}
