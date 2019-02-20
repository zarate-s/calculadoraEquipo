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
public class Pila <T> implements PilaADT <T>{
    private T[] pila;
    private int tope;
    private final int MAX=20;

    public Pila(){
        pila=(T[])new Object[MAX];
        tope=-1;
    }
    private void expande(){
    T[] nuevo=(T[])new Object[pila.length*2];
    for(int i=0;i<=tope;i++)
        nuevo[i]=pila[i];
    pila=nuevo;
    }
    
    /*public void multiPop(int n){
        if(isEmpty()){
            throw new EmptyCollectionException();
        }
        else 
            if(n>tope){
               for(tope=tope;tope>=0;tope--){
            T resul;
        resul=pila[tope];
        pila[tope]=null;
        }
            }
            
        else 
            if(n<=tope){
            int j=tope-n;
        for(tope=tope;tope>=j;tope--){
            T resul;
        resul=pila[tope];
        pila[tope]=null;
        }
        }
    }*/

    @Override
    public void push(T dato) {
        if(tope+1==pila.length)
            expande();
        tope++;
        pila[tope]=dato;
        
    }

    @Override
    public T pop() {
        
        if(isEmpty())
        throw new EmptyCollectionException();    
        
        T resul;
        resul=pila[tope];
        pila[tope]=null;
        tope--;
        return resul;
        
    }

    @Override
    public T peek() {
        if(isEmpty())
            throw new EmptyCollectionException();    
        return pila[tope];
    }

    @Override
    public boolean isEmpty() {
        return tope==-1;
    }

}