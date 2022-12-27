package Interfaces;

import ModelExceptions.AppointmentPrintPersonException;

public interface AppointmentPrintable<T, A>{
    void PrintAppointment(T person, A anAppointment) throws AppointmentPrintPersonException;
}
