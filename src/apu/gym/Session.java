/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apu.gym;

import java.io.*;
import java.util.Scanner;
import javax.swing.*;

/**
 *
 * @author Acer
 */
public class Session {
    private String date;
    private String startTime;
    private String endTime;
    private String duration;
    private String venue;
    private String level;
    private String customerUsername;
    private String customerName;
    private String trainerUsername;
    private String trainerName;
    
    static Session session = new Session();
    
    public Session(){
        date = "";
        startTime = "";
        endTime = "";
        duration = "";
        venue = "";
        level = "";
        customerUsername = "";
        customerName = "";
        trainerUsername = "";
        trainerName = "";
    }
    
    public String getDate(){
        return date;
    }
    
    public String getStartTime(){
        return startTime;
    }
    
    public String getEndTime(){
        return endTime;
    }
    
    public String getDuration(){
        return duration;
    }
    
    public String getVenue(){
        return venue;
    }
    
    public String getLevel(){
        return level;
    }
    
    public String getCustomerUsername(){
        return customerUsername;
    }
    
    public String getCustomerName(){
        return customerName;
    }
    
    public String getTrainerUsername(){
        return trainerUsername;
    }
    
    public String getTrainerName(){
        return trainerName;
    }
    
    public void setDate(String date){
        this.date = date;
    }
    
    public void setStartTime(String startTime){
        this.startTime = startTime;
    }
    
    public void setEndTime(String endTime){
        this.endTime = endTime;
    }
    
    public void setDuration(String duration ){
        this.duration = duration;
    }
    
    public void setVenue(String venue){
        this.venue = venue;
    }
    
    public void setLevel(String level){
        this.level = level;
    }
    
    public void setCustomerUsername(String customerUsername){
        this.customerUsername = customerUsername;
    }
    
    public void setCustomerName(String customerName){
        this.customerName = customerName;
    }
    
    public void setTrainerUsername(String trainerUsername){
        this.trainerUsername = trainerUsername;
    }
    
    public void setTrainerName(String trainerName){
        this.trainerName = trainerName;
    }
    
    public String toString(){
        return date + ";" + startTime + ";" + endTime + ";" + duration + ";" + venue + ";" + level + ";" + customerUsername + ";" + customerName + ";" + trainerUsername + ";" + trainerName;
    }    
    
