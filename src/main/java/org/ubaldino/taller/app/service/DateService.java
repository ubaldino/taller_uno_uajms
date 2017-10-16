package org.ubaldino.taller.app.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.stereotype.Service;

/**
 *
 * @author ubaldino
 */
@Service
public class DateService {
    public Date formatDate(String userInput) {
        Date date;
        try{
            date=new SimpleDateFormat("yyyy-MMMM-dd").parse(userInput);
        }catch (ParseException e){
            date=new Date();
        }
        return date;
    }
    public String getCurrentDate(){
        return (String)new SimpleDateFormat("dd/MMMM/yyyy").format(new Date());
    }
    
}
