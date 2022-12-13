package Hospital_package;

import java.util.ArrayList;
import java.util.Objects;

public abstract class HealthcarePerson extends Person{
    public Clock Ent_hour;
    public Clock Out_hour;
    ArrayList<Patient> patientList = new ArrayList<Patient>();
    String PhoneNum;

    public HealthcarePerson(){}

    public HealthcarePerson(String name, int ID) {
        super(name, ID);
    }

    public HealthcarePerson(Clock Ent_hour, Clock Out_hour, String PhoneNum, String name, int ID, char gender, Date DOB) {
        super(name, ID, gender, DOB);
        this.Ent_hour = Ent_hour;
        this.Out_hour = Out_hour;
        this.PhoneNum = PhoneNum;
    }

    public Clock getEnt_hour() {
        return Ent_hour;
    }

    public void setEnt_hour(Clock ent_hour) {
        Ent_hour = ent_hour;
    }

    public Clock getOut_hour() {
        return Out_hour;
    }

    public void setOut_hour(Clock out_hour) {
        Out_hour = out_hour;
    }

    public String getPhoneNum() {
        return PhoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        PhoneNum = phoneNum;
    }

    public ArrayList<Patient> getPatientList() {
        return patientList;
    }

    public void setPatientList(ArrayList<Patient> patientList) {
        this.patientList = patientList;
    }

    public String toString() {

        String ent_hour, ent_min, out_hour, out_min;

        if (Ent_hour.getHr() < 10) {
            ent_hour = "works from: 0"+Ent_hour.getHr();
        } else {
            ent_hour = "works from: "+Ent_hour.getHr();
        }

        if (Ent_hour.getMin() == 0){
            ent_min = ":00";
        } else if (Ent_hour.getMin() <10) {
            ent_min = ":0" + Ent_hour.getMin();
        } else {
            ent_min = ":" + Ent_hour.getMin();
        }

        if (Out_hour.getHr() < 10) {
            out_hour = "works to: 0"+Out_hour.getHr();
        } else {
            out_hour = "works to: "+Out_hour.getHr();
        }

        if (Out_hour.getMin() == 0){
            out_min = ":00";
        } else if (Out_hour.getMin() <10) {
            out_min = ":0" + Out_hour.getMin();
        } else {
            out_min = ":" + Out_hour.getMin();
        }

        return ent_hour + ent_min + "\n" + out_hour + out_min;

    }
}
