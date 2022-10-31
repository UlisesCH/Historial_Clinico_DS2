/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clinico.Controladores;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

/**
 *
 * @author ulise
 */
public class Conexion {
    
    public static String URL = "/OneDrive/Escritorio/";
    
    //OBJETO PARA LA CONEXION CON LA BASE DE DATOS
    public static Connection conexion;
    
    //ESTRUCTURA DE LA TABLA DE INFORMES CLINICOS
    static final String TBL_Examen
            = "CREATE TABLE TBL_Examen(\n"
            + "ID integer primary key autoincrement,\n"
            + "Nombre_Examen varchar(500),\n"
            + "Cantidad_Muestra varchar(500),\n"
            + "Precio_Examen Double)";
    
    static final String TBL_Prueba
            = "CREATE TABLE TBL_Prueba(\n"
            + "ID integer primary key autoincrement,\n"
            + "ID_Examen integer(500),\n"
            + "Prueba varchar(500),\n"
            + "Unidad varchar(500))";
    
    //ESTRUCTURA DE LA TABLA DE INFORMES CLINICOS
    static final String TBL_Recibo
            = "CREATE TABLE TBL_Recibo(\n"
            + "ID integer primary key autoincrement,\n"
            + "Nombre_Cliente varchar(500),\n"
            + "Edad_Cliente integer(500),\n"
            + "PrecioTotal_Examen Double,\n"
            + "Fecha date)";
    
    static final String TBL_ExamenClinico
            = "CREATE TABLE TBL_ExamenClinico(\n"
            + "ID integer primary key autoincrement,\n"
            + "ID_Recibo integer,\n"
            + "Nombre_Examen varchar(500),\n"
            + "Rango_Muestra varchar(500),\n"
            + "Precio_Examen Double)";
    
    static final String TBL_PruebasExamen
            = "CREATE TABLE TBL_PruebasExamen(\n"
            + "ID integer primary key autoincrement,\n"
            + "ID_ExamenClinico integer,\n"
            + "Prueba varchar(500),\n"
            + "Valor varchar(500),\n"
            + "Unidad varchar(500))";
    
    static String url = "jdbc:sqlite:BDHisClinico.db";
    
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
            stmt.executeUpdate(TBL_Prueba);
            stmt.executeUpdate(TBL_Examen);
            stmt.executeUpdate(TBL_Recibo);
            stmt.executeUpdate(TBL_ExamenClinico);
            stmt.executeUpdate(TBL_PruebasExamen);
            stmt.close();
            conexion.close();
            return true;
        }catch (Exception e){
            System.out.println(e + " Error al crear Tabla");
        }
        return false;

    }
    
}
