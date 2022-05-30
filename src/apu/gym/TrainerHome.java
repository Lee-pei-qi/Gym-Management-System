/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apu.gym;

import static apu.gym.Trainer.trainer;
import java.text.*;
import java.util.*;
import java.util.logging.*;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Acer
 */
public class TrainerHome extends javax.swing.JFrame {
    
    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
    
    Calendar cal = Calendar.getInstance();
    String today = sdf.format(new Date());  // get today day to select the respective tab
    String selectedDate;
    
    /**
     * Creates new form TrainerHome
     */
    public TrainerHome() {
        initComponents();
        
        // icon to display APU logo for JFrame
        ImageIcon icon = new ImageIcon("src/apu/gym/images/logo.png"); // https://www.youtube.com/watch?v=Kmgo00avvEw
        setIconImage(icon.getImage());
        
        // icon to display background
        ImageIcon iconBgd = new ImageIcon("src/apu/gym/images/bgd.png"); // https://www.youtube.com/watch?v=Kmgo00avvEw
        bgd.setIcon(iconBgd);
        
        // display profile icon
        ImageIcon iconProfile = new ImageIcon("src/apu/gym/images/profile.png"); // https://www.youtube.com/watch?v=Kmgo00avvEw
        btnProfile.setIcon(iconProfile);
        
        // set calendar time as today
        cal.setTime(new Date());
        int todayIndex = cal.get(Calendar.DAY_OF_WEEK) - 1;  // subtract calendar index (1=Sunday ... 7=Saturday) with 1 to match with tabbedpanel index
        
        txtSearchWeek.setDate(new Date());
        
        // select the respective tab based on today's day
        Timetable.setSelectedIndex(todayIndex);
        
        // get details from txtfile and display training details
        DefaultTableModel model = getTableModel(todayIndex, today);
        displayTimetable(model, today);
        
        // add change listener for event trigger while switching tabs
        Timetable.addChangeListener(changeListener);
        
    }
    
    private DefaultTableModel getTableModel(int index, String date){
        DefaultTableModel model = (DefaultTableModel)tbl0.getModel();  // get Sunday table by default
                
        switch(index){
            case 0: 
                date0.setText(date);
                break;
            case 1: 
                date1.setText(date);
                model = (DefaultTableModel)tbl1.getModel();
                break;
            case 2: 
                date2.setText(date);
                model = (DefaultTableModel)tbl2.getModel();
                break;
            case 3: 
                date3.setText(date);
                model = (DefaultTableModel)tbl3.getModel();
                break;
            case 4: 
                date4.setText(date);
                model = (DefaultTableModel)tbl4.getModel();
                break;
            case 5: 
                date5.setText(date);
                model = (DefaultTableModel)tbl5.getModel();
                break;
            case 6: 
                date6.setText(date);
                model = (DefaultTableModel)tbl6.getModel();
                break;
        }
        
        return model;
    }
    
    private void clearTableContent(){
        // clear previous content on all table model
        DefaultTableModel model = (DefaultTableModel)tbl0.getModel();
        model.setRowCount(0);
        model = (DefaultTableModel)tbl1.getModel();
        model.setRowCount(0);
        model = (DefaultTableModel)tbl2.getModel();
        model.setRowCount(0);
        model = (DefaultTableModel)tbl3.getModel();
        model.setRowCount(0);
        model = (DefaultTableModel)tbl4.getModel();
        model.setRowCount(0);
        model = (DefaultTableModel)tbl5.getModel();
        model.setRowCount(0);
        model = (DefaultTableModel)tbl6.getModel();
        model.setRowCount(0);
    }
    
    private void displayTimetable(DefaultTableModel model, String date){
        
        // display session details for the selected date
        String sessionStr = trainer.getTrainingSession(date);        
        
        if (!sessionStr.equals("")){
            String[] sessions = sessionStr.split("\n");  // split into diff sessions for the same date
            
            for (String session : sessions) {
                model.setRowCount(0);  // clear previous content
                
                String[] data = session.split(";");
                String time = data[1] + "-" + data[2];
                String customer = data[7] + " - @" + data[6];
                model.addRow(new Object[]{time, data[3], data[4], data[5], customer});  // https://www.youtube.com/watch?v=F0Zq2fAUpXg&t=243s
            }
            
        }
    }
    
