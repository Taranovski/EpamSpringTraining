/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.epam.spring.core.loggers;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.io.FileUtils;
import ua.epam.spring.core.beans.Event;

public class FileEventLogger implements EventLogger {

    private final String fileName;
    protected File file;

    public void init() {
        file = new File(fileName);
        if (!file.canWrite()) {
            throw new RuntimeException("cannot write to file " + fileName);
        }
    }

    public FileEventLogger(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void logEvent(Event event) {
        try {
            FileUtils.writeStringToFile(file, event.toString() + "\n", true);
        } catch (IOException ex) {
            Logger.getLogger(FileEventLogger.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String getFileName() {
        return fileName;
    }

}
