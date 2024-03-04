package umariana.caso4;

//importar librerias
import Mundo.Perro;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/**
 *
 * @author Nicolas Maya y Julian Ceballos
 */

public class Caso4 {
    
    //crear una contenedora variable 
    ArrayList<Perro>misPerros =new ArrayList<>();
    Scanner lector=new Scanner (System.in);
    

    public static void main(String[] args) {
        
        Caso4 expo = new Caso4();
        
        expo.mostrarMenu();

    }
    
        //METODOS
    //muestra el menu principal de todos los metodos  
    
    public void mostrarMenu(){
        boolean activo=true;
        do{
            
           System.out.println("======= Exposicion Caninaq =======");
           System.out.println("1. Agregar un nuevo perro");
           System.out.println("2. Mostrar perros");
           System.out.println("3. Modificar perro");
           System.out.println("4. Eliminar perro");
           System.out.println("5. Perro ganador");
           System.out.println("6. Perro con menor puntaje");
           System.out.println("7. Perro con mayor edad");
           System.out.println("8. Salir");
           System.out.println("_");
           
           int opcion = lector.nextInt();
           switch (opcion){
               
               //se llama a los metodos en el switch
               
               case 1:
                   
                   //se crea un try y catch por la excepcion que se hizo en otra clase
                   try{
                       agregarPerro();
                   }catch (NombreDuplicadoException e){
                       System.out.println(e.getMessage());
                   }

                   break;
                   
               case 2:
                   mostrarPerros();
                   break;
                   
               case 3:
                   modificarPerro();
                   break;
                   
               case 4:
                   eliminarPerro();
                   break;
                   
               case 5:
                   mostrarPerroGanador();
                   break;
                   
               case 6:
                   mostrarPerroMenorPuntaje();
                   break;
                   
               case 7:
                   mostrarPerroConMayorEdad();
                   break;
                   
               case 8:
                   
                   activo = false;
                   System.out.println("Programa finalizado");
                    
                   break;
                   
               default:
                   
                   System.out.println("Opcion no valida, intentelo nuevamente");
            }
            
        }while(activo);     
    }
    
    //metodo creado con exceprion del nombre del perro
    
