import java.util.ArrayList;
import java.util.Scanner;
public class APP{
public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);

    // INTRODUCCION - datos de la universidad
    System.out.println("=== BIENVENIDO AL SISTEMA DE GESTION ACADEMICA ===");
    System.out.println("Ingrese el nombre de la universidad: ");
    String nombre = scanner.nextLine();
    System.out.println("Ingrese la direccion de la universidad: ");
    String direccion = scanner.nextLine();

    // Creo el objeto universidad con esos datos
    Universidad uni = new Universidad(nombre, direccion);

    //Creo variables auxiliares
    String nombreEstudiante;
    String apellidoEstudiante;
    int edadEstudiante;
    String documentoEstudiante;

    String nombreCarrera;

    String nombreMateria;
    String codigoMateria;
    int creditosMateria;
    double notaMateria;

    String nombreP;
    String apellidoP;
     int edadP;
    String documentoP;
    String especialidadP;
    int añosexP;
     String departamentoPersonal;
     String puestoPersonal;
     String fechaIngresoPersonal;

    ArrayList<String> carres=new ArrayList<String>();
    //Creo la variable para las opciones del menu e inicializo en un valor falso
    int op=0;

    //Creo una bandera para poder mostrar profesores y personal
    int bandepro=0;
    int bandeper=0;

    // El menú viene después...
    System.out.println("Segun lo que desee realizar elija una opcion");
    do{

        //Se despliega el menu
        System.out.println("1-Agregar carrera a la facultad");
        System.out.println("2-Agregar estudiante");
        System.out.println("3-Cargar una materia a un estudiante");
        System.out.println("4-Mostrar carreras de la facultad");
        System.out.println("5-Listar alumnos segun la carrera");
        System.out.println("6-Mostrar alumno por nombre");
        System.out.println("7-Agregar un profesor");
        System.out.println("8-Ver profesores en la faacltad");
        System.out.println("9-Agregar materias a profesores");
        System.out.println("10-Agregar un empleado de personal");
        System.out.println("11-Listar los empleados de personal de la facultad");
        System.out.println("12-Para buscar un estudiante por dni");
        System.out.println("13-para mostrar la tabla hash");
        System.out.println("14-Eliminar por dni un estudiante");
        System.out.println("15-Salir");
        op=scanner.nextInt();

        while(op<1||op>15){//Si el ususario se equivoca de opcion se le vuelve a pedir una hasta que sea correcta
            System.out.println("1-Agregar carrera a la facultad");
            System.out.println("2-Agregar estudiante");
            System.out.println("3-Cargar una materia a un estudiante");
            System.out.println("4-Mostrar carreras de la facultad");
            System.out.println("5-Listar alumnos segun la carrera");
            System.out.println("6-Mostrar alumno por nombre");
            System.out.println("7-Agregar un profesor");
            System.out.println("8-Ver profesores en la faacltad");
            System.out.println("9-Agregar materias a profesores");
            System.out.println("10-Agregar un empleado de personal");
            System.out.println("11-Listar los empleados de personal de la facultad");
            System.out.println("12-Para buscar un estudiante por dni");
            System.out.println("13-para mostrar la tabla hash");
            System.out.println("14-Eliminar por dni un estudiante");
            System.out.println("15-Salir");
            op=scanner.nextInt();
        }
        scanner.nextLine();//Sirve para limpiar el buffer
        switch(op){
            case 1:
                   System.out.println("Ingrese el nombre de la carrera:");
                   nombreCarrera=scanner.nextLine();
                   while(carres.contains(nombreCarrera)){
                       System.out.println("Error esa carrera ya esta en la faculdad,registre una carrera diferente");
                       nombreCarrera=scanner.nextLine();
                   }
                   carres.add(nombreCarrera);

                   Carrera nuevaCarre=new Carrera(nombreCarrera);
                   uni.agregarCarrera(nuevaCarre);
                break;

            case 2:
                if(!carres.isEmpty()) {
                    System.out.println("Acontinuacion se mostraran las carreras disponibles para insribir a un estudiante");
                    uni.MostrarCarreras();
                    nombreCarrera= scanner.nextLine();
                    while(!carres.contains(nombreCarrera)){
                        System.out.println("Error seleccione una carrera existente disponible");
                        nombreCarrera=scanner.nextLine();
                    }

                    //Pido el nombre del estudiante
                    System.out.println("Ingrese el nombre del estudiante:");
                    nombreEstudiante=scanner.nextLine();
                    while(nombreEstudiante.isBlank()||nombreEstudiante.length()<2){
                        System.out.println("Error escriba un numbre valido");
                        nombreEstudiante=scanner.nextLine();
                    }

                    //Pido el apellido del estudiante
                    System.out.println("Ingrese el apellido del estudiante:");
                    apellidoEstudiante=scanner.nextLine();
                    while(apellidoEstudiante.isBlank()||apellidoEstudiante.length()<2){
                        System.out.println("Error escriba un nombre valido");
                        apellidoEstudiante=scanner.nextLine();
                    }

                    //Pido la edad del estudiante
                    System.out.println("Ingrese la edad del estudiante:");
                    edadEstudiante=scanner.nextInt();
                    while(edadEstudiante<16){
                        System.out.println("Error ingrese su edad verdadera menores de 16 no pueden cursar");
                        edadEstudiante=scanner.nextInt();
                    }
                    scanner.nextLine();

                    //Pido documento del estudiante
                    System.out.println("Ingrese el documento del estudiante");
                    documentoEstudiante=scanner.nextLine();
                    while(documentoEstudiante.length()<7||documentoEstudiante.length()>8||documentoEstudiante.isBlank()){
                        System.out.println("Error ingrese un dni valido");
                        System.out.println("Ingrese el documento del estudiante");
                        documentoEstudiante=scanner.nextLine();
                    }
                    //Creo un objeto tipo estudiante y lo agrego a la lista de estudiantes de uni
                    Estudiante estudianteNuevo=new Estudiante(nombreEstudiante,apellidoEstudiante,edadEstudiante,nombreCarrera,0,documentoEstudiante);
                    uni.agregarEstudiantes(estudianteNuevo);
                    uni.ordenarPorDni();

                }else{
                    System.out.println("Error pruebe cargar al menos una carrera en el sistema");
                }
                break;
            case 3:
                if(!carres.isEmpty()) {
                    uni.MostrarCarreras();

                    // Pido a qué estudiante le querés agregar la materia

                    //Pido el nombre
                    System.out.println("Ingrese nombre del estudiante: ");
                    nombreEstudiante = scanner.nextLine();
                    while (nombreEstudiante.isBlank() || nombreEstudiante.length() < 2) {
                        System.out.println("Error escriba un numbre valido");
                        nombreEstudiante = scanner.nextLine();
                    }

                    //Pido el apellido
                    System.out.println("Ingrese apellido del estudiante: ");
                    apellidoEstudiante = scanner.nextLine();
                    while (apellidoEstudiante.isBlank() || apellidoEstudiante.length() < 2) {
                        System.out.println("Error escriba un nombre valido");
                        apellidoEstudiante = scanner.nextLine();
                    }

                    //Pido la cerrera
                    System.out.println("Ingrese carrera del estudiante: ");
                    nombreCarrera = scanner.nextLine();
                    while (!carres.contains(nombreCarrera)) {
                        System.out.println("Error seleccione una carrera existente disponible");
                        nombreCarrera = scanner.nextLine();
                    }

                    //Pido el dni
                    System.out.println("Ingrese el documento del estudiante que desea visualizar");
                    documentoEstudiante=scanner.nextLine();
                    while(documentoEstudiante.length()<7||documentoEstudiante.length()>8||documentoEstudiante.isBlank()){
                        System.out.println("Error ingrese un dni valido");
                        System.out.println("Ingrese el documento del estudiante");
                        documentoEstudiante=scanner.nextLine();
                    }
                    // Pido los datos de la materia
                    //Pido el nombre
                    System.out.println("Ingrese nombre de la materia: ");
                    nombreMateria = scanner.nextLine();
                    while (nombreMateria.isBlank()) {
                        System.out.println("Error ingrese un nombre de materia valido");
                        nombreMateria = scanner.nextLine();
                    }

                    //Pido el codigo
                    System.out.println("Ingrese codigo de la materia: ");
                    codigoMateria = scanner.nextLine();
                    while (codigoMateria.isBlank()) {
                        System.out.println("Error ingrese un codigo de materia valido");
                        codigoMateria = scanner.nextLine();
                    }

                    //Pido creditos
                    System.out.println("Ingrese creditos de la materia: ");
                    creditosMateria = scanner.nextInt();
                    while (creditosMateria < 0) {
                        System.out.println("Error ingrese creditos de materia valido");
                        creditosMateria = scanner.nextInt();
                    }
                    scanner.nextLine();

                    //Pido la nota
                    System.out.println("Ingrese nota de la materia: ");
                    notaMateria = scanner.nextDouble();
                    while (notaMateria < 0 || notaMateria > 10) {
                        System.out.println("Error ingrese nota de materia valido");
                        notaMateria = scanner.nextDouble();
                    }
                    scanner.nextLine();

                    // Creo el objeto materia
                    Materia nuevaMateria = new Materia(nombreMateria, codigoMateria, creditosMateria, notaMateria);

                    // Se la agrego al estudiante a través de universidad
                    uni.agregarMateria(nombreEstudiante, apellidoEstudiante, nombreCarrera, nuevaMateria,documentoEstudiante);
                }else{
                    System.out.println("Error ingrese una carrera al menos");
                }
                break;
            case 4:
                if(!carres.isEmpty()){
                    uni.MostrarCarreras();
                }else{
                    System.out.println("Error no hay carreras cargadas para mostrar");
                }
                break;
            case 5:
                if(!carres.isEmpty()){
                    System.out.println("Elija que carrera desea ver su listado");
                    uni.MostrarCarreras();
                    nombreCarrera=scanner.nextLine();
                    while(!carres.contains(nombreCarrera)){
                        System.out.println("Error no ha ingresado una carrera valida porfavor intente de vuelta");
                        uni.MostrarCarreras();
                        nombreCarrera=scanner.nextLine();
                    }
                    uni.listarEstu(nombreCarrera);
                }else{
                    System.out.println("Error no hay carreras cargadas para mostrar sus respectivos estudiantes");
                }
                break;
            case 6:
                //Pido el nombre del estudiante
                System.out.println("Ingrese el nombre de/l el/los estudiante/es que desea listar");
                nombreEstudiante=scanner.nextLine();
                while(nombreEstudiante.isBlank()){
                    System.out.println("Error ingrese un nombre valido");
                    nombreEstudiante=scanner.nextLine();
                }
                uni.buscarPorNombre(nombreEstudiante);
                break;
            case 7:
                //Ingreso nombre
                System.out.println("Ingrese el nombre del profesor: ");
                nombreP= scanner.nextLine();
                while(nombreP.isBlank()){
                    System.out.println("Error ingrese un nombre valido");
                    nombreP=scanner.nextLine();
                }

                //Ingreso apellido
                System.out.println("Ingrese el apellido del profesor: ");
                apellidoP= scanner.nextLine();
                while(apellidoP.isBlank()){
                    System.out.println("Error ingrese un apellido valido");
                    apellidoP=scanner.nextLine();
                }

                //Ingreso edad
                System.out.println("Ingrese la edad del profesor: ");
                edadP= scanner.nextInt();
                while(edadP<22){
                    System.out.println("Error ingrese una edad  valida");
                    edadP=scanner.nextInt();
                }
                scanner.nextLine();
                //ingreso documento
                System.out.println("Ingrese el documento del profesor: ");
                documentoP= scanner.nextLine();
                while(documentoP.isBlank()||documentoP.length()<7||documentoP.length()>8){
                    System.out.println("Error ingrese un documento valido");
                    documentoP=scanner.nextLine();
                }
                //ingreso años de experiencia
                System.out.println("Ingrese años de experiencia del profesor: ");
                añosexP=scanner.nextInt();
                while(añosexP<0){
                    System.out.println("Error ingrese años de experiencia validos");
                    añosexP=scanner.nextInt();
                }
                scanner.nextLine();
                //ingreso especialidad
                System.out.println("Ingrese especialidad del profesor: ");
                especialidadP= scanner.nextLine();
                while(especialidadP.isBlank()){
                    System.out.println("Error ingrese una especialidad valida");
                    especialidadP=scanner.nextLine();
                }
                bandepro=1;
                Profesor profeNuevo=new Profesor(nombreP,apellidoP,edadP,documentoP,especialidadP,añosexP);
                uni.agregarProfesor(profeNuevo);
                uni.ordenarPorDniprof();
                break;
            case 8:
                if(bandepro==0){
                  System.out.println("Error no hay profesores cargados para mostrar");
            }else{
                    uni.listarProfesores();
                }
                break;
            case 9:
                if(bandepro==0){
                    System.out.println("Error no hay profesores para ingresar materias");
                }else{
                    System.out.println("Ingrese el documento del profesor");
                    documentoP=scanner.nextLine();
                    while(documentoP.isBlank()||documentoP.length()<7||documentoP.length()>8){
                        System.out.println("Error ingrese un dni valido");
                        documentoP=scanner.nextLine();
                    }
                    System.out.println("Ingrese el nombre de la materia");
                    nombreMateria=scanner.nextLine();
                    while(nombreMateria.isBlank()){
                        System.out.println("Error ingrese un nombre valido");
                        nombreMateria=scanner.nextLine();
                    }
                    System.out.println("Ingrese el codigo de la materia");
                    codigoMateria=scanner.nextLine();
                    while(codigoMateria.isBlank()){
                        System.out.println("Error ingrese un nombre valido");
                        codigoMateria=scanner.nextLine();
                    }
                    System.out.println("Ingrese los creditos de la materia");
                    creditosMateria=scanner.nextInt();
                    while(creditosMateria<0){
                        System.out.println("Error ingrese creditos validos");
                        creditosMateria=scanner.nextInt();
                    }
                    Materia mat=new Materia(nombreMateria,codigoMateria,creditosMateria,0);
                    uni.asignarMateriaProfesor(documentoP,mat);

                }
                break;
            case 10:
                //Ingreso nombre
                System.out.println("Ingrese el nombre del empleado: ");
                nombreP= scanner.nextLine();
                while(nombreP.isBlank()){
                    System.out.println("Error ingrese un nombre valido");
                    nombreP=scanner.nextLine();
                }

                //Ingreso apellido
                System.out.println("Ingrese el apellido del empleado: ");
                apellidoP= scanner.nextLine();
                while(apellidoP.isBlank()){
                    System.out.println("Error ingrese un apellido valido");
                    apellidoP=scanner.nextLine();
                }

                //Ingreso edad
                System.out.println("Ingrese la edad del empleado: ");
                edadP= scanner.nextInt();
                while(edadP<22){
                    System.out.println("Error ingrese una edad  valida");
                    edadP=scanner.nextInt();
                }
                scanner.nextLine();
                //ingreso documento
                System.out.println("Ingrese el documento del empleado: ");
                documentoP= scanner.nextLine();
                while(documentoP.isBlank()||documentoP.length()<0||documentoP.length()>8){
                    System.out.println("Error ingrese un documento valido");
                    documentoP=scanner.nextLine();
                }
                //ingreso años de experiencia
                System.out.println("Ingrese departamento del empleado: ");
                departamentoPersonal=scanner.nextLine();
                while(departamentoPersonal.isBlank()){
                    System.out.println("Error ingrese departamento valido");
                    departamentoPersonal=scanner.nextLine();
                }
                //ingreso especialidad
                System.out.println("Ingrese el puesto del empleado: ");
                especialidadP= scanner.nextLine();
                while(especialidadP.isBlank()){
                    System.out.println("Error ingrese un puesto valido");
                    especialidadP=scanner.nextLine();
                }

                System.out.println("Ingrese la fecha de ingreso del empleado: ");
                fechaIngresoPersonal= scanner.nextLine();
                while(fechaIngresoPersonal.isBlank()){
                    System.out.println("Error ingrese una fecha valida");
                    fechaIngresoPersonal=scanner.nextLine();
                }
                bandeper=1;
                Personal1 empleadoNuevo=new Personal1(nombreP,apellidoP,edadP,documentoP,especialidadP,departamentoPersonal,fechaIngresoPersonal);
                uni.agregarPersonal(empleadoNuevo);
                uni.ordenarPorDniper();
                break;
            case 11:
                if(bandeper==0){
                    System.out.println("Error no hay personal cargado para mostrar");
                }else{
                    uni.listarPersonal();
                }
                break;
            case 12:
                 System.out.println("Ingrese el documento del estudiante que desea visualizar");
                 documentoEstudiante=scanner.nextLine();
                while(documentoEstudiante.length()<7||documentoEstudiante.length()>8||documentoEstudiante.isBlank()){
                    System.out.println("Error ingrese un dni valido");
                    System.out.println("Ingrese el documento del estudiante");
                    documentoEstudiante=scanner.nextLine();
                }
                uni.buscarPorLegajo(documentoEstudiante);
                break;
            case 13:
                uni.tablaa();
                break;
            case 14:
                System.out.println("Ingrese el documento del estudiante que desea visualizar");
                documentoEstudiante=scanner.nextLine();
                while(documentoEstudiante.length()<7||documentoEstudiante.length()>8||documentoEstudiante.isBlank()){
                    System.out.println("Error ingrese un dni valido");
                    System.out.println("Ingrese el documento del estudiante");
                    documentoEstudiante=scanner.nextLine();
                }
                uni.Eliminar(documentoEstudiante);
                break;
            case 15:
                System.out.println("Gracias por haber usado el programa");
                break;
        }
    }while(op!=15);
    scanner.close();
}
}
