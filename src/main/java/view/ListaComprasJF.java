/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import model.Compra;
import model.dao.CompraDAO;

/**
 *
 * @author vanessalagomachado
 */
public class ListaComprasJF extends javax.swing.JFrame {

    CompraDAO dao;

    /**
     * Creates new form ListaComprasJF
     */
    public ListaComprasJF() {
        initComponents();
        dao = new CompraDAO();
        loadCompras();
    }

    public void loadCompras() {
        DefaultTableModel modelo = (DefaultTableModel) tblCompras.getModel();
        modelo.setNumRows(0);
        for (Compra obj : dao.listaCompras()) {
            Object[] linha = {
                obj,
                obj.getProduto(),
                obj.getCliente()
            };
            modelo.addRow(linha);
        }

    }
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        areaBusca = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCompras = new javax.swing.JTable();
        btnNovo = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnRemover = new javax.swing.JButton();
        btnInfo = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Compras Cadastradas");

        javax.swing.GroupLayout areaBuscaLayout = new javax.swing.GroupLayout(areaBusca);
        areaBusca.setLayout(areaBuscaLayout);
        areaBuscaLayout.setHorizontalGroup(
            areaBuscaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 522, Short.MAX_VALUE)
        );
        areaBuscaLayout.setVerticalGroup(
            areaBuscaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 72, Short.MAX_VALUE)
        );

        tblCompras.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Data da compra", "Produto", "Cliente"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblCompras);

        btnNovo.setText("Novo");
        btnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoActionPerformed(evt);
            }
        });

        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnRemover.setText("Remover");
        btnRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoverActionPerformed(evt);
            }
        });

        btnInfo.setText("Mais Informações");
        btnInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInfoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1)
                    .addComponent(areaBusca, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnRemover, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnInfo)))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(areaBusca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNovo)
                    .addComponent(btnEditar)
                    .addComponent(btnRemover)
                    .addComponent(btnInfo))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
        CadastroCompraJD telaCompra = new CadastroCompraJD(this, rootPaneCheckingEnabled);
        telaCompra.setVisible(true);

        Compra novoObj = telaCompra.getCompra();

        if (novoObj != null) {
            try {
                dao.persist(novoObj);
                loadCompras();
            } catch (Exception ex) {
                System.err.println("Erro ao salvar nova Compra: " + novoObj + "\n Erro: " + ex);
            }

        }
    }//GEN-LAST:event_btnNovoActionPerformed

    private void btnRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoverActionPerformed
        if (tblCompras.getSelectedRow() != -1) {
            Compra obj = (Compra) tblCompras.getModel().getValueAt(tblCompras.getSelectedRow(), 0);
            String txtCompra = "Compra: { produto" + obj.getProduto().getNome() + ", cliente: " + obj.getCliente().getNome() + ", vendedor: " + obj.getFuncionario().getNome() + "}";
            int op_remover = JOptionPane.showConfirmDialog(rootPane, "Tem certeza que deseja remover " + txtCompra + "?");
            if (op_remover == JOptionPane.YES_OPTION) {
                try {
                    dao.remover(obj);
                } catch (Exception ex) {
                    System.out.println("Erro ao remover " + txtCompra + "\n Erro: " + ex);
                }
                JOptionPane.showMessageDialog(rootPane, "Compra removida com sucesso... ");
                loadCompras();
            }

        } else {
            JOptionPane.showMessageDialog(rootPane, "Selecione uma linha");
        }
    }//GEN-LAST:event_btnRemoverActionPerformed

    private void btnInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInfoActionPerformed
        if (tblCompras.getSelectedRow() != -1) {
            Compra obj = (Compra) tblCompras.getModel().getValueAt(tblCompras.getSelectedRow(), 0);
            JOptionPane.showMessageDialog(rootPane, obj.exibirDados());
        } else {
            JOptionPane.showMessageDialog(rootPane, "Selecione uma linha");
        }
    }//GEN-LAST:event_btnInfoActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        if (tblCompras.getSelectedRow() != -1) {
            Compra obj = (Compra) tblCompras.getModel().getValueAt(tblCompras.getSelectedRow(), 0);
            CadastroCompraJD telaCompra = new CadastroCompraJD(this, rootPaneCheckingEnabled);
            telaCompra.setCompra(obj);
            telaCompra.setVisible(true);

            // 2. recuperar o objeto Compra
            Compra compraEdt = telaCompra.getCompra();

            // 3. Se o objeto não for null persistir no BD
            if (compraEdt != null) {
                try {
                    dao.persist(compraEdt);
                } catch (Exception ex) {
                    System.err.println("Erro ao editar Compra\n Erro: " + ex);
                }

                loadCompras();
            }

        } else {
            JOptionPane.showMessageDialog(rootPane, "Selecione uma linha");
        }
    }//GEN-LAST:event_btnEditarActionPerformed

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
            java.util.logging.Logger.getLogger(ListaComprasJF.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListaComprasJF.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListaComprasJF.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListaComprasJF.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ListaComprasJF().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel areaBusca;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnInfo;
    private javax.swing.JButton btnNovo;
    private javax.swing.JButton btnRemover;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblCompras;
    // End of variables declaration//GEN-END:variables
}
