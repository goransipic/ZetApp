package hr.goodapp.zetapp.timetable.adapter;

import java.util.ArrayList;
import java.util.List;

public class Train {
    private String mNumber;
    private String mName;
    private double mTime;


    public Train(String number, String name, double time ) {
        mNumber = number;
        mName = name;
        mTime = time;
    }

   public String getNumber() {
        return mNumber;
    }

    public void setNumber(String mNumber) {
        this.mNumber = mNumber;
    }

    public String getName() {
        return mName;
    }

    public void setName(String mName) {
        this.mName = mName;
    }

    public double getTime() {
        return mTime;
    }

    public void setTime(double mTime) {
        this.mTime = mTime;
    }

   public static List<Train> createTramList(int numTram) {
        List<Train> trains = new ArrayList<Train>();

       trains.add(new Train("1","Zapadni Kolodvor - Borongaj", 2.30));
       trains.add(new Train("5","Prečko - Maksimir", 1.11));
       trains.add(new Train("2","Črnomerec", 1.23));
       trains.add(new Train("12","Ljubljanica - Dubrava", 4.56));
       trains.add(new Train("4","Savski most", 2.45));
       trains.add(new Train("8","Mihaljevac - Zapruđe", 2.78));
       trains.add(new Train("6","Črnomerec - Sopot", 1.23));
       trains.add(new Train("3","Ljubljanica", 1.56));
       trains.add(new Train("7","Savski most - Dubrava",1.55));
       trains.add(new Train("13","Žitnjak - Kvartenikov Trg", 5.12));
       trains.add(new Train("9","Ljubljanica - Borongaj", 4.12));
       trains.add(new Train("11","Črnomerec - Dubec", 2.34));
       trains.add(new Train("15","Mihaljevac - Dolje", 2.11));
       trains.add(new Train("14","Mihaljevac - Zapruđe", 7.26));
       trains.add(new Train("17","Prečko - Borongaj", 2.45));

        return trains;
    }
}