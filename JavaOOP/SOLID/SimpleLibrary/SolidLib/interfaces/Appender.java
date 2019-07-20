package SolidLib.interfaces;

import SolidLib.enums.ReportLevel;

public interface Appender {
    void append(String date, ReportLevel reportLevel, String message);
    void setReportLevel(ReportLevel reportLevel);
    int getAllMessages();
    void increaseAllMessages();
}