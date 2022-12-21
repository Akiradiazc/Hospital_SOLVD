package Hospital_package;

public enum AppointmentsPrices {

    RADIOLOGY(400),
    NEUROLOGY(800),
    PEDIATRICS(200);
    /*
    CARDIOLOGY(600),
    DERMATOLOGY(600),
    INTERNAL(800),
    PNEUMOLOGY(600),
    OPHTHALMOLOGY(500),
    ONCOLOGY(500);*/

    final int AppointmentPrice;

    AppointmentsPrices(int AppointmentPrice){
        this.AppointmentPrice = AppointmentPrice;
    }

}
