/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Contable.Modulos;

import Contable.Controladores.Conexion;
import Contable.Controladores.LibroMayor;
import static Contable.Modulos.CRUD_Cuenta.listaCuenta;
import static Contable.Modulos.CRUD_Partidas.listaPartidas;
import Contable.Vistas.JFCrear_Partida;
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
 * @author emma
 */
public class CRUD_LibroMayor {
    
      //LISTA PARA ALMACENAR LOS DATOS OBTENIDOS DE LA BASE DE DATOS
    public static List<LibroMayor> listaLibroMayor = new ArrayList<LibroMayor>();
    ArrayList<String> ListaCuentasRecoridas = new ArrayList<String>();
    
    CRUD_Partidas CrPartidas = new CRUD_Partidas();
    CRUD_Cuenta CrCuenta = new CRUD_Cuenta();

    int PosicionLibroMayor;
    double TotalDebeMayor = 0;
    double TotalHaberMayor = 0;
    double TotalMayor = 0;
    
    //LLENA LA TABLA CON LOS DATOS OBTENIDOS DE LA BASE DE DATOS
    public static void LlenarTabla(){
        //SE VACIA LA LISTA
        listaLibroMayor.clear();
        //OBJETO PARA TENER INTERACCION CON LA CLASE Conexion
        Conexion conec = new Conexion();
        //CREA LA CONECION Y VERIFICA LA EXISTENCIA DE LA TABLA
        conec.CrearTablas();
        //VARIABLE PARA EL RESULTADO OBTENIDO
        ResultSet result = null;
        
        try{
            //SE INDICA LA ACCION CON LA BASE DE DATOS (SE OBTINIENE LOS DATOS ALMACENADOS)
            PreparedStatement st = conec.conexion.prepareStatement("select * from TBL_LibroMayor");
            //SE ALMACENA LOS RESULTADOS
            result = st.executeQuery();
            
            //SE RECORRE TODO LO ALMACENADO
            while(result.next()){
                //OBJETO DEL CONSTRUCTOR
                LibroMayor InLibroMayor = new LibroMayor(result.getInt("ID"),
                                                result.getInt("IDLibro"),
                                                result.getString("Grupo_Cuenta"),
                                                result.getString("SubGrupo_Cuenta"),
                                                result.getString("Nombre_Cuenta"),
                                                result.getDouble("MontoTotal"));
                
                //SE AGREGA EL CONSTRUCTOR AL ARREGLO
                listaLibroMayor.add(InLibroMayor);

            }
            
        }catch(Exception e){
            System.out.println(e + " Error al llenar la tabla");
        }
    }
    
