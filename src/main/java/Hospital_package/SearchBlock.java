package Hospital_package;

import java.util.ArrayList;
import java.util.function.Predicate;
import java.util.List;

import org.apache.logging.log4j.*;

public class SearchBlock {
    private Date AppSearchDate;
    private Clock AppSearchHour;
    private Patient AppSearchPatient;
    private Doctor AppSearchDoctor;
    private ArrayList<Appointment> ListSearchAppointments;
    private final static Logger Logger_SB = LogManager.getLogger(MainClass.class.getName());

    SearchBlock(ArrayList<Appointment> ListSearchAppointments){
        this.ListSearchAppointments = ListSearchAppointments;
    }
    public Date getAppSearchDate() {
        return AppSearchDate;
    }
    public void setAppSearchDate(Date appSearchDate) {
        AppSearchDate = appSearchDate;
    }
    public Clock getAppSearchHour() {
        return AppSearchHour;
    }
    public void setAppSearchHour(Clock appSearchHour) {
        AppSearchHour = appSearchHour;
    }
    public Patient getAppSearchPatient() {
        return AppSearchPatient;
    }
    public void setAppSearchPatient(Patient appSearchPatient) {
        AppSearchPatient = appSearchPatient;
    }
    public Doctor getAppSearchDoctor() {
        return AppSearchDoctor;
    }
    public void setAppSearchDoctor(Doctor appSearchDoctor) {
        AppSearchDoctor = appSearchDoctor;
    }
    public ArrayList<Appointment> getListSearchAppointments() {
        return ListSearchAppointments;
    }
    public void setListSearchAppointments(ArrayList<Appointment> listSearchAppointments) {
        ListSearchAppointments = listSearchAppointments;
    }

    Predicate<Appointment> IsDate = x -> x.getDate().equals(AppSearchDate) && x.getPatient().equals(AppSearchPatient);
    Predicate<Appointment> IsHour = x -> x.getApp_hour().equals(this.getAppSearchHour())  && x.getPatient().equals(this.getAppSearchPatient());
    Predicate<Appointment> IsDoctor = x -> x.getDoctor().equals(this.getAppSearchDoctor())  && x.getPatient().equals(this.getAppSearchPatient());

    void showSearchResults(){
        if(ListSearchAppointments != null){
        List<Appointment> collect = ListSearchAppointments.stream()
                .filter(IsDate.or(IsHour).or(IsDoctor))
                .toList();
        Logger_SB.info("The following appointments were found: ");
        collect.forEach(Logger_SB::info);
        if(collect.size() ==0){
            Logger_SB.info("No Match results for the appointment, try using another parameters");
        }
        } else {
            Logger_SB.error("Call IT, appointments list not found!");
        }
    }
}
