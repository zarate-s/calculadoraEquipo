/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadora;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Sebastian Zarate, Rodrigo Gonzalez, Maria Jose Domenzain, Montserrat Olivares
 */
public class MetodosTest {
    
    public MetodosTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of resultado method, of class Metodos.
     */
    @Test
    public void testResultado() {
        System.out.println("resultado");
        //Primer test
        String infija = "5 * ( 4 / ( 1 + 1 ) )";
        String expResult = "10.0";
        String result = Metodos.resultado(infija);
        assertEquals(expResult, result);
        
        //Segundo test
        infija = "8 * ( 7 * ( 1 - 1 ) )";
        expResult = "0.0";
        result = Metodos.resultado(infija);
        assertEquals(expResult, result);
        
        //Tercer test
        infija = "2 / ( 4 - ( 6 + 8 ) )";
        expResult = "-0.2";
        result = Metodos.resultado(infija);
        assertEquals(expResult, result);
    }

    /**
     * Test of aPostFija method, of class Metodos.
     */
    @Test
    public void testAPostFija() {
        System.out.println("aPostFija");
        //Primer test
        String infija = "5 * ( 4 / ( 1 + 1 ) )";
        String expResult = "5 4 1 1 + / * ";
        String result = Metodos.aPostFija(infija);
        assertEquals(expResult, result);
        
        //Segundo test
        infija = "8 * ( 7 * ( 1 - 1 ) )";
        expResult = "8 7 1 1 - * * ";
        result = Metodos.aPostFija(infija);
        assertEquals(expResult, result);
        
        //Tercer test
        infija = "2 / ( 4 - ( 6 + 8 ) )";
        expResult = "2 4 6 8 + - / ";
        result = Metodos.aPostFija(infija);
        assertEquals(expResult, result);
    }

    /**
     * Test of evaluarPostFija method, of class Metodos.
     */
    @Test
    public void testEvaluarPostFija() {
        System.out.println("evaluarPostFija");
        //Primer test
        String postfija = "5 4 1 1 + / * ";
        String expResult = "10.0";
        String result = Metodos.evaluarPostFija(postfija);
        assertEquals(expResult, result);
        
        //Segundo test
        postfija = "8 7 1 1 - * * ";
        expResult = "0.0";
        result = Metodos.evaluarPostFija(postfija);
        assertEquals(expResult, result);
        
        //Tercer test
        postfija = "2 4 6 8 + - / ";
        expResult = "-0.2";
        result = Metodos.evaluarPostFija(postfija);
        assertEquals(expResult, result);
    }

    /**
     * Test of ejecutaOperacion method, of class Metodos.
     */
    @Test
    public void testEjecutaOperacion() {
        System.out.println("ejecutaOperacion");
        //Primer test
        double op1 = 5.0;
        double op2 = 13.0;
        String token = "-";
        double expResult = 8.0;
        double result = Metodos.ejecutaOperacion(op1, op2, token);
        assertEquals(expResult, result, 0.0);
        
        //Segundo test
        op1 = 5.0;
        op2 = 10.0;
        token = "/";
        expResult = 2.0;
        result = Metodos.ejecutaOperacion(op1, op2, token);
        assertEquals(expResult, result, 0.0);
        
        //Tercer test
        op1 = 6.0;
        op2 = 7.0;
        token = "*";
        expResult = 42.0;
        result = Metodos.ejecutaOperacion(op1, op2, token);
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of prioridadOperador method, of class Metodos.
     */
    @Test
    public void testPrioridadOperador() {
        System.out.println("prioridadOperador");
        //Primer test
        String token = "(";
        int expResult = 1;
        int result = Metodos.prioridadOperador(token);
        assertEquals(expResult, result);
        
        //Segundo test
        token = "58.96";
        expResult = 0;
        result = Metodos.prioridadOperador(token);
        assertEquals(expResult, result);
        
        //Tercer test
        token = "*";
        expResult = 3;
        result = Metodos.prioridadOperador(token);
        assertEquals(expResult, result);
    }

    /**
     * Test of verificaParentesis method, of class Metodos.
     */
    @Test
    public void testVerificaParentesis() {
        System.out.println("verificaParentesis");
        //Primer test
        String expresion = ")85(";
        boolean expResult = false;
        boolean result = Metodos.verificaParentesis(expresion);
        assertEquals(expResult, result);
        
        //Segundo test
        expresion = "(8*(5+3))";
        expResult = true;
        result = Metodos.verificaParentesis(expresion);
        assertEquals(expResult, result);
        
        //Tercer test
        expresion = "(85*(-2)";
        expResult = false;
        result = Metodos.verificaParentesis(expresion);
        assertEquals(expResult, result);
    }
    
}