    // https://stackoverflow.com/questions/43293581/jtabbedpane-action-performed
    ChangeListener changeListener = new ChangeListener() {
        public void stateChanged(ChangeEvent changeEvent) {
          JTabbedPane sourceTabbedPane = (JTabbedPane) changeEvent.getSource();
          int index = sourceTabbedPane.getSelectedIndex();
          
          // get date from search bar
          Date selectedDate = txtSearchWeek.getDate();
          
          // get the date of selected tab
          // https://stackoverflow.com/questions/2109145/how-to-get-first-day-of-a-given-week-number-in-java
          cal.clear();
          cal.setTime(selectedDate);  
          int todayIndex = cal.get(Calendar.DAY_OF_WEEK) - 1;
          cal.add(Calendar.DATE, index-todayIndex);
          Date date = cal.getTime();
          
          // get details from txtfile and display training details
          DefaultTableModel model = getTableModel(index, sdf.format(date));
          displayTimetable(model, sdf.format(date));
        }
    };
    
    int getSelectedRow(int index){
        int selectedRow = -1;
        
        switch(index){
            case 0: 
                //if no row is selected
                if (tbl0.getSelectionModel().isSelectionEmpty()){
                    JOptionPane.showMessageDialog(null, "Please select a row!", "Missing Input", JOptionPane.ERROR_MESSAGE);
                } else {
                    selectedRow = tbl0.getSelectedRow();
                    selectedDate = date0.getText();
                }
                break;
            case 1: 
                //if no row is selected
                if (tbl1.getSelectionModel().isSelectionEmpty()){
                    JOptionPane.showMessageDialog(null, "Please select a row!", "Missing Input", JOptionPane.ERROR_MESSAGE);
                } else {
                    selectedRow = tbl1.getSelectedRow();
                    selectedDate = date1.getText();
                }
                break;
            case 2: 
                //if no row is selected
                if (tbl2.getSelectionModel().isSelectionEmpty()){
                    JOptionPane.showMessageDialog(null, "Please select a row!", "Missing Input", JOptionPane.ERROR_MESSAGE);
                } else {
                    selectedRow = tbl2.getSelectedRow();
                    selectedDate = date2.getText();
                }
                break;
            case 3: 
                //if no row is selected
                if (tbl3.getSelectionModel().isSelectionEmpty()){
                    JOptionPane.showMessageDialog(null, "Please select a row!", "Missing Input", JOptionPane.ERROR_MESSAGE);
                } else {
                    selectedRow = tbl3.getSelectedRow();
                    selectedDate = date3.getText();
                }
                break;
            case 4: 
                //if no row is selected
                if (tbl4.getSelectionModel().isSelectionEmpty()){
                    JOptionPane.showMessageDialog(null, "Please select a row!", "Missing Input", JOptionPane.ERROR_MESSAGE);
                } else {
                    selectedRow = tbl4.getSelectedRow();
                    selectedDate = date4.getText();
                }
                break;
            case 5: 
                //if no row is selected
                if (tbl5.getSelectionModel().isSelectionEmpty()){
                    JOptionPane.showMessageDialog(null, "Please select a row!", "Missing Input", JOptionPane.ERROR_MESSAGE);
                } else {
                    selectedRow = tbl5.getSelectedRow();
                    selectedDate = date5.getText();
                }
                break;
            case 6: 
                //if no row is selected
                if (tbl6.getSelectionModel().isSelectionEmpty()){
                    JOptionPane.showMessageDialog(null, "Please select a row!", "Missing Input", JOptionPane.ERROR_MESSAGE);
                } else {
                    selectedRow = tbl6.getSelectedRow();
                    selectedDate = date6.getText();
                }
                break;
        }
        
        return selectedRow;
    }
    
