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

        tblProdutos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Nome", "Categoria", "Quantidade", "Valor"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblProdutos);

        btnNovo.setText("Novo");
        btnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoActionPerformed(evt);
            }
        });

        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                 System.out.println("Erro ao remover produto: ");
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
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 422, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnNovo)
                        .addGap(18, 18, 18)
                        .addComponent(btnEditar)
                        .addGap(18, 18, 18)
                        .addComponent(btnRemover)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnInfo)))
                .addContainerGap(19, Short.MAX_VALUE))
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
 private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {
      
       if(tblProdutos.getSelectedRow() != -1){

            Long id = (Long) tblProdutos.getModel().getValueAt(tblProdutos.getSelectedRow(), 0);
            Produto obj_produto = dao.buscarPorId(id).get();


            CadastroProdutoJD telaEdicao = new CadastroProdutoJD(this, rootPaneCheckingEnabled);
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
    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {
        CadastroProdutoJD telaCadastro = new CadastroProdutoJD(this, rootPaneCheckingEnabled);
        telaCadastro.setVisible(true);
        
        Produto novoProduto = telaCadastro.getProduto();
        try {
            //JOptionPane.showMessageDialog(rootPane, novoProduto);
            dao.persist(novoProduto);
        } catch (Exception ex) {
            System.out.println("Erro ao castrar "+ novoProduto.toString()+" \n Erro: "+ex);
        }
        loadTabelaProdutos();
    }//GEN-LAST:event_btnNovoActionPerformed

    private void btnInfoActionPerformed(java.awt.event.ActionEvent evt) {
        if(tblProdutos.getSelectedRow() != -1){
            Long id = (Long) tblProdutos.getModel().getValueAt(tblProdutos.getSelectedRow(), 0);
            Produto obj_produto = dao.buscarPorId(id).get();

            JOptionPane.showMessageDialog(rootPane, obj_produto.exibirDados());
        } else {
            JOptionPane.showMessageDialog(rootPane, "Selecione um produto");
        }
    }
    private void btnRemoverActionPerformed(java.awt.event.ActionEvent evt) {
        if(tblProdutos.getSelectedRow() != -1){

            Long id = (Long) tblProdutos.getModel().getValueAt(tblProdutos.getSelectedRow(), 0);
            Produto obj_produto = dao.buscarPorId(id).get();

            int op = JOptionPane.showConfirmDialog(rootPane,
                    "Deseja remover o produto " + obj_produto.getNome() + "?");

            if(op == JOptionPane.YES_OPTION){
                try {
                    dao.remover(obj_produto);
                } catch (Exception ex) {
                    System.out.println("Erro ao remover produto: " + ex);
                }

                JOptionPane.showMessageDialog(rootPane, "Produto removido com sucesso!");
                loadTabelaProdutos();
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Selecione um produto");
        }
    }
   

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new ListaProdutoJF().setVisible(true));
    }

    public void loadTabelaProdutos(){

        DefaultTableModel modelo = (DefaultTableModel) tblProdutos.getModel();
        modelo.setNumRows(0);

        for(Produto obj: dao.listaProdutos()){
            modelo.addRow(new Object[]{
                    obj.getId(),
                    obj.getNome(),
                    obj.getCategoria(),
                    obj.getQuantidade(),
                    obj.getValor()
            });
        }
    }

    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnInfo;
    
    private javax.swing.JButton btnNovo;
    private javax.swing.JButton btnRemover;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblProdutos;
}

