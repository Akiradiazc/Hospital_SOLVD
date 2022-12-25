package Interfaces;

import Hospital_package.Appointment;

@FunctionalInterface
public interface AppointmentSearchable {
    boolean search(Appointment appointment);
}
