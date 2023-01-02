package Hospital_package;

import java.util.ArrayList;
import ModelExceptions.*;
import org.apache.logging.log4j.*;

public class MainClass {

    private final static Logger Logger = LogManager.getLogger(MainClass.class.getName());

    public static void main(String[] args) throws BelowZeroException, NoMatchException, DoctorSlotOccupiedException, PatientScheduledException, AppointmentScheduledException, AppointmentPrintPersonException, PatientNotMatchException {

        // System introduction

        Logger.info("Welcome to Hospital Management system");
        Logger.info("...");
        Logger.info("Creating a new Hospital");

        //New hospital configuration - name, capacity and specialities

        Hospital Hospital1 = new Hospital();

        Hospital1.setHospital_name("Angeles");
        Hospital1.setCapacity(10);

        Logger.info("A new hospital with name: " + Hospital1.getHospital_name() + " has been created");
        Logger.info("A new hospital with capacity: " + Hospital1.getCapacity() + " people has been created");

        // Adding Specialities & appointments

        ArrayList<Speciality> SpecialitiesList = new ArrayList<>();
        Hospital1.setSpecialities(SpecialitiesList);

        ArrayList<Appointment> AppointmentsList = new ArrayList<>();
        Hospital1.setAppointments(AppointmentsList);

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
        doctor1.setEnt_hour(new Clock(7, 0));
        doctor1.setOut_hour(new Clock(15, 0));
        doctor1.setPhoneNum("6673035273");
        doctor1.setName("Stephen Strange");
        doctor1.setID(100);
        doctor1.setDOB(new Date(12, 12, 2021));
        doctor1.setSpecialization("Radiology");

        Logger.info("New doctor was created with the following info: ");
        Logger.info(doctor1);

        Doctor doctor2 = new Doctor();
        doctor2.setEnt_hour(new Clock(7, 0));
        doctor2.setOut_hour(new Clock(15, 0));
        doctor2.setPhoneNum("6671234568");
        doctor2.setName("Schwartz");
        doctor2.setID(101);
        doctor2.setDOB(new Date(12, 12, 2021));
        doctor2.setSpecialization("Radiology");

        Logger.info("New doctor was created with the following info: ");
        Logger.info(doctor2);

        Doctor doctor3 = new Doctor();
        doctor3.setEnt_hour(new Clock(7, 0));
        doctor3.setOut_hour(new Clock(15, 0));
        doctor3.setPhoneNum("6671234561");
        doctor3.setName("Schmidt");
        doctor3.setID(102);
        doctor3.setDOB(new Date(4, 12, 2021));
        doctor3.setSpecialization("Pediatrics");

        Logger.info("New doctor was created with the following info: ");
        Logger.info(doctor3);

        Doctor doctor4 = new Doctor();
        doctor4.setEnt_hour(new Clock(7, 0));
        doctor4.setOut_hour(new Clock(15, 0));
        doctor4.setPhoneNum("6671234562");
        doctor4.setName("Messi");
        doctor4.setID(103);
        doctor4.setDOB(new Date(4, 12, 1986));
        doctor4.setSpecialization("Pediatrics");

        Logger.info("New doctor was created with the following info: ");
        Logger.info(doctor4);

        //----------------------------Doctors added to list

        Radiology.setDoctorInList(doctor1, Radiology, RadiologyDrList);
        Radiology.setDoctorInList(doctor2, Radiology, RadiologyDrList);
        //Radiology.setDoctorInList(doctor4, Radiology, RadiologyDrList);
        Pediatrics.setDoctorInList(doctor3, Pediatrics, PediatricsDrList);
        Pediatrics.setDoctorInList(doctor4, Pediatrics, PediatricsDrList);

        Logger.info("Doctors where added to specialities lists");

        //---------------------------Final info log

        Logger.info("A new Hospital has been created with the following info");
        Logger.info(Hospital1);

        Logger.info("\n");

        //---------------------------Creating a new Patient

        Logger.info("Creating a new patient");

        Patient patient1 = new Patient();
        patient1.setName("David Diaz");
        patient1.setID(201);
        patient1.setGender('M');
        patient1.setDOB(new Date(27, 2, 1999));
        patient1.setDisease("Broken arm");

        Logger.info("Patient 1 has been created with the following info...");
        Logger.info(patient1);

        //---------------------------Creating a new Patient 2

        Logger.info("Creating a new patient");

        Patient patient2 = new Patient();
        patient2.setName("Stephen Curry");
        patient2.setID(202);
        patient2.setGender('M');
        patient2.setDOB(new Date(14, 3, 1988));
        patient2.setDisease("Broken shoulder");

        Logger.info("Patient 2 has been created with the following info...");
        Logger.info(patient2);

        //----------------------------Creating a new Patient 3

        Logger.info("Creating a new patient");

        Patient patient3 = new Patient();
        patient3.setName("Lebron James");
        patient3.setID(202);
        patient3.setGender('M');
        patient3.setDOB(new Date(30, 12, 1984));
        patient3.setDisease("Old");

        Logger.info("Patient 3 has been created with the following info...");
        Logger.info(patient3);

        //----------------------------Creating an appointment for patient1

        Logger.info("Creating an appointment for patient 1");

        Appointment appointment1 = new Appointment();
        appointment1.setDate(new Date(10, 10, 2010));
        appointment1.setApp_hour(new Clock(13, 30));
        appointment1.setPatient(patient1);
        appointment1.setDoctor(doctor1);

        //---------------------------Adding the appointment of patient1 to hospital's
        AppointmentInListAdder appointmentInListAdder = new AppointmentInListAdder();
        AppointmentInListThread appointmentThread1 = new AppointmentInListThread(appointmentInListAdder, AppointmentsList, appointment1);
        appointmentThread1.start();
        //Hospital1.setAppointmentInDocsList(AppointmentsList, appointment1);

        //---------------------------Creating an appointment for patient2

        Logger.info("Creating an appointment for patient 2");

        Appointment appointment2 = new Appointment();
        appointment2.setDate(new Date(10, 10, 2010));
        appointment2.setApp_hour(new Clock(14, 30));
        appointment2.setPatient(patient2);
        appointment2.setDoctor(doctor1);

        //--------------------------Adding the appointment of patient2 to hospital's
        AppointmentInListThread appointmentThread2 = new AppointmentInListThread(appointmentInListAdder, AppointmentsList, appointment2);
        appointmentThread2.start();

        //Hospital1.setAppointmentInDocsList(AppointmentsList, appointment2);

        //--------------------------Creating an appointment for patient2

        Logger.info("Creating an appointment for patient 3");

        Appointment appointment3 = new Appointment();
        appointment3.setDate(new Date(11, 12, 2010));
        appointment3.setApp_hour(new Clock(8, 30));
        appointment3.setPatient(patient3);
        appointment3.setDoctor(doctor2);

        //-------------------------Adding the appointment of patient3 to hospital's
        AppointmentInListThread appointmentThread3 = new AppointmentInListThread(appointmentInListAdder, AppointmentsList, appointment3);
        appointmentThread3.start();

        //Hospital1.setAppointmentInDocsList(AppointmentsList, appointment3);

        //-------------------------Creating objects to print the appointments for doctors and patients
        AppointmentsToPrint<Doctor, ArrayList<Appointment>> DoctorPrinter = new AppointmentsToPrint<>();
        AppointmentsToPrint<Patient, ArrayList<Appointment>> PatientPrinter = new AppointmentsToPrint<>();

        //  ---- Logger.info(Hospital1.getAppointments());

        //-------------------------Printing the appointments for Doctor 1 & 2 and for each Patient

        Logger.info("Showing Doctor 1 appointments");
        DoctorPrinter.PrintAppointment(doctor1, AppointmentsList);
        Logger.info("Showing Doctor 2 appointments");
        DoctorPrinter.PrintAppointment(doctor2, AppointmentsList);
        Logger.info("Showing Patient 1 appointments");
        PatientPrinter.PrintAppointment(patient1, AppointmentsList);
        Logger.info("Showing Patient 2 appointments");
        PatientPrinter.PrintAppointment(patient2, AppointmentsList);
        Logger.info("Showing Patient 3 appointments");
        PatientPrinter.PrintAppointment(patient3, AppointmentsList);

        //---------------------------Creating and printing the bill for each patient

        Logger.info("Printing Patient 1 bill: ");
        Bill bill1 = new Bill();
        bill1.setPatient(patient1);
        bill1.setAppointment(appointment1);
        bill1.generateBill();
        Logger.info(bill1);

        Logger.info("Printing Patient 2 bill: ");
        Bill bill2 = new Bill();
        bill2.setPatient(patient2);
        bill2.setAppointment(appointment2);
        bill2.generateBill();
        Logger.info(bill2);

        //--------------------------Creating a SearchBlock where an admin can search for a patient's appointment's details using his/her name and
        //--------------------------another parameter (doctor, date, or hour)

        Logger.info("Searching for an appointment from a given Patient and an additional parameter");

        SearchBlock SB1 = new SearchBlock(AppointmentsList);
        SB1.setListSearchAppointments(AppointmentsList);

        SB1.setAppSearchPatient(patient1);
        SB1.setAppSearchDate(new Date(10,10,2010));

        Logger.info("Searching for an appointment of Patient: " + patient1.getName());

        SB1.showSearchResults();

    }

}
