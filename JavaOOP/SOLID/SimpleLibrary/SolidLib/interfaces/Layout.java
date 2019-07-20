package SolidLib.interfaces;

import SolidLib.enums.ReportLevel;

public interface Layout {
    String format(String date, ReportLevel reportLevel, String message);
}