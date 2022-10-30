/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Contable.Modulos;

import Contable.Controladores.BalanceComprobacion;
import Contable.Controladores.Conexion;
import static Contable.Modulos.CRUD_LibroMayor.listaLibroMayor;
import Contable.Vistas.JFCrear_Partida;
import static Contable.Vistas.JFMostrar_BalancenComprobacion.ListaTipoCuentas;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Font;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author ulise
 */
public class CRUD_BalanceComprobacion {
    public static List<BalanceComprobacion> listaBalanceComprobacion = new ArrayList<BalanceComprobacion>();
    ArrayList<String> ListaCuentasRecoridas = new ArrayList<String>();
    
    CRUD_LibroMayor CrLibroMayor = new CRUD_LibroMayor();
    public static String ListaTipoCuentas [] = {"ACTIVO","PASIVO","CAPITAL", 
                                                "INGRESO", "COSTO", "GASTO"};
    
    double TotalActivos = 0, TotalPasivos = 0, TotalCapital = 0, 
        TotalIngresos = 0, TotalCostos = 0, TotalGastos = 0,
        TotalDeudor = 0, TotalAcreedor = 0;
    
    double TotalActivos2 = 0, TotalPasivos2 = 0, TotalCapital2 = 0, 
        TotalIngresos2 = 0, TotalCostos2 = 0, TotalGastos2 = 0,
        TotalDeudor2 = 0, TotalAcreedor2 = 0;
    
    //LLENA LA TABLA CON LOS DATOS OBTENIDOS DE LA BASE DE DATOS
    public static void LlenarTabla(){
        //SE VACIA LA LISTA
        listaBalanceComprobacion.clear();
        //OBJETO PARA TENER INTERACCION CON LA CLASE Conexion
        Conexion conec = new Conexion();
        //CREA LA CONECION Y VERIFICA LA EXISTENCIA DE LA TABLA
        conec.CrearTablas();
        //VARIABLE PARA EL RESULTADO OBTENIDO
        ResultSet result = null;
        
        try{
            //SE INDICA LA ACCION CON LA BASE DE DATOS (SE OBTINIENE LOS DATOS ALMACENADOS)
            PreparedStatement st = conec.conexion.prepareStatement("select * from TBL_BalanceComprobacion");
            //SE ALMACENA LOS RESULTADOS
            result = st.executeQuery();
            
            //SE RECORRE TODO LO ALMACENADO
            while(result.next()){
                //OBJETO DEL CONSTRUCTOR
                BalanceComprobacion InBalanceComprobacion = new BalanceComprobacion(result.getInt("ID"),
                                                result.getInt("IDLibro"),
                                                result.getDouble("Ingresos"),
                                                result.getDouble("Costos"),
                                                result.getDouble("Gastos"));
                
                //SE AGREGA EL CONSTRUCTOR AL ARREGLO
                listaBalanceComprobacion.add(InBalanceComprobacion);

            }
            
        }catch(Exception e){
            System.out.println(e + " Error al llenar la tabla");
        }
    }
    
