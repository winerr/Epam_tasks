package control;

import control.security.Security;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SecurityService {
    public static List<Security> findByPrice(List<Security> securities, int targetPrice){
        List<Security> targetSecurities = new ArrayList<>();
        for (Security security: securities){
            if(security.getPrice() == targetPrice)
                targetSecurities.add(security);
        }
        Collections.sort(targetSecurities);
        return targetSecurities;
    }

    public static List<Security> findByRisk(List<Security> securities, Risk targetRisk){
        List<Security> targetSecurities = new ArrayList<>();
        for (Security security: securities){
            if(security.getRisk() == targetRisk)
                targetSecurities.add(security);
        }
        Collections.sort(targetSecurities);
        return targetSecurities;
    }

    public static List<Security> findByTrend(List<Security> securities, Trend targetTrend){
        List<Security> targetSecurities = new ArrayList<>();
        for (Security security: securities){
            if(security.getTrend() == targetTrend)
                targetSecurities.add(security);
        }
        Collections.sort(targetSecurities);
        return targetSecurities;
    }
}
