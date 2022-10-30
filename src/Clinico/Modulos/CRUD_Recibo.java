/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clinico.Modulos;

import Clinico.Controladores.Conexion;
import Clinico.Controladores.Recibo;
import static Clinico.Vistas.JFCrear_InClinico.listaExamenClinicos;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author ulise
 */
public class CRUD_Recibo extends Conexion {
    
    //LISTA PARA ALMACENAR LOS DATOS OBTENIDOS DE LA BASE DE DATOS
    public static List<Recibo> listaTablaRecibo = new ArrayList<Recibo>();
    
    //LLENA LA TABLA CON LOS DATOS OBTENIDOS DE LA BASE DE DATOS
    public static void LlenarTabla(){
        //SE VACIA LA LISTA
        listaTablaRecibo.clear();
        //OBJETO PARA TENER INTERACCION CON LA CLASE Conexion
        Conexion conec = new Conexion();
        //CREA LA CONECION Y VERIFICA LA EXISTENCIA DE LA TABLA
        conec.CrearTablas();
        //VARIABLE PARA EL RESULTADO OBTENIDO
        ResultSet result = null;
        
        try{
            //SE INDICA LA ACCION CON LA BASE DE DATOS (SE OBTINIENE LOS DATOS ALMACENADOS)
            PreparedStatement st = conec.conexion.prepareStatement("select * from TBL_Recibo");
            //SE ALMACENA LOS RESULTADOS
            result = st.executeQuery();
            
            //SE RECORRE TODO LO ALMACENADO
            while(result.next()){

                //OBJETO DEL CONSTRUCTOR
                Recibo recibo = new Recibo(result.getInt("ID")
                                            ,result.getString("Nombre_Cliente")
                                            ,result.getInt("Edad_Cliente")
                                            ,result.getDouble("PrecioTotal_Examen")
                                            ,result.getString("Fecha"));
                //SE AGREGA EL CONSTRUCTOR AL ARREGLO
                listaTablaRecibo.add(recibo);
                
            }
            
            System.out.println("Se lleno el arreglo con los datos");
            
        }catch(Exception e){
            System.out.println(e + " Error al llenar el arreglo");
        }
    }
    
    //LLENA LA TABLA CON LOS DATOS OBTENIDOS DE LA BASE DE DATOS
    public static void BuscarEnTabla(String buscar){
        //SE VACIA LA LISTA
        listaTablaRecibo.clear();
        //OBJETO PARA TENER INTERACCION CON LA CLASE Conexion
        Conexion conec = new Conexion();
        //CREA LA CONECION Y VERIFICA LA EXISTENCIA DE LA TABLA
        conec.CrearTablas();
        //VARIABLE PARA EL RESULTADO OBTENIDO
        ResultSet result = null;
        
        try{
            //SE INDICA LA ACCION CON LA BASE DE DATOS (SE OBTINIENE LOS DATOS ALMACENADOS)
            PreparedStatement st = conec.conexion.prepareStatement("select * from TBL_Recibo "
                                   + "where Nombre_Cliente LIKE '"+buscar+"'"
                                   + "OR Fecha LIKE '"+buscar+"'");
            //SE ALMACENA LOS RESULTADOS
            result = st.executeQuery();
            
            //SE RECORRE TODO LO ALMACENADO
            while(result.next()){
                //OBJETO DEL CONSTRUCTOR
                Recibo recibo = new Recibo(result.getInt("ID")
                                            ,result.getString("Nombre_Cliente")
                                            ,result.getInt("Edad_Cliente")
                                            ,result.getDouble("PrecioTotal_Examen")
                                            ,result.getString("Fecha"));
                //SE AGREGA EL CONSTRUCTOR AL ARREGLO
                listaTablaRecibo.add(recibo);

            }
            
            System.out.println("Se lleno el arreglo con los datos");
            
        }catch(Exception e){
            System.out.println(e + " Error al llenar el arreglo");
        }
    }
    
    //INSERTA DATOS A LA TABLA DE LA BASE DE DATOS
    public static void Insertar(String Nombre_Cliente, int Edad_Cliente, Double PrecioTotal_Examen, String Fecha){
        //OBJETO PARA ENTERACTUAR CON EL CRUD
        CRUD_ExamenClinico Cr_ExamenClinico = new CRUD_ExamenClinico();
        int ID;
        
        ID = (int)(Math.random()*9000+1);
        
        //OBJETO PARA TENER INTERACCION CON LA CLASE Conexion
        Conexion conec = new Conexion();
        
        try{
            
            //SE INDICA LA ACCION CON LA BASE DE DATOS (SE ALMACENA LOS DATOS)
            PreparedStatement st = conec.conexion.prepareStatement(
                    "insert into TBL_Recibo(ID, Nombre_Cliente, Edad_Cliente, PrecioTotal_Examen, Fecha)\n"
                    + "values("+ID+",'"+Nombre_Cliente+"'," +Edad_Cliente+ "," +PrecioTotal_Examen+ ",'"+Fecha+"');");
            //EJECUTA LA ACCION
            st.execute();

            //CICLO PARA ALMACENAR LOS VALORES
            for(int PosC = 0; PosC < listaExamenClinicos.size(); PosC++){   
                
                Cr_ExamenClinico.Insertar(ID, listaExamenClinicos.get(PosC).getNombreExamen()
                        , listaExamenClinicos.get(PosC).getPrecioExamen(), PosC);

            }

        }catch(Exception e){
            System.out.println(e + " ERROR AL INSERTAR LOS DATOS");
        }
    }
    
    //ELIMINA LOS DATOS DEL REGISTRO SELECCIONADO
    public static void Eliminar(int ID){
        //OBJETO PARA ENTERACTUAR CON EL CRUD
        CRUD_ExamenClinico Cr_ExamenClinico = new CRUD_ExamenClinico();
        //OBJETO PARA TENER INTERACCION CON LA CLASE Conexion
        Conexion conec = new Conexion();
        
        try{
            //SE INDICA LA ACCION CON LA BASE DE DATOS (SE ELIMINA LOS DATOS SEGUN EL ID)
            PreparedStatement st = conec.conexion.prepareStatement("delete from TBL_Recibo where ID="+ID);
            //EJECUTA LA ACCION
            st.execute();
            
            Cr_ExamenClinico.Eliminar(ID);
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "ERROR AL ELIMINAR LOS DATOS " + e);
        }
    }
    
}
