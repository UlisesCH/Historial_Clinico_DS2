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
    double Utilidad;

    public EstadoResultado(int ID, int IDLibro, double Reserva, double Impuesto, double Utilidad) {
        this.ID = ID;
        this.IDLibro = IDLibro;
        this.Reserva = Reserva;
        this.Impuesto = Impuesto;
        this.Utilidad = Utilidad;
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

    public double getUtilidad() {
        return Utilidad;
    }

    public void setUtilidad(double Utilidad) {
        this.Utilidad = Utilidad;
    }

    
}
