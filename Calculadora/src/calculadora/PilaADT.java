/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadora;

/**
 *
 * @author edi
 */
public interface PilaADT<T> {
  abstract public void push(T dato);
  abstract public T pop() throws EmptyCollectionException;
  abstract public T peek() throws EmptyCollectionException;
  abstract public boolean isEmpty();
}
