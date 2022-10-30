/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Contable.Modulos;

import Contable.Controladores.Conexion;
import Contable.Controladores.EstadoResultado;
import static Contable.Modulos.CRUD_BalanceComprobacion.listaBalanceComprobacion;
import Contable.Vistas.JFCrear_Partida;
import Contable.Vistas.JFMostrar_EstadoResultado;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
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
public class CRUD_EstadoResultado {
    CRUD_BalanceComprobacion balanceComprobacion = new CRUD_BalanceComprobacion();
    
    public static List<EstadoResultado> listaEstadoResultado = new ArrayList<EstadoResultado>();
    ArrayList<String> ListaCuentasRecoridas = new ArrayList<String>();
    
    double Ingreso = 0, Costo = 0, Gasto = 0,
            UtilidadBruta = 0, UtilidadAntesOperacion = 0, ReservaLegar = 0, 
            UtilidadAntesImpuesto = 0, ImpuestoPorPagar = 0, UtilidadNeta = 0;
    
    //LLENA LA TABLA CON LOS DATOS OBTENIDOS DE LA BASE DE DATOS
    public static void LlenarTabla(){
        //SE VACIA LA LISTA
        listaEstadoResultado.clear();
        //OBJETO PARA TENER INTERACCION CON LA CLASE Conexion
        Conexion conec = new Conexion();
        //CREA LA CONECION Y VERIFICA LA EXISTENCIA DE LA TABLA
        conec.CrearTablas();
        //VARIABLE PARA EL RESULTADO OBTENIDO
        ResultSet result = null;
        
        try{
            //SE INDICA LA ACCION CON LA BASE DE DATOS (SE OBTINIENE LOS DATOS ALMACENADOS)
            PreparedStatement st = conec.conexion.prepareStatement("select * from TBL_EstadoResultado");
            //SE ALMACENA LOS RESULTADOS
            result = st.executeQuery();
            
            //SE RECORRE TODO LO ALMACENADO
            while(result.next()){
                //OBJETO DEL CONSTRUCTOR
                EstadoResultado InEstadoResultado = new EstadoResultado(result.getInt("ID"),
                                                result.getInt("IDLibro"),
                                                result.getDouble("Reserva"),
                                                result.getDouble("Impuesto"),
                                                result.getDouble("Utilidad"));
                
                //SE AGREGA EL CONSTRUCTOR AL ARREGLO
                listaEstadoResultado.add(InEstadoResultado);

            }
            
        }catch(Exception e){
            System.out.println(e + " Error al llenar la tabla");
        }
    }
    
