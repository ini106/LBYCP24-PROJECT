/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pokemon;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.*;

/**
 *
 * @author Johann Carta
 */
public class PokemonBattle extends javax.swing.JFrame {

    /**
     * Creates new form PokemonBattle
     */
    int[] pokemonlist = {1,4,7,25,144,145};
    int[] lives = {100,100,100,100,100,100};
    public int current_pokemon = 0;//array index, zero based 0-5 only, first pokemon = 0, second =1 and so on.
    String[] trainers = {"alder", "brycen", "cynthia", "cilan", "iris", "drayden"};
    int counter_enemy = 0;
    String user;
    public PokemonBattle() throws SQLException {
        initComponents();
        lifeBarProgressBar.setValue(100);
        Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation((size.width-this.getSize().width)/2,(size.height-this.getSize().height)/2);
    }
    public PokemonBattle(String user) throws SQLException {
        this.user = user;
        initComponents();
        lifeBarProgressBar.setValue(100);
        Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
        initPokemon(user,0);
        this.setLocation((size.width-this.getSize().width)/2,(size.height-this.getSize().height)/2);
        jButton2.setVisible(false);
    }

    /*
    NOTE!
    This is an example on how you change the png file:
    
        ImageIcon bbry = new ImageIcon(getClass().getResource("/Pokemon-Java/Female.png"));
        jLabel1.setIcon(bbry);
    */
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        attack1 = new javax.swing.JButton();
        attack2 = new javax.swing.JButton();
        attack3 = new javax.swing.JButton();
        attack4 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        pokemonImage = new javax.swing.JLabel();
        enemy = new javax.swing.JLabel();
        lifeBarProgressBar = new javax.swing.JProgressBar();
        lifeBarLabel = new javax.swing.JLabel();
        pokemon_enemy = new javax.swing.JLabel();
        jProgressBar1 = new javax.swing.JProgressBar();
        enemylife = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jButton1.setText("Switch");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Next Enemy");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Attack");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        attack1.setText("Attack1");

        attack2.setText("Attack2");

        attack3.setText("Attack3");

        attack4.setText("Attack4");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(attack1)
                    .addComponent(attack2))
                .addGap(110, 110, 110)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(attack4)
                    .addComponent(attack3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 141, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(attack1)
                    .addComponent(attack3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(attack4)
                    .addComponent(attack2))
                .addContainerGap())
        );

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pokemon-Java/Male.png"))); // NOI18N

        pokemonImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pokemon-Java/Pokemon_Back/25.png"))); // NOI18N

        enemy.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pokemon-Java/alder.png"))); // NOI18N

        lifeBarProgressBar.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                lifeBarProgressBarStateChanged(evt);
            }
        });

        lifeBarLabel.setText("jLabel2");

        pokemon_enemy.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pokemon-Java/Pokemon_Front/4.png"))); // NOI18N

        enemylife.setText("enemylife");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pokemon_enemy)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(enemy)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pokemonImage))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lifeBarProgressBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lifeBarLabel)
                            .addComponent(enemylife))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(enemy)
                            .addComponent(pokemon_enemy)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(enemylife)
                            .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lifeBarProgressBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lifeBarLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pokemonImage)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        PokemonSwitch switcher = new PokemonSwitch(pokemonlist, lives,current_pokemon,this);
        switcher.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed
    
    
private void changeUserPokemonImage(int number){
        ImageIcon bbry = new ImageIcon(getClass().getResource("/Pokemon-Java/Pokemon_Back/"+number+".png" ));
        pokemonImage.setIcon(bbry);
    }
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        jButton1.setVisible(false);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void lifeBarProgressBarStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_lifeBarProgressBarStateChanged
        // TODO add your handling code here:
        lifeBarLabel.setText(lifeBarProgressBar.getValue()+"");
    }//GEN-LAST:event_lifeBarProgressBarStateChanged

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        counter_enemy++;
        ImageIcon bbry = new ImageIcon(getClass().getResource("/Pokemon-Java/"+ trainers[counter_enemy] +".png" ));
        enemy.setIcon(bbry);
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(PokemonBattle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PokemonBattle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PokemonBattle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PokemonBattle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new PokemonBattle().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(PokemonBattle.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton attack1;
    private javax.swing.JButton attack2;
    private javax.swing.JButton attack3;
    private javax.swing.JButton attack4;
    private javax.swing.JLabel enemy;
    private javax.swing.JLabel enemylife;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JLabel lifeBarLabel;
    private javax.swing.JProgressBar lifeBarProgressBar;
    private javax.swing.JLabel pokemonImage;
    private javax.swing.JLabel pokemon_enemy;
    // End of variables declaration//GEN-END:variables

    private void initPokemon(String user, int pokemon_order) throws SQLException {
        System.out.println("marker");
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pokemon_user?" + "user=root&password=");
            PreparedStatement pst = conn.prepareStatement("Select * from login where username = ?");
             pst.setString(1, user);
            ResultSet rs = pst.executeQuery();
            rs.next();
            for (int i = 1; i <= 6; i++) {
                pokemonlist[i-1]=Integer.parseInt(rs.getString("pokemon"+i));
                System.out.println(pokemonlist[i-1]);
            }
        } catch (Exception e) {
            System.out.println("Error");
        }
        try {
            //select from user database to get the pokemon list
            //select the first pokemon, then display it.
             
            int pokemonNumber =pokemon_order;
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pokemon?" + "user=root&password=");
            
            
            PreparedStatement pst = conn.prepareStatement("Select * from moves where Number = ?");
             pst.setString(1,pokemonlist[pokemonNumber]+"");
            ResultSet rs = pst.executeQuery();
            rs.next();
            attack1.setText(rs.getString("attack1"));
            attack2.setText(rs.getString("attack2"));
            attack3.setText(rs.getString("attack3"));
            attack4.setText(rs.getString("attack4"));
            changeUserPokemonImage(pokemonlist[pokemonNumber]);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PokemonBattle.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }

    void setPokemon(int current_pokemon) throws SQLException {
        initPokemon(user, current_pokemon);
    }

    
}
