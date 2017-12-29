package lecture3;

import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Train {

    @Getter @Setter
    private int trainNumber;
    @Getter @Setter
    private int emptyPlaces;

    @Getter @Setter
    private Periodicity periodicity;


    @Getter @Setter
    private List<Station> stations;

    public Train(int trainNumber, List<Station> stations, int emptyPlaces, Periodicity periodicity){
        this.trainNumber = trainNumber;
        this.stations = stations;
        this.emptyPlaces = emptyPlaces;
        this.periodicity = periodicity;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Train number " + trainNumber +
                ", Dispatch Station: " + stations.get(0) +
                " Arrival Station: " + stations.get(stations.size()-1) + " Empty places: " + emptyPlaces + " Periodicity: " + periodicity +"\nIntermediate Station :\n");
        for (int i=1; i<stations.size()-1; i++) {
            sb.append(stations.get(i));
            sb.append('\n');
        }

        return sb.toString();
    }
}
