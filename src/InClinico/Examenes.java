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
    private String NombreExamen;
    private Double PrecioExamen;

    public Examenes(int ID, String NombreExamen, Double PrecioExamen) {
        this.ID = ID;
        this.NombreExamen = NombreExamen;
        this.PrecioExamen = PrecioExamen;
    }

    public int getID() {
        return ID;
    }

    public String getNombre_Examen() {
        return NombreExamen;
    }

    public Double getPrecio_Examen() {
        return PrecioExamen;
    }
    
}
