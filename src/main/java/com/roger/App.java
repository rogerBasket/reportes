package com.roger;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

import com.roger.model.Persona;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main(String args[])
    {
    	String rutaJasper = "/home/roger/reportes/report1.jasper";
        ArrayList<Persona> listaPersonas = new ArrayList<Persona>();
        
        for(int i = 0; i < 20; i++)
        	listaPersonas.add(new Persona("nom"+i,"app"+i));
        
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(listaPersonas);
        Map<String, Object> param = new HashMap<String, Object>();
        
        try {
        	String fileName = JasperFillManager.fillReportToFile(rutaJasper,
        			param,dataSource);
        	
        	if(fileName != null)
        		JasperExportManager.exportReportToPdfFile(fileName,"/home/roger/reportes/report1.pdf");
        } catch(Exception jre) {
        	jre.printStackTrace();
        }
    }
}
