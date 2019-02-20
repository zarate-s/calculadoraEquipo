/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadora;

/**
 * Clase Pila que representa estructura de datos Pila.
 * @author Sebastian Zarate, Rodrigo Gonzalez, Maria Jose Domenzain, Montserrat Olivares
 */
public class Pila <T> implements PilaADT <T>{
    private T[] pila;
    private int tope;
    private final int MAX = 20;

    /**
     * Crea una pila vacia.
     */
    public Pila(){
        pila = (T[])new Object[MAX];
        tope = -1;
    }

    /**
     * Agrega un objeto al tope de la pila.
     * 
     * @param dato Dato a ingresar en la pila del mismo tipo que la pila.
     */
    @Override
    public void push(T dato) {
        if(tope+1 == pila.length)
            expande();
        tope++;
        pila[tope] = dato;
        
    }

    /**
     * Remueve el objeto del tope de la pila.
     * 
     * @return Regresa el valor removida del tope de la pila.
     */
    @Override
    public T pop() {
        T resultado;
        
        if(isEmpty())
            throw new EmptyCollectionException();    

        resultado = pila[tope];
        pila[tope] = null;
        tope--;
        
        return resultado;
    }

    /**
     * <pre>
     *  Regresa el elemento de la pila si
     *  pila.isEmpty() regresa false.
     * </pre>
     * @see isEmpty
     *  
     * @return Dato al tope de la pila.
     */
    @Override
    public T peek() {
        if(isEmpty())
            throw new EmptyCollectionException();    
        
        return pila[tope];
    }

    /**
     * Evalua si la pila esta vacia o no.
     * 
     * @return <ul>
     *          <li> true: la pila esta vacia.
     *          <li> false: la pila no esta vacia.
     *         </ul>
     */
    @Override
    public boolean isEmpty() {
        return tope == -1;
    }

    private void expande(){
        T[] nuevo = (T[]) new Object[pila.length*2];
        
        for(int i = 0;i <= tope; i++)
            nuevo[i]= pila[i];
        
        pila = nuevo;
    }

}