/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Contable.Vistas;

import Contable.Modulos.CRUD_BalanceComprobacion;
import Contable.Modulos.CRUD_EstadoResultado;
import static Contable.Modulos.CRUD_EstadoResultado.listaEstadoResultado;
import Contable.Modulos.CRUD_LibroMayor;
import static Contable.Modulos.CRUD_LibroMayor.listaLibroMayor;
import Contable.Modulos.PDF_LibroDiario_BalanceGeneral;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ulise
 */
public class JFMostrar_BalanceGeneral extends javax.swing.JFrame {
    ArrayList<String> ListaCuentasRecoridas = new ArrayList<String>();
    
    CRUD_LibroMayor CrLibroMayor = new CRUD_LibroMayor();
    CRUD_EstadoResultado estadoResultado = new CRUD_EstadoResultado();
    PDF_LibroDiario_BalanceGeneral libroDiario_BalanceGeneral = new PDF_LibroDiario_BalanceGeneral();
    
    public static String ListaTipoCuentas [] = {"ACTIVO","PASIVO","Impuesto", 
                                                "CAPITAL", "Reserva", "Utilidad"};
    
    double Impuesto = 0, Reserva = 0, Utilidad = 0,
           TotalActivos = 0, TotalPasivos = 0, TotalCapital = 0,
           TotalDeudor = 0, TotalAcreedor = 0;
    
    double TotalActivos2 = 0, TotalPasivos2 = 0, TotalCapital2 = 0;
    
    DefaultTableModel model;
    public String ID_LibroDato;
    