    public void agregarPerro() throws NombreDuplicadoException {
        
        //ingresa el nombre del perro
        System.out.println("Ingrese el nombre del perro:");
        lector.nextLine(); String nombre = lector.nextLine();
        
        if(!misPerros.isEmpty()){
            
            for(Perro p: misPerros){
                
                if(p.getNombre().equalsIgnoreCase(nombre)){
                    
                    throw new NombreDuplicadoException ();
                }
            }
        
        }
        
        //Insertar datos o los atributos del perro para luego almacenarlos en la contenedora
        //ingresa la raza
        System.out.println("Ingrese la raza");
        String raza=lector.nextLine();
        
        //ingresa la edad del perro
        System.out.println("Ingrese la edad");
        int edad=lector.nextInt();
        
        //ingresa una foto del perro
        System.out.println("Ingrese la foto");
        lector.nextLine();String foto=lector.nextLine();
        
        //ingresa los puntos otorgados al perro
        System.out.println("Ingrese los puntos");
        int puntos=lector.nextInt();
        

        
        //crea el objeto y llena la información
        Perro nuevoPerro=new Perro(nombre, raza, edad, puntos, foto);
        
        //almacena el objeto en la contenedora
        misPerros.add(nuevoPerro); 
    
    }

    
    public void mostrarPerros (){
        
        //el programa indica un nuevo menu para el metodo de mostrar perros
        //para ordenarlos como el usuario lo elija: normalmente, por raza, por puntos o por edad.
        
        System.out.println("1. Mostrar perros ingresados.");
        System.out.println("2. Mostrar perros ordenados por raza.");
        System.out.println("3. Mostrar perros ordenados por puntos.");
        System.out.println("4. Mostrar perros ordenados por edad.");
        
        int option = lector.nextInt();
        
        //creacion del menu para mostrar a los perros
        switch (option){
            
            //muestra a los perros 
            case 1:
                for(Perro p: misPerros)
                {  
                  System.out.println("Nombre: "+p.getNombre());
                  System.out.println("Foto: "+p.getFoto());
                  System.out.println("Raza: "+p.getRaza());
                  System.out.println("Edad: "+p.getEdad());
                  System.out.println("Puntos: "+p.getPuntos());
                  System.out.println("----------------------------------");
                }
                break;
                
                //muestra a los perros ordenados por su raza
            case 2:
                 //ordena a los perros por raza por medio de un collections
        Comparator<Perro> comparadorRaza = new Comparator<Perro>() {
        @Override
        public int compare(Perro p1, Perro p2) {
            return p1.getRaza().compareTo(p2.getRaza());
        }
         }; Collections.sort(misPerros, comparadorRaza);
               for(Perro p: misPerros) {
               System.out.println("Nombre: "+p.getNombre());
               System.out.println("Foto: "+p.getFoto());
               System.out.println("Raza: "+p.getRaza());
               System.out.println("Edad: "+p.getEdad());
               System.out.println("Puntos: "+p.getPuntos());
               System.out.println("----------------------------------");
            }
            
                break;
                
            case 3:
                //ordena los perros por puntos otorgados
                Collections.sort(misPerros, new Comparator<Perro>() {
                @Override
                public int compare(Perro p1, Perro p2) {
                    return Integer.compare(p1.getPuntos(), p2.getPuntos());
                }
               });

               //muestra a los perros ordenados por puntos otorgados
               System.out.println("Perros ordenados por puntos:");
               for (Perro perro : misPerros) {
                System.out.println("Nombre: " + perro.getNombre());
                System.out.println("Foto: " + perro.getFoto());
                System.out.println("Raza: " + perro.getRaza());
                System.out.println("Edad: " + perro.getEdad());
                System.out.println("Puntos: " + perro.getPuntos());
                System.out.println("----------------------------------");   
            }
               break;
               
               // ordena los perros por su edad
            case 4:
                 Collections.sort(misPerros, new Comparator<Perro>() {
                 @Override
                 public int compare(Perro p1, Perro p2) {
                 return Integer.compare(p1.getEdad(), p2.getEdad());
                 }
                 });

                 // Mostrar perros ordenados por edad
                 System.out.println("Perros ordenados por edad:");
                 for (Perro perro : misPerros) {
                 System.out.println("Nombre: " + perro.getNombre());
                 System.out.println("Foto: " + perro.getFoto());
                 System.out.println("Raza: " + perro.getRaza());
                 System.out.println("Edad: " + perro.getEdad());
                 System.out.println("Puntos: " + perro.getPuntos());
                 System.out.println("----------------------------------");
                 }
                break;
                
                default:
                   
                   System.out.println("Opcion no válida, intentelo nuevamente");
                     
        }
        
      }
    
    public void modificarPerro() {
        // se pide al usuario modificar el perro por algo que es unico el nombre
        System.out.println("Ingrese el nombre del perro que desea modificar:");
        Scanner scanner = new Scanner(System.in);
        String nombre = scanner.nextLine();

        //recorre la contenedora para ver todos los perros
         Perro perroEncontrado = null;
         for (Perro perro : misPerros) {
        if (perro.getNombre().equals(nombre)) {
            perroEncontrado = perro;
            break;
        }
     }

         //si no se encuentra el nombre del perro ingresado se lanza un mensaje
         if (perroEncontrado == null) {
        System.out.println("No se encontro ningun perro con el nombre " + nombre);
        return;
      }

        // si se ingresa el nombre correctamente se podra modificar los datos del perro
        System.out.println("Ingrese la nueva raza:");
        String nuevaRaza = scanner.nextLine();
        perroEncontrado.setRaza(nuevaRaza);
 
       System.out.println("Ingrese la nueva edad:");
        int nuevaEdad = scanner.nextInt();
        perroEncontrado.setEdad(nuevaEdad);

        System.out.println("Ingrese los nuevos puntos:");
       int nuevosPuntos = scanner.nextInt();
        perroEncontrado.setPuntos(nuevosPuntos);

         System.out.println("El perro con nombre " + nombre + " ha sido modificado correctamente.");
}
    
