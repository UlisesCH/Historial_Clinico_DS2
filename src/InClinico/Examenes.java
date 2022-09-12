/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package InClinico;

/**
 *
 * @author ulise
 */
public class Examenes {
    
    private int ID;
    private String Nombre_Examen;
    private Double Precio_Examen;

    public Examenes(int ID, String Nombre_Examen, Double Precio_Examen) {
        this.ID = ID;
        this.Nombre_Examen = Nombre_Examen;
        this.Precio_Examen = Precio_Examen;
    }

    public int getID() {
        return ID;
    }

    public String getNombre_Examen() {
        return Nombre_Examen;
    }

    public Double getPrecio_Examen() {
        return Precio_Examen;
    }
    
}
