package Hospital_package;

public class Receptionist extends HealthcarePerson {

    public Receptionist() {
    }

    public Receptionist(String name, int ID) {
        super(name, ID);
    }

    public Receptionist(Clock Ent_hour, Clock Out_hour, String PhoneNum, String name, int ID, char gender, Date DOB) {
        super(Ent_hour, Out_hour, PhoneNum, name, ID, gender, DOB);
    }



    public Appointment GenerateAppointment(Doctor doctor, Patient patient, Date date, Clock hour){
        Appointment appointment = new Appointment();

        return appointment;
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
                + "Works from = " + ent_hour + ":" + ent_min + " to " + out_hour + ":" + out_min + "\n"
                + "PhoneNum = " + PhoneNum + '\n';
    }
}

