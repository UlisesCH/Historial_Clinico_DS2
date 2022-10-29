/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Contable.Modulos;

import Contable.Controladores.Conexion;
import Contable.Controladores.EstadoResultado;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author ulise
 */
public class CRUD_EstadoResultado {
    public static List<EstadoResultado> listaEstadoResultado = new ArrayList<EstadoResultado>();
    ArrayList<String> ListaCuentasRecoridas = new ArrayList<String>();
    
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
                                                result.getDouble("Impuesto"));
                
                //SE AGREGA EL CONSTRUCTOR AL ARREGLO
                listaEstadoResultado.add(InEstadoResultado);

            }
            
        }catch(Exception e){
            System.out.println(e + " Error al llenar la tabla");
        }
    }
    
    //INSERTA DATOS A LA TABLA DE LA BASE DE DATOS
    public static void Insertar(int IDLibro, Double Reserva, Double Impuesto){
        int ID;
        
        ID = (int)(Math.random()*9000+1);

        //OBJETO PARA TENER INTERACCION CON LA CLASE Conexion
        Conexion conec = new Conexion();

        try{

            //SE INDICA LA ACCION CON LA BASE DE DATOS (SE ALMACENA LOS DATOS)
            PreparedStatement st = conec.conexion.prepareStatement(
                    "insert into TBL_EstadoResultado(ID, IDLibro,Reserva, Impuesto, MontoTotal)\n"
                            
                    + "values("+ID+","+IDLibro+","+Reserva+","+Impuesto+");");
            
            //EJECUTA LA ACCION
            st.execute();
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "ERROR AL INSERTAR LOS DATOS " + e);
        }
        
    }
    
    //MODIFICA DATOS A LA TABLA DE LA BASE DE DATOS
    public static void Modificar(int IDLibro, Double Reserva, Double Impuesto){
        int ID;
        
        ID = (int)(Math.random()*9000+1);
        
        //OBJETO PARA TENER INTERACCION CON LA CLASE Conexion
        Conexion conec = new Conexion();
        
        try{
            
            String sql = "Update TBL_EstadoResultado set ID="+ID+","
                            + "IDLibro="+IDLibro+","
                            + "Reserva='"+Reserva+"',"
                            + "Impuesto="+Impuesto+" "
                            + "where IDLibro="+IDLibro;
            
            //SE INDICA LA ACCION CON LA BASE DE DATOS (SE ALMACENA LOS DATOS)
            PreparedStatement st = conec.conexion.prepareStatement(sql);
            //EJECUTA LA ACCION
            st.execute();
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "ERROR AL INSERTAR LOS DATOS " + e);
        }
    }
}
