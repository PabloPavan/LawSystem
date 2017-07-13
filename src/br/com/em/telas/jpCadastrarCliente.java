/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.em.telas;

import br.com.em.extra.JtextFieldSomenteLetras;
import br.com.em.extra.JPanelBuscaJtextFild;
import br.com.em.extra.JtextFieldSomenteNumeros;
import br.com.em.dao.ClienteDao;
import br.com.em.dao.InterfaceDao;
import br.com.em.pojo.Cliente;

import br.com.em.relatorio.RelatorioCliente;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.ButtonGroup;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author pablo
 */
public class jpCadastrarCliente extends javax.swing.JPanel {

    /**
     * Creates new form jpCadastrarCliente
     */
   
    public jpCadastrarCliente()  {
        initComponents();
       

        busca("");
        table.updateUI();

        ButtonGroup group = new ButtonGroup();
        group.add(jrbnome);
        group.add(jrbsobenome);
        group.add(jrbnumero);

    }

    private void novo() {
        
        jScrollPane1.setEnabled(false);
        table.setEnabled(false);

        JPanelBuscaJtextFild.limpaCampo(aba1);
        JPanelBuscaJtextFild.liberaCampo(aba1, true);
        JPanelBuscaJtextFild.limpaCampo(aba2);
        JPanelBuscaJtextFild.liberaCampo(aba2, true);
        JPanelBuscaJtextFild.limpaCampo(aba3);
        JPanelBuscaJtextFild.liberaCampo(aba3, true);
    

        jtabens.setText("");
        jtabens.setEnabled(true);
        
        jcbsexo.setEnabled(true);
        jcbdefere.setEnabled(true);
        jcbinativo.setSelected(false);

        jbinserir.setEnabled(true);
        jbatualizar.setEnabled(false);
        jbcancelar.setEnabled(true);
        jbnovo.setEnabled(false);
        jtfid.setEnabled(false);

    }

    private void cancelar() {

        jScrollPane1.setEnabled(true);
        table.setEnabled(true);
        
        JPanelBuscaJtextFild.limpaCampo(aba1);
        JPanelBuscaJtextFild.liberaCampo(aba1, false);
        JPanelBuscaJtextFild.limpaCampo(aba2);
        JPanelBuscaJtextFild.liberaCampo(aba2, false);
        JPanelBuscaJtextFild.limpaCampo(aba3);
        JPanelBuscaJtextFild.liberaCampo(aba3, false);
   
        jtabens.setText("");
        jtabens.setEnabled(false);
       
        jcbsexo.setEnabled(false);
        jcbdefere.setEnabled(false);
      

        jbinserir.setEnabled(false);
        jbatualizar.setEnabled(true);
        jbsalvaratualizar.setEnabled(false);
        jbcancelar.setEnabled(true);
        jbnovo.setEnabled(true);
    }

    private void busca(String nome) {
        ClienteDao di = new ClienteDao();

        List<Cliente> list = di.listarCliente(nome, "t");

        DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
        tableModel.setNumRows(0);

        list.stream().forEach((lista) -> {

            tableModel.addRow(new Object[]{
                lista.getP().getNome_pessoa(),
                lista.getP().getSobrenome_pessoa(),
                lista.getP().getCpf_pessoa(),
                lista.getP().getRg_pessoa(),
                lista.getP().getSexo_pessoa(),
                lista.getP().getDataNascimento_pessoa(),
                lista.getP().getEstadoCivil_pessoa(),
                lista.getP().getRua_pessoa(),
                lista.getP().getNumero_pessoa(),
                lista.getP().getComplemento_pessoa(),
                lista.getP().getBairro_pessoa(),
                lista.getP().getCep_pessoa(),
                lista.getP().getCidade_pessoa(),
                lista.getP().getEstado_pessoa(),
                lista.getP().getTelefone_pessoa(),
                lista.getP().getEmail_pessoa(),
                lista.getId_cliente(),
                //   lista.getId_pessoa(),
                lista.getNumero_cliente(),
                lista.getFilhos_cliente(),
                lista.getConjugeNome_cliente(),
                lista.getConjugeSalario_cliente(),
                lista.getProfisao_cliente(),
                lista.getLocalTrabalho_cliente(),
                lista.getRequerenteSalario_cliente(),
                lista.getRelacaoBens_cliente(),
                lista.getDataRegistro_cliente(),
                lista.isDefere_cliente(),
         
                lista.isInativo_cliente(),});
        });

    }

