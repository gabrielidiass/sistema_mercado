/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package view;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle;
import model.Cliente;
import model.dao.Util;

public class CadastroClienteJD extends javax.swing.JDialog {
    private Cliente cliente;

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    public CadastroClienteJD(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    // Generated using JFormDesigner Evaluation license - unknown
    private void initComponents() {
        jLabel1 = new JLabel();
        lblNome = new JLabel();
        txtNome = new JTextField();
        jLabel2 = new JLabel();
        txtCPF = new JTextField();
        btnSalvar = new JButton();
        btnCancelar = new JButton();

        //======== this ========
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        var contentPane = getContentPane();

        //---- jLabel1 ----
        jLabel1.setText("Cadastro de Cliente");

        //---- lblNome ----
        lblNome.setText("Nome");

        //---- jLabel2 ----
        jLabel2.setText("CPF");

        //---- btnSalvar ----
        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(e -> btnSalvarActionPerformed(e));

        //---- btnCancelar ----
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(e -> btnCancelarActionPerformed(e));

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);

        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup().addGroup(contentPaneLayout.createSequentialGroup().addContainerGap().addComponent(jLabel1).addGap(18, 18, 18).addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(lblNome).addComponent(txtNome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(jLabel2).addComponent(txtCPF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)).addGap(18, 18, 18).addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 120, Short.MAX_VALUE).addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(btnSalvar).addComponent(btnCancelar)).addGap(28, 28, 28))
        );
        pack();
        setLocationRelativeTo(getOwner());
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        
        if(cliente == null)
            cliente = new Cliente();
        
        try{
            String cpf = txtCPF.getText().replace(".", "").replace("-", "");
            this.cliente.setNome(txtNome.getText().trim());
            if(Util.validaCPF(cpf)){
                this.cliente.setCPF(cpf);
            } else {
                return;
            }
            
            this.dispose();
        } catch (DateTimeParseException e1){
            cliente = null;
            JOptionPane.showMessageDialog(rootPane, "Data inválida!! Informe data no formato dd-mm-yyyy\n"+e1);
        }  catch (Exception e3){
            cliente = null;
            JOptionPane.showMessageDialog(rootPane, "Ocorreu um erro inesperado: \n"+e3);
        } 
        
        
    }//GEN-LAST:event_btnSalvarActionPerformed

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
            java.util.logging.Logger.getLogger(CadastroClienteJD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastroClienteJD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastroClienteJD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastroClienteJD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                CadastroClienteJD dialog = new CadastroClienteJD(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    private JLabel jLabel1;
    private JLabel lblNome;
    private JTextField txtNome;
    private JLabel jLabel2;
    private JTextField txtCPF;
    private JButton btnSalvar;
    private JButton btnCancelar;
    // End of variables declaration//GEN-END:variables

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
        txtNome.setText(cliente.getNome());
        txtCPF.setText(cliente.getCPF());
    }
}