    void collectPayment(int index, String date){
        try {
            // CUSTOMER make payment while booking training session, when trainer clicks COLLECT PAYMENT button, shows the msg "Payment is transferred to bank"
            
            // check if today is before the selected date (payment can only be collected for past days or today)
            if (new Date().before(sdf.parse(date))){
                JOptionPane.showMessageDialog(null, "Payment Collect UNSUCCESSFUL!\n\nFuture payment cannot be collected!", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                DefaultTableModel model = getTableModel(index, date);
                int selectedRow = getSelectedRow(index);
                
                if (selectedRow != -1){
                    String time = (String)model.getValueAt(selectedRow, 0);
                    int result = trainer.collectPayment(selectedDate, time);
                    
                    switch (result) {
                        // if record is updated
                        case 1:
                            JOptionPane.showMessageDialog(null, "Payment Collect Successful!\n\nPayment is transferred to bank!", 
                                    "Payment Collected", JOptionPane.INFORMATION_MESSAGE);
                            break;
                            // if payment has already collected
                        case -1:
                            JOptionPane.showMessageDialog(null, "Payment Collect UNSUCCESSFUL! \n\nPayment has been collected!", 
                                    "Error", JOptionPane.ERROR_MESSAGE);
                            break;
                        default:
                            JOptionPane.showMessageDialog(null, "Payment Collect UNSUCCESSFUL!\n\nPlease try again or contact the admin.", 
                                "Error", JOptionPane.ERROR_MESSAGE);
                            break;
                    }
                    
                }
            }
        } catch (ParseException ex) {
            Logger.getLogger(TrainerHome.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    void provideFeedback(int index, String date){
        try {
            // check if today is before the selected date (feedback can only be given for past classes)
            if (new Date().before(sdf.parse(date))){
                JOptionPane.showMessageDialog(null, "Feedback UNSUCCESSFUL!\n\nFeedbacks cannot be made on future sessions!", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                DefaultTableModel model = getTableModel(index, date);
                int selectedRow = getSelectedRow(index);
                
                if (selectedRow != -1){
                    String time = (String)model.getValueAt(selectedRow, 0);
                    String customerUsername = (String)model.getValueAt(selectedRow, 4);
                    customerUsername = customerUsername.split("@")[1];
                    int result = trainer.provideFeedback(today, selectedDate, time, customerUsername);
                    
                    switch (result) {
                        // if feedback is provided & not edited
                        case 0:
                            JOptionPane.showMessageDialog(null, "Existing Feedback is NOT edited.", "Feedback Not Edited", JOptionPane.INFORMATION_MESSAGE);
                            break;
                        // if new feedback is added
                        case 1:
                            JOptionPane.showMessageDialog(null, "New Feedback is Added Successfully!", "Feedback Added", JOptionPane.INFORMATION_MESSAGE);
                            break;
                        // if feedback is edited
                        case 2:
                            JOptionPane.showMessageDialog(null, "Existing Feedback is edited successfully!", "Feedback Edited", JOptionPane.INFORMATION_MESSAGE);
                            break;
                        default:
                            JOptionPane.showMessageDialog(null, "Feedback Provided UNSUCCESSFUL!\n\nPlease try again or contact the admin.", "Error", JOptionPane.ERROR_MESSAGE);
                            break;
                    }
                    
                }
            }
        } catch (ParseException ex) {
            Logger.getLogger(TrainerHome.class.getName()).log(Level.SEVERE, null, ex);
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

        jRadioButtonMenuItem1 = new javax.swing.JRadioButtonMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jPanelTitle = new javax.swing.JPanel();
        lblTitle = new javax.swing.JLabel();
        btnProfile = new javax.swing.JButton();
        btnLogout = new javax.swing.JButton();
        lblTimetable = new javax.swing.JLabel();
        Timetable = new javax.swing.JTabbedPane();
        jScrollPane0 = new javax.swing.JScrollPane();
        jPanel3 = new javax.swing.JPanel();
        date0 = new javax.swing.JLabel();
        jScrollPane9 = new javax.swing.JScrollPane();
        tbl0 = new javax.swing.JTable();
        btnPayment0 = new javax.swing.JButton();
        btnFeedback0 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel9 = new javax.swing.JPanel();
        date1 = new javax.swing.JLabel();
        jScrollPane14 = new javax.swing.JScrollPane();
        tbl1 = new javax.swing.JTable();
        btnPayment1 = new javax.swing.JButton();
        btnFeedback1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel8 = new javax.swing.JPanel();
        date2 = new javax.swing.JLabel();
        jScrollPane13 = new javax.swing.JScrollPane();
        tbl2 = new javax.swing.JTable();
        btnPayment2 = new javax.swing.JButton();
        btnFeedback2 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jPanel7 = new javax.swing.JPanel();
        date3 = new javax.swing.JLabel();
        jScrollPane12 = new javax.swing.JScrollPane();
        tbl3 = new javax.swing.JTable();
        btnPayment3 = new javax.swing.JButton();
        btnFeedback3 = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        jPanel6 = new javax.swing.JPanel();
        date4 = new javax.swing.JLabel();
        jScrollPane11 = new javax.swing.JScrollPane();
        tbl4 = new javax.swing.JTable();
        btnPayment4 = new javax.swing.JButton();
        btnFeeback4 = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane8 = new javax.swing.JScrollPane();
        tbl5 = new javax.swing.JTable();
        btnPayment5 = new javax.swing.JButton();
        btnFeedback5 = new javax.swing.JButton();
        date5 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        jPanel4 = new javax.swing.JPanel();
        date6 = new javax.swing.JLabel();
        jScrollPane10 = new javax.swing.JScrollPane();
        tbl6 = new javax.swing.JTable();
        btnFeedback6 = new javax.swing.JButton();
        btnPayment6 = new javax.swing.JButton();
        txtSearchWeek = new com.toedter.calendar.JDateChooser();
        btnViewPayment = new javax.swing.JButton();
        btnViewFeedback = new javax.swing.JButton();
        bgd = new javax.swing.JLabel();

        jRadioButtonMenuItem1.setSelected(true);
        jRadioButtonMenuItem1.setText("jRadioButtonMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Trainer Homepage");

        jPanel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel1.setMaximumSize(new java.awt.Dimension(950, 580));
        jPanel1.setMinimumSize(new java.awt.Dimension(950, 580));
        jPanel1.setPreferredSize(new java.awt.Dimension(950, 580));
        jPanel1.setLayout(null);

        jPanelTitle.setBackground(new java.awt.Color(255, 255, 204));

        lblTitle.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(0, 0, 139));
        lblTitle.setText("APU Gym Management System");

        btnProfile.setBackground(new java.awt.Color(153, 187, 255));
        btnProfile.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnProfile.setFocusable(false);
        btnProfile.setMaximumSize(new java.awt.Dimension(38, 38));
        btnProfile.setMinimumSize(new java.awt.Dimension(38, 38));
        btnProfile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProfileActionPerformed(evt);
            }
        });

        btnLogout.setBackground(new java.awt.Color(255, 0, 0));
        btnLogout.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        btnLogout.setForeground(new java.awt.Color(255, 255, 255));
        btnLogout.setText("LOGOUT");
        btnLogout.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnLogout.setFocusPainted(false);
        btnLogout.setFocusable(false);
        btnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelTitleLayout = new javax.swing.GroupLayout(jPanelTitle);
        jPanelTitle.setLayout(jPanelTitleLayout);
        jPanelTitleLayout.setHorizontalGroup(
            jPanelTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelTitleLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 172, Short.MAX_VALUE)
                .addComponent(btnProfile, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(btnLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );
        jPanelTitleLayout.setVerticalGroup(
            jPanelTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTitleLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanelTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnProfile, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTitle)
                    .addComponent(btnLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(97, 97, 97))
        );

        jPanel1.add(jPanelTitle);
        jPanelTitle.setBounds(0, 0, 950, 90);

        lblTimetable.setBackground(new java.awt.Color(255, 255, 255));
        lblTimetable.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        lblTimetable.setText("Timetable");
        jPanel1.add(lblTimetable);
        lblTimetable.setBounds(30, 150, 210, 44);

        date0.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        date0.setForeground(new java.awt.Color(0, 51, 255));
        date0.setText("Date");

        tbl0.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Time", "Duration (Hour)", "Venue", "Level", "Customer"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl0.setGridColor(new java.awt.Color(255, 255, 204));
        tbl0.setMinimumSize(new java.awt.Dimension(75, 40));
        jScrollPane9.setViewportView(tbl0);

        btnPayment0.setBackground(new java.awt.Color(0, 102, 204));
        btnPayment0.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnPayment0.setForeground(new java.awt.Color(255, 255, 255));
        btnPayment0.setText("Collect Payment");
        btnPayment0.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnPayment0.setFocusable(false);
        btnPayment0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPayment0ActionPerformed(evt);
            }
        });