    //INSERTA DATOS A LA TABLA DE LA BASE DE DATOS
    public static void Insertar(int IDLibro, Double Ingresos, Double Costos , Double Gastos){
        int ID;
        
        ID = (int)(Math.random()*9000+1);

        //OBJETO PARA TENER INTERACCION CON LA CLASE Conexion
        Conexion conec = new Conexion();

        try{

            //SE INDICA LA ACCION CON LA BASE DE DATOS (SE ALMACENA LOS DATOS)
            PreparedStatement st = conec.conexion.prepareStatement(
                    "insert into TBL_BalanceComprobacion(ID, IDLibro, Ingresos, Costos, Gastos)\n"
                            
                    + "values("+ID+","+IDLibro+","+Ingresos+","+Costos+","+Gastos+");");
            
            //EJECUTA LA ACCION
            st.execute();
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "ERROR AL INSERTAR LOS DATOS " + e);
        }
        
    }
    
    //MODIFICA DATOS A LA TABLA DE LA BASE DE DATOS
    public static void Modificar(int IDLibro, Double Ingresos, Double Costos , Double Gastos){

        //OBJETO PARA TENER INTERACCION CON LA CLASE Conexion
        Conexion conec = new Conexion();
        
        try{
            
            String sql = "Update TBL_BalanceComprobacion set "
                            + "IDLibro="+IDLibro+","
                            + "Ingresos="+Ingresos+","
                            + "Costos="+Costos+","
                            + "Gastos="+Gastos+" "
                            + "where IDLibro="+IDLibro;
            
            //SE INDICA LA ACCION CON LA BASE DE DATOS (SE ALMACENA LOS DATOS)
            PreparedStatement st = conec.conexion.prepareStatement(sql);
            //EJECUTA LA ACCION
            st.execute();
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "ERROR AL INSERTAR LOS DATOS " + e);
        }
    }
    
    public void BalanceComprobacion(String ID_Libro){
        
        CrLibroMayor.LlenarTabla();
        LlenarTabla();
        
        boolean ContAuxiliar;
        boolean VariableAuxiliar2 = true;
        ListaCuentasRecoridas.clear();
      
        ListaCuentasRecoridas.add("");
        
        for(int PosicionCuenta = 0; PosicionCuenta < ListaTipoCuentas.length; PosicionCuenta++){

            for(int PosLibroMayor = 0; PosLibroMayor < listaLibroMayor.size(); PosLibroMayor++){

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

                                if("INGRESO".equals(listaLibroMayor.get(Pos2LibroMayor).getGrupo_Cuenta())){

                                    TotalIngresos = TotalIngresos + listaLibroMayor.get(Pos2LibroMayor).getMontoTotal();
                                }
                                else if("COSTO".equals(listaLibroMayor.get(Pos2LibroMayor).getGrupo_Cuenta())){

                                    TotalCostos = TotalCostos+ listaLibroMayor.get(Pos2LibroMayor).getMontoTotal();
                                }
                                else if("GASTO".equals(listaLibroMayor.get(Pos2LibroMayor).getGrupo_Cuenta())){

                                    TotalGastos = TotalGastos + listaLibroMayor.get(Pos2LibroMayor).getMontoTotal();
                                }

                            }

                        }

                    }
                    if("".equals(ListaCuentasRecoridas.get(0))){
                        ListaCuentasRecoridas.set(0, listaLibroMayor.get(PosLibroMayor).getSubGrupo_Cuenta());
                    }else{
                        ListaCuentasRecoridas.add(listaLibroMayor.get(PosLibroMayor).getSubGrupo_Cuenta());
                    }

                    if("INGRESO".equals(listaLibroMayor.get(PosLibroMayor).getGrupo_Cuenta())){
                        if(TotalIngresos != 0){
                            TotalIngresos2 = TotalIngresos2+TotalIngresos;
                            TotalIngresos = 0;
                        }
                    }
                    if("COSTO".equals(listaLibroMayor.get(PosLibroMayor).getGrupo_Cuenta())){
                        if(TotalCostos != 0){
                            TotalCostos2 = TotalCostos2+TotalCostos;
                            TotalCostos = 0;
                        }
                    }
                    if("GASTO".equals(listaLibroMayor.get(PosLibroMayor).getGrupo_Cuenta())){
                        if(TotalGastos != 0){
                            TotalGastos2 = TotalGastos2+TotalGastos;
                            TotalGastos = 0;
                        }
                    }

                }
            } 

        }
        
        for(int PosComprobacion = 0; PosComprobacion < listaBalanceComprobacion.size(); PosComprobacion++){

            if(Integer.parseInt(ID_Libro) == listaBalanceComprobacion.get(PosComprobacion).getIDLibro()){

                VariableAuxiliar2 = false;
                break;
            }

        }

        if(VariableAuxiliar2){

            Insertar(Integer.parseInt(ID_Libro), 
                    TotalIngresos2, 
                    TotalCostos2, 
                    TotalGastos2);
        }else{

            Modificar(Integer.parseInt(ID_Libro), 
                    TotalIngresos2, 
                    TotalCostos2, 
                    TotalGastos2);
        }
        
    }
    
    public void PDFComprobacion(String ID_Libro){
        Document documento = new Document();
        
        CrLibroMayor.LlenarTabla();
        boolean ContAuxiliar;
        ListaCuentasRecoridas.clear();
      
        try {
            //ruta +"/Desktop/"
            String ruta = System.getProperty("user.home");
            PdfWriter.getInstance(documento, new FileOutputStream(ruta +"/OneDrive/Escritorio/"
                    +"BalanceComprobacion"+".pdf"));
            
            documento.open();

            PdfPTable tablaComprobacion = new PdfPTable(3);
            tablaComprobacion.addCell("Cuenta");
            tablaComprobacion.addCell("Deudor");
            tablaComprobacion.addCell("Acreedor");
        
        ListaCuentasRecoridas.add("");
        
        for(int PosicionCuenta = 0; PosicionCuenta < ListaTipoCuentas.length; PosicionCuenta++){

            tablaComprobacion.addCell(ListaTipoCuentas[PosicionCuenta]);
            tablaComprobacion.addCell("");
            tablaComprobacion.addCell("");
            
            for(int PosLibroMayor = 0; PosLibroMayor < listaLibroMayor.size(); PosLibroMayor++){

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
                                else if("INGRESO".equals(listaLibroMayor.get(Pos2LibroMayor).getGrupo_Cuenta())){

                                    TotalIngresos = TotalIngresos + listaLibroMayor.get(Pos2LibroMayor).getMontoTotal();
                                }
                                else if("COSTO".equals(listaLibroMayor.get(Pos2LibroMayor).getGrupo_Cuenta())){

                                    TotalCostos = TotalCostos+ listaLibroMayor.get(Pos2LibroMayor).getMontoTotal();
                                }
                                else if("GASTO".equals(listaLibroMayor.get(Pos2LibroMayor).getGrupo_Cuenta())){

                                    TotalGastos = TotalGastos + listaLibroMayor.get(Pos2LibroMayor).getMontoTotal();
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
                            //celda
                            tablaComprobacion.addCell(listaLibroMayor.get(PosLibroMayor).getSubGrupo_Cuenta());
                            tablaComprobacion.addCell(String.valueOf(TotalActivos));
                            tablaComprobacion.addCell("");
                            TotalActivos2 = TotalActivos2+TotalActivos;
                            TotalActivos = 0;
                        }
                    }
                    if("PASIVO".equals(listaLibroMayor.get(PosLibroMayor).getGrupo_Cuenta())){
                        if(TotalPasivos != 0){
                            tablaComprobacion.addCell(listaLibroMayor.get(PosLibroMayor).getSubGrupo_Cuenta());
                            tablaComprobacion.addCell("");
                            tablaComprobacion.addCell(String.valueOf(TotalPasivos));
                            TotalPasivos2 = TotalPasivos2+TotalPasivos;
                            TotalPasivos = 0;
                        }
                    }
                    if("CAPITAL".equals(listaLibroMayor.get(PosLibroMayor).getGrupo_Cuenta())){
                        if(TotalCapital != 0){
                            tablaComprobacion.addCell(listaLibroMayor.get(PosLibroMayor).getSubGrupo_Cuenta());
                            tablaComprobacion.addCell("");
                            tablaComprobacion.addCell(String.valueOf(TotalCapital));
                            TotalCapital2 = TotalCapital2+TotalCapital;
                            TotalCapital = 0;
                        }
                    }
                    if("INGRESO".equals(listaLibroMayor.get(PosLibroMayor).getGrupo_Cuenta())){
                        if(TotalIngresos != 0){
                            tablaComprobacion.addCell(listaLibroMayor.get(PosLibroMayor).getSubGrupo_Cuenta());
                            tablaComprobacion.addCell("");
                            tablaComprobacion.addCell(String.valueOf(TotalIngresos));
                            TotalIngresos2 = TotalIngresos2+TotalIngresos;
                            TotalIngresos = 0;
                        }
                    }
                    if("COSTO".equals(listaLibroMayor.get(PosLibroMayor).getGrupo_Cuenta())){
                        if(TotalCostos != 0){
                            tablaComprobacion.addCell(listaLibroMayor.get(PosLibroMayor).getSubGrupo_Cuenta());
                            tablaComprobacion.addCell(String.valueOf(TotalCostos));
                            tablaComprobacion.addCell("");
                            TotalCostos2 = TotalCostos2+TotalCostos;
                            TotalCostos = 0;
                        }
                    }
                    if("GASTO".equals(listaLibroMayor.get(PosLibroMayor).getGrupo_Cuenta())){
                        if(TotalGastos != 0){
                            tablaComprobacion.addCell(listaLibroMayor.get(PosLibroMayor).getSubGrupo_Cuenta());
                            tablaComprobacion.addCell(String.valueOf(TotalGastos));
                            tablaComprobacion.addCell("");
                            TotalGastos2 = TotalGastos2+TotalGastos;
                            TotalGastos = 0;
                        }
                    }

                }
            }    
            tablaComprobacion.addCell("");
            tablaComprobacion.addCell("");
            tablaComprobacion.addCell("");
        }
        
        TotalDeudor = TotalActivos2 + TotalCostos2 + TotalGastos2;
        TotalAcreedor = TotalPasivos2 + TotalCapital2 + TotalIngresos2;
        
        documento.add(tablaComprobacion);

        Paragraph parrafo = new Paragraph();
            
        parrafo.setAlignment(Paragraph.ALIGN_CENTER);
        parrafo.add("\n \n");
        parrafo.add("Total Deudor: "+TotalDeudor+"   "+"Total Acreedor: "+TotalAcreedor+"\n");
        parrafo.setFont(FontFactory.getFont("Tahoma", 14, Font.BOLD, BaseColor.DARK_GRAY));

        documento.add(parrafo);
        
        documento.close();
        
        JOptionPane.showMessageDialog(null, "PDF CREADO");
          
        }catch (FileNotFoundException ex) {
            Logger.getLogger(JFCrear_Partida.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DocumentException ex) {
            Logger.getLogger(JFCrear_Partida.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
