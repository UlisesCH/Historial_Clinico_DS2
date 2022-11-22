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
public class CRUD_ReciboTest {
    
    public CRUD_ReciboTest() {
    }

    @Test
    public void testLlenarTabla() {
        System.out.println("LlenarTabla");
        CRUD_Recibo.LlenarTabla();
        fail("The test case is a prototype.");
    }

    @Test
    public void testBuscarEnTabla() {
        System.out.println("BuscarEnTabla");
        String buscar = "";
        CRUD_Recibo.BuscarEnTabla(buscar);
        fail("The test case is a prototype.");
    }

    @Test
    public void testInsertar() {
        System.out.println("Insertar");
        String Nombre_Cliente = "";
        int Edad_Cliente = 0;
        Double PrecioTotal_Examen = null;
        String Fecha = "";
        CRUD_Recibo.Insertar(Nombre_Cliente, Edad_Cliente, PrecioTotal_Examen, Fecha);
        fail("The test case is a prototype.");
    }

    @Test
    public void testEliminar() {
        System.out.println("Eliminar");
        int ID = 0;
        CRUD_Recibo.Eliminar(ID);
        fail("The test case is a prototype.");
    }
    
}