    private void dadostabela() {

        if(table.isEnabled()){
        int seleciona = table.getSelectedRow();

        jtfnome.setText(table.getModel().getValueAt(seleciona, 0).toString());
        jtfsobrenome.setText(table.getModel().getValueAt(seleciona, 1).toString());
        jtfcpf.setText(table.getModel().getValueAt(seleciona, 2).toString());
        jtfrg.setText(table.getModel().getValueAt(seleciona, 3).toString());
        if (table.getModel().getValueAt(seleciona, 4).toString().equals("M")) {
            jcbsexo.setSelectedIndex(0);
        } else {
            jcbsexo.setSelectedIndex(1);
        }
        jtfnascimento.setText(table.getModel().getValueAt(seleciona, 5).toString());
        jtfestadoCivil.setText(table.getModel().getValueAt(seleciona, 6).toString());
        jtfrua.setText(table.getModel().getValueAt(seleciona, 7).toString());
        jtfnumeroEndereco.setText(table.getModel().getValueAt(seleciona, 8).toString());
        jtfcomplemento.setText(table.getModel().getValueAt(seleciona, 9).toString());
        jtfbairro.setText(table.getModel().getValueAt(seleciona, 10).toString());
        jtfcep.setText(table.getModel().getValueAt(seleciona, 11).toString());
        jtfcidade.setText(table.getModel().getValueAt(seleciona, 12).toString());
        jtfestado.setText(table.getModel().getValueAt(seleciona, 13).toString());
        jtftelefone.setText(table.getModel().getValueAt(seleciona, 14).toString());
        jtfemail.setText(table.getModel().getValueAt(seleciona, 15).toString());

        jtfid.setText(table.getModel().getValueAt(seleciona, 16).toString());

        jtfnumero.setText(table.getModel().getValueAt(seleciona, 17).toString());
        jtffilhos.setText(table.getModel().getValueAt(seleciona, 18).toString());
        jtfconjuge.setText(table.getModel().getValueAt(seleciona, 19).toString());
        jtfsalarioConjuge.setText(table.getModel().getValueAt(seleciona, 20).toString());
        jtfprofissao.setText(table.getModel().getValueAt(seleciona, 21).toString());
        jtftrabalho.setText(table.getModel().getValueAt(seleciona, 22).toString());
        jtfsalarioCliente.setText(table.getModel().getValueAt(seleciona, 23).toString());
        jtabens.setText(table.getModel().getValueAt(seleciona, 24).toString());
        // 25 data
        
         if (table.getModel().getValueAt(seleciona, 26).toString().equals("true")) {
            jcbdefere.setSelected(true);
        } else {
            jcbdefere.setSelected(false);
        }
        
        
        if (table.getModel().getValueAt(seleciona, 27).toString().equals("true")) {
            jcbinativo.setSelected(true);
        } else {
            jcbinativo.setSelected(false);
        }
        }
    }

    private void updateLiberar() {
        //novo();
        
        JPanelBuscaJtextFild.liberaCampo(aba1, true);     
        JPanelBuscaJtextFild.liberaCampo(aba2, true);   
        JPanelBuscaJtextFild.liberaCampo(aba3, true); 
       
        
     
        jtabens.setEnabled(true); 
        
        jcbsexo.setEnabled(true);
        jcbdefere.setEnabled(true);
      
        
        jbsalvaratualizar.setEnabled(true);
        jcbinativo.setEnabled(true);
        jbinserir.setEnabled(false);
        jbatualizar.setEnabled(false);
        jbcancelar.setEnabled(true);
        jbnovo.setEnabled(false);
    }

