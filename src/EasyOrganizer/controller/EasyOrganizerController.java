/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package EasyOrganizer.controller;

import EasyOrganizer.db.DBHandler;
import EasyOrganizer.model.EasyOrganizerModel;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 *
 * @author jonatan
 */
public class EasyOrganizerController {
    private DBHandler dBHandler;
    
    public EasyOrganizerController() {
        this.dBHandler = new DBHandler();
    }
    
    public List<EasyOrganizerModel> listBySubject(String subject){
        List<EasyOrganizerModel> eoms = new ArrayList<>();
        for(EasyOrganizerModel eom : dBHandler.selectAll()){
            if(eom.getSubject().contains(subject)){
                eoms.add(eom);
            }
        }
        return eoms;
    }
    
    public List<EasyOrganizerModel> listByDate(Date date){
        List<EasyOrganizerModel> eoms = new ArrayList<>();
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        for(EasyOrganizerModel eom : dBHandler.selectAll()){
            if(df.format(eom.getDate()).equals(df.format(date))){
                eoms.add(eom);
            }
        }
        return eoms;
    }
    
    public List<EasyOrganizerModel> listByDateInterval(Date dateStart, Date dateEnd){
        List<EasyOrganizerModel> eoms = new ArrayList<>();
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        //make sure day right
        dateStart.setHours(0);
        dateStart.setMinutes(0);
        dateStart.setSeconds(0);
        
        dateEnd.setHours(23);
        dateEnd.setMinutes(59);
        dateEnd.setSeconds(59);
        
        long start = dateStart.getTime();
        long end = dateEnd.getTime();
        long eomTime;
        
        for(EasyOrganizerModel eom : dBHandler.selectAll()){
            eomTime = eom.getDate().getTime();
            if(eomTime >= start && eomTime <= end){
                eoms.add(eom);
            }
        }
        return eoms;
    }
    
    public List<EasyOrganizerModel> listAll(){
        return dBHandler.selectAll();
    }
    
    public EasyOrganizerModel listById(int id){
        return dBHandler.selectById(id);
    }
    
    public boolean insertModel(String title, String subject, String description, Date date){
        EasyOrganizerModel eom = new EasyOrganizerModel(0, title, subject, description, date);
        return dBHandler.insert(eom);
    }
    public boolean deleteModel(int id){
        return dBHandler.delete(id);
    }
}
