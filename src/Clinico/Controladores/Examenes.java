/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clinico.Controladores;

/**
 *
 * @author ulise
 */
public class Examenes {
    
    private int ID;
    private String NombreExamen;
    private String RangoMuestra;
    private Double PrecioExamen;

    public Examenes(int ID, String NombreExamen, String CantidadMuestra, Double PrecioExamen) {
        this.ID = ID;
        this.NombreExamen = NombreExamen;
        this.RangoMuestra = CantidadMuestra;
        this.PrecioExamen = PrecioExamen;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getNombreExamen() {
        return NombreExamen;
    }

    public void setNombreExamen(String NombreExamen) {
        this.NombreExamen = NombreExamen;
    }

    public String getRangoMuestra() {
        return RangoMuestra;
    }

    public void setRangoMuestra(String RangoMuestra) {
        this.RangoMuestra = RangoMuestra;
    }

    public Double getPrecioExamen() {
        return PrecioExamen;
    }

    public void setPrecioExamen(Double PrecioExamen) {
        this.PrecioExamen = PrecioExamen;
    }

    
    
}
