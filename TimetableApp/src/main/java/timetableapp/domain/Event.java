package timetableapp.domain;

import java.util.ArrayList;

public class Event {
    private String subject;
    private int start;
    private int stop;
    private String day;
    
    public Event(String subject, int start, int stop, String day) {
        this.subject = subject;
        this.start = start;
        this.stop = stop;
        this.day = day;
    }
    
    public String getSubject() {
        return this.subject;
    }
    
    public int getStart() {
        return this.start;
    }
    
    public int getStop() {
        return this.stop;
    }
    
    public String getDay() {
        return this.day;
    }
    
    public void setSubject(String subject) {
        this.subject = subject;
    }
    
    public void setStart(int start) {
        this.start = start;
    }
    
    public void setStop(int stop) {
        this.stop = stop;
    }
    
    public void setDay(String day) {
        this.day = day;
    }
    /*
    public void startLater(int hours) {
        int newStart = this.start + hours;
        if (newStart < this.stop) {
            this.start = newStart;
        }
    }
    //Tässä on alustavana ylärajana lukkarin tämänhetkinen yläraja klo 19
    public void stopLater(int hours) {
        int newStop = this.stop + hours;
        if (newStop < 20) {
            this.stop = newStop;
        }
    }
    */
    
    @Override
    public String toString() {
        return this.subject + ";" + this.day 
                + ";" + String.valueOf(start) 
                + ";" + String.valueOf(stop);
    }
    //Apumetodi käyttöliittymälle, joka palauttaa aloitusajan koordinaateissa, keston ja päivän numerona
    /*
    public ArrayList<Integer> toCordinats() {
        ArrayList result = new ArrayList<>();
        result.add(this.start - 6);
        result.add(this.stop - this.start);
        if (this.day.equals("maanantai")) {
            result.add(1);
        }
        else if (this.day.equals("tiistai")) {
            result.add(2);
        }
        else if (this.day.equals("keskiviikko")) {
            result.add(3);
        }
        else if (this.day.equals("torstai")) {
            result.add(4);
        }
        else if (this.day.equals("perjantai")) {
            result.add(5);
        }
        else if (this.day.equals("lauantai")) {
            result.add(6);
        }
        else {
            result.add(7);
        }
        return result;
    }
    */
}
