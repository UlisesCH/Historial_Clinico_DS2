/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Contable.Controladores;

/**
 *
 * @author ulise
 */
public class EstadoResultado {
    
    int ID;
    int IDLibro;
    double Reserva;
    double Impuesto;

    public EstadoResultado(int ID, int IDLibro, double Reserva, double Impuesto) {
        this.ID = ID;
        this.IDLibro = IDLibro;
        this.Reserva = Reserva;
        this.Impuesto = Impuesto;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getIDLibro() {
        return IDLibro;
    }

    public void setIDLibro(int IDLibro) {
        this.IDLibro = IDLibro;
    }

    public double getReserva() {
        return Reserva;
    }

    public void setReserva(double Reserva) {
        this.Reserva = Reserva;
    }

    public double getImpuesto() {
        return Impuesto;
    }

    public void setImpuesto(double Impuesto) {
        this.Impuesto = Impuesto;
    }
    
}
