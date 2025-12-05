/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package view;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import javax.swing.*;

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
    // <editor-fold defaultstate="collapsed" desc="Generated
    // Code">//GEN-BEGIN:initComponents
    // Generated using JFormDesigner Evaluation license - unknown

    private void initComponents() {
        jLabel1 = new JLabel();
        lblNome = new JLabel();
        txtNome = new JTextField();
        jLabel2 = new JLabel();
        txtCPF = new JTextField();
        btnSalvar = new JButton();
        btnCancelar = new JButton();

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        var contentPane = getContentPane();

        jLabel1.setText("Cadastro de Cliente");
        lblNome.setText("Nome");
        jLabel2.setText("CPF");

        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(e -> btnSalvarActionPerformed(e));

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(e -> btnCancelarActionPerformed(e));

        GroupLayout layout = new GroupLayout(contentPane);
        contentPane.setLayout(layout);

        // ---- GRUPO HORIZONTAL ----
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                        .addComponent(jLabel1)
                        .addGroup(
                                layout.createSequentialGroup()
                                        .addGap(20)
                                        .addGroup(
                                                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(lblNome)
                                                        .addComponent(jLabel2))
                                        .addGap(20)
                                        .addGroup(
                                                layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(txtNome, 200, 200, 200)
                                                        .addComponent(txtCPF, 200, 200, 200))
                                        .addGap(20))
                        .addGroup(
                                layout.createSequentialGroup()
                                        .addGap(20)
                                        .addComponent(btnSalvar)
                                        .addGap(20)
                                        .addComponent(btnCancelar)
                                        .addGap(20)));

        // ---- GRUPO VERTICAL ----
        layout.setVerticalGroup(
                layout.createSequentialGroup()
                        .addGap(20)
                        .addComponent(jLabel1)
                        .addGap(20)
                        .addGroup(
                                layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblNome)
                                        .addComponent(txtNome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                                                GroupLayout.PREFERRED_SIZE))
                        .addGap(15)
                        .addGroup(
                                layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel2)
                                        .addComponent(txtCPF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                                                GroupLayout.PREFERRED_SIZE))
                        .addGap(30)
                        .addGroup(
                                layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnSalvar)
                                        .addComponent(btnCancelar))
                        .addGap(20));

        pack();
        setLocationRelativeTo(getOwner());
    }

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnCancelarActionPerformed
        this.dispose();
    }// GEN-LAST:event_btnCancelarActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnSalvarActionPerformed

        if (cliente == null)
            cliente = new Cliente();

        try {
            String cpf = txtCPF.getText().replace(".", "").replace("-", "");
            this.cliente.setNome(txtNome.getText().trim());
            if (Util.validaCPF(cpf)) {
                this.cliente.setCPF(cpf);
            } else {
                return;
            }

            this.dispose();
        } catch (DateTimeParseException e1) {
            cliente = null;
            JOptionPane.showMessageDialog(rootPane, "Data inválida!! Informe data no formato dd-mm-yyyy\n" + e1);
        } catch (Exception e3) {
            cliente = null;
            JOptionPane.showMessageDialog(rootPane, "Ocorreu um erro inesperado: \n" + e3);
        }

    }// GEN-LAST:event_btnSalvarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        // <editor-fold defaultstate="collapsed" desc=" Look and feel setting code
        // (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the default
         * look and feel.
         * For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CadastroClienteJD.class.getName()).log(java.util.logging.Level.SEVERE,
                    null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastroClienteJD.class.getName()).log(java.util.logging.Level.SEVERE,
                    null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastroClienteJD.class.getName()).log(java.util.logging.Level.SEVERE,
                    null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastroClienteJD.class.getName()).log(java.util.logging.Level.SEVERE,
                    null, ex);
        }
        // </editor-fold>
        // </editor-fold>
        // </editor-fold>
        // </editor-fold>

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
