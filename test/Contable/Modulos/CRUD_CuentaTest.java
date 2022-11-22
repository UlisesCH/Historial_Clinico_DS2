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
public class CRUD_CuentaTest {
    
    public CRUD_CuentaTest() {
    }

    @Test
    public void testLlenarTabla() {
        System.out.println("LlenarTabla");
        CRUD_Cuenta.LlenarTabla();
        
        boolean resultado = CRUD_Cuenta.Tess;
        boolean resultadoEsperado = true;
        
        if(!(resultado == resultadoEsperado)){
            fail("The test case is a prototype.");
        }
        
    }

    @Test
    public void testInsertar() {
        System.out.println("Insertar");
        int IDPartida = 0;
        String GrupoCuenta = "";
        String TipoCuenta = "";
        String SubGrupoCuenta = "";
        String NombreCuenta = "";
        Double Monto = null;
        String TipoMovimiento = "";
        CRUD_Cuenta.Insertar(IDPartida, GrupoCuenta, TipoCuenta, SubGrupoCuenta, NombreCuenta, Monto, TipoMovimiento);
        
        boolean resultado = CRUD_Cuenta.Tess;
        boolean resultadoEsperado = true;
        
        if(!(resultado == resultadoEsperado)){
            fail("The test case is a prototype.");
        }
    }

    @Test
    public void testEliminarPorCuenta() {
        System.out.println("EliminarPorCuenta");
        int id = 0;
        CRUD_Cuenta.EliminarPorCuenta(id);
        
        boolean resultado = CRUD_Cuenta.Tess;
        boolean resultadoEsperado = true;
        
        if(!(resultado == resultadoEsperado)){
            fail("The test case is a prototype.");
        }
    }

    @Test
    public void testEliminarPorPartida() {
        System.out.println("EliminarPorPartida");
        int id = 0;
        CRUD_Cuenta.EliminarPorPartida(id);
        
        boolean resultado = CRUD_Cuenta.Tess;
        boolean resultadoEsperado = true;
        
        if(!(resultado == resultadoEsperado)){
            fail("The test case is a prototype.");
        }
    }
    
}
