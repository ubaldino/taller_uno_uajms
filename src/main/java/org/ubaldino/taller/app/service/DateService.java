/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ubaldino.taller.app.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author ubaldino
 */
public class DateService {
    @SuppressWarnings("UnusedAssignment")
    public String getLiteralDate(String sFecha){
        SimpleDateFormat frmtDate = new SimpleDateFormat("dd/MM/yyyy");
        Date fecha = null;
        try{
            fecha = frmtDate.parse(sFecha);
        }catch (ParseException ex){
            fecha = null;
        }
 
        if(fecha!=null){
            try{
                return SimpleDateFormat.getDateInstance(SimpleDateFormat.FULL).format(fecha);
            }catch (Exception ex){
                fecha = null;
                return "";
            }
        } else return "";
    }
}
