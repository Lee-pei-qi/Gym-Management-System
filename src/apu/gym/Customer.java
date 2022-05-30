/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apu.gym;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Acer
 */
public class Customer extends User {
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
    
    static Customer customer = new Customer();
    
    public Customer(){
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
    
    public Customer(String gender, String dob, String IC, String email, String phone, String street, String city, String postcode, String state, String country){
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
    
    @Override
    public String toString(){
        return user.getUsername() + ";" + user.getName() + ";" + gender + ";" + dob + ";" + IC + ";" + email + ";" + 
                phone + ";" + street + ";" + city + ";" + postcode + ";" + state + ";" + country;
    }
    
    public String customerdetails(){
        return gender + ";" + dob + ";" + IC + ";" + email + ";" + phone + ";" + street + ";" + city + ";" + postcode + ";" + state + ";" + country;
    }
    
    public boolean getCustomer(String customerusername){
        // check if Customer is found
        boolean flag = false;
        
        try{            
            File f = new File("Customer.txt");
            f.mkdirs();
            
            // open scanner
            Scanner s = new Scanner(f).useDelimiter("[;\n]");

            //check for data in Customer.txt
            while (s.hasNext()){
                //check for another data
                String thisline = s.nextLine();
                //split the data
                String[] data = thisline.split(";");

                if(data[0].equals(customerusername)){
                    customer.setName(data[1]);
                    customer.setGender(data[2]);
                    customer.setIC(data[4]);
                    customer.setEmail(data[5]);
                    customer.setPhone(data[6]);
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
        // check if Customer is found
        boolean flag = false;
        
        try{            
            File f = new File("Customer.txt");
            f.mkdirs();
            
            // open scanner
            Scanner s = new Scanner(f).useDelimiter("[;\n]");

            //check for data in Customer.txt
            while (s.hasNext()){
                //check for another data
                String thisline = s.nextLine();
                //split the data
                String[] data = thisline.split(";");
                
                if(data[0].equals(user.getUsername())){
                    customer.setGender(data[2]);
                    customer.setDOB(data[3]);
                    customer.setIC(data[4]);
                    customer.setEmail(data[5]);
                    customer.setPhone(data[6]);
                    customer.setStreet(data[7]);
                    customer.setCity(data[8]);
                    customer.setPostcode(data[9]);
                    customer.setState(data[10]);
                    customer.setCountry(data[11]);
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
    
    public String getTrainingSession(){
        Session session = new Session();
        return session.getCustomerSession(user.getUsername());
    }
    
    public String searchSession(String date){
        Session session = new Session();
        return session.getCustomerSession(user.getUsername(), date);
    }
    
    public boolean viewFeedback(){
        return new Feedback().viewFeedback();
    }
}
