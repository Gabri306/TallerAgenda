package co.edu.uniquindio.poo.application;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.swing.JOptionPane;

import co.edu.uniquindio.poo.model.Contacto;
import co.edu.uniquindio.poo.model.Grupo;
import co.edu.uniquindio.poo.model.Reunion;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        
        // Creación de objetos Contacto
        Contacto contacto1 = new Contacto("Carlos", "carlos1234", "carrera1234", "312456900", "carlos12ttr@gmail.com");
        Contacto contacto2 = new Contacto("David", "david1234", "carrera123", "312456912", "david12ttr@gmail.com");
        Contacto contacto3 = new Contacto("Juan", "juan1234", "carrera12", "312456921", "juan12ttr@gmail.com");
        Contacto contacto4 = new Contacto("Josue", "josue1234", "carrera1", "312456913", "josue12ttr@gmail.com");
        Contacto contacto5 = new Contacto("Saray", "andrea1234", "carrera", "312456931", "saray12ttr@gmail.com");

        JOptionPane.showMessageDialog(null, "El contacto " + contacto1.toString());
        JOptionPane.showMessageDialog(null, "El contacto " + contacto2.toString());
        JOptionPane.showMessageDialog(null, "El contacto " + contacto3.toString());
        JOptionPane.showMessageDialog(null, "El contacto " + contacto4.toString());
        JOptionPane.showMessageDialog(null, "El contacto " + contacto5.toString());

        // Creación de objetos grupo
        Grupo grupo1 = new Grupo("grupo1", 5);
        Grupo grupo2 = new Grupo("grupo1", 3);
        Grupo grupo3 = new Grupo("grupo1", 2);

        JOptionPane.showMessageDialog(null, "el grupo " + grupo1.toString());
        JOptionPane.showMessageDialog(null, "el grupo " + grupo2.toString());
        JOptionPane.showMessageDialog(null, "el grupo " + grupo3.toString());

        // Creación de objetos reunion
        Reunion reunion1 = new Reunion("Reunión de planificación", LocalDate.of(2024, 9, 15), LocalTime.of(10, 30),5);
        JOptionPane.showMessageDialog(null, "la reunion" + reunion1.toString());
    }
}