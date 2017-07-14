/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.em.secretaria;

import br.com.em.dao.InterfaceDao;
import br.com.em.dao.ProcessoDao;
import br.com.em.extra.JPanelBuscaJtextFild;
import br.com.em.modelo.Processo;
import java.util.List;
import javax.swing.ButtonGroup;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author pablo
 */
public class JpCadastrarProcesso extends javax.swing.JPanel {

    /**
     * Creates new form jpCadastrarCliente
     */
    public JpCadastrarProcesso() {
        initComponents();
        ButtonGroup group = new ButtonGroup();
        group.add(jrbnome);
        group.add(jrbsobrenome);
        group.add(jrbnumero);

        ButtonGroup group2 = new ButtonGroup();
        group2.add(jrbnovo);
        group2.add(jrbativo);
        group2.add(jrbmorto);
    }

    private void novo() {

        JPanelBuscaJtextFild.limpaCampo(aba1);
        JPanelBuscaJtextFild.liberaCampo(aba1, true);

        JPanelBuscaJtextFild.limpaCampo(aba3);
        JPanelBuscaJtextFild.liberaCampo(aba3, true);

        jtaconsulta.setEnabled(true);
        jtanarrativa.setEnabled(true);
        jtfid.setEnabled(false);

        //     JPanelBuscaJtextFild.limpaCampo(jpcliente);
        //     JPanelBuscaJtextFild.limpaCampo(jpvara);
        jbbuscaCliente.setEnabled(true);
        jbbuscaVara.setEnabled(true);

        jrbnovo.setEnabled(true);
        //  jrbativo.setEnabled(true);
        // jrbmorto.setEnabled(true);

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

        jbbuscaCliente.setEnabled(false);
        jbbuscaVara.setEnabled(false);

        jrbnovo.setEnabled(false);
        jrbativo.setEnabled(false);
        jrbmorto.setEnabled(false);

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
        jbbuscaVara.setEnabled(true);

        jtaconsulta.setEnabled(true);
        jtanarrativa.setEnabled(true);
        jtfid.setEnabled(false);

        jrbnovo.setEnabled(true);
        jrbativo.setEnabled(true);
        jrbmorto.setEnabled(true);

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

        InterfaceDao di = new ProcessoDao();

        List<Processo> list = di.listar(busca, auxBusca);

        DefaultTableModel tableModel = (DefaultTableModel) jTable.getModel();
        tableModel.setNumRows(0);

        list.stream().forEach((Processo lista) -> {
            tableModel.addRow(new Object[]{
                lista.getId_processo(),
                lista.getNome_processo(),
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
                lista.getObs_processo()
            });
        });

    }

    private void dadostabela() {

        if (jTable.isEnabled()) {
            int seleciona = jTable.getSelectedRow();

            jtfid.setText(jTable.getModel().getValueAt(seleciona, 0).toString());
            jtfparteNome.setText(jTable.getModel().getValueAt(seleciona, 1).toString());
            jtfnumeroProcesso.setText(jTable.getModel().getValueAt(seleciona, 2).toString());
            jtfnumeroPasta.setText(jTable.getModel().getValueAt(seleciona, 3).toString());

            if (jTable.getModel().getValueAt(seleciona, 3).toString().equalsIgnoreCase("n")) {
                jrbnovo.setSelected(true);
            } else if (jTable.getModel().getValueAt(seleciona, 3).toString().equalsIgnoreCase("a")) {
                jrbativo.setSelected(true);
            } else {
                jrbmorto.setSelected(true);
            }
            jtfacao.setText(jTable.getModel().getValueAt(seleciona, 5).toString());
            jtfIdCliente.setText(jTable.getModel().getValueAt(seleciona, 6).toString());
            jtfidVara.setText(jTable.getModel().getValueAt(seleciona, 7).toString());
            jtfdataInicio.setText(jTable.getModel().getValueAt(seleciona, 8).toString());
            jtfdataFim.setText(jTable.getModel().getValueAt(seleciona, 9).toString());
            jtfdiaSemana.setText(jTable.getModel().getValueAt(seleciona, 10).toString());
            jtanarrativa.setText(jTable.getModel().getValueAt(seleciona, 11).toString());
            jtaconsulta.setText(jTable.getModel().getValueAt(seleciona, 12).toString());
            jtaobs.setText(jTable.getModel().getValueAt(seleciona, 13).toString());

        }
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
        p.setId_vara(jtfidVara.getText());
        p.setDataInicio_processo(jtfdataInicio.getText());
        p.setDataFim_processo(jtfdataFim.getText());
        p.setDiaSemana_processo(jtfdiaSemana.getText());
        p.setNarrativa_processo(jtanarrativa.getText());
        p.setConsulta_processo(jtaconsulta.getText());
        p.setObs_processo(jtaobs.getText());

        InterfaceDao i = new ProcessoDao();
        i.cadastrar(p);
//        busca("");
        cancelar();
    }

