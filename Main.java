package Hospital_project;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Clock Ent_hour = new Clock(07, 00);
		Clock Out_hour = new Clock(15,00);
		
		System.out.println(Ent_hour);
		
		Date prueba_date = new Date(12,12,2021);
		Date date_david = new Date(27,02,1999);
		Date date_maria = new Date(9,03,1999);
		
		//Person David = new Person("David", 1234, 'M', prueba_date);
		
		//System.out.println(David);
		
		// HealthcarePerson Strange = new HealthcarePerson(Ent_hour, Out_hour, 66730352, "David", 1234, 'M', prueba_date);
		
		Doctor Strange = new Doctor(Ent_hour, Out_hour, 66730352, "Stephen Strange", 1234, 'M', prueba_date, "Neurosurgery");
		
		System.out.println(Strange);
		
		Patient David = new Patient("David", 123, 'M', date_david);
		Patient Maria = new Patient("Maria", 321, 'F', date_maria);
		
		David.setDisease("Broken arm");
		Maria.setDisease("Broken arm");
		
		System.out.println(David);
		
		Student student1= new Student(Ent_hour, Out_hour, 66730352, "Mario", 1234, 'M', prueba_date, "Neurosurgery", Strange);
		
		System.out.println(student1);
	}

}
