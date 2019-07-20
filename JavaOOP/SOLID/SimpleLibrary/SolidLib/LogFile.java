package SolidLib;

import SolidLib.enums.ReportLevel;
import SolidLib.interfaces.File;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

public class LogFile implements File {
    private int size;
    private PrintWriter writer;

    public LogFile() throws FileNotFoundException {
        this.createWriter();
    }

    @Override
    public void write(String wholeMessage) {
        StringBuilder toBeWritten = new StringBuilder(wholeMessage);

        increaseSize(toBeWritten.toString());

        this.writer.println(toBeWritten.toString());
    }

    private void increaseSize(String message) {
        for (int i = 0; i < message.length(); i++) {
            if (Character.isAlphabetic(message.charAt(i))) {
                this.size += message.charAt(i);
            }
        }
    }

    @Override
    public int getSize() {
        return this.size;
    }

    private void createWriter() throws FileNotFoundException {
        this.writer = new PrintWriter(new FileOutputStream("C:\\Users\\peShev\\Desktop\\OutputFile.txt"), true);
    }
}