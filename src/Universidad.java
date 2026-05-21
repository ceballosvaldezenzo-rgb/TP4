import java.util.ArrayList;

public class Universidad {
    //***ATRIBUTOS PRIVADOS***//
    private String nombre;
    private String direccion;
    private ArrayList<Estudiante> estudiante;
    private ArrayList<Carrera> carreras;
    private ArrayList<Profesor> profesores;
    private ArrayList<Personal1> personal;
    private indiceEstudiante indice;

    //***CONSTRUCTOR SIN PARAMETROS***//
    public Universidad() {
        this.estudiante = new ArrayList<Estudiante>();
        this.carreras = new ArrayList<Carrera>();
        this.profesores = new ArrayList<Profesor>();
        this.personal = new ArrayList<Personal1>();
        this.indice = new indiceEstudiante();
    }

    //***CONSTRUCTOR CON PARAMETROS***//
    public Universidad(String nombre, String direccion) {
        setNombre(nombre);
        setDireccion(direccion);
        this.estudiante = new ArrayList<Estudiante>();
        this.carreras = new ArrayList<Carrera>();
        this.profesores = new ArrayList<Profesor>();
        this.personal = new ArrayList<Personal1>();
        this.indice = new indiceEstudiante();
    }

    //***GETTERS Y SETTERS***//

