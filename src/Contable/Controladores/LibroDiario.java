/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Contable.Controladores;

/**
 *
 * @author ulise
 */
public class LibroDiario {
    
    int ID;
    String Nombre;
    String FechaInicio;
    String FechaFinal;

    public LibroDiario(int ID, String Nombre, String FechaInicio, String FechaFinal) {
        this.ID = ID;
        this.Nombre = Nombre;
        this.FechaInicio = FechaInicio;
        this.FechaFinal = FechaFinal;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getFechaInicio() {
        return FechaInicio;
    }

    public void setFechaInicio(String FechaInicio) {
        this.FechaInicio = FechaInicio;
    }

    public String getFechaFinal() {
        return FechaFinal;
    }

    public void setFechaFinal(String FechaFinal) {
        this.FechaFinal = FechaFinal;
    }
    
    
}
