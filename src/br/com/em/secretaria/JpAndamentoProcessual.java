/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.em.secretaria;

import br.com.em.dao.DefesasPreviasDao;
import br.com.em.dao.InterfaceDao;
import br.com.em.dao.PeticoesIniciaisDao;
import br.com.em.dao.PeticoesSimplesDao;
import br.com.em.extra.JPanelBuscaJtextFild;
import br.com.em.modelo.DefesasPrevias;
import br.com.em.modelo.PeticoesIniciais;
import br.com.em.modelo.PeticoesSimples;
import java.util.Date;
import java.util.List;
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author pablo
 */
public class JpAndamentoProcessual extends javax.swing.JPanel {

    /**
     * Creates new form jpCadastrarCliente
     */
    ButtonGroup group = new ButtonGroup();

    public JpAndamentoProcessual() {
        initComponents();

        group.add(jrbPeticoesIniciais);
        group.add(jrbDefesasPrevias);
        group.add(jrbPeticoesSimples);

    }

    public void busca() {

        if (!(jrbPeticoesIniciais.isSelected() | jrbDefesasPrevias.isSelected() | jrbPeticoesSimples.isSelected())) {
            JOptionPane.showMessageDialog(null, "É Preciso Selecionar o Tipo de Tabela");
        } else {
            if (jrbPeticoesIniciais.isSelected()) {

                InterfaceDao i = new PeticoesIniciaisDao();
                List<PeticoesIniciais> list = i.listar(String.valueOf(jycFiltro.getYear() - 2000), "");
                DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
                tableModel.setNumRows(0);

                list.stream().forEach((PeticoesIniciais lista) -> {
                    tableModel.addRow(new Object[]{
                        // lista.getId_agenda(),
                        lista.getId_peticoesIniciais(),
                        lista.getData_peticoesIniciais(),
                        lista.getId_cliente(),
                        lista.getId_processo(),
                        lista.getNome_pessoa() + " " + lista.getSobrenome_pessoa(),
                        lista.getAcao_processo(),
                        lista.getNumero_processo(),
                        lista.getNumero_cliente(),
                        lista.getNumeroPasta_processo(),});
                });
            } else if (jrbDefesasPrevias.isSelected()) {

                InterfaceDao i = new DefesasPreviasDao();
                List<DefesasPrevias> list = i.listar(String.valueOf(jycFiltro.getYear() - 2000), "");
                DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
                tableModel.setNumRows(0);

                list.stream().forEach((DefesasPrevias lista) -> {
                    tableModel.addRow(new Object[]{
                        // lista.getId_agenda(),
                        lista.getId_defesaPrevia(),
                        lista.getData_defesaPrevia(),
                        lista.getId_cliente(),
                        lista.getId_processo(),
                        lista.getNome_pessoa() + " " + lista.getSobrenome_pessoa(),
                        lista.getAcao_processo(),
                        lista.getNumero_processo(),
                        lista.getNumero_cliente(),
                        lista.getNumeroPasta_processo(),});
                });

            } else {

                InterfaceDao i = new PeticoesSimplesDao();
                List<PeticoesSimples> list = i.listar(String.valueOf(jycFiltro.getYear() - 2000), "");
                DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
                tableModel.setNumRows(0);

                list.stream().forEach((PeticoesSimples lista) -> {
                    tableModel.addRow(new Object[]{
                        // lista.getId_agenda(),
                        lista.getId_peticoesSimples(),
                        lista.getData_peticoesSimples(),
                        lista.getId_cliente(),
                        lista.getId_processo(),
                        lista.getNome_pessoa() + " " + lista.getSobrenome_pessoa(),
                        lista.getAcao_processo(),
                        lista.getNumero_processo(),
                        lista.getNumero_cliente(),
                        lista.getNumeroPasta_processo(),});
                });
            }
        }

        table.updateUI();

    }

