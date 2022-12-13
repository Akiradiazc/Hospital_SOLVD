package Hospital_package;

import Interfaces.AppointmentGeneratable;

public class Recepcionist extends HealthcarePerson implements AppointmentGeneratable{

    private Appointment appointment;

    public Recepcionist(String name, int ID) {
        super(name, ID);
    }

    public Recepcionist(Clock Ent_hour, Clock Out_hour, String PhoneNum, String name, int ID, char gender, Date DOB) {
        super(Ent_hour, Out_hour, PhoneNum, name, ID, gender, DOB);
    }

    public void setAppointment(Appointment appointment){

    }

    @Override
    public void GenerateAppointment(){
        //Appointment appointment = new Appointment();

    }

}