    //INSERTA DATOS A LA TABLA DE LA BASE DE DATOS
    public static void Insertar(int IDLibro, String Grupo_Cuenta, String SubGrupo_Cuenta, 
                                String Nombre_Cuenta, Double MontoTotal){
        int ID;
        
        ID = (int)(Math.random()*9000+1);

        //OBJETO PARA TENER INTERACCION CON LA CLASE Conexion
        Conexion conec = new Conexion();

        try{

            //SE INDICA LA ACCION CON LA BASE DE DATOS (SE ALMACENA LOS DATOS)
            PreparedStatement st = conec.conexion.prepareStatement(
                    "insert into TBL_LibroMayor(ID, IDLibro, Grupo_Cuenta, SubGrupo_Cuenta, "
                            + "Nombre_Cuenta, MontoTotal)\n"
                            
                    + "values("+ID+","+IDLibro+",'"+Grupo_Cuenta+"','"+SubGrupo_Cuenta+"',"
                            + "'"+Nombre_Cuenta+"',"+MontoTotal+");");
            
            //EJECUTA LA ACCION
            st.execute();
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "ERROR AL INSERTAR LOS DATOS " + e);
        }
        
    }
    
    //MODIFICA DATOS A LA TABLA DE LA BASE DE DATOS
    public static void Modificar(int ID, int IDLibro, String Grupo_Cuenta, String SubGrupo_Cuenta, 
                                String Nombre_Cuenta, Double MontoTotal){
        
        //OBJETO PARA TENER INTERACCION CON LA CLASE Conexion
        Conexion conec = new Conexion();
        
        try{
            
            String sql = "Update TBL_LibroMayor set IDLibro="+IDLibro+","
                            + "Grupo_Cuenta='"+Grupo_Cuenta+"',"
                            + "SubGrupo_Cuenta='"+SubGrupo_Cuenta+"',"
                            + "Nombre_Cuenta='"+Nombre_Cuenta+"',"
                            + "MontoTotal="+MontoTotal+" "
                            + "where ID="+ID+" "
                            + "AND IDLibro="+IDLibro;
            
            //SE INDICA LA ACCION CON LA BASE DE DATOS (SE ALMACENA LOS DATOS)
            PreparedStatement st = conec.conexion.prepareStatement(sql);
            //EJECUTA LA ACCION
            st.execute();
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "ERROR AL INSERTAR LOS DATOS " + e);
        }
    }
    
    
    public void LibroMayor(String ID_LibroDato){
        CRUD_BalanceComprobacion balanceComprobacion = new CRUD_BalanceComprobacion();
        CrPartidas.LlenarTabla();
        CrCuenta.LlenarTabla();
        LlenarTabla();
        
        boolean VariableAuxiliar;
        boolean VariableAuxiliar2;
      
        ListaCuentasRecoridas.add("");
        
        //CICLO PARA LLENAR LA TABLA CON LOS VALORES DEL ARREGLO
        for(int PosP = 0; PosP < listaPartidas.size(); PosP++){

            //VERIFICA SI PERTENECE AL LIBRO
            if(listaPartidas.get(PosP).getIDLibro() == Integer.valueOf(ID_LibroDato)){
                
                for(int PosC = 0; PosC < listaCuenta.size(); PosC++){
                    
                    VariableAuxiliar2 = true;
                    VariableAuxiliar = true;
                    
                    
                    //VERIFICA SI LA CUENTA PERTENECE A LA PARTIDA
                    if(listaCuenta.get(PosC).getIDPartida() == listaPartidas.get(PosP).getID()){

                        for(int PosC2 = 0; PosC2 < listaCuenta.size(); PosC2++){
                            //VERIFICA SI LAS CUENTAS SON DEL MISMO GRUPO
                            if(listaCuenta.get(PosC).getNombreCuenta().
                                    equals(listaCuenta.get(PosC2).getNombreCuenta())){
                                
                                for(int PosLC = 0; PosLC < ListaCuentasRecoridas.size(); PosLC++){
                                    //VERIFICA SI LAS CUENTA YA FUE RECORRIDA
                                    if(ListaCuentasRecoridas.get(PosLC).equals(listaCuenta.get(PosC).getNombreCuenta())){
                                        VariableAuxiliar = false;
                                        break;
                                    }

                                }

                                if(VariableAuxiliar){
                                    //VERIFICA EL TIPO DE MOVIMIENTO
                                    if("DEBE".equals(listaCuenta.get(PosC2).getTipoMovimiento())){

                                        TotalDebeMayor = TotalDebeMayor+listaCuenta.get(PosC2).getMonto();
                                    }
                                    else if("HABER".equals(listaCuenta.get(PosC2).getTipoMovimiento())){

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

                            for(int PosLibroMayor = 0; PosLibroMayor < listaLibroMayor.size(); PosLibroMayor++){
                                
                                if(listaCuenta.get(PosC).getNombreCuenta()
                                        .equals(listaLibroMayor.get(PosLibroMayor).getNombre_Cuenta())){
                                    
                                    PosicionLibroMayor = PosLibroMayor;
                                    
                                    VariableAuxiliar2 = false;
                                    break;
                                }
                                
                            }
                            
                            TotalMayor = TotalDebeMayor-TotalHaberMayor;
                            
                            if(VariableAuxiliar2){
                   
                                Insertar(Integer.parseInt(ID_LibroDato), 
                                        listaCuenta.get(PosC).getGrupoCuenta(), 
                                        listaCuenta.get(PosC).getSubGrupoCuenta(), 
                                        listaCuenta.get(PosC).getNombreCuenta(), 
                                        TotalMayor);
                            }else{

                                System.err.println("Dinero "+TotalMayor);
                                System.err.println("ID "+listaLibroMayor.get(PosicionLibroMayor).getID());
                                System.err.println("Cuenta "+listaLibroMayor.get(PosicionLibroMayor).getNombre_Cuenta());

                                Modificar(listaLibroMayor.get(PosicionLibroMayor).getID(),
                                        Integer.parseInt(ID_LibroDato), 
                                        listaCuenta.get(PosC).getGrupoCuenta(), 
                                        listaCuenta.get(PosC).getSubGrupoCuenta(), 
                                        listaCuenta.get(PosC).getNombreCuenta(), 
                                        TotalMayor);
                            }
                            
                            PosicionLibroMayor = 0;
                            
                            TotalMayor = 0;
                            TotalDebeMayor = 0;
                            TotalHaberMayor = 0;

                        }
     
                    }

                }
                
            }

        }
        
        balanceComprobacion.BalanceComprobacion(ID_LibroDato);

    }
    
    public void PDFLibroMayor(String ID_LibroDato){
        
        boolean ContAuxiliar;
        boolean Auxiliar;
        
        Document documento = new Document();
        ListaCuentasRecoridas.clear();

        try {
            //ruta +"/Desktop/"
            String ruta = System.getProperty("user.home");
            PdfWriter.getInstance(documento, new FileOutputStream(ruta +"/OneDrive/Escritorio/"
                    +"LibroMayor"+".pdf"));
            
            documento.open();

            PdfPTable tablaCliente = new PdfPTable(4);
            tablaCliente.addCell("Cuenta");
            tablaCliente.addCell("Debe");
            tablaCliente.addCell("Haber");
            tablaCliente.addCell("Total");
             
            CrPartidas.LlenarTabla();
            CrCuenta.LlenarTabla();

            ListaCuentasRecoridas.add("");
                
            //CICLO PARA LLENAR LA TABLA CON LOS VALORES DEL ARREGLO
            for(int PosP = 0; PosP < listaPartidas.size(); PosP++){

                //VERIFICA SI PERTENECE AL LIBRO
                if(listaPartidas.get(PosP).getIDLibro() == Integer.valueOf(ID_LibroDato)){

                    for(int PosC = 0; PosC < listaCuenta.size(); PosC++){
                        
                        Auxiliar = true;
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

                                            tablaCliente.addCell(listaCuenta.get(PosC).getNombreCuenta());
                                            tablaCliente.addCell( String.valueOf(listaCuenta.get(PosC2).getMonto()));
                                            tablaCliente.addCell( "");
                                            tablaCliente.addCell( "");

                                            TotalDebeMayor = TotalDebeMayor+listaCuenta.get(PosC2).getMonto();
                                    
                                        }
                                    
                                        else if("HABER".equals(listaCuenta.get(PosC2).getTipoMovimiento())){

                                            tablaCliente.addCell(listaCuenta.get(PosC).getNombreCuenta());
                                            tablaCliente.addCell( "");
                                            tablaCliente.addCell( String.valueOf(listaCuenta.get(PosC2).getMonto()));
                                            tablaCliente.addCell( "");

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

                                tablaCliente.addCell("Total");
                                tablaCliente.addCell( String.valueOf(TotalDebeMayor));
                                tablaCliente.addCell( String.valueOf(TotalHaberMayor));
                                tablaCliente.addCell( String.valueOf(TotalMayor));
                                
                                tablaCliente.addCell(" ");
                                tablaCliente.addCell(" ");
                                tablaCliente.addCell(" ");
                                tablaCliente.addCell(" ");
                                
                                TotalDebeMayor = 0;
                                TotalHaberMayor = 0;

                            }

                        }

                    }

                }

            }
            
            documento.add(tablaCliente);
            
            documento.close();
            
            JOptionPane.showMessageDialog(null, "PDF CREADO");
          
        }catch (FileNotFoundException ex) {
            Logger.getLogger(JFCrear_Partida.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DocumentException ex) {
            Logger.getLogger(JFCrear_Partida.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
