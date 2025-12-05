package view;

import model.*;
import model.dao.ClienteDAO;
import model.dao.FuncionarioDAO;
import model.dao.ProdutoDAO;
import model.dao.CompraDAO;

import javax.swing.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class CadastroCompraJD extends javax.swing.JDialog {

    ClienteDAO daoCliente;
    FuncionarioDAO daoFuncionario;
    ProdutoDAO daoProduto;
    CompraDAO daoCompra;

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
    private Compra compra;

    public CadastroCompraJD(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

        daoCliente = new ClienteDAO();
        daoProduto = new ProdutoDAO();
        daoFuncionario = new FuncionarioDAO();
        daoCompra = new CompraDAO();

        loadFormaPgto();
        loadClientes();
        loadFuncionarioes();
        loadProdutos();

        txtDataCompra.setText(LocalDateTime.now().format(formatter));
    }

    public void loadFormaPgto() {
        for (FormaPagamento obj : FormaPagamento.values()) {
            cmbFormaPagamento.addItem(obj);
        }
    }

    public void loadClientes() {
        for (Cliente obj : daoCliente.listaClientes()) {
            cmbCliente.addItem(obj);
        }
    }

    public void loadFuncionarioes() {
        for (Funcionario obj : daoFuncionario.listaFuncionarios()) {
            cmbFuncionario.addItem(obj);
        }
    }

    public void loadProdutos() {
        for (Produto obj : daoProduto.listaProdutos()) {
            cmbProduto.addItem(obj);
        }
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        lblDtCompra = new javax.swing.JLabel();
        txtDataCompra = new javax.swing.JTextField();
        lblValor = new javax.swing.JLabel();
        txtValor = new javax.swing.JTextField();
        lblFormaPagamento = new javax.swing.JLabel();
        cmbFormaPagamento = new javax.swing.JComboBox<>();
        cmbCliente = new javax.swing.JComboBox<>();
        cmbProduto = new javax.swing.JComboBox<>();
        cmbFuncionario = new javax.swing.JComboBox<>();
        lblCliente = new javax.swing.JLabel();
        lblProduto = new javax.swing.JLabel();
        lblFuncionario = new javax.swing.JLabel();
        btnSalvar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Helvetica Neue", 1, 24));
        jLabel1.setText("Cadastro de Compra");

        lblDtCompra.setText("Data Compra:");

        lblValor.setText("Valor:");

        lblFormaPagamento.setText("Forma Pagamento:");

        cmbProduto.addItemListener(evt -> cmbProdutoItemStateChanged(evt));

        lblCliente.setText("Cliente:");

        lblProduto.setText("Produto:");

        lblFuncionario.setText("Funcionário:");

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
                            .addComponent(lblDtCompra)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(txtDataCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(lblValor)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(txtValor, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(lblFormaPagamento)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(cmbFormaPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(lblCliente)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(cmbCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(lblProduto)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(cmbProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(lblFuncionario)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(cmbFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(28, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(20, 20, 20)
                    .addComponent(jLabel1)
                    .addGap(31, 31, 31)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblDtCompra)
                        .addComponent(txtDataCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblValor)
                        .addComponent(txtValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblFormaPagamento)
                        .addComponent(cmbFormaPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblCliente)
                        .addComponent(cmbCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblProduto)
                        .addComponent(cmbProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblFuncionario)
                        .addComponent(cmbFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addComponent(btnSalvar)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(btnCancelar)
                    .addContainerGap())
        );

        pack();
    }

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {
        this.dispose();
    }

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {

        try {
            if (compra == null)
                compra = new Compra();

            double valor = Double.parseDouble(txtValor.getText().replace(",", "."));
            LocalDateTime dataCompra = LocalDateTime.parse(txtDataCompra.getText(), formatter);

            compra.setValorCompra(valor);
            compra.setDataCompra(dataCompra);
            compra.setFormaPagamento((FormaPagamento) cmbFormaPagamento.getSelectedItem());
            compra.setCliente((Cliente) cmbCliente.getSelectedItem());
            compra.setFuncionario((Funcionario) cmbFuncionario.getSelectedItem());
            compra.setProduto((Produto) cmbProduto.getSelectedItem());

            daoCompra.persist(compra);

            this.dispose();

        } catch (NumberFormatException e) {
            compra = null;
            JOptionPane.showMessageDialog(this, "Valor inválido.", "Erro", JOptionPane.ERROR_MESSAGE);
        } catch (DateTimeParseException e) {
            compra = null;
            JOptionPane.showMessageDialog(this, "Data inválida. Use dd-MM-yyyy HH:mm", "Erro", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            compra = null;
            JOptionPane.showMessageDialog(this, "Erro ao salvar compra: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void cmbProdutoItemStateChanged(java.awt.event.ItemEvent evt) {
        Produto objSel = (Produto) cmbProduto.getSelectedItem();
        if (objSel != null)
            txtValor.setText("" + objSel.getValor());
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            CadastroCompraJD dialog = new CadastroCompraJD(new javax.swing.JFrame(), true);
            dialog.setVisible(true);
        });
    }

    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JComboBox<Cliente> cmbCliente;
    private javax.swing.JComboBox<FormaPagamento> cmbFormaPagamento;
    private javax.swing.JComboBox<Produto> cmbProduto;
    private javax.swing.JComboBox<Funcionario> cmbFuncionario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblCliente;
    private javax.swing.JLabel lblDtCompra;
    private javax.swing.JLabel lblFormaPagamento;
    private javax.swing.JLabel lblValor;
    private javax.swing.JLabel lblProduto;
    private javax.swing.JLabel lblFuncionario;
    private javax.swing.JTextField txtDataCompra;
    private javax.swing.JTextField txtValor;

    public Compra getCompra() {
        return compra;
    }

    public void setCompra(Compra compra) {
        this.compra = compra;
        txtDataCompra.setText(compra.getDataCompra().format(formatter));
        txtValor.setText("" + compra.getValorCompra());
        cmbCliente.setSelectedItem(compra.getCliente());
        cmbProduto.setSelectedItem(compra.getProduto());
        cmbFuncionario.setSelectedItem(compra.getFuncionario());
        cmbFormaPagamento.setSelectedItem(compra.getFormaPagamento());
    }
}
