/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package InContable.Modulos;

import InContable.Conexion;
import InContable.Partida;
import static JFInContable.JFCrear_Partida.listaInCuenta;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author ulise
 */
public class CRUD_Partidas {
    
    CRUD_Cuenta CrCuenta = new CRUD_Cuenta();
    //LISTA PARA ALMACENAR LOS DATOS OBTENIDOS DE LA BASE DE DATOS
    public static List<Partida> listaPartidas = new ArrayList<Partida>();
    
    //LLENA LA TABLA CON LOS DATOS OBTENIDOS DE LA BASE DE DATOS
    public static void LlenarTabla(){
        //SE VACIA LA LISTA
        listaPartidas.clear();
        //OBJETO PARA TENER INTERACCION CON LA CLASE Conexion
        Conexion conec = new Conexion();
        //CREA LA CONECION Y VERIFICA LA EXISTENCIA DE LA TABLA
        conec.CrearTablas();
        //VARIABLE PARA EL RESULTADO OBTENIDO
        ResultSet result = null;
        
        try{
            //SE INDICA LA ACCION CON LA BASE DE DATOS (SE OBTINIENE LOS DATOS ALMACENADOS)
            PreparedStatement st = conec.conexion.prepareStatement("select * from TBL_Partida");
            //SE ALMACENA LOS RESULTADOS
            result = st.executeQuery();
            
            //SE RECORRE TODO LO ALMACENADO
            while(result.next()){
                //OBJETO DEL CONSTRUCTOR
                Partida InPartida = new Partida(result.getInt("ID"),
                                                result.getInt("IDLibro"),
                                                result.getString("Concepto"),
                                                result.getString("Fecha"));
                //SE AGREGA EL CONSTRUCTOR AL ARREGLO
                listaPartidas.add(InPartida);

            }
            
        }catch(Exception e){
            System.out.println(e + " Error al llenar la tabla");
        }
    }
    
    //INSERTA DATOS A LA TABLA DE LA BASE DE DATOS
    public static void Insertar(int IDLibro, String Concepto, String Fecha){
        int ID;
        
        ID = (int)(Math.random()*9000+1);

        //OBJETO PARA TENER INTERACCION CON LA CLASE Conexion
        Conexion conec = new Conexion();

        try{

            //SE INDICA LA ACCION CON LA BASE DE DATOS (SE ALMACENA LOS DATOS)
            PreparedStatement st = conec.conexion.prepareStatement(
                    "insert into TBL_Partida(ID, IDLibro, Concepto, Fecha)\n"
                    + "values("+ID+","+IDLibro+",'"+Concepto+"','"+Fecha+"');");
            //EJECUTA LA ACCION
            st.execute();
            
            //CICLO PARA LLENAR LA TABLA CON LOS VALORES DEL ARREGLO
            for(int PosC = 0; PosC < listaInCuenta.size(); PosC++){
                
                CRUD_Cuenta.Insertar(ID,
                listaInCuenta.get(PosC).getGrupoCuenta(),
                listaInCuenta.get(PosC).getTipoCuenta(),
                listaInCuenta.get(PosC).getSubGrupoCuenta(),
                listaInCuenta.get(PosC).getNombreCuenta(),
                listaInCuenta.get(PosC).getMonto(),
                listaInCuenta.get(PosC).getTipoMovimiento());
            }
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "ERROR AL INSERTAR LOS DATOS " + e);
        }
        
    }
    
    //ELIMINA LOS DATOS DEL REGISTRO SELECCIONADO
    public static void EliminarPorPartida(int id){
        
        //OBJETO PARA TENER INTERACCION CON LA CLASE Conexion
        Conexion conec = new Conexion();
        
        try{
            //SE INDICA LA ACCION CON LA BASE DE DATOS (SE ELIMINA LOS DATOS SEGUN EL ID)
            PreparedStatement st = conec.conexion.prepareStatement("delete from TBL_Partida where ID="+id);
            //EJECUTA LA ACCION
            st.execute();
            
            CRUD_Cuenta.EliminarPorPartida(id);
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "ERROR AL ELIMINAR LOS DATOS " + e);
        }
    }
    
    //ELIMINA LOS DATOS DEL REGISTRO SELECCIONADO
    public static void EliminarPorLibro(int id){
        LlenarTabla();
        
        //OBJETO PARA TENER INTERACCION CON LA CLASE Conexion
        Conexion conec = new Conexion();
        
        try{
            //SE INDICA LA ACCION CON LA BASE DE DATOS (SE ELIMINA LOS DATOS SEGUN EL ID)
            PreparedStatement st = conec.conexion.prepareStatement("delete from TBL_Partida where IDLibro="+id);
            //EJECUTA LA ACCION
            st.execute();

            for(int i=0; i< listaPartidas.size(); i++){
                
                if(listaPartidas.get(i).getIDLibro() == id){
                    CRUD_Cuenta.EliminarPorPartida(listaPartidas.get(i).getID());
                }  
            }
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "ERROR AL ELIMINAR LOS DATOS " + e);
        }
    }
}
