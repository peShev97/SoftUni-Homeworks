package SolidLib.appenders;

import SolidLib.appenders.AppenderImpl;
import SolidLib.enums.ReportLevel;
import SolidLib.interfaces.Layout;

public class ConsoleAppender extends AppenderImpl {
    public ConsoleAppender(Layout layout) {
        super(layout);
    }

    public ConsoleAppender(Layout layout, ReportLevel level) {
        super(layout, level);
    }

    @Override
    public void append(String date, ReportLevel reportLevel, String message) {
        if (super.isAppendable(reportLevel)) {
            System.out.println(super.getLayout().format(date, reportLevel, message));
            super.increaseAllMessages();
        }
    }
}