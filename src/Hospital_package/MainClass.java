package Hospital_package;

import java.util.ArrayList;


import ModelExceptions.BelowZeroException;
import ModelExceptions.NoMatchException;
import org.apache.logging.log4j.*;

public class MainClass {

    private final static Logger Logger = LogManager.getLogger(MainClass.class.getName());

    public static void main(String[] args) throws BelowZeroException, NoMatchException {

        // System introduction

        Logger.info("Welcome to Hospital Management system");
        Logger.info("...");
        Logger.info("Creating a new Hospital");

        //New hospital configuration - name, capacity and specialities

        Hospital Hospital1 = new Hospital();

        Hospital1.setHospital_name("Angeles");
        Hospital1.setCapacity(10);

        Logger.info("A new hospital with name: "+Hospital1.getHospital_name() + " has been created");
        Logger.info("A new hospital with capacity: "+Hospital1.getCapacity() + " people has been created");

        // Adding Specialities

        ArrayList<Speciality> SpecialitiesList = new ArrayList<>();
        Hospital1.setSpecialities(SpecialitiesList);

        Logger.info("Adding Specialities to Hospital");

        Speciality Radiology = new Speciality("Radiology", new ArrayList<>());
        Speciality Pediatrics = new Speciality("Pediatrics", new ArrayList<>());

        SpecialitiesList.add(Pediatrics);
        SpecialitiesList.add(Radiology);

        Logger.info("The following specialities were added: " + Hospital1.getSpecialities());

        // Creation of List of doctors to add to respective Speciality list

        ArrayList<Doctor> RadiologyDrList = new ArrayList<>();
        Radiology.setDoctorsList(RadiologyDrList);

        ArrayList<Doctor> PediatricsDrList = new ArrayList<>();
        Pediatrics.setDoctorsList(PediatricsDrList);

        //Creation of doctors
        Logger.info("Creating doctors to add to the Specialities departments");

        Doctor doctor1 = new Doctor();
        doctor1.setEnt_hour(new Clock(07,00));
        doctor1.setOut_hour(new Clock(15, 00));
        doctor1.setPhoneNum("6673035273");
        doctor1.setName("Stephen Strange");
        doctor1.setID(100);
        doctor1.setDOB(new Date(12,12,2021));
        doctor1.setSpecialization("Radiology");

        Logger.info("New doctor was created with the following info: ");
        Logger.info(doctor1);

        Doctor doctor2 = new Doctor();
        doctor2.setEnt_hour(new Clock(07, 00));
        doctor2.setOut_hour(new Clock(15, 00));
        doctor2.setPhoneNum("6671234568");
        doctor2.setName("Schwartz");
        doctor2.setID(101);
        doctor2.setDOB(new Date(12,12,2021));
        doctor2.setSpecialization("Radiology");

        Logger.info("New doctor was created with the following info: ");
        Logger.info(doctor2);

        Doctor doctor3 = new Doctor();
        doctor3.setEnt_hour(new Clock(07, 00));
        doctor3.setOut_hour(new Clock(15, 00));
        doctor3.setPhoneNum("6671234561");
        doctor3.setName("Schmidt");
        doctor3.setID(102);
        doctor3.setDOB(new Date(4,12,2021));
        doctor3.setSpecialization("Pediatrics");

        Logger.info("New doctor was created with the following info: ");
        Logger.info(doctor3);

        Doctor doctor4 = new Doctor();
        doctor4.setEnt_hour(new Clock(07, 00));
        doctor4.setOut_hour(new Clock(15, 00));
        doctor4.setPhoneNum("6671234562");
        doctor4.setName("Messi");
        doctor4.setID(103);
        doctor4.setDOB(new Date(4,12,1986));
        doctor4.setSpecialization("Pediatrics");

        Logger.info("New doctor was created with the following info: ");
        Logger.info(doctor4);

        // Doctors added to list

        Logger.info(Radiology.getName());

        Radiology.setDoctorInList(doctor1, Radiology,RadiologyDrList);
        Radiology.setDoctorInList(doctor2, Radiology,RadiologyDrList);
        //Radiology.setDoctorInList(doctor4, Radiology, RadiologyDrList);
        Pediatrics.setDoctorInList(doctor3, Pediatrics,PediatricsDrList);
        Pediatrics.setDoctorInList(doctor4, Pediatrics,PediatricsDrList);

        Logger.info("Doctors where added to specialities lists");

        // Final info log

        Logger.info("A new Hospital has been created with the following info");
        Logger.info(Hospital1);

        Patient David = new Patient(
                "David",
                123, 'M',
                new Date(27,02,1999));

        David.setDisease("Broken arm");

    }

}
