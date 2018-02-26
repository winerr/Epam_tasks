package control;

import control.security.Bond;
import control.security.Security;
import control.security.Share;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Security> securities = new ArrayList<>();

        securities.add(new Share(123, "first share", 1234, Risk.MEDIUM, Trend.DESCENDING));
        securities.add(new Share(124, "second share", 534, Risk.LOW, Trend.GROWING));
        securities.add(new Share(125, "third share", 54, Risk.HIGH, Trend.DESCENDING));
        securities.add(new Share(126, "fourth share", 234, Risk.VERY_HIGH, Trend.GROWING));

        securities.add(new Bond(234, "first bond", 1234, Risk.VERY_HIGH, Trend.GROWING));
        securities.add(new Bond(235, "second bond", 534, Risk.HIGH, Trend.DESCENDING));
        securities.add(new Bond(236, "third bond", 54, Risk.LOW, Trend.GROWING));
        securities.add(new Bond(237, "fourth bond", 234, Risk.MEDIUM, Trend.DESCENDING));

        securities.forEach(System.out::println);
        System.out.println();

        SecurityService.findByPrice(securities, 534).forEach(System.out::println);
        System.out.println();
        SecurityService.findByRisk(securities, Risk.VERY_HIGH).forEach(System.out::println);
        System.out.println();
        SecurityService.findByTrend(securities, Trend.DESCENDING).forEach(System.out::println);
    }
}
