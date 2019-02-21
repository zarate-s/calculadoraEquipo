/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadora;

import java.util.Scanner;

/**
 * Clase Metodos con metodos estaticos utiles para evaluacion de cadenas infijas.
 * @author Sebastian Zarate, Rodrigo Gonzalez, Maria Jose Domenzain, Montserrat Olivares
 */
public class Metodos {
    
    /**
     * <pre>
     * Metodo que consigue el resultado 
     * de una operacion aritmetica si el syntax es correcto.
     * </pre>
     * 
     * @param infija Cadena que representa operaciones aritmeticas en forma infija.
     * @return Resultado de una operacion aritmetica.
     * @see aPostFija evaluarPostfija
     */
    public static String resultado (String infija) {
        String res = "";
        if(verificaParentesis(infija))
            res = evaluarPostFija(aPostFija(infija));
        else
            res = " Syntax Error: Parentesis incorrectos ";
        
        return res;
    }
    
    /**
     * Metodo que convierte operaciones aritmeticas de la forma infija a forma postfija.
     * 
     * @param infija Cadena que representa operaciones aritmeticas en forma infija.
     * @return Regresa cadena que representa operaciones aritmetica en forma postfija.
     * 
     * @see prioridadOperador evaluarPostFija
     */
    public static String aPostFija (String infija) {
        StringBuilder postfija;
        PilaADT<String> pila;
        Scanner scan;
        String token;
        int prioridad;
        
        pila = new Pila<>();
        postfija = new StringBuilder();
        scan = new Scanner(infija);
        
        while(scan.hasNext()) {
            token = scan.next();
            prioridad = prioridadOperador(token);
            
            switch (prioridad) {
                case 0: postfija.append(token+" "); //es numero
                        break;
                        
                case 1: pila.push(token); //parentesis abre
                        break;
                        
                case 2: while(!pila.isEmpty() && prioridadOperador((String) pila.peek()) != 1) //parentesis cierra
                            postfija.append(pila.pop()+" ");
                        pila.pop();
                        break;
                default:while(!pila.isEmpty() && prioridad <= prioridadOperador((String) pila.peek()))//es operador
                            postfija.append(pila.pop() +" ");
                        pila.push(token);
            }
        }
        
        while(!pila.isEmpty())
            postfija.append(pila.pop()+" ");
        
        System.out.println("Postfija: "+postfija.toString()); //Imprime a consola cadena PostFija
        return postfija.toString();
    }
    
    /**
     * 
     * Metodo que evalua una cadena postFija y regresa un resultado.
     * 
     * @param postfija Cadena que representa operaciones aritmetica en forma postfija.
     * @return Cadena que representa valor Double de una operacion aritmetica.
     * 
     * @see aPostFija ejecutaOperacion
     */
    public static String evaluarPostFija (String postfija) {
        Pila<Double> pila;
        Scanner scan;
        String token = null, resultadoStr = null;
        double op1, op2, res;
        
        pila = new Pila<>();
        scan = new Scanner(postfija);
        
        try {
            while(scan.hasNext()) {
                token = scan.next();
                if(prioridadOperador(token) == 0) //si recibe un numero
                    pila.push(Double.parseDouble(token));
                else { //si recibe un operador
                    op1 = pila.pop();
                    op2 = pila.pop();
                    res = ejecutaOperacion(op1, op2, token);
                    pila.push(res);
                }
            }
            //pila llena de valor resultante
            res = pila.pop();
            if(pila.isEmpty())
                resultadoStr = String.valueOf(res);
            else //la pila tiene incongruencia entre cantidad de numeros y operadores
                resultadoStr = " Faltan operadores! ";
            
        } catch(EmptyCollectionException ecx) { //el metodo pila.pop mando error en el while por lo que faltan numeros u operadores
            resultadoStr = " Faltan numeros u operadores! ";
        } catch(NumberFormatException nfe) { //el formato de la cadena postfija es incorrecto (la entrada fue incorrecta)
            resultadoStr = " Syntax error! "+token;
        } catch(ArithmeticException ae) { //errores aritmeticos por lo general la division entre 0
            resultadoStr = " Error Aritmetico! ";
        }
        
        return resultadoStr;
    }
    
    /**
     * <pre>
     * Metodo que calcula resultado de operacion aritmetica 
     * entre dos operandos dado un operador.
     * </pre>
     * @param op2 Segundo operando para ejecutar operacion.
     * @param op1 Primer operando para ejecutar operacion.
     * @param token Operador usado para operacion.
     * @return Resultado de operacion entre dos operandos de acuerdo a operador.
     */
    //Se invierten op1 y op2 para funcionalidad requerida en evaluar postFija
    public static double ejecutaOperacion(double op2, double op1, String token) {
        Double res = null;
        
        switch (token.charAt(0)) {
            case '+': res = op1 + op2;
                      break;
            case '-': res = op1-op2;
                      break;
            case '/': res = op1/op2;
                      break;
            case '*': res = op1*op2;         
        }
        
        return res;
    }
    
    /**
     * Metodo que designa la prioridad de un token.
     * 
     * @param token Token que representa una parte de una operacion aritmetica.
     * @return <ul>
     *          <li> 4 si el token es un + o un -.
     *          <li> 3 si el token es un * o un /.
     *          <li> 2 si es un parentesis de apertura (.
     *          <li> 1 si es un parentesis de cerradura ).
     *          <li> 0 si el token es un numero.
     *         </ul>
     */
    public static int prioridadOperador (String token) {
        int prioridad;
        
        if (token.equals("+") || token.equals("-"))
            prioridad = 4;
        else if (token.equals("*") || token.equals("/"))
            prioridad = 3;
        else if (token.equals("("))
            prioridad = 1;
        else if (token.equals(")"))
            prioridad = 2;
        else
            prioridad = 0;
        
        return prioridad;
    }
    
    /**
     * Metodo que verifica una cadena infija si los parentesis son correctos.
     * @param expresion Cadena que representa operaciones aritmetica en forma infija.
     * @return <ul>
     *          <li> true: los parentesis son correctos en la expresion.
     *          <li> false: los parentesis son incorrectos en la expresion.
     *         </ul>
     */
    public static boolean verificaParentesis (String expresion) {
        boolean res;
        Pila<Character> pila;
        int j, i;
        
        res = false;
        pila = new Pila<>();
        i = 0;
        j=expresion.length();
        while(i<j){
          if(expresion.charAt(i)=='(')
              pila.push('(');
          else 
            if(expresion.charAt(i)==')'){
                try{
                    pila.pop();  
                }catch(Exception e){
                    i=j;
                    pila.push(')');
                }
            }
          i++;
        }
        
        return pila.isEmpty();
    }
}
