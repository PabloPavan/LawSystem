/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.em.secretaria;

import br.com.em.dao.AgendaVoDao;
import br.com.em.dao.InterfaceDao;
import br.com.em.modelo.Agenda;
import br.com.em.vo.AgendaVo;
import java.util.List;
import static javax.swing.JComponent.TOOL_TIP_TEXT_KEY;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author pablo
 */
public class JpAgenda extends javax.swing.JPanel {

    /**
     * Creates new form jpCadastrarCliente
     */
    public JpAgenda() {
        initComponents();
        busca();

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
        jScrollPane1 = new javax.swing.JScrollPane();
        jtaatividades = new javax.swing.JTextArea();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jthorarios = new javax.swing.JTable();
        jccalendario = new com.toedter.calendar.JCalendar();
        jButton2 = new javax.swing.JButton();

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Atividades"));

        jtaatividades.setEditable(false);
        jtaatividades.setColumns(20);
        jtaatividades.setRows(5);
        jScrollPane1.setViewportView(jtaatividades);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Horários"));

        jthorarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Hora", "atividade", "Número do Processo", "Número do Cliente", "Ação"
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
            jthorarios.getColumnModel().getColumn(1).setMinWidth(0);
            jthorarios.getColumnModel().getColumn(1).setPreferredWidth(0);
            jthorarios.getColumnModel().getColumn(1).setMaxWidth(0);
        }

        jccalendario.setBorder(javax.swing.BorderFactory.createTitledBorder("Calendário"));
        jccalendario.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jccalendarioPropertyChange(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 713, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jccalendario, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jccalendario, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/em/icons/data+.png"))); // NOI18N
        jButton2.setText("Adiconar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton2)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2)
                .addGap(16, 16, 16))
        );
    }// </editor-fold>//GEN-END:initComponents

    
    
    
    public void busca(){
        InterfaceDao i = new AgendaVoDao();
        List<AgendaVo> list = i.listar(jccalendario.getDate().toString().format("%1$td-%1$tm-%1$ty", jccalendario.getDate()), "");
 
         DefaultTableModel tableModel = (DefaultTableModel) jthorarios.getModel();
        tableModel.setNumRows(0);

        list.stream().forEach((AgendaVo lista) -> {
            tableModel.addRow(new Object[]{
                lista.getHora_agenda(),
                lista.getAtividade_agenda(),
                lista.getNumero_processo(),
                lista.getNumero_cliente(),
                lista.getAcao_processo()
            });
        });

        jthorarios.updateUI();

    }
    private void jpccalendarioPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jpccalendarioPropertyChange

    }//GEN-LAST:event_jpccalendarioPropertyChange

    private void jccalendarioPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jccalendarioPropertyChange
        busca();
    }//GEN-LAST:event_jccalendarioPropertyChange

    private void jthorariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jthorariosMouseClicked
     if (jthorarios.isEnabled()) {

            int seleciona = jthorarios.getSelectedRow();

            jtaatividades.setText(jthorarios.getModel().getValueAt(seleciona, 1).toString());
          

        }
    }//GEN-LAST:event_jthorariosMouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       JdAgenda dialog = new JdAgenda(new javax.swing.JFrame(), true);     
                dialog.setVisible(true);
                busca();
    }//GEN-LAST:event_jButton2ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private com.toedter.calendar.JCalendar jccalendario;
    private javax.swing.JTextArea jtaatividades;
    private javax.swing.JTable jthorarios;
    // End of variables declaration//GEN-END:variables
}
