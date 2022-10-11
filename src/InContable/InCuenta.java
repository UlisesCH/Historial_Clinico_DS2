/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package InContable;

/**
 *
 * @author ulise
 */
public class InCuenta {

    //VARIABLES DE VALORES ALMACENADOS EN LA BASE DE DATOS
    
    private String GrupoCuenta;
    private String NombreCuenta;
    private Double Monto;
    private String TipoCuenta;

    public InCuenta(String GrupoCuenta, String NombreCuenta, Double Monto, String TipoCuenta) {
        this.GrupoCuenta = GrupoCuenta;
        this.NombreCuenta = NombreCuenta;
        this.Monto = Monto;
        this.TipoCuenta = TipoCuenta;
    }

    public String getGrupoCuenta() {
        return GrupoCuenta;
    }

    public void setGrupoCuenta(String GrupoCuenta) {
        this.GrupoCuenta = GrupoCuenta;
    }

    public String getNombreCuenta() {
        return NombreCuenta;
    }

    public void setNombreCuenta(String NombreCuenta) {
        this.NombreCuenta = NombreCuenta;
    }

    public Double getMonto() {
        return Monto;
    }

    public void setMonto(Double Monto) {
        this.Monto = Monto;
    }

    public String getTipoCuenta() {
        return TipoCuenta;
    }

    public void setTipoCuenta(String TipoCuenta) {
        this.TipoCuenta = TipoCuenta;
    }

    
}
