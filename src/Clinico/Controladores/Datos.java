/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clinico.Controladores;

/**
 *
 * @author ulise
 */
public class Datos {
    
    private int ID;
    private int IDExamen;
    private String Dato;
    private String Unidad;

    public Datos(int ID, int IDExamen, String Dato, String Unidad) {
        this.ID = ID;
        this.IDExamen = IDExamen;
        this.Dato = Dato;
        this.Unidad = Unidad;
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

    public String getUnidad() {
        return Unidad;
    }
    
    
    
}
