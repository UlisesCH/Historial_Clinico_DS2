/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package InClinico;

/**
 *
 * @author ulise
 */
public class InClRecibo {
    
    //VARIABLES DE VALORES ALMACENADOS EN LA BASE DE DATOS
    private String Nombre_Cliente;
    private String Nombre_Examen;
    private Double Precio_Examen;
    private String Fecha;

    public InClRecibo(String Nombre_Cliente, String Nombre_Examen, Double Precio_Examen, String Fecha) {
        this.Nombre_Cliente = Nombre_Cliente;
        this.Nombre_Examen = Nombre_Examen;
        this.Precio_Examen = Precio_Examen;
        this.Fecha = Fecha;
    }

    public String getNombre_Cliente() {
        return Nombre_Cliente;
    }

    public String getNombre_Examen() {
        return Nombre_Examen;
    }

    public Double getPrecio_Examen() {
        return Precio_Examen;
    }

    public String getFecha() {
        return Fecha;
    }

    
}
