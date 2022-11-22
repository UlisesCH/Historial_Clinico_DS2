/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Contable.Modulos;

import Contable.Controladores.Conexion;
import Contable.Controladores.Cuenta;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author ulise
 */
public class CRUD_Cuenta {
    
    public static boolean Tess = false;
    
    //LISTA PARA ALMACENAR LOS DATOS OBTENIDOS DE LA BASE DE DATOS
    public static List<Cuenta> listaCuenta = new ArrayList<Cuenta>();
    
    //LLENA LA TABLA CON LOS DATOS OBTENIDOS DE LA BASE DE DATOS
    public static void LlenarTabla(){
        //SE VACIA LA LISTA
        listaCuenta.clear();
        //OBJETO PARA TENER INTERACCION CON LA CLASE Conexion
        Conexion conec = new Conexion();
        //CREA LA CONECION Y VERIFICA LA EXISTENCIA DE LA TABLA
        conec.CrearTablas();
        //VARIABLE PARA EL RESULTADO OBTENIDO
        ResultSet result = null;
        
        try{
            //SE INDICA LA ACCION CON LA BASE DE DATOS (SE OBTINIENE LOS DATOS ALMACENADOS)
            PreparedStatement st = conec.conexion.prepareStatement("select * from TBL_Cuenta");
            //SE ALMACENA LOS RESULTADOS
            result = st.executeQuery();
            
            //SE RECORRE TODO LO ALMACENADO
            while(result.next()){
                //OBJETO DEL CONSTRUCTOR
                Cuenta InCuenta = new Cuenta(result.getInt("ID"),
                                                result.getInt("IDPartida"),
                                                result.getString("Grupo_Cuenta"),
                                                result.getString("Tipo_Cuenta"),
                                                result.getString("SubGrupo_Cuenta"),
                                                result.getString("Nombre_Cuenta"),
                                                result.getDouble("Monto"),
                                                result.getString("TipoMovimiento"));
                //SE AGREGA EL CONSTRUCTOR AL ARREGLO
                listaCuenta.add(InCuenta);

            }
            
            Tess = true;
            
        }catch(Exception e){
            
            Tess = false;
            
            System.out.println(e + " Error al llenar la tabla");
        }
    }
    
    //INSERTA DATOS A LA TABLA DE LA BASE DE DATOS
    public static void Insertar(int IDPartida, String GrupoCuenta, String TipoCuenta, 
                                String SubGrupoCuenta, String NombreCuenta, 
                                Double Monto, String TipoMovimiento){
        int ID;
        
        ID = (int)(Math.random()*9000+1);

        //OBJETO PARA TENER INTERACCION CON LA CLASE Conexion
        Conexion conec = new Conexion();

        try{

            //SE INDICA LA ACCION CON LA BASE DE DATOS (SE ALMACENA LOS DATOS)
            PreparedStatement st = conec.conexion.prepareStatement(
                    "insert into TBL_Cuenta(ID, IDPartida, Grupo_Cuenta, Tipo_Cuenta, SubGrupo_Cuenta,"
                                            + "Nombre_Cuenta, Monto, TipoMovimiento)\n"
                                  + "values("+ID+",'"+IDPartida+"','"+GrupoCuenta+"','"+TipoCuenta+"','"+SubGrupoCuenta+"',"
                                           + "'"+NombreCuenta+"',"+Monto+",'"+TipoMovimiento+"');");
            //EJECUTA LA ACCION
            st.execute();
            
            Tess = true;
            
        }catch(Exception e){
            
            Tess = false;
            JOptionPane.showMessageDialog(null, "ERROR AL INSERTAR LOS DATOS " + e);
        }
        
    }
    
    
    //ELIMINA LOS DATOS DEL REGISTRO SELECCIONADO
    public static void EliminarPorCuenta(int id){
        
        //OBJETO PARA TENER INTERACCION CON LA CLASE Conexion
        Conexion conec = new Conexion();
        
        try{
            //SE INDICA LA ACCION CON LA BASE DE DATOS (SE ELIMINA LOS DATOS SEGUN EL ID)
            PreparedStatement st = conec.conexion.prepareStatement("delete from TBL_Cuenta where ID="+id);
            //EJECUTA LA ACCION
            st.execute();
            
            Tess = true;
            
        }catch(Exception e){
            
            Tess = false;
            JOptionPane.showMessageDialog(null, "ERROR AL ELIMINAR LOS DATOS " + e);
        }
    }
    
    //ELIMINA LOS DATOS DEL REGISTRO SELECCIONADO
    public static void EliminarPorPartida(int id){
        
        //OBJETO PARA TENER INTERACCION CON LA CLASE Conexion
        Conexion conec = new Conexion();
        
        try{
            //SE INDICA LA ACCION CON LA BASE DE DATOS (SE ELIMINA LOS DATOS SEGUN EL ID)
            PreparedStatement st = conec.conexion.prepareStatement("delete from TBL_Cuenta where IDPartida="+id);
            //EJECUTA LA ACCION
            st.execute();
            
            Tess = true;
            
        }catch(Exception e){
            
            Tess = false;
            JOptionPane.showMessageDialog(null, "ERROR AL ELIMINAR LOS DATOS " + e);
        }
    }
}
