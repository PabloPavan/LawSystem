/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.em.secretaria;



/**
 *
 * @author pablo
 */
public class JpAndamentoProcessual extends javax.swing.JPanel {

    /**
     * Creates new form jpCadastrarCliente
     */
    public JpAndamentoProcessual() {
        initComponents();

    }



    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jScrollPanetable = new javax.swing.JScrollPane();
        jtPeticoesIniciais = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jScrollPanetable1 = new javax.swing.JScrollPane();
        jtDefesaPrevia = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jScrollPanetable2 = new javax.swing.JScrollPane();
        jtPeticoesSimples = new javax.swing.JTable();
        jycFiltro = new com.toedter.calendar.JYearChooser();
        jPanel1 = new javax.swing.JPanel();
        jbsalvaratualizar = new javax.swing.JButton();
        jrbPeticoesIniciais = new javax.swing.JRadioButton();
        jtfIdCliente = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jcData = new com.toedter.calendar.JCalendar();
        jbatualizar = new javax.swing.JButton();
        jrbPeticoesSimples = new javax.swing.JRadioButton();
        jbBuscaProcesso = new javax.swing.JButton();
        jbinserir = new javax.swing.JButton();
        jbcancelar = new javax.swing.JButton();
        jrbDefesasPrevias = new javax.swing.JRadioButton();
        jLabel5 = new javax.swing.JLabel();
        jtfNumeroProcesso = new javax.swing.JTextField();
        jtfNomeCliente = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jtfNumeroCliente = new javax.swing.JTextField();
        jtfidProcesso = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jbnovo = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jtfid = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jtfNumeroPasta = new javax.swing.JTextField();

