package view;

import java.util.Arrays;
import java.util.List;

import javax.swing.JOptionPane;

import model.Categoria;
import model.Produto;

public class CadastroProdutoJD extends javax.swing.JDialog {

    private Produto produto;
    private boolean modoEdicao = false;

    public CadastroProdutoJD(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        loadCategorias();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        lblNome = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtQuantidade = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtValor = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        cmbCategoria = new javax.swing.JComboBox<>();
        btnSalvar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Cadastro de Produto");

        lblNome.setText("Nome");
        jLabel2.setText("Quantidade");
        jLabel3.setText("Valor");
        jLabel4.setText("Categoria");

        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(evt -> btnSalvarActionPerformed(evt));

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(evt -> btnCancelarActionPerformed(evt));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNome)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtNome)
                            .addComponent(txtQuantidade)
                            .addComponent(txtValor)
                            .addComponent(cmbCategoria, 0, 200, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNome)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cmbCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalvar)
                    .addComponent(btnCancelar))
                .addContainerGap())
        );

        pack();
    }

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {
        produto = null; // garante que não salva nada
        this.dispose();
    }

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {

        if (produto == null) {
            produto = new Produto();
        }

        try {
            produto.setNome(txtNome.getText().trim().toUpperCase());
            produto.setQuantidade(Integer.parseInt(txtQuantidade.getText().trim()));
            produto.setCategoria((Categoria) cmbCategoria.getSelectedItem());
            produto.setValor(Double.parseDouble(txtValor.getText().trim().replace(",", ".")));

            this.dispose();

        } catch (NumberFormatException e1) {
            produto = null;
            JOptionPane.showMessageDialog(rootPane, "Valor inválido:\n" + e1);
        } catch (Exception e3) {
            produto = null;
            JOptionPane.showMessageDialog(rootPane, "Erro inesperado:\n" + e3);
        }
    }

    private void loadCategorias() {
        cmbCategoria.removeAllItems();
        List<Categoria> categorias = Arrays.asList(Categoria.values());
        categorias.forEach(obj -> cmbCategoria.addItem(obj));
    }

    public Produto getProduto() {
        return produto;
    }

    // --------------- CORRIGIDO PARA EDIÇÃO ------------------
    public void setProduto(Produto produto) {
        this.produto = produto;
        this.modoEdicao = true;

        jLabel1.setText("Editar Produto");

        txtNome.setText(produto.getNome());
        txtQuantidade.setText(String.valueOf(produto.getQuantidade()));
        txtValor.setText(String.valueOf(produto.getValor()));
        cmbCategoria.setSelectedItem(produto.getCategoria());
    }

    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JComboBox<Categoria> cmbCategoria;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel lblNome;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtQuantidade;
    private javax.swing.JTextField txtValor;
}
