/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package InClinico;

/**
 *
 * @author ulise
 */
public class InClinico {
    
    //VARIABLES DE VALORES ALMACENADOS EN LA BASE DE DATOS
    private int ID;
    private String Nombre_Cliente;
    private String Nombre_Examen;
    private Double PrecioTotal_Examen;
    private String Fecha;

    public InClinico(int ID, String Nombre_Cliente, String Nombre_Examen, Double PrecioTotal_Examen, String Fecha) {
        this.ID = ID;
        this.Nombre_Cliente = Nombre_Cliente;
        this.Nombre_Examen = Nombre_Examen;
        this.PrecioTotal_Examen = PrecioTotal_Examen;
        this.Fecha = Fecha;
    }

    public int getID() {
        return ID;
    }

    public String getNombre_Cliente() {
        return Nombre_Cliente;
    }

    public String getNombre_Examen() {
        return Nombre_Examen;
    }

    public Double getPrecioTotal_Examen() {
        return PrecioTotal_Examen;
    }

    public String getFecha() {
        return Fecha;
    }
    
    
    
}
