package umariana.caso4;

/**
 *
 * @author Nicolas Maya y Julian Ceballos
 */

//esta clase hace una excepcion por si se ingresa el mismo nombre mas de una vez en el programa

public class NombreDuplicadoException extends Exception {
    
    //indica un mensaje para que el usuario observe que ya se ingreso ese nombre
    
    public NombreDuplicadoException() {
        super("Ya existe un nuevo perro con ese nombre, intentelo nuevamnete");
    }
}