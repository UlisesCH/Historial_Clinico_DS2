/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package VistasInClinico;

import InClinico.Modulos.CRUD_DatosExamenes;
import static InClinico.Modulos.CRUD_DatosExamenes.listaDatos;
import static InClinico.Modulos.CRUD_DatosExamenes.listaDatosExamenes;
import InClinico.Modulos.CRUD_Examenes;
import static InClinico.Modulos.CRUD_Examenes.listaExamenes;
import InClinico.Controladores.Conexion;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ulise
 */
public class JFCrear_Examen extends javax.swing.JFrame {
    //OBJETO PARA INTERACTUAR CON LA TABLA
    DefaultTableModel model;
    int ID;
    int fila;
    
    /**
     * Creates new form JFCrear_Examen
     */
    public JFCrear_Examen() {
        initComponents();
        this.setLocationRelativeTo(null);
        
        model = (DefaultTableModel) this.TableExamenes.getModel();
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        BtnCrearExamen = new javax.swing.JButton();
        BtnRegresar = new javax.swing.JButton();
        TxtNombExamen = new javax.swing.JTextField();
        TxtPrecioExamen = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TableExamenes = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        TxtTabNombExamen = new javax.swing.JTextField();
        TxtTabPrecioExamen = new javax.swing.JTextField();
        BtnModificar = new javax.swing.JButton();
        BtnEliminar = new javax.swing.JButton();
        BtnAgregarDatos = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setText("CREAR EXAMENES");

        BtnCrearExamen.setText("Crear Examen");
        BtnCrearExamen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnCrearExamenActionPerformed(evt);
            }
        });

        BtnRegresar.setText("Regresar");
        BtnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnRegresarActionPerformed(evt);
            }
        });

        jLabel2.setText("NOMBRE DE EXAMEN CLINICO");

        jLabel3.setText("PRECIO");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(125, 125, 125))
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(105, 105, 105))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(TxtNombExamen, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(BtnRegresar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(18, 18, 18))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(TxtPrecioExamen)
                                        .addGap(46, 46, 46)))
                                .addComponent(BtnCrearExamen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(27, 27, 27))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(55, 55, 55))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(41, 41, 41)
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TxtNombExamen)
                .addGap(56, 56, 56)
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TxtPrecioExamen)
                .addGap(82, 82, 82)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnCrearExamen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BtnRegresar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(49, 49, 49))
        );

        jPanel2.setBackground(new java.awt.Color(204, 204, 255));

        TableExamenes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID", "Nombre", "Precio"
            }
        ));
        TableExamenes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TableExamenesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TableExamenes);
        if (TableExamenes.getColumnModel().getColumnCount() > 0) {
            TableExamenes.getColumnModel().getColumn(0).setPreferredWidth(5);
            TableExamenes.getColumnModel().getColumn(2).setPreferredWidth(5);
        }

        jLabel4.setText("NOMBRE EXAMEN");

        jLabel5.setText("PRECIO");

        TxtTabPrecioExamen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtTabPrecioExamenActionPerformed(evt);
            }
        });

        BtnModificar.setText("Modificar");
        BtnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnModificarActionPerformed(evt);
            }
        });

        BtnEliminar.setText("Eliminar");
        BtnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnEliminarActionPerformed(evt);
            }
        });

        BtnAgregarDatos.setText("Agregar Prueba");
        BtnAgregarDatos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAgregarDatosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(BtnModificar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(50, 50, 50)
                        .addComponent(BtnAgregarDatos)
                        .addGap(43, 43, 43)
                        .addComponent(BtnEliminar)
                        .addGap(20, 20, 20))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(101, 101, 101))
                            .addComponent(TxtTabNombExamen))
                        .addGap(80, 80, 80)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(TxtTabPrecioExamen)
                                .addGap(20, 20, 20))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(46, 46, 46))))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TxtTabNombExamen)
                    .addComponent(TxtTabPrecioExamen))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnModificar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BtnEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BtnAgregarDatos))
                .addGap(15, 15, 15)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnRegresarActionPerformed
        // TODO add your handling code here:
        //OBJETO PARA INTERACTUAR CON EL JFCrear_InContable
        JFCrear_InClinico InClinico = new JFCrear_InClinico();
        //SE INDICA QUE SE MUESTRE LA VENTANA
        InClinico.setVisible(true);
        //SE OCULTA LA VENTANA ACTUAL
        this.dispose();
    }//GEN-LAST:event_BtnRegresarActionPerformed

    private void BtnCrearExamenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCrearExamenActionPerformed
        // TODO add your handling code here:
        
        //OBJETO PARA ENTERACTUAR CON LA CONEXION
        Conexion conec = new Conexion();
        //CREA REALIZA LA CONEXION Y CREA LA TABLA SI NO HAY
        conec.CrearTablas();
        
        //SE OBTIENES LOS DATOS DE LOS INPUTS
        String NombExamen = TxtNombExamen.getText();
        Double PrecioExamen = Double.valueOf(TxtPrecioExamen.getText());
        
        CRUD_Examenes Cr = new CRUD_Examenes();
        Cr.Insertar(NombExamen, PrecioExamen);
        
        Llenar();
        
    }//GEN-LAST:event_BtnCrearExamenActionPerformed

    private void TxtTabPrecioExamenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtTabPrecioExamenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtTabPrecioExamenActionPerformed

    private void BtnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnModificarActionPerformed
        // TODO add your handling code here:
        
        //OBJETO PARA ENTERACTUAR CON LA CONEXION
        Conexion conec = new Conexion();
        //CREA REALIZA LA CONEXION Y CREA LA TABLA SI NO HAY
        conec.CrearTablas();
        
        fila = TableExamenes.getSelectedRow();
        ID = 0;
        
        if(fila != -1){
            
            ID = Integer.parseInt((String) TableExamenes.getValueAt(fila, 0).toString());

            //SE OBTIENES LOS DATOS DE LOS INPUTS
            String NombExamen = TxtTabNombExamen.getText();
            Double PrecioExamen = Double.parseDouble(TxtTabPrecioExamen.getText());
            
            //OBJETO PARA ENTERACTUAR CON EL CRUD
            CRUD_Examenes Cr = new CRUD_Examenes();
            //SE MANDA LOS VALORES AL INSERTAR
            Cr.Modificar(ID, NombExamen, PrecioExamen);

            Llenar();
        }
        else{
            JOptionPane.showMessageDialog(null, "NO SE A SELECIONADO FILA");

        }
        
    }//GEN-LAST:event_BtnModificarActionPerformed

    private void BtnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnEliminarActionPerformed
        // TODO add your handling code here:
        
        fila = TableExamenes.getSelectedRow();
        ID = 0;
        
        if(fila == -1){
            JOptionPane.showMessageDialog(null, "NO SE A SELECIONADO FILA");
        }
        else{
            
            ID = Integer.parseInt((String) TableExamenes.getValueAt(fila, 0).toString());
            
            CRUD_Examenes Cr = new CRUD_Examenes();
            Cr.Eliminar(ID);
        }
        
        Llenar();
        
    }//GEN-LAST:event_BtnEliminarActionPerformed

    private void TableExamenesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableExamenesMouseClicked
        // TODO add your handling code here:
        
        fila = TableExamenes.getSelectedRow();
        ID = 0;
        if(fila == -1){
            JOptionPane.showMessageDialog(null, "NO SE A SELECIONADO FILA");
        }
        else{
            if((String) TableExamenes.getValueAt(fila, 0).toString() != "--"){
                ID = Integer.parseInt((String) TableExamenes.getValueAt(fila, 0).toString());
                String NombExamen = (String) TableExamenes.getValueAt(fila, 1);
                Double PrecioExamen = Double.valueOf((String) TableExamenes.getValueAt(fila, 2).toString());

                TxtTabNombExamen.setText(NombExamen);
                TxtTabPrecioExamen.setText(""+PrecioExamen);
            }else{
                JOptionPane.showMessageDialog(null, "FILA SELECCIONADA NO ES VALIDA");
            }
            
        }
        
    }//GEN-LAST:event_TableExamenesMouseClicked

    private void BtnAgregarDatosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAgregarDatosActionPerformed
        // TODO add your handling code here
        
        String ID_Examen = (String) TableExamenes.getValueAt(fila, 0).toString();
        String Examen = (String) TableExamenes.getValueAt(fila, 1).toString();
        fila = TableExamenes.getSelectedRow();
        //OBJETO PARA INTERACTUAR CON EL JFCrear_InContable
        if(fila != -1){
            if((String) TableExamenes.getValueAt(fila, 0).toString() != "--"){
                JFAgregar_Datos Agregar_Datos = new JFAgregar_Datos(ID_Examen,Examen);

                //SE INDICA QUE SE MUESTRE LA VENTANA
                Agregar_Datos.setVisible(true);
                //SE OCULTA LA VENTANA ACTUAL
                this.dispose();
            }else{
                JOptionPane.showMessageDialog(null, "FILA SELECCIONADA NO ES VALIDA");
            }
                
        }else{
            JOptionPane.showMessageDialog(null, "NO SE A SELECIONADO FILA");
        }
     
    }//GEN-LAST:event_BtnAgregarDatosActionPerformed

    public void Llenar(){
        
        //SE LIMPIA LA TABLA
        model.setRowCount(0);
        //OBJETO PARA ENTERACTUAR CON EL CRUD
        CRUD_Examenes CR_Examen = new CRUD_Examenes();
        //SE LLENA EL ARREGLO CON LOS VALORES DE LA TABLA
        CR_Examen.LlenarTabla();
        
        //CICLO PARA LLENAR LA TABLA CON LOS VALORES DEL ARREGLO
        for(int PosC = 0; PosC < listaExamenes.size(); PosC++){

            model.addRow(new Object[]{listaExamenes.get(PosC).getID()
                    ,listaExamenes.get(PosC).getNombre_Examen(),listaExamenes.get(PosC).getPrecio_Examen()});
            
            //CICLO PARA LLENAR LA TABLA CON LOS VALORES DEL ARREGLO
            for(int PosD = 0; PosD < listaDatos.size(); PosD++){

                if(listaDatos.get(PosD).getID_Examen() == listaExamenes.get(PosC).getID()){
                    model.addRow(new Object[]{"--","   -"+listaDatos.get(PosD).getDato()});
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
            java.util.logging.Logger.getLogger(JFCrear_Examen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFCrear_Examen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFCrear_Examen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFCrear_Examen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFCrear_Examen().setVisible(true);
                
                //OBJETO PARA ENTERACTUAR CON LA CONEXION
                Conexion conec = new Conexion();
                //CREA REALIZA LA CONEXION Y CREA LA TABLA SI NO HAY
                conec.CrearTablas();
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnAgregarDatos;
    private javax.swing.JButton BtnCrearExamen;
    private javax.swing.JButton BtnEliminar;
    private javax.swing.JButton BtnModificar;
    private javax.swing.JButton BtnRegresar;
    private javax.swing.JTable TableExamenes;
    private javax.swing.JTextField TxtNombExamen;
    private javax.swing.JTextField TxtPrecioExamen;
    private javax.swing.JTextField TxtTabNombExamen;
    private javax.swing.JTextField TxtTabPrecioExamen;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
