/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apu.gym;

import static apu.gym.User.user;
import java.io.*;
import java.util.*;
import javax.swing.*;

/**
 *
 * @author Acer
 */
public class Trainer extends User{
    private String gender;
    private String dob;
    private String IC;
    private String email;
    private String phone;
    private String street;
    private String city;
    private String postcode;
    private String state;
    private String country;
    
    static Trainer trainer = new Trainer();
    
    public Trainer(){
        gender = "";
        dob = "";
        IC = "";
        email = "";
        phone = "";
        street = "";
        city = "";
        postcode = "";
        state = "";
        country = "";
    }
    
    public Trainer(String gender, String dob, String IC, String email, String phone, String street, String city, String postcode, String state, String country){
        this.gender = gender;
        this.dob = dob;
        this.IC = IC;
        this.email = email;
        this.phone = phone;
        this.street = street;
        this.city = city;
        this.postcode = postcode;
        this.state = state;
        this.country = country;
    }
    
    public String getGender(){
        return gender;
    }
    
    public String getDOB(){
        return dob;
    }
    
    public String getIC(){
        return IC;
    }
    
    public String getEmail(){
        return email;
    }
    
    public String getPhone(){
        return phone;
    }
    
    public String getStreet(){
        return street;
    }
    
    public String getCity(){
        return city;
    }
    
    public String getPostcode(){
        return postcode;
    }
    
    public String getState(){
        return state;
    }
    
    public String getCountry(){
        return country;
    }
    
    public void setGender(String gender){
        this.gender = gender;
    }
    
    public void setDOB(String dob){
        this.dob = dob;
    }
    
    public void setIC(String IC){
        this.IC = IC;
    }
    
    public void setEmail(String email){
        this.email = email;
    }
    
    public void setPhone(String phone){
        this.phone = phone;
    }
    
    public void setStreet(String street){
        this.street = street;
    }
    
    public void setCity(String city){
        this.city = city;
    }
    
    public void setPostcode(String postcode){
        this.postcode = postcode;
    }
    
    public void setState(String state){
        this.state = state;
    }
    
    public void setCountry(String country){
        this.country = country;
    }
    
    public String toString(){
        return user.getUsername() + ";" + user.getName() + ";" + gender + ";" + dob + ";" + IC + ";" + email + ";" + phone + ";" + street + ";" + city + ";" + postcode + ";" + state + ";" + country;
    }
    
    public String trainerdetails(){
        return gender + ";" + dob + ";" + IC + ";" + email + ";" + phone + ";" + street + ";" + city + ";" + postcode + ";" + state + ";" + country;
    }
    
    public boolean getTrainer(String trainerusername){
        // check if user is found
        boolean flag = false;
        
        try{            
            File f = new File("Trainer.txt");
            f.mkdirs();
            
            // open scanner
            Scanner s = new Scanner(f).useDelimiter("[;\n]");

            //check for data in user.txt
            while (s.hasNext()){
                //check for another data
                String thisline = s.nextLine();
                //split the data
                String[] data = thisline.split(";");

                if(data[0].equals(trainerusername)){
                    trainer.setName(data[1]);
                    trainer.setGender(data[2]);
                    trainer.setIC(data[4]);
                    trainer.setEmail(data[5]);
                    trainer.setPhone(data[6]);
                    flag = true;
                    break;
                } 
            }
            // close scanner
            s.close();
            
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(new JFrame(), ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        
        return flag;
    }
    
    public boolean getDetails(){
        // check if user is found
        boolean flag = false;
        
        try{            
            File f = new File("Trainer.txt");
            f.mkdirs();
            
            // open scanner
            Scanner s = new Scanner(f).useDelimiter("[;\n]");

            //check for data in user.txt
            while (s.hasNext()){
                //check for another data
                String thisline = s.nextLine();
                //split the data
                String[] data = thisline.split(";");
                
                if(data[0].equals(user.getUsername())){
                    trainer.setGender(data[2]);
                    trainer.setDOB(data[3]);
                    trainer.setIC(data[4]);
                    trainer.setEmail(data[5]);
                    trainer.setPhone(data[6]);
                    trainer.setStreet(data[7]);
                    trainer.setCity(data[8]);
                    trainer.setPostcode(data[9]);
                    trainer.setState(data[10]);
                    trainer.setCountry(data[11]);
                    flag = true;
                    break;
                } 
                
            }
            // close scanner
            s.close();
            
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(new JFrame(), ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        
        return flag;
    }
    
    
    public String getTrainingSession(String date){
        Session session = new Session();
        return session.getTrainerSession(date, user.getUsername());
    }
    
    public int collectPayment(String date, String time){
        Payment payment = new Payment();
        return payment.collectPayment(date, time, user.getUsername());
    }
    
    public int provideFeedback(String feedbackDate,String sessionDate,String sessionTime,String customerUsername){
        Feedback feedback = new Feedback(feedbackDate,sessionDate,sessionTime,customerUsername,user.getUsername());
        return feedback.provideFeedback();
    }
    
}
