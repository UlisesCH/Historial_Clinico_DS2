/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package InClinico;

/**
 *
 * @author ulise
 */
public class ExamenClinico {
    
    //VARIABLES DE VALORES ALMACENADOS EN LA BASE DE DATOS
    private int ID;
    private int IDRecibo;
    private String NombreExamen;
    private Double PrecioExamen;
    
    public ExamenClinico(){
        
    }

    public ExamenClinico(int ID, int IDRecibo, String NombreExamen, Double PrecioExamen) {
        this.ID = ID;
        this.IDRecibo = IDRecibo;
        this.NombreExamen = NombreExamen;
        this.PrecioExamen = PrecioExamen;
    }

    public int getID() {
        return ID;
    }

    public int getID_Recibo() {
        return IDRecibo;
    }

    public String getNombre_Examen() {
        return NombreExamen;
    }

    public Double getPrecio_Examen() {
        return PrecioExamen;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setID_Recibo(int ID_Recibo) {
        this.IDRecibo = ID_Recibo;
    }

    public void setNombre_Examen(String Nombre_Examen) {
        this.NombreExamen = Nombre_Examen;
    }

    public void setPrecio_Examen(Double Precio_Examen) {
        this.PrecioExamen = Precio_Examen;
    }

   
    
}
