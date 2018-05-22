/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfacesGraficas;

import Classes.Configuration;
import Classes.Point;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author martasantos
 */
public class Inicial extends javax.swing.JFrame {

    private Point point;
    private Configuration config;
    /**
     * Creates new form Inicial
     */
    public Inicial() {
        initComponents();
    }

    public Inicial(Point point, Configuration config) {
        this.point = point;
        this.config = config;
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
        jTextArea1 = new javax.swing.JTextArea();
        alturaCenario = new javax.swing.JLabel();
        larguraCenario = new javax.swing.JLabel();
        insertAlturaCen = new javax.swing.JTextField();
        insetLarguraCen = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        insertXPontoInicial = new javax.swing.JTextField();
        insertYPontoInicial = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelaObstaculos = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        Cenario = new javax.swing.JLabel();
        pontoInicial = new javax.swing.JLabel();
        pontoFinal = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        insertXPontoFinal = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        insertYPontoFinal = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        insertIteracoes = new javax.swing.JTextField();
        cruzamentos = new javax.swing.JLabel();
        insertCruzamentos = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        insertSolucoesAleatorias = new javax.swing.JTextField();
        muta = new javax.swing.JSpinner();

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        alturaCenario.setText("Altura: ");

        larguraCenario.setText("Largura:");

        insertAlturaCen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertAlturaCenActionPerformed(evt);
            }
        });

        insetLarguraCen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insetLarguraCenActionPerformed(evt);
            }
        });

        jLabel3.setText("X:");

        jLabel4.setText("Y:");

        insertYPontoInicial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertYPontoInicialActionPerformed(evt);
            }
        });

        tabelaObstaculos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "X", "Y", "Largura", "Altura"
            }
        ));
        jScrollPane2.setViewportView(tabelaObstaculos);

        jLabel5.setText("Obstáculos:");

        jButton1.setText("Siga");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        Cenario.setText("Cenário:");

        pontoInicial.setText("Ponto Inicial:");

        pontoFinal.setText("Ponto Final:");

        jLabel9.setText("X:");

        jLabel10.setText("Y:");

        insertYPontoFinal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertYPontoFinalActionPerformed(evt);
            }
        });

        jLabel11.setText("Mutações: ");

        jLabel12.setText("Iterações:");

        cruzamentos.setText("Cruzamentos:");

        insertCruzamentos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertCruzamentosActionPerformed(evt);
            }
        });

        jLabel1.setText("Nº de Soluções aleatórias:");

        insertSolucoesAleatorias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertSolucoesAleatoriasActionPerformed(evt);
            }
        });

        muta.setModel(new javax.swing.SpinnerNumberModel(Float.valueOf(0.0f), Float.valueOf(-0.5f), Float.valueOf(0.5f), Float.valueOf(0.1f)));
        muta.setToolTipText("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(Cenario))
                        .addGap(118, 118, 118)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pontoInicial)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(pontoFinal)
                                        .addGap(4, 4, 4)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel3)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(insertXPontoInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel9)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(insertXPontoFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(43, 43, 43)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(insertYPontoInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(insertYPontoFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel12)
                                            .addComponent(jLabel1))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(insertSolucoesAleatorias, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(insertIteracoes, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(3, 3, 3))))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(106, 106, 106)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(alturaCenario)
                                .addGap(18, 18, 18)
                                .addComponent(insertAlturaCen, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(larguraCenario)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(insetLarguraCen, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(cruzamentos)
                                    .addComponent(jLabel11))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(insertCruzamentos, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(muta, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                .addContainerGap(103, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(264, 264, 264))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(85, 85, 85))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(87, 87, 87)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Cenario)
                            .addComponent(pontoInicial))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(alturaCenario)
                            .addComponent(insertAlturaCen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(insertXPontoInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(insertYPontoInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(77, 77, 77))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(202, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(larguraCenario)
                            .addComponent(insetLarguraCen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pontoFinal))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(insertXPontoFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(insertYPontoFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(insertIteracoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(muta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cruzamentos)
                    .addComponent(insertCruzamentos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(insertSolucoesAleatorias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void insertYPontoInicialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertYPontoInicialActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_insertYPontoInicialActionPerformed

    private void  verificarValores(){
        String alturaCen= insertAlturaCen.getText();
        String largCen=insetLarguraCen.getText();
        String mutacoes = (String) muta.getValue();
        
        String cruzamentos= insertCruzamentos.getText();
        String iteracoes= insertIteracoes.getText();
        String solucoesAleatorias= insertSolucoesAleatorias.getText();
   
        try{
           int altura = Integer.parseInt(alturaCen);
           int largura = Integer.parseInt(largCen);
           float muta = Float.parseFloat(mutacoes);
           int cruz = Integer.parseInt(cruzamentos);
           int ite = Integer.parseInt(iteracoes);
           int sol = Integer.parseInt(solucoesAleatorias);
        }catch(Exception ex){
            System.out.println("x");
        }
        
    }
    
    private Point criarPontoInicial (){
        String xPontoInicial= insertXPontoFinal.getText();
        String yPontoIncial= insertYPontoInicial.getText();
        Point pi= null;
        
        try{
            
        }catch(Exception ex){
            int xinit = Integer.parseInt(xPontoInicial);
           int yinit = Integer.parseInt(yPontoIncial);
          pi=new Point(xinit, yinit);
        }
        
        return pi;
    }
    
    private Point criarPontoFinal (){
        String xPontoFinal= insertXPontoFinal.getText();
        String yPontoFinal= insertYPontoFinal.getText();
       
        Point pf= null;
        
        try{
            
        }catch(Exception ex){
           int xfinal = Integer.parseInt(xPontoFinal);
           int yfinal = Integer.parseInt(yPontoFinal);
          pf=new Point(xfinal, yfinal);
        }
        
        return pf;
    }
    
    
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void insertYPontoFinalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertYPontoFinalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_insertYPontoFinalActionPerformed

    private void insertAlturaCenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertAlturaCenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_insertAlturaCenActionPerformed

    private void insetLarguraCenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insetLarguraCenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_insetLarguraCenActionPerformed

    private void insertSolucoesAleatoriasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertSolucoesAleatoriasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_insertSolucoesAleatoriasActionPerformed

    private void insertCruzamentosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertCruzamentosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_insertCruzamentosActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Inicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Inicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Inicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Inicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Inicial().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Cenario;
    private javax.swing.JLabel alturaCenario;
    private javax.swing.JLabel cruzamentos;
    private javax.swing.JTextField insertAlturaCen;
    private javax.swing.JTextField insertCruzamentos;
    private javax.swing.JTextField insertIteracoes;
    private javax.swing.JTextField insertSolucoesAleatorias;
    private javax.swing.JTextField insertXPontoFinal;
    private javax.swing.JTextField insertXPontoInicial;
    private javax.swing.JTextField insertYPontoFinal;
    private javax.swing.JTextField insertYPontoInicial;
    private javax.swing.JTextField insetLarguraCen;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JLabel larguraCenario;
    private javax.swing.JSpinner muta;
    private javax.swing.JLabel pontoFinal;
    private javax.swing.JLabel pontoInicial;
    private javax.swing.JTable tabelaObstaculos;
    // End of variables declaration//GEN-END:variables
}
