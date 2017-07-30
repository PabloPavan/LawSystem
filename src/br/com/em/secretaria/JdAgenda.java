/*
 * Copyright (C) 2017 pablo
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package br.com.em.secretaria;

import br.com.em.dao.AgendaDao;
import br.com.em.dao.AgendaVoDao;
import br.com.em.dao.InterfaceDao;
import br.com.em.modelo.Agenda;
import br.com.em.vo.AgendaVo;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author pablo
 */
public class JdAgenda extends javax.swing.JDialog {

    /**
     * Creates new form JdAgenda
     */
    public JdAgenda(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        busca("");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jbBusca = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jtfidProcesso = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jccalendar = new com.toedter.calendar.JCalendar();
        Date date = new Date();
        SpinnerDateModel sm =
        new SpinnerDateModel(date, null, null, Calendar.HOUR_OF_DAY);
        jspHora = new  javax.swing.JSpinner(sm);
        jScrollPane1 = new javax.swing.JScrollPane();
        jtaAtividade = new javax.swing.JTextArea();
        jbnovo = new javax.swing.JButton();
        jbinserir = new javax.swing.JButton();
        jbatualizar = new javax.swing.JButton();
        jbsalvaratualizar = new javax.swing.JButton();
        jbcancelar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jthorarios = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jtfidagenda = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jtfbusca = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jbBusca.setText("Buscar Processo");
        jbBusca.setEnabled(false);
        jbBusca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbBuscaActionPerformed(evt);
            }
        });

        jLabel1.setText("Id da Agenda:");

        jtfidProcesso.setEnabled(false);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Data/Hora"));

        jccalendar.setEnabled(false);
        jccalendar.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jccalendarPropertyChange(evt);
            }
        });

        JSpinner.DateEditor de = new JSpinner.DateEditor(jspHora, "HH:mm");
        jspHora.setEditor(de);
        jspHora.setEnabled(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jccalendar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jspHora, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jccalendar, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jspHora, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jScrollPane1.setBorder(javax.swing.BorderFactory.createTitledBorder("Atividades"));

        jtaAtividade.setColumns(20);
        jtaAtividade.setRows(5);
        jtaAtividade.setEnabled(false);
        jScrollPane1.setViewportView(jtaAtividade);

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

        jthorarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "idAgenda", "data", "Hora", "atividade", "idProcesso"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jthorarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jthorariosMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jthorarios);
        if (jthorarios.getColumnModel().getColumnCount() > 0) {
            jthorarios.getColumnModel().getColumn(0).setMinWidth(0);
            jthorarios.getColumnModel().getColumn(0).setPreferredWidth(0);
            jthorarios.getColumnModel().getColumn(0).setMaxWidth(0);
            jthorarios.getColumnModel().getColumn(1).setMinWidth(100);
            jthorarios.getColumnModel().getColumn(1).setPreferredWidth(100);
            jthorarios.getColumnModel().getColumn(1).setMaxWidth(100);
            jthorarios.getColumnModel().getColumn(2).setMinWidth(75);
            jthorarios.getColumnModel().getColumn(2).setPreferredWidth(75);
            jthorarios.getColumnModel().getColumn(2).setMaxWidth(75);
            jthorarios.getColumnModel().getColumn(4).setMinWidth(0);
            jthorarios.getColumnModel().getColumn(4).setPreferredWidth(0);
            jthorarios.getColumnModel().getColumn(4).setMaxWidth(0);
        }

        jLabel4.setText("Id do Processo:");

        jtfidagenda.setEnabled(false);

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/em/icons/busca.png"))); // NOI18N
        jLabel5.setText("Buscar");

        jtfbusca.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtfbuscaKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jbBusca)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtfidProcesso, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtfidagenda, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(0, 90, Short.MAX_VALUE)
                                .addComponent(jbnovo, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jbinserir, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jbatualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jbsalvaratualizar)
                                .addGap(18, 18, 18)
                                .addComponent(jbcancelar))
                            .addComponent(jScrollPane1)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(jtfbusca)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jtfbusca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbBusca, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jtfidProcesso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jtfidagenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jbinserir)
                            .addComponent(jbatualizar)
                            .addComponent(jbsalvaratualizar)
                            .addComponent(jbcancelar)
                            .addComponent(jbnovo)))
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public void novo() {
        jbBusca.setEnabled(true);
        jccalendar.setEnabled(true);
        jspHora.setEnabled(true);
        jtaAtividade.setEnabled(true);
        jtaAtividade.setText(" ");
        jthorarios.setEnabled(false);

        jbinserir.setEnabled(true);
        jbatualizar.setEnabled(false);
        jbcancelar.setEnabled(true);
        jbnovo.setEnabled(false);

    }

    public void save() {
        Agenda agenda = new Agenda();

        //  p.setNome_processo(jtfparteNome.getText());
        agenda.setData_agenda(jccalendar.getDate().toString().format("%1$td-%1$tm-%1$ty", jccalendar.getDate()));
        agenda.setHora_agenda(jspHora.getValue().toString().format("%1$tH:%1$tM", jspHora.getValue()));
        agenda.setAtividade_agenda(jtaAtividade.getText());
        agenda.setId_processo(jtfidProcesso.getText());

        
        if(!jtfidProcesso.getText().isEmpty()){
        InterfaceDao i = new AgendaDao();
        i.cadastrar(agenda);
        cancelar();
        }else{
                JOptionPane.showMessageDialog(null, "É Preciso Adiconar um Processo");
                }
        busca("");
        

    }

    private void busca(String busca) {

        InterfaceDao i = new AgendaDao();
        List<Agenda> list = i.listar(busca, "");

        DefaultTableModel tableModel = (DefaultTableModel) jthorarios.getModel();
        tableModel.setNumRows(0);

        list.stream().forEach((Agenda lista) -> {
            tableModel.addRow(new Object[]{
                lista.getId_agenda(),
                lista.getData_agenda(),
                lista.getHora_agenda(),
                lista.getAtividade_agenda(),
                lista.getId_processo(),
            });
        });

        jthorarios.updateUI();
    }

    public void cancelar(){
        jbBusca.setEnabled(false);
        jccalendar.setEnabled(false);
        jspHora.setEnabled(false);
        jtaAtividade.setEnabled(false);
        jtaAtividade.setText(" ");
        jthorarios.setEnabled(true);

        jbinserir.setEnabled(false);
        jbatualizar.setEnabled(true);
        jbcancelar.setEnabled(true);
        jbnovo.setEnabled(true);
    }
    
    public void liberaUpdate(){
    jbBusca.setEnabled(true);
        jccalendar.setEnabled(true);
        jspHora.setEnabled(true);
        jtaAtividade.setEnabled(true);
        jthorarios.setEnabled(true);

        jbinserir.setEnabled(false);
        jbatualizar.setEnabled(false);
        jbsalvaratualizar.setEnabled(true);
        jbcancelar.setEnabled(true);
        jbnovo.setEnabled(false);
}
    
    public void update(){
        Agenda agenda = new Agenda();

        
        agenda.setId_agenda(jtfidagenda.getText());
        agenda.setData_agenda(jccalendar.getDate().toString().format("%1$td-%1$tm-%1$ty", jccalendar.getDate()));
        agenda.setHora_agenda(jspHora.getValue().toString().format("%1$tH:%1$tM", jspHora.getValue()));
        agenda.setAtividade_agenda(jtaAtividade.getText());
        agenda.setId_processo(jtfidProcesso.getText());

        InterfaceDao i = new AgendaDao();
        i.atualizar(agenda);
        cancelar();  
        busca("");
    }
    private void jbnovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbnovoActionPerformed
        novo();
    }//GEN-LAST:event_jbnovoActionPerformed

    private void jbinserirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbinserirActionPerformed
        save();
    }//GEN-LAST:event_jbinserirActionPerformed

    private void jbatualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbatualizarActionPerformed
        liberaUpdate();
    }//GEN-LAST:event_jbatualizarActionPerformed

    private void jbsalvaratualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbsalvaratualizarActionPerformed
