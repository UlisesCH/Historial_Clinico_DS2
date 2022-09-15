/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package InClinico;

import static JFInClinico.JFCrear_InClinico.listaExamenClinicos;
import static JFInClinico.JFCrear_InClinico.listaRecibo;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author ulise
 */
public class CRUD_DatosExamenes extends Conexion{
    
    //LISTA PARA ALMACENAR LOS DATOS OBTENIDOS DE LA BASE DE DATOS
    public static List<Datos> listaDatos = new ArrayList<Datos>();
    
    //LISTA PARA ALMACENAR LOS DATOS OBTENIDOS DE LA BASE DE DATOS
    public static List<DatosExamenes> listaDatosExamenes = new ArrayList<DatosExamenes>();
    
    //LLENA LA TABLA CON LOS DATOS OBTENIDOS DE LA BASE DE DATOS
    public static void LlenarTablaDatos(){
        //SE VACIA LA LISTA
        listaDatos.clear();
        //OBJETO PARA TENER INTERACCION CON LA CLASE Conexion
        Conexion conec = new Conexion();
        //CREA LA CONECION Y VERIFICA LA EXISTENCIA DE LA TABLA
        conec.CrearTablas();
        //VARIABLE PARA EL RESULTADO OBTENIDO
        ResultSet result = null;
        
        try{
            //SE INDICA LA ACCION CON LA BASE DE DATOS (SE OBTINIENE LOS DATOS ALMACENADOS)
            PreparedStatement st = conec.conexion.prepareStatement("select * from TBL_Datos");
                                                                    
            //SE ALMACENA LOS RESULTADOS
            result = st.executeQuery();
            
            //SE RECORRE TODO LO ALMACENADO
            while(result.next()){
                
                //OBJETO DEL CONSTRUCTOR
                Datos datos = new Datos(result.getInt("ID"),
                                            result.getInt("ID_Examen"),
                                                result.getString("Dato"));
                //SE AGREGA EL CONSTRUCTOR AL ARREGLO
                listaDatos.add(datos);

            }
            
            System.out.println("Se lleno el arreglo con los datos");
            
        }catch(Exception e){
            System.out.println(e + " Error al llenar el arreglo");
        }
    }
    
    //LLENA LA LISTA CON LOS DATOS OBTENIDOS DE LA BASE DE DATOS
    public static void LlenarListaDatosExamenes(){
        //SE VACIA LA LISTA
        listaDatosExamenes.clear();
        //OBJETO PARA TENER INTERACCION CON LA CLASE Conexion
        Conexion conec = new Conexion();
        //CREA LA CONECION Y VERIFICA LA EXISTENCIA DE LA TABLA
        conec.CrearTablas();
        //VARIABLE PARA EL RESULTADO OBTENIDO
        ResultSet result = null;
        
        try{
            //SE INDICA LA ACCION CON LA BASE DE DATOS (SE OBTINIENE LOS DATOS ALMACENADOS)
            PreparedStatement st = conec.conexion.prepareStatement("select * from TBL_DatosExamen");
            //SE ALMACENA LOS RESULTADOS
            result = st.executeQuery();
            
            //SE RECORRE TODO LO ALMACENADO
            while(result.next()){
                //OBJETO DEL CONSTRUCTOR
                DatosExamenes datosExamen = new DatosExamenes(result.getInt("ID"),
                                                result.getInt("ID_Examen"),
                                                result.getString("Dato"),
                                                result.getString("Valor"));
                //SE AGREGA EL CONSTRUCTOR AL ARREGLO
                listaDatosExamenes.add(datosExamen);

            }
            
            System.out.println("Se lleno el arreglo con los datos");
            
        }catch(Exception e){
            System.out.println(e + " Error al llenar el arreglo");
        }
    }
    
