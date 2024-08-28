package co.edu.uniquindio.poo.model;

import java.util.Arrays;

public class Agenda {
    private Contacto[] listaContactos;
    private int numeroContactos;
    private Grupo[] listaGrupos;
    private int numeroGrupos;
    private Reunion[] listaReuniones;
    private int numeroReuniones;

    //Constructor
    public Agenda(int numeroContactos, int numeroGrupos, int numeroReuniones){
        this.numeroContactos =numeroContactos;
        this.numeroGrupos = numeroGrupos;
        this.numeroReuniones = numeroReuniones;
        this.listaContactos = new Contacto[numeroContactos];
        this.listaGrupos = new Grupo[numeroGrupos];
        this.listaReuniones = new Reunion[numeroReuniones];
    }

    /**
     * Métodos set y get
     * @return
     */
    public Contacto[] getListaContactos() {
        return listaContactos;
    }

    public void setListaContactos(Contacto[] listaContactos) {
        this.listaContactos = listaContactos;
    }

    public int getNumeroContactos() {
        return numeroContactos;
    }

    public void setNumeroContactos(int numeroContactos) {
        this.numeroContactos = numeroContactos;
    }

    public Grupo[] getListaGrupos() {
        return listaGrupos;
    }

    public void setListaGrupos(Grupo[] listaGrupos) {
        this.listaGrupos = listaGrupos;
    }

    public int getNumeroGrupos() {
        return numeroGrupos;
    }

    public void setNumeroGrupos(int numeroGrupos) {
        this.numeroGrupos = numeroGrupos;
    }

    public Reunion[] getListaReuniones() {
        return listaReuniones;
    }

    public void setListaReuniones(Reunion[] listaReuniones) {
        this.listaReuniones = listaReuniones;
    }

    public int getNumeroReuniones() {
        return numeroReuniones;
    }

    public void setNumeroReuniones(int numeroReuniones) {
        this.numeroReuniones = numeroReuniones;
    }

    /**
     * Método toString
     */
    @Override
    public String toString() {
        return "Agenda [listaContactos=" + Arrays.toString(listaContactos) + ", numeroContactos=" + numeroContactos
                + ", listaGrupos=" + Arrays.toString(listaGrupos) + ", numeroGrupos=" + numeroGrupos
                + ", listaReuniones=" + Arrays.toString(listaReuniones) + ", numeroReuniones=" + numeroReuniones + "]";
    }
    
    /**
     * Este método crea un contacto en la clase agenda, solo si hay espacio disponible para un nuevo contacto
     * @param nuevoContacto
     * @return
     */
    public String crearContacto(Contacto nuevoContacto){
        String mensaje = "";
        int posDisponible=0;
        Contacto contactoEncontrado = null;
        posDisponible = buscarPosDisponible();
        if(posDisponible == -1){
            mensaje ="no se pueden agregar mas contactos a la agenda";
        }else{
            contactoEncontrado = buscarContacto(nuevoContacto.getNombre());
            if (contactoEncontrado != null) {
                mensaje= "Este contacto ya está en la agenda";
            }else{ 
                listaContactos[posDisponible] = nuevoContacto;
                mensaje="Se agrego el contacto";
            }   
        }
        return mensaje;
    }

    /**
     * Este método es util para buscar un contacto especifico en la agenda
     * @param nombre
     * @return
     */
    private Contacto buscarContacto(String nombre) {
        Contacto contactoEncontrado = null;
        for (Contacto contactoAux : listaContactos) {
            if(contactoAux.getNombre().equals(nombre)){
                return contactoAux;
            }
        }
        return contactoEncontrado;
     }


     /**
      * Este método sirve para buscar si hay o no posición disponible para un nuevo contacto
      * @return
      */
    private int buscarPosDisponible() {
        int posDisponible = -1;
        boolean flag = false;
        for(int i = 0; i < listaContactos.length && flag == false;i++){
            Contacto contacto = listaContactos [i];
            if(contacto == null){
                posDisponible = i;
                flag = true;
            }
        }
        return posDisponible;


     }


    /**
     * Este método crea un grupo en la clase agenda, solo si hay espacio disponible para un nuevo grupo
     * @param nuevoGrupo
     * @return
     */
    public String crearGrupo(Grupo nuevoGrupo){
        String mensaje = "";
        int posDisponible=0;
        Grupo grupoEncontrado = null;
        posDisponible = buscarPosDisponibleG();
        if(posDisponible == -1){
            mensaje ="no se pueden agregar mas grupos";
        }else{
            grupoEncontrado = buscarGrupo(nuevoGrupo.getNombre());
            if (grupoEncontrado != null) {
                mensaje= "Este grupo ya existe ";
            }else{ 
                listaGrupos[posDisponible] = nuevoGrupo;
                mensaje="Se agrego el grupo ";
            }   
        }
        return mensaje;
    }

    /**
     * Este método es util para buscar un grupo especifico en la agenda
     * @param nombre
     * @return
     */
    private Grupo buscarGrupo(String nombre) {
        Grupo grupoEncontrado = null;
        for (Grupo grupoAux : listaGrupos) {
            if(grupoAux.getNombre().equals(nombre)){
                return grupoAux;
            }
        }
        return grupoEncontrado;
     }

    /**
     * Este método sirve para buscar si hay o no posición disponible para un nuevo grupo
     * @return
     */
    private int buscarPosDisponibleG() {
        int posDisponible = -1;
        boolean flag = false;
        for(int i = 0; i < listaGrupos.length && flag == false;i++){
            Grupo grupo = listaGrupos [i];
            if(grupo == null){
                posDisponible = i;
                flag = true;
            }
        }
        return posDisponible;
    }


    /**
     * Este método crea una reunion en la clase agenda, solo si hay espacio disponible para una nueva reunión
     * @param nuevaReunion
     * @return
     */
    public String crearReunion(Reunion nuevaReunion){
        String mensaje = "";
        int posDisponible=0;
        Reunion reunionEncontrada = null;
        posDisponible = buscarPosDisponibleR();
        if(posDisponible == -1){
            mensaje ="no se pueden agregar mas reuniones";
        }else{
            reunionEncontrada = buscarReunion(nuevaReunion.getDescripcion());
            if (reunionEncontrada != null) {
                mensaje= "Esta reunion ya existe ";
            }else{ 
                listaReuniones[posDisponible] = nuevaReunion;
                mensaje="Se agrego la reunion";
            }   
        }
        return mensaje;
    }

    /**
     * Este método es util para buscar una reunion en la agenda
     * @param descripcion
     * @return
     */
    private Reunion buscarReunion(String descripcion) {
        Reunion reunionEncontrada = null;
        for (Reunion reunionAux : listaReuniones) {
            if(reunionAux.getDescripcion().equals(descripcion)){
                return reunionAux;
            }
        }
        return reunionEncontrada;
     }

    /**
     * Este método sirve para buscar si hay o no posición disponible para una nueva reunión
     * @return
     */
    private int buscarPosDisponibleR() {
        int posDisponible = -1;
        boolean flag = false;
        for(int i = 0; i < listaReuniones.length && flag == false;i++){
            Reunion reunion = listaReuniones [i];
            if(reunion == null){
                posDisponible = i;
                flag = true;
            }
        }
        return posDisponible;
    }

}
