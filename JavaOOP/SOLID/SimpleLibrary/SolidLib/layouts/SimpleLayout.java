package SolidLib.layouts;

import SolidLib.enums.ReportLevel;
import SolidLib.interfaces.Layout;

public class SimpleLayout implements Layout {

    @Override
    public String format(String date, ReportLevel reportLevel, String message) {
        return String.format("%s - %s - %s", date, reportLevel.name(), message);
    }
}