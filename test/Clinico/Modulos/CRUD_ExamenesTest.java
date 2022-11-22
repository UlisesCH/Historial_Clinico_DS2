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
public class CRUD_ExamenesTest {
    
    public CRUD_ExamenesTest() {
    }

    @Test
    public void testLlenarTabla() {
        System.out.println("LlenarTabla");
        CRUD_Examenes.LlenarTabla();
        
        boolean resultado = CRUD_Examenes.Tess;
        boolean resultadoEsperado = true;
        
        if(!(resultado == resultadoEsperado)){
            fail("The test case is a prototype.");
        }
        
    }

    @Test
    public void testInsertar() {
        System.out.println("Insertar");
        String Nombre_Examen = "";
        String Rango_Muestra = "";
        Double Precio_Examen = null;
        CRUD_Examenes.Insertar(Nombre_Examen, Rango_Muestra, Precio_Examen);
        
        boolean resultado = CRUD_Examenes.Tess;
        boolean resultadoEsperado = true;
        
        if(!(resultado == resultadoEsperado)){
            fail("The test case is a prototype.");
        }
    }

    @Test
    public void testEliminar() {
        System.out.println("Eliminar");
        int ID = 0;
        CRUD_Examenes.Eliminar(ID);
        
        boolean resultado = CRUD_Examenes.Tess;
        boolean resultadoEsperado = true;
        
        if(!(resultado == resultadoEsperado)){
            fail("The test case is a prototype.");
        }
    }

    @Test
    public void testModificar() {
        System.out.println("Modificar");
        int ID = 0;
        String Nombre_Examen = "";
        String Rango_Muestra = "";
        Double Precio_Examen = null;
        CRUD_Examenes.Modificar(ID, Nombre_Examen, Rango_Muestra, Precio_Examen);
        
        boolean resultado = CRUD_Examenes.Tess;
        boolean resultadoEsperado = true;
        
        if(!(resultado == resultadoEsperado)){
            fail("The test case is a prototype.");
        }
    }
    
}
