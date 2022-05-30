/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apu.gym;

import java.io.*;
import static java.lang.Double.parseDouble;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.swing.*;

/**
 *
 * @author Acer
 */
public class Payment {
    //private int ID;
    private String paymentDate;
    private String paymentType;
    private double amount;
    private String sessionDate;
    private String sessionTime;
    private String customerUsername;
    private String trainerUsername;
    private String collectedDate;
    private String status;
    
    static Payment payment = new Payment();
    
    public Payment(){
        //ID = 0;
        paymentDate = "";
        paymentType = "";
        amount = 0.0;
        sessionDate =  "";
        sessionTime =  "";
        customerUsername =  "";
        trainerUsername =  "";
        collectedDate =  "";    
        status = "";
    }
    
    public String getPaymentDate(){
        return paymentDate;
    }
    
    public String getPaymentType(){
        return paymentType;
    }
    
    public double getAmount(){
        return amount;
    }
    
    public String getSessionDate(){
        return sessionDate;
    }
    
    public String getSessionTime(){
        return sessionTime;
    }
    
    public String getCustomerUsername(){
        return customerUsername;
    }
    
    public String getTrainerUsername(){
        return trainerUsername;
    }
    
    public String getCollectedDate(){
        return collectedDate;
    }
    
    public String getStatus(){
        return status;
    }
    
    public void setPaymentDate(String paymentDate){
        this.paymentDate = paymentDate;
    }
    
    public void setPaymentType(String paymentType){
        this.paymentType = paymentType;
    }
    
    public void setAmount(double amount){
        this.amount = amount;
    }
    
    public void setSessionDate(String sessionDate){
        this.sessionDate = sessionDate;
    }
    
    public void setSessionTime(String sessionTime){
        this.sessionTime = sessionTime;
    }
    
    public void setCustomerUsername(String customerUsername){
        this.customerUsername = customerUsername;
    }
    
    public void setTrainerUsername(String trainerUsername){
        this.trainerUsername = trainerUsername;
    }
    
    public void setCollectedDate(String collectedDate){
        this.collectedDate = collectedDate;
    }
    
    public void setStatus(String status){
        this.status = status;
    }
    
    public String toString(){
        return paymentDate + ";" + paymentType + ";" + amount + ";" + sessionDate + ";" + sessionTime + ";" + customerUsername + ";" + trainerUsername + ";" + collectedDate + ";" + status; 
    }
    
    public int collectPayment(String sessionDate, String sessionTime, String trainerUsername){
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        int flag = 0;  // 0=not found, 1=found, -1=collected
        String filePath = "Payment.txt";
        
        try{            
            File f = new File(filePath);
            f.mkdirs();
            
            // open scanner
            Scanner s = new Scanner(f).useDelimiter("[;\n]");
            
            //check for data in user.txt
            while (s.hasNext()){
                //check for another data
                String thisline = s.nextLine();
                //split the data
                String[] data = thisline.split(";");
                

                if(data[3].equals(sessionDate) && data[4].equals(sessionTime) && data[6].equals(trainerUsername)){
                    
                    // check if payment is collected
                    if (data[8].equals("Collected")){
                        flag = -1;
                    } else {
                        paymentDate = data[0];
                        paymentType = data[1];
                        amount = parseDouble(data[2]);
                        this.sessionDate =  sessionDate;
                        this.sessionTime =  sessionTime;
                        customerUsername =  data[5];
                        this.trainerUsername =  trainerUsername;

                        // update status to 'Collected' & collectedDate
                        collectedDate = sdf.format(new Date()) ;    
                        status = "Collected";

                        // update the updated record to txtfile
                        WriteFile wf = new WriteFile(filePath);
                        wf.updateRowByLine(thisline, this.toString());

                        flag = 1;
                    }
                    
                } 
            }
            // close scanner
            s.close();

        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(new JFrame(), ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(new JFrame(), ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        
        return flag;
    }
    
    public String getPayment(String trainerUsername){
        // check if record is found
        boolean flag = false;
        String payment = "";
        
        try{            
            File f = new File("Payment.txt");
            f.mkdirs();
            
            Scanner s = new Scanner(f).useDelimiter("[;\n]");  // open scanner
            
            //check for data in payment.txt
            while (s.hasNext()){
                String thisline = s.nextLine();
                String[] data = thisline.split(";");
                
                if(data[6].equals(trainerUsername)){
                    // if it is the first matched record
                    if (!flag){
                        payment += thisline;
                    } else {
                        payment += "\n" + thisline;
                    }                   
                    flag = true;
                } 
            }
            s.close();  // close scanner

        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(new JFrame(), ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

        return payment;
    }
    
    public String getPayment(String trainerUsername, String date){
        // check if record is found
        boolean flag = false;
        String payment = "";
        
        try{            
            File f = new File("Payment.txt");
            f.mkdirs();
            
            Scanner s = new Scanner(f).useDelimiter("[;\n]");  // open scanner
            
            //check for data in payment.txt
            while (s.hasNext()){
                String thisline = s.nextLine();
                String[] data = thisline.split(";");
                
                if(data[3].equals(date) && data[6].equals(trainerUsername)){
                    // if it is the first matched record
                    if (!flag){
                        payment += thisline;
                    } else {
                        payment += "\n" + thisline;
                    }                   
                    flag = true;
                } 
            }
            s.close();  // close scanner

        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(new JFrame(), ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

        return payment;
    }
}