    public boolean getAllSession(){
        // check if session is found
        boolean flag = false;
        
        try{            
            File f = new File("Session.txt");
            f.mkdirs();
            
            // open scanner
            Scanner s = new Scanner(f).useDelimiter("[;\n]");
            
            //check for data in session.txt
            while (s.hasNext()){
                //check for another data
                String thisline = s.nextLine();
                //split the data
                String[] data = thisline.split(";");
                
                session.setDate(data[0]);
                session.setStartTime(data[1]);
                session.setEndTime(data[2]);
                session.setVenue(data[4]);
                session.setCustomerName(data[7]);
                session.setTrainerName(data[9]);
                        
                flag = true;
            } 
            // close scanner
            s.close();

        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(new JFrame(), ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return flag;
    }
    
    public String getTrainerSession(String trainerID){
        // check if session is found
        boolean flag = false;
        String session = "";
        
        try{            
            File f = new File("Session.txt");
            f.mkdirs();
            
            // open scanner
            Scanner s = new Scanner(f).useDelimiter("[;\n]");
            
            //check for data in user.txt
            while (s.hasNext()){
                //check for another data
                String thisline = s.nextLine();
                //split the data
                String[] data = thisline.split(";");
                

                if(data[8].equals(trainerID)){
                    // if it is the first matched record
                    if (!flag){
                        session += thisline;
                    } else {
                        session += "\n" + thisline;

                    }
                    
                    flag = true;
                } 
            }
            // close scanner
            s.close();

        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(new JFrame(), ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

        return session;
    }
    
    public String getTrainerSession(String date, String trainerID){
        // check if session is found
        boolean flag = false;
        String session = "";
        
        try{            
            File f = new File("Session.txt");
            f.mkdirs();
            
            // open scanner
            Scanner s = new Scanner(f).useDelimiter("[;\n]");
            
            //check for data in user.txt
            while (s.hasNext()){
                //check for another data
                String thisline = s.nextLine();
                //split the data
                String[] data = thisline.split(";");
                

                if(data[0].equals(date) && data[8].equals(trainerID)){
                    this.date = date;
                    // if it is the first matched record
                    if (!flag){
                        session += thisline;
                    } else {
                        session += "\n" + thisline;

                    }
                    
                    flag = true;
                } 
            }
            // close scanner
            s.close();

        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(new JFrame(), ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

        return session;
    }
    
    public String getCustomerSession(String customerID){
        // check if session is found
        boolean flag = false;
        String session = "";
        
        try{            
            File f = new File("Session.txt");
            f.mkdirs();
            
            Scanner s = new Scanner(f).useDelimiter("[;\n]");  // open scanner
            
            //check for data in session.txt
            while (s.hasNext()){
                String thisline = s.nextLine();
                String[] data = thisline.split(";");
                
                if(data[6].equals(customerID)){
                    // if it is the first matched record
                    if (!flag){
                        session += thisline;
                    } else {
                        session += "\n" + thisline;
                    }                   
                    flag = true;
                } 
            }
            s.close();  // close scanner

        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(new JFrame(), ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

        return session;
    }
    
    public String getCustomerSession(String customerID, String date){
        // check if session is found
        boolean flag = false;
        String session = "";
        
        try{            
            File f = new File("Session.txt");
            f.mkdirs();
            
            Scanner s = new Scanner(f).useDelimiter("[;\n]");  // open scanner
            
            //check for data in session.txt
            while (s.hasNext()){
                String thisline = s.nextLine();
                String[] data = thisline.split(";");

                if(data[0].equals(date) && data[6].equals(customerID)){
                    // if it is the first matched record
                    if (!flag){
                        session += thisline;
                    } else {
                        session += "\n" + thisline;
                    }
                    flag = true;
                } 
            }
            s.close();  // close scanner

        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(new JFrame(), ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

        return session;
    }
    
    public String searchSession(String searchString, String searchKey){
        int index = -1;
        
        switch(searchKey){
            case "Date":
                index = 0;
                break;
            case "Customer":
                index = 6;
                break;
            case "Trainer":
                index = 8;
                break;
        }
        
        // check if session is found
        boolean flag = false;
        String session = "";
        
        if (index != -1){
            try{            
                File f = new File("Session.txt");
                f.mkdirs();

                // open scanner
                Scanner s = new Scanner(f).useDelimiter("[;\n]");

                //check for data in user.txt
                while (s.hasNext()){
                    //check for another data
                    String thisline = s.nextLine();
                    
                    if (!thisline.equals("")){
                        //split the data
                        String[] data = thisline.split(";");


                        if(data[index].equals(searchString)){
                            // if it is the first matched record
                            if (!flag){
                                session += thisline;
                            } else {
                                session += "\n" + thisline;

                            }

                            flag = true;
                        } 
                    }
                }
                // close scanner
                s.close();

            } catch (FileNotFoundException ex) {
                JOptionPane.showMessageDialog(new JFrame(), ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        
        return session;
    }
    
    public static boolean deletesession(String date, String customer, String trainer){
        try{            
            File ss = new File("Session.txt");
            ss.mkdirs();
            
            String filesession = "Session.txt";
            
            // open scanner
            Scanner s = new Scanner(ss).useDelimiter("[;\n]");
            
            //check for data in user.txt
            while (s.hasNext()){
                //check for another data
                String thisline = s.nextLine();
                //split the data
                String[] Ssrow = thisline.split(";");
                
                if (Ssrow[0].equals(date) && Ssrow[7].equals(customer) && Ssrow[9].equals(trainer)){
                    session.setDate(date);
                    session.setStartTime(Ssrow[1]);
                    session.setEndTime(Ssrow[2]);
                    session.setDuration(Ssrow[3]);
                    session.setVenue(Ssrow[4]);
                    session.setLevel(Ssrow[5]);
                    session.setCustomerUsername(Ssrow[6]);
                    session.setCustomerName(Ssrow[7]);
                    session.setTrainerUsername(Ssrow[8]);
                    session.setTrainerName(Ssrow[9]);
                } 
            }
            // close scanner
            s.close();
            
            WriteFile wft = new WriteFile(filesession);
            wft.deleteRow(session.toString());

        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(new JFrame(), ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(new JFrame(), ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        
        return true;
    }
}
