/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package InClinico.Controladores;

/**
 *
 * @author ulise
 */
public class Datos {
    
    private int ID;
    private int IDExamen;
    private String Dato;

    public Datos(int ID, int IDExamen, String Dato) {
        this.ID = ID;
        this.IDExamen = IDExamen;
        this.Dato = Dato;
    }

    public int getID() {
        return ID;
    }

    public int getID_Examen() {
        return IDExamen;
    }

    public String getDato() {
        return Dato;
    }
    
    
    
}
