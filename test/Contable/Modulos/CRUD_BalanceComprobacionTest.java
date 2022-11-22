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
public class CRUD_BalanceComprobacionTest {
    
    public CRUD_BalanceComprobacionTest() {
    }

    @Test
    public void testLlenarTabla() {
        System.out.println("LlenarTabla");
        CRUD_BalanceComprobacion.LlenarTabla();
        
        boolean resultado = CRUD_BalanceComprobacion.Tess;
        boolean resultadoEsperado = true;
        
        if(!(resultado == resultadoEsperado)){
            fail("The test case is a prototype.");
        }
    }

    @Test
    public void testInsertar() {
        System.out.println("Insertar");
        int IDLibro = 0;
        Double Ingresos = null;
        Double Costos = null;
        Double Gastos = null;
        CRUD_BalanceComprobacion.Insertar(IDLibro, Ingresos, Costos, Gastos);
        boolean resultado = CRUD_BalanceComprobacion.Tess;
        boolean resultadoEsperado = true;
        
        if(!(resultado == resultadoEsperado)){
            fail("The test case is a prototype.");
        }
    }

    @Test
    public void testModificar() {
        System.out.println("Modificar");
        int IDLibro = 0;
        Double Ingresos = null;
        Double Costos = null;
        Double Gastos = null;
        CRUD_BalanceComprobacion.Modificar(IDLibro, Ingresos, Costos, Gastos);
        boolean resultado = CRUD_BalanceComprobacion.Tess;
        boolean resultadoEsperado = true;
        
        if(!(resultado == resultadoEsperado)){
            fail("The test case is a prototype.");
        }
    }


    @Test
    public void testPDFComprobacion() {
        System.out.println("PDFComprobacion");
        String ID_Libro = "5987";
        CRUD_BalanceComprobacion instance = new CRUD_BalanceComprobacion();
        instance.PDFComprobacion(ID_Libro);
        boolean resultado = CRUD_BalanceComprobacion.Tess;
        boolean resultadoEsperado = true;
        
        if(!(resultado == resultadoEsperado)){
            fail("The test case is a prototype.");
        }
    }
    
}
