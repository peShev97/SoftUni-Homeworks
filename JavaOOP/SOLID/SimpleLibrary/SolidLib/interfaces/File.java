package SolidLib.interfaces;

import SolidLib.enums.ReportLevel;

public interface File {
    void write(String wholeMessage);
    int getSize();
}