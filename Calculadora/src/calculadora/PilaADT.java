/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadora;



/**
 * Interface que representa la estructura algoritmica abstracta de Pila.
 * @author Sebastian Zarate, Rodrigo Gonzalez, Maria Jose Domenzain, Montserrat Olivares
 */
public interface PilaADT<T> {
    public void push(T dato);
    public T pop();
    public T peek();
    public boolean isEmpty();
}