package Hospital_package;

import java.util.Objects;

interface IprescriptionGenerate {
    void GeneratePrescription();
}

interface IExaminationTestsGenerate {
    void GenerateExamTest();
}
public class Doctor extends HealthcarePerson implements IprescriptionGenerate, IExaminationTestsGenerate{

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

    @Override
    public void GeneratePrescription(){
        System.out.println("Take 2 paracetamol every 8 hours");
    }

    @Override
    public void GenerateExamTest(){
        System.out.println("Do a Urine Testing");
    }

    @Override
    public String toString() {

        String ent_hour, ent_min, out_hour, out_min;

        if (Ent_hour.getHr() < 10) {
            ent_hour = "0"+Ent_hour.getHr();
        } else {
            ent_hour = ""+Ent_hour.getHr();
        }

        if (Ent_hour.getMin() == 0){
            ent_min = "00";
        } else if (Ent_hour.getMin() <10) {
            ent_min = "0" + Ent_hour.getMin();
        } else {
            ent_min = "" + Ent_hour.getMin();
        }

        if (Out_hour.getHr() < 10) {
            out_hour = "0"+Out_hour.getHr();
        } else {
            out_hour = ""+Out_hour.getHr();
        }

        if (Out_hour.getMin() == 0){
            out_min = "00";
        } else if (Out_hour.getMin() <10) {
            out_min = "0" + Out_hour.getMin();
        } else {
            out_min = "" + Out_hour.getMin();
        }

        return "Doctor profile:\n"
                + "Name = " + getName() + '\n'
                + "Specialization = " + Specialization + "\n"
                + "Works from = " + ent_hour + ":" + ent_min + " to " + out_hour + ":" + out_min + "\n"
                + "PhoneNum = " + PhoneNum + '\n';
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
        Doctor other = (Doctor) obj;
        return Objects.equals(Specialization, other.Specialization) && getName().equals(other.getName());
    }
}
