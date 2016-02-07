/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.epam.spring.core.loggers;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.io.FileUtils;
import ua.epam.spring.core.beans.Event;

public class FileEventLogger implements EventLogger {

    private final String fileName;
    private final File file;

    public FileEventLogger(String fileName) throws IOException {
        this.fileName = fileName;
        Path path = Paths.get(fileName);

        if (!Files.exists(path)) {
            path = Files.createFile(path);
        }
        file = path.toFile();
    }

    @Override
    public void logEvent(Event event) {
        try {
            FileUtils.writeStringToFile(file, event.toString(), true);
        } catch (IOException ex) {
            Logger.getLogger(FileEventLogger.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String getFileName() {
        return fileName;
    }

}
