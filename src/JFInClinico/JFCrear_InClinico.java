/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package JFInClinico;

import InClinico.CRUD_Examenes;
import static InClinico.CRUD_Examenes.listaExamenes;
import InClinico.CRUD_InClinico;
import InClinico.Conexion;
import InClinico.InClRecibo;
import JFInContable.JFCrear_InContable;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ulise
 */
public class JFCrear_InClinico extends javax.swing.JFrame implements Printable{
    //OBJETO PARA INTERACTUAR CON LA TABLA
    DefaultTableModel model;
    
    //LISTA PARA ALMACENAR LOS DATOS OBTENIDOS DE LA BASE DE DATOS
    public static List<InClRecibo> listaInClRecibo = new ArrayList<InClRecibo>();
    
    /**
     * Creates new form JFCrear_InClinico
     */
    public JFCrear_InClinico() {
        initComponents();
        this.setLocationRelativeTo(null);
        model = (DefaultTableModel) this.TableInClRecibo.getModel();
        
        Combo();
        
        listaInClRecibo.clear();
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
        BtnMosInClinico = new javax.swing.JButton();
        BtnInContable = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        TxtNombCliente = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jCFecha = new com.toedter.calendar.JCalendar();
        BtnAgregar = new javax.swing.JButton();
        BtnLimpiar = new javax.swing.JButton();
        CombxExamen = new javax.swing.JComboBox<>();
        BtnCrear = new javax.swing.JButton();
        JPRecibo = new javax.swing.JPanel();
        jPanelRecibo = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        TxtNomPacienteRecibo = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        TxtFecha = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TableInClRecibo = new javax.swing.JTable();
        TxtTotalExamen = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        BtnEliminar = new javax.swing.JButton();
        BtnGuardar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(0, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("CREAR INFORME DE EXAMEN CLINICO");

        BtnMosInClinico.setText("MOSTRAR INFORMES");
        BtnMosInClinico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnMosInClinicoActionPerformed(evt);
            }
        });

        BtnInContable.setText("INFORME CONTABLE");
        BtnInContable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnInContableActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(BtnMosInClinico, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(23, 23, 23)
                .addComponent(BtnInContable, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(50, 50, 50))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(188, 188, 188)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(195, 195, 195))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnMosInClinico)
                    .addComponent(BtnInContable))
                .addGap(16, 16, 16))
        );

        jPanel2.setBackground(new java.awt.Color(204, 204, 255));

        jLabel2.setText("NOMBRE DE PACIENTE");

        jLabel3.setText("NOMBRE DE EXAMEN CLINICO");

        jLabel5.setText("FECHA EN QUE SE REALIZO");

        BtnAgregar.setText("AGREGAR");
        BtnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAgregarActionPerformed(evt);
            }
        });

        BtnLimpiar.setText("LIMPIAR RECIBO");
        BtnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnLimpiarActionPerformed(evt);
            }
        });

        CombxExamen.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccion Examen" }));

        BtnCrear.setText("CREAR");
        BtnCrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnCrearActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TxtNombCliente)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jCFecha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(BtnLimpiar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(31, 31, 31)
                        .addComponent(BtnAgregar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(20, 20, 20))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(CombxExamen, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BtnCrear)
                        .addGap(10, 10, 10)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TxtNombCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CombxExamen)
                    .addComponent(BtnCrear))
                .addGap(18, 18, 18)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCFecha, javax.swing.GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
                .addGap(35, 35, 35)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnAgregar)
                    .addComponent(BtnLimpiar))
                .addGap(15, 15, 15))
        );

        jPanelRecibo.setBackground(new java.awt.Color(204, 204, 255));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("RECIBO DE EXAMENES REALIZADOS");

        jLabel7.setText("NOMBRE");

        TxtNomPacienteRecibo.setText("NOMBRE PACIENTE");

        jLabel8.setText("FECHA");

        TxtFecha.setText("FECHA");

        TableInClRecibo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre Examen", "Precio"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(TableInClRecibo);
        if (TableInClRecibo.getColumnModel().getColumnCount() > 0) {
            TableInClRecibo.getColumnModel().getColumn(1).setMinWidth(100);
            TableInClRecibo.getColumnModel().getColumn(1).setPreferredWidth(10);
            TableInClRecibo.getColumnModel().getColumn(1).setMaxWidth(100);
        }

        TxtTotalExamen.setText("TOTAL");

        jLabel9.setText("PRECIO TOTAL:");

        jLabel10.setText("LABORATORIO CLINICO DE ANALISIS HENDRYKS");

        javax.swing.GroupLayout jPanelReciboLayout = new javax.swing.GroupLayout(jPanelRecibo);
        jPanelRecibo.setLayout(jPanelReciboLayout);
        jPanelReciboLayout.setHorizontalGroup(
            jPanelReciboLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelReciboLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanelReciboLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelReciboLayout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(31, 31, 31))
                    .addGroup(jPanelReciboLayout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(jPanelReciboLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelReciboLayout.createSequentialGroup()
                        .addComponent(TxtFecha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(228, 228, 228))
                    .addGroup(jPanelReciboLayout.createSequentialGroup()
                        .addComponent(TxtNomPacienteRecibo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(169, 169, 169))))
            .addGroup(jPanelReciboLayout.createSequentialGroup()
                .addGap(219, 219, 219)
                .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(TxtTotalExamen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(32, 32, 32))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelReciboLayout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(64, 64, 64))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelReciboLayout.createSequentialGroup()
                .addGap(83, 83, 83)
                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(82, 82, 82))
            .addGroup(jPanelReciboLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanelReciboLayout.setVerticalGroup(
            jPanelReciboLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelReciboLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelReciboLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(TxtNomPacienteRecibo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelReciboLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TxtFecha, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelReciboLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(TxtTotalExamen, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(5, 5, 5))
        );

        javax.swing.GroupLayout JPReciboLayout = new javax.swing.GroupLayout(JPRecibo);
        JPRecibo.setLayout(JPReciboLayout);
        JPReciboLayout.setHorizontalGroup(
            JPReciboLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelRecibo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        JPReciboLayout.setVerticalGroup(
            JPReciboLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelRecibo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel4.setBackground(new java.awt.Color(204, 204, 255));

        BtnEliminar.setText("ELIMINAR");
        BtnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnEliminarActionPerformed(evt);
            }
        });

        BtnGuardar.setText("GUARDAR INFORME");
        BtnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnGuardarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(BtnGuardar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(85, 85, 85)
                .addComponent(BtnEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(20, 20, 20))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnEliminar)
                    .addComponent(BtnGuardar))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JPRecibo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(JPRecibo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnMosInClinicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnMosInClinicoActionPerformed
        // TODO add your handling code here:
        //OBJETO PARA INTERACTUAR CON EL JFMostrar_InClinico
        JFMostrar_InClinico Mostrar = new JFMostrar_InClinico();
        //SE INDICA QUE SE MUESTRE LA VENTANA
        Mostrar.setVisible(true);
        //SE OCULTA LA VENTANA ACTUAL
        this.dispose();
    }//GEN-LAST:event_BtnMosInClinicoActionPerformed

    private void BtnInContableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnInContableActionPerformed
        // TODO add your handling code here:
        //OBJETO PARA INTERACTUAR CON EL JFCrear_InContable
        JFCrear_InContable InContable = new JFCrear_InContable();
        //SE INDICA QUE SE MUESTRE LA VENTANA
        InContable.setVisible(true);
        //SE OCULTA LA VENTANA ACTUAL
        this.dispose();
    }//GEN-LAST:event_BtnInContableActionPerformed

    private void BtnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnLimpiarActionPerformed
        // TODO add your handling code here:
        
        TxtNombCliente.setText("");

        TxtNomPacienteRecibo.setText("Nombre Paciente");
        TxtTotalExamen.setText("Total");
        TxtFecha.setText("Fecha");
        
        listaInClRecibo.clear();
        Llenar();
    }//GEN-LAST:event_BtnLimpiarActionPerformed

    private void BtnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAgregarActionPerformed
        //OBJETO PARA ENTERACTUAR CON LA CONEXION
            Conexion conec = new Conexion();
            //CREA REALIZA LA CONEXION Y CREA LA TABLA SI NO HAY
            conec.CrearTablas();
        
        try {
            // TODO add your handling code here:
            
            //SE OBTIENEN LOS DATOS DEL JCALENDAT
            String dia = Integer.toString(jCFecha.getCalendar().get(Calendar.DAY_OF_MONTH));
            String mes = Integer.toString(jCFecha.getCalendar().get(Calendar.MONTH)+1);
            String anio = Integer.toString(jCFecha.getCalendar().get(Calendar.YEAR));
            //SE OBTIENES LOS DATOS DE LOS INPUTS
            
            String Nombre_Cliente = TxtNombCliente.getText();
            
            //VARIABLE PARA EL RESULTADO OBTENIDO
            ResultSet result = null;
            
            //SE INDICA LA ACCION CON LA BASE DE DATOS (SE OBTINIENE LOS DATOS ALMACENADOS)
            PreparedStatement st = conec.conexion.prepareStatement("select Nombre_Examen, "
                    + "Precio_Examen from TBL_Examen where Nombre_Examen ='"+CombxExamen.getSelectedItem().toString()+"'");
            //SE ALMACENA LOS RESULTADOS
            result = st.executeQuery();

            String Nombre_Examen = result.getString("Nombre_Examen");
            Double PrecioTotal_Examen = result.getDouble("Precio_Examen");
            //SE ALMACENA LOS VALOR DE LA FECHA
            String Fecha = dia+ "/" +mes+ "/" +anio;
            
            //OBJETO DEL CONSTRUCTOR
            InClRecibo InClRecibo = new InClRecibo(Nombre_Cliente,Nombre_Examen,PrecioTotal_Examen,Fecha);
            
            //SE AGREGA EL CONSTRUCTOR AL ARREGLO
            listaInClRecibo.add(InClRecibo);
            
            conec.conexion.close();
            
            Llenar();
        } catch (SQLException ex) {
            Logger.getLogger(JFCrear_InClinico.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_BtnAgregarActionPerformed

    private void BtnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnGuardarActionPerformed
        // TODO add your handling code here:
        
        Guardar();
    }//GEN-LAST:event_BtnGuardarActionPerformed

    private void BtnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnEliminarActionPerformed
        // TODO add your handling code here:
        
        int fila = TableInClRecibo.getSelectedRow();
        if(fila == -1){
            JOptionPane.showMessageDialog(null, "NO SE A SELECIONADO FILA");
        }
        else{
            listaInClRecibo.remove(fila);
        }
        
        Llenar();
    }//GEN-LAST:event_BtnEliminarActionPerformed

    private void BtnCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCrearActionPerformed
        // TODO add your handling code here:
        
        //OBJETO PARA INTERACTUAR CON EL JFCrear_InContable
        JFCrear_Examen Examen = new JFCrear_Examen();
        //SE INDICA QUE SE MUESTRE LA VENTANA
        Examen.setVisible(true);
        //SE OCULTA LA VENTANA ACTUAL
        this.dispose();
        
    }//GEN-LAST:event_BtnCrearActionPerformed

    public void Guardar(){
        
        //OBJETO PARA ENTERACTUAR CON LA CONEXION
        Conexion conec = new Conexion();
        //CREA REALIZA LA CONEXION Y CREA LA TABLA SI NO HAY
        conec.CrearTablas();

        //CICLO PARA LLENAR LA TABLA CON LOS VALORES DEL ARREGLO
        for(int PosC = 0; PosC < listaInClRecibo.size(); PosC++){

            //OBJETO PARA ENTERACTUAR CON EL CRUD
            CRUD_InClinico Cr = new CRUD_InClinico();
            //SE MANDA LOS VALORES AL INSERTAR
            Cr.Insertar(listaInClRecibo.get(PosC).getNombre_Cliente(), listaInClRecibo.get(PosC).getNombre_Examen()
                        , listaInClRecibo.get(PosC).getPrecio_Examen(), listaInClRecibo.get(PosC).getFecha());
        }
        
        JOptionPane.showMessageDialog(null, "DATOS GUARDADOS");
        
        Imprimir();
        
        TxtNombCliente.setText("");

        TxtNomPacienteRecibo.setText("Nombre Paciente");
        TxtTotalExamen.setText("Total");
        TxtFecha.setText("Fecha");
        
        listaInClRecibo.clear();
        Llenar();
        
    }
    
    public void Llenar(){
        Double Total = 0.0;
        
        //SE LIMPIA LA TABLA
        model.setRowCount(0);
        
        //CICLO PARA LLENAR LA TABLA CON LOS VALORES DEL ARREGLO
        for(int PosC = 0; PosC < listaInClRecibo.size(); PosC++){
            
            TxtNomPacienteRecibo.setText(listaInClRecibo.get(PosC).getNombre_Cliente());

            model.addRow(new Object[]{listaInClRecibo.get(PosC).getNombre_Examen(),listaInClRecibo.get(PosC).getPrecio_Examen()});
            
            TxtFecha.setText(listaInClRecibo.get(PosC).getFecha());
            
            Total = Total+listaInClRecibo.get(PosC).getPrecio_Examen();
        }
        
        TxtTotalExamen.setText(""+Total);
        
    }
    
    public void Combo(){
        
        //OBJETO PARA ENTERACTUAR CON EL CRUD
        CRUD_Examenes cr = new CRUD_Examenes();
        //SE LLENA EL ARREGLO CON LOS VALORES DE LA TABLA
        cr.LlenarTabla();
        //CICLO PARA LLENAR LA TABLA CON LOS VALORES DEL ARREGLO
        for(int PosC = 0; PosC < listaExamenes.size(); PosC++){
            
            System.out.println("Se lleno el arreglo con los datos"+ listaExamenes.get(PosC).getNombre_Examen());
            
            CombxExamen.addItem(listaExamenes.get(PosC).getNombre_Examen());

        }
        
    }
    
    public void Imprimir(){
        Document documento = new Document();
        
        try{
            String ruta = System.getProperty("user.home");
            PdfWriter.getInstance(documento, new FileOutputStream(ruta + "/Desktop/" + TxtNombCliente.getText().trim() + ".pdf"));
            
            documento.open();
            
            Paragraph parrafo = new Paragraph();
            
            parrafo.setAlignment(Paragraph.ALIGN_CENTER);
            parrafo.add("LABORATORIO CLINICO DE ANALISIS HENDRYKS\n \n");
            parrafo.setFont(FontFactory.getFont("Tahoma", 14, Font.BOLD, BaseColor.DARK_GRAY));
            
            parrafo.setAlignment(Paragraph.ALIGN_CENTER);
            parrafo.add("RECIBO DE EXAMENES REALIZADOS\n \n");
            parrafo.setFont(FontFactory.getFont("Tahoma", 14, Font.BOLD, BaseColor.DARK_GRAY));
            
            documento.add(parrafo);
            
            PdfPTable tablaCliente = new PdfPTable(4);
            tablaCliente.addCell("Nombre");
            tablaCliente.addCell("Nombre del Examen");
            tablaCliente.addCell("Precio");
            tablaCliente.addCell("Fecha");
            
                //CICLO PARA LLENAR LA TABLA CON LOS VALORES DEL ARREGLO
                for(int PosC = 0; PosC < listaInClRecibo.size(); PosC++){
                    tablaCliente.addCell(listaInClRecibo.get(PosC).getNombre_Cliente());
                    tablaCliente.addCell(listaInClRecibo.get(PosC).getNombre_Examen());
                    tablaCliente.addCell(listaInClRecibo.get(PosC).getPrecio_Examen().toString());
                    tablaCliente.addCell(listaInClRecibo.get(PosC).getFecha());
                }
                documento.add(tablaCliente);
                
            documento.close();
            JOptionPane.showMessageDialog(null, "Reporte creado correctamente");
            
        }catch (FileNotFoundException ex) {
            Logger.getLogger(JFMostrar_InClinico.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DocumentException ex) {
            Logger.getLogger(JFMostrar_InClinico.class.getName()).log(Level.SEVERE, null, ex);
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
            java.util.logging.Logger.getLogger(JFCrear_InClinico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFCrear_InClinico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFCrear_InClinico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFCrear_InClinico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFCrear_InClinico().setVisible(true);
                //OBJETO PARA ENTERACTUAR CON LA CONEXION
                Conexion conec = new Conexion();
                //CREA REALIZA LA CONEXION Y CREA LA TABLA SI NO HAY
                conec.CrearTablas();
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnAgregar;
    private javax.swing.JButton BtnCrear;
    private javax.swing.JButton BtnEliminar;
    private javax.swing.JButton BtnGuardar;
    private javax.swing.JButton BtnInContable;
    private javax.swing.JButton BtnLimpiar;
    private javax.swing.JButton BtnMosInClinico;
    private javax.swing.JComboBox<String> CombxExamen;
    private javax.swing.JPanel JPRecibo;
    private javax.swing.JTable TableInClRecibo;
    private javax.swing.JLabel TxtFecha;
    private javax.swing.JLabel TxtNomPacienteRecibo;
    private javax.swing.JTextField TxtNombCliente;
    private javax.swing.JLabel TxtTotalExamen;
    private com.toedter.calendar.JCalendar jCFecha;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanelRecibo;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

    @Override
    public int print(Graphics graf, PageFormat pagFor, int index) throws PrinterException 
    {
        
        if(index>0){
            return NO_SUCH_PAGE;
        }
        
        Graphics2D gra2d = (Graphics2D) graf;
        gra2d.translate(pagFor.getImageableX(), pagFor.getImageableY());
        gra2d.scale(1.0, 1.0);
        
        JPRecibo.printAll(graf);
        
        return PAGE_EXISTS;
    }

    
}
