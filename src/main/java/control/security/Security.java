package control.security;

import control.Risk;
import control.Trend;

public interface Security extends Comparable<Security> {
    int getPrice();
    Risk getRisk();
    Trend getTrend();
}
