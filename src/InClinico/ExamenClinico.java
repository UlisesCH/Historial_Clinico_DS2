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
    private int ID_Recibo;
    private String Nombre_Examen;
    private Double Precio_Examen;
    
    public ExamenClinico(){
        
    }

    public ExamenClinico(int ID, int ID_Recibo, String Nombre_Examen, Double Precio_Examen) {
        this.ID = ID;
        this.ID_Recibo = ID_Recibo;
        this.Nombre_Examen = Nombre_Examen;
        this.Precio_Examen = Precio_Examen;
    }

    public int getID() {
        return ID;
    }

    public int getID_Recibo() {
        return ID_Recibo;
    }

    public String getNombre_Examen() {
        return Nombre_Examen;
    }

    public Double getPrecio_Examen() {
        return Precio_Examen;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setID_Recibo(int ID_Recibo) {
        this.ID_Recibo = ID_Recibo;
    }

    public void setNombre_Examen(String Nombre_Examen) {
        this.Nombre_Examen = Nombre_Examen;
    }

    public void setPrecio_Examen(Double Precio_Examen) {
        this.Precio_Examen = Precio_Examen;
    }

   
    
}
