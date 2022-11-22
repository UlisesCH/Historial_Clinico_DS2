/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package Login;

import java.util.Date;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ulise
 */
public class LoginTest {
    
    public LoginTest() {
    }

    @Test
    public void testLogin() {
        System.out.println("Login");
        Login instance = new Login();
        
        String Usuario;
        String Password;
        
        String UserexpResult;
        String PassexpResult;
        
        instance.jFormattedTextField1.setText("Admin");
        instance.jPasswordField1.setText("admin");
        
        UserexpResult = (String) instance.jFormattedTextField1.getText();
        PassexpResult = String.valueOf(instance.jPasswordField1.getPassword());
        
        instance.Login();
        
        boolean resultado = Login.Tess;
        boolean resultadoEsperado = true;
        
        Usuario = "Admin";
        Password = "admin";
        
        //Comapra las coincidencias
        assertEquals(Usuario, UserexpResult);
        assertEquals(Password, PassexpResult);

        assertEquals(resultadoEsperado, resultado);
        
        if(!(resultado == resultadoEsperado)){
            fail("The test case is a prototype.");
        }
        
    }

}
