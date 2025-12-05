package view;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Compra;
import model.dao.CompraDAO;

public class ListaComprasJF extends javax.swing.JFrame {

    CompraDAO dao;

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
            new Object [][] {},
            new String [] {
                "Data da compra", "Produto", "Cliente"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblCompras);

        btnNovo.setText("Novo");
        btnNovo.addActionListener(evt -> btnNovoActionPerformed(evt));

        btnEditar.setText("Editar");
        btnEditar.addActionListener(evt -> btnEditarActionPerformed(evt));

        btnRemover.setText("Remover");
        btnRemover.addActionListener(evt -> btnRemoverActionPerformed(evt));

        btnInfo.setText("Mais Informações");
        btnInfo.addActionListener(evt -> btnInfoActionPerformed(evt));

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
    }

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {
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
    }

    private void btnRemoverActionPerformed(java.awt.event.ActionEvent evt) {
        if (tblCompras.getSelectedRow() != -1) {
            Compra obj = (Compra) tblCompras.getModel().getValueAt(tblCompras.getSelectedRow(), 0);
            String txtCompra = "Compra: { produto " + obj.getProduto().getNome() + ", cliente: " + obj.getCliente().getNome() + ", vendedor: " + obj.getFuncionario().getNome() + " }";
            int op = JOptionPane.showConfirmDialog(rootPane, "Tem certeza que deseja remover " + txtCompra + "?");
            if (op == JOptionPane.YES_OPTION) {
                try {
                    dao.remover(obj);
                } catch (Exception ex) {
                    System.out.println("Erro ao remover " + txtCompra + "\n Erro: " + ex);
                }
                JOptionPane.showMessageDialog(rootPane, "Compra removida com sucesso...");
                loadCompras();
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Selecione uma linha");
        }
    }

    private void btnInfoActionPerformed(java.awt.event.ActionEvent evt) {
        if (tblCompras.getSelectedRow() != -1) {
            Compra obj = (Compra) tblCompras.getModel().getValueAt(tblCompras.getSelectedRow(), 0);
            JOptionPane.showMessageDialog(rootPane, obj.exibirDados());
        } else {
            JOptionPane.showMessageDialog(rootPane, "Selecione uma linha");
        }
    }

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {
        if (tblCompras.getSelectedRow() != -1) {
            Compra obj = (Compra) tblCompras.getModel().getValueAt(tblCompras.getSelectedRow(), 0);
            CadastroCompraJD telaCompra = new CadastroCompraJD(this, rootPaneCheckingEnabled);
            telaCompra.setCompra(obj);
            telaCompra.setVisible(true);

            Compra compraEdt = telaCompra.getCompra();

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
    }

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception ex) {}

        java.awt.EventQueue.invokeLater(() -> new ListaComprasJF().setVisible(true));
    }

    private javax.swing.JPanel areaBusca;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnInfo;
    private javax.swing.JButton btnNovo;
    private javax.swing.JButton btnRemover;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblCompras;
}
