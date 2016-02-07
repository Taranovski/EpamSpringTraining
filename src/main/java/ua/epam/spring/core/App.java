/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.epam.spring.core;

import ua.epam.spring.core.loggers.ConsoleEventLogger;
import ua.epam.spring.core.beans.Client;
import ua.epam.spring.core.loggers.EventLogger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ua.epam.spring.core.beans.Event;

/**
 *
 * @author Oleksandr_Taranovsky
 */
public class App {
    private Client client;
    private EventLogger eventLogger;

    public App(Client client, EventLogger eventLogger) {
        this.client = client;
        this.eventLogger = eventLogger;
    }

    public App() {
    }
    
    public void logEvent(Event message){
        eventLogger.logEvent(message);        
    }
    
    public static void main(String[] args) {
//        Client client1 = new Client("1", "Alex");
//        EventLogger consoleEventLogger = new ConsoleEventLogger();
        
        
        
        
//        App app = new App(client1, consoleEventLogger);
        
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        
        App app = applicationContext.getBean(App.class);
        
        Event event = applicationContext.getBean(Event.class);
        
        
        app.logEvent(event);
    }
}