    //***GET Y SETTER NOMBRE***//
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (!nombre.isBlank()) {
            this.nombre = nombre;
            System.out.println("El nombre de la facultad se guardo con exito");
        } else {
            System.out.println("Error no se puede cargar el nombre de la facultad");
        }
    }

    //***GET Y SETTER DIRECCION***//
    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        if (!direccion.isBlank()) {
            this.direccion = direccion;
            System.out.println("La direccion de la facultad se guardo con exito");
        } else {
            System.out.println("Error no se puede cargar la direccion de la facultad");
        }
    }

    //***GETTER Y SETTER DE CARRERAS***//
    public ArrayList<Carrera> getCarreras() {
        return carreras;
    }

    public void setCarrera(String carrera, Carrera ca) {
        for (Carrera c : carreras) {
            if (c.getCarrera().equalsIgnoreCase(carrera)) {
                System.out.println("No se inserto la carrera a la lista ya que ya existe");
                return;
            }
        }
        agregarCarrera(ca);//Si  no existe la carrera con ese nombre se le pasa la carrera para agregarse a la lista
        System.out.println("Se agrego la carrera a la lista de carreras de la facultad");
    }

    public void agregarCarrera(Carrera car) {
        carreras.add(car);
    }


    //***METODOS***//

    //***METODO PARA BUSCAR POR NOMBRE UN ALUMNO***//
    public void buscarPorNombre(String n) {
        for (Carrera carri : carreras) {
            carri.buscarporN(n);
        }
    }

    //***METODO PARA LISTAR ALUMNOS***//
    public void listarEstu(String carrera) {
        for (Carrera carri : carreras) {
            if (carri.getCarrera().equalsIgnoreCase(carrera)) {
                carri.listarEstudiante();
            }
        }
    }

    //***METODO PARA AGREGAR ESTUDIANTE***//
    public void agregarEstudiantes(Estudiante es) {
        for (Estudiante est : estudiante) {
            if (est.getDocumento().equalsIgnoreCase(es.getDocumento())) {
                System.out.println("Error el alumno que queres inscribir ya existe");
                return;
            }
        }
        for (Carrera car : carreras) {
            if (car.getCarrera().equalsIgnoreCase(es.getCarrera())) {
                car.agregarEstudiante(es);
            }
        }
        estudiante.add(es);
        indice.insertar(es.getDocumento(), es);
    }

    //***METODO PARA AGREGAR UNA MATERIA A UN ESTUDIANTE EN LA LISTA ESTUDIANTE***//
    public void agregarMateria(String n, String a, String c, Materia mate,String dni) {
        for (Estudiante estu : estudiante) {
            if ((estu.getNombre().equalsIgnoreCase(n)) && (estu.getApellido().equalsIgnoreCase(a)) && (estu.getCarrera().equalsIgnoreCase(c))&&(estu.getDocumento().equalsIgnoreCase(dni))) {
                estu.agregarMateria(mate);
                estu.actualizarPromedio();
            }
        }
    }

    //****METODO PARA MOSTRAR CARRERAS DE LA FACULTAD***//
    public void MostrarCarreras() {
        System.out.println("En la facultad " + getNombre() + " con direccion " + getDireccion() + " se ofrecen las siguientes ofertas academicas:");
        for (Carrera carre : carreras) {
            System.out.println(carre.getCarrera());
        }
        System.out.println("==========================");
    }

    //**METODO PARA AGREGAR PROFESOR**//
    public void agregarProfesor(Profesor prof) {
        for (Profesor p : profesores) {
            if (p.getDocumento().equalsIgnoreCase(prof.getDocumento())) {
                System.out.println("Error: ese profesor ya existe.");
                return;
            }
        }
        profesores.add(prof);
        System.out.println("Profesor agregado correctamente.");
    }

    //***METODO PARA AGREGAR PERSONAL**//
    public void agregarPersonal(Personal1 per) {
        for (Personal1 p : personal) {
            if (p.getDocumento().equalsIgnoreCase(per.getDocumento())) {
                System.out.println("Error: ese personal ya existe.");
                return;
            }
        }
        personal.add(per);
        System.out.println("Personal agregado correctamente.");
    }

    //**METODO PARA AGREGAR MATERIA A PROFESOR**//
    public void asignarMateriaProfesor(String documento, Materia materia) {
        for (Profesor p : profesores) {
            if (p.getDocumento().equalsIgnoreCase(documento)) {
                p.agregarM(materia);
                return;
            }
        }
        System.out.println("Error: no se encontró ningún profesor con ese documento.");
    }

    //**METODOS PARA LISTAR PERSONAL Y PROFESORES**//
    public void listarProfesores() {
        for (Profesor p : profesores) {
            System.out.println(p.toString());
            System.out.println("===========");
        }
    }

    public void listarPersonal() {
        for (Personal1 p : personal) {
            System.out.println(p.toString());
            System.out.println("===========");
        }
    }

    //***METODO PARA ORDENAR POR DNI A LOS ESTUDIANRES***//
    public void ordenarPorDni() {
        for (int i = 0; i < estudiante.size() - 1; i++) {
            for (int j = 0; j < estudiante.size() - i - 1; j++) {
                if (estudiante.get(j).getDocumento().compareTo(estudiante.get(j + 1).getDocumento()) > 0) {
                    Estudiante temp = estudiante.get(j);
                    estudiante.set(j, estudiante.get(j + 1));
                    estudiante.set(j + 1, temp);
                }
            }
        }
        System.out.println("Estudiantes ordenados por DNI.");
    }

    //***METODO PARA ORDENAR POR DNI A LOS PROFESORES***//
    public void ordenarPorDniprof() {
        for (int i = 0; i < profesores.size() - 1; i++) {
            for (int j = 0; j < profesores.size() - i - 1; j++) {
                if (profesores.get(j).getDocumento().compareTo(profesores.get(j + 1).getDocumento()) > 0) {
                    Profesor temp = profesores.get(j);
                    profesores.set(j, profesores.get(j + 1));
                    profesores.set(j + 1, temp);
                }
            }
        }
        System.out.println("Profesores ordenados por DNI.");
    }

    //***METODO PARA ORDENAR POR DNI AL PERSONAL***//
    public void ordenarPorDniper() {
        for (int i = 0; i < personal.size() - 1; i++) {
            for (int j = 0; j < personal.size() - i - 1; j++) {
                if (personal.get(j).getDocumento().compareTo(personal.get(j + 1).getDocumento()) > 0) {
                    Personal1 temp = personal.get(j);
                    personal.set(j, personal.get(j + 1));
                    personal.set(j + 1, temp);
                }
            }
        }
        System.out.println("Empleados de personal ordenados por DNI.");
    }

    //***METODO PARA BUSCAR ESTUDIANTE POR DNI
    public Estudiante buscarPorLegajo(String legajo) {
        Estudiante encontrado = indice.buscar(legajo);
        if (encontrado != null) {
            System.out.println(encontrado.toString());
        } else {
            System.out.println("No se encontró ningún estudiante con ese legajo.");
        }
        return encontrado;
    }
    public void Eliminar(String dni){
        indice.eliminaDni(dni);
    }

    public void tablaa(){
        indice.mostrarTabla();
    }
}

