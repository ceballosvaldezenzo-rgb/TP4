import java.util.ArrayList;

public class Personal1 extends Persona{
        //***ATRIBUTOS DE PERSONAL***//
        private String departamento;
        private String puesto;
        private String fechaIngreso;

        // constructores, getters, setters y toString()
        //***Constructor sin parametros**//
        public Personal1(){
        }

    //***Constructor con parametros***//
    public Personal1(String nombre,String apellido,int edad,String documento,String departamento,String puesto,String fechaIngreso){
        super(nombre,apellido,edad,documento);
        setDepartamento(departamento);
        setPuesto(puesto);
        setFecha(fechaIngreso);

    }

    //***Getters y Setters***//

    //**Departamento**//
    public String getDepartamento(){
        return departamento;
    }

    public void setDepartamento(String departamento){
        if(!departamento.isBlank()){
            this.departamento=departamento;
        }
    }

    //**Puesto**//
    public String getPuesto(){
        return puesto;
    }

    public void setPuesto(String puesto){
        if(!puesto.isBlank()){
            this.puesto=puesto;
        }
    }

    //**Fecha ingreso**//
    public String getFecha(){
        return fechaIngreso;
    }

    public void setFecha(String fechaIngreso){
        if(!fechaIngreso.isBlank()){
            this.fechaIngreso=fechaIngreso;
        }
    }

    //***Metodos**//
    @Override
    public String toString(){

        String info=super.toString()+
                "\nDepartamento: "+getDepartamento()+
                "\nFecha de ingreso: "+getFecha()+
                "\nPuesto: "+getPuesto();
        return info;
    }

}
