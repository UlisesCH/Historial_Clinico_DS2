/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Contable.Modulos;

import static Clinico.Controladores.Conexion.URL;
import static Contable.Modulos.CRUD_Cuenta.listaCuenta;
import static Contable.Modulos.CRUD_EstadoResultado.listaEstadoResultado;
import static Contable.Modulos.CRUD_LibroMayor.listaLibroMayor;
import static Contable.Modulos.CRUD_Partidas.listaPartidas;
import Contable.Vistas.JFCrear_Partida;
import Contable.Vistas.JFMostrar_BalanceGeneral;
import static Contable.Vistas.JFMostrar_BalanceGeneral.ListaTipoCuentas;
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
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author ulise
 */
public class PDF_LibroDiario_BalanceGeneral {
    ArrayList<String> ListaCuentasRecoridas = new ArrayList<String>();
    
    CRUD_LibroMayor CrLibroMayor = new CRUD_LibroMayor();
    CRUD_EstadoResultado estadoResultado = new CRUD_EstadoResultado();
    CRUD_Partidas CRPartidas = new CRUD_Partidas();
    CRUD_Cuenta CRCuenta = new CRUD_Cuenta();
    
    public static String ListaTipoCuentas [] = {"ACTIVO","PASIVO","Impuesto", 
                                                "CAPITAL", "Reserva", "Utilidad"};
    
    double Impuesto = 0, Reserva = 0, Utilidad = 0,
           TotalActivos = 0, TotalPasivos = 0, TotalCapital = 0,
           TotalDeudor = 0, TotalAcreedor = 0;
    
