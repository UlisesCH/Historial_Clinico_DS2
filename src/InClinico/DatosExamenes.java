/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package InClinico;

/**
 *
 * @author ulise
 */
public class DatosExamenes {
    
    private int ID;
    private int ID_Examen;
    private String Dato;
    private String Valor;
    
    public DatosExamenes(){
        
    }

    public DatosExamenes(int ID, int ID_Examen, String Dato, String Valor) {
        this.ID = ID;
        this.ID_Examen = ID_Examen;
        this.Dato = Dato;
        this.Valor = Valor;
    }

    public int getID() {
        return ID;
    }

    public int getID_Examen() {
        return ID_Examen;
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
        this.ID_Examen = ID_Examen;
    }

    public void setDato(String Dato) {
        this.Dato = Dato;
    }

    public void setValor(String Valor) {
        this.Valor = Valor;
    }
 
}
