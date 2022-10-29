/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package InContable;

/**
 *
 * @author emma
 */
public class LibroMayor {
    
    int ID;
    int IDLibro;
    String Grupo_Cuenta;
    String Tipo_Cuenta;
    String SubGrupo_Cuenta;
    double MontoTotal;

    public LibroMayor(int ID, int IDLibro, String Grupo_Cuenta, String Tipo_Cuenta, String SubGrupo_Cuenta, double MontoTotal) {
        this.ID = ID;
        this.IDLibro = IDLibro;
        this.Grupo_Cuenta = Grupo_Cuenta;
        this.Tipo_Cuenta = Tipo_Cuenta;
        this.SubGrupo_Cuenta = SubGrupo_Cuenta;
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

    public String getTipo_Cuenta() {
        return Tipo_Cuenta;
    }

    public void setTipo_Cuenta(String Tipo_Cuenta) {
        this.Tipo_Cuenta = Tipo_Cuenta;
    }

    public String getSubGrupo_Cuenta() {
        return SubGrupo_Cuenta;
    }

    public void setSubGrupo_Cuenta(String SubGrupo_Cuenta) {
        this.SubGrupo_Cuenta = SubGrupo_Cuenta;
    }

    public double getMontoTotal() {
        return MontoTotal;
    }

    public void setMontoTotal(double MontoTotal) {
        this.MontoTotal = MontoTotal;
    }
    
    
    
}

