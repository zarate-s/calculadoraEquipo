/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadora;

import java.util.Scanner;

/**
 *
 * @author sebas
 */
public class Metodos {
    public static String resultado (String expresion) {
        String res = "";
        if(verificaParentesis(expresion))
            res = evaluarPostFija(aPostFija(expresion));
        else
            res = " Syntax Error: Parentesis incorrectos ";
        return res;
    }
    
    private static String aPostFija (String infija) {
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
        System.out.println("Postfija: "+postfija.toString());
        return postfija.toString();
    }
    
    private static String evaluarPostFija (String postfija) {
        Pila<Double> pila;
        Scanner scan;
        String token = null, resultadoStr = null;
        double op1, op2, res;
        
        pila = new Pila<>();
        scan = new Scanner(postfija);
        
        try {
            while(scan.hasNext()) {
                token = scan.next();
                if(prioridadOperador(token) == 0)
                    pila.push(Double.parseDouble(token));
                else {
                    op1 = (Double) pila.pop();
                    op2 = (Double) pila.pop();
                    res = ejecutaOperacion(op1, op2, token);
                    pila.push(res);
                }
            }
            res = (Double) pila.pop();
            if(pila.isEmpty())
                resultadoStr = String.valueOf(res);
            else
                resultadoStr = " Faltan operadores! ";
        } catch(EmptyCollectionException ecx) {
            resultadoStr = " Faltan operadores! ";
        } catch(NumberFormatException nfe) {
            resultadoStr = " Syntax error! "+token;
        } catch(ArithmeticException ae) {
            resultadoStr = " Division entre 0! ";
        }
        
        return resultadoStr;
    }
    
    private static double ejecutaOperacion(double op1, double op2, String token) throws ArithmeticException {
        double res = 0;
        
        switch (token.charAt(0)) {
            case '+': res = op2 + op1;
                      break;
            case '-': res = op2-op1;
                      break;
            case '/': if(op2 == 0)
                        throw new ArithmeticException();
                      else
                        res = op1/op2;
                      break;
            case '*': res = op2*op1;         
        }
        return res;
    }
    
    /**
     * 
     * @param caracter
     * @return 
     */
    private static int prioridadOperador (String caracter) {
        int prioridad;
        
        if (caracter.equals("+") || caracter.equals("-"))
            prioridad = 4;
        else if (caracter.equals("*") || caracter.equals("/"))
            prioridad = 3;
        else if (caracter.equals("("))
            prioridad = 1;
        else if (caracter.equals(")"))
            prioridad = 2;
        else
            prioridad = 0;
        return prioridad;
    }
    
    private static boolean verificaParentesis (String expresion) {
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
