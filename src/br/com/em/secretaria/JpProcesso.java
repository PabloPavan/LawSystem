
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.em.secretaria;

import br.com.em.dao.InterfaceDao;
import br.com.em.dao.ProcessoDao;
import br.com.em.dao.ProcessoVoDao;
import br.com.em.dao.VaraDao;
import br.com.em.extra.JPanelBuscaJtextFild;
import br.com.em.extra.JtextFieldSomenteLetras;
import br.com.em.extra.JtextFieldSomenteNumeros;
import br.com.em.modelo.Processo;
import br.com.em.modelo.Vara;
import br.com.em.relatorio.RelatorioCliente;
import br.com.em.vo.ProcessoVo;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author pablo
 */
public class JpProcesso extends javax.swing.JPanel {

    /**
     * Creates new form jpCadastrarCliente
     */
    List<Vara> varalist;

    public JpProcesso() {

        initComponents();

        busca("");
        table.updateUI();

        ButtonGroup group = new ButtonGroup();
        group.add(jrbnome);
        group.add(jrbsobrenome);
        group.add(jrbnumero);

        ButtonGroup group2 = new ButtonGroup();
        group2.add(jrbnovo);
        group2.add(jrbativo);
        group2.add(jrbmorto);

        InterfaceDao i = new VaraDao();
        varalist = i.listar("", "");
        varalist.forEach((vara) -> {
            jcbvara.addItem(vara.getNome_vara());
        });

    }

    private void novo() {

        JPanelBuscaJtextFild.limpaCampo(aba1);
        JPanelBuscaJtextFild.liberaCampo(aba1, true);
        JPanelBuscaJtextFild.limpaCampo(jpcliente);

        JPanelBuscaJtextFild.limpaCampo(aba3);
        JPanelBuscaJtextFild.liberaCampo(aba3, true);

        jtaconsulta.setEnabled(true);
        jtanarrativa.setEnabled(true);
        jtaobs.setEnabled(true);
        jtfid.setEnabled(false);

        //     JPanelBuscaJtextFild.limpaCampo(jpcliente);
        //     JPanelBuscaJtextFild.limpaCampo(jpvara);
        jbbuscaCliente.setEnabled(true);

        jcbvara.setEnabled(true);
        jrbnovo.setEnabled(true);
        jrbnovo.setSelected(true);
        jScrollPanetable.setEnabled(false);
        table.setEnabled(false);
        //  jrbativo.setEnabled(true);
        // jrbmorto.setEnabled(true);
        jtfnumeroMorto.setEnabled(false);

        jbinserir.setEnabled(true);
        jbatualizar.setEnabled(false);
        jbsalvaratualizar.setEnabled(false);
        jbcancelar.setEnabled(true);
        jbnovo.setEnabled(false);

    }

    private void cancelar() {

        JPanelBuscaJtextFild.limpaCampo(aba1);
        JPanelBuscaJtextFild.liberaCampo(aba1, false);
        //    JPanelBuscaJtextFild.limpaCampo(jpcliente);

        //   JPanelBuscaJtextFild.limpaCampo(jpvara);
        JPanelBuscaJtextFild.limpaCampo(aba3);
        JPanelBuscaJtextFild.liberaCampo(aba3, false);

        jtaconsulta.setEnabled(false);
        jtanarrativa.setEnabled(false);
        jtaobs.setEnabled(false);
        table.setEnabled(true);
        jbbuscaCliente.setEnabled(false);
        jcbvara.setEnabled(false);

        jrbnovo.setEnabled(false);
        jrbativo.setEnabled(false);
        jtfnumeroMorto.setEnabled(false);

        jbinserir.setEnabled(false);
        jbsalvaratualizar.setEnabled(false);
        jbcancelar.setEnabled(true);
        jbnovo.setEnabled(true);
        jbatualizar.setEnabled(true);

    }

