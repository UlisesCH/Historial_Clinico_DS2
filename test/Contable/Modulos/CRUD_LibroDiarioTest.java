/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package Contable.Modulos;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ulise
 */
public class CRUD_LibroDiarioTest {
    
    public CRUD_LibroDiarioTest() {
    }

    @Test
    public void testLlenarTabla() {
        System.out.println("LlenarTabla");
        CRUD_LibroDiario.LlenarTabla();
        boolean resultado = CRUD_LibroDiario.Tess;
        boolean resultadoEsperado = true;
        
        if(!(resultado == resultadoEsperado)){
            fail("The test case is a prototype.");
        }
    }

    @Test
    public void testInsertar() {
        System.out.println("Insertar");
        String Nombre = "";
        String FechaInicio = "";
        String FechaFinal = "";
        CRUD_LibroDiario.Insertar(Nombre, FechaInicio, FechaFinal);
        boolean resultado = CRUD_LibroDiario.Tess;
        boolean resultadoEsperado = true;
        
        if(!(resultado == resultadoEsperado)){
            fail("The test case is a prototype.");
        }
    }

    @Test
    public void testEliminar() {
        System.out.println("Eliminar");
        int id = 0;
        CRUD_LibroDiario.Eliminar(id);
        boolean resultado = CRUD_LibroDiario.Tess;
        boolean resultadoEsperado = true;
        
        if(!(resultado == resultadoEsperado)){
            fail("The test case is a prototype.");
        }
    }
    
}