        btnFeedback0.setBackground(new java.awt.Color(0, 102, 204));
        btnFeedback0.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnFeedback0.setForeground(new java.awt.Color(255, 255, 255));
        btnFeedback0.setText("Provide Feedback");
        btnFeedback0.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnFeedback0.setFocusable(false);
        btnFeedback0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFeedback0ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnPayment0, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnFeedback0, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 843, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(date0))))
                .addGap(0, 31, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(date0)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnFeedback0, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPayment0, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 86, Short.MAX_VALUE))
        );

        jScrollPane0.setViewportView(jPanel3);

        Timetable.addTab("Sunday", jScrollPane0);

        date1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        date1.setForeground(new java.awt.Color(0, 51, 255));
        date1.setText("Date");

        tbl1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Time", "Duration (Hour)", "Venue", "Level", "Customer"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl1.setGridColor(new java.awt.Color(255, 255, 204));
        tbl1.setMinimumSize(new java.awt.Dimension(75, 40));
        jScrollPane14.setViewportView(tbl1);

        btnPayment1.setBackground(new java.awt.Color(0, 102, 204));
        btnPayment1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnPayment1.setForeground(new java.awt.Color(255, 255, 255));
        btnPayment1.setText("Collect Payment");
        btnPayment1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnPayment1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPayment1ActionPerformed(evt);
            }
        });

        btnFeedback1.setBackground(new java.awt.Color(0, 102, 204));
        btnFeedback1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnFeedback1.setForeground(new java.awt.Color(255, 255, 255));
        btnFeedback1.setText("Provide Feedback");
        btnFeedback1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnFeedback1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFeedback1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnPayment1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnFeedback1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel9Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane14, javax.swing.GroupLayout.PREFERRED_SIZE, 843, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(date1))))
                .addGap(0, 18, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(date1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane14, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPayment1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnFeedback1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 90, Short.MAX_VALUE))
        );

        jScrollPane1.setViewportView(jPanel9);

        Timetable.addTab("Monday", jScrollPane1);

        date2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        date2.setForeground(new java.awt.Color(0, 51, 255));
        date2.setText("Date");

        tbl2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Time", "Duration (Hour)", "Venue", "Level", "Customer"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl2.setGridColor(new java.awt.Color(255, 255, 204));
        tbl2.setMinimumSize(new java.awt.Dimension(75, 40));
        jScrollPane13.setViewportView(tbl2);

        btnPayment2.setBackground(new java.awt.Color(0, 102, 204));
        btnPayment2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnPayment2.setForeground(new java.awt.Color(255, 255, 255));
        btnPayment2.setText("Collect Payment");
        btnPayment2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnPayment2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPayment2ActionPerformed(evt);
            }
        });

        btnFeedback2.setBackground(new java.awt.Color(0, 102, 204));
        btnFeedback2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnFeedback2.setForeground(new java.awt.Color(255, 255, 255));
        btnFeedback2.setText("Provide Feedback");
        btnFeedback2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnFeedback2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFeedback2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnPayment2, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnFeedback2, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel8Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane13, javax.swing.GroupLayout.PREFERRED_SIZE, 843, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(date2))))
                .addGap(0, 18, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(date2)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane13, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPayment2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnFeedback2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 87, Short.MAX_VALUE))
        );

        jScrollPane2.setViewportView(jPanel8);

        Timetable.addTab("Tuesday", jScrollPane2);

        date3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        date3.setForeground(new java.awt.Color(0, 51, 255));
        date3.setText("Date");

        tbl3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Time", "Duration (Hour)", "Venue", "Level", "Customer"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl3.setGridColor(new java.awt.Color(255, 255, 204));
        tbl3.setMinimumSize(new java.awt.Dimension(75, 40));
        jScrollPane12.setViewportView(tbl3);

        btnPayment3.setBackground(new java.awt.Color(0, 102, 204));
        btnPayment3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnPayment3.setForeground(new java.awt.Color(255, 255, 255));
        btnPayment3.setText("Collect Payment");
        btnPayment3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnPayment3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPayment3ActionPerformed(evt);
            }
        });

        btnFeedback3.setBackground(new java.awt.Color(0, 102, 204));
        btnFeedback3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnFeedback3.setForeground(new java.awt.Color(255, 255, 255));
        btnFeedback3.setText("Provide Feedback");
        btnFeedback3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnFeedback3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFeedback3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnPayment3, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnFeedback3, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel7Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, 843, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(date3))))
                .addGap(0, 31, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(date3)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPayment3, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnFeedback3, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 83, Short.MAX_VALUE))
        );

        jScrollPane3.setViewportView(jPanel7);

        Timetable.addTab("Wednesday", jScrollPane3);

        date4.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        date4.setForeground(new java.awt.Color(0, 51, 255));
        date4.setText("Date");

        tbl4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Time", "Duration (Hour)", "Venue", "Level", "Customer"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl4.setGridColor(new java.awt.Color(255, 255, 204));
        tbl4.setMinimumSize(new java.awt.Dimension(75, 40));
        jScrollPane11.setViewportView(tbl4);

        btnPayment4.setBackground(new java.awt.Color(0, 102, 204));
        btnPayment4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnPayment4.setForeground(new java.awt.Color(255, 255, 255));
        btnPayment4.setText("Collect Payment");
        btnPayment4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnPayment4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPayment4ActionPerformed(evt);
            }
        });

        btnFeeback4.setBackground(new java.awt.Color(0, 102, 204));
        btnFeeback4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnFeeback4.setForeground(new java.awt.Color(255, 255, 255));
        btnFeeback4.setText("Provide Feedback");
        btnFeeback4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnFeeback4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFeeback4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(btnPayment4, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnFeeback4, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 843, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(date4)))
                .addGap(0, 31, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(date4)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnFeeback4, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPayment4, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 88, Short.MAX_VALUE))
        );

        jScrollPane4.setViewportView(jPanel6);

        Timetable.addTab("Thursday", jScrollPane4);

        tbl5.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Time", "Duration (Hour)", "Venue", "Level", "Customer"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl5.setGridColor(new java.awt.Color(255, 255, 204));
        tbl5.setMinimumSize(new java.awt.Dimension(75, 40));
        jScrollPane8.setViewportView(tbl5);

        btnPayment5.setBackground(new java.awt.Color(0, 102, 204));
        btnPayment5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnPayment5.setForeground(new java.awt.Color(255, 255, 255));
        btnPayment5.setText("Collect Payment");
        btnPayment5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnPayment5.setFocusable(false);
        btnPayment5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPayment5ActionPerformed(evt);
            }
        });

        btnFeedback5.setBackground(new java.awt.Color(0, 102, 204));
        btnFeedback5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnFeedback5.setForeground(new java.awt.Color(255, 255, 255));
        btnFeedback5.setText("Provide Feedback");
        btnFeedback5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnFeedback5.setFocusable(false);
        btnFeedback5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFeedback5ActionPerformed(evt);
            }
        });

        date5.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        date5.setForeground(new java.awt.Color(0, 51, 255));
        date5.setText("Date");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(date5)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 843, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(btnPayment5, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(btnFeedback5, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(0, 31, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(date5)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnFeedback5, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPayment5, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(107, Short.MAX_VALUE))
        );

        jScrollPane5.setViewportView(jPanel2);

        Timetable.addTab("Friday", jScrollPane5);

        date6.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        date6.setForeground(new java.awt.Color(0, 51, 255));
        date6.setText("Date");

        tbl6.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Time", "Duration (Hour)", "Venue", "Level", "Customer"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl6.setGridColor(new java.awt.Color(255, 255, 204));
        tbl6.setMinimumSize(new java.awt.Dimension(75, 40));
        jScrollPane10.setViewportView(tbl6);

        btnFeedback6.setBackground(new java.awt.Color(0, 102, 204));
        btnFeedback6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnFeedback6.setForeground(new java.awt.Color(255, 255, 255));
        btnFeedback6.setText("Provide Feedback");
        btnFeedback6.setToolTipText("");
        btnFeedback6.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnFeedback6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFeedback6ActionPerformed(evt);
            }
        });

        btnPayment6.setBackground(new java.awt.Color(0, 102, 204));
        btnPayment6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnPayment6.setForeground(new java.awt.Color(255, 255, 255));
        btnPayment6.setText("Collect Payment");
        btnPayment6.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnPayment6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPayment6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(btnPayment6, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnFeedback6, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 843, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(date6)))
                .addGap(0, 31, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(date6)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnFeedback6, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPayment6, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 83, Short.MAX_VALUE))
        );

        jScrollPane6.setViewportView(jPanel4);

        Timetable.addTab("Saturday", jScrollPane6);

        jPanel1.add(Timetable);
        Timetable.setBounds(20, 220, 910, 350);

        txtSearchWeek.setFocusable(false);
        txtSearchWeek.setRequestFocusEnabled(false);
        txtSearchWeek.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                txtSearchWeekPropertyChange(evt);
            }
        });
        jPanel1.add(txtSearchWeek);
        txtSearchWeek.setBounds(780, 190, 150, 30);

        btnViewPayment.setBackground(new java.awt.Color(0, 102, 204));
        btnViewPayment.setForeground(new java.awt.Color(255, 255, 255));
        btnViewPayment.setText("VIEW PAYMENT");
        btnViewPayment.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnViewPayment.setFocusable(false);
        btnViewPayment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewPaymentActionPerformed(evt);
            }
        });
        jPanel1.add(btnViewPayment);
        btnViewPayment.setBounds(620, 110, 150, 40);

        btnViewFeedback.setBackground(new java.awt.Color(0, 102, 204));
        btnViewFeedback.setForeground(new java.awt.Color(255, 255, 255));
        btnViewFeedback.setText("VIEW FEEDBACK");
        btnViewFeedback.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnViewFeedback.setFocusable(false);
        btnViewFeedback.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewFeedbackActionPerformed(evt);
            }
        });
        jPanel1.add(btnViewFeedback);
        btnViewFeedback.setBounds(780, 110, 150, 40);

        bgd.setText("jLabel1");
        bgd.setMaximumSize(new java.awt.Dimension(950, 580));
        bgd.setMinimumSize(new java.awt.Dimension(950, 580));
        bgd.setOpaque(true);
        bgd.setPreferredSize(new java.awt.Dimension(950, 580));
        jPanel1.add(bgd);
        bgd.setBounds(0, 0, 950, 580);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
        // confirm logout dialog
        int reply = JOptionPane.showConfirmDialog(null, "Do you want to Logout?", "Logout Confirmation", JOptionPane.YES_NO_OPTION);
        
        if (reply == JOptionPane.YES_OPTION){
            this.dispose();
            Login login = new Login();
            login.setVisible(true);
        }
    }//GEN-LAST:event_btnLogoutActionPerformed

    private void btnProfileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProfileActionPerformed
        // transfer to Profile page
        this.dispose();
        TrainerProfile tp = new TrainerProfile();
        tp.setVisible(true);
    }//GEN-LAST:event_btnProfileActionPerformed

    private void btnPayment5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPayment5ActionPerformed
        collectPayment(5, date5.getText());
    }//GEN-LAST:event_btnPayment5ActionPerformed

    private void btnFeedback5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFeedback5ActionPerformed
        provideFeedback(5, date5.getText());
    }//GEN-LAST:event_btnFeedback5ActionPerformed

    private void btnPayment3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPayment3ActionPerformed
        collectPayment(3, date3.getText());
    }//GEN-LAST:event_btnPayment3ActionPerformed

    private void btnFeedback3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFeedback3ActionPerformed
        provideFeedback(3, date3.getText());
    }//GEN-LAST:event_btnFeedback3ActionPerformed

    private void btnFeedback2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFeedback2ActionPerformed
        provideFeedback(2, date2.getText());
    }//GEN-LAST:event_btnFeedback2ActionPerformed

    private void btnFeedback0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFeedback0ActionPerformed
        provideFeedback(0, date0.getText());
    }//GEN-LAST:event_btnFeedback0ActionPerformed

    private void btnPayment0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPayment0ActionPerformed
        collectPayment(0, date0.getText());
    }//GEN-LAST:event_btnPayment0ActionPerformed

    private void btnPayment1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPayment1ActionPerformed
        collectPayment(1, date1.getText());
    }//GEN-LAST:event_btnPayment1ActionPerformed

    private void btnPayment2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPayment2ActionPerformed
        collectPayment(2, date2.getText());
    }//GEN-LAST:event_btnPayment2ActionPerformed

    private void btnPayment4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPayment4ActionPerformed
        collectPayment(4, date4.getText());
    }//GEN-LAST:event_btnPayment4ActionPerformed

    private void btnPayment6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPayment6ActionPerformed
        collectPayment(6, date6.getText());
    }//GEN-LAST:event_btnPayment6ActionPerformed

    private void btnFeedback1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFeedback1ActionPerformed
        provideFeedback(1, date1.getText());
    }//GEN-LAST:event_btnFeedback1ActionPerformed

    private void btnFeeback4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFeeback4ActionPerformed
        provideFeedback(4, date4.getText());
    }//GEN-LAST:event_btnFeeback4ActionPerformed

    private void btnFeedback6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFeedback6ActionPerformed
        provideFeedback(6, date6.getText());
    }//GEN-LAST:event_btnFeedback6ActionPerformed

    private void txtSearchWeekPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_txtSearchWeekPropertyChange
        // get selected date
        Date selectedDate = txtSearchWeek.getDate();
        
        if (selectedDate != null){
            cal.clear();
            cal.setTime(selectedDate);
            int index = cal.get(Calendar.DAY_OF_WEEK) - 1;

            // select the respective tab based on the selected date's day
            Timetable.setSelectedIndex(index);
            
            // clear previous content in all table
            clearTableContent();
            
            // display timetable for the selected date
            DefaultTableModel model = getTableModel(index, sdf.format(selectedDate));
            displayTimetable(model, sdf.format(selectedDate));
        }
    }//GEN-LAST:event_txtSearchWeekPropertyChange

    private void btnViewPaymentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewPaymentActionPerformed
        // transfer to View Payment page
        this.dispose();
        TrainerViewPayment tvp = new TrainerViewPayment();
        tvp.setVisible(true);
    }//GEN-LAST:event_btnViewPaymentActionPerformed

    private void btnViewFeedbackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewFeedbackActionPerformed
        // transfer to View Feedback page
        this.dispose();
        TrainerViewFeedback tvf = new TrainerViewFeedback();
        tvf.setVisible(true);
    }//GEN-LAST:event_btnViewFeedbackActionPerformed

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
            java.util.logging.Logger.getLogger(TrainerHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TrainerHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TrainerHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TrainerHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TrainerHome().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane Timetable;
    private javax.swing.JLabel bgd;
    private javax.swing.JButton btnFeeback4;
    private javax.swing.JButton btnFeedback0;
    private javax.swing.JButton btnFeedback1;
    private javax.swing.JButton btnFeedback2;
    private javax.swing.JButton btnFeedback3;
    private javax.swing.JButton btnFeedback5;
    private javax.swing.JButton btnFeedback6;
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnPayment0;
    private javax.swing.JButton btnPayment1;
    private javax.swing.JButton btnPayment2;
    private javax.swing.JButton btnPayment3;
    private javax.swing.JButton btnPayment4;
    private javax.swing.JButton btnPayment5;
    private javax.swing.JButton btnPayment6;
    private javax.swing.JButton btnProfile;
    private javax.swing.JButton btnViewFeedback;
    private javax.swing.JButton btnViewPayment;
    private javax.swing.JLabel date0;
    private javax.swing.JLabel date1;
    private javax.swing.JLabel date2;
    private javax.swing.JLabel date3;
    private javax.swing.JLabel date4;
    private javax.swing.JLabel date5;
    private javax.swing.JLabel date6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JPanel jPanelTitle;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItem1;
    private javax.swing.JScrollPane jScrollPane0;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane14;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JLabel lblTimetable;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JTable tbl0;
    private javax.swing.JTable tbl1;
    private javax.swing.JTable tbl2;
    private javax.swing.JTable tbl3;
    private javax.swing.JTable tbl4;
    private javax.swing.JTable tbl5;
    private javax.swing.JTable tbl6;
    private com.toedter.calendar.JDateChooser txtSearchWeek;
    // End of variables declaration//GEN-END:variables
}