    //INSERTA DATOS A LA TABLA DE LA BASE DE DATOS
    public static void InsertarDatos(int ID_Examen, String Dato){
        int ID;
        
        ID = (int)(Math.random()*9000+1);
        
        //OBJETO PARA TENER INTERACCION CON LA CLASE Conexion
        Conexion conec = new Conexion();

        try{
            
            //SE INDICA LA ACCION CON LA BASE DE DATOS (SE ALMACENA LOS DATOS)
            PreparedStatement st = conec.conexion.prepareStatement(
                    "insert into TBL_Datos(ID, ID_Examen, Dato)\n"
                    + "values("+ID+",'"+ID_Examen+"','"+Dato+"');");
            //EJECUTA LA ACCION
            st.execute();
            System.out.println(" se inserto");

        }catch(Exception e){
            System.out.println(e + " ERROR AL INSERTAR LOS DATOS");
        }
    }
    
    //INSERTA DATOS A LA TABLA DE LA BASE DE DATOS
    public static void InsertarValorDatos(int ID_ExamenClinico, String Dato, String Valor){
        int ID;
        
        ID = (int)(Math.random()*9000+1);
        
        //OBJETO PARA TENER INTERACCION CON LA CLASE Conexion
        Conexion conec = new Conexion();

        try{
            
            System.out.println(ID_ExamenClinico +" "+ Dato);
            
            //SE INDICA LA ACCION CON LA BASE DE DATOS (SE ALMACENA LOS DATOS)
            PreparedStatement st = conec.conexion.prepareStatement(
                    "insert into TBL_DatosExamen(ID, ID_ExamenClinico, Dato, Valor)\n"
                    + "values("+ID+",'"+ID_ExamenClinico+"','"+Dato+"','"+Valor+"');");
            //EJECUTA LA ACCION
            st.execute();
            
        }catch(Exception e){
            System.out.println(e + " ERROR AL INSERTAR LOS DATOS");
        }
    }
    
    //ELIMINA LOS DATOS DEL REGISTRO SELECCIONADO
    public static void Eliminar(int ID){
        
        //OBJETO PARA TENER INTERACCION CON LA CLASE Conexion
        Conexion conec = new Conexion();
        
        try{
            //SE INDICA LA ACCION CON LA BASE DE DATOS (SE ELIMINA LOS DATOS SEGUN EL ID)
            PreparedStatement st = conec.conexion.prepareStatement("delete from TBL_Datos where ID="+ID);
            //EJECUTA LA ACCION
            st.execute();
            
            JOptionPane.showMessageDialog(null, "DATOS ELIMINADOS");
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "ERROR AL ELIMINAR LOS DATOS " + e);
        }
    }
    
    //ELIMINA LOS DATOS DEL REGISTRO SELECCIONADO
    public static void EliminarValorDatos(int ID_ExamenClinico){
        
        //OBJETO PARA TENER INTERACCION CON LA CLASE Conexion
        Conexion conec = new Conexion();
        
        try{
            //SE INDICA LA ACCION CON LA BASE DE DATOS (SE ELIMINA LOS DATOS SEGUN EL ID)
            PreparedStatement st = conec.conexion.prepareStatement("delete from TBL_DatosExamen where ID_ExamenClinico="+ID_ExamenClinico);
            //EJECUTA LA ACCION
            st.execute();
            
            JOptionPane.showMessageDialog(null, "DATOS ELIMINADOS");
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "ERROR AL ELIMINAR LOS DATOS " + e);
        }
    }
    
    //MODIFICA DATOS A LA TABLA DE LA BASE DE DATOS
    public static void Modificar(int ID, int ID_ExamenClinico, String Dato, String Valor){
        
        //OBJETO PARA TENER INTERACCION CON LA CLASE Conexion
        Conexion conec = new Conexion();
        
        try{
            
            String sql = "Update TBL_DatosExamen set ID="+ID+",ID_ExamenClinico='"+ID_ExamenClinico+"', "
                            + "Dato='"+Dato+"',Valor="+Valor+" where ID="+ID;
            
            //SE INDICA LA ACCION CON LA BASE DE DATOS (SE ALMACENA LOS DATOS)
            PreparedStatement st = conec.conexion.prepareStatement(sql);
            //EJECUTA LA ACCION
            st.execute();
            
            JOptionPane.showMessageDialog(null, "DATOS MODIFICADOS");
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "ERROR AL INSERTAR LOS DATOS " + e);
        }
    }
}
