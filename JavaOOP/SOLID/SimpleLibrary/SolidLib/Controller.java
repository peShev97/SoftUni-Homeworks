package SolidLib;

import SolidLib.appenders.ConsoleAppender;
import SolidLib.appenders.FileAppender;
import SolidLib.enums.ReportLevel;
import SolidLib.interfaces.Appender;
import SolidLib.interfaces.Layout;
import SolidLib.interfaces.Logger;
import SolidLib.layouts.SimpleLayout;
import SolidLib.layouts.XmlLayout;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Controller {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int linesForAppeneders = Integer.parseInt(reader.readLine());

        Appender[] appenders = new Appender[linesForAppeneders];

        for (int i = 0; i < linesForAppeneders; i++) {
            String[] appenderInfo = reader.readLine().split("\\s+");
            String type = appenderInfo[0];
            String layout = appenderInfo[1];

            Layout layout1 = null;

            switch (layout) {
                case "SimpleLayout":
                    layout1 = new SimpleLayout();
                    break;
                case "XmlLayout":
                    layout1 = new XmlLayout();
                    break;
            }

            Appender appender = null;

            switch (type) {
                case "ConsoleAppender":
                    if (appenderInfo.length == 3) {
                        appender = new ConsoleAppender(layout1, ReportLevel.valueOf(appenderInfo[2]));
                    } else {
                        appender = new ConsoleAppender(layout1);
                    }
                    break;
                case "FileAppender":
                    if (appenderInfo.length == 3) {
                        appender = new FileAppender(layout1, ReportLevel.valueOf(appenderInfo[2]));
                    } else {
                        appender = new FileAppender(layout1);
                    }
                    break;
            }

            appenders[i] = appender;
        }

        Logger logger = new MessageLogger(appenders);

        String command = "";

        while (!"END".equals(command=reader.readLine())) {
            String[] commandInfo = command.split("\\|");
            String reportLevel = commandInfo[0];
            String date = commandInfo[1];
            String message = commandInfo[2];

            switch (reportLevel) {
                case "INFO":
                    logger.logInfo(date, message);
                    break;
                case "WARNING":
                    logger.logWarning(date, message);
                    break;
                case "ERROR":
                    logger.logError(date, message);
                    break;
                case "CRITICAL":
                    logger.logCritical(date, message);
                    break;
                case "FATAL":
                    logger.logFatal(date, message);
                    break;
            }
        }

        System.out.println("Logger info");

        for (Appender appender : logger.getAppenders()) {
            System.out.println(appender.toString());
        }
    }
}