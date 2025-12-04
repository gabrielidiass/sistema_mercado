package view;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import model.Produto;
import model.dao.ProdutoDAO;

public class ListaProdutoJF extends javax.swing.JFrame {

    ProdutoDAO dao;

    public ListaProdutoJF() {
        initComponents();
        dao = new ProdutoDAO();
        loadTabelaProdutos();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblProdutos = new javax.swing.JTable();
        btnNovo = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnRemover = new javax.swing.JButton();
        btnInfo = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        // ---------- MODELO CORRIGIDO ----------
        tblProdutos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {},
            new String [] {
                "ID", "Nome", "Categoria", "Quantidade", "Valor"
            }
        ) {
            Class[] types = new Class [] {
                Long.class, String.class, String.class, Integer.class, Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblProdutos);

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
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 550, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnNovo)
                        .addGap(18, 18, 18)
                        .addComponent(btnEditar)
                        .addGap(18, 18, 18)
                        .addComponent(btnRemover)
                        .addGap(18, 18, 18)
                        .addComponent(btnInfo)))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNovo)
                    .addComponent(btnEditar)
                    .addComponent(btnRemover)
                    .addComponent(btnInfo))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
    }

    // ----------------- BOTÃO NOVO -----------------

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {
        CadastroProdutoJD telaCadastro = new CadastroProdutoJD(this, true);
        telaCadastro.setVisible(true);

        Produto novoProduto = telaCadastro.getProduto();

        if (novoProduto != null) {
            try {
                dao.persist(novoProduto);
            } catch (Exception ex) {
                System.out.println("Erro ao cadastrar: " + ex);
            }
            loadTabelaProdutos();
        }
    }

    // ----------------- BOTÃO EDITAR -----------------

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {

        int linha = tblProdutos.getSelectedRow();

        if (linha != -1) {

            Long id = (Long) tblProdutos.getValueAt(linha, 0);
            Produto obj_produto = dao.buscarPorId(id).get();

            // Abre a tela de edição
            CadastroProdutoJD telaEdicao = new CadastroProdutoJD(this, true);
            telaEdicao.setProduto(obj_produto);
            telaEdicao.setVisible(true);

            try {
                dao.persist(telaEdicao.getProduto());
            } catch (Exception ex) {
                System.err.println("Erro ao editar produto: " + ex);
            }

            loadTabelaProdutos();

        } else {
            JOptionPane.showMessageDialog(rootPane, "Selecione um produto");
        }
    }

    // ----------------- BOTÃO INFO -----------------

    private void btnInfoActionPerformed(java.awt.event.ActionEvent evt) {
        int linha = tblProdutos.getSelectedRow();

        if (linha != -1) {
            Long id = (Long) tblProdutos.getValueAt(linha, 0);
            Produto obj_produto = dao.buscarPorId(id).get();

            JOptionPane.showMessageDialog(rootPane, obj_produto.exibirDados());
        } else {
            JOptionPane.showMessageDialog(rootPane, "Selecione um produto");
        }
    }

    // ----------------- BOTÃO REMOVER -----------------

    private void btnRemoverActionPerformed(java.awt.event.ActionEvent evt) {
        int linha = tblProdutos.getSelectedRow();

        if (linha != -1) {

            Long id = (Long) tblProdutos.getValueAt(linha, 0);
            Produto obj_produto = dao.buscarPorId(id).get();

            int op = JOptionPane.showConfirmDialog(rootPane,
                "Deseja remover o produto " + obj_produto.getNome() + "?");

            if (op == JOptionPane.YES_OPTION) {
                try {
                    dao.remover(obj_produto);
                } catch (Exception ex) {
                    System.out.println("Erro ao remover: " + ex);
                }

                JOptionPane.showMessageDialog(rootPane, "Produto removido com sucesso!");
                loadTabelaProdutos();
            }

        } else {
            JOptionPane.showMessageDialog(rootPane, "Selecione um produto");
        }
    }

    // ----------------- CARREGAR TABELA -----------------

    public void loadTabelaProdutos() {

        DefaultTableModel modelo = (DefaultTableModel) tblProdutos.getModel();
        modelo.setNumRows(0);

        for (Produto obj : dao.listaProdutos()) {
            modelo.addRow(new Object[]{
                obj.getId(),
                obj.getNome(),
                obj.getCategoria(),
                obj.getQuantidade(),
                obj.getValor()
            });
        }
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new ListaProdutoJF().setVisible(true));
    }

    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnInfo;
    private javax.swing.JButton btnNovo;
    private javax.swing.JButton btnRemover;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblProdutos;
}
