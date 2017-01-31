/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package EasyOrganizer.util;

import EasyOrganizer.model.EasyOrganizerModel;
import java.util.Comparator;

/**
 * responsavel por organizar a lista com as datas
 * @author Ana Paula
 */
public class SortByDate implements Comparator<EasyOrganizerModel>{
    
    @Override
    public int compare(EasyOrganizerModel o1, EasyOrganizerModel o2) {
        if(o1.getDate().getTime() < o2.getDate().getTime()){
            return -1;
        }else if(o1.getDate().getTime() == o2.getDate().getTime()){
            return 0;
        }
        return 1;
    }
    
}
