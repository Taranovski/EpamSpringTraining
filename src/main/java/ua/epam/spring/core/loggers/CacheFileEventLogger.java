/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.epam.spring.core.loggers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.io.FileUtils;
import ua.epam.spring.core.beans.Event;

public class CacheFileEventLogger extends FileEventLogger {

    private final int cacheSize;
    private final List<Event> events;

    public CacheFileEventLogger(String fileName, int cacheSize) {
        super(fileName);
        this.cacheSize = cacheSize;
        events = new ArrayList<>(cacheSize);
    }

    public void destroy() {
        if (!events.isEmpty()) {
            writeEventsFromCache();
        }
    }

    @Override
    public void logEvent(Event event) {
        if (events.size() < cacheSize) {
            events.add(event);
        } else {
            writeEventsFromCache();
            events.clear();
            events.add(event);
        }
    }

    private void writeEventsFromCache() {
        StringBuilder log = new StringBuilder();

        for (Event event1 : events) {
            log.append(event1.toString());
            log.append("\n");
        }
        try {
            FileUtils.writeStringToFile(file, log.toString(), true);
        } catch (IOException ex) {
            Logger.getLogger(CacheFileEventLogger.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