    private void save() {

        Cliente c = new Cliente();
        c.getP().setNome_pessoa(jtfnome.getText());
        c.getP().setSobrenome_pessoa(jtfsobrenome.getText());
        c.getP().setCpf_pessoa(jtfcpf.getText());
        c.getP().setRg_pessoa(jtfrg.getText());
        c.getP().setSexo_pessoa(jcbsexo.getItemAt(jcbsexo.getSelectedIndex()));
        c.getP().setDataNascimento_pessoa(jtfnascimento.getText());
        c.getP().setEstadoCivil_pessoa(jtfestadoCivil.getText());
        c.getP().setRua_pessoa(jtfrua.getText());
        c.getP().setNumero_pessoa(jtfnumeroEndereco.getText());
        c.getP().setComplemento_pessoa(jtfcomplemento.getText());
        c.getP().setBairro_pessoa(jtfbairro.getText());
        c.getP().setCep_pessoa(jtfcep.getText());
        c.getP().setCidade_pessoa(jtfcidade.getText());
        c.getP().setEstado_pessoa(jtfestado.getText());
        c.getP().setTelefone_pessoa(jtftelefone.getText());
        c.getP().setEmail_pessoa(jtfemail.getText());
        c.setNumero_cliente(jtfnumero.getText());
        c.setFilhos_cliente(jtffilhos.getText());
        c.setConjugeNome_cliente(jtfconjuge.getText());
        c.setConjugeSalario_cliente(jtfsalarioConjuge.getText());
        c.setProfisao_cliente(jtfprofissao.getText());
        c.setLocalTrabalho_cliente(jtftrabalho.getText());
        c.setRequerenteSalario_cliente(jtfsalarioCliente.getText());
        c.setRelacaoBens_cliente(jtabens.getText());
        c.setDataRegistro_cliente("");
        c.setDefere_cliente(true);
        jcbinativo.setEnabled(false);

//        if (jcbinativo.isSelected()) {
//            c.setInativo_cliente(true);
//
//        } else {
//
//            c.setInativo_cliente(false);
//        }
        InterfaceDao i = new ClienteDao();
        i.cadastrar(c);
       
        busca("");
        cancelar();
    }

