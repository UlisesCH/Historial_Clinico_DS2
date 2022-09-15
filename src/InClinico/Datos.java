/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package InClinico;

/**
 *
 * @author ulise
 */
public class Datos {
    
    private int ID;
    private int ID_Examen;
    private String Dato;

    public Datos(int ID, int ID_Examen, String Dato) {
        this.ID = ID;
        this.ID_Examen = ID_Examen;
        this.Dato = Dato;
    }

    public int getID() {
        return ID;
    }

    public int getID_Examen() {
        return ID_Examen;
    }

    public String getDato() {
        return Dato;
    }
    
    
    
}
