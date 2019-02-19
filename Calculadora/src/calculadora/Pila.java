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
public class Pila <T> implements PilaADT {
  private T pila[];
  private int tope;
  private final int MAX = 20;

  public Pila() {
    pila = (T []) new Object[MAX];
    tope = -1;
  }
  
  public Pila (int max) {
    pila = (T []) new Object[max];
    tope = -1;
  }
  
  @Override
  public void push(Object dato) {
    if(tope+1 == pila.length)
      expande();
    tope++;
    pila[tope] = (T) dato;
  }

  @Override
  public Object pop() throws EmptyCollectionException{
    T dato;
    
    if(!this.isEmpty()) {
      dato = pila[tope];
      pila[tope] = null;
      tope--;
    } else
      throw new EmptyCollectionException();
    
    return dato;
  }

  @Override
  public Object peek() throws EmptyCollectionException{
    T dato;
    
    if(!this.isEmpty())
      dato = pila[tope];
    else
      throw new EmptyCollectionException();
    return dato;
  }

  @Override
  public boolean isEmpty() {
    return tope == -1;
  }

  private void expande() {
    T[] nuevo = (T[]) new Object[pila.length*2];
    
    for(int i = 0; i < tope; i++)
      nuevo[i] = pila[i];
    pila = nuevo;
  }
  
  public int size() {
    return tope;
  }
}
