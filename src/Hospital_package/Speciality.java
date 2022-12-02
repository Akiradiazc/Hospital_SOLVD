package Hospital_package;

import java.util.ArrayList;

public class Speciality {
    private String name;
    private ArrayList<Doctor> DoctorsList;

    public Speciality(String name, ArrayList<Doctor> DoctorsList) {
        this.name = name;
        this.DoctorsList = DoctorsList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Doctor> getDoctorsList() {
        return DoctorsList;
    }

    public void setDoctorsList(ArrayList<Doctor> doctorsList) {
        DoctorsList = doctorsList;
    }

    @Override
    public String toString() {
        return name;
    }
}
