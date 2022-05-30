/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apu.gym;

import java.io.*;
import java.util.Scanner;

/**
 https://www.homeandlearn.co.uk/java/write_to_textfile.html
 */

public class WriteFile {
    private String path;
    private boolean append_to_file = false;
   
    public WriteFile(String file_path){ //overwrite the text file
        path = file_path;
    }
    
    public WriteFile(String file_path, boolean value){ //append to the file - insert new record
        path = file_path;
        append_to_file = value;
    }
    
    public void writeToFile (String textline) throws IOException{ //text to write in file
        FileWriter write = new FileWriter(path, append_to_file); //FileWriter - opening the correct file, and storing the text as bytes
        PrintWriter print = new PrintWriter(write); //convert plain text to bytes
        
        print.println(textline);  // cursor on next new line
        print.close();
    }
    
    public void updateFile (String textline) throws IOException{ //text to write in file
        FileWriter write = new FileWriter(path, append_to_file); //FileWriter - opening the correct file, and storing the text as bytes
        PrintWriter print = new PrintWriter(write); //convert plain text to bytes
        
        print.print(textline);  // cursor on current line
        print.close();
    }
    
    // input - user input to compare with dataset, index - index of compatible data, textline - new updated record 
    public void updateRow(String input, int index, String textline) throws IOException{    
           File f = new File(path);
           Scanner sc = new Scanner(f);
           String line = "";
           StringBuilder sb = new StringBuilder();
           
           while(sc.hasNextLine()){
               line = sc.nextLine();
               String[] data = line.split(";");

               if (data[index].equals(input)){
                   sb.append(textline);
                   sb.append("\n");
               } else {
               sb.append(line);
               sb.append("\n");
               }
           }
           sc.close();
           updateFile(sb.toString());
    }
    
    public void updateRowByLine(String originalLine, String updateLine) throws IOException{    
           File f = new File(path);
           Scanner sc = new Scanner(f);
           String line = "";
           StringBuilder sb = new StringBuilder();
           
           while(sc.hasNextLine()){
               line = sc.nextLine();

               if (line.equals(originalLine)){
                   sb.append(updateLine);
                   sb.append("\n");
               } else {
                    sb.append(line);
                    sb.append("\n");
               }
           }
           sc.close();
           System.out.println(sb.toString());
           updateFile(sb.toString());
    }
   
    
    public void deleteRow(String deleteLine) throws IOException{
        File file = new File(path);
        
        Scanner sc = new Scanner(file);
        String line = "";
        StringBuilder sb = new StringBuilder();
           
           while(sc.hasNextLine()){
               line = sc.nextLine();

               if (!line.equals(deleteLine)){
                   sb.append(line);
                   sb.append("\n");
               }    
           }
           sc.close();
           updateFile(sb.toString());
    }
}
