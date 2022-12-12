package Hospital_package;

import ModelExceptions.BelowZeroException;

import java.util.ArrayList;
import org.apache.logging.log4j.*;

public class Hospital {
    private String Hospital_name;
    private int Capacity;
    private ArrayList<Speciality> Specialities;

    private static Logger LoggerBZE_Hospital = LogManager.getLogger(MainClass.class.getName());

    public Hospital(){}

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

    public void setCapacity(int capacity) throws BelowZeroException {
        if (capacity > 0){
            Capacity = capacity;
        } else {
            LoggerBZE_Hospital.error("Hospital capacity was set with a number less than zero");
            throw new BelowZeroException("F", new RuntimeException());
        }
        /*
        try{
            if (capacity > 0){
                Capacity = capacity;
            } else {
                throw new BelowZeroException();
            }
        } catch (BelowZeroException BZE){
            LoggerBZE_Hospital.error(BZE.getCause());
            LoggerBZE_Hospital.error("Hospital capacity was set with a number less than zero");
        }
         */
    }

    public ArrayList<Speciality> getSpecialities() {
        return Specialities;
    }

    public void setSpecialities(ArrayList<Speciality> specialities) {
        Specialities = specialities;
    }

    @Override
    public String toString() {
        return "\nHospital Data" + '\n'
                +"----------------------------------\n"
                +"Hospital name: " + Hospital_name + '\n'
                + "Capacity: " + Capacity + " people" + '\n'
                + "Specialities that are handled: " + Specialities;
    }
}