update();
    }//GEN-LAST:event_jbsalvaratualizarActionPerformed

    private void jbcancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbcancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_jbcancelarActionPerformed

    private void jthorariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jthorariosMouseClicked
        if (jthorarios.isEnabled()) {

            int seleciona = jthorarios.getSelectedRow();

            jtfidagenda.setText(jthorarios.getModel().getValueAt(seleciona, 0).toString());

            Date data = new Date();
            data.setDate(Integer.valueOf(jthorarios.getModel().getValueAt(seleciona, 1).toString().substring(0, 2)));
            data.setMonth(Integer.valueOf(jthorarios.getModel().getValueAt(seleciona, 1).toString().substring(3, 5)));
            data.setYear(Integer.valueOf(jthorarios.getModel().getValueAt(seleciona, 1).toString().substring(6, 8) )+100);
            jccalendar.setDate(data);

            Date d = new Date();
            d.setHours(Integer.valueOf(jthorarios.getModel().getValueAt(seleciona, 2).toString().substring(0, 2)));
            d.setMinutes(Integer.valueOf(jthorarios.getModel().getValueAt(seleciona, 2).toString().substring(3, 5)));
            jspHora.setValue(d);

            jtaAtividade.setText(jthorarios.getModel().getValueAt(seleciona, 3).toString());
            jtfidProcesso.setText(jthorarios.getModel().getValueAt(seleciona, 4).toString());

        
            //  System.out.println(jspHora.getValue().toString().format("%1$tH:%1$tM", jspHora.getValue()));
        }
    }//GEN-LAST:event_jthorariosMouseClicked

    private void jccalendarPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jccalendarPropertyChange
        //  busca();
    }//GEN-LAST:event_jccalendarPropertyChange

    private void jtfbuscaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfbuscaKeyReleased
        busca(jtfbusca.getText());
    }//GEN-LAST:event_jtfbuscaKeyReleased

    private void jbBuscaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBuscaActionPerformed
        jdBuscaProcesso tbp = new jdBuscaProcesso(null, true);
        tbp.setVisible(true);
        jtfidProcesso.setText(tbp.Id_processo);
    }//GEN-LAST:event_jbBuscaActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton jbBusca;
    private javax.swing.JButton jbatualizar;
    private javax.swing.JButton jbcancelar;
    private javax.swing.JButton jbinserir;
    private javax.swing.JButton jbnovo;
    private javax.swing.JButton jbsalvaratualizar;
    private com.toedter.calendar.JCalendar jccalendar;
    private javax.swing.JSpinner jspHora;
    private javax.swing.JTextArea jtaAtividade;
    private javax.swing.JTextField jtfbusca;
    private javax.swing.JTextField jtfidProcesso;
    private javax.swing.JTextField jtfidagenda;
    private javax.swing.JTable jthorarios;
    // End of variables declaration//GEN-END:variables
}
