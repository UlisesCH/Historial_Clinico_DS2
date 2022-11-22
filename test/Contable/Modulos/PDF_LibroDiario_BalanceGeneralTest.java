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
public class PDF_LibroDiario_BalanceGeneralTest {
    
    public PDF_LibroDiario_BalanceGeneralTest() {
    }

    @Test
    public void testPDFLibroDiario() {
        System.out.println("PDFLibroDiario");
        String ID_Libro = "5987";
        PDF_LibroDiario_BalanceGeneral instance = new PDF_LibroDiario_BalanceGeneral();
        instance.PDFLibroDiario(ID_Libro);
        
        boolean resultado = PDF_LibroDiario_BalanceGeneral.Tess;
        boolean resultadoEsperado = true;
        
        if(!(resultado == resultadoEsperado)){
            fail("The test case is a prototype.");
        }
    }

    @Test
    public void testPDFBalanceGeneral() {
        System.out.println("PDFBalanceGeneral");
        String ID_Libro = "5987";
        PDF_LibroDiario_BalanceGeneral instance = new PDF_LibroDiario_BalanceGeneral();
        instance.PDFBalanceGeneral(ID_Libro);
         boolean resultado = PDF_LibroDiario_BalanceGeneral.Tess;
        boolean resultadoEsperado = true;
        
        if(!(resultado == resultadoEsperado)){
            fail("The test case is a prototype.");
        }
    }
    
}
