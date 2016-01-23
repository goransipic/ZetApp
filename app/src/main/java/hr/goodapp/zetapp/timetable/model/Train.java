package hr.goodapp.zetapp.timetable.model;

import java.util.ArrayList;
import java.util.List;

public class Train {
    private String mZetTypeOfVehicle;
    private String mNameStation;
    private String mNumbersOfTrains;

    public Train(String zetTypeOfVehicle, String nameStation, String numbersOfTrains ) {
        mZetTypeOfVehicle = zetTypeOfVehicle;
        mNameStation = nameStation;
        mNumbersOfTrains = numbersOfTrains;
    }

    public String getmZetTypeOfVehicle() {
        return mZetTypeOfVehicle;
    }

    public void setmZetTypeOfVehicle(String mZetTypeOfVehicle) {
        this.mZetTypeOfVehicle = mZetTypeOfVehicle;
    }

    public String getmNameStation() {
        return mNameStation;
    }

    public void setmNameStation(String mNameStation) {
        this.mNameStation = mNameStation;
    }

    public String getmNumbersOfTrains() {
        return mNumbersOfTrains;
    }

    public void setmNumbersOfTrains(String mNumbersOfTrains) {
        this.mNumbersOfTrains = mNumbersOfTrains;
    }

    public static List<Train> createTramList(int numTram) {
        List<Train> trains = new ArrayList<Train>();

       trains.add(new Train("TRAM","Trg dr. F. Tuđmana", "1 2 6 11 31"));
       trains.add(new Train("BUS","Britanski Trg", "101 102 103 105 138"));
       trains.add(new Train("TRAM","Trg J. Jelačića", "1 6 11 12 13 14 17 31 32 34"));
       trains.add(new Train("TRAM","Britanski trg", "1 6 11 31"));
       trains.add(new Train("TRAM","Kvaternikov trg", "4 5 6 7 8 11 12 13 14 15 31 33 34"));
       trains.add(new Train("TRAM","Trešnjevački trg", "1 2 3 5 9 11 12 17 32 34"));
       trains.add(new Train("TRAM","Trg hr. velikana", "1 17"));
       trains.add(new Train("BUS","Črnomerec", "127 128 126 135 125 137 121 130 124 120 131 123 122"));
       trains.add(new Train("BUS","Dubec","212 223 224 231 261 262 263 267 270 271 272 273 274"));
       trains.add(new Train("BUS","Dubrava", "205 206 208 209 210 213 223"));
       trains.add(new Train("BUS","Jankomir", "107 115 146"));
       trains.add(new Train("BUS","Kaptol", "105 106 201 226 238"));
       trains.add(new Train("TRAM","Selska", "12 9 3"));
       trains.add(new Train("TRAM","Vrbik", "5 13 3"));
       trains.add(new Train("TRAM","Vjesnik", "5 17 14 4"));

        return trains;
    }
}