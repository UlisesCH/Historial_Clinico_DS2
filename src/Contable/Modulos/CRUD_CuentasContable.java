/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Contable.Modulos;

import Contable.Controladores.Conexion;
import Contable.Controladores.CuentasContable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author ulise
 */
public class CRUD_CuentasContable {
    
    //LISTA PARA ALMACENAR LOS DATOS OBTENIDOS DE LA BASE DE DATOS
    public static List<CuentasContable> listaCuentasContable = new ArrayList<CuentasContable>();
    public static String ListaTipoCuentas [] = {"Activo","Pasivos","Capital"};
    
    //LLENA LA TABLA CON LOS DATOS OBTENIDOS DE LA BASE DE DATOS
    public static void LlenarTabla(){
        //SE VACIA LA LISTA
        listaCuentasContable.clear();
        //OBJETO PARA TENER INTERACCION CON LA CLASE Conexion
        Conexion conec = new Conexion();
        //CREA LA CONECION Y VERIFICA LA EXISTENCIA DE LA TABLA
        conec.CrearTablas();
        //VARIABLE PARA EL RESULTADO OBTENIDO
        ResultSet result = null;
        
        try{
            //SE INDICA LA ACCION CON LA BASE DE DATOS (SE OBTINIENE LOS DATOS ALMACENADOS)
            PreparedStatement st = conec.conexion.prepareStatement("select * from TBL_CuentasContable");
            //SE ALMACENA LOS RESULTADOS
            result = st.executeQuery();
            
            //SE RECORRE TODO LO ALMACENADO
            while(result.next()){
                //OBJETO DEL CONSTRUCTOR
                CuentasContable InCuentas = new CuentasContable(result.getInt("ID"),
                                                  result.getString("Grupo_Cuenta"),
                                                  result.getString("Tipo_Cuenta"),
                                                  result.getString("SubGrupo_Cuenta"),
                                                    result.getString("Nombre_Cuenta"));
                //SE AGREGA EL CONSTRUCTOR AL ARREGLO
                listaCuentasContable.add(InCuentas);

            }
            
        }catch(Exception e){
            System.out.println(e + " Error al llenar la tabla");
        }
    }
    
    //INSERTA DATOS A LA TABLA DE LA BASE DE DATOS
    public static void Insertar(String TipoCuenta, String GrupoCuenta, String SubGrupoCuenta, String NombreCuenta){
        int ID;
        
        ID = (int)(Math.random()*9000+1);

        //OBJETO PARA TENER INTERACCION CON LA CLASE Conexion
        Conexion conec = new Conexion();

        try{

            //SE INDICA LA ACCION CON LA BASE DE DATOS (SE ALMACENA LOS DATOS)
            PreparedStatement st = conec.conexion.prepareStatement(
                    "insert into TBL_CuentasContable(ID, Grupo_Cuenta, Tipo_Cuenta, SubGrupo_Cuenta, Nombre_Cuenta)\n"
                    + "values("+ID+",'"+GrupoCuenta+"','"+TipoCuenta+"','"+SubGrupoCuenta+"','"+NombreCuenta+"');");
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
            PreparedStatement st = conec.conexion.prepareStatement("delete from TBL_CuentasContable where ID="+id);
            //EJECUTA LA ACCION
            st.execute();
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "ERROR AL ELIMINAR LOS DATOS " + e);
        }
    }
    
}
