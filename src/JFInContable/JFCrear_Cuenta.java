/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package JFInContable;

import InContable.Conexion;
import InContable.CuentasContable;
import static InContable.CuentasContable.ListaGrupoActivoCorriente;
import static InContable.CuentasContable.ListaGrupoActivoNoCorriente;
import static InContable.CuentasContable.ListaGrupoCapital;
import static InContable.CuentasContable.ListaGrupoCosto;
import static InContable.CuentasContable.ListaGrupoGastoNoOperativos;
import static InContable.CuentasContable.ListaGrupoGastoOperativos;
import static InContable.CuentasContable.ListaGrupoIngresoNoOperativos;
import static InContable.CuentasContable.ListaGrupoIngresoOperativos;
import static InContable.CuentasContable.ListaGrupoPasivoCorriente;
import static InContable.CuentasContable.ListaGrupoPasivoNoCorriente;
import static InContable.CuentasContable.ListaTipoCuentaAP;
import static InContable.CuentasContable.ListaTipoCuentaIG;
import InContable.Modulos.CRUD_CuentasContable;
import static InContable.Modulos.CRUD_CuentasContable.listaCuentasContable;
import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ulise
 */
public class JFCrear_Cuenta extends javax.swing.JFrame {
    DefaultTableModel model;
    CuentasContable incuenta = new CuentasContable();
    CRUD_CuentasContable CRCuentasContable = new CRUD_CuentasContable();
    String AuxiliarTipo;
    public String ID_LibroDato;
    
