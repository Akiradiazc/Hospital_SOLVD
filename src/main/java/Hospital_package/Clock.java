package Hospital_package;

import java.util.Objects;

public class Clock {
    private int hr;
    private int min;

    public Clock(int h, int m) { // initiallizing constructor
        setTime(h, m);
    }
    public Clock() { // default constructor
        hr = 0;
        min = 0;
    }
    public void setTime(int h, int m) {
        setHr(h);
        setMin(m);
    }
    public void setHr(int v) {
        hr = v;
        if (hr < 0 || hr > 23) {
            hr = 0;
        }
    }
    public void setMin(int v) {
        min = v;
        if (min < 0 || min > 59) {
            min = 00;
        }
    }
    //Getters
    public int getHr() {
        return hr;
    }
    public int getMin() {
        return min;
    }
    public String toString() {
        String ent_hour, ent_min, out_hour, out_min;

        if (hr< 10) {
            ent_hour = "0"+hr;
        } else {
            ent_hour = ""+hr;
        }

        if (min == 0){
            ent_min = "00";
        } else if (min <10) {
            ent_min = "0" + min;
        } else {
            ent_min = "" + min;
        }

        return ent_hour + ":" + ent_min;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Clock clock = (Clock) o;
        return hr == clock.hr && min == clock.min;
    }

    @Override
    public int hashCode() {
        return Objects.hash(hr, min);
    }
}
