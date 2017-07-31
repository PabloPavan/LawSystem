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

import br.com.em.dao.InterfaceDao;
import br.com.em.dao.ProcessoVoDao;
import br.com.em.vo.ProcessoVo;
import java.util.List;
import javax.swing.ButtonGroup;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author pablo
 */
public class jdBuscaProcesso extends javax.swing.JDialog {

    /**
     * Creates new form jdBuscaProcesso
     */
    public String Id_processo;
    public String nome_pessoa;
    public String sobrenome_pessoa;
    public String numero_processo;
    public String numero_pasta;
    public String id_cliente;
    public String numero_cliente;
    public String acao_processo;

    public jdBuscaProcesso(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        ButtonGroup group = new ButtonGroup();
        group.add(jrbnome);
        group.add(jrbsobrenome);
        group.add(jrbnumero);
        table.updateUI();
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

        Consulta = new javax.swing.JPanel();
        jtfbusca = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jrbnome = new javax.swing.JRadioButton();
        jrbnumero = new javax.swing.JRadioButton();
        jrbsobrenome = new javax.swing.JRadioButton();
        jLabel5 = new javax.swing.JLabel();
        jScrollPanetable = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jrbnome)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jrbsobrenome)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jrbnumero))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jrbnumero)
                .addComponent(jrbnome)
                .addComponent(jrbsobrenome))
        );

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/em/icons/busca.png"))); // NOI18N
        jLabel5.setText("Buscar");

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "Nome Cliente", "Sobrenome Cliente", "Número ", "Nº Pasta", "id_cli", "nu_cli", "acao"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, true, true
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
            table.getColumnModel().getColumn(5).setMinWidth(0);
            table.getColumnModel().getColumn(5).setPreferredWidth(0);
            table.getColumnModel().getColumn(5).setMaxWidth(0);
            table.getColumnModel().getColumn(6).setMinWidth(0);
            table.getColumnModel().getColumn(6).setPreferredWidth(0);
            table.getColumnModel().getColumn(6).setMaxWidth(0);
            table.getColumnModel().getColumn(7).setMinWidth(0);
            table.getColumnModel().getColumn(7).setPreferredWidth(0);
            table.getColumnModel().getColumn(7).setMaxWidth(0);
        }

        javax.swing.GroupLayout ConsultaLayout = new javax.swing.GroupLayout(Consulta);
        Consulta.setLayout(ConsultaLayout);
        ConsultaLayout.setHorizontalGroup(
            ConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ConsultaLayout.createSequentialGroup()
                .addGroup(ConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ConsultaLayout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(ConsultaLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(ConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPanetable, javax.swing.GroupLayout.DEFAULT_SIZE, 611, Short.MAX_VALUE)
                            .addGroup(ConsultaLayout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jtfbusca)))))
                .addContainerGap())
        );
        ConsultaLayout.setVerticalGroup(
            ConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ConsultaLayout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(ConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jtfbusca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPanetable, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 669, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(Consulta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 351, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(Consulta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

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
                lista.getNumero_processo(),
                lista.getNumeroPasta_processo(),
                lista.getId_cliente(),
                lista.getNumero_cliente(),
                lista.getAcao_processo(),
            
            });
            
        });

        table.updateUI();

    }
    private void jtfbuscaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfbuscaKeyReleased
        busca(jtfbusca.getText());
    }//GEN-LAST:event_jtfbuscaKeyReleased

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked
        if (evt.getClickCount() == 2) {

            Id_processo = (String) ((table.getModel().getValueAt(table.getSelectedRow(), 0)));
            nome_pessoa = (String) ((table.getModel().getValueAt(table.getSelectedRow(), 1)));
            sobrenome_pessoa = (String) ((table.getModel().getValueAt(table.getSelectedRow(), 2)));
            numero_processo = (String) ((table.getModel().getValueAt(table.getSelectedRow(), 3)));
            numero_pasta = (String) ((table.getModel().getValueAt(table.getSelectedRow(), 4)));
            id_cliente = (String) ((table.getModel().getValueAt(table.getSelectedRow(), 5)));
            numero_cliente = (String) ((table.getModel().getValueAt(table.getSelectedRow(), 6)));
            acao_processo = (String) ((table.getModel().getValueAt(table.getSelectedRow(), 7)));

            this.dispose();
        }
    }//GEN-LAST:event_tableMouseClicked

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Consulta;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPanetable;
    private javax.swing.JRadioButton jrbnome;
    private javax.swing.JRadioButton jrbnumero;
    private javax.swing.JRadioButton jrbsobrenome;
    private javax.swing.JTextField jtfbusca;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables
}
