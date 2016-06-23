package hr.goodapp.zetapp.timetable_new.model;

import java.util.List;

/**
 * Created by goransi on 23.6.2016..
 */
public class TimeTableResultLoader {

    private List<TimeTableModel> timeTableModel;

    private String ImageUrl;


    public List<TimeTableModel> getTimeTableModel() {
        return timeTableModel;
    }

    public void setTimeTableModel(List<TimeTableModel> timeTableModel) {
        this.timeTableModel = timeTableModel;
    }

    public String getImageUrl() {
        return ImageUrl;
    }

    public void setImageUrl(String imageUrl) {
        ImageUrl = imageUrl;
    }
}