    //INSERTA DATOS A LA TABLA DE LA BASE DE DATOS
    public static void Insertar(int IDLibro, Double Reserva, Double Impuesto, Double Utilidad){
        int ID;
        
        ID = (int)(Math.random()*9000+1);

        //OBJETO PARA TENER INTERACCION CON LA CLASE Conexion
        Conexion conec = new Conexion();

        try{

            //SE INDICA LA ACCION CON LA BASE DE DATOS (SE ALMACENA LOS DATOS)
            PreparedStatement st = conec.conexion.prepareStatement(
                    "insert into TBL_EstadoResultado(ID, IDLibro, Reserva, Impuesto, Utilidad)\n"
                            
                    + "values("+ID+","+IDLibro+","+Reserva+","+Impuesto+","+Utilidad+");");
            
            //EJECUTA LA ACCION
            st.execute();
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "ERROR AL INSERTAR LOS DATOS " + e);
        }
        
    }
    
    //MODIFICA DATOS A LA TABLA DE LA BASE DE DATOS
    public static void Modificar(int IDLibro, Double Reserva, Double Impuesto, Double Utilidad){

        //OBJETO PARA TENER INTERACCION CON LA CLASE Conexion
        Conexion conec = new Conexion();
        
        try{
            
            String sql = "Update TBL_EstadoResultado set "
                            + "IDLibro="+IDLibro+","
                            + "Reserva="+Reserva+","
                            + "Impuesto="+Impuesto+","
                            + "Utilidad="+Utilidad+" "
                            + "where IDLibro="+IDLibro;
            
            //SE INDICA LA ACCION CON LA BASE DE DATOS (SE ALMACENA LOS DATOS)
            PreparedStatement st = conec.conexion.prepareStatement(sql);
            //EJECUTA LA ACCION
            st.execute();
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "ERROR AL INSERTAR LOS DATOS " + e);
        }
    }
    
    public void EstadoResultado(String ID_Libro){
        boolean VariableAuxiliar = true;
        balanceComprobacion.LlenarTabla();
        LlenarTabla();
        
        for(int PosComrpobacion = 0; PosComrpobacion < listaBalanceComprobacion.size(); PosComrpobacion++){
            
            if(Integer.parseInt(ID_Libro) == listaBalanceComprobacion.get(PosComrpobacion).getIDLibro()){
                
                Ingreso = listaBalanceComprobacion.get(PosComrpobacion).getIngresos();
                Costo = listaBalanceComprobacion.get(PosComrpobacion).getCostos();
                Gasto = listaBalanceComprobacion.get(PosComrpobacion).getGastos();
                
                if(Ingreso<0){
                    Ingreso = Ingreso*-1;
                }
                if(Costo<0){
                    Costo = Costo*-1;
                }
                if(Gasto<0){
                    Gasto = Gasto*-1;
                }

                UtilidadBruta = Ingreso-Costo;
                UtilidadAntesOperacion = UtilidadBruta-Gasto;
                ReservaLegar = UtilidadAntesOperacion*0.07;
                UtilidadAntesImpuesto = UtilidadAntesOperacion - ReservaLegar;

                if(UtilidadAntesImpuesto > 50000){
                    
                    ImpuestoPorPagar = UtilidadAntesImpuesto*0.30; 
                }else if(UtilidadAntesImpuesto <= 50000){
                    
                    ImpuestoPorPagar = UtilidadAntesImpuesto*0.25;
                }

                UtilidadNeta = UtilidadAntesImpuesto-ImpuestoPorPagar;
            }          
        }
        
        for(int PosComprobacion = 0; PosComprobacion < listaEstadoResultado.size(); PosComprobacion++){

            if(Integer.parseInt(ID_Libro) == listaEstadoResultado.get(PosComprobacion).getIDLibro()){

                VariableAuxiliar = false;
                break;
            }

        }

        if(VariableAuxiliar){

            Insertar(Integer.parseInt(ID_Libro), 
                    ReservaLegar, 
                    ImpuestoPorPagar, 
                    UtilidadNeta);
        }else{

            Modificar(Integer.parseInt(ID_Libro), 
                    ReservaLegar, 
                    ImpuestoPorPagar, 
                    UtilidadNeta);
        }
        
    }
    
    public void PDFEstadoResultado(String ID_Libro){
        Document documento = new Document();
        balanceComprobacion.LlenarTabla();
        
        try {
            //ruta +"/Desktop/"
            String ruta = System.getProperty("user.home");
            PdfWriter.getInstance(documento, new FileOutputStream(ruta +"/Desktop/"
                    +"EstadoResultado"+".pdf"));
            
            documento.open();

            PdfPTable tablaResultado = new PdfPTable(3);
            tablaResultado.addCell("Cuenta");
            tablaResultado.addCell("Deudor");
            tablaResultado.addCell("Acreedor");
        
            for(int PosComrpobacion = 0; PosComrpobacion < listaBalanceComprobacion.size(); PosComrpobacion++){

                if(Integer.parseInt(ID_Libro) == listaBalanceComprobacion.get(PosComrpobacion).getIDLibro()){

                    Ingreso = listaBalanceComprobacion.get(PosComrpobacion).getIngresos();
                    Costo = listaBalanceComprobacion.get(PosComrpobacion).getCostos();
                    Gasto = listaBalanceComprobacion.get(PosComrpobacion).getGastos();

                    if(Ingreso<0){
                        Ingreso = Ingreso*-1;
                    }
                    if(Costo<0){
                        Costo = Costo*-1;
                    }
                    if(Gasto<0){
                        Gasto = Gasto*-1;
                    }

                    tablaResultado.addCell("Ingresos");
                    tablaResultado.addCell(String.valueOf(Ingreso));
                    tablaResultado.addCell(" ");
                    
                    tablaResultado.addCell("Costos");
                    tablaResultado.addCell(String.valueOf(Costo));
                    tablaResultado.addCell(" ");

                    UtilidadBruta = Ingreso-Costo;

                    tablaResultado.addCell("Utilidad Antes de Operacion ");
                    tablaResultado.addCell(String.valueOf(UtilidadBruta));
                    tablaResultado.addCell(" ");

                    tablaResultado.addCell("Gastos de Operacion ");
                    tablaResultado.addCell(String.valueOf(Gasto));
                    tablaResultado.addCell(" ");

                    UtilidadAntesOperacion = UtilidadBruta-Gasto;

                    tablaResultado.addCell("Utilidad Antes de Operacion ");
                    tablaResultado.addCell(String.valueOf(UtilidadAntesOperacion));
                    tablaResultado.addCell("7 %");
                    
                    ReservaLegar = UtilidadAntesOperacion*0.07;

                    tablaResultado.addCell("Reserva Legar ");
                    tablaResultado.addCell(String.valueOf(ReservaLegar));
                    tablaResultado.addCell(" ");

                    UtilidadAntesImpuesto = UtilidadAntesOperacion - ReservaLegar;

                    tablaResultado.addCell("Utilidad Antes de Impiesto ");
                    tablaResultado.addCell(String.valueOf(UtilidadAntesImpuesto));
                    tablaResultado.addCell(" ");
                    
                    if(UtilidadAntesImpuesto > 50000){

                        ImpuestoPorPagar = UtilidadAntesImpuesto*0.30; 

                        tablaResultado.addCell("Impuesto Por Pagar ");
                        tablaResultado.addCell(String.valueOf(ImpuestoPorPagar));
                        tablaResultado.addCell("30%");

                    }else if(UtilidadAntesImpuesto <= 50000){

                        ImpuestoPorPagar = UtilidadAntesImpuesto*0.25;

                        tablaResultado.addCell("Impuesto Por Pagar ");
                        tablaResultado.addCell(String.valueOf(ImpuestoPorPagar));
                        tablaResultado.addCell(" ");
                    }

                    UtilidadNeta = UtilidadAntesImpuesto-ImpuestoPorPagar;

                    tablaResultado.addCell("Utilidad Neta");
                    tablaResultado.addCell(String.valueOf(UtilidadNeta));
                    tablaResultado.addCell(" ");

                }          
            }
        
        documento.add(tablaResultado);
            
        documento.close();
        
        JOptionPane.showMessageDialog(null, "PDF CREADO");
          
        }catch (FileNotFoundException ex) {
            Logger.getLogger(JFMostrar_EstadoResultado.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DocumentException ex) {
            Logger.getLogger(JFMostrar_EstadoResultado.class.getName()).log(Level.SEVERE, null, ex);
        }    
    }
}
