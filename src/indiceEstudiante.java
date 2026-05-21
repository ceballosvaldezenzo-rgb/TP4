public class indiceEstudiante {
    //***ATRIBUTOS DE LA CLASE
    private Elemento[] tabla;
    private final int tamaño=29;
    private int cantidadInsertados;
    private double factordecarga;

    //***CONSTRUCTOR
    public indiceEstudiante(){
        this.tabla=new Elemento[tamaño];
        for(int i=0;i<tamaño;i++){
            tabla[i]=null;
        }
        this.cantidadInsertados=0;
        this.factordecarga=0.0;
    }

    //***METODOS

    //***METODO PARA CALCULAR EL VALOR DE EL DNI
    public long Transformarclave(String n){
        long d=0;
        for(int i=0;i<n.length();i++){
            d=d*10+((int)n.charAt(i)-'0');//funciona porque los dnis van de '0'que por ASCII es 48 y en adelante entonces hace por ejemplo 2-0 que seria 50-48 y eso si da 2
        }
        return d;//DEVUELVE LA CLAVE AMPLIFICADA
    }
    //***METODO DE LA DISPERCION***/
    public int Dispersion(long x){
        double t;
        int v;
        double r=0.6180;
        t = r * x - Math.floor(r * x);//Math.floor toma la parte entera y elimina la decimal aqui lo que hace es por ejem:12,8-12 dejando asi el 0,8
        v = (int) (tamaño * t); // M es la cantidad de posiciones de nuestra tabla aqui se hace por ejemplo:29*0,8=23,2 pero castea el entero entoces v va a valer 23

        return v;

    }

    //***METODO HASH
    private int hash(String legajo){
    long a=Transformarclave(legajo);
    int indice=Dispersion(a);
    if(indice<0){
        indice=indice*-1;
    }
    return indice;
    }

    //***METODO PARA INSERTAR
    public void insertar(String legajo,Estudiante es){
        this.factordecarga=(double)cantidadInsertados/tamaño;
        if(factordecarga>=0.75){
            System.out.println("Error la tabla hash ya esta llena");
            return;
        }
        int indice=hash(legajo);
        Elemento nuevo=new Elemento(es);
        nuevo.setSgte(tabla[indice]);
        tabla[indice]=nuevo;
    }

    //**METODO PARA BUSCAR POR DNI**//
    public Estudiante buscar(String legajo){
        int indice=hash(legajo);

        Estudiante estu;
        Elemento aux=tabla[indice];
        while(aux!=null){
            if(aux.geteEstudiante().getDocumento().equalsIgnoreCase(legajo)&&aux.getEsaob()==true){
                estu=tabla[indice].geteEstudiante();
                System.out.println("El estudiante con dni: "+legajo+" ha sido encontrado,su informacion es:");
               return estu;
            }
           aux=aux.getSgte();
        }
        System.out.println("Error no se encontro el estudiante,por ende el dni que ingreso no corresponde a un alumno de la facultad");
        return null;
    }

    //****METODO PARA VER TODOS LOS ALUMNOS DE LA TABLA***//
    public void mostrarTabla(){
        int i=0;
        int j=0;
        Elemento aux;
        for(i=0;i<this.tamaño;i++){
                aux = tabla[i];
                while (aux != null) {
                  if(aux.getEsaob()==true) {
                      System.out.println("El alumno en la posicion " + i + " " + j + " tiene la siguiente informacion:");
                      System.out.println(aux.geteEstudiante().toString());
                  }
                    aux = aux.getSgte();
                }
            }
        }



    //***METODO PARA ELIMINAR POR DNI***//
    public void eliminaDni(String dni){
        Elemento aux;

        int indice=hash(dni);
        aux=tabla[indice];
       while(aux!=null){
           if(aux.geteEstudiante().getDocumento().equalsIgnoreCase(dni)&&aux.getEsaob()==true){
               aux.setnegaresaob();
               System.out.println("El alumno con ifnformacion: "+aux.geteEstudiante().toString()+"\n FUE ELIMINADO CON EXITO");
               return;
           }
           aux = aux.getSgte();
       }
       System.out.println("Error no se ah encontrado el alumno con ese dni");


    }
   /* //***METODO PARA LA EXPLORACION
    private int exploracion(int o,int p){
        int funcion=(o+(p*p))%tamaño;
        return funcion;
    }
    */

    /*//***METODO PARA BUSCAR
    public Estudiante buscar(String legajo){
       int o=0;//+++pasos para la exploracion
        int r=hash(legajo);//++++calcula la posicion segun el dni;

        while(tabla[r]!=null){
            if(tabla[r].getDocumento().equalsIgnoreCase(legajo)){
                return tabla[r];
            }
            o+=1;
            r=exploracion(r,o);
        }
        return null;
    }
*/


}