        jtPeticoesIniciais.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "Data", "id_c", "id_p", "Nome", "Sobrenome", "Número do Processo", "Número do Cliente", "Número da Pasta"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtPeticoesIniciais.getTableHeader().setReorderingAllowed(false);
        jtPeticoesIniciais.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtPeticoesIniciaisMouseClicked(evt);
            }
        });
        jScrollPanetable.setViewportView(jtPeticoesIniciais);
        if (jtPeticoesIniciais.getColumnModel().getColumnCount() > 0) {
            jtPeticoesIniciais.getColumnModel().getColumn(0).setMinWidth(0);
            jtPeticoesIniciais.getColumnModel().getColumn(0).setPreferredWidth(0);
            jtPeticoesIniciais.getColumnModel().getColumn(0).setMaxWidth(0);
            jtPeticoesIniciais.getColumnModel().getColumn(1).setMinWidth(100);
            jtPeticoesIniciais.getColumnModel().getColumn(1).setPreferredWidth(100);
            jtPeticoesIniciais.getColumnModel().getColumn(1).setMaxWidth(100);
            jtPeticoesIniciais.getColumnModel().getColumn(2).setMinWidth(0);
            jtPeticoesIniciais.getColumnModel().getColumn(2).setPreferredWidth(0);
            jtPeticoesIniciais.getColumnModel().getColumn(2).setMaxWidth(0);
            jtPeticoesIniciais.getColumnModel().getColumn(3).setMinWidth(0);
            jtPeticoesIniciais.getColumnModel().getColumn(3).setPreferredWidth(0);
            jtPeticoesIniciais.getColumnModel().getColumn(3).setMaxWidth(0);
            jtPeticoesIniciais.getColumnModel().getColumn(6).setMinWidth(0);
            jtPeticoesIniciais.getColumnModel().getColumn(6).setPreferredWidth(0);
            jtPeticoesIniciais.getColumnModel().getColumn(6).setMaxWidth(0);
            jtPeticoesIniciais.getColumnModel().getColumn(7).setMinWidth(0);
            jtPeticoesIniciais.getColumnModel().getColumn(7).setPreferredWidth(0);
            jtPeticoesIniciais.getColumnModel().getColumn(7).setMaxWidth(0);
        }

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPanetable, javax.swing.GroupLayout.DEFAULT_SIZE, 914, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPanetable, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Relação de Petições Iniciais", jPanel2);

        jtDefesaPrevia.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "Nome Cliente", "Sobrenome Cliente", "Número ", "Nº Pasta"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtDefesaPrevia.getTableHeader().setReorderingAllowed(false);
        jtDefesaPrevia.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtDefesaPreviaMouseClicked(evt);
            }
        });
        jScrollPanetable1.setViewportView(jtDefesaPrevia);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPanetable1, javax.swing.GroupLayout.DEFAULT_SIZE, 914, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPanetable1, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Relação de Defesas Prévias,  Recursos e etc", jPanel3);

        jtPeticoesSimples.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "Nome Cliente", "Sobrenome Cliente", "Número ", "Nº Pasta"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtPeticoesSimples.getTableHeader().setReorderingAllowed(false);
        jtPeticoesSimples.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtPeticoesSimplesMouseClicked(evt);
            }
        });
        jScrollPanetable2.setViewportView(jtPeticoesSimples);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPanetable2, javax.swing.GroupLayout.DEFAULT_SIZE, 914, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPanetable2, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Relação de Peticões Simples", jPanel4);

        jycFiltro.setBorder(javax.swing.BorderFactory.createTitledBorder("Filtro"));

        jbsalvaratualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/em/icons/dataatualizar.png"))); // NOI18N
        jbsalvaratualizar.setText("Atualizar");
        jbsalvaratualizar.setEnabled(false);
        jbsalvaratualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbsalvaratualizarActionPerformed(evt);
            }
        });

        jrbPeticoesIniciais.setText("Petições Iniciais");

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

        jrbPeticoesSimples.setText("Petições Simples");

        jbBuscaProcesso.setText("Buscar Processo");

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

        jrbDefesasPrevias.setText("Defesas Prévias");

        jLabel5.setText("Nome do Cliente:");

        jtfNumeroProcesso.setEnabled(false);

        jtfNomeCliente.setEnabled(false);

        jLabel4.setText("Número do Cliente:");

        jtfNumeroCliente.setEnabled(false);

        jtfidProcesso.setEnabled(false);

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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtfid, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jbBuscaProcesso))
                    .addComponent(jcData, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jtfidProcesso, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jtfIdCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(20, 20, 20)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel4))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jtfNumeroCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(67, 226, Short.MAX_VALUE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jtfNumeroProcesso, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel7)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jtfNumeroPasta))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jtfNomeCliente))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jrbPeticoesIniciais)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jrbDefesasPrevias)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jrbPeticoesSimples)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
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
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbBuscaProcesso, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jtfidProcesso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jtfNumeroProcesso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jtfid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(jtfNumeroPasta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jtfNomeCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jrbPeticoesIniciais)
                            .addComponent(jrbDefesasPrevias)
                            .addComponent(jrbPeticoesSimples))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jbinserir)
                            .addComponent(jbatualizar)
                            .addComponent(jbsalvaratualizar)
                            .addComponent(jbcancelar)
                            .addComponent(jbnovo)))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jcData, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3)
                        .addComponent(jtfIdCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4)
                        .addComponent(jtfNumeroCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 943, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jycFiltro, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(jycFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jtPeticoesIniciaisMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtPeticoesIniciaisMouseClicked
   
    }//GEN-LAST:event_jtPeticoesIniciaisMouseClicked

    private void jbnovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbnovoActionPerformed
       // novo();
    }//GEN-LAST:event_jbnovoActionPerformed

    private void jbinserirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbinserirActionPerformed
     //   save();
    }//GEN-LAST:event_jbinserirActionPerformed

    private void jbatualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbatualizarActionPerformed
     //   liberaUpdate();
    }//GEN-LAST:event_jbatualizarActionPerformed

    private void jbsalvaratualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbsalvaratualizarActionPerformed
      //  update();
    }//GEN-LAST:event_jbsalvaratualizarActionPerformed

    private void jbcancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbcancelarActionPerformed
    //    this.dispose();
    }//GEN-LAST:event_jbcancelarActionPerformed

    private void jtDefesaPreviaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtDefesaPreviaMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jtDefesaPreviaMouseClicked

    private void jtPeticoesSimplesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtPeticoesSimplesMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jtPeticoesSimplesMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPanetable;
    private javax.swing.JScrollPane jScrollPanetable1;
    private javax.swing.JScrollPane jScrollPanetable2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JButton jbBuscaProcesso;
    private javax.swing.JButton jbatualizar;
    private javax.swing.JButton jbcancelar;
    private javax.swing.JButton jbinserir;
    private javax.swing.JButton jbnovo;
    private javax.swing.JButton jbsalvaratualizar;
    private com.toedter.calendar.JCalendar jcData;
    private javax.swing.JRadioButton jrbDefesasPrevias;
    private javax.swing.JRadioButton jrbPeticoesIniciais;
    private javax.swing.JRadioButton jrbPeticoesSimples;
    private javax.swing.JTable jtDefesaPrevia;
    private javax.swing.JTable jtPeticoesIniciais;
    private javax.swing.JTable jtPeticoesSimples;
    private javax.swing.JTextField jtfIdCliente;
    private javax.swing.JTextField jtfNomeCliente;
    private javax.swing.JTextField jtfNumeroCliente;
    private javax.swing.JTextField jtfNumeroPasta;
    private javax.swing.JTextField jtfNumeroProcesso;
    private javax.swing.JTextField jtfid;
    private javax.swing.JTextField jtfidProcesso;
    private com.toedter.calendar.JYearChooser jycFiltro;
    // End of variables declaration//GEN-END:variables
}
