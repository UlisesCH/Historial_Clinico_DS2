/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Contable.Controladores;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 *
 * @author ulise
 */
public class Conexion {
    
     public static boolean Tess = false;
    
    //OBJETO PARA LA CONEXION CON LA BASE DE DATOS
    public static Connection conexion;
    
    static final String TBL_CuentasContable
            = "CREATE TABLE TBL_CuentasContable(\n"
            + "ID integer primary key autoincrement,\n"
            + "Grupo_Cuenta varchar(500),\n"
            + "Tipo_Cuenta varchar(500),\n"
            + "SubGrupo_Cuenta varchar(500),\n"
            + "Nombre_Cuenta varchar(500))";
    
    //ESTRUCTURA DE LA TABLA DE INFORMES CONTABLES
    static final String TBL_Libros
            = "CREATE TABLE TBL_Libros(\n"
            + "ID integer primary key autoincrement,\n"
            + "Nombre varchar(500),\n"
            + "FechaInicio date,\n"
            + "FechaFinal date)";
    
    static final String TBL_LibroMayor
            = "CREATE TABLE TBL_LibroMayor("
            + "ID integer primary key autoincrement,"
            + "IDLibro integer,\n"
            + "Grupo_Cuenta varchar(500),\n"
            + "SubGrupo_Cuenta varchar(500),\n"
            + "Nombre_Cuenta varchar(500),\n"
            + "MontoTotal Double)";
    
    static final String TBL_BalanceComprobacion
            = "CREATE TABLE TBL_BalanceComprobacion("
            + "ID integer primary key autoincrement,"
            + "IDLibro integer,\n"
            + "Ingresos Double,\n"
            + "Costos Double,\n"
            + "Gastos Double)";
    
    static final String TBL_EstadoResultado
            = "CREATE TABLE TBL_EstadoResultado("
            + "ID integer primary key autoincrement,"
            + "IDLibro integer,\n"
            + "Reserva Double,\n"
            + "Impuesto Double,\n"
            + "Utilidad Double)";
    
    static final String TBL_Partida
            = "CREATE TABLE TBL_Partida(\n"
            + "ID integer primary key autoincrement,\n"
            + "IDLibro integer,\n"
            + "Concepto varchar(500),\n"
            + "Fecha date)";
    
    static final String TBL_Cuenta
            = "CREATE TABLE TBL_Cuenta(\n"
            + "ID integer primary key autoincrement,\n"
            + "IDPartida integer,\n"
            + "Grupo_Cuenta varchar(500),\n"
            + "Tipo_Cuenta varchar(500),\n"
            + "SubGrupo_Cuenta varchar(500),\n"
            + "Nombre_Cuenta varchar(500),\n"
            + "TipoMovimiento varchar(500),\n"
            + "Monto Double)";
    
    //DIRECCION DONDE SE ALMACENARA LA BASE DE DATOS
    static String url = "jdbc:sqlite:BDHisContable.db";
    
    //CREA LA CONEXION CON LA BASE DE DATOS Y TABLA INDICADA
    public static void crearConexion(){
        try{
            conexion = DriverManager.getConnection(url);

        }catch (Exception e){
            System.out.println(e + " Error al crear Conexion");
        }
    }
    
    //CREA LA TABLA EN CASO DE NO HABER
    public static boolean CrearTablas(){
        Statement stmt = null;
        try{
            crearConexion();
            stmt = conexion.createStatement();
            stmt.executeUpdate(TBL_CuentasContable);
            stmt.executeUpdate(TBL_Libros);
            stmt.executeUpdate(TBL_LibroMayor);
            stmt.executeUpdate(TBL_BalanceComprobacion);
            stmt.executeUpdate(TBL_EstadoResultado);
            stmt.executeUpdate(TBL_Partida);
            stmt.executeUpdate(TBL_Cuenta);
            stmt.close();
            conexion.close();
            
            Tess = true;
            
        }catch (Exception e){
            
            Tess = false;
            System.out.println(e + " Error al crear Tabla");
        }
        
        return false;
    }
    
}
