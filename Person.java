package Hospital_project;

public class Person {

    private String name;
    private int ID;
    private char gender;
    private Date DOB;
    
    public Person(String name, int ID) {
        this.name = name;
        this.ID = ID;
    }

    public Person(String name, int ID, char gender, Date DOB) {
        this.name = name;
        this.ID = ID;
        this.gender = gender;
        this.DOB = DOB;
    }
    
    //Getters
    public void setName(String name) {
        this.name = name;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public void setDOB(Date DOB) {
        this.DOB = DOB;
    }
    //Setters
    public String getName() {
        return name;
    }

    public int getID() {
        return ID;
    }

    public char getGender() {
        return gender;
    }

    public Date getDOB() {
        return DOB;
    }
}
