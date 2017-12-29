package lecture3;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalTime;

public class Station {

    @Getter @Setter
    private String location;
    @Getter @Setter
    private LocalTime arrival;
    @Getter @Setter
    private LocalTime dispatch;
    @Getter @Setter
    private boolean endStation;


    @Override
    public String toString() {
        if(endStation)
            return location + ", time on station: " + arrival + "; ";
        return location +
                ", arrival=" + arrival +
                ", dispatch=" + dispatch;
    }

    public Station(String location, LocalTime arrival, LocalTime dispatch){
        this.location = location;
        this.arrival = arrival;
        this.dispatch = dispatch;
        this.endStation = false;
    }

    public Station(String location, LocalTime arrival){
        this.location = location;
        this.arrival = arrival;
        this.endStation = true;
    }
}