    public void eliminarPerro() {
        System.out.println("Ingrese el nombre del perro que desea eliminar:");
        Scanner scanner = new Scanner(System.in);
        String nombre = scanner.nextLine();

        //recorre la contenedora para buscar por el nombre al perro que se dea eliminar
        Perro perroEncontrado = null;
         for (Perro perro : misPerros) {
        if (perro.getNombre().equals(nombre)) {
            perroEncontrado = perro;
            break;
        }
       }

        if (perroEncontrado == null) {
        System.out.println("No se encontro ningun perro con el nombre " + nombre);
        return;
      }
 
        //borra el perro con el nombre ingresado
         misPerros.remove(perroEncontrado);
         System.out.println("El perro con nombre " + nombre + " ha sido eliminado correctamente.");
   }
    
    
    public void mostrarPerroGanador() {
         if (misPerros.isEmpty()) {
        System.out.println("No hay ningun perro registrado.");
        return;
    }

        //recorre la contenedora para buscar el perro que tenga mayor puntuacion
          Perro perroGanador = misPerros.get(0);
          for (Perro perro : misPerros) {
          if (perro.getPuntos() > perroGanador.getPuntos()) {
            perroGanador = perro;
        }
      }

         //muestra todos los datos del perro ganador
          System.out.println("Perro ganador:");
          System.out.println("Nombre: " + perroGanador.getNombre());
          System.out.println("Foto: " + perroGanador.getFoto());
          System.out.println("Raza: " + perroGanador.getRaza());
          System.out.println("Edad: " + perroGanador.getEdad());
          System.out.println("Puntos: " + perroGanador.getPuntos());
          System.out.println("----------------------------------");
    }
    
    
    
    public void mostrarPerroMenorPuntaje() {
    if (misPerros.isEmpty()) {
        System.out.println("No hay ningun perro registrado.");
        return;
    }

    //recorre la contenedora para encontrar el perro con menor puntaje
    Perro perroMenorPuntaje = misPerros.get(0);
    for (Perro perro : misPerros) {
        if (perro.getPuntos() < perroMenorPuntaje.getPuntos()) {
            perroMenorPuntaje = perro;
        }
    }

    //muestra todos los datos del perro con menor puntaje
    System.out.println("Perro con menor puntaje:");
    System.out.println("Nombre: " + perroMenorPuntaje.getNombre());
    System.out.println("Foto: " + perroMenorPuntaje.getFoto());
    System.out.println("Raza: " + perroMenorPuntaje.getRaza());
    System.out.println("Edad: " + perroMenorPuntaje.getEdad());
    System.out.println("Puntos: " + perroMenorPuntaje.getPuntos());
    System.out.println("----------------------------------");
    }
    
    
    
    public void mostrarPerroConMayorEdad() {
    if (misPerros.isEmpty()) {
        System.out.println("No hay perros registrados en la exposición.");
        return;
    }

    //recorre la contenedora para ver el perro con mayor edad
    Perro perroMayorEdad = misPerros.get(0);
    for (Perro perro : misPerros) {
        if (perro.getEdad() > perroMayorEdad.getEdad()) {
            perroMayorEdad = perro;
        }
    }

    //muetra los dastos del perro que tiene mayor edad
    System.out.println("Perro con mayor edad:");
    System.out.println("Nombre: " + perroMayorEdad.getNombre());
    System.out.println("Foto: " + perroMayorEdad.getFoto());
    System.out.println("Raza: " + perroMayorEdad.getRaza());
    System.out.println("Edad: " + perroMayorEdad.getEdad());
    System.out.println("Puntos: " + perroMayorEdad.getPuntos());
    System.out.println("----------------------------------");
    }

}