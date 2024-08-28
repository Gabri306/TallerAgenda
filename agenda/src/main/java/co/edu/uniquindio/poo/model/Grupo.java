package co.edu.uniquindio.poo.model;

import java.util.Arrays;

public class Grupo {
    private String nombre;
    private Contacto[] listaContactos;
    private int numeroContactos;

    //Constructor
    public Grupo(String nombre, int numeroContactos){
        this.nombre = nombre;
        this.numeroContactos = numeroContactos;
        this.listaContactos = new Contacto[numeroContactos];
    }

    /**
     * Métodos set y get
     * @return
     */
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Contacto[] getListaContacto() {
        return listaContactos;
    }

    public void setListaContacto(Contacto[] listaContactos) {
        this.listaContactos = listaContactos;
    }

    public int getNumeroContactos() {
        return numeroContactos;
    }

    public void setNumeroContactos(int numeroContactos) {
        this.numeroContactos = numeroContactos;
    }

    /**
     * Método toString
     */
    @Override
    public String toString() {
        return "Grupo [nombre=" + nombre + ", listaContacto=" + Arrays.toString(listaContactos) + ", numeroContactos="
                + numeroContactos + "]";
    }


    /**
     * Este método crea un contacto en la clase grupo, solo si hay espacio disponible para un nuevo contacto
     * @param nuevoContacto
     * @return
     */
    public String crearContacto(Contacto nuevoContacto){
        String mensaje = "";
        int posDisponible=0;
        Contacto contactoEncontrado = null;
        posDisponible = buscarPosDisponible();
        if(posDisponible == -1){
            mensaje ="no se pueden agregar mas contactos al grupo";
        }else{
            contactoEncontrado = buscarContacto(nuevoContacto.getNombre());
            if (contactoEncontrado != null) {
                mensaje= "Este contacto ya está en el grupo";
            }else{ 
                listaContactos[posDisponible] = nuevoContacto;
                mensaje="Se agrego el contacto";
            }   
        }
        return mensaje;
    }


    /**
     * Este método es util para buscar un contacto especifico en el grupo
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


}