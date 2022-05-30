/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apu.gym;

import java.io.*;
import static java.lang.Double.parseDouble;
import java.util.Scanner;
import java.util.logging.*;
import javax.swing.*;

/**
 *
 * @author Acer
 */
public class Feedback {
    //private int ID;
    private String feedbackDate;
    private String sessionDate;
    private String sessionTime;
    private String customerUsername;
    private String trainerUsername;
    private double rating;
    private String content;
    
    static Feedback feedback = new Feedback();
    
    public Feedback(){
        //ID = 0;
        feedbackDate = "";
        sessionDate =  "";
        sessionTime =  "";
        customerUsername =  "";
        trainerUsername =  "";
        rating =  0;    
        content = "";
    }
    
    public Feedback(String feedbackDate,String sessionDate,String sessionTime,String customerUsername,String trainerUsername){
        this.feedbackDate = feedbackDate;
        this.sessionDate =  sessionDate;
        this.sessionTime =  sessionTime;
        this.customerUsername =  customerUsername;
        this.trainerUsername =  trainerUsername;
        this.rating = 0;    
        this.content = "";
    }
    
    public String getFeedbackDate(){
        return feedbackDate;
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
    
    public double getRating(){
        return rating;
    }
    
    public String getContent(){
        return content;
    }
    
    public void setFeedbackDate(String feedbackDate){
        this.feedbackDate = feedbackDate;
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
    
    public void setRating(double rating){
        this.rating = rating;
    }
    
    public void setContent(String content){
        this.content = content;
    }
    
    public String toString(){
        return feedbackDate + ";" + sessionDate + ";" + sessionTime + ";" + customerUsername + ";" + trainerUsername + ";" + rating + ";" + content;
    }
    
    public int provideFeedback(){
        int flag = -1;  // 0=provided, 1=added, 2=edited, -1=error        
        
        String filePath = "Feedback.txt";
        
        try{            
            File f = new File(filePath);
            f.mkdirs();
            
            // open scanner
            Scanner s = new Scanner(f).useDelimiter("[;\n]");
            
            //check for data in session.txt
            while (s.hasNext()){
                //check for another data
                String thisline = s.nextLine();
                
                if (!thisline.equals("")){
                    //split the data
                    String[] data = thisline.split(";");

                    // check if feedback is provided
                    if(data[1].equals(sessionDate) && data[2].equals(sessionTime) && data[4].equals(trainerUsername)){
                        flag = 0;  // feedback is provided

                        // if provided, ask whether to edit feedback
                        int result = JOptionPane.showConfirmDialog(null, "Feedback has been provided.\n\nDo you want to EDIT the feedback?", "Record Existed", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

                        // if YES, show input box with existing feedback
                        if (result == 0){
                            String reply = JOptionPane.showInputDialog(null, "Rating: "+data[5]+"\n\n Enter New Rating", "Input New Rating", JOptionPane.INFORMATION_MESSAGE);
                            
                            if (reply != null){
                                rating = parseDouble(reply);
                                String reply2 = JOptionPane.showInputDialog(null, "Feedback: "+data[6]+"\n\n Enter New Feedback", "Input New Feedback", JOptionPane.INFORMATION_MESSAGE);

                                if (!reply2.equals("")){
                                    content = reply2;

                                    // update the updated record to txtfile
                                    WriteFile wf = new WriteFile(filePath);
                                    wf.updateRowByLine(thisline, this.toString());
                                    flag = 2;  // feedback is edited
                                } else {
                                    JOptionPane.showMessageDialog(new JFrame(), "Invalid Input!", "Error", JOptionPane.ERROR_MESSAGE);
                                }
                            }
                        }
                    } 
                }
            }
            
            if (flag == -1){
                // add feedback if data is not existed
                // show input box to add feedback - rating
                String reply = JOptionPane.showInputDialog(null, "Enter Rating", "Input Rating", JOptionPane.INFORMATION_MESSAGE);
                
                if (reply != null){
                    rating = parseDouble(reply);
                    
                    // show input box to add feedback - content
                    String reply2 = JOptionPane.showInputDialog(null, "Enter Feedback", "Input Feedback", JOptionPane.INFORMATION_MESSAGE);
                    if (!reply2.equals("")){
                        content = reply2;
                        
                        //write to txtfile
                        WriteFile wf = new WriteFile(filePath, true);        
                        wf.writeToFile(this.toString());
                        flag = 1;  // new feedback is added
                    } else {
                        JOptionPane.showMessageDialog(new JFrame(), "Invalid Input!", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }            
            }
            
            s.close();  // close scanner

        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(new JFrame(), ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch (IOException ex) { 
            Logger.getLogger(Feedback.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(new JFrame(), "Invalid Rating!", "Error", JOptionPane.ERROR_MESSAGE);
        }
        
        return flag;
    }
    
    public boolean viewFeedback(){
        // check if feedback is found
        boolean flag = false;
        
        try{            
            File f = new File("Feedback.txt");
            f.mkdirs();
            
            // open scanner
            Scanner s = new Scanner(f).useDelimiter("[;\n]");
            
            //check for data in Feedback.txt
            while (s.hasNext()){
                //check for another data
                String thisline = s.nextLine();
                //split the data
                String[] data = thisline.split(";");
                

                if(data[1].equals(feedback.getSessionDate()) && data[2].equals(feedback.getSessionTime()) && 
                        data[3].equals(feedback.getCustomerUsername()) && data[4].equals(feedback.getTrainerUsername())){
                    feedback.setRating(parseDouble(data[5]));
                    feedback.setContent(data[6]);
                    
                    flag = true;
                } 
            }
            // close scanner
            s.close();

        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(new JFrame(), ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return flag;
    }
    
    public boolean getFeedback(){
        // check if feedback is found
        boolean flag = false;
        
        try{            
            File f = new File("Feedback.txt");
            f.mkdirs();
            
            // open scanner
            Scanner s = new Scanner(f).useDelimiter("[;\n]");
            
            //check for data in Feedback.txt
            while (s.hasNext()){
                String thisline = s.nextLine();
                String[] data = thisline.split(";");  //split the data
                

                if(data[1].equals(feedback.getSessionDate()) && data[2].equals(feedback.getSessionTime()) && 
                        data[3].equals(feedback.getCustomerUsername()) && data[4].equals(feedback.getTrainerUsername())){
                    feedback.setRating(parseDouble(data[5]));
                    feedback.setContent(data[6]);
                    feedback.setFeedbackDate(data[0]);
                    flag = true;
                } 
            }
            // close scanner
            s.close();

        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(new JFrame(), ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return flag;
    }
}