    private void updateliberar() {

        JPanelBuscaJtextFild.liberaCampo(aba1, true);
        JPanelBuscaJtextFild.liberaCampo(aba3, true);

        jbbuscaCliente.setEnabled(true);
        jcbvara.setEnabled(true);

        jtaconsulta.setEnabled(true);
        jtanarrativa.setEnabled(true);
        jtaobs.setEnabled(true);
        jtfid.setEnabled(false);
        table.setEnabled(true);
        jrbnovo.setEnabled(false);
        jrbativo.setEnabled(true);
        jrbmorto.setEnabled(true);
        jtfnumeroMorto.setEnabled(false);

        jtfid.setEnabled(false);

        jbsalvaratualizar.setEnabled(true);

        jbinserir.setEnabled(false);
        jbatualizar.setEnabled(false);
        jbcancelar.setEnabled(true);
        jbnovo.setEnabled(false);

    }

    private void busca(String busca) {
        String auxBusca = null;
        if (jrbnome.isSelected()) {
            auxBusca = "nome";
        } else if (jrbsobrenome.isSelected()) {
            auxBusca = "sobrenome";
        } else {
            auxBusca = "numero";
        }

        InterfaceDao di = new ProcessoVoDao();
        List<ProcessoVo> list = di.listar(busca, auxBusca);

        DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
        tableModel.setNumRows(0);

        list.stream().forEach((ProcessoVo lista) -> {
            tableModel.addRow(new Object[]{
                lista.getId_processo(),
                lista.getNome_pessoa(),
                lista.getSobrenome_pessoa(),
                lista.getNomeparte_processo(),
                lista.getNumero_processo(),
                lista.getNumeroPasta_processo(),
                lista.getAndamento_processo(),
                lista.getAcao_processo(),
                lista.getId_cliente(),
                lista.getId_vara(),
                lista.getDataInicio_processo(),
                lista.getDataFim_processo(),
                lista.getDiaSemana_processo(),
                lista.getNarrativa_processo(),
                lista.getConsulta_processo(),
                lista.getObs_processo(),
                lista.getNumero_cliente(),
                lista.getRg_pessoa(),
                lista.getCpf_pessoa()
            });
        });

        table.updateUI();

    }

    private void save() {
        Processo p = new Processo();

        p.setNome_processo(jtfparteNome.getText());
        p.setNumero_processo(jtfnumeroProcesso.getText());
        p.setNumeroPasta_processo(jtfnumeroPasta.getText());

        if (jrbnovo.isSelected()) {
            p.setAndamento_processo("n");
        } else if (jrbativo.isSelected()) {
            p.setAndamento_processo("a");
        } else {
            p.setAndamento_processo("m");
        }

        p.setAcao_processo(jtfacao.getText());
        p.setId_cliente(jtfIdCliente.getText());
        p.setId_vara((varalist.get(jcbvara.getSelectedIndex()).getId_vara()));
        p.setDataInicio_processo(jtfdataInicio.getText());
        p.setDataFim_processo(jtfdataFim.getText());
        p.setDiaSemana_processo(jtfdiaSemana.getText());
        p.setNarrativa_processo(jtanarrativa.getText());
        p.setConsulta_processo(jtaconsulta.getText());
        p.setObs_processo(jtaobs.getText());

        if (!jtfIdCliente.getText().isEmpty()) {
            InterfaceDao i = new ProcessoDao();
            i.cadastrar(p);
            cancelar();
        } else {
            JOptionPane.showMessageDialog(null, "É Preciso Adiconar um Cliente na Aba Dados do Cliente");
        }

        busca("");

    }

