package Hospital_package;

import javax.print.attribute.standard.PagesPerMinuteColor;
import java.util.ArrayList;

public class MainClass {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        Hospital Hospital1 = new Hospital("Angeles", 400, 3, new ArrayList<>());

        Hospital1.setN(2);

        Speciality Radiology = new Speciality("Radiology", new ArrayList<>());
        Speciality Pediatry = new Speciality("Pediatry", new ArrayList<>());

        ArrayList<Speciality> Especialidades = new ArrayList<>(Hospital1.getN());

        ArrayList<Doctor> Radiologydoclist = new ArrayList<>();
        Radiology.setDoctorsList(Radiologydoclist);

        ArrayList<Doctor> Pediatrydoclist = new ArrayList<>();
        Pediatry.setDoctorsList(Pediatrydoclist);

        Radiologydoclist.add(
                new Doctor(
                        new Clock(07, 00),
                        new Clock(15,00),
                        66730352, "Stephen Strange",
                        1234, 'M', new Date(12,12,2021), "Radiology")
        );
        Radiologydoclist.add(
                new Doctor(
                        new Clock(07, 00),
                        new Clock(15,00),
                        66730352, "Julian Jimenez",
                        1234, 'M', new Date(12,12,2021), "Radiology")
        );

        Pediatrydoclist.add(
                new Doctor(
                        new Clock(07, 00),
                        new Clock(15,00),
                        66730352, "Simi Haze",
                        1234, 'M', new Date(12,12,2021), "Radiology")
        );
        Pediatrydoclist.add(
                new Doctor(
                        new Clock(07, 00),
                        new Clock(15,00),
                        66730352, "Julian Alvarez",
                        1234, 'M', new Date(12,12,2021), "Radiology")
        );

        Especialidades.add(Pediatry);
        Especialidades.add(Radiology);

        Hospital1.setSpecialities(Especialidades);

        Hospital1.getHospital_name();
        Hospital1.getSpecialities();

        System.out.println(Hospital1);

        Doctor Strange = new Doctor(
                new Clock(07, 00),
                new Clock(15,00),
                66730352, "Stephen Strange",
                1234, 'M', new Date(12,12,2021), "Neurosurgery");

        System.out.println(Strange);

        Patient David = new Patient(
                "David",
                123, 'M',
                new Date(27,02,1999));

        Patient Maria = new Patient(
                "Maria",
                321, 'F',
                new Date(9,03,1999));

        David.setDisease("Broken arm");
        Maria.setDisease("Broken arm");

        System.out.println(David);

    }

}