    public void update() {
        
        Cliente c = new Cliente();
        c.getP().setNome_pessoa(jtfnome.getText());
        c.getP().setSobrenome_pessoa(jtfsobrenome.getText());
        c.getP().setCpf_pessoa(jtfcpf.getText());
        c.getP().setRg_pessoa(jtfrg.getText());
        c.getP().setSexo_pessoa(jcbsexo.getItemAt(jcbsexo.getSelectedIndex()));
        c.getP().setDataNascimento_pessoa(jtfnascimento.getText());
        c.getP().setEstadoCivil_pessoa(jtfestadoCivil.getText());
        c.getP().setRua_pessoa(jtfrua.getText());
        c.getP().setNumero_pessoa(jtfnumeroEndereco.getText());
        c.getP().setComplemento_pessoa(jtfcomplemento.getText());
        c.getP().setBairro_pessoa(jtfbairro.getText());
        c.getP().setCep_pessoa(jtfcep.getText());
        c.getP().setCidade_pessoa(jtfcidade.getText());
        c.getP().setEstado_pessoa(jtfestado.getText());
        c.getP().setTelefone_pessoa(jtftelefone.getText());
        c.getP().setEmail_pessoa(jtfemail.getText());
        
        c.setId_cliente(jtfid.getText());
        c.setNumero_cliente(jtfnumero.getText());
        c.setFilhos_cliente(jtffilhos.getText());
        c.setConjugeNome_cliente(jtfconjuge.getText());
        c.setConjugeSalario_cliente(jtfsalarioConjuge.getText());
        c.setProfisao_cliente(jtfprofissao.getText());
        c.setLocalTrabalho_cliente(jtftrabalho.getText());
        c.setRequerenteSalario_cliente(jtfsalarioCliente.getText());
        c.setRelacaoBens_cliente(jtabens.getText());
        c.setDataRegistro_cliente("");
      
        c.setDefere_cliente(true);
      
     //   jcbinativo.setEnabled(false);

        if (jcbinativo.isSelected()) {
            c.setInativo_cliente(true);

        } else {

            c.setInativo_cliente(false);
        }
        InterfaceDao i = new ClienteDao();
        i.atualizar(c);

        busca("");
        cancelar();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jtfbusca = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jrbnome = new javax.swing.JRadioButton();
        jrbsobenome = new javax.swing.JRadioButton();
        jrbnumero = new javax.swing.JRadioButton();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        aba1 = new javax.swing.JPanel();
        jlrg = new javax.swing.JLabel();
        jlcpf = new javax.swing.JLabel();
        jcbinativo = new javax.swing.JCheckBox();
        jlnascimento = new javax.swing.JLabel();
        jtfid = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jtfcpf = new javax.swing.JTextField();
        try {
            javax.swing.text.MaskFormatter cnpj = new javax.swing.text.MaskFormatter("###.###.###-##");
            jtfcpf = new javax.swing.JFormattedTextField(cnpj);
        } catch (Exception exception) {

        }
        jtfrg = new javax.swing.JTextField();
        try {
            javax.swing.text.MaskFormatter rg = new javax.swing.text.MaskFormatter("##########");
            jtfrg = new javax.swing.JFormattedTextField(rg);
        } catch (Exception exception) {

        }
        jtfsobrenome = new javax.swing.JTextField();
        jtfnome = new javax.swing.JTextField();
        jlsobrenome = new javax.swing.JLabel();
        jlnome = new javax.swing.JLabel();
        jtfnascimento = new javax.swing.JTextField();
        try {
            javax.swing.text.MaskFormatter nsc= new javax.swing.text.MaskFormatter("##/##/####");
            jtfnascimento = new javax.swing.JFormattedTextField(nsc);
        } catch (Exception exception) {

        }
        jlrg1 = new javax.swing.JLabel();
        jlnascimento1 = new javax.swing.JLabel();
        jtfestadoCivil = new javax.swing.JTextField();
        try {
            javax.swing.text.MaskFormatter nsc= new javax.swing.text.MaskFormatter("##/##/####");
            jtfnascimento = new javax.swing.JFormattedTextField(nsc);
        } catch (Exception exception) {

        }
        jcbsexo = new javax.swing.JComboBox<>();
        aba2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jtfrua = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jtfnumeroEndereco =  new JtextFieldSomenteNumeros(25);
        jLabel4 = new javax.swing.JLabel();
        jtfcomplemento = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jtfbairro = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jtfcidade = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jtfestado = new JtextFieldSomenteLetras(2);
        jLabel10 = new javax.swing.JLabel();
        jtftelefone = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jtfemail = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jtfcep = new javax.swing.JTextField();
        aba3 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jtfnumero = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jtffilhos = new JtextFieldSomenteNumeros(2);
        jLabel16 = new javax.swing.JLabel();
        jtfprofissao = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jtftrabalho = new javax.swing.JTextField();
        jtfsalarioCliente = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jtfconjuge = new javax.swing.JTextField();
        jsprelacao = new javax.swing.JScrollPane();
        jtabens = new javax.swing.JTextArea();
        jcbdefere = new javax.swing.JCheckBox();
        jLabel24 = new javax.swing.JLabel();
        jtfsalarioConjuge = new javax.swing.JTextField();
        jbnovo = new javax.swing.JButton();
        jbinserir = new javax.swing.JButton();
        jbatualizar = new javax.swing.JButton();
        jbsalvaratualizar = new javax.swing.JButton();
        jbcancelar = new javax.swing.JButton();
        jbimprimir = new javax.swing.JButton();

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Pesquisa"));

        jtfbusca.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtfbuscaKeyReleased(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Filtros"));

        jrbnome.setSelected(true);
        jrbnome.setText("Nome");

        jrbsobenome.setText("Sobrenome");

        jrbnumero.setText("Número");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jrbnome)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jrbsobenome)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jrbnumero))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jrbsobenome)
                .addComponent(jrbnome)
                .addComponent(jrbnumero))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jrbnome, jrbsobenome});

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/em/icons/busca.png"))); // NOI18N
        jLabel5.setText("Buscar");

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome", "Sobrenome", "CPF", "RG", "Sexo", "DataN", "EstadoCivil", "Rua", "Numero", "Complemento", "Bairro", "Cep", "Cidade", "Estado", "Telefone", "Email", "Id_cliente", "Número", "Filhos", "ConjugeN", "ConjugeS", "Profissao", "Trabalho", "RequerenteSalario", "Relacao", "DataR", "Defere", "inativo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table.getTableHeader().setReorderingAllowed(false);
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table);
        if (table.getColumnModel().getColumnCount() > 0) {
            table.getColumnModel().getColumn(4).setMinWidth(0);
            table.getColumnModel().getColumn(4).setPreferredWidth(0);
            table.getColumnModel().getColumn(4).setMaxWidth(0);
            table.getColumnModel().getColumn(5).setMinWidth(0);
            table.getColumnModel().getColumn(5).setPreferredWidth(0);
            table.getColumnModel().getColumn(5).setMaxWidth(0);
            table.getColumnModel().getColumn(6).setMinWidth(0);
            table.getColumnModel().getColumn(6).setPreferredWidth(0);
            table.getColumnModel().getColumn(6).setMaxWidth(0);
            table.getColumnModel().getColumn(7).setMinWidth(0);
            table.getColumnModel().getColumn(7).setPreferredWidth(0);
            table.getColumnModel().getColumn(7).setMaxWidth(0);
            table.getColumnModel().getColumn(8).setMinWidth(0);
            table.getColumnModel().getColumn(8).setPreferredWidth(0);
            table.getColumnModel().getColumn(8).setMaxWidth(0);
            table.getColumnModel().getColumn(9).setMinWidth(0);
            table.getColumnModel().getColumn(9).setPreferredWidth(0);
            table.getColumnModel().getColumn(9).setMaxWidth(0);
            table.getColumnModel().getColumn(10).setMinWidth(0);
            table.getColumnModel().getColumn(10).setPreferredWidth(0);
            table.getColumnModel().getColumn(10).setMaxWidth(0);
            table.getColumnModel().getColumn(11).setMinWidth(0);
            table.getColumnModel().getColumn(11).setPreferredWidth(0);
            table.getColumnModel().getColumn(11).setMaxWidth(0);
            table.getColumnModel().getColumn(12).setMinWidth(0);
            table.getColumnModel().getColumn(12).setPreferredWidth(0);
            table.getColumnModel().getColumn(12).setMaxWidth(0);
            table.getColumnModel().getColumn(13).setMinWidth(0);
            table.getColumnModel().getColumn(13).setPreferredWidth(0);
            table.getColumnModel().getColumn(13).setMaxWidth(0);
            table.getColumnModel().getColumn(14).setMinWidth(0);
            table.getColumnModel().getColumn(14).setPreferredWidth(0);
            table.getColumnModel().getColumn(14).setMaxWidth(0);
            table.getColumnModel().getColumn(15).setMinWidth(0);
            table.getColumnModel().getColumn(15).setPreferredWidth(0);
            table.getColumnModel().getColumn(15).setMaxWidth(0);
            table.getColumnModel().getColumn(16).setMinWidth(0);
            table.getColumnModel().getColumn(16).setPreferredWidth(0);
            table.getColumnModel().getColumn(16).setMaxWidth(0);
            table.getColumnModel().getColumn(18).setMinWidth(0);
            table.getColumnModel().getColumn(18).setPreferredWidth(0);
            table.getColumnModel().getColumn(18).setMaxWidth(0);
            table.getColumnModel().getColumn(19).setMinWidth(0);
            table.getColumnModel().getColumn(19).setPreferredWidth(0);
            table.getColumnModel().getColumn(19).setMaxWidth(0);
            table.getColumnModel().getColumn(20).setMinWidth(0);
            table.getColumnModel().getColumn(20).setPreferredWidth(0);
            table.getColumnModel().getColumn(20).setMaxWidth(0);
            table.getColumnModel().getColumn(21).setMinWidth(0);
            table.getColumnModel().getColumn(21).setPreferredWidth(0);
            table.getColumnModel().getColumn(21).setMaxWidth(0);
            table.getColumnModel().getColumn(22).setMinWidth(0);
            table.getColumnModel().getColumn(22).setPreferredWidth(0);
            table.getColumnModel().getColumn(22).setMaxWidth(0);
            table.getColumnModel().getColumn(23).setMinWidth(0);
            table.getColumnModel().getColumn(23).setPreferredWidth(0);
            table.getColumnModel().getColumn(23).setMaxWidth(0);
            table.getColumnModel().getColumn(24).setMinWidth(0);
            table.getColumnModel().getColumn(24).setPreferredWidth(0);
            table.getColumnModel().getColumn(24).setMaxWidth(0);
            table.getColumnModel().getColumn(25).setMinWidth(0);
            table.getColumnModel().getColumn(25).setPreferredWidth(0);
            table.getColumnModel().getColumn(25).setMaxWidth(0);
            table.getColumnModel().getColumn(26).setMinWidth(0);
            table.getColumnModel().getColumn(26).setPreferredWidth(0);
            table.getColumnModel().getColumn(26).setMaxWidth(0);
            table.getColumnModel().getColumn(27).setMinWidth(0);
            table.getColumnModel().getColumn(27).setPreferredWidth(0);
            table.getColumnModel().getColumn(27).setMaxWidth(0);
        }

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(jtfbusca))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jtfbusca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jlrg.setText("RG:");

        jlcpf.setText("CPF:");

        jcbinativo.setText("Inativo");
        jcbinativo.setEnabled(false);

        jlnascimento.setText("Data Nasc:");

        jtfid.setEnabled(false);

        jLabel1.setText("Id:");

        jtfcpf.setEnabled(false);
        jtfcpf.setNextFocusableComponent(jtfrg);

        jtfrg.setEnabled(false);
        jtfrg.setNextFocusableComponent(jcbsexo);

        jtfsobrenome.setEnabled(false);
        jtfsobrenome.setNextFocusableComponent(jtfcpf);

        jtfnome.setEnabled(false);
        jtfnome.setNextFocusableComponent(jtfsobrenome);

        jlsobrenome.setText("Sobrenome:");

        jlnome.setText("Nome:");

        jtfnascimento.setEnabled(false);
        jtfnascimento.setNextFocusableComponent(jtfestadoCivil);

        jlrg1.setText("Sexo:");

        jlnascimento1.setText("Estado Civil:");

        jtfestadoCivil.setEnabled(false);
        jtfestadoCivil.setNextFocusableComponent(jtfnome);

        jcbsexo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "M", "F"}));
        jcbsexo.setEnabled(false);
        jcbsexo.setNextFocusableComponent(jtfnascimento);

        javax.swing.GroupLayout aba1Layout = new javax.swing.GroupLayout(aba1);
        aba1.setLayout(aba1Layout);
        aba1Layout.setHorizontalGroup(
            aba1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(aba1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(aba1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(jlsobrenome)
                    .addComponent(jlnome))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(aba1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(aba1Layout.createSequentialGroup()
                        .addComponent(jtfid, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                        .addComponent(jcbinativo))
                    .addComponent(jtfsobrenome)
                    .addComponent(jtfnome))
                .addGap(87, 87, 87)
                .addGroup(aba1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jlrg1)
                    .addGroup(aba1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jlrg)
                        .addComponent(jlcpf)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(aba1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jcbsexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(aba1Layout.createSequentialGroup()
                        .addGroup(aba1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jtfrg, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                            .addComponent(jtfcpf, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(87, 87, 87)
                        .addGroup(aba1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jlnascimento)
                            .addComponent(jlnascimento1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(aba1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtfnascimento, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtfestadoCivil, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(65, Short.MAX_VALUE))
        );
        aba1Layout.setVerticalGroup(
            aba1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(aba1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(aba1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlcpf)
                    .addComponent(jcbinativo)
                    .addComponent(jLabel1)
                    .addComponent(jtfid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfcpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlnascimento)
                    .addComponent(jtfnascimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(aba1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlrg)
                    .addComponent(jtfrg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfnome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlnome)
                    .addComponent(jlnascimento1)
                    .addComponent(jtfestadoCivil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(aba1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfsobrenome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlsobrenome)
                    .addComponent(jlrg1)
                    .addComponent(jcbsexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(40, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Dados do Tipo Pessoa", aba1);

        jLabel2.setText("Rua:");

        jtfrua.setEnabled(false);

        jLabel3.setText("Número:");

        //try {
            //            javax.swing.text.MaskFormatter a= new javax.swing.text.MaskFormatter("#0");
            //            jtfnumeroEndereco = new javax.swing.JFormattedTextField(a);
            //        } catch (Exception exception) {
            //
            //       }
        jtfnumeroEndereco.setEnabled(false);

        jLabel4.setText("Complemento:");

        jtfcomplemento.setEnabled(false);

        jLabel6.setText("Bairro:");

        jtfbairro.setEnabled(false);

        jLabel8.setText("Cidade:");

        jtfcidade.setEnabled(false);

        jLabel9.setText("Estado:");

        jtfestado.setEnabled(false);

        jLabel10.setText("Telefone:");

        jtftelefone.setEnabled(false);

        jLabel11.setText("Email:");

        jtfemail.setEnabled(false);
        jtfemail.setNextFocusableComponent(jtfrua);

        jLabel12.setText("Cep:");

        try {
            javax.swing.text.MaskFormatter cep = new javax.swing.text.MaskFormatter("######-###");
            jtfcep = new javax.swing.JFormattedTextField(cep);
        } catch (Exception exception) {

        }
        jtfcep.setEnabled(false);

        javax.swing.GroupLayout aba2Layout = new javax.swing.GroupLayout(aba2);
        aba2.setLayout(aba2Layout);
        aba2Layout.setHorizontalGroup(
            aba2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(aba2Layout.createSequentialGroup()
                .addGroup(aba2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, aba2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(aba2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(aba2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jtfbairro)
                            .addGroup(aba2Layout.createSequentialGroup()
                                .addComponent(jtfestado, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel10)
                                .addGap(5, 5, 5)
                                .addComponent(jtftelefone, javax.swing.GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE))))
                    .addGroup(aba2Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtfrua)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(aba2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(aba2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(aba2Layout.createSequentialGroup()
                        .addComponent(jtfnumeroEndereco)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtfcomplemento, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(aba2Layout.createSequentialGroup()
                        .addComponent(jtfcidade, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtfcep, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jtfemail))
                .addContainerGap())
        );
        aba2Layout.setVerticalGroup(
            aba2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(aba2Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(aba2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jtfrua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jtfnumeroEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jtfcomplemento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(aba2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jtfbairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(jtfcidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(jtfcep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addGroup(aba2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jtfestado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(jtftelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(jtfemail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31))
        );

        jTabbedPane1.addTab("Dados do Tipo Contato", aba2);

        aba3.setAutoscrolls(true);

        jLabel7.setText("Número:");

        //try {
            //            javax.swing.text.MaskFormatter a= new javax.swing.text.MaskFormatter("#######");
            //            jtfnumero= new javax.swing.JFormattedTextField(a);
            //        } catch (Exception exception) {
            //
            //        }
        jtfnumero.setEnabled(false);

        jLabel13.setText("Filhos:");

        //try {
            //            javax.swing.text.MaskFormatter a= new javax.swing.text.MaskFormatter("#######");
            //            jtffilhos = new javax.swing.JFormattedTextField(a);
            //        } catch (Exception exception) {
            //
            //        }
        jtffilhos.setEnabled(false);

        jLabel16.setText("Profissão:");

        jtfprofissao.setEnabled(false);

        jLabel17.setText("Local de Trabalho:");

        jtftrabalho.setEnabled(false);

        //try {
            //            javax.swing.text.MaskFormatter a= new javax.swing.text.MaskFormatter("#######");
            //            jtfsalarioCliente = new javax.swing.JFormattedTextField(a);
            //        } catch (Exception exception) {
            //
            //        }
        jtfsalarioCliente.setEnabled(false);

        jLabel15.setText("Salário Cliente:");

        jLabel18.setText("Cônjuge:");

        jtfconjuge.setEnabled(false);

        jsprelacao.setViewportBorder(javax.swing.BorderFactory.createTitledBorder("Relação de Bens:"));

        jtabens.setColumns(20);
        jtabens.setRows(5);
        jtabens.setEnabled(false);
        jsprelacao.setViewportView(jtabens);

        jcbdefere.setBackground(new java.awt.Color(153, 153, 153));
        jcbdefere.setSelected(true);
        jcbdefere.setText("Defere");
        jcbdefere.setEnabled(false);
        jcbdefere.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        jLabel24.setText("Salário Cônjuge:");

        //try {
            //            javax.swing.text.MaskFormatter a= new javax.swing.text.MaskFormatter("#######");
            //            jtfsalarioCliente = new javax.swing.JFormattedTextField(a);
            //        } catch (Exception exception) {
            //
            //        }
        jtfsalarioConjuge.setEnabled(false);

        javax.swing.GroupLayout aba3Layout = new javax.swing.GroupLayout(aba3);
        aba3.setLayout(aba3Layout);
        aba3Layout.setHorizontalGroup(
            aba3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(aba3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(aba3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jsprelacao)
                    .addGroup(aba3Layout.createSequentialGroup()
                        .addGroup(aba3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(aba3Layout.createSequentialGroup()
                                .addComponent(jLabel16)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jtfprofissao, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel17)
                                .addGap(4, 4, 4)
                                .addComponent(jtftrabalho, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel15)
                                .addGap(129, 129, 129)
                                .addComponent(jcbdefere))
                            .addGroup(aba3Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jtfnumero, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel18)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jtfconjuge, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(aba3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(aba3Layout.createSequentialGroup()
                                        .addGap(82, 82, 82)
                                        .addComponent(jtfsalarioCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(aba3Layout.createSequentialGroup()
                                        .addComponent(jLabel24)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jtfsalarioConjuge, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addComponent(jLabel13)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jtffilhos, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(23, Short.MAX_VALUE))))
        );
        aba3Layout.setVerticalGroup(
            aba3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(aba3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(aba3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jtfnumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(jtffilhos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18)
                    .addComponent(jtfconjuge, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfsalarioConjuge, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel24))
                .addGap(18, 18, 18)
                .addGroup(aba3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(aba3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel16)
                        .addComponent(jtfprofissao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel17)
                        .addComponent(jtftrabalho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel15)
                        .addComponent(jtfsalarioCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jcbdefere, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addComponent(jsprelacao, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Dados do Tipo Cliente", aba3);

        jbnovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/em/icons/data+.png"))); // NOI18N
        jbnovo.setText("Novo");
        jbnovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbnovoActionPerformed(evt);
            }
        });

        jbinserir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/em/icons/datasave.png"))); // NOI18N
        jbinserir.setText("Salvar");
        jbinserir.setEnabled(false);
        jbinserir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbinserirActionPerformed(evt);
            }
        });

        jbatualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/em/icons/dataedit.png"))); // NOI18N
        jbatualizar.setText("Editar");
        jbatualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbatualizarActionPerformed(evt);
            }
        });

        jbsalvaratualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/em/icons/dataatualizar.png"))); // NOI18N
        jbsalvaratualizar.setText("Atualizar");
        jbsalvaratualizar.setEnabled(false);
        jbsalvaratualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbsalvaratualizarActionPerformed(evt);
            }
        });

        jbcancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/em/icons/data-.png"))); // NOI18N
        jbcancelar.setText("Cancelar");
        jbcancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbcancelarActionPerformed(evt);
            }
        });

        jbimprimir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/em/icons/Print.png"))); // NOI18N
        jbimprimir.setText("Imprimir");
        jbimprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbimprimirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jbimprimir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jbnovo, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbinserir, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jbatualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jbsalvaratualizar)
                        .addGap(18, 18, 18)
                        .addComponent(jbcancelar))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbinserir)
                    .addComponent(jbatualizar)
                    .addComponent(jbsalvaratualizar)
                    .addComponent(jbcancelar)
                    .addComponent(jbnovo)
                    .addComponent(jbimprimir))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jbnovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbnovoActionPerformed
        novo();
    }//GEN-LAST:event_jbnovoActionPerformed

    private void jbinserirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbinserirActionPerformed
        save();
    }//GEN-LAST:event_jbinserirActionPerformed

    private void jbatualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbatualizarActionPerformed
        updateLiberar();
    }//GEN-LAST:event_jbatualizarActionPerformed

    private void jbsalvaratualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbsalvaratualizarActionPerformed
         update();
    }//GEN-LAST:event_jbsalvaratualizarActionPerformed

    private void jbcancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbcancelarActionPerformed
        cancelar();
    }//GEN-LAST:event_jbcancelarActionPerformed

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked
        dadostabela();
    }//GEN-LAST:event_tableMouseClicked

    private void jtfbuscaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfbuscaKeyReleased
        busca(jtfbusca.getText());
    }//GEN-LAST:event_jtfbuscaKeyReleased

    private void jbimprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbimprimirActionPerformed
     Map parametros = new HashMap();
    parametros.put("id_cliente", Integer.parseInt(jtfid.getText()));
        RelatorioCliente rc = new RelatorioCliente(parametros);
    
    }//GEN-LAST:event_jbimprimirActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel aba1;
    private javax.swing.JPanel aba2;
    private javax.swing.JPanel aba3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JButton jbatualizar;
    private javax.swing.JButton jbcancelar;
    private javax.swing.JButton jbimprimir;
    private javax.swing.JButton jbinserir;
    private javax.swing.JButton jbnovo;
    private javax.swing.JButton jbsalvaratualizar;
    private javax.swing.JCheckBox jcbdefere;
    private javax.swing.JCheckBox jcbinativo;
    private javax.swing.JComboBox<String> jcbsexo;
    private javax.swing.JLabel jlcpf;
    private javax.swing.JLabel jlnascimento;
    private javax.swing.JLabel jlnascimento1;
    private javax.swing.JLabel jlnome;
    private javax.swing.JLabel jlrg;
    private javax.swing.JLabel jlrg1;
    private javax.swing.JLabel jlsobrenome;
    private javax.swing.JRadioButton jrbnome;
    private javax.swing.JRadioButton jrbnumero;
    private javax.swing.JRadioButton jrbsobenome;
    private javax.swing.JScrollPane jsprelacao;
    private javax.swing.JTextArea jtabens;
    private javax.swing.JTextField jtfbairro;
    private javax.swing.JTextField jtfbusca;
    private javax.swing.JTextField jtfcep;
    private javax.swing.JTextField jtfcidade;
    private javax.swing.JTextField jtfcomplemento;
    private javax.swing.JTextField jtfconjuge;
    private javax.swing.JTextField jtfcpf;
    private javax.swing.JTextField jtfemail;
    private javax.swing.JTextField jtfestado;
    private javax.swing.JTextField jtfestadoCivil;
    private javax.swing.JTextField jtffilhos;
    private javax.swing.JTextField jtfid;
    private javax.swing.JTextField jtfnascimento;
    private javax.swing.JTextField jtfnome;
    private javax.swing.JTextField jtfnumero;
    private javax.swing.JTextField jtfnumeroEndereco;
    private javax.swing.JTextField jtfprofissao;
    private javax.swing.JTextField jtfrg;
    private javax.swing.JTextField jtfrua;
    private javax.swing.JTextField jtfsalarioCliente;
    private javax.swing.JTextField jtfsalarioConjuge;
    private javax.swing.JTextField jtfsobrenome;
    private javax.swing.JTextField jtftelefone;
    private javax.swing.JTextField jtftrabalho;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables
}
