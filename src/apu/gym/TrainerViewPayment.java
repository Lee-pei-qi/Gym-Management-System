/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package apu.gym;

import static apu.gym.Customer.customer;
import static apu.gym.Feedback.feedback;
import static apu.gym.Trainer.trainer;
import static apu.gym.User.user;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Acer
 */
public class TrainerViewPayment extends javax.swing.JFrame {
    
    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
    Calendar cal = Calendar.getInstance();
    String allPayment;
    
    /**
     * Creates new form TrainerViewPayment
     */
    public TrainerViewPayment() {
        initComponents();
        
        // icon to display APU logo for JFrame
        ImageIcon icon = new ImageIcon("src/apu/gym/images/logo.png"); // https://www.youtube.com/watch?v=Kmgo00avvEw
        setIconImage(icon.getImage());
        
        // icon to display background
        ImageIcon iconBgd = new ImageIcon("src/apu/gym/images/bgd.png"); // https://www.youtube.com/watch?v=Kmgo00avvEw
        bgd.setIcon(iconBgd);
        
        allPayment = new Payment().getPayment(user.getUsername());
        displayPayment(allPayment);
    }
    
    private void displayPayment(String paymentStr){
        DefaultTableModel model = (DefaultTableModel)tblPayment.getModel();
        model.setRowCount(0);  // remove previous records in table
        
        if (!paymentStr.equals("")){
            String[] payments = paymentStr.split("\n");  // split string into arrays of payments
            
            for (String payment : payments) {
                String[] data = payment.split(";");
                model.addRow(new Object[]{data[3], data[4], data[5], data[2], data[8], data[7]});  // https://www.youtube.com/watch?v=F0Zq2fAUpXg&t=243s
            }
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
        jPanelTitle = new javax.swing.JPanel();
        lblTitle = new javax.swing.JLabel();
        btnLogout = new javax.swing.JButton();
        lblPayment = new javax.swing.JLabel();
        jScrollPane9 = new javax.swing.JScrollPane();
        tblPayment = new javax.swing.JTable();
        btnBack = new javax.swing.JButton();
        txtSearch = new com.toedter.calendar.JDateChooser();
        btnClear = new javax.swing.JButton();
        btnCollect = new javax.swing.JButton();
        bgd = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Trainer View Payment");
        setMaximumSize(new java.awt.Dimension(950, 580));
        setMinimumSize(new java.awt.Dimension(950, 580));
        setSize(new java.awt.Dimension(950, 580));
        getContentPane().setLayout(null);

        jPanel1.setMaximumSize(new java.awt.Dimension(950, 580));
        jPanel1.setMinimumSize(new java.awt.Dimension(950, 580));
        jPanel1.setPreferredSize(new java.awt.Dimension(950, 580));
        jPanel1.setLayout(null);

        jPanelTitle.setBackground(new java.awt.Color(255, 255, 204));

        lblTitle.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(0, 0, 139));
        lblTitle.setText("APU Gym Management System");

        btnLogout.setBackground(new java.awt.Color(255, 0, 0));
        btnLogout.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        btnLogout.setForeground(new java.awt.Color(255, 255, 255));
        btnLogout.setText("LOGOUT");
        btnLogout.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnLogout.setFocusPainted(false);
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 244, Short.MAX_VALUE)
                .addComponent(btnLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
        );
        jPanelTitleLayout.setVerticalGroup(
            jPanelTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTitleLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanelTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTitle)
                    .addComponent(btnLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30))
        );

        jPanel1.add(jPanelTitle);
        jPanelTitle.setBounds(0, 0, 950, 90);

        lblPayment.setBackground(new java.awt.Color(255, 255, 255));
        lblPayment.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        lblPayment.setText("Payment");
        jPanel1.add(lblPayment);
        lblPayment.setBounds(30, 110, 210, 44);

        tblPayment.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Session Date", "Session Time", "Customer", "Amount", "Status", "Collected Date"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblPayment.setGridColor(new java.awt.Color(255, 255, 204));
        tblPayment.setMinimumSize(new java.awt.Dimension(75, 40));
        jScrollPane9.setViewportView(tblPayment);

        jPanel1.add(jScrollPane9);
        jScrollPane9.setBounds(20, 170, 900, 280);

        btnBack.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnBack.setText("BACK");
        btnBack.setToolTipText("");
        btnBack.setActionCommand("Back");
        btnBack.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnBack.setFocusable(false);
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        jPanel1.add(btnBack);
        btnBack.setBounds(650, 470, 110, 40);

        txtSearch.setFocusable(false);
        txtSearch.setRequestFocusEnabled(false);
        txtSearch.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                txtSearchPropertyChange(evt);
            }
        });
        jPanel1.add(txtSearch);
        txtSearch.setBounds(640, 120, 180, 30);

        btnClear.setBackground(new java.awt.Color(255, 255, 153));
        btnClear.setText("Clear");
        btnClear.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnClear.setFocusable(false);
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });
        jPanel1.add(btnClear);
        btnClear.setBounds(830, 120, 90, 29);

        btnCollect.setBackground(new java.awt.Color(0, 102, 204));
        btnCollect.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnCollect.setForeground(new java.awt.Color(255, 255, 255));
        btnCollect.setText("COLLECT");
        btnCollect.setToolTipText("");
        btnCollect.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnCollect.setFocusable(false);
        btnCollect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCollectActionPerformed(evt);
            }
        });
        jPanel1.add(btnCollect);
        btnCollect.setBounds(780, 470, 140, 40);

        bgd.setText("jLabel1");
        bgd.setMaximumSize(new java.awt.Dimension(950, 580));
        bgd.setMinimumSize(new java.awt.Dimension(950, 580));
        bgd.setPreferredSize(new java.awt.Dimension(950, 580));
        jPanel1.add(bgd);
        bgd.setBounds(0, 1, 950, 580);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 950, 580);

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

    private void txtSearchPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_txtSearchPropertyChange
        // get selected date
        Date selectedDate = txtSearch.getDate();
        
        if (selectedDate != null){
            cal.clear();
            cal.setTime(selectedDate);
            
            // display payment details for the selected date
            String payment = new Payment().getPayment(user.getUsername(), sdf.format(selectedDate));
            displayPayment(payment);
        }
    }//GEN-LAST:event_txtSearchPropertyChange

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        txtSearch.setCalendar(null);  // remove selected date
        displayPayment(allPayment);  // display all payments
    }//GEN-LAST:event_btnClearActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // back to Homepage
        this.dispose();
        TrainerHome th = new TrainerHome();
        th.setVisible(true);
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnCollectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCollectActionPerformed
        DefaultTableModel model = (DefaultTableModel)tblPayment.getModel();

        if (tblPayment.getSelectionModel().isSelectionEmpty()){
            JOptionPane.showMessageDialog(null, "Please select a row!", "Missing Input", JOptionPane.ERROR_MESSAGE);
        } else {
            try {
                int selectedRow = tblPayment.getSelectedRow();
                String date = (String)model.getValueAt(selectedRow, 0);
                
                // check if today is before the selected date (payment can only be collected for past days or today)
                if (new Date().before(sdf.parse(date))){
                    JOptionPane.showMessageDialog(null, "Payment Collect UNSUCCESSFUL!\n\nFuture payment cannot be collected!", "Error", JOptionPane.ERROR_MESSAGE);
                }
                else {
                    String time = (String)model.getValueAt(selectedRow, 1);
                    int result = trainer.collectPayment(date, time);
                    
                    switch (result) {
                        // if record is updated
                        case 1:
                            JOptionPane.showMessageDialog(null, "Payment Collect Successful!\n\nPayment is transferred to bank!", 
                                    "Payment Collected", JOptionPane.INFORMATION_MESSAGE);
                            // refresh data in table
                            allPayment = new Payment().getPayment(user.getUsername());
                            displayPayment(allPayment);
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
                
            } catch (ParseException ex) {
                Logger.getLogger(CustomerHome.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnCollectActionPerformed

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
            java.util.logging.Logger.getLogger(TrainerViewPayment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TrainerViewPayment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TrainerViewPayment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TrainerViewPayment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TrainerViewPayment().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bgd;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnCollect;
    private javax.swing.JButton btnLogout;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanelTitle;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JLabel lblPayment;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JTable tblPayment;
    private com.toedter.calendar.JDateChooser txtSearch;
    // End of variables declaration//GEN-END:variables
}
