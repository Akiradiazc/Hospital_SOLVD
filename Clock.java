package Hospital_project;

public class Clock {
    private int hr;
    private int min;
    
    public Clock(int h, int m) { // initallizing constructor
        setTime(h, m);
    }
    
    public Clock() { // deafult constructor
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
    
    public void print() {
        System.out.println(hr + ":" + min);
    }
    
    public String toString() {
        return hr + ":" + min;
    }
}
