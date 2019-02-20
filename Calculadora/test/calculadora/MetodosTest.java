/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadora;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author sebas
 */
public class MetodosTest {
    
    public MetodosTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of resultado method, of class Metodos.
     */
    @Test
    public void testResultado() {
        System.out.println("resultado");
        String infija = "(25*14)";
        String expResult = "350.0";
        String result = Metodos.resultado(infija);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of aPostFija method, of class Metodos.
     */
    @Test
    public void testAPostFija() {
        System.out.println("aPostFija");
        String infija = "(25*14)";
        String expResult = "2514*";
        String result = Metodos.aPostFija(infija);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of evaluarPostFija method, of class Metodos.
     */
    @Test
    public void testEvaluarPostFija() {
        System.out.println("evaluarPostFija");
        String postfija = "2514*";
        String expResult = "350.0";
        String result = Metodos.evaluarPostFija(postfija);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of ejecutaOperacion method, of class Metodos.
     */
    @Test
    public void testEjecutaOperacion() {
        System.out.println("ejecutaOperacion");
        double op1 = 25.0;
        double op2 = 14.0;
        String token = "*";
        double expResult = 350.0;
        double result = Metodos.ejecutaOperacion(op1, op2, token);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of prioridadOperador method, of class Metodos.
     */
    @Test
    public void testPrioridadOperador() {
        System.out.println("prioridadOperador");
        String caracter = "25";
        int expResult = 0;
        int result = Metodos.prioridadOperador(caracter);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of verificaParentesis method, of class Metodos.
     */
    @Test
    public void testVerificaParentesis() {
        System.out.println("verificaParentesis");
        String expresion = "(25*14)";
        boolean expResult = true;
        boolean result = Metodos.verificaParentesis(expresion);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }
    
}
