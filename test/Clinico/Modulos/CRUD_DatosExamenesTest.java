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
public class CRUD_DatosExamenesTest {
    
    public CRUD_DatosExamenesTest() {
    }

    @Test
    public void testLlenarTablaDatos() {
        System.out.println("LlenarTablaDatos");
        CRUD_DatosExamenes.LlenarTablaDatos();
        boolean resultado = CRUD_DatosExamenes.Tess;
        boolean resultadoEsperado = true;
        
        if(!(resultado == resultadoEsperado)){
            fail("The test case is a prototype.");
        }
    }

    @Test
    public void testLlenarListaDatosExamenes() {
        System.out.println("LlenarListaDatosExamenes");
        CRUD_DatosExamenes.LlenarListaDatosExamenes();
        boolean resultado = CRUD_DatosExamenes.Tess;
        boolean resultadoEsperado = true;
        
        if(!(resultado == resultadoEsperado)){
            fail("The test case is a prototype.");
        }
    }

    @Test
    public void testInsertarDatos() {
        System.out.println("InsertarDatos");
        int ID_Examen = 0;
        String Dato = "";
        String Unidad = "";
        CRUD_DatosExamenes.InsertarDatos(ID_Examen, Dato, Unidad);
        boolean resultado = CRUD_DatosExamenes.Tess;
        boolean resultadoEsperado = true;
        
        if(!(resultado == resultadoEsperado)){
            fail("The test case is a prototype.");
        }
    }

    @Test
    public void testInsertarValorDatos() {
        System.out.println("InsertarValorDatos");
        int ID_ExamenClinico = 0;
        String Dato = "";
        String Valor = "";
        String Unidad = "";
        CRUD_DatosExamenes.InsertarValorDatos(ID_ExamenClinico, Dato, Valor, Unidad);
        boolean resultado = CRUD_DatosExamenes.Tess;
        boolean resultadoEsperado = true;
        
        if(!(resultado == resultadoEsperado)){
            fail("The test case is a prototype.");
        }
    }

    @Test
    public void testEliminar() {
        System.out.println("Eliminar");
        int ID = 0;
        CRUD_DatosExamenes.Eliminar(ID);
        boolean resultado = CRUD_DatosExamenes.Tess;
        boolean resultadoEsperado = true;
        
        if(!(resultado == resultadoEsperado)){
            fail("The test case is a prototype.");
        }
    }

    @Test
    public void testEliminarValorDatos() {
        System.out.println("EliminarValorDatos");
        int ID_ExamenClinico = 0;
        CRUD_DatosExamenes.EliminarValorDatos(ID_ExamenClinico);
        boolean resultado = CRUD_DatosExamenes.Tess;
        boolean resultadoEsperado = true;
        
        if(!(resultado == resultadoEsperado)){
            fail("The test case is a prototype.");
        }
    }

    
}
