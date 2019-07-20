package SolidLib.layouts;

import SolidLib.enums.ReportLevel;
import SolidLib.interfaces.Layout;

public class XmlLayout implements Layout {

    @Override
    public String format(String date, ReportLevel reportLevel, String message) {
        StringBuilder output = new StringBuilder("<log>");

        String spaces = "    ";

        output.append(System.lineSeparator())
                .append(spaces)
                .append(String.format("<date>%s</date>", date))
                .append(System.lineSeparator())
                .append(spaces)
                .append(String.format("<level>%s</level>", reportLevel))
                .append(System.lineSeparator())
                .append(spaces)
                .append(String.format("<message>%s</message>", message))
                .append(System.lineSeparator())
                .append("</log>");

        return output.toString();
    }
}