package SolidLib.appenders;

import SolidLib.LogFile;
import SolidLib.appenders.AppenderImpl;
import SolidLib.enums.ReportLevel;
import SolidLib.interfaces.File;
import SolidLib.interfaces.Layout;

import java.io.FileNotFoundException;

public class FileAppender extends AppenderImpl {
    private File file;

    public FileAppender(Layout layout) throws FileNotFoundException {
        super(layout);
        this.file = new LogFile();
    }

    public FileAppender(Layout layout, ReportLevel level) throws FileNotFoundException {
        super(layout, level);
        this.file = new LogFile();
    }

    @Override
    public void append(String date, ReportLevel reportLevel, String message) {
        if (super.isAppendable(reportLevel)) {
            this.file.write(super.getLayout().format(date, reportLevel, message));
            super.increaseAllMessages();
        }
    }

    @Override
    public String toString() {
        return String.format("%s, File size: %d", super.toString(), this.file.getSize());
    }
}