    private void update() {

        Processo p = new Processo();
        p.setId_processo(jtfid.getText());
        p.setNome_processo(jtfparteNome.getText());
        p.setNumero_processo(jtfnumeroProcesso.getText());
        p.setNumeroPasta_processo(jtfnumeroPasta.getText());
        if (jrbnovo.isSelected()) {
            p.setAndamento_processo("n");
        } else if (jrbativo.isSelected()) {
            p.setAndamento_processo("a");
        } else {
            p.setAndamento_processo("m");
        }

        p.setAcao_processo(jtfacao.getText());
        p.setId_cliente(jtfIdCliente.getText());
        p.setId_vara(varalist.get(jcbvara.getSelectedIndex()).getId_vara());
        p.setDataInicio_processo(jtfdataInicio.getText());
        p.setDataFim_processo(jtfdataFim.getText());
        p.setDiaSemana_processo(jtfdiaSemana.getText());
        p.setNarrativa_processo(jtanarrativa.getText());
        p.setConsulta_processo(jtaconsulta.getText());
        p.setObs_processo(jtaobs.getText());

        InterfaceDao i = new ProcessoDao();
        i.atualizar(p);
        busca("");
        cancelar();

    }

    private void dadostabela() {

        if (table.isEnabled()) {

            int seleciona = table.getSelectedRow();

            jtfid.setText(table.getModel().getValueAt(seleciona, 0).toString());
            jtfnomeCliente.setText(table.getModel().getValueAt(seleciona, 1).toString() + " " + table.getModel().getValueAt(seleciona, 2).toString());
            jtfparteNome.setText(table.getModel().getValueAt(seleciona, 3).toString());
            jtfnumeroProcesso.setText(table.getModel().getValueAt(seleciona, 4).toString());
            jtfnumeroPasta.setText(table.getModel().getValueAt(seleciona, 5).toString());

            if (table.getModel().getValueAt(seleciona, 6).toString().equalsIgnoreCase("n")) {
                jrbnovo.setSelected(true);
            } else if (table.getModel().getValueAt(seleciona, 6).toString().equalsIgnoreCase("a")) {
                jrbativo.setSelected(true);
            } else {
                jrbmorto.setSelected(true);
            }
            jtfacao.setText(table.getModel().getValueAt(seleciona, 7).toString());
            jtfIdCliente.setText(table.getModel().getValueAt(seleciona, 8).toString());
            System.out.println(Integer.parseInt(table.getModel().getValueAt(seleciona, 9).toString()));
            jcbvara.setSelectedIndex(Integer.parseInt(table.getModel().getValueAt(seleciona, 9).toString()) - 1);

            jtfdataInicio.setText(table.getModel().getValueAt(seleciona, 10).toString());
            jtfdataFim.setText(table.getModel().getValueAt(seleciona, 11).toString());
            jtfdiaSemana.setText(table.getModel().getValueAt(seleciona, 12).toString());
            jtanarrativa.setText(table.getModel().getValueAt(seleciona, 13).toString());
            jtaconsulta.setText(table.getModel().getValueAt(seleciona, 14).toString());
            jtaobs.setText(table.getModel().getValueAt(seleciona, 15).toString());
            jtfnumeroCliente.setText(table.getModel().getValueAt(seleciona, 16).toString());
            jtfrgCliente.setText(table.getModel().getValueAt(seleciona, 17).toString());
            jtfcpfCliente.setText(table.getModel().getValueAt(seleciona, 18).toString());

        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Consulta = new javax.swing.JPanel();
        jtfbusca = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jrbnome = new javax.swing.JRadioButton();
        jrbnumero = new javax.swing.JRadioButton();
        jrbsobrenome = new javax.swing.JRadioButton();
        jLabel5 = new javax.swing.JLabel();
        jScrollPanetable = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jbnovo = new javax.swing.JButton();
        jbinserir = new javax.swing.JButton();
        jbatualizar = new javax.swing.JButton();
        jbsalvaratualizar = new javax.swing.JButton();
        jbcancelar = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        aba2 = new javax.swing.JPanel();
        jpcliente = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jtfIdCliente = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jtfnomeCliente = new javax.swing.JTextField();
        jtfcpfCliente = new javax.swing.JTextField();
        jbbuscaCliente = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jtfrgCliente = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jtfnumeroCliente = new javax.swing.JTextField();
        aba1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jtfid = new javax.swing.JTextField();
        jtfnumeroProcesso = new JtextFieldSomenteNumeros(25);
        jLabel9 = new javax.swing.JLabel();
        jtfnumeroPasta = new JtextFieldSomenteNumeros(25);
        jLabel10 = new javax.swing.JLabel();
        jtfacao = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jtfdataInicio = new javax.swing.JTextField();
        jtfdataFim = new javax.swing.JTextField();
        jpandamento = new javax.swing.JPanel();
        jrbnovo = new javax.swing.JRadioButton();
        jrbativo = new javax.swing.JRadioButton();
        jrbmorto = new javax.swing.JRadioButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jtfparteNome = new JtextFieldSomenteLetras(100);
        jLabel2 = new javax.swing.JLabel();
        jtfdiaSemana = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtaobs = new javax.swing.JTextArea();
        jLabel6 = new javax.swing.JLabel();
        jtfnumeroMorto = new JtextFieldSomenteNumeros(25);
        jLabel7 = new javax.swing.JLabel();
        jcbvara = new javax.swing.JComboBox<>();
        aba3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jtanarrativa = new javax.swing.JTextArea();
        jScrollPane4 = new javax.swing.JScrollPane();
        jtaconsulta = new javax.swing.JTextArea();
        jbimprimir = new javax.swing.JButton();

        Consulta.setBorder(javax.swing.BorderFactory.createTitledBorder("Pesquisa"));

        jtfbusca.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtfbuscaKeyReleased(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Filtros"));

        jrbnome.setSelected(true);
        jrbnome.setText("Nome");

        jrbnumero.setText("Número do Processo");

        jrbsobrenome.setText("Sobrenome");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jrbnome)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jrbsobrenome)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jrbnumero)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jrbnumero)
                .addComponent(jrbnome)
                .addComponent(jrbsobrenome))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jrbnome, jrbnumero});

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/em/icons/busca.png"))); // NOI18N
        jLabel5.setText("Buscar");

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "Nome Cliente", "Sobrenome Cliente", "Nomeparte", "Número ", "Nº Pasta", "andamento", "acao", "idcli", "idvara", "dataI", "dataF", "dia", "narrativa", "consulta", "obs", "numerocli", "rg", "cpf"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false
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
        jScrollPanetable.setViewportView(table);
        if (table.getColumnModel().getColumnCount() > 0) {
            table.getColumnModel().getColumn(0).setMinWidth(0);
            table.getColumnModel().getColumn(0).setPreferredWidth(0);
            table.getColumnModel().getColumn(0).setMaxWidth(0);
            table.getColumnModel().getColumn(3).setMinWidth(0);
            table.getColumnModel().getColumn(3).setPreferredWidth(0);
            table.getColumnModel().getColumn(3).setMaxWidth(0);
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
            table.getColumnModel().getColumn(17).setMinWidth(0);
            table.getColumnModel().getColumn(17).setPreferredWidth(0);
            table.getColumnModel().getColumn(17).setMaxWidth(0);
            table.getColumnModel().getColumn(18).setMinWidth(0);
            table.getColumnModel().getColumn(18).setPreferredWidth(0);
            table.getColumnModel().getColumn(18).setMaxWidth(0);
        }

        javax.swing.GroupLayout ConsultaLayout = new javax.swing.GroupLayout(Consulta);
        Consulta.setLayout(ConsultaLayout);
        ConsultaLayout.setHorizontalGroup(
            ConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ConsultaLayout.createSequentialGroup()
                .addGroup(ConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ConsultaLayout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtfbusca))
                    .addGroup(ConsultaLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPanetable)))
                .addContainerGap())
        );
        ConsultaLayout.setVerticalGroup(
            ConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ConsultaLayout.createSequentialGroup()
                .addGroup(ConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ConsultaLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(ConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jtfbusca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPanetable, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

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

        jLabel13.setText("Id:");

        jLabel14.setText("CPF:");

        jtfIdCliente.setEnabled(false);

        jLabel15.setText("Nome:");

        jtfnomeCliente.setEnabled(false);

        jtfcpfCliente.setEnabled(false);

        jbbuscaCliente.setText("Buscar Cliente");
        jbbuscaCliente.setEnabled(false);
        jbbuscaCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbbuscaClienteActionPerformed(evt);
            }
        });

        jLabel3.setText("RG:");

        jtfrgCliente.setEnabled(false);

        jLabel4.setText("Número:");

        jtfnumeroCliente.setEnabled(false);

        javax.swing.GroupLayout jpclienteLayout = new javax.swing.GroupLayout(jpcliente);
        jpcliente.setLayout(jpclienteLayout);
        jpclienteLayout.setHorizontalGroup(
            jpclienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpclienteLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jpclienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpclienteLayout.createSequentialGroup()
                        .addComponent(jbbuscaCliente)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtfIdCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtfnumeroCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpclienteLayout.createSequentialGroup()
                        .addGroup(jpclienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel15)
                            .addComponent(jLabel14))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jpclienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtfnomeCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 750, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jpclienteLayout.createSequentialGroup()
                                .addComponent(jtfcpfCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jtfrgCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(152, Short.MAX_VALUE))
        );
        jpclienteLayout.setVerticalGroup(
            jpclienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpclienteLayout.createSequentialGroup()
                .addGroup(jpclienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbbuscaCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(jtfIdCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jtfnumeroCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addGroup(jpclienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfnomeCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15))
                .addGap(18, 18, 18)
                .addGroup(jpclienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(jtfcpfCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jtfrgCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(53, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout aba2Layout = new javax.swing.GroupLayout(aba2);
        aba2.setLayout(aba2Layout);
        aba2Layout.setHorizontalGroup(
            aba2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(aba2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpcliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        aba2Layout.setVerticalGroup(
            aba2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, aba2Layout.createSequentialGroup()
                .addContainerGap(26, Short.MAX_VALUE)
                .addComponent(jpcliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Dados do Cliente", aba2);

        jLabel1.setText("Id:");

        jtfid.setEnabled(false);

        jtfnumeroProcesso.setEnabled(false);

        jLabel9.setText("Número da Pasta:");

        jtfnumeroPasta.setEnabled(false);

        jLabel10.setText("Acão:");

        jtfacao.setEnabled(false);

        jLabel11.setText("Data de Inicio:");

        jLabel12.setText("Data de Fim:");

        try {
            javax.swing.text.MaskFormatter nsc= new javax.swing.text.MaskFormatter("##/##/####");
            jtfdataInicio = new javax.swing.JFormattedTextField(nsc);
        } catch (Exception exception) {

        }
        jtfdataInicio.setEnabled(false);

        try {
            javax.swing.text.MaskFormatter nsc= new javax.swing.text.MaskFormatter("##/##/####");
            jtfdataFim = new javax.swing.JFormattedTextField(nsc);
        } catch (Exception exception) {

        }
        jtfdataFim.setEnabled(false);

        jpandamento.setBorder(javax.swing.BorderFactory.createTitledBorder("Andamento"));

        jrbnovo.setSelected(true);
        jrbnovo.setText("Novo");
        jrbnovo.setEnabled(false);
        jrbnovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbnovoActionPerformed(evt);
            }
        });

        jrbativo.setText("Ativo");
        jrbativo.setEnabled(false);
        jrbativo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbativoActionPerformed(evt);
            }
        });

        jrbmorto.setText("Morto");
        jrbmorto.setEnabled(false);
        jrbmorto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbmortoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpandamentoLayout = new javax.swing.GroupLayout(jpandamento);
        jpandamento.setLayout(jpandamentoLayout);
        jpandamentoLayout.setHorizontalGroup(
            jpandamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpandamentoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jrbnovo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jrbativo)
                .addGap(2, 2, 2)
                .addComponent(jrbmorto)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpandamentoLayout.setVerticalGroup(
            jpandamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpandamentoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpandamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jrbnovo)
                    .addComponent(jrbativo)
                    .addComponent(jrbmorto)))
        );

        jLabel8.setText("Número do Processo:");

        jLabel18.setText("Parte Nome:");

        jtfparteNome.setEnabled(false);

        jLabel2.setText("Dia da Semana:");

        jtfdiaSemana.setEnabled(false);

        jScrollPane2.setBorder(javax.swing.BorderFactory.createTitledBorder("Observações"));

        jtaobs.setColumns(20);
        jtaobs.setRows(5);
        jtaobs.setEnabled(false);
        jScrollPane2.setViewportView(jtaobs);

        jLabel6.setText("Número Morto:");

        jtfnumeroMorto.setEnabled(false);

        jLabel7.setText("Vara:");

        jcbvara.setEnabled(false);

        javax.swing.GroupLayout aba1Layout = new javax.swing.GroupLayout(aba1);
        aba1.setLayout(aba1Layout);
        aba1Layout.setHorizontalGroup(
            aba1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(aba1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(aba1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(aba1Layout.createSequentialGroup()
                        .addGroup(aba1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel12)
                            .addComponent(jLabel11)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(aba1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(aba1Layout.createSequentialGroup()
                                .addGroup(aba1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jtfdataInicio, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                                    .addComponent(jtfdataFim))
                                .addGap(18, 18, 18)
                                .addGroup(aba1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(aba1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jtfdiaSemana, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jtfnumeroMorto, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jcbvara, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2))
                    .addGroup(aba1Layout.createSequentialGroup()
                        .addGroup(aba1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel18)
                            .addComponent(jLabel10)
                            .addComponent(jLabel1))
                        .addGap(4, 4, 4)
                        .addGroup(aba1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(aba1Layout.createSequentialGroup()
                                .addComponent(jtfid, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 66, Short.MAX_VALUE)
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jtfnumeroProcesso, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jtfnumeroPasta, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jpandamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(aba1Layout.createSequentialGroup()
                                .addComponent(jtfparteNome)
                                .addGap(199, 199, 199))
                            .addComponent(jtfacao))))
                .addContainerGap())
        );
        aba1Layout.setVerticalGroup(
            aba1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(aba1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(aba1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(aba1Layout.createSequentialGroup()
                        .addGroup(aba1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jtfid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)
                            .addComponent(jtfnumeroProcesso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9)
                            .addComponent(jtfnumeroPasta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(aba1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel18)
                            .addComponent(jtfparteNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jpandamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(aba1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jtfacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(aba1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(aba1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(aba1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(jtfdataInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(jtfdiaSemana, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(aba1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(jtfdataFim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)
                            .addComponent(jtfnumeroMorto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(aba1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(jcbvara, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, aba1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );

        jTabbedPane1.addTab("Dados do Processo", aba1);

        jScrollPane3.setBorder(javax.swing.BorderFactory.createTitledBorder("Narrativa"));

        jtanarrativa.setColumns(20);
        jtanarrativa.setRows(5);
        jtanarrativa.setEnabled(false);
        jScrollPane3.setViewportView(jtanarrativa);

        jScrollPane4.setBorder(javax.swing.BorderFactory.createTitledBorder("Consulta"));

        jtaconsulta.setColumns(20);
        jtaconsulta.setRows(5);
        jtaconsulta.setEnabled(false);
        jScrollPane4.setViewportView(jtaconsulta);

        javax.swing.GroupLayout aba3Layout = new javax.swing.GroupLayout(aba3);
        aba3.setLayout(aba3Layout);
        aba3Layout.setHorizontalGroup(
            aba3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(aba3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 441, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 485, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        aba3Layout.setVerticalGroup(
            aba3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, aba3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(aba3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane4)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Narrativa e Consulta", aba3);

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
                    .addComponent(Consulta, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jbimprimir)
                        .addGap(18, 18, 18)
                        .addComponent(jbnovo, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jbinserir, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jbatualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jbsalvaratualizar)
                        .addGap(18, 18, 18)
                        .addComponent(jbcancelar))
                    .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(Consulta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
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
        updateliberar();
    }//GEN-LAST:event_jbatualizarActionPerformed

    private void jbsalvaratualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbsalvaratualizarActionPerformed
        update();
    }//GEN-LAST:event_jbsalvaratualizarActionPerformed

    private void jbcancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbcancelarActionPerformed
        cancelar();
    }//GEN-LAST:event_jbcancelarActionPerformed

    private void jbbuscaClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbbuscaClienteActionPerformed
        JdBuscaCliente tbc = new JdBuscaCliente(null, true);
        tbc.setVisible(true);
        jtfIdCliente.setText(tbc.idcli);
        jtfnumeroCliente.setText(tbc.numerocli);
        jtfnomeCliente.setText(tbc.nomecli + " " + tbc.sobrenomecli);
        jtfcpfCliente.setText(tbc.cpfcli);
        jtfrgCliente.setText(tbc.rgcli);
    }//GEN-LAST:event_jbbuscaClienteActionPerformed

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked
        dadostabela();
    }//GEN-LAST:event_tableMouseClicked

    private void jrbmortoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbmortoActionPerformed
        jtfnumeroMorto.setEnabled(true);
    }//GEN-LAST:event_jrbmortoActionPerformed

    private void jrbnovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbnovoActionPerformed
        jtfnumeroMorto.setEnabled(false);
    }//GEN-LAST:event_jrbnovoActionPerformed

    private void jrbativoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbativoActionPerformed
        jtfnumeroMorto.setEnabled(false);
    }//GEN-LAST:event_jrbativoActionPerformed

    private void jtfbuscaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfbuscaKeyReleased
        busca(jtfbusca.getText());
    }//GEN-LAST:event_jtfbuscaKeyReleased

    private void jbimprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbimprimirActionPerformed
        if (!jtfid.getText().isEmpty()) {
            Map parametros = new HashMap();
            parametros.put("id_processo", Integer.parseInt(jtfid.getText()));
            RelatorioCliente rc = new RelatorioCliente(parametros);
        } else {
            JOptionPane.showMessageDialog(null, "Para Imprimir é Necessário Selecionar um Processo na Tabela");
        }

    }//GEN-LAST:event_jbimprimirActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Consulta;
    private javax.swing.JPanel aba1;
    private javax.swing.JPanel aba2;
    private javax.swing.JPanel aba3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPanetable;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JButton jbatualizar;
    private javax.swing.JButton jbbuscaCliente;
    private javax.swing.JButton jbcancelar;
    private javax.swing.JButton jbimprimir;
    private javax.swing.JButton jbinserir;
    private javax.swing.JButton jbnovo;
    private javax.swing.JButton jbsalvaratualizar;
    private javax.swing.JComboBox<String> jcbvara;
    private javax.swing.JPanel jpandamento;
    private javax.swing.JPanel jpcliente;
    private javax.swing.JRadioButton jrbativo;
    private javax.swing.JRadioButton jrbmorto;
    private javax.swing.JRadioButton jrbnome;
    private javax.swing.JRadioButton jrbnovo;
    private javax.swing.JRadioButton jrbnumero;
    private javax.swing.JRadioButton jrbsobrenome;
    private javax.swing.JTextArea jtaconsulta;
    private javax.swing.JTextArea jtanarrativa;
    private javax.swing.JTextArea jtaobs;
    private javax.swing.JTextField jtfIdCliente;
    private javax.swing.JTextField jtfacao;
    private javax.swing.JTextField jtfbusca;
    private javax.swing.JTextField jtfcpfCliente;
    private javax.swing.JTextField jtfdataFim;
    private javax.swing.JTextField jtfdataInicio;
    private javax.swing.JTextField jtfdiaSemana;
    private javax.swing.JTextField jtfid;
    private javax.swing.JTextField jtfnomeCliente;
    private javax.swing.JTextField jtfnumeroCliente;
    private javax.swing.JTextField jtfnumeroMorto;
    private javax.swing.JTextField jtfnumeroPasta;
    private javax.swing.JTextField jtfnumeroProcesso;
    private javax.swing.JTextField jtfparteNome;
    private javax.swing.JTextField jtfrgCliente;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables

}
