public class Elemento {
    //***ATRIBUTOS**//

    private Estudiante es;//****TIENE UN ATRIBUTO QUE ALMACENA UN OBJETO TIPO ESTUDIANTE***//
    private Elemento sgte;//***TIENE UN PUNTERO AL SIGUIENTE NODO "es" QUE ES DE TIPO ESTUDIANTE***//
    private boolean esaob;
    //***CONSTRUCTOR**//

    public Elemento(Estudiante estu){
        this.es=estu;//**CUANDO SE RESERVA ESPACIO EN MEMORIA DE UN NUEVO OBJETO RIUPO ELEMENTO ALMACENA EL ESTUDIANTE QUE LE PASEMOS
        this.sgte=null;//***EMPEZARA APUNTANDO A NULL EL NUEVO ELEMENTO**//
        this.esaob=true;
    }

    //***GETER**//

    public Estudiante geteEstudiante(){
        return es;
    }

    public Elemento getSgte(){
        return sgte;
    }

    public void setSgte(Elemento siguiente){
        this.sgte = siguiente;//Lo hace apuntar al alemento que esta como cabeza de la lista
    }
    public void setnegaresaob(){
        this.esaob=false;
    }

    public boolean getEsaob(){
        return esaob;
    }

}
