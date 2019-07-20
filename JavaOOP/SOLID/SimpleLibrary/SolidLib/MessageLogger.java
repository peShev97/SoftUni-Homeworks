package SolidLib;

import SolidLib.enums.ReportLevel;
import SolidLib.interfaces.Appender;
import SolidLib.interfaces.Logger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MessageLogger implements Logger {
    private List<Appender> appenders;

    public MessageLogger(Appender... appenders) {
        this.appenders = new ArrayList<>();
        this.appenders.addAll(Arrays.asList(appenders));
    }

    @Override
    public void logInfo(String date, String message) {
        iterAppenders(date, ReportLevel.INFO, message);
    }

    @Override
    public void logWarning(String date, String message) {
        iterAppenders(date, ReportLevel.WARNING, message);
    }

    @Override
    public void logError(String date, String message) {
        iterAppenders(date, ReportLevel.ERROR, message);
    }

    @Override
    public void logCritical(String date, String message) {
        iterAppenders(date, ReportLevel.CRITICAL, message);
    }

    @Override
    public void logFatal(String date, String message) {
        iterAppenders(date, ReportLevel.FATAL, message);
    }

    private void iterAppenders(String date, ReportLevel reportLevel, String message) {
        for (Appender appender : this.appenders) {
            appender.append(date, reportLevel, message);
        }
    }

    @Override
    public List<Appender> getAppenders() {
        return Collections.unmodifiableList(this.appenders);
    }
}