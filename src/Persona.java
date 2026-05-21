public class Persona {//**CLASE MADRE***//

    //***Atributos de la clase madre***//
    private String nombre;
    private  String apellido;
    private int edad;
    private String documento;

    //**Constructor vacio de la clase madre**//
    public Persona(){

    }

    //**Constructor con parametros de la clase madre**//
    public Persona(String nombre,String apellido,int edad,String documento){
        setNombre(nombre);
        setApellido(apellido);
        setEdad(edad);
        setDni(documento);
    }

    //**Getters y Setters**//

    //**Gett y Sett nombre**//
    public String getNombre(){
        return nombre;
    }
    public void setNombre(String nombre){
        if(!nombre.isBlank()){
            this.nombre=nombre;
            System.out.println("Nombre guardado exitosamente");
        }else{
            System.out.println("Error no es posible guardarle el nombre ");
        }
    }

    //**Gett y Sett apellido**//
    public String getApellido(){
        return apellido;
    }
    public void setApellido(String apellido){
        if(!apellido.isBlank()){
            this.apellido=apellido;
            System.out.println("Apellido guardado exitosamente");
        }else{
            System.out.println("Error no es posible guardarle el apellido");
        }
    }

    //**Gett y Sett edad**//
    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        if (edad > 16) { // solo acepta mayores de 16
            this.edad = edad;
            System.out.println("Edad guardada exitosamente.");
        } else {
            System.out.println("Error: la edad debe ser mayor a 16.");
        }
    }

    //**Gett y Sett documento//
    public String getDocumento() {
        return documento;
    }

    public void setDni(String documento){
        if(!documento.isBlank() && documento.length() >= 7 && documento.length() <= 8 && soloNumeros(documento)){
            this.documento = documento;
            System.out.println("El documento se guardo correctamente");
        } else {
            System.out.println("Error documento invalido");
        }
    }

    public boolean soloNumeros(String n){
        for(int i = 0; i < n.length(); i++){
            if(!Character.isDigit(n.charAt(i))){ // si encuentra algo que NO es número
                return false;
            }
        }
        return true;

    }

    @Override
    public String toString(){
        return "Nombre: " + getNombre() + " " + getApellido() +
                "\nEdad: " + getEdad() +
                "\nDocumento: " + getDocumento();
    }

    @Override
    public boolean equals(Object obj){
        Persona otra = (Persona) obj; // convertís el Object a Persona
        return this.documento.equals(otra.documento); // comparás por documento
    }

    @Override
    public int hashCode(){
        return documento.hashCode(); // número único basado en el documento
    }



}
