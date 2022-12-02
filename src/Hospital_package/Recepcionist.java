package Hospital_package;

public class Recepcionist extends HealthcarePerson{

    public Recepcionist(String name, int ID) {
        super(name, ID);
    }

    public Recepcionist(Clock Ent_hour, Clock Out_hour, int PhoneNum, String name, int ID, char gender, Date DOB) {
        super(Ent_hour, Out_hour, PhoneNum, name, ID, gender, DOB);
    }
}
