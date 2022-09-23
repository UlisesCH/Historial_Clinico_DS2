package InClinico.Modulos;

import InClinico.Controladores.Conexion;
import InClinico.Controladores.ExamenClinico;
import static InClinico.Modulos.CRUD_DatosExamenes.listaDatos;
import static InClinico.Modulos.CRUD_DatosExamenes.listaDatosExamenes;
import static VistasInClinico.JFCrear_InClinico.listaExamenClinicos;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ulise
 */
public class CRUD_ExamenClinico extends Conexion {
    
    //LISTA PARA ALMACENAR LOS DATOS OBTENIDOS DE LA BASE DE DATOS
    public static List<ExamenClinico> listaExClinico = new ArrayList<ExamenClinico>();
    
    //LLENA LA TABLA CON LOS DATOS OBTENIDOS DE LA BASE DE DATOS
    public static void LlenarTabla(){
        //SE VACIA LA LISTA
        listaExClinico.clear();
        //OBJETO PARA TENER INTERACCION CON LA CLASE Conexion
        Conexion conec = new Conexion();
        //CREA LA CONECION Y VERIFICA LA EXISTENCIA DE LA TABLA
        conec.CrearTablas();
        //VARIABLE PARA EL RESULTADO OBTENIDO
        ResultSet result = null;
        
        try{
            //SE INDICA LA ACCION CON LA BASE DE DATOS (SE OBTINIENE LOS DATOS ALMACENADOS)
            PreparedStatement st = conec.conexion.prepareStatement("select * from TBL_ExamenClinico");
            //SE ALMACENA LOS RESULTADOS
            result = st.executeQuery();
            
            //SE RECORRE TODO LO ALMACENADO
            while(result.next()){
                //OBJETO DEL CONSTRUCTOR
                ExamenClinico inclinico = new ExamenClinico(result.getInt("ID"),result.getInt("ID_Recibo")
                                            ,result.getString("Nombre_Examen"),result.getDouble("Precio_Examen"));
                //SE AGREGA EL CONSTRUCTOR AL ARREGLO
                listaExClinico.add(inclinico);
                
            }
            
            System.out.println("Se lleno el arreglo con los datos");
            
        }catch(Exception e){
            System.out.println(e + " Error al llenar el arreglo");
        }
    }
    
    
    //LLENA LA TABLA CON LOS DATOS OBTENIDOS DE LA BASE DE DATOS
    public static void BuscarEnTabla(String buscar){
        //SE VACIA LA LISTA
        listaExClinico.clear();
        //OBJETO PARA TENER INTERACCION CON LA CLASE Conexion
        Conexion conec = new Conexion();
        //CREA LA CONECION Y VERIFICA LA EXISTENCIA DE LA TABLA
        conec.CrearTablas();
        //VARIABLE PARA EL RESULTADO OBTENIDO
        ResultSet result = null;
        
        try{
            //SE INDICA LA ACCION CON LA BASE DE DATOS (SE OBTINIENE LOS DATOS ALMACENADOS)
            PreparedStatement st = conec.conexion.prepareStatement("select * from TBL_ExamenClinico "
                                   + "where Nombre_Cliente LIKE '"+buscar+"'"
                                   + "OR Nombre_Examen LIKE '"+buscar+"'"
                                   + "OR Fecha LIKE '"+buscar+"'");
            //SE ALMACENA LOS RESULTADOS
            result = st.executeQuery();
            
            //SE RECORRE TODO LO ALMACENADO
            while(result.next()){
                //OBJETO DEL CONSTRUCTOR
                ExamenClinico inclinico = new ExamenClinico(result.getInt("ID"),result.getInt("ID_Recibo")
                                            ,result.getString("Nombre_Examen"),result.getDouble("Precio_Examen"));
                //SE AGREGA EL CONSTRUCTOR AL ARREGLO
                listaExClinico.add(inclinico);

            }
            
            System.out.println("Se lleno el arreglo con los datos");
            
        }catch(Exception e){
            System.out.println(e + " Error al llenar el arreglo");
        }
    }
    
    
    
    //INSERTA DATOS A LA TABLA DE LA BASE DE DATOS
    public static void Insertar(int ID_Recibo, String Nombre_Examen, Double Precio_Examen, int PosC){
        CRUD_DatosExamenes Cr_DatosExamenes = new CRUD_DatosExamenes();
        int ID;
        
        ID = (int)(Math.random()*9000+1);
        //OBJETO PARA TENER INTERACCION CON LA CLASE Conexion
        Conexion conec = new Conexion();

        try{
            
            System.out.println(Nombre_Examen);
            
            //SE INDICA LA ACCION CON LA BASE DE DATOS (SE ALMACENA LOS DATOS)
            PreparedStatement st = conec.conexion.prepareStatement(
                    "insert into TBL_ExamenClinico(ID, ID_Recibo, Nombre_Examen, Precio_Examen)\n"
                    + "values("+ID+","+ID_Recibo+",'"+Nombre_Examen+"'," +Precio_Examen+ ");");
            //EJECUTA LA ACCION
            st.execute();
            
            for(int PosD = 0; PosD < listaDatosExamenes.size(); PosD++){

                if(listaDatosExamenes.get(PosD).getIDExamen() == listaExamenClinicos.get(PosC).getID()){

                    Cr_DatosExamenes.InsertarValorDatos(ID, 
                                    listaDatos.get(PosD).getDato(),
                                    listaDatosExamenes.get(PosD).getValor(),
                                    listaDatosExamenes.get(PosD).getUnidad());
                    
                    System.out.println("Unidad "+listaDatosExamenes.get(PosD).getUnidad());
                    
                }
                
            }

        }catch(Exception e){
            System.out.println(e + " ERROR AL INSERTAR LOS DATOS");
        }
    }
    
    //ELIMINA LOS DATOS DEL REGISTRO SELECCIONADO
    public static void Eliminar(int ID_Recibo){
        //OBJETO PARA ENTERACTUAR CON EL CRUD
        CRUD_DatosExamenes Cr_DatosExamenes = new CRUD_DatosExamenes();
        //OBJETO PARA TENER INTERACCION CON LA CLASE Conexion
        Conexion conec = new Conexion();
        
        try{

            LlenarTabla();
            
            //SE INDICA LA ACCION CON LA BASE DE DATOS (SE ELIMINA LOS DATOS SEGUN EL ID)
            PreparedStatement st = conec.conexion.prepareStatement("delete from TBL_ExamenClinico where ID_Recibo="+ID_Recibo);
            //EJECUTA LA ACCION
            st.execute();
            
            for(int PosList = 0; PosList < listaExClinico.size(); PosList++){
                if(listaExClinico.get(PosList).getID_Recibo()==ID_Recibo){
                    Cr_DatosExamenes.EliminarValorDatos(listaExClinico.get(PosList).getID());
                }
            }
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "ERROR AL ELIMINAR LOS DATOS " + e);
        }
    }
    
    //INSERTA DATOS A LA TABLA DE LA BASE DE DATOS
    public static void Modificar(int ID, int ID_Recibo, String Nombre_Examen, Double Precio_Examen){

        //OBJETO PARA TENER INTERACCION CON LA CLASE Conexion
        Conexion conec = new Conexion();
    
        try{
            
            String sql = "Update TBL_ExamenClinico set ID="+ID+", ID_Recibo="+ID_Recibo+
                        ",Nombre_Examen='"+Nombre_Examen+"', Precio_Examen="+Precio_Examen+
                        "where ID="+ID;
            
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
