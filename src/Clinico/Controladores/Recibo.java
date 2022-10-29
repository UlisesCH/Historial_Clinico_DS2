/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clinico.Controladores;

/**
 *
 * @author ulise
 */
public class Recibo {
    
    //VARIABLES DE VALORES ALMACENADOS EN LA BASE DE DATOS
    private int ID;
    private String NombreCliente;
    private int EdadCliente;
    private Double PrecioTotalExamen;
    private String Fecha;
    
    public Recibo(){
        
    }

    public Recibo(int ID, String NombreCliente, int EdadCliente, Double PrecioTotalExamen, String Fecha) {
        this.ID = ID;
        this.NombreCliente = NombreCliente;
        this.EdadCliente = EdadCliente;
        this.PrecioTotalExamen = PrecioTotalExamen;
        this.Fecha = Fecha;
    }

    public int getID() {
        return ID;
    }

    public String getNombre_Cliente() {
        return NombreCliente;
    }

    public int getEdad_Cliente() {
        return EdadCliente;
    }

    public Double getPrecioTotal_Examen() {
        return PrecioTotalExamen;
    }

    public String getFecha() {
        return Fecha;
    }
    
    

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setNombre_Cliente(String Nombre_Cliente) {
        this.NombreCliente = Nombre_Cliente;
    }

    public void setEdad_Cliente(int Edad_Cliente) {
        this.EdadCliente = Edad_Cliente;
    }

    public void setPrecioTotal_Examen(Double PrecioTotal_Examen) {
        this.PrecioTotalExamen = PrecioTotal_Examen;
    }

    public void setFecha(String Fecha) {
        this.Fecha = Fecha;
    }
    
    
    
}
