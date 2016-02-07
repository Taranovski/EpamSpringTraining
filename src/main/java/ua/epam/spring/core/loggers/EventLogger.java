/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.epam.spring.core.loggers;

import ua.epam.spring.core.beans.Event;

/**
 *
 * @author Oleksandr_Taranovsky
 */
public interface EventLogger {
    void logEvent(Event event);
}
