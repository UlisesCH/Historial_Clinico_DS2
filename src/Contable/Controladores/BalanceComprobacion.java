/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Contable.Controladores;

/**
 *
 * @author ulise
 */
public class BalanceComprobacion {
    
    int ID;
    int IDLibro;
    double Ingresos;
    double Costos;
    double Gastos;

    public BalanceComprobacion(int ID, int IDLibro, double Ingresos, double Costos, double Gastos) {
        this.ID = ID;
        this.IDLibro = IDLibro;
        this.Ingresos = Ingresos;
        this.Costos = Costos;
        this.Gastos = Gastos;
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

    public double getIngresos() {
        return Ingresos;
    }

    public void setIngresos(double Ingresos) {
        this.Ingresos = Ingresos;
    }

    public double getCostos() {
        return Costos;
    }

    public void setCostos(double Costos) {
        this.Costos = Costos;
    }

    public double getGastos() {
        return Gastos;
    }

    public void setGastos(double Gastos) {
        this.Gastos = Gastos;
    }

}
