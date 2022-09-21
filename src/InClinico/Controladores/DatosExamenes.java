/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package InClinico.Controladores;

/**
 *
 * @author ulise
 */
public class DatosExamenes {
    
    private int ID;
    private int IDExamen;
    private String Dato;
    private String Valor;
    
    public DatosExamenes(){
        
    }

    public DatosExamenes(int ID, int IDExamen, String Dato, String Valor) {
        this.ID = ID;
        this.IDExamen = IDExamen;
        this.Dato = Dato;
        this.Valor = Valor;
    }

    public int getID() {
        return ID;
    }

    public int getID_Examen() {
        return IDExamen;
    }

    public String getDato() {
        return Dato;
    }

    public String getValor() {
        return Valor;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setID_Examen(int ID_Examen) {
        this.IDExamen = ID_Examen;
    }

    public void setDato(String Dato) {
        this.Dato = Dato;
    }

    public void setValor(String Valor) {
        this.Valor = Valor;
    }
 
}
