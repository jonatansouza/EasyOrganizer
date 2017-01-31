/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EasyOrganizer.model;

import java.util.Date;

/**
 * Modelo para os compromissos, esses modelos serao salvos no sqlite
 * @author Ana Paula
 */
public class EasyOrganizerModel {
    private int id;
    private String title;
    private String subject;
    private String description;
    private Date date;

    public EasyOrganizerModel(int id, String title, String subject, String description, Date date) {
        this.id = id;
        this.title = title;
        this.subject = subject;
        this.description = description;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "EasyOrganizerModel{" + "id=" + id + ", title=" + title + ", subject=" + subject + ", description=" + description + ", date=" + date + '}';
    }
   
    
}
