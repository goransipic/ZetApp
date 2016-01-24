package hr.goodapp.zetapp.zetlines.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 24.1.2016..
 */
public class ZetLines {

    String zetNumber;
    String zetVenhicleType;
    String zetRouteStations;


    public ZetLines(String zetNumber, String zetVenhicleType, String zetRouteStations) {
        this.zetNumber = zetNumber;
        this.zetVenhicleType = zetVenhicleType;
        this.zetRouteStations = zetRouteStations;
    }

    public String getZetNumber() {
        return zetNumber;
    }

    public void setZetNumber(String zetNumber) {
        this.zetNumber = zetNumber;
    }

    public String getZetVenhicleType() {
        return zetVenhicleType;
    }

    public void setZetVenhicleType(String zetVenhicleType) {
        this.zetVenhicleType = zetVenhicleType;
    }

    public String getZetRouteStations() {
        return zetRouteStations;
    }

    public void setZetRouteStations(String zetRouteStations) {
        this.zetRouteStations = zetRouteStations;
    }


    public static List<ZetLines> createTramList(int numTram) {
        List<ZetLines> trains = new ArrayList<ZetLines>();

        trains.add(new ZetLines("1","TRAM", "Borongaj\nLjubljanica\nSelska\nZapadni kolodvor"));
        trains.add(new ZetLines("2","TRAM", "Ljubljanica\nSavišće\nSelska\nŽitnjak\nČrnomerec"));
        trains.add(new ZetLines("3","TRAM", "Ljubljanica\nSavišće"));
        trains.add(new ZetLines("4","TRAM", "Dubec\nDubrava\nMandlova\nRavnice\nSavski most"));
        trains.add(new ZetLines("5","TRAM", "Prečko\nBukovačka\nLjubljanica\nBukovačka"));
        trains.add(new ZetLines("11","TRAM", "Črnomerec\nDubec\nMandlova\nLjubljanica"));
        trains.add(new ZetLines("15","TRAM", "Mihaljevac\nDolje\nRavnice\n"));
        trains.add(new ZetLines("109","BUS", "Črnomerec\nKauzlarićev prilaz\nZagrebačka avenija\n"));
        trains.add(new ZetLines("110","BUS","Savski most\nBotinec\n"));
        trains.add(new ZetLines("120","BUS", "Črnomerec\nHuzjanova\n"));
        trains.add(new ZetLines("268","BUS", "Glavni kolodvor\nVelika Gorica\nLisinski\nGlavni kolodvor\nZagrebačka"));
        trains.add(new ZetLines("132","BUS", "Savski most\nBrezovica škola\n"));
        trains.add(new ZetLines("122","BUS", "Črnomerec\nPodsusedski trg\n"));
        trains.add(new ZetLines("101","BUS", "Britanski trg\nPantovčak\n"));
        trains.add(new ZetLines("103","BUS", "Britanski trg\nKraljevec"));

        return trains;
    }
}
