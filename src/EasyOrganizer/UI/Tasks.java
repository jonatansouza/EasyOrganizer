/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package EasyOrganizer.UI;

import EasyOrganizer.controller.EasyOrganizerController;
import EasyOrganizer.model.EasyOrganizerModel;
import EasyOrganizer.util.EasyOrganizerConst;
import java.awt.CardLayout;
import java.awt.Graphics;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 * Tela que apresenta todas as tarefas persistidas no banco de dados e ainda contem os filtros para visualização customizada
 * @author Ana Paula
 */
public class Tasks extends javax.swing.JPanel {
    
    /**
     * Creates new form Tasks
     */
    private DefaultTableModel dm;
    private EasyOrganizerController eomController;
    private JPanel contentPanel;
    private Date dateStart;
    private Date dateEnd;
    
    public Tasks(JPanel contentPanel, EasyOrganizerController eomController) {
        this.contentPanel = contentPanel;
        this.eomController = eomController;
        initComponents();
        createColumns();
        populate(eomController.listAll());
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(new Background().getBackgroud("back.jpg"), 0,0, this);
    }
    
    private void createColumns(){
        dm = (DefaultTableModel) jTable1.getModel();
        dm.addColumn("id");
        dm.addColumn("Assunto");
        dm.addColumn("Data e Hora");
        
        jTable1.getColumnModel().removeColumn(jTable1.getColumn("id"));
    }
    
    private void populate(List<EasyOrganizerModel> eoms){
        dm = (DefaultTableModel) jTable1.getModel();
        for (int i = dm.getRowCount() - 1; i >= 0; i--) {
            dm.removeRow(i);
        }
        Object rowData [] = new Object[3];
        for(EasyOrganizerModel eom: eoms){
            rowData[0] = eom.getId();
            rowData[1] = eom.getSubject();
            rowData[2] = new SimpleDateFormat("dd/MM/yyyy HH:mm").format(eom.getDate());
            dm.addRow(rowData);
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        subjectField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        formStart = new net.sourceforge.jcalendarbutton.JCalendarButton();
        formEnd = new net.sourceforge.jcalendarbutton.JCalendarButton();
        jButton2 = new javax.swing.JButton();
        spinner = new javax.swing.JSpinner();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();

        addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                formFocusGained(evt);
            }
        });
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });
        addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                formPropertyChange(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jButton1.setText("Voltar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setText("Filtros");

        jLabel2.setText("Assunto:");

        subjectField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subjectFieldActionPerformed(evt);
            }
        });
        subjectField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                subjectFieldKeyReleased(evt);
            }
        });

        jLabel3.setText("Datas:");

        formStart.setText("inicio");
        formStart.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                formStartPropertyChange(evt);
            }
        });

        formEnd.setText("fim");
        formEnd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                formEndActionPerformed(evt);
            }
        });
        formEnd.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                formEndPropertyChange(evt);
            }
        });

        jButton2.setText("Clique para ver");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel4.setText("Hoje:");

        jLabel5.setText("Próximos  dias:");

        jButton3.setText("Buscar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Buscar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("Limpar Filtros");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jLabel6.setText("<html><body><b>dica:</b> Clique no compromisso na<br>tabela para visualiza-lo</body></html>");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(119, 119, 119)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(spinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton4))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton2)
                                    .addComponent(subjectField, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(formStart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(formEnd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jButton3)))))))
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(subjectField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(formStart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(formEnd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton3)
                            .addComponent(jLabel3))
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton2)
                            .addComponent(jLabel4))
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(spinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(jButton4))
                        .addGap(37, 37, 37)
                        .addComponent(jButton5)
                        .addGap(29, 29, 29)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 493, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        EasyOrganizerModel eom = eomController.listById((int)jTable1.getModel().getValueAt(jTable1.getSelectedRow(), 0));
        Task t = new Task(eom.getTitle(), eom.getSubject(), 
                eom.getDescription(), new SimpleDateFormat("dd/MM/yyyy hh:mm").format(eom.getDate()));
        
        Object[] options = {"fechar",
                     "deletar"};
        int del = JOptionPane.showOptionDialog(contentPanel, t, "Compromisso "+ eom.getTitle(),
                JOptionPane.YES_NO_CANCEL_OPTION,
                 JOptionPane.PLAIN_MESSAGE,
                 null,
                 options,
                 null);
        
        
        if(del == 1){
            if(eomController.deleteModel(eom.getId())){
                populate(eomController.listAll());
                JOptionPane.showMessageDialog(contentPanel, "Compromisso "+eom.getTitle()+" deletado com sucesso!");
            }else{
                JOptionPane.showMessageDialog(contentPanel, "Ocorreu um erro ao deletar");
            }
            
        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void formFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_formFocusGained
        populate(eomController.listAll());
    }//GEN-LAST:event_formFocusGained

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        CardLayout cl = (CardLayout)contentPanel.getLayout();
        cl.show(contentPanel, "menu");        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void formPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_formPropertyChange
      
    }//GEN-LAST:event_formPropertyChange

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
         populate(eomController.listAll());
    }//GEN-LAST:event_formComponentShown

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        populate(eomController.listByDate(new Date()));
    }//GEN-LAST:event_jButton2ActionPerformed

    private void subjectFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_subjectFieldKeyReleased
        populate(eomController.listBySubject(subjectField.getText()));
        
    }//GEN-LAST:event_subjectFieldKeyReleased

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        if(dateStart == null){
            JOptionPane.showMessageDialog(contentPanel, "intervalo invalido");
        }else if(dateEnd == null){
            JOptionPane.showMessageDialog(contentPanel, "intervalo invalido");
        }else if(dateStart.getTime() >= dateEnd.getTime()){
            JOptionPane.showMessageDialog(contentPanel, "intervalo invalido");
        }else{
            populate(eomController.listByDateInterval(dateStart, dateEnd));
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void formStartPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_formStartPropertyChange
        if (evt.getNewValue() instanceof java.util.Date){
            this.dateStart = (Date) evt.getNewValue();
        }
    }//GEN-LAST:event_formStartPropertyChange

    private void formEndActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_formEndActionPerformed
                // TODO add your handling code here:
    }//GEN-LAST:event_formEndActionPerformed

    private void formEndPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_formEndPropertyChange
        if (evt.getNewValue() instanceof java.util.Date){
            this.dateEnd = (Date) evt.getNewValue();
        }        // TODO add your handling code here:
    }//GEN-LAST:event_formEndPropertyChange

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        if((int) spinner.getValue() <= 0){
            JOptionPane.showMessageDialog(contentPanel, "valor invalido");
        }else{
            long nextDays = EasyOrganizerConst.DAY * ((int)spinner.getValue()+1);
            populate(eomController.listByDateInterval(new Date(), new Date(new Date().getTime() + nextDays)));
        }
        
        
        
    }//GEN-LAST:event_jButton4ActionPerformed

    private void subjectFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subjectFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_subjectFieldActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        populate(eomController.listAll());
    }//GEN-LAST:event_jButton5ActionPerformed
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private net.sourceforge.jcalendarbutton.JCalendarButton formEnd;
    private net.sourceforge.jcalendarbutton.JCalendarButton formStart;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JSpinner spinner;
    private javax.swing.JTextField subjectField;
    // End of variables declaration//GEN-END:variables
}
