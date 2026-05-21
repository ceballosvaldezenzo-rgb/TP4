import java.util.ArrayList;

public class Carrera {

    //===ATRIBUTOS PRIVADOS===//

   private String carrera;
   private ArrayList<Estudiante>estudiantes;

   //===CONSTRUCTOR SIN PARAMETROS===//
    public Carrera(){
        this.estudiantes= new ArrayList<Estudiante>();
    }

    //===CONSTRUCTOR CON PARAMETROS===//
    public Carrera(String carrera){
        setCarrera(carrera);
        this.estudiantes=new ArrayList<Estudiante>();
    }

    //====GETTERS Y SETTERS===//

    //===GET Y SET NOMBRE===//

    public String getCarrera(){
        return carrera;
    }
    public void setCarrera(String carrera){
       if(!carrera.isBlank()){
           this.carrera=carrera;
           System.out.println("Se guardo con exito el nombre de la carrera");
       }else{
           System.out.println("Error no se puede guardar el nombre de la carrera");
       }
    }

    //===METODO PARA AGREGAR ESTUDIANTES===//
    public void agregarEstudiante(Estudiante estu){
        estudiantes.add(estu);
    }

    //===METODO PARA BUSCAR POR NOMBRE===//
    public void buscarporN(String nom){
        int i=1;
        for(Estudiante e:estudiantes){
            if(e.getNombre().equalsIgnoreCase(nom)){//compara si hay un alumno con el nombre que se solicita
                System.out.println("Informacion del estudiante "+(++i)+" con nombre "+nom+" :");
                System.out.println(e.toString());
                System.out.println("********************************");
            }
        }
    }

    //===MEODO PARA LISTAR ESTUDIANTES===//
   public void listarEstudiante(){
        int i=1;//contador para indice del estudainte
        for(Estudiante estus:estudiantes){
            System.out.println("Informacion del estudiante "+i+": ");
            System.out.println(estus.toString());
            System.out.println("=======================");
            i+=1;
        }
    }
}
