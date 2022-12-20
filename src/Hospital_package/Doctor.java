package Hospital_package;

import Interfaces.ExaminationTestGeneratable;
import Interfaces.PrescriptionGeneratable;

import javax.print.Doc;
import java.util.HashMap;
import java.util.Objects;

public class Doctor extends HealthcarePerson implements PrescriptionGeneratable, ExaminationTestGeneratable{

    String Specialization;

    public Doctor(){}

    public Doctor(String name, int ID, String Specialization, HashMap<Patient, Appointment> DocsAppo) {
        super(name, ID);
        this.Specialization = Specialization;
    }

    public Doctor(Clock Ent_hour, Clock Out_hour, String PhoneNum, String name, int ID, char gender, Date DOB, String spec) {
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

        return "\nDoctor profile:\n"
                + "Name = " + getName() + '\n'
                + "Specialization = " + Specialization + "\n"
                + "Works from = " + ent_hour + ":" + ent_min + " to " + out_hour + ":" + out_min + "\n"
                + "PhoneNum = " + PhoneNum + '\n';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Doctor doctor = (Doctor) o;
        return this.getName().equals(((Doctor) o).getName()) && this.getSpecialization().equals(((Doctor) o).getSpecialization());
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getName(), Specialization);
    }
}