    /**
     * Creates new form JFMostrar_BalanceGeneral
     */
    public JFMostrar_BalanceGeneral(String ID_Libro) {
        initComponents();
        this.setLocationRelativeTo(null);
        
        ID_LibroDato = ID_Libro;
        model = (DefaultTableModel) this.TableBalanceGeneral.getModel();
        Llenar(ID_Libro);
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
        TableBalanceGeneral = new javax.swing.JTable();
        TxtTotalDeudor = new javax.swing.JLabel();
        TxtTotalAcreedor = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel4.setBackground(new java.awt.Color(0, 255, 255));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setText("BALANCE GENERAL");

        BtnInClinico2.setText("REGRESAR");
        BtnInClinico2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnInClinico2ActionPerformed(evt);
            }
        });

        jButton1.setText("Generar PDF");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(BtnInClinico2)
                .addGap(153, 153, 153)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(116, 116, 116))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BtnInClinico2)
                    .addComponent(jButton1))
                .addContainerGap())
        );

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));

        TableBalanceGeneral.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cuenta", "Debe", "Haber"
            }
        ));
        jScrollPane1.setViewportView(TableBalanceGeneral);

        TxtTotalDeudor.setText("Total Deudor:");

        TxtTotalAcreedor.setText("Total Acreedor:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 676, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(TxtTotalDeudor)
                .addGap(161, 161, 161)
                .addComponent(TxtTotalAcreedor)
                .addGap(76, 76, 76))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TxtTotalDeudor)
                    .addComponent(TxtTotalAcreedor))
                .addContainerGap(14, Short.MAX_VALUE))
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
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
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

        libroDiario_BalanceGeneral.PDFBalanceGeneral(String.valueOf(ID_LibroDato));
    }//GEN-LAST:event_jButton1ActionPerformed

    public void Llenar(String ID_Libro){
        CrLibroMayor.LlenarTabla();
        estadoResultado.LlenarTabla();
        
        boolean ContAuxiliar;
        ListaCuentasRecoridas.clear();
        ListaCuentasRecoridas.add("");
        
        for(int PosEstadoResultado = 0; PosEstadoResultado < listaEstadoResultado.size(); PosEstadoResultado++){
            
            System.err.println(""+listaEstadoResultado.get(PosEstadoResultado).getIDLibro());
            
            
            if(listaEstadoResultado.get(PosEstadoResultado).getIDLibro() == Integer.parseInt(ID_Libro)){
            
                Impuesto = listaEstadoResultado.get(PosEstadoResultado).getImpuesto()*-1;
                Reserva = listaEstadoResultado.get(PosEstadoResultado).getReserva()*-1;
                Utilidad = listaEstadoResultado.get(PosEstadoResultado).getUtilidad()*-1;
            
            }
            
        }
        
        for(int PosicionCuenta = 0; PosicionCuenta < ListaTipoCuentas.length; PosicionCuenta++){
        
            if(!"Impuesto".equals(ListaTipoCuentas[PosicionCuenta]) && 
               !"Reserva".equals(ListaTipoCuentas[PosicionCuenta]) && 
               !"Utilidad".equals(ListaTipoCuentas[PosicionCuenta])){
               
                model.addRow(new Object[]{ListaTipoCuentas[PosicionCuenta]});
            }
            
            for(int PosLibroMayor = 0; PosLibroMayor < listaLibroMayor.size(); PosLibroMayor++){
                
                //VERIFICA SI PERTENECE AL LIBRO
                if(listaLibroMayor.get(PosLibroMayor).getIDLibro() == Integer.parseInt(ID_Libro)){

                    ContAuxiliar = true;

                    if(ListaTipoCuentas[PosicionCuenta].equals(
                            listaLibroMayor.get(PosLibroMayor).getGrupo_Cuenta())){

                        for(int Pos2LibroMayor = 0; Pos2LibroMayor < listaLibroMayor.size(); Pos2LibroMayor++){

                            if(listaLibroMayor.get(PosLibroMayor).getSubGrupo_Cuenta().equals(
                               listaLibroMayor.get(Pos2LibroMayor).getSubGrupo_Cuenta())){

                                for(int PosLC = 0; PosLC < ListaCuentasRecoridas.size(); PosLC++){

                                    //VERIFICA SI LAS CUENTA YA FUE RECORRIDA
                                    if(ListaCuentasRecoridas.get(PosLC).equals(listaLibroMayor.get(PosLibroMayor).getSubGrupo_Cuenta())){
                                        ContAuxiliar = false;
                                        break;
                                    }

                                }

                                if(ContAuxiliar){

                                    if(ListaTipoCuentas[PosicionCuenta].equals(
                                listaLibroMayor.get(PosLibroMayor).getGrupo_Cuenta())){

                                    }

                                    if("ACTIVO".equals(listaLibroMayor.get(Pos2LibroMayor).getGrupo_Cuenta())){

                                        TotalActivos = TotalActivos + listaLibroMayor.get(Pos2LibroMayor).getMontoTotal();
                                    }
                                    else if("PASIVO".equals(listaLibroMayor.get(Pos2LibroMayor).getGrupo_Cuenta())){

                                        TotalPasivos = TotalPasivos + listaLibroMayor.get(Pos2LibroMayor).getMontoTotal();
                                    }
                                    else if("CAPITAL".equals(listaLibroMayor.get(Pos2LibroMayor).getGrupo_Cuenta())){

                                        TotalCapital = TotalCapital + listaLibroMayor.get(Pos2LibroMayor).getMontoTotal();
                                    }

                                }

                            }

                        }
                        if("".equals(ListaCuentasRecoridas.get(0))){
                            ListaCuentasRecoridas.set(0, listaLibroMayor.get(PosLibroMayor).getSubGrupo_Cuenta());
                        }else{
                            ListaCuentasRecoridas.add(listaLibroMayor.get(PosLibroMayor).getSubGrupo_Cuenta());
                        }

                        if("ACTIVO".equals(listaLibroMayor.get(PosLibroMayor).getGrupo_Cuenta())){
                            if(TotalActivos != 0){
                                model.addRow(new Object[]{listaLibroMayor.get(PosLibroMayor).getSubGrupo_Cuenta(), TotalActivos, ""});
                                TotalActivos2 = TotalActivos2+TotalActivos;
                                TotalActivos = 0;
                            }
                        }
                        if("PASIVO".equals(listaLibroMayor.get(PosLibroMayor).getGrupo_Cuenta())){
                            if(TotalPasivos != 0){
                                model.addRow(new Object[]{listaLibroMayor.get(PosLibroMayor).getSubGrupo_Cuenta(), "", TotalPasivos});
                                TotalPasivos2 = TotalPasivos2+TotalPasivos;
                                TotalPasivos = 0;
                            }
                        }
                        if("CAPITAL".equals(listaLibroMayor.get(PosLibroMayor).getGrupo_Cuenta())){
                            if(TotalCapital != 0){
                                model.addRow(new Object[]{listaLibroMayor.get(PosLibroMayor).getSubGrupo_Cuenta(), "", TotalCapital});
                                TotalCapital2 = TotalCapital2+TotalCapital;
                                TotalCapital = 0;
                            }
                        }
                    }
                }
            }
            
            if("Impuesto".equals(ListaTipoCuentas[PosicionCuenta])){
                model.addRow(new Object[]{"Impuesto Por Pagar", "", Impuesto});
            }
            if("Reserva".equals(ListaTipoCuentas[PosicionCuenta])){
                model.addRow(new Object[]{"Reserva Legal", "", Reserva});
            }
            if("Utilidad".equals(ListaTipoCuentas[PosicionCuenta])){
                model.addRow(new Object[]{"Utilidad Neta", "", Utilidad});
            }
            
            if("ACTIVO".equals(ListaTipoCuentas[PosicionCuenta]) || 
               "Impuesto".equals(ListaTipoCuentas[PosicionCuenta])){
               
                model.addRow(new Object[]{});
            }
        }
        
        TotalDeudor = TotalActivos2;
        TotalAcreedor = TotalPasivos2 + Impuesto + TotalCapital2 + Reserva + Utilidad;
        
        TxtTotalDeudor.setText("Total Deudor "+ TotalDeudor);
        TxtTotalAcreedor.setText("Total Acreedor "+ TotalAcreedor);
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
            java.util.logging.Logger.getLogger(JFMostrar_BalanceGeneral.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFMostrar_BalanceGeneral.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFMostrar_BalanceGeneral.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFMostrar_BalanceGeneral.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnInClinico2;
    private javax.swing.JTable TableBalanceGeneral;
    private javax.swing.JLabel TxtTotalAcreedor;
    private javax.swing.JLabel TxtTotalDeudor;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
