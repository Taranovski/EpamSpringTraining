/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.epam.spring.core.beans;

import java.text.DateFormat;
import java.util.Date;
import java.util.Random;

/**
 *
 * @author Oleksandr_Taranovsky
 */
public class Event {
    private final int id;
    private String message;
    private Date date;
    private DateFormat dateFormat;

    public Event(Date date, DateFormat dateFormat) {
        id = new Random().nextInt();
        this.date = date;
        this.dateFormat = dateFormat;
    }
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Event{" + "id=" + id + ", message=" + message + ", date=" + dateFormat.format(date) + '}';
    }
    
    
}
