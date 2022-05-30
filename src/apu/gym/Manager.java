/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apu.gym;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import static apu.gym.Trainer.trainer;
import static apu.gym.Customer.customer;
import static apu.gym.Session.session;
import static apu.gym.Payment.payment;

/**
 *
 * @author Pekyen
 */
public class Manager extends User {
    static Manager manager = new Manager();
    
    public String searchsession(String searchString, String searchKey){
        Session session = new Session();
        return session.searchSession(searchString, searchKey);
    }
    
    public boolean searchtrainer(String trainerusername){
        Trainer trainer = new Trainer();
        return trainer.getTrainer(trainerusername);
    }
    
    public boolean searchcustomer(String customerusername){
        Customer customer = new Customer();
        return customer.getCustomer(customerusername);
    }
    
    public static boolean registertrainer(String username, String name, String email, String password, String role)throws IOException {
        File us = new File("User.txt");
        us.mkdirs();
        File tr = new File("Trainer.txt");
        tr.mkdirs();
        
        String fileuser = "User.txt";
        String filetrainer = "Trainer.txt";
        
        try {
            // read user.txt
            BufferedReader bu = new BufferedReader(new FileReader(us));
            // read trainer.txt
            BufferedReader br = new BufferedReader(new FileReader(tr));
            
            // get lines from user.txt
            Object [] Uslines = bu.lines().toArray();
            // get lines from trainer.txt
            Object [] Trlines = br.lines().toArray();
            
            // extract user data from lines
            for (int i=0; i < Uslines.length; i++){
                String Line = Uslines[i].toString().trim();
                // split the data 
                String[] Usrow = Line.split(";"); 
                
                // Check for existing username 
                if (Usrow[1].equals(username)){
                    JOptionPane.showMessageDialog(new JFrame(), "Username Already Taken." , "Data Exists", JOptionPane.ERROR_MESSAGE); 
                    return false;
                }
            }
            
            // extract trainer data from lines
            for (int i=0; i < Trlines.length; i++){
                String Line = Trlines[i].toString().trim();
                // split the data 
                String[] Trrow = Line.split(";"); 
                
                // Check for existing trainer email 
                if (Trrow[5].equals(email)){
                    JOptionPane.showMessageDialog(new JFrame(), "Trainer's Email Already Registered." , "Data Exists", JOptionPane.ERROR_MESSAGE);
                    return false;
                }
            }

            bu.close();
            br.close();
            
            // write into user.txt
            String user = name + ";" + username + ";" + password + ";" + role;
            
            WriteFile wfu = new WriteFile(fileuser,true);
            wfu.writeToFile(user); 
            
            // write into trainer.txt
            String data = username + ";" + name + ";" + trainer.trainerdetails();
            
            WriteFile wft = new WriteFile(filetrainer,true);
            wft.writeToFile(data); 
 
        } catch (Exception e) {
            JOptionPane.showMessageDialog(new JFrame(), e.getMessage() , "Error", JOptionPane.ERROR_MESSAGE);
        }
        return true;
    }
    
