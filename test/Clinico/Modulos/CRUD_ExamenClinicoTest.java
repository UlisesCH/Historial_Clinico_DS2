/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package Clinico.Modulos;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ulise
 */
public class CRUD_ExamenClinicoTest {
    
    public CRUD_ExamenClinicoTest() {
    }

    @Test
    public void testLlenarTabla() {
        System.out.println("LlenarTabla");
        CRUD_ExamenClinico.LlenarTabla();
        
        boolean resultado = CRUD_ExamenClinico.Tess;
        boolean resultadoEsperado = true;
        
        if(!(resultado == resultadoEsperado)){
            fail("The test case is a prototype.");
        }
    }

    @Test
    public void testInsertar() {
        System.out.println("Insertar");
        int ID_Recibo = 0;
        String Nombre_Examen = "";
        Double Precio_Examen = null;
        int PosC = 0;
        CRUD_ExamenClinico.Insertar(ID_Recibo, Nombre_Examen, Precio_Examen, PosC);
        
        boolean resultado = CRUD_ExamenClinico.Tess;
        boolean resultadoEsperado = true;
        
        if(!(resultado == resultadoEsperado)){
            fail("The test case is a prototype.");
        }
    }

    @Test
    public void testEliminar() {
        System.out.println("Eliminar");
        int ID_Recibo = 0;
        CRUD_ExamenClinico.Eliminar(ID_Recibo);
        
        boolean resultado = CRUD_ExamenClinico.Tess;
        boolean resultadoEsperado = true;
        
        if(!(resultado == resultadoEsperado)){
            fail("The test case is a prototype.");
        }
    }

}
