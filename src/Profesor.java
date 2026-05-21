import java.util.ArrayList;

public class Profesor extends Persona{
    //***ATRIBUTOS PROPIOS DE PROFESOR**//
   private String especialidad;
    private int aniosExperiencia;
    private ArrayList<Materia> materiasAsignadas;

    //***Constructor sin parametros**//
    public Profesor(){
        this.materiasAsignadas=new ArrayList<Materia>();
    }

    //***Constructor con parametros***//
    public Profesor(String nombre,String apellido,int edad,String documento,String especialidad,int aniosExperiencia){
        super(nombre,apellido,edad,documento);
        setEspecialidad(especialidad);
        setAnios(aniosExperiencia);
        this.materiasAsignadas=new ArrayList<Materia>();
    }

    //***Getters y Setters***//

    //**Especialidad**//
    public String getEspecialidad(){
        return especialidad;
    }

    public void setEspecialidad(String especialidad){
        if(!especialidad.isBlank()){
            this.especialidad=especialidad;
        }
    }

    //**Años experiencia**//
    public int getAnios(){
        return aniosExperiencia;
    }

    public void setAnios(int aniosExperiencia){
        if(aniosExperiencia>-1){
            this.aniosExperiencia=aniosExperiencia;
        }
    }

    //***Metodos**//
    @Override
    public String toString(){

        String info=super.toString()+
        "\nEspecialidad: "+getEspecialidad()+
        "\nAños de experiencia: "+getAnios();
         if(!materiasAsignadas.isEmpty()){
             info+="\nMaterias a cargo: ";
             for(Materia m:materiasAsignadas){
                 info+="\n - "+m.getNombre();
             }
         }
         return info;
    }

    //***Asignar materia**//
    public void agregarM(Materia mat){
        materiasAsignadas.add(mat);
        System.out.println("Materia asignada al profesor correctamente.");
    }
}