    private void update() {

        Processo p = new Processo();

        p.setNome_processo(jtfparteNome.getText());
        p.setNumero_processo(jtfnumeroProcesso.getText());
        p.setNumeroPasta_processo(jtfnumeroPasta.getText());
        p.setAndamento_processo("n");
        p.setAcao_processo(jtfacao.getText());
        p.setId_cliente(jtfIdCliente.getText());
        p.setId_vara(jtfidVara.getText());
        p.setDataInicio_processo(jtfdataInicio.getText());
        p.setDataFim_processo(jtfdataFim.getText());
        p.setDiaSemana_processo(jtfdiaSemana.getText());
        p.setNarrativa_processo(jtanarrativa.getText());
        p.setConsulta_processo(jtaconsulta.getText());
        p.setObs_processo(jtaobs.getText());

        InterfaceDao i = new ProcessoDao();
        i.atualizar(p);
//        busca("");
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

        Consulta = new javax.swing.JPanel();
        jtfbusca4 = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jrbnome = new javax.swing.JRadioButton();
        jrbnumero = new javax.swing.JRadioButton();
        jrbsobrenome = new javax.swing.JRadioButton();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable = new javax.swing.JTable();
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
        jtfnumeroProcesso = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jtfnumeroPasta = new javax.swing.JTextField();
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
        jtfparteNome = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jtfdiaSemana = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtaobs = new javax.swing.JTextArea();
        jLabel6 = new javax.swing.JLabel();
        jtfnumeroMorto = new javax.swing.JTextField();
        aba3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jtanarrativa = new javax.swing.JTextArea();
        jScrollPane4 = new javax.swing.JScrollPane();
        jtaconsulta = new javax.swing.JTextArea();
        aba4 = new javax.swing.JPanel();
        jpvara = new javax.swing.JPanel();
        jbbuscaVara = new javax.swing.JButton();
        jtfidVara = new javax.swing.JTextField();
        jtfnomeVara = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();

        Consulta.setBorder(javax.swing.BorderFactory.createTitledBorder("Pesquisa"));

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

        jTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "Nome", "Número ", "Nº Pasta", "andamento", "idcli", "idvara", "dataI", "dataF", "dia", "narrativa", "consulta", "obs"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable.setColumnSelectionAllowed(true);
        jTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTable);
        jTable.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        if (jTable.getColumnModel().getColumnCount() > 0) {
            jTable.getColumnModel().getColumn(0).setMinWidth(0);
            jTable.getColumnModel().getColumn(0).setPreferredWidth(0);
            jTable.getColumnModel().getColumn(0).setMaxWidth(0);
            jTable.getColumnModel().getColumn(4).setMinWidth(0);
            jTable.getColumnModel().getColumn(4).setPreferredWidth(0);
            jTable.getColumnModel().getColumn(4).setMaxWidth(0);
            jTable.getColumnModel().getColumn(5).setMinWidth(0);
            jTable.getColumnModel().getColumn(5).setPreferredWidth(0);
            jTable.getColumnModel().getColumn(5).setMaxWidth(0);
            jTable.getColumnModel().getColumn(6).setMinWidth(0);
            jTable.getColumnModel().getColumn(6).setPreferredWidth(0);
            jTable.getColumnModel().getColumn(6).setMaxWidth(0);
            jTable.getColumnModel().getColumn(7).setMinWidth(0);
            jTable.getColumnModel().getColumn(7).setPreferredWidth(0);
            jTable.getColumnModel().getColumn(7).setMaxWidth(0);
            jTable.getColumnModel().getColumn(8).setMinWidth(0);
            jTable.getColumnModel().getColumn(8).setPreferredWidth(0);
            jTable.getColumnModel().getColumn(8).setMaxWidth(0);
            jTable.getColumnModel().getColumn(9).setMinWidth(0);
            jTable.getColumnModel().getColumn(9).setPreferredWidth(0);
            jTable.getColumnModel().getColumn(9).setMaxWidth(0);
            jTable.getColumnModel().getColumn(10).setMinWidth(0);
            jTable.getColumnModel().getColumn(10).setPreferredWidth(0);
            jTable.getColumnModel().getColumn(10).setMaxWidth(0);
            jTable.getColumnModel().getColumn(11).setMinWidth(0);
            jTable.getColumnModel().getColumn(11).setPreferredWidth(0);
            jTable.getColumnModel().getColumn(11).setMaxWidth(0);
            jTable.getColumnModel().getColumn(12).setMinWidth(0);
            jTable.getColumnModel().getColumn(12).setPreferredWidth(0);
            jTable.getColumnModel().getColumn(12).setMaxWidth(0);
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
                        .addComponent(jtfbusca4))
                    .addGroup(ConsultaLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1)))
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
                            .addComponent(jtfbusca4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
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

        jbbuscaCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/em/icons/busca.png"))); // NOI18N
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
                .addGroup(jpclienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel15)
                    .addComponent(jLabel13)
                    .addComponent(jLabel14))
                .addGroup(jpclienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpclienteLayout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jtfIdCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel4)
                        .addGap(12, 12, 12)
                        .addComponent(jtfnumeroCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jbbuscaCliente)
                        .addContainerGap())
                    .addGroup(jpclienteLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jpclienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpclienteLayout.createSequentialGroup()
                                .addComponent(jtfcpfCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jtfrgCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(540, Short.MAX_VALUE))
                            .addGroup(jpclienteLayout.createSequentialGroup()
                                .addComponent(jtfnomeCliente)
                                .addGap(94, 94, 94))))))
        );
        jpclienteLayout.setVerticalGroup(
            jpclienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpclienteLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jpclienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpclienteLayout.createSequentialGroup()
                        .addGroup(jpclienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtfnumeroCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jpclienteLayout.createSequentialGroup()
                        .addGroup(jpclienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtfIdCliente)
                            .addComponent(jLabel13))
                        .addGap(25, 25, 25)
                        .addGroup(jpclienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtfnomeCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15))
                        .addGap(18, 18, 18)
                        .addGroup(jpclienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(jtfcpfCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(jtfrgCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(50, Short.MAX_VALUE))
                    .addGroup(jpclienteLayout.createSequentialGroup()
                        .addComponent(jbbuscaCliente)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
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
                .addContainerGap(41, Short.MAX_VALUE)
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

        jtfdataInicio.setEnabled(false);

        jtfdataFim.setEnabled(false);

        jpandamento.setBorder(javax.swing.BorderFactory.createTitledBorder("Andamento"));

        jrbnovo.setSelected(true);
        jrbnovo.setText("Novo");
        jrbnovo.setEnabled(false);

        jrbativo.setText("Ativo");
        jrbativo.setEnabled(false);

        jrbmorto.setText("Morto");
        jrbmorto.setEnabled(false);

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
                            .addComponent(jLabel11))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
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
                            .addComponent(jtfnumeroMorto, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, aba1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

        jbbuscaVara.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/em/icons/busca.png"))); // NOI18N
        jbbuscaVara.setEnabled(false);
        jbbuscaVara.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbbuscaVaraActionPerformed(evt);
            }
        });

        jtfidVara.setEnabled(false);

        jtfnomeVara.setEnabled(false);

        jLabel19.setText("Nome:");

        jLabel20.setText("Id:");

        javax.swing.GroupLayout jpvaraLayout = new javax.swing.GroupLayout(jpvara);
        jpvara.setLayout(jpvaraLayout);
        jpvaraLayout.setHorizontalGroup(
            jpvaraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpvaraLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpvaraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel20)
                    .addComponent(jLabel19))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpvaraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpvaraLayout.createSequentialGroup()
                        .addComponent(jtfidVara, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 756, Short.MAX_VALUE)
                        .addComponent(jbbuscaVara))
                    .addComponent(jtfnomeVara))
                .addContainerGap())
        );
        jpvaraLayout.setVerticalGroup(
            jpvaraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpvaraLayout.createSequentialGroup()
                .addGroup(jpvaraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpvaraLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jpvaraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel20)
                            .addComponent(jtfidVara, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jbbuscaVara))
                .addGap(18, 18, 18)
                .addGroup(jpvaraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel19)
                    .addComponent(jtfnomeVara, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(79, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout aba4Layout = new javax.swing.GroupLayout(aba4);
        aba4.setLayout(aba4Layout);
        aba4Layout.setHorizontalGroup(
            aba4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 990, Short.MAX_VALUE)
            .addGroup(aba4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(aba4Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jpvara, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        aba4Layout.setVerticalGroup(
            aba4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 203, Short.MAX_VALUE)
            .addGroup(aba4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, aba4Layout.createSequentialGroup()
                    .addContainerGap(41, Short.MAX_VALUE)
                    .addComponent(jpvara, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
        );

        jTabbedPane1.addTab("Dados da Vara", aba4);

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
                        .addComponent(jbnovo, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbinserir, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
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
                    .addComponent(jbnovo))
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
        // TODO add your handling code here:
    }//GEN-LAST:event_jbbuscaClienteActionPerformed

    private void jbbuscaVaraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbbuscaVaraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbbuscaVaraActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Consulta;
    private javax.swing.JPanel aba1;
    private javax.swing.JPanel aba2;
    private javax.swing.JPanel aba3;
    private javax.swing.JPanel aba4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable;
    private javax.swing.JButton jbatualizar;
    private javax.swing.JButton jbbuscaCliente;
    private javax.swing.JButton jbbuscaVara;
    private javax.swing.JButton jbcancelar;
    private javax.swing.JButton jbinserir;
    private javax.swing.JButton jbnovo;
    private javax.swing.JButton jbsalvaratualizar;
    private javax.swing.JPanel jpandamento;
    private javax.swing.JPanel jpcliente;
    private javax.swing.JPanel jpvara;
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
    private javax.swing.JTextField jtfbusca4;
    private javax.swing.JTextField jtfcpfCliente;
    private javax.swing.JTextField jtfdataFim;
    private javax.swing.JTextField jtfdataInicio;
    private javax.swing.JTextField jtfdiaSemana;
    private javax.swing.JTextField jtfid;
    private javax.swing.JTextField jtfidVara;
    private javax.swing.JTextField jtfnomeCliente;
    private javax.swing.JTextField jtfnomeVara;
    private javax.swing.JTextField jtfnumeroCliente;
    private javax.swing.JTextField jtfnumeroMorto;
    private javax.swing.JTextField jtfnumeroPasta;
    private javax.swing.JTextField jtfnumeroProcesso;
    private javax.swing.JTextField jtfparteNome;
    private javax.swing.JTextField jtfrgCliente;
    // End of variables declaration//GEN-END:variables

}