    public void dadostabela() {
        if (table.isEnabled()) {

            int seleciona = table.getSelectedRow();

            jtfid.setText(table.getModel().getValueAt(seleciona, 0).toString());

            Date data = new Date();
            data.setDate(Integer.valueOf(table.getModel().getValueAt(seleciona, 1).toString().substring(0, 2)));
            data.setMonth(Integer.valueOf(table.getModel().getValueAt(seleciona, 1).toString().substring(3, 5)));
            data.setYear(Integer.valueOf(table.getModel().getValueAt(seleciona, 1).toString().substring(6, 8)) + 100);
            jcData.setDate(data);

            jtfIdCliente.setText(table.getModel().getValueAt(seleciona, 2).toString());
            jtfIdProcesso.setText(table.getModel().getValueAt(seleciona, 3).toString());
            jtfNomeCliente.setText(table.getModel().getValueAt(seleciona, 4).toString());
            jtfAcao.setText(table.getModel().getValueAt(seleciona, 5).toString());
            jtfNumeroProcesso.setText(table.getModel().getValueAt(seleciona, 6).toString());
            jtfNumeroCliente.setText(table.getModel().getValueAt(seleciona, 7).toString());
            jtfNumeroPasta.setText(table.getModel().getValueAt(seleciona, 8).toString());
        }
    }

    public void novo() {

        jcData.setEnabled(true);
        jbBuscaProcesso.setEnabled(true);
        table.setEnabled(false);

        jrbPeticoesIniciais.setEnabled(false);
        jrbDefesasPrevias.setEnabled(false);
        jrbPeticoesSimples.setEnabled(false);
        jbBuscaTabela.setEnabled(false);

        JPanelBuscaJtextFild.limpaCampo(jpDados);

        jbinserir.setEnabled(true);
        jbatualizar.setEnabled(false);
        jbcancelar.setEnabled(true);
        jbnovo.setEnabled(false);
        jtfid.setEnabled(false);
    }

    public void cancelar() {

        jcData.setEnabled(false);
        jbBuscaProcesso.setEnabled(false);
        table.setEnabled(true);

        jrbPeticoesIniciais.setEnabled(true);
        jrbDefesasPrevias.setEnabled(true);
        jrbPeticoesSimples.setEnabled(true);
        jbBuscaTabela.setEnabled(true);

        JPanelBuscaJtextFild.limpaCampo(jpDados);

        jbinserir.setEnabled(false);
        jbatualizar.setEnabled(true);
        jbsalvaratualizar.setEnabled(false);
        jbcancelar.setEnabled(true);
        jbnovo.setEnabled(true);
    }

    public void updateLiberar() {

        jcData.setEnabled(true);
        jbBuscaProcesso.setEnabled(true);
        table.setEnabled(true);

        jrbPeticoesIniciais.setEnabled(false);
        jrbDefesasPrevias.setEnabled(false);
        jrbPeticoesSimples.setEnabled(false);
        jbBuscaTabela.setEnabled(false);

        jbsalvaratualizar.setEnabled(true);
        jbinserir.setEnabled(false);
        jbatualizar.setEnabled(false);
        jbcancelar.setEnabled(true);
        jbnovo.setEnabled(false);
    }

    public void update() {
        if (!jtfid.getText().isEmpty()) {
            if (jrbPeticoesIniciais.isSelected()) {
                PeticoesIniciais pi = new PeticoesIniciais();
                pi.setData_peticoesIniciais(jcData.getDate().toString().format("%1$td-%1$tm-%1$ty", jcData.getDate()));
                pi.setId_cliente(jtfIdCliente.getText());
                pi.setId_processo(jtfIdProcesso.getText());
                pi.setId_peticoesIniciais(jtfid.getText());

                InterfaceDao i = new PeticoesIniciaisDao();
                i.atualizar(pi);

            } else if (jrbDefesasPrevias.isSelected()) {

                DefesasPrevias dp = new DefesasPrevias();
                dp.setData_defesaPrevia(jcData.getDate().toString().format("%1$td-%1$tm-%1$ty", jcData.getDate()));
                dp.setId_cliente(jtfIdCliente.getText());
                dp.setId_processo(jtfIdProcesso.getText());
                dp.setId_defesaPrevia(jtfid.getText());

                InterfaceDao idp = new DefesasPreviasDao();
                idp.atualizar(dp);

            } else {
                PeticoesSimples ps = new PeticoesSimples();
                ps.setData_peticoesSimples(jcData.getDate().toString().format("%1$td-%1$tm-%1$ty", jcData.getDate()));
                ps.setId_cliente(jtfIdCliente.getText());
                ps.setId_processo(jtfIdProcesso.getText());
                ps.setId_peticoesSimples(jtfid.getText());

                InterfaceDao ips = new PeticoesSimplesDao();
                ips.atualizar(ps);
            }

            busca();
            cancelar();
        } else {
            JOptionPane.showMessageDialog(null, "É necessário selecionar um dado na tabela");
        }
    }

