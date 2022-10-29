/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Contable.Modulos;

import Contable.Controladores.Conexion;
import Contable.Controladores.LibroDiario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author ulise
 */
public class CRUD_LibroDiario {
    //LISTA PARA ALMACENAR LOS DATOS OBTENIDOS DE LA BASE DE DATOS
    public static List<LibroDiario> listaLibroDiario = new ArrayList<LibroDiario>();
    
    //LLENA LA TABLA CON LOS DATOS OBTENIDOS DE LA BASE DE DATOS
    public static void LlenarTabla(){
        //SE VACIA LA LISTA
        listaLibroDiario.clear();
        //OBJETO PARA TENER INTERACCION CON LA CLASE Conexion
        Conexion conec = new Conexion();
        //CREA LA CONECION Y VERIFICA LA EXISTENCIA DE LA TABLA
        conec.CrearTablas();
        //VARIABLE PARA EL RESULTADO OBTENIDO
        ResultSet result = null;
        
        try{
            //SE INDICA LA ACCION CON LA BASE DE DATOS (SE OBTINIENE LOS DATOS ALMACENADOS)
            PreparedStatement st = conec.conexion.prepareStatement("select * from TBL_Libros");
            //SE ALMACENA LOS RESULTADOS
            result = st.executeQuery();
            
            //SE RECORRE TODO LO ALMACENADO
            while(result.next()){
                //OBJETO DEL CONSTRUCTOR
                LibroDiario InLibroDiario = new LibroDiario(result.getInt("ID"),
                                                result.getString("Nombre"),
                                                result.getString("FechaInicio"),
                                                result.getString("FechaFinal"));
                //SE AGREGA EL CONSTRUCTOR AL ARREGLO
                listaLibroDiario.add(InLibroDiario);

            }
            
        }catch(Exception e){
            System.out.println(e + " Error al llenar la tabla");
        }
    }
    
    //INSERTA DATOS A LA TABLA DE LA BASE DE DATOS
    public static void Insertar(String Nombre, String FechaInicio, String FechaFinal){
        int ID;
        
        ID = (int)(Math.random()*9000+1);

        //OBJETO PARA TENER INTERACCION CON LA CLASE Conexion
        Conexion conec = new Conexion();

        try{

            //SE INDICA LA ACCION CON LA BASE DE DATOS (SE ALMACENA LOS DATOS)
            PreparedStatement st = conec.conexion.prepareStatement(
                    "insert into TBL_Libros(ID, Nombre, FechaInicio, FechaFinal)\n"
                    + "values("+ID+",'"+Nombre+"','"+FechaInicio+"','"+FechaFinal+"');");
            //EJECUTA LA ACCION
            st.execute();
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "ERROR AL INSERTAR LOS DATOS " + e);
        }
        
    }
    
    //ELIMINA LOS DATOS DEL REGISTRO SELECCIONADO
    public static void Eliminar(int id){
        
        //OBJETO PARA TENER INTERACCION CON LA CLASE Conexion
        Conexion conec = new Conexion();
        
        try{
            //SE INDICA LA ACCION CON LA BASE DE DATOS (SE ELIMINA LOS DATOS SEGUN EL ID)
            PreparedStatement st = conec.conexion.prepareStatement("delete from TBL_Libros where ID="+id);
            //EJECUTA LA ACCION
            st.execute();
            
            CRUD_Partidas.EliminarPorLibro(id);
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "ERROR AL ELIMINAR LOS DATOS " + e);
        }
    }
    
}
