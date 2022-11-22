/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package Clinico.Controladores;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ulise
 */
public class ConexionTest {
    
    public ConexionTest() {
    }

    @Test
    public void testCrearTablas() {
        System.out.println("CrearTablas");
        boolean expResult = false;
        boolean result = Conexion.CrearTablas();
        assertEquals(expResult, result);
       
        if(!(result == expResult)){
            fail("The test case is a prototype.");
        }
    }
    
}