    double TotalActivos2 = 0, TotalPasivos2 = 0, TotalCapital2 = 0;
    
    
    public void PDFLibroDiario(String ID_Libro){
        Document documento = new Document();
        
        int contador = 1;
        double TotalDebe = 0;
        double TotalHaber = 0;

        //SE LLENA EL ARREGLO CON LOS VALORES DE LA TABLA
        CRPartidas.LlenarTabla();
        CRCuenta.LlenarTabla();
        
        try {
            //ruta +"/Desktop/"
            String ruta = System.getProperty("user.home");
            PdfWriter.getInstance(documento, new FileOutputStream(ruta +URL
                    +"LibroDiario"+".pdf"));
            
            documento.open();
            
            Paragraph parrafo = new Paragraph();

            parrafo.setAlignment(Paragraph.ALIGN_CENTER);
            parrafo.add("\n \n");
            parrafo.add(" LIBRO DIARIO \n");
            parrafo.add("\n \n");
            parrafo.setFont(FontFactory.getFont("Tahoma", 14, Font.BOLD, BaseColor.DARK_GRAY));

            documento.add(parrafo);
            parrafo.clear();

            PdfPTable tablaDiario = new PdfPTable(4);
            tablaDiario.addCell("Fecha");
            tablaDiario.addCell("Cuenta");
            tablaDiario.addCell("Deudor");
            tablaDiario.addCell("Acreedor");
        
            //CICLO PARA LLENAR LA TABLA CON LOS VALORES DEL ARREGLO
            for(int PosPartida = 0; PosPartida < listaPartidas.size(); PosPartida++){

                if(listaPartidas.get(PosPartida).getIDLibro() == Integer.parseInt(ID_Libro)){

                    tablaDiario.addCell(listaPartidas.get(PosPartida).getFecha());
                    tablaDiario.addCell("Partida "+contador);
                    tablaDiario.addCell(" ");
                    tablaDiario.addCell(" ");

                    for(int PosCuenta = 0; PosCuenta < listaCuenta.size(); PosCuenta++){

                        if(listaCuenta.get(PosCuenta).getIDPartida() == listaPartidas.get(PosPartida).getID()){

                            if("DEBE".equals(listaCuenta.get(PosCuenta).getTipoMovimiento())){
                                tablaDiario.addCell(" ");
                                tablaDiario.addCell(listaCuenta.get(PosCuenta).getNombreCuenta());
                                tablaDiario.addCell(" ");
                                tablaDiario.addCell(""+listaCuenta.get(PosCuenta).getMonto());

                                TotalDebe = TotalDebe+listaCuenta.get(PosCuenta).getMonto();

                            }
                            else if("HABER".equals(listaCuenta.get(PosCuenta).getTipoMovimiento())){
                                
                                tablaDiario.addCell(" ");
                                tablaDiario.addCell(listaCuenta.get(PosCuenta).getNombreCuenta());
                                tablaDiario.addCell(""+listaCuenta.get(PosCuenta).getMonto());
                                tablaDiario.addCell(" ");
                                
                                TotalHaber = TotalHaber+listaCuenta.get(PosCuenta).getMonto();
                            }

                        }

                    }

                    tablaDiario.addCell(listaPartidas.get(PosPartida).getFecha());
                    tablaDiario.addCell(listaPartidas.get(PosPartida).getConcepto());
                    tablaDiario.addCell(" ");
                    tablaDiario.addCell(" ");

                    tablaDiario.addCell(" ");
                    tablaDiario.addCell(" ");
                    tablaDiario.addCell(" ");
                    tablaDiario.addCell(" ");

                    contador++;
                }

            }

            documento.add(tablaDiario);

            parrafo.setAlignment(Paragraph.ALIGN_CENTER);
            parrafo.add("\n \n");
            parrafo.add("Total Debe: "+TotalDebe+"   "+"Total Haber: "+TotalHaber+"\n");
            parrafo.setFont(FontFactory.getFont("Tahoma", 14, Font.BOLD, BaseColor.DARK_GRAY));

            documento.add(parrafo);

            documento.close();

            JOptionPane.showMessageDialog(null, "PDF Libro Diario CREADO");
          
        }catch (FileNotFoundException ex) {
            Logger.getLogger(JFMostrar_BalanceGeneral.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DocumentException ex) {
            Logger.getLogger(JFMostrar_BalanceGeneral.class.getName()).log(Level.SEVERE, null, ex);
        }    
        
    }
    
    public void PDFBalanceGeneral(String ID_Libro){
        Document documento = new Document();
        
        estadoResultado.LlenarTabla();
        CrLibroMayor.LlenarTabla();
        boolean ContAuxiliar;
        ListaCuentasRecoridas.clear();
      
        try {
            //ruta +"/Desktop/"
            String ruta = System.getProperty("user.home");
            PdfWriter.getInstance(documento, new FileOutputStream(ruta +URL
                    +"BalanceGeneral"+".pdf"));
            
            documento.open();

            Paragraph parrafo = new Paragraph();

            parrafo.setAlignment(Paragraph.ALIGN_CENTER);
            parrafo.add("\n \n");
            parrafo.add(" BALANCE GENERAL \n");
            parrafo.add("\n \n");
            parrafo.setFont(FontFactory.getFont("Tahoma", 14, Font.BOLD, BaseColor.DARK_GRAY));

            documento.add(parrafo);
            parrafo.clear();
            
            PdfPTable tablaComprobacion = new PdfPTable(3);
            tablaComprobacion.addCell("Cuenta");
            tablaComprobacion.addCell("Deudor");
            tablaComprobacion.addCell("Acreedor");
        
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

                    tablaComprobacion.addCell(ListaTipoCuentas[PosicionCuenta]);
                    tablaComprobacion.addCell(" ");
                    tablaComprobacion.addCell(" ");
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
                                    tablaComprobacion.addCell(listaLibroMayor.get(PosLibroMayor).getSubGrupo_Cuenta());
                                    tablaComprobacion.addCell(String.valueOf(TotalActivos));
                                    tablaComprobacion.addCell(" ");
                                    TotalActivos2 = TotalActivos2+TotalActivos;
                                    TotalActivos = 0;
                                }
                            }
                            if("PASIVO".equals(listaLibroMayor.get(PosLibroMayor).getGrupo_Cuenta())){
                                if(TotalPasivos != 0){
                                    tablaComprobacion.addCell(listaLibroMayor.get(PosLibroMayor).getSubGrupo_Cuenta());
                                    tablaComprobacion.addCell(" ");
                                    tablaComprobacion.addCell(String.valueOf(TotalPasivos));
                                    TotalPasivos2 = TotalPasivos2+TotalPasivos;
                                    TotalPasivos = 0;
                                }
                            }
                            if("CAPITAL".equals(listaLibroMayor.get(PosLibroMayor).getGrupo_Cuenta())){
                                if(TotalCapital != 0){
                                    tablaComprobacion.addCell(listaLibroMayor.get(PosLibroMayor).getSubGrupo_Cuenta());
                                    tablaComprobacion.addCell(" ");
                                    tablaComprobacion.addCell(String.valueOf(TotalCapital));
                                    TotalCapital2 = TotalCapital2+TotalCapital;
                                    TotalCapital = 0;
                                }
                            }
                        }
                    }
                }

                if("Impuesto".equals(ListaTipoCuentas[PosicionCuenta])){
                    tablaComprobacion.addCell("Impuesto Por Pagar");
                    tablaComprobacion.addCell(" ");
                    tablaComprobacion.addCell(String.valueOf(Impuesto));
                }
                if("Reserva".equals(ListaTipoCuentas[PosicionCuenta])){
                    tablaComprobacion.addCell("Reserva Legal");
                    tablaComprobacion.addCell(" ");
                    tablaComprobacion.addCell(String.valueOf(Reserva));
                }
                if("Utilidad".equals(ListaTipoCuentas[PosicionCuenta])){
                    tablaComprobacion.addCell("Utilidad Neta");
                    tablaComprobacion.addCell(" ");
                    tablaComprobacion.addCell(String.valueOf(Utilidad));
                }

                if("ACTIVO".equals(ListaTipoCuentas[PosicionCuenta]) || 
                   "Impuesto".equals(ListaTipoCuentas[PosicionCuenta])){

                    tablaComprobacion.addCell(" ");
                    tablaComprobacion.addCell(" ");
                    tablaComprobacion.addCell(" ");
                }
            }

            TotalDeudor = TotalActivos2;
            TotalAcreedor = TotalPasivos2 + Impuesto + TotalCapital2 + Reserva + Utilidad;

            documento.add(tablaComprobacion);

            parrafo.setAlignment(Paragraph.ALIGN_CENTER);
            parrafo.add("\n \n");
            parrafo.add("Total Deudor: "+TotalDeudor+"   "+"Total Acreedor: "+TotalAcreedor+"\n");
            parrafo.setFont(FontFactory.getFont("Tahoma", 14, Font.BOLD, BaseColor.DARK_GRAY));

            documento.add(parrafo);

            documento.close();

            JOptionPane.showMessageDialog(null, "PDF Balance General CREADO");
          
        }catch (FileNotFoundException ex) {
            Logger.getLogger(JFMostrar_BalanceGeneral.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DocumentException ex) {
            Logger.getLogger(JFMostrar_BalanceGeneral.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
