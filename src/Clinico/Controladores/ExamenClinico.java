/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clinico.Controladores;

/**
 *
 * @author ulise
 */
public class ExamenClinico {
    
    //VARIABLES DE VALORES ALMACENADOS EN LA BASE DE DATOS
    private int ID;
    private int IDRecibo;
    private String NombreExamen;
    private String RangoMuestra;
    private Double PrecioExamen;
    
    public ExamenClinico(){
        
    }

    public ExamenClinico(int ID, int IDRecibo, String NombreExamen, String CantidadMuestra, Double PrecioExamen) {
        this.ID = ID;
        this.IDRecibo = IDRecibo;
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

    public int getIDRecibo() {
        return IDRecibo;
    }

    public void setIDRecibo(int IDRecibo) {
        this.IDRecibo = IDRecibo;
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
