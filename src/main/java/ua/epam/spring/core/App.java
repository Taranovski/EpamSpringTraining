/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.epam.spring.core;

import java.util.Map;
import ua.epam.spring.core.beans.Client;
import ua.epam.spring.core.loggers.EventLogger;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ua.epam.spring.core.beans.Event;
import ua.epam.spring.core.beans.EventType;

/**
 *
 * @author Oleksandr_Taranovsky
 */
public class App {

    private Client client;
    private EventLogger eventLogger;
    private Map<EventType, EventLogger> eventLoggers;

    public App(Client client, EventLogger eventLogger, Map<EventType, EventLogger> eventLoggers) {
        this.client = client;
        this.eventLogger = eventLogger;
        this.eventLoggers = eventLoggers;
    }

    public App() {
    }

    public void logEvent(Event message, EventType eventType) {
        EventLogger logger = eventLoggers.get(eventType);
        if (logger != null) {
            logger.logEvent(message);
        } else {
            eventLogger.logEvent(message);
        }
    }

    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        App app = applicationContext.getBean(App.class);
        for (int i = 0; i < 30; i++) {
            Event event = applicationContext.getBean(Event.class);
            app.logEvent(event, EventType.ERROR);
        }

        applicationContext.close();

    }
}
