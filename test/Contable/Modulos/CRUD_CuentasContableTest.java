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
public class CRUD_CuentasContableTest {
    
    public CRUD_CuentasContableTest() {
    }

    @Test
    public void testLlenarTabla() {
        System.out.println("LlenarTabla");
        CRUD_CuentasContable.LlenarTabla();
        boolean resultado = CRUD_CuentasContable.Tess;
        boolean resultadoEsperado = true;
        
        if(!(resultado == resultadoEsperado)){
            fail("The test case is a prototype.");
        }
    }

    @Test
    public void testInsertar() {
        System.out.println("Insertar");
        String TipoCuenta = "";
        String GrupoCuenta = "";
        String SubGrupoCuenta = "";
        String NombreCuenta = "";
        CRUD_CuentasContable.Insertar(TipoCuenta, GrupoCuenta, SubGrupoCuenta, NombreCuenta);
        
        boolean resultado = CRUD_CuentasContable.Tess;
        boolean resultadoEsperado = true;
        
        if(!(resultado == resultadoEsperado)){
            fail("The test case is a prototype.");
        }
        
    }

    @Test
    public void testEliminar() {
        System.out.println("Eliminar");
        int id = 0;
        CRUD_CuentasContable.Eliminar(id);
        boolean resultado = CRUD_CuentasContable.Tess;
        boolean resultadoEsperado = true;
        
        if(!(resultado == resultadoEsperado)){
            fail("The test case is a prototype.");
        }
    }
    
}
