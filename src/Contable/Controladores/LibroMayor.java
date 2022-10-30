/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Contable.Controladores;

/**
 *
 * @author emma
 */
public class LibroMayor {
    
    int ID;
    int IDLibro;
    String Grupo_Cuenta;
    String SubGrupo_Cuenta;
    String Nombre_Cuenta;
    double MontoTotal;

    public LibroMayor(int ID, int IDLibro, String Grupo_Cuenta, String SubGrupo_Cuenta, String Nombre_Cuenta, double MontoTotal) {
        this.ID = ID;
        this.IDLibro = IDLibro;
        this.Grupo_Cuenta = Grupo_Cuenta;
        this.SubGrupo_Cuenta = SubGrupo_Cuenta;
        this.Nombre_Cuenta = Nombre_Cuenta;
        this.MontoTotal = MontoTotal;
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

    public String getGrupo_Cuenta() {
        return Grupo_Cuenta;
    }

    public void setGrupo_Cuenta(String Grupo_Cuenta) {
        this.Grupo_Cuenta = Grupo_Cuenta;
    }

    public String getSubGrupo_Cuenta() {
        return SubGrupo_Cuenta;
    }

    public void setSubGrupo_Cuenta(String SubGrupo_Cuenta) {
        this.SubGrupo_Cuenta = SubGrupo_Cuenta;
    }

    public String getNombre_Cuenta() {
        return Nombre_Cuenta;
    }

    public void setNombre_Cuenta(String Nombre_Cuenta) {
        this.Nombre_Cuenta = Nombre_Cuenta;
    }

    public double getMontoTotal() {
        return MontoTotal;
    }

    public void setMontoTotal(double MontoTotal) {
        this.MontoTotal = MontoTotal;
    }

    
}

