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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import static apu.gym.Session.session;
import static apu.gym.Manager.manager;
import static apu.gym.Payment.payment;

/**
 *
 * @author Pekyen
 */
public class BookSession extends javax.swing.JFrame {

    /**
     * Creates new form BookSession
     */
    
    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
    
    String today = sdf.format(new Date());
    
    SimpleDateFormat format = new SimpleDateFormat("HH:mm");
    Date date1;
    Date date2;
            
    Double amount;        
    
    public BookSession() {
        initComponents();
        
        // https://stackoverflow.com/questions/10021565/how-to-show-only-date-after-the-date-of-today-in-jcalendar
        try {
            // set date to today or after until next year
            dateSession.setSelectableDateRange(new Date(),sdf.parse("31-12-2022"));

        } catch (ParseException ex) {
            Logger.getLogger(BookSession.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        gettrainerusername();
        getcustomerusername();
    }
    
    public void calculateduration(){
        // https://stackoverflow.com/questions/4927856/how-can-i-calculate-a-time-difference-in-java
        try {
            date1 = format.parse(cboStart.getSelectedItem().toString());
            date2 = format.parse(cboEnd.getSelectedItem().toString());
            
            long difference = date2.getTime() - date1.getTime(); 
            
            long diffHours = difference / (60 * 60 * 1000) % 24;
            long diffMinutes = difference / (60 * 1000) % 60;
            
            String duration = String.valueOf(diffHours) + " hour " + String.valueOf(diffMinutes) + " minutes";
            txtDuration.setText(duration);
            
            if (date1.after(date2) || date1.equals(date2)){
                JOptionPane.showMessageDialog(this, "Please select the correct time." , "Invalid Time", JOptionPane.ERROR_MESSAGE);
            } else {
               txtDuration.setText(duration); 
            }

        } catch (ParseException ex) {
            Logger.getLogger(BookSession.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void gettrainerusername(){
        File tr = new File("Trainer.txt");
        tr.mkdirs();
        
        try {
            // read trainer.txt
            BufferedReader br = new BufferedReader(new FileReader(tr));
            
            // get lines from trainer.txt
            Object [] Trlines = br.lines().toArray();
            
            // extract trainer data from lines
            for (int i=0; i < Trlines.length; i++){
                String Line = Trlines[i].toString().trim();
                // split the data 
                String[] Trrow = Line.split(";"); 
                // get username
                cboTrainer.addItem(Trrow[0]);
                // get trainer name according to username
                if (cboTrainer.getSelectedItem().toString().equals(Trrow[0])){
                    txtTrainer.setText(Trrow[1]);
                }
            }
            br.close();
        } catch (IOException e) {
             JOptionPane.showMessageDialog(new JFrame(), e.getMessage() , "Error", JOptionPane.ERROR_MESSAGE);
        } 
    }
    
    public void getcustomerusername(){
        File cr = new File("Customer.txt");
        cr.mkdirs();
        
        try {
            // read customer.txt
            BufferedReader br = new BufferedReader(new FileReader(cr));
            
            // get lines from customer.txt
            Object [] Crlines = br.lines().toArray();
            
            // extract customer data from lines
            for (int i=0; i < Crlines.length; i++){
                String Line = Crlines[i].toString().trim();
                // split the data 
                String[] Crrow = Line.split(";"); 
                // get username
                cboCustomer.addItem(Crrow[0]);
                // get customer name according to username
                if (cboCustomer.getSelectedItem().toString().equals(Crrow[0])){
                    txtCustomer.setText(Crrow[1]);
                }
            }
            br.close();
        } catch (IOException e) {
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

        jPanel1 = new javax.swing.JPanel();
        toppanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        cboStart = new javax.swing.JComboBox<>();
        cboEnd = new javax.swing.JComboBox<>();
        txtDuration = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        cboPaymentType = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        txtAmount = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtTrainer = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        cboTrainer = new javax.swing.JComboBox<>();
        jLabel14 = new javax.swing.JLabel();
        txtCustomer = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        cboCustomer = new javax.swing.JComboBox<>();
        btnSave = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        cboLevel = new javax.swing.JComboBox<>();
        cboVenue = new javax.swing.JComboBox<>();
        dateSession = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Booking for Training Session");

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        toppanel.setBackground(new java.awt.Color(255, 255, 153));
        toppanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Symphony Black", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 51, 204));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("APU Gym Training Session");
        toppanel.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 10, 760, 60));

        jPanel2.setBackground(new java.awt.Color(176, 196, 222));

        jLabel2.setFont(new java.awt.Font("Symphony Black", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 153));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("TRAINING");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        toppanel.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 19, 150, -1));

        jPanel1.add(toppanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 950, 80));

        cboStart.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cboStart.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "10:00", "10:30", "11:00", "11:30", "12:00", "14:00", "14:30", "15:00", "15:30", "16:00", "16:30" }));
        cboStart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboStartActionPerformed(evt);
            }
        });

        cboEnd.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cboEnd.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "10:30", "11:00", "11:30", "13:00", "13:30", "14:00", "14:30", "15:00", "15:30", "16:00", "16:30", "17:00" }));
        cboEnd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboEndActionPerformed(evt);
            }
        });

        txtDuration.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtDuration.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtDuration.setDisabledTextColor(new java.awt.Color(0, 51, 153));
        txtDuration.setEnabled(false);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Session Time");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("Session Date");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("Duration");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setText("Venue");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setText("Payment Type");

        cboPaymentType.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cboPaymentType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Credit Card", "Cash" }));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setText("Payment Amount");

        txtAmount.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel12.setText("Trainer Username");

        txtTrainer.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtTrainer.setDisabledTextColor(new java.awt.Color(0, 51, 153));
        txtTrainer.setEnabled(false);

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel13.setText("Trainer Name");

        cboTrainer.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cboTrainer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboTrainerActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel14.setText("Customer Username");

        txtCustomer.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtCustomer.setDisabledTextColor(new java.awt.Color(0, 51, 153));
        txtCustomer.setEnabled(false);

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel15.setText("Customer Name");

        cboCustomer.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cboCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboCustomerActionPerformed(evt);
            }
        });

        btnSave.setBackground(new java.awt.Color(0, 102, 204));
        btnSave.setFont(new java.awt.Font("Symphony Black", 0, 14)); // NOI18N
        btnSave.setForeground(new java.awt.Color(255, 255, 255));
        btnSave.setText("SAVE");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnCancel.setBackground(new java.awt.Color(0, 102, 204));
        btnCancel.setFont(new java.awt.Font("Symphony Black", 0, 14)); // NOI18N
        btnCancel.setForeground(new java.awt.Color(255, 255, 255));
        btnCancel.setText("CANCEL");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel16.setText("Level");

        cboLevel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cboLevel.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Beginner", "Intermediate", "Advanced" }));

        cboVenue.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cboVenue.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Room 1", "Room 2", "Room 3", "Room 4", "Room 5" }));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cboLevel, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(cboStart, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cboEnd, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtDuration)
                            .addComponent(cboVenue, 0, 200, Short.MAX_VALUE)
                            .addComponent(dateSession, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtAmount))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cboPaymentType, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 161, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(65, 65, 65)
                        .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(83, 83, 83))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cboTrainer, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtTrainer, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(cboCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(39, 39, 39))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(dateSession, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cboStart, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cboEnd, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtDuration, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(34, 34, 34)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cboVenue, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(31, 31, 31)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cboLevel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(36, 36, 36)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cboPaymentType, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(32, 32, 32)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(61, 61, 61)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cboTrainer, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(32, 32, 32)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtTrainer, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cboCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(32, 32, 32)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(51, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 950, 500));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void cboStartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboStartActionPerformed
        // https://www.youtube.com/watch?v=GGgbwFE1cOw
        Object obj = evt.getSource();
        if (obj == cboStart){
            calculateduration();
        }
    }//GEN-LAST:event_cboStartActionPerformed

    private void cboEndActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboEndActionPerformed
        // https://www.youtube.com/watch?v=GGgbwFE1cOw
        Object obj = evt.getSource();
        if (obj == cboEnd){
            calculateduration();
        }
    }//GEN-LAST:event_cboEndActionPerformed

    private void cboTrainerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboTrainerActionPerformed
        Object obj = evt.getSource();
        if (obj == cboTrainer){
            File tr = new File("Trainer.txt");
            tr.mkdirs();
        
            try {
                // read trainer.txt
                BufferedReader br = new BufferedReader(new FileReader(tr));
            
                // get lines from trainer.txt
                Object [] Trlines = br.lines().toArray();
            
                // extract trainer data from lines
                for (int i=0; i < Trlines.length; i++){
                    String Line = Trlines[i].toString().trim();
                    // split the data 
                    String[] Trrow = Line.split(";"); 
                    // get trainer name according to username
                    if (cboTrainer.getSelectedItem().toString().equals(Trrow[0])){
                        txtTrainer.setText(Trrow[1]);
                    }
                }
                br.close();
            } catch (IOException e) {
                JOptionPane.showMessageDialog(new JFrame(), e.getMessage() , "Error", JOptionPane.ERROR_MESSAGE);
            } 
        }
    }//GEN-LAST:event_cboTrainerActionPerformed

    private void cboCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboCustomerActionPerformed
        Object obj = evt.getSource();
        if (obj == cboCustomer){
            File cr = new File("Customer.txt");
            cr.mkdirs();
        
            try {
                // read customer.txt
                BufferedReader br = new BufferedReader(new FileReader(cr));
            
                // get lines from customer.txt
                Object [] Crlines = br.lines().toArray();
            
                // extract customer data from lines
                for (int i=0; i < Crlines.length; i++){
                    String Line = Crlines[i].toString().trim();
                    // split the data 
                    String[] Crrow = Line.split(";"); 
                    // get customer name according to username
                    if (cboCustomer.getSelectedItem().toString().equals(Crrow[0])){
                        txtCustomer.setText(Crrow[1]);
                    }
                }
                br.close();
            } catch (IOException e) {
                JOptionPane.showMessageDialog(new JFrame(), e.getMessage() , "Error", JOptionPane.ERROR_MESSAGE);
            } 
        }
    }//GEN-LAST:event_cboCustomerActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        if (txtDuration.getText().isEmpty() || txtAmount.getText().isEmpty() || dateSession.getDate() == null){
            JOptionPane.showMessageDialog(null, "Please fill in the details!", "Missing Input", JOptionPane.ERROR_MESSAGE);
            try {
                amount = Double.parseDouble(txtAmount.getText());
            } catch(NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Please enter amount in numeric value." , "Empty Input", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }
        
        if (cboTrainer.getSelectedItem() == null || cboCustomer.getSelectedItem() == null){
            JOptionPane.showMessageDialog(null, "Please register new trainer or customer before proceed!", "Missing Data", JOptionPane.ERROR_MESSAGE);
        }
        
        if (date1.after(date2) || date1.equals(date2)){
            JOptionPane.showMessageDialog(this, "Please select the correct time." , "Invalid Time", JOptionPane.ERROR_MESSAGE);
        }
        
        else {
            try {
                session.setDate(sdf.format(dateSession.getDate()));   // parse date into string
                session.setStartTime(cboStart.getSelectedItem().toString());
                session.setEndTime(cboEnd.getSelectedItem().toString());
                session.setDuration(txtDuration.getText());
                session.setLevel(cboLevel.getSelectedItem().toString());
                session.setVenue(cboVenue.getSelectedItem().toString());
                session.setTrainerUsername(cboTrainer.getSelectedItem().toString());
                session.setTrainerName(txtTrainer.getText());
                session.setCustomerUsername(cboCustomer.getSelectedItem().toString());
                session.setCustomerName(txtCustomer.getText());
                
                payment.setPaymentDate(today);
                payment.setPaymentType(cboPaymentType.getSelectedItem().toString());
                payment.setAmount(Double.parseDouble(txtAmount.getText()));
                payment.setSessionDate(sdf.format(dateSession.getDate()));
                payment.setSessionTime(cboStart.getSelectedItem().toString() + "-" + cboEnd.getSelectedItem().toString());
                payment.setCustomerUsername(cboCustomer.getSelectedItem().toString());
                payment.setTrainerUsername(cboTrainer.getSelectedItem().toString());
                payment.setCollectedDate("");
                payment.setStatus("Paid");   
                
                if (manager.booktraining()){
                    JOptionPane.showMessageDialog(this, "Session Booked!" , "Data Inserted", JOptionPane.INFORMATION_MESSAGE);
                    this.dispose();
                    ManagerDashboard md = new ManagerDashboard();
                    md.setVisible(true);
                }
                
            } catch (NullPointerException | NumberFormatException e){
                JOptionPane.showMessageDialog(null, "Please enter a valid price or date!", "Invalid Input", JOptionPane.ERROR_MESSAGE);
                
            } catch (IOException ex) {
                Logger.getLogger(BookSession.class.getName()).log(Level.SEVERE, null, ex);
            }   
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        int reply = JOptionPane.showConfirmDialog(null, "Do you want to exit? Changes made WILL NOT be saved!", "Exit Confirmation", JOptionPane.YES_NO_OPTION);

        if (reply == JOptionPane.YES_OPTION){
            // back to Homepage
            this.dispose();
            ManagerDashboard md = new ManagerDashboard();
            md.setVisible(true);
        }
    }//GEN-LAST:event_btnCancelActionPerformed

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
            java.util.logging.Logger.getLogger(BookSession.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BookSession.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BookSession.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BookSession.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BookSession().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnSave;
    private javax.swing.JComboBox<String> cboCustomer;
    private javax.swing.JComboBox<String> cboEnd;
    private javax.swing.JComboBox<String> cboLevel;
    private javax.swing.JComboBox<String> cboPaymentType;
    private javax.swing.JComboBox<String> cboStart;
    private javax.swing.JComboBox<String> cboTrainer;
    private javax.swing.JComboBox<String> cboVenue;
    private com.toedter.calendar.JDateChooser dateSession;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel toppanel;
    private javax.swing.JTextField txtAmount;
    private javax.swing.JTextField txtCustomer;
    private javax.swing.JTextField txtDuration;
    private javax.swing.JTextField txtTrainer;
    // End of variables declaration//GEN-END:variables
}
