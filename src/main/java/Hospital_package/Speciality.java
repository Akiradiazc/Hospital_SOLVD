package Hospital_package;

import ModelExceptions.BelowZeroException;

import java.util.ArrayList;

import ModelExceptions.NoMatchException;
import org.apache.logging.log4j.*;

public class Speciality {
    private String name;
    private ArrayList<Doctor> DoctorsList;
    private static Logger LoggerNME_Speciality = LogManager.getLogger(MainClass.class.getName());

    public Speciality(String name, ArrayList<Doctor> DoctorsList) {
        this.name = name;
        this.DoctorsList = DoctorsList;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Doctor> getDoctorsList() {
        return DoctorsList;
    }

    public void setDoctorsList(ArrayList<Doctor> doctorsList) {
        DoctorsList = doctorsList;
    }

    public void setDoctorInList(Doctor doctor, Speciality speciality,ArrayList<Doctor> doctorsList) throws NoMatchException {
        if (doctor.getSpecialization().equals(speciality.getName())){
            doctorsList.add(doctor);
        } else {
            LoggerNME_Speciality.error("Doctor's speciality didn't match to speciality list");
            throw new NoMatchException("F", new RuntimeException());
        }
    }

    @Override
    public String toString() {
        return name;
    }
}
