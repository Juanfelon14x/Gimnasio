package co.edu.uniquindio.poo;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
public class Gimnasio {
    private String nombre;
    private LocalDate fechaInscripcion;
    private LinkedList<Miembro> miembros;
    private LinkedList<Entrenador> entrenadores;

    public Gimnasio(String nombre) {
        this.nombre = nombre;
        miembros = new LinkedList<>();
        entrenadores = new LinkedList<>();
    }

    public void agregarMiembro(Miembro miembro) {
        if (!verificarMiembro(miembro.getCedula())) {
            miembros.add(miembro);
        }
    }

    public boolean verificarMiembro(String cedula) {
        boolean centinela = false;
        for (Miembro miembro : miembros) {
            if (miembro.getCedula().equals(cedula)) {
                centinela = true;
            }
        }
        return centinela;
    }

    public void agregarEntrenador(Entrenador entrenador) {
        if (!verificarEntrenador(entrenador.getCorreo())) {
            entrenadores.add(entrenador);
        }
    }

    public boolean verificarEntrenador(String correo) {
        boolean centinela = false;
        for (Entrenador entrenador : entrenadores) {
            if (entrenador.getCorreo().equals(correo)) {
                centinela = true;
            }
        }
        return centinela;
    }

    public void eliminarMiembro(String cedula) {
        for (Miembro miembro : miembros) {
            if (miembro.getCedula().equals(cedula)) {
                miembros.remove(miembro);
                break;
            }
        }
    }

    public void eliminarEntrenador(String correo) {
        for (Entrenador entrenador : entrenadores) {
            if (entrenador.getCorreo().equals(correo)) {
                entrenadores.remove(entrenador);
                break;
            }
        }
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    // --------------------------------------------------------------
    // Pilas metodos nuevos del taller

    /**
     * Metodo que muestra los nombres de los miembros de la lista en orden inverso
     */
    public void listaNombresInverso() {
        for (int i = miembros.size() - 1; i >= 0; i--) {
            Miembro miembro = miembros.get(i);
            mostrarMensaje(miembro.getNombre());
        }
    }

    /**
     * Metodo que crea una lista de miembros que son menores de 18 años.
     * 
     * @return Una lista de objetos cuya edad es menor de 18 años.
     */
    public LinkedList<Miembro> miembrosMenoresEdad() {
        LinkedList<Miembro> menores = new LinkedList<>();
        for (Miembro miembro : miembros) {
            if (miembro.getEdad() < 18) {
                menores.add(miembro);
            }
        }
        return menores;
    }
    // --------------------------------------------------------------



    // --------------------Completar los metodos---------------------

    /*
     - calcularPromedioEdad()
     - modaEdades()
     - elimiarNombreVocales()
     - determiarVocal()
     */

    // --------------------Completar---------------------------------

    public double calcularPromedioEdad(){
        double promedio = 0;
        int edades = 0;
        for(Miembro miembro : miembros){
            edades = edades + miembro.getEdad();
        }
        promedio = edades / miembros.size();
        return promedio;
    }

    public int modaEdades(){
        List<Integer> edades = new ArrayList<>();
        for(Miembro miembro : miembros){
            edades.add(miembro.getEdad());
        }
        int frecuenciamax = 0;
        int moda = 0;
        for(int i = 0; i < edades.size(); i++){
            int frecuenciaactual = 0;
            for(int j = 0; j < edades.size(); j++){
                if(edades.get(i) == edades.get(j)){
                    frecuenciaactual++;
                }
            }
            if (frecuenciaactual > frecuenciamax) {
                frecuenciamax = frecuenciaactual;
                moda = edades.get(i);
            }
        }
        return moda;
    }
        
    public List<Character> determinarVocal(Miembro miembro){
        String vocales = "aeiouAEIOU";
        List<Character> vocalesdenombre = new ArrayList<>();
        for(char letra : miembro.getNombre().toCharArray()){
            for (char vocal : vocales.toCharArray()) {
                if (letra == vocal) {
                    vocalesdenombre.add(letra);
                }
            }
        }
        return vocalesdenombre;
    }
    public String getNombre() {
        return nombre;
    }

    public String elimiarNombreVocales(){
        StringBuilder mensaje = new StringBuilder();
        Iterator<Miembro> iterator = miembros.iterator(); // Usar un iterador

        while (iterator.hasNext()) {
            Miembro miembro = iterator.next();
            if (determinarVocal(miembro).size() > 3) {
                iterator.remove(); // Eliminar de forma segura
                mensaje.append(miembro.getNombre()).append(", ");
            }
        }

        return mensaje.toString();
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFechaInscripcion() {
        return fechaInscripcion;
    }

    public void setFechaInscripcion(LocalDate fechaInscripcion) {
        this.fechaInscripcion = fechaInscripcion;
    }

    public LinkedList<Miembro> getMiembros() {
        return miembros;
    }

    public void setMiembros(LinkedList<Miembro> miembros) {
        this.miembros = miembros;
    }

    public LinkedList<Entrenador> getEntrenadores() {
        return entrenadores;
    }

    public void setEntrenadores(LinkedList<Entrenador> entrenadores) {
        this.entrenadores = entrenadores;
    }

    @Override
    public String toString() {
        return "Gimnasio [nombre=" + nombre + ", fechaInscripcion=" + fechaInscripcion + ", miembros=" + miembros
                + ", entrenadores=" + entrenadores + "]";
    }
    public static void main(String[] args) {

    Gimnasio SmartLife = new Gimnasio("SmartLife");

    for(int i = 1; i < 10; i++){
        Miembro miembroi = new Miembro("Miembro" + i, 16 + i, "" + i, "23523" + i, Membresia.ANUAL);
        System.out.println(miembroi);
        SmartLife.agregarMiembro(miembroi);
    }
    Miembro miembro12 = new Miembro("Miembro", 25 ,"Masculino", "235256", Membresia.ANUAL);
        System.out.println(miembro12);
        SmartLife.agregarMiembro(miembro12);
    
    Entrenador entrenador1 = new Entrenador("Felipe", "Coach de hipertrofia",
    "54565456", "pipelon444@gmail.com");



    System.out.println(SmartLife.modaEdades());
    System.out.println(SmartLife.calcularPromedioEdad());
    System.out.println(SmartLife.elimiarNombreVocales());
    }
}