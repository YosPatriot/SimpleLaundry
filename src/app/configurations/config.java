/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.configurations;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/**
 *
 * @author AMIRULLAH
 */
public class config {
    public static Properties prop = new Properties();
    public void SaveProp(String title, String value){
        try
        {
           prop.setProperty(title, value);
           prop.store(new FileOutputStream("src/config.app"),null);
        }catch(IOException e){
        
        }
    }
     public String GetProp(String title){
         String value = "";
        try
        {
           prop.load(new FileInputStream("src/config.app"));
           value=prop.getProperty(title);
        }catch(IOException e){
        
        }
        return value;
    }
    public Double getDiskon(){
        String value = "Atur Diskon";
        double result=0;
    try
        {
           prop.load(new FileInputStream("src/config.app"));
           value=prop.getProperty(value);
           result = Double.parseDouble(value);
        }catch(IOException e){
        
        }
        return result;
    }
}
