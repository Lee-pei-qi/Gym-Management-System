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
 * @author Pekyen
 */
public class User {
    
    //user fields
    protected String name, username, password, role;
    static User user = new User();
    
    public User(){
        this.name = "";
        this.username = "";
        this.password = "";
        this.role = "";
    }
    
    //constructor of all user fields
    public User(String name, String username, String password, String role){
        this.name = name;
        this.username = username;
        this.password = password;
        this.role = role;
    }
    
    //declare the data from text file
    User(String[] data){
        this(data[0],data[1],data[2],data[3]);
    }
    
    public String getName(){
        return name;
    }
    
    public void setName(String name){
        this.name=name;
    }
    
    public String getUsername(){
        return username;
    }
    
    public void setUsername(String username){
        this.username=username;
    }
    
    public String getPassword(){
        return password;
    }
    
    public void setPassword(String password){
        this.password = password;
    }
    
    public String GetRole(){
        return role;
    }
    
    public void setRole(String role){
        this.role = role;
    }
    
    public String toString(){
        return name + ";" + username + ";" + password + ";" + role;
    }
    
    public String totrainer(){
        return name + ";" + username + ";" + password + ";" + "Trainer";
    }
    
    //login for user
    public static boolean login (String username, String password, String role){
        try{
            File us = new File("User.txt");
            us.mkdirs();
            
            // open scanner
            Scanner scUs = new Scanner(us).useDelimiter("[;\n]");
            
            //check for data in user.txt
            while (scUs.hasNext()){
                //check for another data
                String thisline = scUs.nextLine();
                //split the data
                String[] data = thisline.split(";");
                
                if(data[1].equals(username)){
                    
                    if (data[3].equals(role)){
                                        
                        if(data[2].equals(password)){
                            
                            //set user session
                            user.setName(data[0]);
                            user.setUsername(data[1]);
                            user.setPassword(data[2]);
                            user.setRole(data[3]);
                                                        
                            return true;
                            
                        } else {
                            JOptionPane.showMessageDialog(new JFrame(), "Incorrect Password." , "Invalid Credentials", JOptionPane.WARNING_MESSAGE);
                            return false;
                        }
                    
                    } else {
                    JOptionPane.showMessageDialog(new JFrame(), "Incorrect User Role." , "Invalid Credentials", JOptionPane.WARNING_MESSAGE);
                    return false;
                    }
                }
            }
            
            // close scanner
            scUs.close();
            
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(new JFrame(), ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        
        JOptionPane.showMessageDialog(new JFrame(), "Credential Not Exists." , "Error", JOptionPane.ERROR_MESSAGE);
        return false;
    }
}