    public static boolean registercustomer(String username, String name, String email, String password, String role)throws IOException {
        File us = new File("User.txt");
        us.mkdirs();
        File cs = new File("Customer.txt");
        cs.mkdirs();
        
        String fileuser = "User.txt";
        String filecustomer = "Customer.txt";
        
        try {
            // read user.txt
            BufferedReader bu = new BufferedReader(new FileReader(us));
            // read customer.txt
            BufferedReader br = new BufferedReader(new FileReader(cs));
            
            // get lines from user.txt
            Object [] Uslines = bu.lines().toArray();
            // get lines from customer.txt
            Object [] Cslines = br.lines().toArray();
            
            // extract user data from lines
            for (int i=0; i < Uslines.length; i++){
                String Line = Uslines[i].toString().trim();
                // split the data 
                String[] Usrow = Line.split(";"); 
                
                // Check for existing username 
                if (Usrow[1].equals(username)){
                    JOptionPane.showMessageDialog(new JFrame(), "Username Already Taken." , "Data Exists", JOptionPane.ERROR_MESSAGE); 
                    return false;
                }
            }
              
            // extract customer data from lines
            for (int i=0; i < Cslines.length; i++){
                String Line = Cslines[i].toString().trim();
                // split the data 
                String[] Csrow = Line.split(";"); 
                
                // Check for existing customer email 
                if (Csrow[5].equals(email)){
                    JOptionPane.showMessageDialog(new JFrame(), "Customer's Email Already Registered." , "Data Exists", JOptionPane.ERROR_MESSAGE);
                    return false;
                } 
            }
            
            bu.close();
            br.close();
            
            // write into user.txt
            String user = name + ";" + username + ";" + password + ";" + role;
            
            WriteFile wfu = new WriteFile(fileuser,true);
            wfu.writeToFile(user); 

            // write into customer.txt
            String data = username + ";" + name + ";" + customer.customerdetails();
            
            WriteFile wft = new WriteFile(filecustomer,true);
            wft.writeToFile(data);
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(new JFrame(), e.getMessage() , "Error", JOptionPane.ERROR_MESSAGE);
        }
        return true;
    }
    
    public boolean booktraining() throws IOException {
        File ss = new File("Session.txt");
        ss.mkdirs();
        String filesession = "Session.txt";
        
        try {
            // read session.txt
            BufferedReader br = new BufferedReader(new FileReader(ss));
            
            // get lines from session.txt
            Object [] Sslines = br.lines().toArray();
            
            // extract trainer data from lines
            for (int i=0; i < Sslines.length; i++){
                String Line = Sslines[i].toString().trim();
                // split the data 
                String[] Ssrow = Line.split(";"); 
                
                // Check for existing trainer session
                if (Ssrow[0].equals(session.getDate()) && Ssrow[1].equals(session.getStartTime()) && Ssrow[8].equals(session.getTrainerUsername())){
                    JOptionPane.showMessageDialog(new JFrame(), "Trainer's Training Session Clashed." , "Clashed Booking Session", JOptionPane.ERROR_MESSAGE);
                    return false;
                } 
                // Check for existing session with same venue
                if (Ssrow[0].equals(session.getDate()) && Ssrow[1].equals(session.getStartTime()) && Ssrow[4].equals(session.getVenue())){
                    JOptionPane.showMessageDialog(new JFrame(), "Venue Clashed. \nPlease select another venue." , "Clashed Booking Session", JOptionPane.ERROR_MESSAGE);
                    return false;
                }
                // Check for existing customer session
                if (Ssrow[0].equals(session.getDate()) && Ssrow[1].equals(session.getStartTime()) && Ssrow[6].equals(session.getCustomerUsername())){
                    JOptionPane.showMessageDialog(new JFrame(), "Customer's Training Session Clashed." , "Clashed Booking Session", JOptionPane.ERROR_MESSAGE);
                    return false;
                }
            }
            br.close();
            
            WriteFile wft = new WriteFile(filesession,true);
            wft.writeToFile(session.toString());
            // write into payment.txt
            getpayment();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(new JFrame(), e.getMessage() , "Error", JOptionPane.ERROR_MESSAGE);
        }
        return true;
    }
    
    public boolean getpayment() throws IOException {
        File ps = new File("Payment.txt");
        ps.mkdirs();
        String filepayment = "Payment.txt";
        
        try {
            // read payment.txt
            BufferedReader br = new BufferedReader(new FileReader(ps));
            
            // get lines from payment.txt
            Object [] Pslines = br.lines().toArray();
            
            // extract payment data from lines
            for (int i=0; i < Pslines.length; i++){
                String Line = Pslines[i].toString().trim();
                // split the data 
                String[] Psrow = Line.split(";"); 
            }
            br.close();
            
            WriteFile wft = new WriteFile(filepayment,true);
            wft.writeToFile(payment.toString());
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(new JFrame(), e.getMessage() , "Error", JOptionPane.ERROR_MESSAGE);
        }
        return true;
    }
}
