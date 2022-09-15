/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package InClinico;

/**
 *
 * @author ulise
 */
public class Recibo {
    
    //VARIABLES DE VALORES ALMACENADOS EN LA BASE DE DATOS
    private int ID;
    private String Nombre_Cliente;
    private Double PrecioTotal_Examen;
    private String Fecha;
    
    public Recibo(){
        
    }

    public Recibo(int ID, String Nombre_Cliente, Double PrecioTotal_Examen, String Fecha) {
        this.ID = ID;
        this.Nombre_Cliente = Nombre_Cliente;
        this.PrecioTotal_Examen = PrecioTotal_Examen;
        this.Fecha = Fecha;
    }

    public int getID() {
        return ID;
    }

    public String getNombre_Cliente() {
        return Nombre_Cliente;
    }

    public Double getPrecioTotal_Examen() {
        return PrecioTotal_Examen;
    }

    public String getFecha() {
        return Fecha;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setNombre_Cliente(String Nombre_Cliente) {
        this.Nombre_Cliente = Nombre_Cliente;
    }

    public void setPrecioTotal_Examen(Double PrecioTotal_Examen) {
        this.PrecioTotal_Examen = PrecioTotal_Examen;
    }

    public void setFecha(String Fecha) {
        this.Fecha = Fecha;
    }
    
}
