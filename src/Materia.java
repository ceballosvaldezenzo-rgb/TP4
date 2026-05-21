public class Materia {
    //****ATRIBUTOS DE CLASE****//
    private String nombre;
    private String codigo;
    private int creditos;
    private double calificacion;
    private Profesor profesor;

    //===CONSTRUCTOR VACIO===//

    public Materia(){
        this.profesor = null; // arranca sin profesor asignado
    }

    //----CONSTRUCTOR CON PARAMETROS---//

    public Materia(String nombre,String codigo,int creditos,double calificacion){
        setNombre(nombre);
        setCodigo(codigo);
        setCreditos(creditos);
        setCalificacion(calificacion);
        this.profesor = null; // arranca sin profesor asignado
    }

    //++++SETTERS Y GETTERS++++//

    //{{{GET Y SET NOMBRE}}}//
    public String getNombre(){
        return nombre;
    }

    public void setNombre(String nombre){
        if(!nombre.isBlank()){
            this.nombre = nombre;
        } else {
            System.out.println("Error: el nombre no puede estar vacío.");
        }
    }

    //$$$GET Y SET CODIGO$$$//
    public String getCodigo(){
        return codigo;
    }

    public void setCodigo(String codigo){
        if(!codigo.isBlank()){
            this.codigo = codigo;
        } else {
            System.out.println("Error: el codigo no puede estar vacío.");
        }
    }

    //###GET Y SET CREDITOS###//
    public int getCredito(){
        return creditos;
    }

    public void setCreditos(int credito){
        if(credito > 0){
            this.creditos = credito;
        } else {
            System.out.println("Error: los creditos deben ser mayor a 0.");
        }
    }

    //!!!GET Y SET DE CALIFICACION!!!//
    public double getCalificacion(){
        return calificacion;
    }
    public void setCalificacion(double calificacion){
        if(calificacion >= 0 && calificacion <= 10){
            this.calificacion = calificacion;
        } else {
            System.out.println("Error: la calificacion debe estar entre 0 y 10.");
        }
    }
    public Profesor getProfesor(){
        return profesor;
    }

    public void setProfesor(Profesor profesor){
        if(profesor != null){
            this.profesor = profesor;
            System.out.println("Profesor asignado correctamente.");
        } else {
            System.out.println("Error: el profesor no puede ser nulo.");
        }
    }

    //METODOS PARA MOSTRAR LAS MATERIAS//
    public void mostrarMates(){
        System.out.println("Materia: "+getNombre());
        System.out.println("Calificacion: "+getCalificacion());
        System.out.println("Codigo: "+getCodigo());
        System.out.println("Creditos: "+getCredito());
        System.out.println("=============================================\n=================================");
    }

    @Override
    public String toString(){
        String info = "Materia: " + getNombre() +
                "\nCodigo: " + getCodigo() +
                "\nCreditos: " + getCredito() +
                "\nCalificacion: " + getCalificacion();
        if(profesor != null){
            info += "\nProfesor: " + profesor.getNombre() + " " + profesor.getApellido();
        }
        return info;
    }

}
