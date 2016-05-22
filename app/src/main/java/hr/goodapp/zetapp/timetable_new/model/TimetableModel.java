package hr.goodapp.zetapp.timetable_new.model;

/**
 * Created by User on 21.5.2016..
 */
public class TimeTableModel {

    private String time;

    private String start;

    private String end;

    public TimeTableModel(String time, String start, String end) {
        this.time = time;
        this.start = start;
        this.end = end;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }
}
