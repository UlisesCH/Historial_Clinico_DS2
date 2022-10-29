/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Contable.Vistas;

import Contable.Controladores.Conexion;
import Contable.Modulos.CRUD_Cuenta;
import static Contable.Modulos.CRUD_Cuenta.listaCuenta;
import Contable.Modulos.CRUD_LibroMayor;
import Contable.Modulos.CRUD_Partidas;
import static Contable.Modulos.CRUD_Partidas.listaPartidas;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author emma
 */
public class JFMostrar_LibroMayor extends javax.swing.JFrame {
    
    //OBJETO PARA INTERACTUAR CON LA TABLA
    DefaultTableModel model;
    
    CRUD_Partidas CrPartidas = new CRUD_Partidas();
    CRUD_LibroMayor CrLibroMayor = new CRUD_LibroMayor();
    CRUD_Cuenta CrCuenta = new CRUD_Cuenta();
    
    ArrayList<String> ListaCuentasRecoridas = new ArrayList<String>();
    public String ID_LibroDato;
    
    double TotalDebeMayor = 0;
    double TotalHaberMayor = 0;
    double TotalMayor = 0;
    
    /**
     * Creates new form JFMostrar_LibroMayor
     */
      public JFMostrar_LibroMayor(String ID_Libro) {
        initComponents();
        this.setLocationRelativeTo(null);
        
        ID_LibroDato = ID_Libro;
        model = (DefaultTableModel) this.TableLibroMayor.getModel();
        
        Llenar();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        BtnInClinico2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TableLibroMayor = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel4.setBackground(new java.awt.Color(0, 255, 255));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setText("LIBROS DIARIOS");

        BtnInClinico2.setText("MOSTRAR  INFORMES DE LIBROS");
        BtnInClinico2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnInClinico2ActionPerformed(evt);
            }
        });

        jButton1.setText("PDF");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(280, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(276, 276, 276))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(BtnInClinico2, javax.swing.GroupLayout.PREFERRED_SIZE, 366, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(114, 114, 114))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnInClinico2)
                    .addComponent(jButton1))
                .addGap(22, 22, 22))
        );

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));

        TableLibroMayor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Fecha", "Cuenta", "Debe", "Haber", "Total"
            }
        ));
        jScrollPane1.setViewportView(TableLibroMayor);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 676, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 383, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(12, 12, 12))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnInClinico2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnInClinico2ActionPerformed
        // TODO add your handling code here:
        //OBJETO PARA INTERACTUAR CON EL JFCrear_InContable
        JFMostrar_InformeLibros Mostrar = new JFMostrar_InformeLibros();
        //SE INDICA QUE SE MUESTRE LA VENTANA
        Mostrar.setVisible(true);
        //SE OCULTA LA VENTANA ACTUAL
        this.dispose();
    }//GEN-LAST:event_BtnInClinico2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:

        CrLibroMayor.PDFExamenes(ID_LibroDato);

    }//GEN-LAST:event_jButton1ActionPerformed

    public void Llenar(){
        CrPartidas.LlenarTabla();
        CrCuenta.LlenarTabla();
        boolean ContAuxiliar;
        ListaCuentasRecoridas.clear();
      
        ListaCuentasRecoridas.add("");
        
        //CICLO PARA LLENAR LA TABLA CON LOS VALORES DEL ARREGLO
        for(int PosP = 0; PosP < listaPartidas.size(); PosP++){
            
            //VERIFICA SI PERTENECE AL LIBRO
            if(listaPartidas.get(PosP).getIDLibro() == Integer.valueOf(ID_LibroDato)){
                
                for(int PosC = 0; PosC < listaCuenta.size(); PosC++){
                    
                    ContAuxiliar = true;
                    
                    //VERIFICA SI LA CUENTA PERTENECE A LA PARTIDA
                    if(listaCuenta.get(PosC).getIDPartida() == listaPartidas.get(PosP).getID()){

                        for(int PosC2 = 0; PosC2 < listaCuenta.size(); PosC2++){

                            //VERIFICA SI LAS CUENTAS SON DEL MISMO GRUPO
                            if(listaCuenta.get(PosC).getNombreCuenta().
                                    equals(listaCuenta.get(PosC2).getNombreCuenta())){
                                
                                for(int PosLC = 0; PosLC < ListaCuentasRecoridas.size(); PosLC++){

                                    //VERIFICA SI LAS CUENTA YA FUE RECORRIDA
                                    if(ListaCuentasRecoridas.get(PosLC).equals(listaCuenta.get(PosC).getNombreCuenta())){
                                        ContAuxiliar = false;
                                        break;
                                    }

                                }

                                if(ContAuxiliar){
                                    //VERIFICA EL TIPO DE MOVIMIENTO
                                    
                                    if("DEBE".equals(listaCuenta.get(PosC2).getTipoMovimiento())){

                                        model.addRow(new Object[]{ "",
                                                       listaCuenta.get(PosC).getNombreCuenta(),
                                                       listaCuenta.get(PosC2).getMonto(), ""});
                                        
                                        TotalDebeMayor = TotalDebeMayor+listaCuenta.get(PosC2).getMonto();
                                    }
                                    else if("HABER".equals(listaCuenta.get(PosC2).getTipoMovimiento())){
                                        
                                        model.addRow(new Object[]{ "",
                                                       listaCuenta.get(PosC).getNombreCuenta(),
                                                       "",listaCuenta.get(PosC2).getMonto()});
                                        
                                        TotalHaberMayor = TotalHaberMayor+listaCuenta.get(PosC2).getMonto();
                                    }
                                    
                                }
                                
                            }
                        
                        }
                        
                        if("".equals(ListaCuentasRecoridas.get(0))){
                            ListaCuentasRecoridas.set(0, listaCuenta.get(PosC).getNombreCuenta());
                        }else{
                            ListaCuentasRecoridas.add(listaCuenta.get(PosC).getNombreCuenta());
                        }
                        
                        //VERIFICA SI ALGUNA VARIABLE ES DIFERENTE A CERO
                        if(TotalDebeMayor != 0 || TotalHaberMayor != 0){
                            
                            TotalMayor = TotalDebeMayor-TotalHaberMayor;

                            model.addRow(new Object[]{ "","TOTAL",
                                                       TotalDebeMayor,TotalHaberMayor,TotalMayor});

                            TotalDebeMayor = 0;
                            TotalHaberMayor = 0;

                        }
     
                    }

                }
                
            }

        }

    }
    
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
            java.util.logging.Logger.getLogger(JFMostrar_LibroMayor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFMostrar_LibroMayor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFMostrar_LibroMayor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFMostrar_LibroMayor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Conexion conec = new Conexion();
                conec.CrearTablas();
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnInClinico2;
    private javax.swing.JTable TableLibroMayor;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
