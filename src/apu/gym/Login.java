/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apu.gym;

import java.awt.Color;
import javax.swing.*;

/**
 *
 * @author Pekyen
 */
public class Login extends javax.swing.JFrame {

    String name, username, password, role;
    
    public Login() {
        initComponents();
        
        // icon to display APU logo for JFrame
        ImageIcon icon = new ImageIcon("src/apu/gym/images/logo.png"); // https://www.youtube.com/watch?v=Kmgo00avvEw
        setIconImage(icon.getImage());
        
        // icon to display background
        ImageIcon iconBgd = new ImageIcon("src/apu/gym/images/bgd.png"); // https://www.youtube.com/watch?v=Kmgo00avvEw
        bgd.setIcon(iconBgd);
        
        // display user icon
        ImageIcon iconUser = new ImageIcon("src/apu/gym/images/user.png"); // https://www.youtube.com/watch?v=Kmgo00avvEw
        jLabel2.setIcon(iconUser);
        
        // display username icon
        ImageIcon iconUsername = new ImageIcon("src/apu/gym/images/username.png"); // https://www.youtube.com/watch?v=Kmgo00avvEw
        jLabel4.setIcon(iconUsername);
        
        // display password icon
        ImageIcon iconPass = new ImageIcon("src/apu/gym/images/password.png"); // https://www.youtube.com/watch?v=Kmgo00avvEw
        jLabel5.setIcon(iconPass);
        
        jPanel2.setFocusable(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btngrpUser = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        txtPassword = new javax.swing.JPasswordField();
        chkViewPassword = new javax.swing.JCheckBox();
        btnLogin = new javax.swing.JButton();
        radManager = new javax.swing.JRadioButton();
        radTrainer = new javax.swing.JRadioButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        radCustomer = new javax.swing.JRadioButton();
        bgd = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("User Login");
        setResizable(false);

        jPanel1.setLayout(null);

        jPanel3.setBackground(new java.awt.Color(255, 255, 153));

        jLabel3.setBackground(new java.awt.Color(255, 255, 204));
        jLabel3.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 139));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("APU Gym Management System");
        jLabel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 204)));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel3);
        jPanel3.setBounds(140, 30, 400, 40);

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        txtUsername.setBackground(new java.awt.Color(176, 196, 222));
        txtUsername.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        txtUsername.setForeground(new java.awt.Color(255, 255, 255));
        txtUsername.setText("Username");
        txtUsername.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        txtUsername.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtUsernameFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtUsernameFocusLost(evt);
            }
        });

        txtPassword.setBackground(new java.awt.Color(176, 196, 222));
        txtPassword.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        txtPassword.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

        chkViewPassword.setBackground(new java.awt.Color(176, 196, 222));
        chkViewPassword.setText("View Password");
        chkViewPassword.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        chkViewPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkViewPasswordActionPerformed(evt);
            }
        });

        btnLogin.setBackground(new java.awt.Color(255, 255, 153));
        btnLogin.setFont(new java.awt.Font("Segoe UI Semibold", 1, 16)); // NOI18N
        btnLogin.setForeground(new java.awt.Color(0, 0, 139));
        btnLogin.setText("LOGIN");
        btnLogin.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 255, 102)));
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });

        radManager.setBackground(new java.awt.Color(176, 196, 222));
        btngrpUser.add(radManager);
        radManager.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        radManager.setText("Manager");

        radTrainer.setBackground(new java.awt.Color(176, 196, 222));
        btngrpUser.add(radTrainer);
        radTrainer.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        radTrainer.setText("Trainer");

        jLabel4.setText("jLabel4");

        jLabel5.setText("jLabel5");

        radCustomer.setBackground(new java.awt.Color(176, 196, 222));
        btngrpUser.add(radCustomer);
        radCustomer.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        radCustomer.setText("Customer");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(46, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnLogin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtPassword)
                    .addComponent(txtUsername)
                    .addComponent(chkViewPassword, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE))
                .addGap(66, 66, 66))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(164, 164, 164)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(radManager, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(radTrainer, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(radCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(chkViewPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(radTrainer)
                    .addComponent(radManager, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(radCustomer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(32, 32, 32)
                .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(114, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2);
        jPanel2.setBounds(140, 50, 400, 380);

        bgd.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1.add(bgd);
        bgd.setBounds(0, 0, 700, 500);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 700, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 499, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void chkViewPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkViewPasswordActionPerformed
        if (chkViewPassword.isSelected()){
            // unmask password
            txtPassword.setEchoChar((char)0);
        } else {
            // mask password
            txtPassword.setEchoChar('*');
        }
    }//GEN-LAST:event_chkViewPasswordActionPerformed

    private void txtUsernameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtUsernameFocusGained
        // insert placeholder
        if (txtUsername.getText().trim().equals("Username")){
            txtUsername.setText("");
            txtUsername.setForeground(new Color(0,0,0));
        }
    }//GEN-LAST:event_txtUsernameFocusGained

    private void txtUsernameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtUsernameFocusLost
        if (txtUsername.getText().trim().equals("")){
            txtUsername.setText("Username");
            txtUsername.setForeground(new Color(255,255,255));
        }
    }//GEN-LAST:event_txtUsernameFocusLost

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        
        username = txtUsername.getText();
        password = String.valueOf(txtPassword.getPassword());
        
        // get user role according to the radio buttons
        if (radManager.isSelected() == true){
            role = "Manager";
        } else if (radTrainer.isSelected() == true){
            role = "Trainer";
        } else if (radCustomer.isSelected() == true){
            role = "Customer";
        }
        ButtonModel btnRole = btngrpUser.getSelection();
        
        // check for empty input
        if (username.trim().equals("Username") || password.length() <= 0){
            JOptionPane.showMessageDialog(this, "Please enter valid username or password." , 
                    "Empty Input", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        if (btnRole == null){
            JOptionPane.showMessageDialog(this, "Please select the user role." , "Empty Role", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        // check whether the username match with password
        if(username.trim().length()>0 && password.length() > 0){
            
            //return true for login in user
            if(User.login(username, password, role)){
                JOptionPane.showMessageDialog(this, "Nice to see you in APU Gym Management, " + role + " " + 
                        username + "!" , "Login Successful", JOptionPane.INFORMATION_MESSAGE);
                
                if(role.equals("Manager")){
                   new ManagerDashboard().setVisible(true);
                }
                
                if(role.equals("Trainer")){
                   new TrainerHome().setVisible(true);
                }
                
                if(role.equals("Customer")){
                    new CustomerHome().setVisible(true);
                }
                
                this.dispose();
            }
            
        }
        
    }//GEN-LAST:event_btnLoginActionPerformed

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bgd;
    private javax.swing.JButton btnLogin;
    private javax.swing.ButtonGroup btngrpUser;
    private javax.swing.JCheckBox chkViewPassword;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JRadioButton radCustomer;
    private javax.swing.JRadioButton radManager;
    private javax.swing.JRadioButton radTrainer;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}
