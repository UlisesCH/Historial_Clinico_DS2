/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package InContable;

/**
 *
 * @author ulise
 */
public class InContable {
    
    //VARIABLES DE VALORES ALMACENADOS EN LA BASE DE DATOS
    private int ID;
    private String NombProducto;
    private int Cantidad;
    private String NombProveedor;
    private Double PrecioProducto;
    private String TipoCuenta;
    private String Fecha;

    //CONSTRUCTOR PARA EL ARREGLO
    public InContable(int ID, String NombProducto, int Cantidad, String NombProveedor, 
                        Double PrecioProducto, String TipoCuenta, String Fecha) {
        this.ID = ID;
        this.NombProducto = NombProducto;
        this.Cantidad = Cantidad;
        this.NombProveedor = NombProveedor;
        this.PrecioProducto = PrecioProducto;
        this.TipoCuenta = TipoCuenta;
        this.Fecha = Fecha;
    }

    //METODOS GET PARA LA OBTENCION DE DATOS

    public int getID() {
        return ID;
    }

    public String getNombProducto() {
        return NombProducto;
    }

    public int getCantidad() {
        return Cantidad;
    }

    public String getNombProveedor() {
        return NombProveedor;
    }

    public Double getPrecioProducto() {
        return PrecioProducto;
    }

    public String getTipoCuenta() {
        return TipoCuenta;
    }

    public String getFecha() {
        return Fecha;
    }
    
    
}
