package lecture3;

import lombok.experimental.var;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {

    private static final String []citys = {"Lvov", "Kiev", "Odessa", "Poltana", "Kharkiv", "Korosten", "Ivano-Frankivsk", "Chernivtsi", "Dnipro"};

    public static void main(String[] args) {
        List<Train> trains = getList();

        trains.forEach(System.out::println);
        System.out.println("----------------------------------");
        TrainServices.getTrainFromTo(trains, citys[2], citys[1]).forEach(System.out::println);

        System.out.println("----------------------------------");
        TrainServices.getTrainFromStartTime(trains, LocalTime.parse("09:21")).forEach(System.out::println);

        System.out.println("----------------------------------");
        System.out.println(TrainServices.searchByPlaces(trains, 100));

        System.out.println("----------------------------------");
        TrainServices.searchByLocation(trains, "an").forEach(System.out::println);

        System.out.println("----------------------------------");
        TrainServices.getTrainFromDate(trains, LocalDate.parse("2017-12-30")).forEach(System.out::println);

    }


    private static List<Train> getList(){
        Random r = new Random();

        List<Train> trains = new ArrayList<>();
        List<Station> stations = new ArrayList<>();

        stations.add(new Station(citys[4], LocalTime.parse("05:32")));
        stations.add(new Station(citys[3], LocalTime.parse("06:21"), LocalTime.parse("06:46")));
        stations.add(new Station(citys[2], LocalTime.parse("07:43"), LocalTime.parse("08:13")));
        stations.add(new Station(citys[1], LocalTime.parse("08:54")));
        trains.add(new Train(r.nextInt(255), stations, 56, Periodicity.EVEN_DAY));
        stations = new ArrayList<>();

        stations.add(new Station(citys[8], LocalTime.parse("08:32")));
        stations.add(new Station(citys[7], LocalTime.parse("09:21"), LocalTime.parse("09:46")));
        stations.add(new Station(citys[6], LocalTime.parse("13:43"), LocalTime.parse("14:13")));
        stations.add(new Station(citys[5], LocalTime.parse("22:54")));
        trains.add(new Train(r.nextInt(255), stations, 21, Periodicity.ODD_DAY));
        stations = new ArrayList<>();

        stations.add(new Station(citys[5], LocalTime.parse("15:32")));
        stations.add(new Station(citys[8], LocalTime.parse("19:21"), LocalTime.parse("19:46")));
        stations.add(new Station(citys[1], LocalTime.parse("21:43"), LocalTime.parse("21:53")));
        stations.add(new Station(citys[3], LocalTime.parse("02:54")));
        trains.add(new Train(r.nextInt(255), stations, 123, Periodicity.EVERY_DAY));
        stations = new ArrayList<>();

        stations.add(new Station(citys[0], LocalTime.parse("02:32")));
        stations.add(new Station(citys[2], LocalTime.parse("09:21"), LocalTime.parse("09:46")));
        stations.add(new Station(citys[1], LocalTime.parse("20:13"), LocalTime.parse("20:16")));
        stations.add(new Station(citys[7], LocalTime.parse("22:54")));
        trains.add(new Train(r.nextInt(255), stations, 87, Periodicity.EVERY_THIRD_DAY));

        return trains;
    }

}
