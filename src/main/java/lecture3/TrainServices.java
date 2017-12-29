package lecture3;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class TrainServices {

    public static List<Train> getTrainFromTo(List<Train> trains, String startLocation, String endLocation){
        List<Train> checkedTrains = new ArrayList<>();
        for (Train t: trains){
            for (int i=0; i<t.getStations().size()-1; i++){
                if(t.getStations().get(i).getLocation().equals(startLocation) && checkOneTrain(t, endLocation, i)){
                    checkedTrains.add(t);
                }
            }
        }
        return checkedTrains;
    }

    public static List<Train> getTrainFromStartTime(List<Train> trains, LocalTime startTime){
        List<Train> checkedTrains = new ArrayList<>();
        for(Train t: trains){
            if(t.getStations().get(0).getArrival().compareTo(startTime) > 0)
                checkedTrains.add(t);


        }
        return checkedTrains;
    }

    public static List<Train> getTrainFromDate(List<Train> trains, LocalDate date){
        List<Train> checkedTrains = new ArrayList<>();
        for(Train t: trains){
            if (t.getPeriodicity() == Periodicity.EVERY_DAY)
                checkedTrains.add(t);
            else if (date.getDayOfMonth()%2 != 0 && t.getPeriodicity() == Periodicity.ODD_DAY )
                checkedTrains.add(t);
            else if (date.getDayOfMonth() %2 == 0 && t.getPeriodicity() == Periodicity.EVEN_DAY )
                checkedTrains.add(t);
            else if (date.getDayOfMonth() %3 == 0 && t.getPeriodicity() == Periodicity.EVERY_THIRD_DAY)
                checkedTrains.add(t);
            else if (t.getPeriodicity().toString().contains(date.getDayOfWeek().toString()))
                checkedTrains.add(t);
        }
        return checkedTrains;
    }

    public static Train searchByPlaces(List<Train> trains, int places){
        int difference = Integer.MAX_VALUE;
        Train train = null;

        for (Train t: trains){
            if( Math.abs(t.getEmptyPlaces() - places) < difference) {
                difference = Math.abs(t.getEmptyPlaces() - places);
                train = t;
            }
        }
        return train;
    }

    public static List<Train> searchByLocation(List<Train> trains, String searchedLocation){
        List<Train> checkedTrains = new ArrayList<>();
        for (Train t: trains){
            for (Station s: t.getStations()){
                if(s.getLocation().contains(searchedLocation)){
                    checkedTrains.add(t);
                    break;
                }
            }
        }
        return checkedTrains;
    }

    private static boolean checkOneTrain(Train t, String endLocation, int index){
        for (int i=index; i<t.getStations().size(); i++){
            if (t.getStations().get(i).getLocation().equals(endLocation))
                return true;
        }
        return false;
    }


}
