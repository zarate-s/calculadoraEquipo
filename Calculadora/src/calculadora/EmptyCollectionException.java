/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadora;

/**
 * Clase EmptyCollectionException para representar el error asociado con la clase pila cuando esta vacia.
 * @author Sebastian Zarate, Rodrigo Gonzalez, Maria Jose Domenzain, Montserrat Olivares
 */
public class EmptyCollectionException extends RuntimeException {

  /**
   * Constructor vacio que manda mensaje "Collection is empty"
   */
  public EmptyCollectionException() {
    super("Collection is empty");
  }
  
  /**
   * Constructor para mandar un mensaje al usuario
   * @param mensaje Mensaje mandado por la exception
   */
  public EmptyCollectionException (String mensaje) {
    super(mensaje);
  }
}
