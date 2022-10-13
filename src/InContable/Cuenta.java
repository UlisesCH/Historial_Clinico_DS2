/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package InContable;

/**
 *
 * @author ulise
 */
public class Cuenta {

    //VARIABLES DE VALORES ALMACENADOS EN LA BASE DE DATOS
    private int ID;
    private int IDPartida;
    private String GrupoCuenta;
    private String TipoCuenta;
    private String SubGrupoCuenta;
    private String NombreCuenta;
    private Double Monto;
    private String TipoMovimiento;

    public Cuenta(int ID, int IDPartida, String GrupoCuenta, String TipoCuenta, String SubGrupoCuenta, String NombreCuenta, Double Monto, String TipoMovimiento) {
        this.ID = ID;
        this.IDPartida = IDPartida;
        this.GrupoCuenta = GrupoCuenta;
        this.TipoCuenta = TipoCuenta;
        this.SubGrupoCuenta = SubGrupoCuenta;
        this.NombreCuenta = NombreCuenta;
        this.Monto = Monto;
        this.TipoMovimiento = TipoMovimiento;
    }

    public Cuenta(String GrupoCuenta, String TipoCuenta, String SubGrupoCuenta, String NombreCuenta, Double Monto, String TipoMovimiento) {
        this.GrupoCuenta = GrupoCuenta;
        this.TipoCuenta = TipoCuenta;
        this.SubGrupoCuenta = SubGrupoCuenta;
        this.NombreCuenta = NombreCuenta;
        this.Monto = Monto;
        this.TipoMovimiento = TipoMovimiento;
    }
    
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getIDPartida() {
        return IDPartida;
    }

    public void setIDPartida(int IDPartida) {
        this.IDPartida = IDPartida;
    }

    public String getGrupoCuenta() {
        return GrupoCuenta;
    }

    public void setGrupoCuenta(String GrupoCuenta) {
        this.GrupoCuenta = GrupoCuenta;
    }

    public String getTipoCuenta() {
        return TipoCuenta;
    }

    public void setTipoCuenta(String TipoCuenta) {
        this.TipoCuenta = TipoCuenta;
    }

    public String getSubGrupoCuenta() {
        return SubGrupoCuenta;
    }

    public void setSubGrupoCuenta(String SubGrupoCuenta) {
        this.SubGrupoCuenta = SubGrupoCuenta;
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

    public String getTipoMovimiento() {
        return TipoMovimiento;
    }

    public void setTipoMovimiento(String TipoMovimiento) {
        this.TipoMovimiento = TipoMovimiento;
    }

    
}
