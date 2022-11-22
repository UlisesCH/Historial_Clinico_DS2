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
public class CRUD_LibroMayorTest {
    
    public CRUD_LibroMayorTest() {
    }

    @Test
    public void testLlenarTabla() {
        System.out.println("LlenarTabla");
        CRUD_LibroMayor.LlenarTabla();
        boolean resultado = CRUD_LibroMayor.Tess;
        boolean resultadoEsperado = true;
        
        if(!(resultado == resultadoEsperado)){
            fail("The test case is a prototype.");
        }
    }

    @Test
    public void testInsertar() {
        System.out.println("Insertar");
        int IDLibro = 0;
        String Grupo_Cuenta = "";
        String SubGrupo_Cuenta = "";
        String Nombre_Cuenta = "";
        Double MontoTotal = null;
        CRUD_LibroMayor.Insertar(IDLibro, Grupo_Cuenta, SubGrupo_Cuenta, Nombre_Cuenta, MontoTotal);
        boolean resultado = CRUD_LibroMayor.Tess;
        boolean resultadoEsperado = true;
        
        if(!(resultado == resultadoEsperado)){
            fail("The test case is a prototype.");
        }
    }

    @Test
    public void testModificar() {
        System.out.println("Modificar");
        int ID = 0;
        int IDLibro = 0;
        String Grupo_Cuenta = "";
        String SubGrupo_Cuenta = "";
        String Nombre_Cuenta = "";
        Double MontoTotal = null;
        CRUD_LibroMayor.Modificar(ID, IDLibro, Grupo_Cuenta, SubGrupo_Cuenta, Nombre_Cuenta, MontoTotal);
        boolean resultado = CRUD_LibroMayor.Tess;
        boolean resultadoEsperado = true;
        
        if(!(resultado == resultadoEsperado)){
            fail("The test case is a prototype.");
        }
    }

   
    @Test
    public void testPDFLibroMayor() {
        System.out.println("PDFLibroMayor");
        String ID_LibroDato = "5987";
        CRUD_LibroMayor instance = new CRUD_LibroMayor();
        instance.PDFLibroMayor(ID_LibroDato);
       boolean resultado = CRUD_LibroMayor.Tess;
        boolean resultadoEsperado = true;
        
        if(!(resultado == resultadoEsperado)){
            fail("The test case is a prototype.");
        }
    }
    
}
