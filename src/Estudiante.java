import java.util.ArrayList;

public class Estudiante extends Persona {

    //====ATRIBUTOS PRIVADOS====//

    private String carrera;
    private double promedio;
    private ArrayList<Materia> materias; // lista de materias del estudiante

    //====CONSTRUCTOR SIN PARAMETROS====//
    // Crea un estudiante vacío con la lista de materias inicializada
    public Estudiante() {
        this.materias = new ArrayList<Materia>();
    }

    //====CONSTRUCTOR CON PARAMETROS====//
    // Crea un estudiante con todos sus datos, usando los setters para validar
    public Estudiante(String nombre, String apellido, int edad, String carrera, double promedio,String documento) {
        super(nombre,apellido,edad,documento);
        setCarrera(carrera);
        this.materias = new ArrayList<Materia>(); // la lista siempre arranca vacía
        // no seteamos promedio porque se calcula solo con calcularPromedio()
    }



    //---CARRERA---//
    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        if (!carrera.isBlank()) { // si NO está vacío, guarda
            this.carrera = carrera;
            System.out.println("Carrera guardada exitosamente.");
        } else {
            System.out.println("Error: la carrera no puede estar vacía.");
        }
    }

    //---PROMEDIO---//
    public double getPromedio() {
        return promedio;
    }

    // El promedio no tiene setter porque se calcula solo con calcularPromedio()

    //====METODOS====//

    // Agrega una materia a la lista del estudiante
    public void agregarMateria(Materia materia) {
        materias.add(materia);
        actualizarPromedio();
        System.out.println("Materia agregada exitosamente.");
    }

    //**ACTUALIZA PROMEDIO**//
    public void actualizarPromedio(){
        if(!materias.isEmpty()){
            this.promedio = calcularPromedio(0) / materias.size();
        }
    }

    // Recorre la lista de materias, suma las calificaciones y calcula el promedio
    public double calcularPromedio(int indice) {
        if (materias.isEmpty()) { // si no tiene materias evita dividir por cero
            return 0;
        }else{
         if(indice==materias.size()){
            return 0;
         }
          return materias.get(indice).getCalificacion()+calcularPromedio(indice+1);
        }
    }



    @Override
    public String toString(){
        String info = super.toString() +
                "\nCarrera: " + getCarrera() +
                "\nPromedio: " + promedio; // usá el atributo directamente
        if(!materias.isEmpty()){
            info += "\nMaterias: ";
            for(Materia m : materias){
                info += "\n  - " + m.getNombre();
            }
        }
        return info;
    }
}