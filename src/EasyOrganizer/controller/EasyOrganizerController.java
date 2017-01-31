/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package EasyOrganizer.controller;

import EasyOrganizer.db.DBHandler;
import EasyOrganizer.model.EasyOrganizerModel;
import EasyOrganizer.util.SortByDate;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

/**
 *Controlador que intermedia as requisições da interface grafica e a persistencia no banco de dados
 * @author Ana Paula
 */
public class EasyOrganizerController {
    private DBHandler dBHandler;
    public EasyOrganizerController() {
        this.dBHandler = new DBHandler();
    }
    /**
     * Lista por assunto
     * @param subject
     * @return uma lista de EasyOrganizerModel correspondentes ao assunto passado como parametro
     */
    public List<EasyOrganizerModel> listBySubject(String subject){
        List<EasyOrganizerModel> eoms = new ArrayList<>();
        for(EasyOrganizerModel eom : dBHandler.selectAll()){
            if(eom.getSubject().contains(subject)){
                eoms.add(eom);
            }
        }
        
        Collections.sort(eoms, new SortByDate());
        return eoms;
    }
    /**
     * Lista todos os compromissos que corresponde a data por parametro
     * @param date
     * @return uma lista de EasyOrganizerModel correspondentes a data passado como parametro
     */
    public List<EasyOrganizerModel> listByDate(Date date){
        List<EasyOrganizerModel> eoms = new ArrayList<>();
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        for(EasyOrganizerModel eom : dBHandler.selectAll()){
            if(df.format(eom.getDate()).equals(df.format(date))){
                eoms.add(eom);
            }
        }
        Collections.sort(eoms, new SortByDate());
        return eoms;
    }
    /**
     * Lista de acordo com o intervalo de datas passado por parametro
     * @param dateStart
     * @param dateEnd
     * @return uma lista de EasyOrganizerModel correspondentes ao intervalo passado como parametro
     */
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
        Collections.sort(eoms, new SortByDate());
        return eoms;
    }
    /**
     * lista todos
     * @return lista com todos EasyOrganizerModel
     */
    public List<EasyOrganizerModel> listAll(){
        ArrayList<EasyOrganizerModel> eoms = (ArrayList<EasyOrganizerModel>) dBHandler.selectAll();
        Collections.sort(eoms, new SortByDate());
        return eoms;
    }
    /**
     * procura pelo id
     * @param id
     * @return um EasyOrganizerModel correspondente ao id passado
     */
    public EasyOrganizerModel listById(int id){
        return dBHandler.selectById(id);
    }
    /**
     * metodo reponsavel por inserir
     * @param title
     * @param subject
     * @param description
     * @param date
     * @return
     */
    public boolean insertModel(String title, String subject, String description, Date date){
        EasyOrganizerModel eom = new EasyOrganizerModel(0, title, subject, description, date);
        return dBHandler.insert(eom);
    }
    /**
     * responsavel por deletar
     * @param id
     * @return
     */
    public boolean deleteModel(int id){
        return dBHandler.delete(id);
    }
}
