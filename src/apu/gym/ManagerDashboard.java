/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apu.gym;

import static apu.gym.Manager.manager;
import static apu.gym.Trainer.trainer;
import static apu.gym.Customer.customer;
import java.awt.*;
import java.io.File;
import java.util.Scanner;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/**
 *
 * @author Pekyen
 */
public class ManagerDashboard extends javax.swing.JFrame {

    Color paneldefault;
    Color panelclick;
    
    // button group for radio buttons on Training tab
    ButtonGroup btnGrp = new ButtonGroup();
    
    String trainerusername, customerusername;
    
    String date, customername, trainername;
    
    public ManagerDashboard() {
        initComponents();
        
        // icon to display APU logo for JFrame
        ImageIcon icon = new ImageIcon("src/apu/gym/images/logo.png"); // https://www.youtube.com/watch?v=Kmgo00avvEw
        setIconImage(icon.getImage());
        jLabel6.setIcon(icon);
        jLabel6.setText("");
        
        // display gym icon
        ImageIcon iconGym = new ImageIcon("src/apu/gym/images/gym.png"); // https://www.youtube.com/watch?v=Kmgo00avvEw
        jLabel4.setIcon(iconGym);
        
        // display trainer icon
        ImageIcon iconTrainer = new ImageIcon("src/apu/gym/images/trainer.png"); // https://www.youtube.com/watch?v=Kmgo00avvEw
        jLabel5.setIcon(iconTrainer);
        
        // display customer icon
        ImageIcon iconCustomer = new ImageIcon("src/apu/gym/images/customer.png"); // https://www.youtube.com/watch?v=Kmgo00avvEw
        jLabel3.setIcon(iconCustomer);
        
        // display search icon
        ImageIcon iconSearch = new ImageIcon("src/apu/gym/images/search.png"); // https://www.youtube.com/watch?v=Kmgo00avvEw
        btnSearchTrainer.setIcon(iconSearch);
        btnSearchCustomer.setIcon(iconSearch);
        btnSearchSession.setIcon(iconSearch);
        
        // set color for the side panel
        paneldefault = new Color(176,196,222);
        panelclick = new Color(108,157,222);
        paneltraining.setBackground(paneldefault);
        paneltrainer.setBackground(paneldefault);
        panelcustomer.setBackground(paneldefault);
        
        // set the dashboard to be visible whereas other panel set to be invisible
        dashtraining.setVisible(true);
        dashtrainer.setVisible(false);
        dashcustomer.setVisible(false);
        
        // design for tables
        tableSession.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 14));
        tableSession.getTableHeader().setForeground(new Color(37,116,169));
        TableColumn venue = tableSession.getColumnModel().getColumn(2);
        venue.setPreferredWidth(25);
         
        tableTrainer.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 14));
        tableTrainer.getTableHeader().setForeground(new Color(37,116,169));
        TableColumn tgender = tableTrainer.getColumnModel().getColumn(1);
        tgender.setPreferredWidth(30);
        
        tableCustomer.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 14));
        tableCustomer.getTableHeader().setForeground(new Color(37,116,169));
        TableColumn cgender = tableCustomer.getColumnModel().getColumn(1);
        cgender.setPreferredWidth(30);
        
        // add radio buttons on Training tab into a button group 
        // https://www.geeksforgeeks.org/jradiobutton-java-swing/
        btnGrp.add(radDate);
        btnGrp.add(radCustomer);
        btnGrp.add(radTrainer);
        
        // display details in table
        TrainingTable();
        TrainerTable();
        CustomerTable();
    }
    
    private void TrainingTable(){
        try {
            File f = new File("Session.txt");
            f.mkdirs();
            
            Scanner ss = new Scanner(f).useDelimiter("[;\n]");
            String[] ssArray;
            
            // check for data in session.txt     
            while (ss.hasNext()) {
                // check for another data    
                String ssline = ss.nextLine();
                // split the data 
                ssArray = ssline.split(";");
                
                // store training data into string array
                String ssrow[] = {ssArray[0],ssArray[1] + " - " + ssArray[2],ssArray[4],ssArray[7],ssArray[9]};     
                DefaultTableModel tbltraining = (DefaultTableModel)tableSession.getModel();
                // add string array ssrow
                tbltraining.addRow(ssrow);
            }
            ss.close();
        } catch (Exception e) {
             JOptionPane.showMessageDialog(new JFrame(), e.getMessage() , "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void TrainerTable(){
        try {
            File f = new File("Trainer.txt");
            f.mkdirs();
            
            Scanner ts = new Scanner(f).useDelimiter("[;\n]");
            String[] tsArray;
            
            // check for data in trainer.txt     
            while (ts.hasNext()) {
                // check for another data    
                String tsline = ts.nextLine();
                // split the data 
                tsArray = tsline.split(";");
                
                // store trainer data into string array
                String tsrow[] = {tsArray[1],tsArray[2],tsArray[4],tsArray[5],tsArray[6]};     
                DefaultTableModel tbltrainer = (DefaultTableModel)tableTrainer.getModel();
                // add string array tsrow
                tbltrainer.addRow(tsrow);
            }
            ts.close();
        } catch (Exception e) {
             JOptionPane.showMessageDialog(new JFrame(), e.getMessage() , "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void CustomerTable(){
        try {
            File f = new File("Customer.txt");
            f.mkdirs();
            
            Scanner cs = new Scanner(f).useDelimiter("[;\n]");
            String[] csArray;
            
            // check for data in customer.txt     
            while (cs.hasNext()) {
                // check for another data    
                String csline = cs.nextLine();
                // split the data 
                csArray = csline.split(";");
                
                // store customer data into string array
                String csrow[] = {csArray[1],csArray[2],csArray[4],csArray[5],csArray[6]};     
                DefaultTableModel tblcustomer = (DefaultTableModel)tableCustomer.getModel();
                // add string array csrow
                tblcustomer.addRow(csrow);
            }
            cs.close();
        } catch (Exception e) {
             JOptionPane.showMessageDialog(new JFrame(), e.getMessage() , "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainpanel = new javax.swing.JPanel();
        toppanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        sidepanel = new javax.swing.JPanel();
        paneltraining = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        paneltrainer = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        panelcustomer = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        btnLogoout = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        dashtraining = new javax.swing.JPanel();
        btnBook = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tableSession = new javax.swing.JTable();
        txtSearchSession = new javax.swing.JTextField();
        btnSearchSession = new javax.swing.JButton();
        radTrainer = new javax.swing.JRadioButton();
        radDate = new javax.swing.JRadioButton();
        radCustomer = new javax.swing.JRadioButton();
        btnDelete = new javax.swing.JButton();
        dashtrainer = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tableTrainer = new javax.swing.JTable();
        btnRegisterTrainer = new javax.swing.JButton();
        btnSearchTrainer = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        txtTrainerUsername = new javax.swing.JTextField();
        dashcustomer = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tableCustomer = new javax.swing.JTable();
        btnRegisterCustomer = new javax.swing.JButton();
        btnSearchCustomer = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        txtCustomerUsername = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Manager Dashboard");
        setResizable(false);

        mainpanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        toppanel.setBackground(new java.awt.Color(255, 255, 153));
        toppanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Symphony Black", 0, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("APU Gym Management System");
        toppanel.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 10, 580, 60));

        jPanel1.setBackground(new java.awt.Color(176, 196, 222));

        jLabel2.setFont(new java.awt.Font("Symphony Black", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 153));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("MANAGER");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        toppanel.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 150, 40));

        mainpanel.add(toppanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 950, 80));

        sidepanel.setBackground(new java.awt.Color(176, 196, 222));
        sidepanel.setForeground(new java.awt.Color(0, 0, 204));
        sidepanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        paneltraining.setBackground(new java.awt.Color(108, 157, 222));
        paneltraining.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                paneltrainingMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                paneltrainingMousePressed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Symphony", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 153));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel4.setText("  Training Session");

        javax.swing.GroupLayout paneltrainingLayout = new javax.swing.GroupLayout(paneltraining);
        paneltraining.setLayout(paneltrainingLayout);
        paneltrainingLayout.setHorizontalGroup(
            paneltrainingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, paneltrainingLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                .addContainerGap())
        );
        paneltrainingLayout.setVerticalGroup(
            paneltrainingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneltrainingLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                .addContainerGap())
        );

        sidepanel.add(paneltraining, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 130, 200, 60));

        paneltrainer.setBackground(new java.awt.Color(108, 157, 222));
        paneltrainer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                paneltrainerMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                paneltrainerMousePressed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Symphony", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 153));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel5.setText("   Trainer");

        javax.swing.GroupLayout paneltrainerLayout = new javax.swing.GroupLayout(paneltrainer);
        paneltrainer.setLayout(paneltrainerLayout);
        paneltrainerLayout.setHorizontalGroup(
            paneltrainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneltrainerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                .addContainerGap())
        );
        paneltrainerLayout.setVerticalGroup(
            paneltrainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, paneltrainerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                .addContainerGap())
        );

        sidepanel.add(paneltrainer, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, 200, 60));

        panelcustomer.setBackground(new java.awt.Color(108, 157, 222));
        panelcustomer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelcustomerMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                panelcustomerMousePressed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Symphony", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 153));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel3.setText("   Customer");

        javax.swing.GroupLayout panelcustomerLayout = new javax.swing.GroupLayout(panelcustomer);
        panelcustomer.setLayout(panelcustomerLayout);
        panelcustomerLayout.setHorizontalGroup(
            panelcustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelcustomerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelcustomerLayout.setVerticalGroup(
            panelcustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelcustomerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                .addContainerGap())
        );

        sidepanel.add(panelcustomer, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 290, 200, 60));

        btnLogoout.setBackground(new java.awt.Color(102, 153, 255));
        btnLogoout.setFont(new java.awt.Font("Symphony Black", 1, 14)); // NOI18N
        btnLogoout.setForeground(new java.awt.Color(51, 51, 255));
        btnLogoout.setText("LOGOUT");
        btnLogoout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogooutActionPerformed(evt);
            }
        });
        sidepanel.add(btnLogoout, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 460, 200, 40));

        jLabel6.setText("jLabel6");
        sidepanel.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, -1, -1));

        mainpanel.add(sidepanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 200, 500));

        dashtraining.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnBook.setBackground(new java.awt.Color(0, 102, 204));
        btnBook.setFont(new java.awt.Font("Symphony Black", 0, 14)); // NOI18N
        btnBook.setForeground(new java.awt.Color(255, 255, 255));
        btnBook.setText("BOOK TRAINING");
        btnBook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBookActionPerformed(evt);
            }
        });
        dashtraining.add(btnBook, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 160, 40));

        jScrollPane3.setBorder(null);

        tableSession.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        tableSession.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Date", "Time", "Venue", "Customer", "Trainer"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableSession.setFocusable(false);
        tableSession.setGridColor(new java.awt.Color(255, 255, 255));
        tableSession.setRowHeight(35);
        tableSession.setRowMargin(3);
        tableSession.setSelectionBackground(new java.awt.Color(102, 153, 255));
        tableSession.getTableHeader().setResizingAllowed(false);
        tableSession.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(tableSession);
        if (tableSession.getColumnModel().getColumnCount() > 0) {
            tableSession.getColumnModel().getColumn(0).setResizable(false);
            tableSession.getColumnModel().getColumn(1).setResizable(false);
            tableSession.getColumnModel().getColumn(2).setResizable(false);
            tableSession.getColumnModel().getColumn(3).setResizable(false);
            tableSession.getColumnModel().getColumn(4).setResizable(false);
            tableSession.getColumnModel().getColumn(4).setHeaderValue("Trainer");
        }

        dashtraining.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 710, 390));

        txtSearchSession.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        dashtraining.add(txtSearchSession, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 20, 240, 30));

        btnSearchSession.setBackground(new java.awt.Color(255, 255, 204));
        btnSearchSession.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchSessionActionPerformed(evt);
            }
        });
        dashtraining.add(btnSearchSession, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 20, 50, 40));

        radTrainer.setText("Trainer");
        dashtraining.add(radTrainer, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 50, -1, -1));

        radDate.setText("Date");
        dashtraining.add(radDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 50, -1, -1));

        radCustomer.setText("Customer");
        dashtraining.add(radCustomer, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 50, -1, -1));

        btnDelete.setBackground(new java.awt.Color(255, 102, 102));
        btnDelete.setFont(new java.awt.Font("Symphony Black", 0, 14)); // NOI18N
        btnDelete.setForeground(new java.awt.Color(255, 255, 255));
        btnDelete.setText("DELETE");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        dashtraining.add(btnDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 20, -1, 40));

        mainpanel.add(dashtraining, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 80, 750, 500));

        dashtrainer.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane4.setBorder(null);

        tableTrainer.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        tableTrainer.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Gender", "IC Number", "Email", "Telephone Number"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableTrainer.setFocusable(false);
        tableTrainer.setGridColor(new java.awt.Color(255, 255, 255));
        tableTrainer.setRowHeight(35);
        tableTrainer.setRowMargin(3);
        tableTrainer.setSelectionBackground(new java.awt.Color(102, 153, 255));
        tableTrainer.getTableHeader().setResizingAllowed(false);
        tableTrainer.getTableHeader().setReorderingAllowed(false);
        jScrollPane4.setViewportView(tableTrainer);
        if (tableTrainer.getColumnModel().getColumnCount() > 0) {
            tableTrainer.getColumnModel().getColumn(0).setResizable(false);
            tableTrainer.getColumnModel().getColumn(1).setResizable(false);
            tableTrainer.getColumnModel().getColumn(2).setResizable(false);
            tableTrainer.getColumnModel().getColumn(3).setResizable(false);
            tableTrainer.getColumnModel().getColumn(4).setResizable(false);
        }

        dashtrainer.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 710, 390));

        btnRegisterTrainer.setBackground(new java.awt.Color(0, 102, 204));
        btnRegisterTrainer.setFont(new java.awt.Font("Symphony Black", 0, 14)); // NOI18N
        btnRegisterTrainer.setForeground(new java.awt.Color(255, 255, 255));
        btnRegisterTrainer.setText("REGISTER TRAINER");
        btnRegisterTrainer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegisterTrainerActionPerformed(evt);
            }
        });
        dashtrainer.add(btnRegisterTrainer, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 180, 40));

        btnSearchTrainer.setBackground(new java.awt.Color(255, 255, 204));
        btnSearchTrainer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchTrainerActionPerformed(evt);
            }
        });
        dashtrainer.add(btnSearchTrainer, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 20, 50, 40));

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Trainer's Username");
        dashtrainer.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 10, 190, 20));

        txtTrainerUsername.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        dashtrainer.add(txtTrainerUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 30, 190, 30));

        mainpanel.add(dashtrainer, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 80, 750, 500));

        dashcustomer.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane5.setBorder(null);

        tableCustomer.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        tableCustomer.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Gender", "IC Number", "Email", "Telephone Number"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableCustomer.setFocusable(false);
        tableCustomer.setGridColor(new java.awt.Color(255, 255, 255));
        tableCustomer.setRowHeight(35);
        tableCustomer.setRowMargin(3);
        tableCustomer.setSelectionBackground(new java.awt.Color(102, 153, 255));
        tableCustomer.getTableHeader().setResizingAllowed(false);
        tableCustomer.getTableHeader().setReorderingAllowed(false);
        jScrollPane5.setViewportView(tableCustomer);
        if (tableCustomer.getColumnModel().getColumnCount() > 0) {
            tableCustomer.getColumnModel().getColumn(0).setResizable(false);
            tableCustomer.getColumnModel().getColumn(1).setResizable(false);
            tableCustomer.getColumnModel().getColumn(2).setResizable(false);
            tableCustomer.getColumnModel().getColumn(3).setResizable(false);
            tableCustomer.getColumnModel().getColumn(4).setResizable(false);
        }

        dashcustomer.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 710, 390));

        btnRegisterCustomer.setBackground(new java.awt.Color(0, 102, 204));
        btnRegisterCustomer.setFont(new java.awt.Font("Symphony Black", 0, 14)); // NOI18N
        btnRegisterCustomer.setForeground(new java.awt.Color(255, 255, 255));
        btnRegisterCustomer.setText("REGISTER CUSTOMER");
        btnRegisterCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegisterCustomerActionPerformed(evt);
            }
        });
        dashcustomer.add(btnRegisterCustomer, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 200, 40));

        btnSearchCustomer.setBackground(new java.awt.Color(255, 255, 204));
        btnSearchCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchCustomerActionPerformed(evt);
            }
        });
        dashcustomer.add(btnSearchCustomer, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 20, 50, -1));

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Customer's Username");
        dashcustomer.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 10, 190, 20));

        txtCustomerUsername.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        dashcustomer.add(txtCustomerUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 30, 190, 30));

        mainpanel.add(dashcustomer, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 80, 750, 500));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainpanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainpanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnLogooutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogooutActionPerformed
        // confirm logout dialog
        int reply = JOptionPane.showConfirmDialog(null, "Do you want to Logout?", "Logout Confirmation", JOptionPane.YES_NO_OPTION);
        
        if (reply == JOptionPane.YES_OPTION){
            this.dispose();
            Login login = new Login();
            login.setVisible(true);
        }
    }//GEN-LAST:event_btnLogooutActionPerformed

    private void paneltrainingMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_paneltrainingMouseClicked
        dashtraining.setVisible(true);
        dashtrainer.setVisible(false);
        dashcustomer.setVisible(false);
    }//GEN-LAST:event_paneltrainingMouseClicked

    private void paneltrainingMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_paneltrainingMousePressed
        paneltraining.setBackground(panelclick);
        paneltrainer.setBackground(paneldefault);
        panelcustomer.setBackground(paneldefault);
    }//GEN-LAST:event_paneltrainingMousePressed

    private void paneltrainerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_paneltrainerMouseClicked
        dashtraining.setVisible(false);
        dashtrainer.setVisible(true);
        dashcustomer.setVisible(false);
    }//GEN-LAST:event_paneltrainerMouseClicked

    private void paneltrainerMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_paneltrainerMousePressed
        paneltrainer.setBackground(panelclick);
        paneltraining.setBackground(paneldefault);
        panelcustomer.setBackground(paneldefault);
    }//GEN-LAST:event_paneltrainerMousePressed

    private void panelcustomerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelcustomerMouseClicked
        dashtraining.setVisible(false);
        dashtrainer.setVisible(false);
        dashcustomer.setVisible(true);
    }//GEN-LAST:event_panelcustomerMouseClicked

    private void panelcustomerMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelcustomerMousePressed
        panelcustomer.setBackground(panelclick);
        paneltraining.setBackground(paneldefault);
        paneltrainer.setBackground(paneldefault);
    }//GEN-LAST:event_panelcustomerMousePressed

    private void btnSearchTrainerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchTrainerActionPerformed
        trainerusername = txtTrainerUsername.getText();
        boolean flag = manager.searchtrainer(trainerusername);
        
        DefaultTableModel tbltrainer = (DefaultTableModel)tableTrainer.getModel();
        
        try {
            if (flag == true){
                String trow[] = {trainer.getName(),trainer.getGender(),trainer.getIC(),trainer.getEmail(),trainer.getPhone()};
                
                tbltrainer.setRowCount(0);
                // add string array trow
                tbltrainer.addRow(trow);
            }
            else {
                JOptionPane.showMessageDialog(this, "Record not found." , "Record Not Found", JOptionPane.ERROR_MESSAGE);
                tbltrainer.setRowCount(0);
                TrainerTable();
            }
        } catch(NullPointerException e) {
            JOptionPane.showMessageDialog(new JFrame(), e.getMessage() , "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnSearchTrainerActionPerformed

    private void btnSearchCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchCustomerActionPerformed
        customerusername = txtCustomerUsername.getText();
        boolean flag = manager.searchcustomer(customerusername);
        
        DefaultTableModel tblcustomer = (DefaultTableModel)tableCustomer.getModel();

        try{
            if (flag == true){
                String trow[] = {customer.getName(),customer.getGender(),customer.getIC(),customer.getEmail(),customer.getPhone()};
                
                tblcustomer.setRowCount(0);
                // add string array trow
                tblcustomer.addRow(trow);
            }
            else {
                JOptionPane.showMessageDialog(this, "Record not found." , "Record Not Found", JOptionPane.ERROR_MESSAGE);
                tblcustomer.setRowCount(0);
                CustomerTable();
            }
        } catch(NullPointerException e) {
            JOptionPane.showMessageDialog(new JFrame(), e.getMessage() , "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnSearchCustomerActionPerformed

    private void btnRegisterTrainerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegisterTrainerActionPerformed
        this.dispose();
        RegisterTrainer rp = new RegisterTrainer();
        rp.setVisible(true);
    }//GEN-LAST:event_btnRegisterTrainerActionPerformed

    private void btnRegisterCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegisterCustomerActionPerformed
        this.dispose();
        RegisterCustomer rc = new RegisterCustomer();
        rc.setVisible(true);
    }//GEN-LAST:event_btnRegisterCustomerActionPerformed

    private void btnBookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBookActionPerformed
        this.dispose();
        BookSession bs = new BookSession();
        bs.setVisible(true);
    }//GEN-LAST:event_btnBookActionPerformed

    private void btnSearchSessionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchSessionActionPerformed
        String searchString = txtSearchSession.getText();
        String searchKey = "";
        
        // get gender according to the radio buttons
        if (radDate.isSelected() == true){
            searchKey = "Date";
        } else if (radTrainer.isSelected() == true){
            searchKey = "Trainer";
        } else if (radCustomer.isSelected() == true){
            searchKey = "Customer";
        }
                
        if (btnGrp.getSelection() == null){
            JOptionPane.showMessageDialog(this, "Please select a search key." , "Empty Search Key", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        String sessionStr = manager.searchsession(searchString, searchKey);
        
        DefaultTableModel model = (DefaultTableModel)tableSession.getModel();
        model.setRowCount(0);  // remove previous records in table

        try{
            if (!sessionStr.equals("")){
                String[] sessions = sessionStr.split("\n");  // split string into arrays of session
                
                for (String session : sessions) {
                    String[] data = session.split(";");
                    String time = data[1] + "-" + data[2];
                    model.addRow(new Object[]{data[0], time, data[4], data[7], data[9]}); 
                }
            }
            else {
                JOptionPane.showMessageDialog(this, "Record not found." , "Record Not Found", JOptionPane.ERROR_MESSAGE);
                TrainingTable();
            }
        } catch(NullPointerException e) {
            JOptionPane.showMessageDialog(new JFrame(), e.getMessage() , "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnSearchSessionActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        DefaultTableModel tbltraining = (DefaultTableModel)tableSession.getModel();
        
        try{
            int data = tableSession.getSelectedRow();
            
            // get data from selected row of the table
            date = tbltraining.getValueAt(data, 0).toString();
            customername = tbltraining.getValueAt(data, 3).toString();
            trainername = tbltraining.getValueAt(data, 4).toString();
        
            if (tableSession.getSelectedRowCount() == 1){
                int reply = JOptionPane.showConfirmDialog(null, "Do you want to delete this training session? \nThis action is irreversible!", "Delete Confirmation", JOptionPane.YES_NO_OPTION);
        
                if (reply == JOptionPane.YES_OPTION){
                    // delete row from the table
                    tbltraining.removeRow(tableSession.getSelectedRow());
                    
                    // delete the selected session from session.txt
                    if (Session.deletesession(date, customername, trainername)){
                        JOptionPane.showMessageDialog(this, "Session Deleted!" , "Data Deleted", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
                
            } else {
                JOptionPane.showMessageDialog(this, "Please select a row to delete." , "Faulty Selection", JOptionPane.ERROR_MESSAGE);
            }
            
        } catch(Exception ex) {
            JOptionPane.showMessageDialog(this, "Please select a row to delete." , "Missing Selection", JOptionPane.ERROR_MESSAGE);
        }
        
    }//GEN-LAST:event_btnDeleteActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ManagerDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManagerDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManagerDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManagerDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManagerDashboard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBook;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnLogoout;
    private javax.swing.JButton btnRegisterCustomer;
    private javax.swing.JButton btnRegisterTrainer;
    private javax.swing.JButton btnSearchCustomer;
    private javax.swing.JButton btnSearchSession;
    private javax.swing.JButton btnSearchTrainer;
    private javax.swing.JPanel dashcustomer;
    private javax.swing.JPanel dashtrainer;
    private javax.swing.JPanel dashtraining;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JPanel mainpanel;
    private javax.swing.JPanel panelcustomer;
    private javax.swing.JPanel paneltrainer;
    private javax.swing.JPanel paneltraining;
    private javax.swing.JRadioButton radCustomer;
    private javax.swing.JRadioButton radDate;
    private javax.swing.JRadioButton radTrainer;
    private javax.swing.JPanel sidepanel;
    private javax.swing.JTable tableCustomer;
    private javax.swing.JTable tableSession;
    private javax.swing.JTable tableTrainer;
    private javax.swing.JPanel toppanel;
    private javax.swing.JTextField txtCustomerUsername;
    private javax.swing.JTextField txtSearchSession;
    private javax.swing.JTextField txtTrainerUsername;
    // End of variables declaration//GEN-END:variables
}
