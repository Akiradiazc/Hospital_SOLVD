package Hospital_package;

import java.util.ArrayList;

public class Hospital {
    private String Hospital_name;
    private int Capacity;
    private ArrayList<Speciality> Specialities;

    public Hospital(String Hospital_name, int Capacity, ArrayList<Speciality> Specialities) {
        this.Hospital_name = Hospital_name;
        this.Capacity= Capacity;
        this.Specialities = Specialities;
    }

    public String getHospital_name() {
        return Hospital_name;
    }

    public void setHospital_name(String hospital_name) {
        Hospital_name = hospital_name;
    }

    public int getCapacity() {
        return Capacity;
    }

    public void setCapacity(int capacity) {
        Capacity = capacity;
    }

    public ArrayList<Speciality> getSpecialities() {
        return Specialities;
    }

    public void setSpecialities(ArrayList<Speciality> specialities) {
        Specialities = specialities;
    }

    @Override
    public String toString() {
        return "Hospital Data" + '\n'
                +"----------------------------------\n"
                +"Hospital name: " + Hospital_name + '\n'
                + "Capacity: " + Capacity + '\n'
                + "Specialities that are handled: " + Specialities;
    }
}