    /**
     * Creates new form JFCrear_Cuenta
     */
    public JFCrear_Cuenta(String ID_Libro) {
        initComponents();
        this.setLocationRelativeTo(null);
        
        ID_LibroDato = ID_Libro;
        model = (DefaultTableModel) this.TableCuentasContables.getModel();
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
        jScrollPane1 = new javax.swing.JScrollPane();
        TableCuentasContables = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        CombxGrupoCuenta = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        TxtNombreCuenta = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        CombxTipoCuenta = new javax.swing.JComboBox<>();
        CombxSubGrupoCuenta = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));

        TableCuentasContables.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "ID", "Nombre"
            }
        ));
        jScrollPane1.setViewportView(TableCuentasContables);
        if (TableCuentasContables.getColumnModel().getColumnCount() > 0) {
            TableCuentasContables.getColumnModel().getColumn(0).setMinWidth(50);
            TableCuentasContables.getColumnModel().getColumn(0).setPreferredWidth(50);
            TableCuentasContables.getColumnModel().getColumn(0).setMaxWidth(50);
        }

        jButton1.setText("Agregar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton3.setText("Eliminar");

        CombxGrupoCuenta.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {"SELECCIONE GRUPO", "ACTIVO", "PASIVO", "CAPITAL", "INGRESO", "COSTO", "GASTOS" }));
        CombxGrupoCuenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CombxGrupoCuentaActionPerformed(evt);
            }
        });

        jLabel2.setText("Grupo de Cuenta");

        jLabel3.setText("Nombre de Cuenta");

        CombxTipoCuenta.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {}));
        CombxTipoCuenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CombxTipoCuentaActionPerformed(evt);
            }
        });

        CombxSubGrupoCuenta.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {}));

        jLabel4.setText("Sub Grupo");

        jLabel5.setText("Tipo Cuenta");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(CombxGrupoCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(48, 48, 48)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(CombxTipoCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(55, 55, 55)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(CombxSubGrupoCuenta, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(TxtNombreCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 585, Short.MAX_VALUE))
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton1)
                    .addComponent(jButton3))
                .addGap(20, 20, 20))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CombxGrupoCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CombxTipoCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CombxSubGrupoCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(TxtNombreCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(151, 151, 151)
                        .addComponent(jButton3)
                        .addGap(70, 70, 70))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );

        jPanel3.setBackground(new java.awt.Color(153, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setText("CREAR CUENTE CONTABLE");

        jButton4.setText("Regersar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton4)
                .addGap(47, 47, 47)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton4))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
        String TipoCuenta = "";
        String GrupoCuenta;
        String SubGrupoCuenta;
        String NombreCuenta;
        
        //OBJETO PARA ENTERACTUAR CON LA CONEXION
        Conexion conec = new Conexion();
        //CREA REALIZA LA CONEXION Y CREA LA TABLA SI NO HAY
        conec.CrearTablas();
        
        //SE OBTIENES LOS DATOS DE LOS INPUTS
        
        if(CombxTipoCuenta.getSelectedItem()!= null){
            TipoCuenta = CombxTipoCuenta.getSelectedItem().toString();
        }
        
        GrupoCuenta = CombxGrupoCuenta.getSelectedItem().toString();
        SubGrupoCuenta = CombxSubGrupoCuenta.getSelectedItem().toString();
        NombreCuenta = TxtNombreCuenta.getText();
        
        CRCuentasContable.Insertar(TipoCuenta,GrupoCuenta,SubGrupoCuenta,NombreCuenta);
        
        Llenar();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        //OBJETO PARA INTERACTUAR CON EL JFCrear_Partida
        JFCrear_Partida InContable = new JFCrear_Partida(ID_LibroDato);
        //SE INDICA QUE SE MUESTRE LA VENTANA
        InContable.setVisible(true);
        //SE OCULTA LA VENTANA ACTUAL
        this.dispose();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void CombxGrupoCuentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CombxGrupoCuentaActionPerformed
        // TODO add your handling code here:
        CombxSubGrupoCuenta.removeAllItems();
        CombxTipoCuenta.removeAllItems();
        
        switch (CombxGrupoCuenta.getSelectedItem().toString()) {
            case "SELECCIONE GRUPO":
                
            break;
            case "ACTIVO":
                jLabel5.setVisible(TRUE);
                CombxTipoCuenta.setVisible(TRUE);
                CombxTipoCuenta.addItem("Seleccione Tipo");
                for(int i = 0; i < incuenta.ListaTipoCuentaAP.length; i++){
                    CombxTipoCuenta.addItem(incuenta.ListaTipoCuentaAP[i].toString());
                }
                AuxiliarTipo = CombxTipoCuenta.getSelectedItem().toString();
                break;
            case "PASIVO":
                jLabel5.setVisible(TRUE);
                CombxTipoCuenta.setVisible(TRUE);
                CombxTipoCuenta.addItem("Seleccione Tipo");
                for(int i = 0; i < incuenta.ListaTipoCuentaAP.length; i++){
                    CombxTipoCuenta.addItem(incuenta.ListaTipoCuentaAP[i].toString());
                }
                AuxiliarTipo = CombxTipoCuenta.getSelectedItem().toString();
                break;
            case "CAPITAL":
                jLabel5.setVisible(FALSE);
                CombxTipoCuenta.setVisible(FALSE);
                
                for(int i = 0; i < incuenta.ListaGrupoCapital.length; i++){
                    CombxSubGrupoCuenta.addItem(incuenta.ListaGrupoCapital[i].toString());
                }

                break;
            case "INGRESO":
                jLabel5.setVisible(TRUE);
                CombxTipoCuenta.setVisible(TRUE);
                CombxTipoCuenta.addItem("Seleccione Tipo");
                for(int i = 0; i < incuenta.ListaTipoCuentaIG.length; i++){
                    CombxTipoCuenta.addItem(incuenta.ListaTipoCuentaIG[i].toString());
                }
                AuxiliarTipo = CombxTipoCuenta.getSelectedItem().toString();
                break;
            case "COSTO":
                jLabel5.setVisible(FALSE);
                CombxTipoCuenta.setVisible(FALSE);
                
                for(int i = 0; i < incuenta.ListaGrupoCosto.length; i++){
                    CombxSubGrupoCuenta.addItem(incuenta.ListaGrupoCosto[i].toString());
                }

                break;
            case "GASTOS":
                jLabel5.setVisible(TRUE);
                CombxTipoCuenta.setVisible(TRUE);
                CombxTipoCuenta.addItem("Seleccione Tipo");
                for(int i = 0; i < incuenta.ListaTipoCuentaIG.length; i++){
                    CombxTipoCuenta.addItem(incuenta.ListaTipoCuentaIG[i].toString());
                }
                AuxiliarTipo = CombxTipoCuenta.getSelectedItem().toString();
                break;
            default:
                throw new AssertionError();
        }
    }//GEN-LAST:event_CombxGrupoCuentaActionPerformed

    private void CombxTipoCuentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CombxTipoCuentaActionPerformed
        // TODO add your handling code here:

        CombxSubGrupoCuenta.removeAllItems();
        
        System.err.println(""+AuxiliarTipo);
        System.err.println(""+CombxTipoCuenta.getSelectedItem());
        
        if(CombxTipoCuenta.getSelectedItem()!= null){
            AuxiliarTipo = CombxTipoCuenta.getSelectedItem().toString();
        }
        
        switch (CombxGrupoCuenta.getSelectedItem().toString()) {
            case "ACTIVO":

                if("Corriente".equals(AuxiliarTipo)){
                    for(int i = 0; i < incuenta.ListaGrupoActivoCorriente.length; i++){
                        CombxSubGrupoCuenta.addItem(incuenta.ListaGrupoActivoCorriente[i].toString());
                    } 
                }else if("No Corriente".equals(AuxiliarTipo)){
                    for(int i = 0; i < incuenta.ListaGrupoActivoNoCorriente.length; i++){
                        CombxSubGrupoCuenta.addItem(incuenta.ListaGrupoActivoNoCorriente[i].toString());
                    } 
                }
                
            break;
            case "PASIVO":
                
                if("Corriente".equals(AuxiliarTipo)){
                    for(int i = 0; i < incuenta.ListaGrupoPasivoCorriente.length; i++){
                        CombxSubGrupoCuenta.addItem(incuenta.ListaGrupoPasivoCorriente[i].toString());
                    } 
                }else if("No Corriente".equals(AuxiliarTipo)){
                    for(int i = 0; i < incuenta.ListaGrupoPasivoNoCorriente.length; i++){
                        CombxSubGrupoCuenta.addItem(incuenta.ListaGrupoPasivoNoCorriente[i].toString());
                    }
                }
                
            break;
            case "CAPITAL":
                for(int i = 0; i < incuenta.ListaGrupoCapital.length; i++){
                    CombxSubGrupoCuenta.addItem(incuenta.ListaGrupoCapital[i].toString());
                }
            break;
            case "INGRESO":
                
                if("Operativos".equals(AuxiliarTipo)){
                    for(int i = 0; i < incuenta.ListaGrupoIngresoOperativos.length; i++){
                        CombxSubGrupoCuenta.addItem(incuenta.ListaGrupoIngresoOperativos[i].toString());
                    } 
                }else if("No Operativos".equals(AuxiliarTipo)){
                    for(int i = 0; i < incuenta.ListaGrupoIngresoNoOperativos.length; i++){
                        CombxSubGrupoCuenta.addItem(incuenta.ListaGrupoIngresoNoOperativos[i].toString());
                    }
                }
 
            break;
            case "COSTO":
                for(int i = 0; i < incuenta.ListaGrupoCosto.length; i++){
                    CombxSubGrupoCuenta.addItem(incuenta.ListaGrupoCosto[i].toString());
                }
            break;
            case "GASTOS":

                if("Operativos".equals(AuxiliarTipo)){
                    for(int i = 0; i < incuenta.ListaGrupoGastoOperativos.length; i++){
                        CombxSubGrupoCuenta.addItem(incuenta.ListaGrupoGastoOperativos[i].toString());
                    } 
                }else if("No Operativos".equals(AuxiliarTipo)){
                    for(int i = 0; i < incuenta.ListaGrupoGastoNoOperativos.length; i++){
                        CombxSubGrupoCuenta.addItem(incuenta.ListaGrupoGastoNoOperativos[i].toString());
                    }
                }
                
            break;
            default:
                throw new AssertionError();
        }
    }//GEN-LAST:event_CombxTipoCuentaActionPerformed

    public void Llenar(){

        //SE LIMPIA LA TABLA
        model.setRowCount(0);
        CRCuentasContable.LlenarTabla();
        //CICLO PARA LLENAR LA TABLA CON LOS VALORES DEL ARREGLO
        for(int PosComb = 1; PosComb < CombxGrupoCuenta.getItemCount(); PosComb++){

            model.addRow(new Object[]{"",CombxGrupoCuenta.getItemAt(PosComb).toString()});
            
            if("ACTIVO".equals(CombxGrupoCuenta.getItemAt(PosComb))){
                LlenarActivos();
            }else if("PASIVO".equals(CombxGrupoCuenta.getItemAt(PosComb))){
                LlenarPasivos();
            }else if("CAPITAL".equals(CombxGrupoCuenta.getItemAt(PosComb))){
                LlenarCapital();
            }else if("INGRESO".equals(CombxGrupoCuenta.getItemAt(PosComb))){
                LlenarIngresos();
            }else if("COSTO".equals(CombxGrupoCuenta.getItemAt(PosComb))){
                LlenarCostos();
            }else if("GASTOS".equals(CombxGrupoCuenta.getItemAt(PosComb))){
                LlenarGatos();
            }
        }
    }
    
    public void LlenarActivos(){

        for(int PosTipo = 0; PosTipo < ListaTipoCuentaAP.length; PosTipo++){
                
            model.addRow(new Object[]{"",ListaTipoCuentaAP[PosTipo]});

            if("Corriente".equals(ListaTipoCuentaAP[PosTipo])){
                LlenarActivosCorrientes();  
            }else if("No Corriente".equals(ListaTipoCuentaAP[PosTipo])){
                LlenarActivosNoCorrientes();
            }
        }
    }
 
    public void LlenarActivosCorrientes(){
        
        for(int PosGrupo = 0; PosGrupo < ListaGrupoActivoCorriente.length; PosGrupo++){
             
            model.addRow(new Object[]{"","--"+ListaGrupoActivoCorriente[PosGrupo]});
            
            for(int PosC = 0; PosC < listaCuentasContable.size(); PosC++){

                if(ListaGrupoActivoCorriente[PosGrupo].
                        equals(listaCuentasContable.get(PosC).getSubGrupoCuenta())){

                    model.addRow(new Object[]{listaCuentasContable.get(PosC).getID()," "+
                                "       "+listaCuentasContable.get(PosC).getNombreCuenta()});
                }               
            }           
        }        
    }
    
    public void LlenarActivosNoCorrientes(){
        
        for(int PosGrupo = 0; PosGrupo < ListaGrupoActivoNoCorriente.length; PosGrupo++){
             
            model.addRow(new Object[]{"","--"+ListaGrupoActivoNoCorriente[PosGrupo]});
            
            for(int PosC = 0; PosC < listaCuentasContable.size(); PosC++){
                
                if(ListaGrupoActivoNoCorriente[PosGrupo].
                        equals(listaCuentasContable.get(PosC).getSubGrupoCuenta())){

                    model.addRow(new Object[]{listaCuentasContable.get(PosC).getID()," "+
                                "       "+listaCuentasContable.get(PosC).getNombreCuenta()});
                }               
            }           
        }      
    }
    
    public void LlenarPasivos(){

        for(int PosTipo = 0; PosTipo < ListaTipoCuentaAP.length; PosTipo++){
                
            model.addRow(new Object[]{"",ListaTipoCuentaAP[PosTipo]});

            if("Corriente".equals(ListaTipoCuentaAP[PosTipo])){
                LlenarPasivosCorrientes();  
            }else if("No Corriente".equals(ListaTipoCuentaAP[PosTipo])){
                LlenarPasivosNoCorrientes();
            }
        }
    }
    
    public void LlenarPasivosCorrientes(){

        for(int PosGrupo = 0; PosGrupo < ListaGrupoPasivoCorriente.length; PosGrupo++){
             
            model.addRow(new Object[]{"","--"+ListaGrupoPasivoCorriente[PosGrupo]});
            
            for(int PosC = 0; PosC < listaCuentasContable.size(); PosC++){

                if(ListaGrupoPasivoCorriente[PosGrupo].
                        equals(listaCuentasContable.get(PosC).getSubGrupoCuenta())){

                    model.addRow(new Object[]{listaCuentasContable.get(PosC).getID()," "+
                                "       "+listaCuentasContable.get(PosC).getNombreCuenta()});
                }               
            }            
        }         
    }
    
    public void LlenarPasivosNoCorrientes(){

        for(int PosGrupo = 0; PosGrupo < ListaGrupoPasivoNoCorriente.length; PosGrupo++){
             
            model.addRow(new Object[]{"","--"+ListaGrupoPasivoNoCorriente[PosGrupo]});
            
            for(int PosC = 0; PosC < listaCuentasContable.size(); PosC++){

                if(ListaGrupoPasivoNoCorriente[PosGrupo].
                        equals(listaCuentasContable.get(PosC).getSubGrupoCuenta())){

                    model.addRow(new Object[]{listaCuentasContable.get(PosC).getID()," "+
                                "       "+listaCuentasContable.get(PosC).getNombreCuenta()});
                }               
            }           
        }
    }
    
    public void LlenarCapital(){

        for(int PosGrupo = 0; PosGrupo < ListaGrupoCapital.length; PosGrupo++){
             
            model.addRow(new Object[]{"","--"+ListaGrupoCapital[PosGrupo]});

            for(int PosC = 0; PosC < listaCuentasContable.size(); PosC++){

                if(ListaGrupoCapital[PosGrupo].
                        equals(listaCuentasContable.get(PosC).getSubGrupoCuenta())){

                    model.addRow(new Object[]{listaCuentasContable.get(PosC).getID()," "+
                                "       "+listaCuentasContable.get(PosC).getNombreCuenta()});
                }              
            }            
        }
    }
    
    public void LlenarIngresos(){

        for(int PosTipo = 0; PosTipo < ListaTipoCuentaIG.length; PosTipo++){
                
            model.addRow(new Object[]{"",ListaTipoCuentaIG[PosTipo]});
            if("Operativos".equals(ListaTipoCuentaIG[PosTipo])){
                LlenarIngresosOperativos();  
            }else if("No Operativos".equals(ListaTipoCuentaIG[PosTipo])){
                LlenarIngresosNoOperativos();
            }
        }
    }
    
    public void LlenarIngresosOperativos(){

        for(int PosGrupo = 0; PosGrupo < ListaGrupoIngresoOperativos.length; PosGrupo++){
             
            model.addRow(new Object[]{"","--"+ListaGrupoIngresoOperativos[PosGrupo]});
            
            for(int PosC = 0; PosC < listaCuentasContable.size(); PosC++){

                if(ListaGrupoIngresoOperativos[PosGrupo].
                        equals(listaCuentasContable.get(PosC).getSubGrupoCuenta())){

                    model.addRow(new Object[]{listaCuentasContable.get(PosC).getID()," "+
                                "       "+listaCuentasContable.get(PosC).getNombreCuenta()});
                }               
            }           
        }
    }
    
    public void LlenarIngresosNoOperativos(){

        for(int PosGrupo = 0; PosGrupo < ListaGrupoIngresoNoOperativos.length; PosGrupo++){
             
            model.addRow(new Object[]{"","--"+ListaGrupoIngresoNoOperativos[PosGrupo]});
            
            for(int PosC = 0; PosC < listaCuentasContable.size(); PosC++){

                if(ListaGrupoIngresoNoOperativos[PosGrupo].
                        equals(listaCuentasContable.get(PosC).getSubGrupoCuenta())){

                    model.addRow(new Object[]{listaCuentasContable.get(PosC).getID()," "+
                                "       "+listaCuentasContable.get(PosC).getNombreCuenta()});
                }               
            }            
        }
    }
    
    public void LlenarCostos(){

        for(int PosGrupo = 0; PosGrupo < ListaGrupoCosto.length; PosGrupo++){
             
            model.addRow(new Object[]{"","--"+ListaGrupoCosto[PosGrupo]});

            for(int PosC = 0; PosC < listaCuentasContable.size(); PosC++){

                if(ListaGrupoCosto[PosGrupo].
                        equals(listaCuentasContable.get(PosC).getSubGrupoCuenta())){

                    model.addRow(new Object[]{listaCuentasContable.get(PosC).getID()," "+
                                "       "+listaCuentasContable.get(PosC).getNombreCuenta()});
                }              
            }            
        }
    }
    
    public void LlenarGatos(){

        for(int PosTipo = 0; PosTipo < ListaTipoCuentaIG.length; PosTipo++){
                
            model.addRow(new Object[]{"",ListaTipoCuentaIG[PosTipo]});

            if("Operativos".equals(ListaTipoCuentaIG[PosTipo])){
                LlenarGatosOperativos();  
            }else if("No Operativos".equals(ListaTipoCuentaIG[PosTipo])){
                LlenarGatosNoOperativos();
            }
        }
    }
    
    public void LlenarGatosOperativos(){

        for(int PosGrupo = 0; PosGrupo < ListaGrupoGastoOperativos.length; PosGrupo++){
             
            model.addRow(new Object[]{"","--"+ListaGrupoGastoOperativos[PosGrupo]});
            
            for(int PosC = 0; PosC < listaCuentasContable.size(); PosC++){

                if(ListaGrupoGastoOperativos[PosGrupo].
                        equals(listaCuentasContable.get(PosC).getSubGrupoCuenta())){

                    model.addRow(new Object[]{listaCuentasContable.get(PosC).getID()," "+
                                "       "+listaCuentasContable.get(PosC).getNombreCuenta()});
                }               
            }            
        }
    }
    
    public void LlenarGatosNoOperativos(){

        for(int PosGrupo = 0; PosGrupo < ListaGrupoGastoNoOperativos.length; PosGrupo++){
             
            model.addRow(new Object[]{"","--"+ListaGrupoGastoNoOperativos[PosGrupo]});
            
            for(int PosC = 0; PosC < listaCuentasContable.size(); PosC++){

                if(ListaGrupoGastoNoOperativos[PosGrupo].
                        equals(listaCuentasContable.get(PosC).getSubGrupoCuenta())){

                    model.addRow(new Object[]{listaCuentasContable.get(PosC).getID()," "+
                                "       "+listaCuentasContable.get(PosC).getNombreCuenta()});
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
            java.util.logging.Logger.getLogger(JFCrear_Cuenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFCrear_Cuenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFCrear_Cuenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFCrear_Cuenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
                //OBJETO PARA ENTERACTUAR CON LA CONEXION
                Conexion conec = new Conexion();
                //CREA REALIZA LA CONEXION Y CREA LA TABLA SI NO HAY
                conec.CrearTablas();
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> CombxGrupoCuenta;
    private javax.swing.JComboBox<String> CombxSubGrupoCuenta;
    private javax.swing.JComboBox<String> CombxTipoCuenta;
    private javax.swing.JTable TableCuentasContables;
    private javax.swing.JTextField TxtNombreCuenta;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
