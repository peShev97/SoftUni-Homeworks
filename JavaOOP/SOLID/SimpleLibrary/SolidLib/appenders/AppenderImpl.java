package SolidLib.appenders;

import SolidLib.enums.ReportLevel;
import SolidLib.interfaces.Appender;
import SolidLib.interfaces.Layout;

public abstract class AppenderImpl implements Appender {
    private Layout layout;
    private ReportLevel level;
    private int allMesseges;

    protected AppenderImpl(Layout layout) {
        this.layout = layout;
        this.setReportLevel(ReportLevel.INFO);
    }

    protected AppenderImpl(Layout layout, ReportLevel level) {
        this(layout);
        this.setReportLevel(level);
    }

    protected Layout getLayout() { return this.layout; }

    @Override
    public void setReportLevel(ReportLevel reportLevel) {
        this.level = reportLevel;
    }

    protected boolean isAppendable(ReportLevel reportLevel) {
        return reportLevel.ordinal() >= this.level.ordinal();
    }

    @Override
    public int getAllMessages() {
        return this.allMesseges;
    }

    @Override
    public void increaseAllMessages() {
        this.allMesseges++;
    }

    @Override
    public String toString() {
        return String.format("Appender type: %s, Layout type: %s, Report level: %s, Messages appended: %d",
                getClass().getSimpleName(),
                this.layout.getClass().getSimpleName(),
                this.level,
                this.getAllMessages());
    }
}