    public void save() {
        if (!jtfIdProcesso.getText().isEmpty()) {
            JComboBox jcb = new JComboBox();

            jcb.addItem("Petições Iniciais");
            jcb.addItem("Defesas Previas");
            jcb.addItem("Petições Simples");

            JOptionPane.showMessageDialog(null, jcb, "Selecione a tabela correspondente", JOptionPane.QUESTION_MESSAGE);
// jcb.getSelectedIndex() começa em 0

            switch (jcb.getSelectedIndex()) {
                case 0:
                    PeticoesIniciais pi = new PeticoesIniciais();
                    pi.setData_peticoesIniciais(jcData.getDate().toString().format("%1$td-%1$tm-%1$ty", jcData.getDate()));
                    pi.setId_cliente(jtfIdCliente.getText());
                    pi.setId_processo(jtfIdProcesso.getText());

                    InterfaceDao i = new PeticoesIniciaisDao();
                    i.cadastrar(pi);
                    jrbPeticoesIniciais.setSelected(true);
                    break;
                case 1:
                    DefesasPrevias dp = new DefesasPrevias();
                    dp.setData_defesaPrevia(jcData.getDate().toString().format("%1$td-%1$tm-%1$ty", jcData.getDate()));
                    dp.setId_cliente(jtfIdCliente.getText());
                    dp.setId_processo(jtfIdProcesso.getText());

                    InterfaceDao idp = new DefesasPreviasDao();
                    idp.cadastrar(dp);
                    jrbDefesasPrevias.setSelected(true);
                    break;
                case 2:
                    PeticoesSimples ps = new PeticoesSimples();
                    ps.setData_peticoesSimples(jcData.getDate().toString().format("%1$td-%1$tm-%1$ty", jcData.getDate()));
                    ps.setId_cliente(jtfIdCliente.getText());
                    ps.setId_processo(jtfIdProcesso.getText());

                    InterfaceDao ips = new PeticoesSimplesDao();
                    ips.cadastrar(ps);
                    jrbPeticoesSimples.setSelected(true);
                    break;
                default:
                    System.out.println("error");

            }
            busca();
            cancelar();
        } else {
            JOptionPane.showMessageDialog(null, "É necessário adicionar um processo");
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

        jpDados = new javax.swing.JPanel();
        jbsalvaratualizar = new javax.swing.JButton();
        jtfIdCliente = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jcData = new com.toedter.calendar.JCalendar();
        jbatualizar = new javax.swing.JButton();
        jbBuscaProcesso = new javax.swing.JButton();
        jbinserir = new javax.swing.JButton();
        jbcancelar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jtfNumeroProcesso = new javax.swing.JTextField();
        jtfNomeCliente = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jtfNumeroCliente = new javax.swing.JTextField();
        jtfIdProcesso = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jbnovo = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jtfid = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jtfNumeroPasta = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jtfAcao = new javax.swing.JTextField();
        jScrollPanetable = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jpfiltro = new javax.swing.JPanel();
        jycFiltro = new com.toedter.calendar.JYearChooser();
        jrbPeticoesIniciais = new javax.swing.JRadioButton();
        jrbDefesasPrevias = new javax.swing.JRadioButton();
        jrbPeticoesSimples = new javax.swing.JRadioButton();
        jbBuscaTabela = new javax.swing.JButton();

        jpDados.setBorder(javax.swing.BorderFactory.createTitledBorder("Dados"));

        jbsalvaratualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/em/icons/dataatualizar.png"))); // NOI18N
        jbsalvaratualizar.setText("Atualizar");
        jbsalvaratualizar.setEnabled(false);
        jbsalvaratualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbsalvaratualizarActionPerformed(evt);
            }
        });

        jtfIdCliente.setEnabled(false);

        jLabel1.setText("Id Porcesso:");

        jcData.setBorder(javax.swing.BorderFactory.createTitledBorder("Data "));
        jcData.setEnabled(false);

        jbatualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/em/icons/dataedit.png"))); // NOI18N
        jbatualizar.setText("Editar");
        jbatualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbatualizarActionPerformed(evt);
            }
        });

        jbBuscaProcesso.setText("Buscar Processo");
        jbBuscaProcesso.setEnabled(false);
        jbBuscaProcesso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbBuscaProcessoActionPerformed(evt);
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

        jbcancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/em/icons/data-.png"))); // NOI18N
        jbcancelar.setText("Cancelar");
        jbcancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbcancelarActionPerformed(evt);
            }
        });

        jLabel5.setText("Nome do Cliente:");

        jtfNumeroProcesso.setEnabled(false);

        jtfNomeCliente.setEnabled(false);

        jLabel4.setText("Número do Cliente:");

        jtfNumeroCliente.setEnabled(false);

        jtfIdProcesso.setEnabled(false);

        jLabel2.setText("Número do Processo:");

        jbnovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/em/icons/data+.png"))); // NOI18N
        jbnovo.setText("Novo");
        jbnovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbnovoActionPerformed(evt);
            }
        });

        jLabel3.setText("Id Cliente:");

        jLabel6.setText("Id:");

        jtfid.setEnabled(false);

        jLabel7.setText("Número da Pasta:");

        jtfNumeroPasta.setEnabled(false);

        jLabel8.setText("Ação:");

        jtfAcao.setEnabled(false);

        javax.swing.GroupLayout jpDadosLayout = new javax.swing.GroupLayout(jpDados);
        jpDados.setLayout(jpDadosLayout);
        jpDadosLayout.setHorizontalGroup(
            jpDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpDadosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpDadosLayout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtfid, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jbBuscaProcesso))
                    .addComponent(jcData, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jpDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpDadosLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jpDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jpDadosLayout.createSequentialGroup()
                                .addGroup(jpDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jpDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jtfIdProcesso, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jtfIdCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(20, 20, 20)
                                .addGroup(jpDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel4))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jpDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jpDadosLayout.createSequentialGroup()
                                        .addComponent(jtfNumeroProcesso, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel7)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jtfNumeroPasta, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE))
                                    .addGroup(jpDadosLayout.createSequentialGroup()
                                        .addComponent(jtfNumeroCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel8)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jtfAcao))))
                            .addGroup(jpDadosLayout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jtfNomeCliente)))
                        .addContainerGap(24, Short.MAX_VALUE))
                    .addGroup(jpDadosLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jbnovo, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11)
                        .addComponent(jbinserir, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jbatualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jbsalvaratualizar)
                        .addGap(18, 18, 18)
                        .addComponent(jbcancelar)
                        .addContainerGap())))
        );
        jpDadosLayout.setVerticalGroup(
            jpDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpDadosLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jpDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbBuscaProcesso, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jtfIdProcesso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jtfNumeroProcesso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jtfid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(jtfNumeroPasta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jpDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpDadosLayout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(jpDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jtfNomeCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(59, 59, 59)
                        .addGroup(jpDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jbinserir)
                            .addComponent(jbatualizar)
                            .addComponent(jbsalvaratualizar)
                            .addComponent(jbcancelar)
                            .addComponent(jbnovo)))
                    .addGroup(jpDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jcData, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3)
                        .addComponent(jtfIdCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4)
                        .addComponent(jtfNumeroCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel8)
                        .addComponent(jtfAcao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        jScrollPanetable.setBorder(javax.swing.BorderFactory.createTitledBorder("Tabela"));

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Data", "id_c", "id_p", "Nome", "Ação", "Processo", "Número do Cliente", "Pasta"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
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
            table.getColumnModel().getColumn(0).setMinWidth(50);
            table.getColumnModel().getColumn(0).setPreferredWidth(50);
            table.getColumnModel().getColumn(0).setMaxWidth(50);
            table.getColumnModel().getColumn(1).setMinWidth(100);
            table.getColumnModel().getColumn(1).setPreferredWidth(100);
            table.getColumnModel().getColumn(1).setMaxWidth(100);
            table.getColumnModel().getColumn(2).setMinWidth(0);
            table.getColumnModel().getColumn(2).setPreferredWidth(0);
            table.getColumnModel().getColumn(2).setMaxWidth(0);
            table.getColumnModel().getColumn(3).setMinWidth(0);
            table.getColumnModel().getColumn(3).setPreferredWidth(0);
            table.getColumnModel().getColumn(3).setMaxWidth(0);
            table.getColumnModel().getColumn(6).setMinWidth(100);
            table.getColumnModel().getColumn(6).setPreferredWidth(100);
            table.getColumnModel().getColumn(6).setMaxWidth(100);
            table.getColumnModel().getColumn(7).setMinWidth(0);
            table.getColumnModel().getColumn(7).setPreferredWidth(0);
            table.getColumnModel().getColumn(7).setMaxWidth(0);
            table.getColumnModel().getColumn(8).setMinWidth(75);
            table.getColumnModel().getColumn(8).setPreferredWidth(75);
            table.getColumnModel().getColumn(8).setMaxWidth(75);
        }

        jpfiltro.setBorder(javax.swing.BorderFactory.createTitledBorder("Filtro"));

        jrbPeticoesIniciais.setText("Petições Iniciais");

        jrbDefesasPrevias.setText("Defesas Prévias");

        jrbPeticoesSimples.setText("Petições Simples");

        jbBuscaTabela.setText("Buscar Tabela");
        jbBuscaTabela.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbBuscaTabelaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpfiltroLayout = new javax.swing.GroupLayout(jpfiltro);
        jpfiltro.setLayout(jpfiltroLayout);
        jpfiltroLayout.setHorizontalGroup(
            jpfiltroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpfiltroLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpfiltroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jbBuscaTabela, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jpfiltroLayout.createSequentialGroup()
                        .addGap(0, 5, Short.MAX_VALUE)
                        .addComponent(jycFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jpfiltroLayout.createSequentialGroup()
                        .addGroup(jpfiltroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jrbDefesasPrevias)
                            .addComponent(jrbPeticoesIniciais)
                            .addComponent(jrbPeticoesSimples))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jpfiltroLayout.setVerticalGroup(
            jpfiltroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpfiltroLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jycFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jrbPeticoesIniciais)
                .addGap(3, 3, 3)
                .addComponent(jrbDefesasPrevias)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jrbPeticoesSimples)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jbBuscaTabela, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPanetable)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jpfiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jpDados, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPanetable, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jpfiltro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpDados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
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

    private void jbBuscaTabelaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBuscaTabelaActionPerformed
        busca();
    }//GEN-LAST:event_jbBuscaTabelaActionPerformed

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked
        dadostabela();
    }//GEN-LAST:event_tableMouseClicked

    private void jbBuscaProcessoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBuscaProcessoActionPerformed
        jdBuscaProcesso tbp = new jdBuscaProcesso(null, true);
        tbp.setVisible(true);
        jtfIdProcesso.setText(tbp.Id_processo);
        jtfNomeCliente.setText(tbp.nome_pessoa + " " + tbp.sobrenome_pessoa);
        jtfNumeroProcesso.setText(tbp.numero_processo);
        jtfNumeroPasta.setText(tbp.numero_pasta);
        jtfIdCliente.setText(tbp.id_cliente);
        jtfNumeroCliente.setText(tbp.numero_cliente);
        jtfAcao.setText(tbp.acao_processo);

    }//GEN-LAST:event_jbBuscaProcessoActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPanetable;
    private javax.swing.JButton jbBuscaProcesso;
    private javax.swing.JButton jbBuscaTabela;
    private javax.swing.JButton jbatualizar;
    private javax.swing.JButton jbcancelar;
    private javax.swing.JButton jbinserir;
    private javax.swing.JButton jbnovo;
    private javax.swing.JButton jbsalvaratualizar;
    private com.toedter.calendar.JCalendar jcData;
    private javax.swing.JPanel jpDados;
    private javax.swing.JPanel jpfiltro;
    private javax.swing.JRadioButton jrbDefesasPrevias;
    private javax.swing.JRadioButton jrbPeticoesIniciais;
    private javax.swing.JRadioButton jrbPeticoesSimples;
    private javax.swing.JTextField jtfAcao;
    private javax.swing.JTextField jtfIdCliente;
    private javax.swing.JTextField jtfIdProcesso;
    private javax.swing.JTextField jtfNomeCliente;
    private javax.swing.JTextField jtfNumeroCliente;
    private javax.swing.JTextField jtfNumeroPasta;
    private javax.swing.JTextField jtfNumeroProcesso;
    private javax.swing.JTextField jtfid;
    private com.toedter.calendar.JYearChooser jycFiltro;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables
}
